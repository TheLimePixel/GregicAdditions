package gregicadditions.machines;

import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.item.GATransparentCasing;
import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.Textures;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;

import static gregtech.api.multiblock.BlockPattern.RelativeDirection.*;

public class TileEntityFusionReactor extends RecipeMapMultiblockController {
    private final int tier;

    public TileEntityFusionReactor(String metaTileEntityId, int tier) {
        super(metaTileEntityId, RecipeMaps.FUSION_RECIPES);
        this.tier = tier;
        this.reinitializeStructurePattern();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new TileEntityFusionReactor(metaTileEntityId, tier);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start().start(LEFT, DOWN, BACK)
                .aisle("###############", "######OCO######", "###############")
                .aisle("######ICI######", "####CCcccCC####", "######ICI######")
                .aisle("####CC###CC####", "###EccOCOccE###", "####CC###CC####")
                .aisle("###C#######C###", "##EcEC###CEcE##", "###C#######C###")
                .aisle("##C#########C##", "#CcE#######EcC#", "##C#########C##")
                .aisle("##C#########C##", "#CcC#######CcC#", "##C#########C##")
                .aisle("#I###########I#", "OcO#########OcO", "#I###########I#")
                .aisle("#C###########C#", "CcC#########CcC", "#C###########C#")
                .aisle("#I###########I#", "OcO#########OcO", "#I###########I#")
                .aisle("##C#########C##", "#CcC#######CcC#", "##C#########C##")
                .aisle("##C#########C##", "#CcE#######EcC#", "##C#########C##")
                .aisle("###C#######C###", "##EcEC###CEcE##", "###C#######C###")
                .aisle("####CC###CC####", "###EccOCOccE###", "####CC###CC####")
                .aisle("######ICI######", "####CCcccCC####", "######ICI######")
                .aisle("###############", "######OSO######", "###############")
                .where('S', selfPredicate())
                .where('C', statePredicate(getCasingState()))
                .where('c', statePredicate(getCoilState()))
                .where('O', statePredicate(getCasingState()).or(tilePredicate((state, tile) -> {
                    for (int i = tier; i < GTValues.V.length; i++) {
                        if (tile.metaTileEntityId.equals(MetaTileEntities.FLUID_EXPORT_HATCH[i].metaTileEntityId))
                            return true;
                    }
                    return false;
                })))
                .where('E', statePredicate(getCasingState()).or(tilePredicate((state, tile) -> {
                    for (int i = tier; i < GTValues.V.length; i++) {
                        if (tile.metaTileEntityId.equals(MetaTileEntities.ENERGY_INPUT_HATCH[i].metaTileEntityId))
                            return true;
                    }
                    return false;
                })))
                .where('I', statePredicate(getCasingState()).or(tilePredicate((state, tile) -> {
                    for (int i = tier; i < GTValues.V.length; i++) {
                        if (tile.metaTileEntityId.equals(MetaTileEntities.FLUID_IMPORT_HATCH[i].metaTileEntityId))
                            return true;
                    }
                    return false;
                })))
                .where('#', (tile)->{return true;})
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture() {
        return Textures.SOLID_STEEL_CASING;
    }

    protected IBlockState getCasingState() {

        switch (tier) {
            case 6:
                return MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV);
            case 7:
                return MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.FUSION_CASING);
            case 8:
            default:
                return MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.FUSION_CASING_MK2);
        }
    }

    protected IBlockState getCoilState() {

        switch (tier) {
            case 6:
                return MetaBlocks.WIRE_COIL.getState(BlockWireCoil.CoilType.SUPERCONDUCTOR);
            case 7:
            case 8:
            default:
                return MetaBlocks.WIRE_COIL.getState(BlockWireCoil.CoilType.FUSION_COIL);
        }
    }
}

