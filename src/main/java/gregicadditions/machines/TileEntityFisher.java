package gregicadditions.machines;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.gui.widgets.ToggleButtonWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.api.render.Textures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;
import java.util.Random;

public class TileEntityFisher extends TieredMetaTileEntity {

    private EnumFacing outputFacing;
    private boolean autoOutputItems;


    public TileEntityFisher(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new TileEntityFisher(metaTileEntityId, getTier());
    }

    @Override
    public boolean onWrenchClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if (!playerIn.isSneaking()) {
            EnumFacing currentOutputSide = getOutputFacing();
            if (currentOutputSide == facing ||
                    getFrontFacing() == facing) return false;
            setOutputFacing(facing);
            return true;
        }
        return super.onWrenchClick(playerIn, hand, facing, hitResult);
    }

    @Override
    protected IItemHandlerModifiable createExportItemHandler() {
        return new ItemStackHandler(4);
    }

    @Override
    public void update() {
        super.update();
        if (!getWorld().isRemote) {
            Random rand = new Random();
            LootContext.Builder lootcontext$builder = new LootContext.Builder((WorldServer) getWorld()).withLuck(getTier() / 2);
            List<ItemStack> result = getWorld().getLootTableManager().getLootTableFromLocation(LootTableList.GAMEPLAY_FISHING).generateLootForPools(rand, lootcontext$builder.build());
            long energyToConsume = GTValues.V[getTier()] / 16;
            int waitTime = (int) Math.ceil(256 / (Math.pow(2, getTier())));
            if (hasPool() && getTimer() % waitTime == 0 && energyContainer.getEnergyStored() >= energyToConsume) {
                for (ItemStack output : result) {
                    if (slotToOutput(output) != 4)
                    exportItems.insertItem(slotToOutput(output), output, false);
                    energyContainer.removeEnergy(energyToConsume);
                }
            }
            if (getTimer() % 5 == 0) {
                EnumFacing outputFacing = getOutputFacing();
                if (autoOutputItems) {
                    pushItemsIntoNearbyHandlers(outputFacing);
                }
            }
        }
    }

    private boolean hasPool() {
        boolean hasPool = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (this.getWorld().getBlockState(new BlockPos(getPos().getX() + i, getPos().getY() - 1, getPos().getZ() + j)).getBlock() != Blocks.WATER)
                    hasPool = false;
            }
        }
        return hasPool;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        Textures.FILTER_OVERLAY.renderSided(frontFacing, renderState, translation, pipeline);
        if (outputFacing != null) {
            Textures.PIPE_OUT_OVERLAY.renderSided(outputFacing, renderState, translation, pipeline);
            if (autoOutputItems) {
                Textures.ITEM_OUTPUT_OVERLAY.renderSided(outputFacing, renderState, translation, pipeline);
            }
        }
    }

    private int slotToOutput(ItemStack stack) {
        for (int i = 0; i < 4; i++) {
            if ((exportItems.getStackInSlot(i).getItem() == stack.getItem() || exportItems.getStackInSlot(i).isEmpty()) && exportItems.getStackInSlot(i).getCount() < exportItems.getStackInSlot(i).getMaxStackSize())
                return i;
        }
        return 4;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("OutputFacing", getOutputFacing().getIndex());
        data.setBoolean("AutoOutputItems", autoOutputItems);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.outputFacing = EnumFacing.VALUES[data.getInteger("OutputFacing")];
        this.autoOutputItems = data.getBoolean("AutoOutputItems");
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeByte(getOutputFacing().getIndex());
        buf.writeBoolean(autoOutputItems);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.outputFacing = EnumFacing.VALUES[buf.readByte()];
        this.autoOutputItems = buf.readBoolean();
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == 100) {
            this.outputFacing = EnumFacing.VALUES[buf.readByte()];
            getHolder().scheduleChunkForRenderUpdate();
        } else if (dataId == 101) {
            this.autoOutputItems = buf.readBoolean();
            getHolder().scheduleChunkForRenderUpdate();
        }
    }

    public void setOutputFacing(EnumFacing outputFacing) {
        this.outputFacing = outputFacing;
        if (!getWorld().isRemote) {
            writeCustomData(100, buf -> buf.writeByte(outputFacing.getIndex()));
            markDirty();
        }
    }

    public void setAutoOutputItems(boolean autoOutputItems) {
        this.autoOutputItems = autoOutputItems;
        if (!getWorld().isRemote) {
            writeCustomData(101, buf -> buf.writeBoolean(autoOutputItems));
            markDirty();
        }
    }

    @Override
    public void setFrontFacing(EnumFacing frontFacing) {
        super.setFrontFacing(frontFacing);
        if (this.outputFacing == null) {
            setOutputFacing(frontFacing.getOpposite());
        }
    }

    public EnumFacing getOutputFacing() {
        return outputFacing == null ? EnumFacing.SOUTH : outputFacing;
    }

    public boolean isAutoOutputItems() {
        return autoOutputItems;
    }

    protected ModularUI.Builder createGuiTemplate(EntityPlayer player) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 166)
                .widget(new LabelWidget(5, 5, getMetaFullName()))
                .widget(new SlotWidget(this.exportItems, 0, 70, 25)
                        .setBackgroundTexture(GuiTextures.SLOT))
                .widget(new SlotWidget(this.exportItems, 1, 88, 25)
                        .setBackgroundTexture(GuiTextures.SLOT))
                .widget(new SlotWidget(this.exportItems, 2, 70, 43)
                        .setBackgroundTexture(GuiTextures.SLOT))
                .widget(new SlotWidget(this.exportItems, 3, 88, 43)
                        .setBackgroundTexture(GuiTextures.SLOT))

                .bindPlayerInventory(player.inventory);

        int buttonStartX = 7;
        if (exportItems.getSlots() > 0) {
            builder.widget(new ToggleButtonWidget(buttonStartX, 62, 18, 18,
                    GuiTextures.BUTTON_ITEM_OUTPUT, this::isAutoOutputItems, this::setAutoOutputItems));
        }
        return builder;
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return createGuiTemplate(entityPlayer).build(getHolder(), entityPlayer);
    }
}