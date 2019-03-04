package gregicadditions.jei;

import com.google.common.collect.Lists;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.machines.GATileEntities;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.List;

public class CokeOvenInfo extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return GATileEntities.COKE_OVEN;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder() //Aisles go from back to front
                .aisle("XXX", "XXX", "XXX")
                .aisle("XHX", "X#X", "XBX")
                .aisle("XXX", "XYX", "XXX")
                .where('X', GAMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.COKE_OVEN_BRICKS))
                .where('#', Blocks.AIR.getDefaultState())
                .where('Y', GATileEntities.COKE_OVEN, EnumFacing.SOUTH)
                .where('H', GATileEntities.COKE_FLUID_HATCH, EnumFacing.WEST)
                .where('B', GATileEntities.COKE_ITEM_BUS, EnumFacing.EAST)
                .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gregtech.multiblock.ga_coke_oven.description")};
    }

}