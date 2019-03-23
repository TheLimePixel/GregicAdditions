package gregicadditions.item;

import gregicadditions.GAConfig;
import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.stats.IMetaItemStats;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import net.minecraftforge.fml.common.Loader;

public class GAMetaItem extends MaterialMetaItem {

    public GAMetaItem() {
        super(OrePrefix.valueOf("plateCurved"), OrePrefix.valueOf("ingotDouble"), OrePrefix.valueOf("round"), null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null);
    }

    public void registerSubItems() {
        GAMetaItems.COKE_BRICK = addItem(0, "ga_brick.coke");
        GAMetaItems.FIRECLAY_BRICK = addItem(1, "ga_brick.fireclay").setUnificationData(OrePrefix.ingot, Materials.Fireclay);
        GAMetaItems.ADVANCED_CIRCUIT = addItem(2, "circuit.advanced.regular").setUnificationData(OrePrefix.circuit, Tier.Advanced);
        GAMetaItems.GOOD_CIRCUIT = addItem(3, "circuit.good.regular").setUnificationData(OrePrefix.circuit, Tier.Good);
        GAMetaItems.PETRI_DISH = addItem(4, "component.petri.dish");
        GAMetaItems.COMPRESSED_CLAY = addItem(5, "ga_compressed.clay");
        GAMetaItems.COMPRESSED_COKE_CLAY = addItem(6, "ga_compressed.coke.clay");
        GAMetaItems.COMPRESSED_FIRECLAY = addItem(7, "ga_compressed.fireclay");
        GAMetaItems.CRYSTAL_COMPUTER = addItem(8, "computer.crystal").setUnificationData(OrePrefix.circuit, Tier.Ultimate);
        GAMetaItems.NANO_COMPUTER = addItem(9, "computer.nano").setUnificationData(OrePrefix.circuit, Tier.Elite);
        GAMetaItems.QUANTUM_COMPUTER = addItem(10, "computer.quantum").setUnificationData(OrePrefix.circuit, Tier.Master);
        GAMetaItems.CRYSTAL_MAINFRAME = addItem(11, "mainframe.crystal").setUnificationData(OrePrefix.circuit, Tier.Superconductor);
        GAMetaItems.NANO_MAINFRAME = addItem(12, "mainframe.nano").setUnificationData(OrePrefix.circuit, Tier.Master);
        GAMetaItems.INTEGRATED_MAINFRAME = addItem(13, "mainframe.normal").setUnificationData(OrePrefix.circuit, Tier.Elite);
        GAMetaItems.QUANTUM_MAINFRAME = addItem(14, "mainframe.quantum").setUnificationData(OrePrefix.circuit, Tier.Ultimate);
        GAMetaItems.NEURO_PROCESSOR = addItem(15, "processor.neuro");
        GAMetaItems.INTEGRATED_COMPUTER = addItem(16, "computer.normal").setUnificationData(OrePrefix.circuit, Tier.Extreme);
        GAMetaItems.RAW_CRYSTAL_CHIP = addItem(17, "crystal.raw");
        GAMetaItems.STEMCELLS = addItem(18, "stemcells");
        GAMetaItems.MICA_SHHET = addItem(26, "mica_sheet");
        GAMetaItems.MICA_INSULATOR_SHHET = addItem(27, "mica_insulator_sheet");
        GAMetaItems.MICA_INSULATOR_FOI = addItem(28, "mica_insulator_foil");
        GAMetaItems.BASIC_BOARD = addItem(29, "board.basic");
        GAMetaItems.GOOD_PHENOLIC_BOARD = addItem(30, "board.good.phenolic");
        GAMetaItems.GOOD_PLASTIC_BOARD = addItem(31, "board.good.plastic");
        GAMetaItems.ADVANCED_BOARD = addItem(32, "board.advanced");
        GAMetaItems.EXTREME_BOARD = addItem(33, "board.extreme");
        GAMetaItems.ELITE_BOARD = addItem(34, "board.elite");
        GAMetaItems.MASTER_BOARD = addItem(35, "board.master");

        if (Loader.isModLoaded("forestry") && GAConfig.GT6.electrodes) {
            GAMetaItems.ELECTRODE_APATITE = addItem(100, "electrode.apatite");
            GAMetaItems.ELECTRODE_BLAZE = addItem(101, "electrode.blaze");
            GAMetaItems.ELECTRODE_BRONZE = addItem(102, "electrode.bronze");
            GAMetaItems.ELECTRODE_COPPER = addItem(103, "electrode.copper");
            GAMetaItems.ELECTRODE_DIAMOND = addItem(104, "electrode.diamond");
            GAMetaItems.ELECTRODE_EMERALD = addItem(105, "electrode.emerald");
            GAMetaItems.ELECTRODE_ENDER = addItem(106, "electrode.ender");
            GAMetaItems.ELECTRODE_GOLD = addItem(107, "electrode.gold");
            if (Loader.isModLoaded("ic2") || Loader.isModLoaded("binniecore"))
                GAMetaItems.ELECTRODE_IRON = addItem(108, "electrode.iron");
            GAMetaItems.ELECTRODE_LAPIS = addItem(109, "electrode.lapis");
            GAMetaItems.ELECTRODE_OBSIDIAN = addItem(110, "electrode.obsidian");
            if (Loader.isModLoaded("extrautils2"))
                GAMetaItems.ELECTRODE_ORCHID = addItem(111, "electrode.orchid");
            if (Loader.isModLoaded("ic2") || Loader.isModLoaded("techreborn") || Loader.isModLoaded("binniecore"))
                GAMetaItems.ELECTRODE_RUBBER = addItem(112, "electrode.rubber");
            GAMetaItems.ELECTRODE_TIN = addItem(113, "electrode.tin");
        }

        if (GAConfig.GT5U.enableZPMandUVBats) {
            GAMetaItems.ENERGY_MODULE = addItem(19, "energy.module").addStats(new IMetaItemStats[]{ElectricStats.createRechargeableBattery(10000000000L, 7)}).setModelAmount(8);
            GAMetaItems.ENERGY_CLUSTER = addItem(20, "energy.cluster").addStats(new IMetaItemStats[]{ElectricStats.createRechargeableBattery(100000000000L, 8)}).setModelAmount(8);
        }

        if (GAConfig.GT5U.replaceUVwithMAXBat) {
            GAMetaItems.MAX_BATTERY = addItem(21, "max.battery").addStats(new IMetaItemStats[]{ElectricStats.createRechargeableBattery(9223372036854775807L, 9)}).setModelAmount(8);
            MetaItems.ZPM2.setInvisible();
        }

        if (Loader.isModLoaded("tconstruct") && GAConfig.Misc.TiCIntegration)
        GAMetaItems.COMPRESSED_GROUT = addItem(22, "ga_compressed.grout");
        GAMetaItems.MOLD_FORM_ANVIL = addItem(36, "mold.form.anvil");
        GAMetaItems.MOLD_FORM_BALL = addItem(37, "mold.form.ball");
        GAMetaItems.MOLD_FORM_BLOCK = addItem(38, "mold.form.block");
        GAMetaItems.MOLD_FORM_BOTTLE = addItem(39, "mold.form.bottle");
        GAMetaItems.MOLD_FORM_COINAGE = addItem(40, "mold.form.coinage");
        GAMetaItems.MOLD_FORM_CYLINDER = addItem(23, "mold.form.cylinder");
        GAMetaItems.MOLD_FORM_GEAR = addItem(41, "mold.form.gear");
        GAMetaItems.MOLD_FORM_INGOT = addItem(42, "mold.form.ingot");
        GAMetaItems.MOLD_FORM_NAME = addItem(43, "mold.form.name");
        GAMetaItems.MOLD_FORM_NUGGETS = addItem(44, "mold.form.nuggets");
        GAMetaItems.MOLD_FORM_PLATE = addItem(45, "mold.form.plate");
        GAMetaItems.MOLD_FORM_SMALL_GEAR = addItem(46, "mold.form.small_gear");
        GAMetaItems.SHAPE_AXE_HEAD = addItem(47, "shape.axe_head");
        GAMetaItems.SHAPE_BLOCK = addItem(48, "shape.block");
        GAMetaItems.SHAPE_BOLT = addItem(49, "shape.bolt");
        GAMetaItems.SHAPE_BOTTLE = addItem(50, "shape.bottle");
        GAMetaItems.SHAPE_CELL = addItem(51, "shape.cell");
        GAMetaItems.SHAPE_FILE_HEAD = addItem(52, "shape.file_head");
        GAMetaItems.SHAPE_GEAR = addItem(53, "shape.gear");
        GAMetaItems.SHAPE_HAMMER_HEAD = addItem(54, "shape.hammer_head");
        GAMetaItems.SHAPE_HOE_HEAD = addItem(55, "shape.hoe_head");
        GAMetaItems.SHAPE_INGOT = addItem(56, "shape.ingot");
        GAMetaItems.SHAPE_LARGE_PIPE = addItem(57, "shape.large_pipe");
        GAMetaItems.SHAPE_NORMAL_PIPE = addItem(58, "shape.normal_pipe");
        GAMetaItems.SHAPE_PICKAXE_HEAD = addItem(59, "shape.pickaxe_head");
        GAMetaItems.SHAPE_PLATE = addItem(60, "shape.plate");
        GAMetaItems.SHAPE_RING = addItem(61, "shape.ring");
        GAMetaItems.SHAPE_ROD = addItem(62, "shape.rod");
        GAMetaItems.SHAPE_SAW_BLADE = addItem(63, "shape.saw_blade");
        GAMetaItems.SHAPE_SHOVEL_HEAD = addItem(64, "shape.shovel_head");
        GAMetaItems.SHAPE_SMALL_PIPE = addItem(65, "shape.small_pipe");
        GAMetaItems.SHAPE_SWORD_BLADE = addItem(66, "shape.sword_blade");
        GAMetaItems.SHAPE_TINY_PIPE = addItem(67, "shape.tiny_pipe");
        GAMetaItems.SHAPE_WIRE = addItem(68, "shape.wire");

        MetaItems.COMPRESSED_CLAY.setInvisible();
        MetaItems.COMPRESSED_FIRECLAY.setInvisible();
        MetaItems.COKE_OVEN_BRICK.setInvisible();
        MetaItems.FIRECLAY_BRICK.setInvisible();
    }
}
