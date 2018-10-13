package gregicadditions.machines;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregicadditions.GATextures;
import gregtech.api.capability.impl.FluidTankList;
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
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidTank;

import javax.annotation.Nullable;
import java.util.List;

public class TileEntityCokeFluidHatch extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IFluidTank> {
    private static final int INVENTORY_SIZE = 4000;
    private boolean isExportHatch = true;

    public TileEntityCokeFluidHatch(String metaTileEntityId) {
        super(metaTileEntityId, 0);
        this.initializeInventory();
    }

    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new TileEntityCokeFluidHatch(this.metaTileEntityId);
    }

    public void update() {
        super.update();
        if (!this.getWorld().isRemote && this.getTimer() % 5L == 0L) {
            if (this.isExportHatch) {
                this.pushFluidsIntoNearbyHandlers(new EnumFacing[]{this.getFrontFacing()});
            } else {
                this.pullFluidsFromNearbyHandlers(new EnumFacing[]{this.getFrontFacing()});
            }
        }

    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        GATextures.COKE_OVEN_BRICKS.render(renderState, translation, pipeline);
        (this.isExportHatch ? Textures.PIPE_OUT_OVERLAY : Textures.PIPE_IN_OVERLAY).renderSided(this.getFrontFacing(), renderState, translation, pipeline);
    }

    private int getInventorySize() {
        return INVENTORY_SIZE;
    }

    protected FluidTankList createImportFluidHandler() {
        return this.isExportHatch ? new FluidTankList(false, new IFluidTank[0]) : new FluidTankList(false, new IFluidTank[]{new FluidTank(this.getInventorySize())});
    }

    protected FluidTankList createExportFluidHandler() {
        return this.isExportHatch ? new FluidTankList(false, new IFluidTank[]{new FluidTank(this.getInventorySize())}) : new FluidTankList(false, new IFluidTank[0]);
    }

    public MultiblockAbility<IFluidTank> getAbility() {
        return this.isExportHatch ? MultiblockAbility.EXPORT_FLUIDS : MultiblockAbility.IMPORT_FLUIDS;
    }

    public void registerAbilities(List<IFluidTank> abilityList) {
        abilityList.addAll(this.isExportHatch ? this.exportFluids.getFluidTanks() : this.importFluids.getFluidTanks());
    }

    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return false;
    }

    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gregtech.universal.tooltip.fluid_storage_capacity", new Object[]{this.getInventorySize()}));
    }
}