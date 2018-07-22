package gregicadditions.item;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.toolitem.ToolMetaItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class GAMetaItems {


    public static List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();

    public static MetaItem<?>.MetaValueItem NANO_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem INTEGRATED_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem WETWARE_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem COATED_BOARD;
    public static MetaItem<?>.MetaValueItem EPOXY_BOARD;
    public static MetaItem<?>.MetaValueItem FIBER_BOARD;
    public static MetaItem<?>.MetaValueItem MULTILAYER_FIBER_BOARD;
    public static MetaItem<?>.MetaValueItem PHENOLIC_BOARD;
    public static MetaItem<?>.MetaValueItem PLASTIC_BOARD;
    public static MetaItem<?>.MetaValueItem WETWARE_BOARD;
    public static MetaItem<?>.MetaValueItem GLOWSTONE_BOULE;
    public static MetaItem<?>.MetaValueItem NAQUADAH_BOULE;
    public static MetaItem<?>.MetaValueItem SILICON_BOULE;
    public static MetaItem<?>.MetaValueItem COKE_BRICK;
    public static MetaItem<?>.MetaValueItem FIRECLAY_BRICK;
    public static MetaItem<?>.MetaValueItem ADVANCED_CIRCUIT;
    public static MetaItem<?>.MetaValueItem GOOD_CIRCUIT;
    public static MetaItem<?>.MetaValueItem BASIC_CIRCUIT;
    public static MetaItem<?>.MetaValueItem VACUUM_TUBE;
    public static MetaItem<?>.MetaValueItem DIODE;
    public static MetaItem<?>.MetaValueItem CAPACITOR;
    public static MetaItem<?>.MetaValueItem GLASS_FIBER;
    public static MetaItem<?>.MetaValueItem GLASS_TUBE;
    public static MetaItem<?>.MetaValueItem PETRI_DISH;
    public static MetaItem<?>.MetaValueItem RESISTOR;
    public static MetaItem<?>.MetaValueItem SMALL_COIL;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR;
    public static MetaItem<?>.MetaValueItem SMD_DIODE;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem TRANSISTOR;
    public static MetaItem<?>.MetaValueItem COMPRESSED_CLAY;
    public static MetaItem<?>.MetaValueItem COMPRESSED_COKE_CLAY;
    public static MetaItem<?>.MetaValueItem COMPRESSED_FIRECLAY;
    public static MetaItem<?>.MetaValueItem CRYSTAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem NANO_COMPUTER;
    public static MetaItem<?>.MetaValueItem QUANTUM_COMPUTER;
    public static MetaItem<?>.MetaValueItem WETWARE_COMPUTER;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MAINFRAME;
    public static MetaItem<?>.MetaValueItem NANO_MAINFRAME;
    public static MetaItem<?>.MetaValueItem INTEGRATED_MAINFRAME;
    public static MetaItem<?>.MetaValueItem QUANTUM_MAINFRAME;
    public static MetaItem<?>.MetaValueItem WETWARE_MAINFRAME;
    public static MetaItem<?>.MetaValueItem ASOC;
    public static MetaItem<?>.MetaValueItem LOGIC_CIRCUIT;
    public static MetaItem<?>.MetaValueItem CPU;
    public static MetaItem<?>.MetaValueItem HPIC;
    public static MetaItem<?>.MetaValueItem NAND;
    public static MetaItem<?>.MetaValueItem NANOCPU;
    public static MetaItem<?>.MetaValueItem NOR;
    public static MetaItem<?>.MetaValueItem PIC;
    public static MetaItem<?>.MetaValueItem QBIT_CPU;
    public static MetaItem<?>.MetaValueItem RAM;
    public static MetaItem<?>.MetaValueItem SOC;
    public static MetaItem<?>.MetaValueItem CRYSTALPROCESSOR;
    public static MetaItem<?>.MetaValueItem NANOPROCESSOR;
    public static MetaItem<?>.MetaValueItem QUANTUMPROCESSOR;
    public static MetaItem<?>.MetaValueItem WETWAREPROCESSOR;
    public static MetaItem<?>.MetaValueItem ASOC_WAFER;
    public static MetaItem<?>.MetaValueItem LOGIC_CIRCUIT_WAFER;
    public static MetaItem<?>.MetaValueItem CPU_WAFER;
    public static MetaItem<?>.MetaValueItem GLOWSTONE_WAFER;
    public static MetaItem<?>.MetaValueItem HPIC_WAFER;
    public static MetaItem<?>.MetaValueItem NAND_WAFER;
    public static MetaItem<?>.MetaValueItem NANOCPU_WAFER;
    public static MetaItem<?>.MetaValueItem NAQUADAH_WAFER;
    public static MetaItem<?>.MetaValueItem NOR_WAFER;
    public static MetaItem<?>.MetaValueItem PIC_WAFER;
    public static MetaItem<?>.MetaValueItem QBIT_CPU_WAFER;
    public static MetaItem<?>.MetaValueItem RAM_WAFER;
    public static MetaItem<?>.MetaValueItem SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem SOC_WAFER;
    public static MetaItem<?>.MetaValueItem ACACIA_FORM;
    public static MetaItem<?>.MetaValueItem BIRCH_FORM;
    public static MetaItem<?>.MetaValueItem DARK_OAK_FORM;
    public static MetaItem<?>.MetaValueItem JUNGLE_FORM;
    public static MetaItem<?>.MetaValueItem OAK_FORM;
    public static MetaItem<?>.MetaValueItem SPRUCE_FORM;
    public static MetaItem<?>.MetaValueItem BIO_CHAFF;
    public static MetaItem<?>.MetaValueItem RAW_CARBON_FIBERS;
    public static MetaItem<?>.MetaValueItem ADVANCED_ALLOY_PLATE;
    public static MetaItem<?>.MetaValueItem MIXED_METAL_PLATE;
    public static MetaItem<?>.MetaValueItem RAW_CRYSTAL_CHIP;
    public static MetaItem<?>.MetaValueItem CRYSTAL_CPU;
    public static MetaItem<?>.MetaValueItem CRYSTAL_SOC;
    public static MetaItem<?>.MetaValueItem ULTIMATE_PIPE_SMALL;
    public static MetaItem<?>.MetaValueItem ULTIMATE_PIPE;
    public static MetaItem<?>.MetaValueItem ULTIMATE_PIPE_LARGE;

    public static MetaItem<?>.MetaValueItem BENDING_CYLINDER;
    public static MetaItem<?>.MetaValueItem SMALL_BENDING_CYLINDER;

    public static void init() {
        GAMetaItem item = new GAMetaItem();
        item.setRegistryName("ga_meta_item");
        GAMetaTool tool = new GAMetaTool();
        tool.setRegistryName("ga_meta_tool");
    }

    public static void registerOreDict() {
        for (MetaItem<?> item : ITEMS) {
            if (item instanceof GAMetaItem) {
                ((GAMetaItem) item).registerOreDict();
            }
        }
    }

    public static void registerRecipes() {
        for (MetaItem<?> item : ITEMS) {
            if (item instanceof GAMetaTool)
                ((GAMetaTool) item).registerRecipes();
        }
    }
}
