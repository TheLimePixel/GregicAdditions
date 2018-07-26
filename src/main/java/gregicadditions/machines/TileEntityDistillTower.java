package gregicadditions.machines;

import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

import static gregtech.api.multiblock.BlockPattern.RelativeDirection.*;

public class TileEntityDistillTower extends RecipeMapMultiblockController {
    public TileEntityDistillTower(String metaTileEntityId) {
        super(metaTileEntityId, GARecipeMaps.DISTILLATION_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new TileEntityDistillTower(metaTileEntityId);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            FluidStack stackInTank = importFluids.drain(Integer.MAX_VALUE, false);
            if (stackInTank != null && stackInTank.amount > 0) {
                TextComponentTranslation fluidName = new TextComponentTranslation(stackInTank.getFluid().getUnlocalizedName(stackInTank));
                textList.add(new TextComponentTranslation("gregtech.multiblock.distillation_tower.distilling_fluid", fluidName));
            }
        }
        super.addDisplayText(textList);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return SingleLimitFactory.start(RIGHT, FRONT, UP)
                .aisle("YSY", "YZY", "YYY")
                .aisle("XXX", "X#X", "XXX").setRepeatable(0, 10)
                .aisle("XXX", "XXX", "XXX")
                .where('S', selfPredicate())
                .where('Z', abilityPartPredicate(MultiblockAbility.IMPORT_FLUIDS))
                .where('Y', statePredicate(getCasingState()).or(abilityPartPredicate(MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.INPUT_ENERGY)))
                .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(MultiblockAbility.EXPORT_FLUIDS)))
                .where('#', blockPredicate(Blocks.AIR))
                .addCheck(1, abilityPartPredicate(MultiblockAbility.EXPORT_FLUIDS))
                .addCheck(2, abilityPartPredicate(MultiblockAbility.EXPORT_FLUIDS))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture() {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }
}

