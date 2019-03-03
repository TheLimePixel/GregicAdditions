package gregicadditions.machines;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregicadditions.GATextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.render.Textures;
import gregtech.common.metatileentities.electric.multiblockpart.MetaTileEntityMultiblockPart;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;

public class TileEntityCokeItemBus extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IItemHandlerModifiable> {
    private static final int INVENTORY_SIZE = 1;
    private final boolean isExportHatch = true;

    public TileEntityCokeItemBus(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, 0);
        this.initializeInventory();
    }

    @Override
	public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new TileEntityCokeItemBus(this.metaTileEntityId);
    }

    @Override
	public void update() {
        super.update();
        if (!this.getWorld().isRemote && this.getTimer() % 5L == 0L) {
            if (this.isExportHatch) {
                this.pushItemsIntoNearbyHandlers(new EnumFacing[]{this.getFrontFacing()});
            } else {
                this.pullItemsFromNearbyHandlers(new EnumFacing[]{this.getFrontFacing()});
            }
        }

    }

    @Override
	public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        GATextures.COKE_OVEN_BRICKS.render(renderState, translation, pipeline);
        (this.isExportHatch ? Textures.PIPE_OUT_OVERLAY : Textures.PIPE_IN_OVERLAY).renderSided(this.getFrontFacing(), renderState, translation, pipeline);
    }

    private int getInventorySize() {
        return INVENTORY_SIZE;
    }

    @Override
	protected IItemHandlerModifiable createExportItemHandler() {
        return this.isExportHatch ? new ItemStackHandler(this.getInventorySize()) : new ItemStackHandler(0);
    }

    @Override
	protected IItemHandlerModifiable createImportItemHandler() {
        return this.isExportHatch ? new ItemStackHandler(0) : new ItemStackHandler(this.getInventorySize());
    }

    @Override
	public MultiblockAbility<IItemHandlerModifiable> getAbility() {
        return this.isExportHatch ? MultiblockAbility.EXPORT_ITEMS : MultiblockAbility.IMPORT_ITEMS;
    }

    @Override
	public void registerAbilities(List<IItemHandlerModifiable> abilityList) {
        abilityList.add(this.isExportHatch ? this.exportItems : this.importItems);
    }

    @Override
	protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return false;
    }

    @Override
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gregtech.universal.tooltip.item_storage_capacity", new Object[]{this.getInventorySize()}));
    }
}