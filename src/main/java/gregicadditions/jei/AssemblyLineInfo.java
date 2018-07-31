package gregicadditions.jei;

import com.google.common.collect.Lists;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.item.GATransparentCasing;
import gregicadditions.machines.GATileEntities;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.List;

public class AssemblyLineInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return GATileEntities.ASSEMBLY_LINE;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
                .aisle("COC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("FIF", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("FIF", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GAG", "#Y#")
                .aisle("CIC", "RTR", "GSG", "#Y#")
                .where('S', GATileEntities.ASSEMBLY_LINE, EnumFacing.SOUTH)
                .where('C', MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[4],EnumFacing.DOWN)
                .where('O', MetaTileEntities.ITEM_EXPORT_BUS[4],EnumFacing.DOWN)
                .where('Y', MetaTileEntities.ENERGY_INPUT_HATCH[4],EnumFacing.UP)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[0],EnumFacing.DOWN)
                .where('G', MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
                .where('A', MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLER_CASING))
                .where('R', GAMetaBlocks.TRANSPARENT_CASING.getState(GATransparentCasing.CasingType.REINFORCED_GLASS))
                .where('T', GAMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.TUNGSTENSTEEL_GEARBOX_CASING))
                .where('#', Blocks.AIR.getDefaultState())
                .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gregtech.multiblock.assembly_line.description")};
    }

}