package gregicadditions.machines;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.Textures;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityRockBreaker extends TieredMetaTileEntity {

    private OrientedOverlayRenderer renderer;

    public TileEntityRockBreaker(ResourceLocation metaTileEntityId, OrientedOverlayRenderer renderer, int tier) {
        super(metaTileEntityId, tier);
        this.renderer = renderer;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new TileEntityRockBreaker(metaTileEntityId, renderer, getTier());
    }

    @Override
    protected IItemHandlerModifiable createExportItemHandler() {
        return new ItemStackHandler(1);
    }

    @Override
    public void update() {
        super.update();
        if (!getWorld().isRemote) {
            ItemStack output;
            int largestSignal = 0;
            for (EnumFacing face : EnumFacing.VALUES)
                if (getWorld().getRedstonePower(getPos(), face) > largestSignal)
                    largestSignal = getWorld().getRedstonePower(getPos(), face);
            switch (largestSignal) {
                case 4:
                case 5:
                case 6:
                case 7:
                    output = new ItemStack(Blocks.STONE, 1, 3);
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    output = new ItemStack(Blocks.STONE, 1, 1);
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                    output = new ItemStack(Blocks.STONE, 1, 5);
                    break;
                default:
                    output = new ItemStack(Blocks.COBBLESTONE);
            }
            long energyToConsume = GTValues.V[getTier()] / 16;
            int waitTime = (int) Math.ceil(32 / (Math.pow(2, getTier())));
            if (checkSides(Blocks.LAVA) && checkSides(Blocks.WATER) && getTimer() % waitTime == 0 && energyContainer.getEnergyStored() >= energyToConsume) {
                exportItems.insertItem(0, output, false);
                energyContainer.removeEnergy(energyToConsume);
            }
            if (getTimer() % 5 == 0) {
                pushItemsIntoNearbyHandlers(frontFacing);
            }
        }
    }

    private boolean checkSides(BlockStaticLiquid liquid) {
        EnumFacing frontFacing = getFrontFacing();
        for (EnumFacing side : EnumFacing.VALUES) {
            if (side == frontFacing || side == EnumFacing.DOWN || side == EnumFacing.UP) continue;
            if (getWorld().getBlockState(getPos().offset(side)) == liquid.getDefaultState())
                return true;
        }
        return false;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        renderer.render(renderState, translation, pipeline, getFrontFacing(), false);
        Textures.PIPE_OUT_OVERLAY.renderSided(frontFacing, renderState, translation, pipeline);
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }
}