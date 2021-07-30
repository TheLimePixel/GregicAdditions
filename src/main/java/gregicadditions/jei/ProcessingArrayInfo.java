package gregicadditions.jei;

import java.util.List;

import com.google.common.collect.Lists;

import gregicadditions.GAConfig;
import gregicadditions.machines.GATileEntities;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

public class ProcessingArrayInfo extends MultiblockInfoPage {

	public ProcessingArrayInfo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MultiblockControllerBase getController() {
		return GATileEntities.PROCESSING_ARRAY;
	}

	@Override
	public List<MultiblockShapeInfo> getMatchingShapes() {
		MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
				.aisle("XIX", "XXX", "XXX")
				.aisle("MXX", "S#E", "XXX")
				.aisle("XOX", "XXX", "XXX")
				.where('S', GATileEntities.PROCESSING_ARRAY, EnumFacing.WEST)
				.where('M', GATileEntities.MACHINE_ACCESS_INTERFACE, EnumFacing.WEST)
				.where('X', MetaBlocks.METAL_CASING.getState(MetalCasingType.TUNGSTENSTEEL_ROBUST))
				.where('#', Blocks.AIR.getDefaultState())
				.where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.NORTH)
				.where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.LV],EnumFacing.EAST)
				.where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.SOUTH).build();

		return Lists.newArrayList(shapeInfo);
	}

	public IBlockState getCasingState() {
		return MetaBlocks.METAL_CASING.getState(MetalCasingType.TUNGSTENSTEEL_ROBUST);
	}

	@Override
	public String[] getDescription() {
		return new String[] { I18n.format("gregtech.multiblock.processing_array.description", GAConfig.processingArray.processingArrayMachineLimit) };
	}

}
