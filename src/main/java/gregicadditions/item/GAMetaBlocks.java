package gregicadditions.item;

import gregicadditions.GAMaterials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.pipelike.cable.WireProperties;
import gregtech.common.pipelike.fluidpipe.FluidPipeProperties;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GAMetaBlocks {


    public static GAMultiblockCasing MUTLIBLOCK_CASING;

    public static GATransparentCasing TRANSPARENT_CASING;

    public static void init() {
        MUTLIBLOCK_CASING = new GAMultiblockCasing();
        MUTLIBLOCK_CASING.setRegistryName("ga_multiblock_casing");

        TRANSPARENT_CASING = new GATransparentCasing();
        TRANSPARENT_CASING.setRegistryName("ga_transparent_casing");

        MetaBlocks.FLUID_PIPE.addPipeMaterial(GAMaterials.Plasma, new FluidPipeProperties(1000000, 30, true));

        MetaBlocks.CABLE.addCableMaterial(GAMaterials.MVSuperconductor, new WireProperties(128, 2, 0));
        MetaBlocks.CABLE.addCableMaterial(GAMaterials.HVSuperconductor, new WireProperties(512, 2, 0));
        MetaBlocks.CABLE.addCableMaterial(GAMaterials.EVSuperconductor, new WireProperties(2048, 4, 0));
        MetaBlocks.CABLE.addCableMaterial(GAMaterials.IVSuperconductor, new WireProperties(8192, 4, 0));
        MetaBlocks.CABLE.addCableMaterial(GAMaterials.LuVSuperconductor, new WireProperties(32768, 8, 0));
        MetaBlocks.CABLE.addCableMaterial(GAMaterials.ZPMSuperconductor, new WireProperties(131072, 8, 0));
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
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }

    private static String statePropertiesToString(Map<IProperty<?>, Comparable<?>> properties) {
        StringBuilder stringbuilder = new StringBuilder();

        List<Map.Entry<IProperty<?>, Comparable<?>>> entries = properties.entrySet().stream()
                .sorted(Comparator.comparing(c -> c.getKey().getName()))
                .collect(Collectors.toList());

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
