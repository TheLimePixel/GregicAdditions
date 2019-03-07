package gregicadditions.item;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.pipelike.fluidpipe.FluidPipeProperties;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GAMetaBlocks {

	public static GAMultiblockCasing MUTLIBLOCK_CASING;

	public static GATransparentCasing TRANSPARENT_CASING;

	public static void init() {
		MUTLIBLOCK_CASING = new GAMultiblockCasing();
		MUTLIBLOCK_CASING.setRegistryName("ga_multiblock_casing");

		TRANSPARENT_CASING = new GATransparentCasing();
		TRANSPARENT_CASING.setRegistryName("ga_transparent_casing");

		MetaBlocks.FLUID_PIPE.addPipeMaterial(Materials.Ultimet, new FluidPipeProperties(1500, 12000, true));
		//MetaBlocks.FLUID_PIPE.addPipeMaterial(GAMaterials.Plasma, new FluidPipeProperties(1000000, 30, true));
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemModels() {
		registerItemModel(MUTLIBLOCK_CASING);
		registerItemModel(TRANSPARENT_CASING);
	}

	@SideOnly(Side.CLIENT)
	private static void registerItemModel(Block block) {
		for (IBlockState state : block.getBlockState().getValidStates()) {
			//noinspection ConstantConditions
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), block.getMetaFromState(state), new ModelResourceLocation(block.getRegistryName(), statePropertiesToString(state.getProperties())));
		}
	}

	private static String statePropertiesToString(Map<IProperty<?>, Comparable<?>> properties) {
		StringBuilder stringbuilder = new StringBuilder();

		List<Map.Entry<IProperty<?>, Comparable<?>>> entries = properties.entrySet().stream().sorted(Comparator.comparing(c -> c.getKey().getName())).collect(Collectors.toList());

		for (Map.Entry<IProperty<?>, Comparable<?>> entry : entries) {
			if (stringbuilder.length() != 0) {
				stringbuilder.append(",");
			}

			IProperty<?> property = entry.getKey();
			stringbuilder.append(property.getName());
			stringbuilder.append("=");
			stringbuilder.append(getPropertyName(property, entry.getValue()));
		}

		if (stringbuilder.length() == 0) {
			stringbuilder.append("normal");
		}

		return stringbuilder.toString();
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> String getPropertyName(IProperty<T> property, Comparable<?> value) {
		return property.getName((T) value);
	}
}
