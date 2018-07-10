package gregicadditions.item;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

public class GAMetaItem extends MaterialMetaItem {

    public GAMetaItem() {
        super(OrePrefix.valueOf("plateCurved"), null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null);
    }

    public void registerSubItems() {

        GAMetaItems.NANO_ASSEMBLY = addItem(1, "assembly.nano");
        GAMetaItems.INTEGRATED_ASSEMBLY = addItem(0, "assembly.normal");
        GAMetaItems.WETWARE_ASSEMBLY = addItem(2, "assembly.wetware");
        GAMetaItems.COATED_BOARD = addItem(3, "board.coated");
        GAMetaItems.EPOXY_BAORD = addItem(4, "board.epoxy");
        GAMetaItems.FIBER_BOARD = addItem(5, "board.fiber-reinforced");
        GAMetaItems.MULTILAYER_FIBER_BOARD = addItem(6, "board.multilayer.fiber-reinforced");
        GAMetaItems.PHENOLIC_BOARD = addItem(7, "board.phenolic");
        GAMetaItems.PLASTIC_BOARD = addItem(8, "board.plastic");
        GAMetaItems.WETWARE_BOARD = addItem(9, "board.wetware");
        GAMetaItems.GLOSTONE_BOULE = addItem(10, "boule.glowstone");
        GAMetaItems.NAQUADAH_BOULE = addItem(11, "boule.naquadah");
        GAMetaItems.SILICON_BOULE = addItem(12, "boule.silicon");
        GAMetaItems.COKE_BRICK = addItem(13, "brick.coke");
        GAMetaItems.FIRECLAY_BRICK = addItem(14, "brick.fireclay");
        GAMetaItems.ADVANCED_CIRCUIT = addItem(15, "circuit.advanced.regular");
        GAMetaItems.GOOD_CIRCUIT = addItem(16, "circuit.good.regular");
        GAMetaItems.BASIC_CIRCUIT = addItem(17, "circuit.basic.regular");
        GAMetaItems.VACUUM_TUBE = addItem(18, "circuit.vacuum.tube");
        GAMetaItems.DIODE = addItem(19, "component.diode");
        GAMetaItems.CAPACITOR = addItem(20, "component.capacitor");
        GAMetaItems.GLASS_FIBER = addItem(21, "component.glass.fiber");
        GAMetaItems.GLASS_TUBE = addItem(22, "component.glass.tube");
        GAMetaItems.PETRI_DISH = addItem(23, "component.petri.dish");
        GAMetaItems.RESISTOR = addItem(24, "component.resistor");
        GAMetaItems.SMALL_COIL = addItem(25, "component.small.coil");
        GAMetaItems.SMD_DIODE = addItem(26, "component.smd.diode");
        GAMetaItems.SMD_CAPACITOR = addItem(27, "component.smd.capacitor");
        GAMetaItems.SMD_RESISTOR = addItem(28, "component.smd.resistor");
        GAMetaItems.SMD_TRANSISTOR = addItem(29, "component.smd.transistor");
        GAMetaItems.TRANSISTOR = addItem(30, "component.transistor");
        GAMetaItems.COMPRESSED_CLAY = addItem(31, "compressed.clay");
        GAMetaItems.COMPRESSED_COKE_CLAY = addItem(32, "compressed.coke.clay");
        GAMetaItems.COMPRESSED_FIRECLAY = addItem(33, "compressed.fireclay");
        GAMetaItems.CRYSTAL_COMPUTER = addItem(34, "computer.crystal");
        GAMetaItems.NANO_COMPUTER = addItem(35, "computer.nano");
        GAMetaItems.QUANTUM_COMPUTER = addItem(36, "computer.quantum");
        GAMetaItems.WETWARE_COMPUTER = addItem(37, "computer.wetware");
        GAMetaItems.CRYSTAL_MAINFRAME = addItem(38, "mainframe.crystal");
        GAMetaItems.NANO_MAINFRAME = addItem(39, "mainframe.nano");
        GAMetaItems.INTEGRATED_MAINFRAME = addItem(40, "mainframe.normal");
        GAMetaItems.QUANTUM_MAINFRAME = addItem(41, "mainframe.quantum");
        GAMetaItems.WETWARE_MAINFRAME = addItem(42, "mainframe.wetware");
        GAMetaItems.ASOC = addItem(43, "plate.asoc");
        GAMetaItems.LOGIC_CIRCUIT = addItem(44, "plate.circuit");
        GAMetaItems.CPU = addItem(45, "plate.cpu");
        GAMetaItems.HPIC = addItem(46, "plate.hpic");
        GAMetaItems.NAND = addItem(47, "plate.nand");
        GAMetaItems.NANOCPU = addItem(48, "plate.nanocpu");
        GAMetaItems.NOR = addItem(49, "plate.nor");
        GAMetaItems.PIC = addItem(50, "plate.pic");
        GAMetaItems.QBIT_CPU = addItem(51, "plate.qbit");
        GAMetaItems.RAM = addItem(52, "plate.ram");
        GAMetaItems.SOC = addItem(53, "plate.soc");
        GAMetaItems.CRYSTALPROCESSOR = addItem(54, "processor.crystal");
        GAMetaItems.INTEGRATED_PROCESSOR = addItem(55, "processor.integrated");
        GAMetaItems.NANOPROCESSOR = addItem(56, "processor.nano");
        GAMetaItems.QUANTUMPROCESSOR = addItem(57, "processor.quantum");
        GAMetaItems.WETWAREPROCESSOR = addItem(68, "processor.wetware");
        GAMetaItems.ASOC_WAFER = addItem(59, "wafer.asoc");
        GAMetaItems.LOGIC_CIRCUIT_WAFER = addItem(60, "wafer.circuit");
        GAMetaItems.CPU_WAFER = addItem(61, "wafer.cpu");
        GAMetaItems.GLOWSTONE_WAFER = addItem(62, "wafer.glowstone");
        GAMetaItems.HPIC_WAFER = addItem(63, "wafer.hpic");
        GAMetaItems.NAND_WAFER = addItem(64, "wafer.nand");
        GAMetaItems.NANOCPU_WAFER = addItem(65, "wafer.nanocpu");
        GAMetaItems.NAQUADAH_WAFER = addItem(66, "wafer.naquadah");
        GAMetaItems.NOR_WAFER = addItem(67, "wafer.nor");
        GAMetaItems.PIC_WAFER = addItem(68, "wafer.pic");
        GAMetaItems.QBIT_CPU_WAFER = addItem(69, "wafer.qbit");
        GAMetaItems.RAM_WAFER = addItem(70, "wafer.ram");
        GAMetaItems.SILICON_WAFER = addItem(71, "wafer.silicon");
        GAMetaItems.SOC_WAFER = addItem(72, "wafer.soc");
}

    public void registerRecipes() {
    }
}
