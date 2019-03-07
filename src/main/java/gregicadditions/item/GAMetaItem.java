package gregicadditions.item;

import org.apache.commons.lang3.ArrayUtils;

import gregicadditions.GAConfig;
import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.stats.IMetaItemStats;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class GAMetaItem extends MaterialMetaItem {

	public GAMetaItem() {
		super(OrePrefix.valueOf("plateCurved"), OrePrefix.valueOf("ingotDouble"), OrePrefix.valueOf("round"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	@Override
	public void registerSubItems() {
		GAMetaItems.COATED_BOARD = addItem(3, "board.coated");
		GAMetaItems.EPOXY_BOARD = addItem(4, "board.epoxy");
		GAMetaItems.FIBER_BOARD = addItem(5, "board.fiber-reinforced");
		GAMetaItems.MULTILAYER_FIBER_BOARD = addItem(6, "board.multilayer.fiber-reinforced");
		GAMetaItems.PHENOLIC_BOARD = addItem(7, "board.phenolic");
		GAMetaItems.PLASTIC_BOARD = addItem(8, "board.plastic");
		GAMetaItems.WETWARE_BOARD = addItem(9, "board.wetware");
		GAMetaItems.GLOWSTONE_BOULE = addItem(10, "boule.glowstone");
		GAMetaItems.NAQUADAH_BOULE = addItem(11, "boule.naquadah");
		GAMetaItems.SILICON_BOULE = addItem(12, "boule.silicon");
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
		GAMetaItems.ACACIA_FORM = addItem(72, "form.acacia").addOreDict("formWood").setMaxStackSize(1);
		GAMetaItems.BIRCH_FORM = addItem(73, "form.birch").addOreDict("formWood").setMaxStackSize(1);
		GAMetaItems.DARK_OAK_FORM = addItem(74, "form.darkoak").addOreDict("formWood").setMaxStackSize(1);
		GAMetaItems.JUNGLE_FORM = addItem(75, "form.jungle").addOreDict("formWood").setMaxStackSize(1);
		GAMetaItems.OAK_FORM = addItem(76, "form.oak").addOreDict("formWood").setMaxStackSize(1);
		GAMetaItems.SPRUCE_FORM = addItem(77, "form.spruce").addOreDict("formWood").setMaxStackSize(1);
		GAMetaItems.RAW_CARBON_FIBERS = addItem(79, "carbon.fibers");
		GAMetaItems.RAW_CRYSTAL_CHIP = addItem(82, "crystal.raw");
		GAMetaItems.CRYSTAL_CPU = addItem(83, "crystal.cpu");
		GAMetaItems.CRYSTAL_SOC = addItem(84, "crystal.soc");
		GAMetaItems.STEMCELLS = addItem(85, "stemcells");
		GAMetaItems.LAPOTRON_CRYSTAL = addItem(104, "crystal.lapotron").addStats(new IMetaItemStats[] { ElectricStats.createRechargeableBattery(10000000L, 4) }).setModelAmount(8);
		GAMetaItems.PLATE_IRIDIUM_ALLOY = addItem(105, "plate.iridium.alloy");
		GAMetaItems.PLATE_IRIDIUM_ALLOY_UNCOMPRESSED = addItem(106, "plate.iridium.alloy.uncompressed");
		GAMetaItems.NEUTRON_REFLECTOR = addItem(107, "neutron.reflector");

		if (Loader.isModLoaded("forestry") && GAConfig.GT6.electrodes) {
			GAMetaItems.ELECTRODE_APATITE = addItem(108, "electrode.apatite");
			GAMetaItems.ELECTRODE_BLAZE = addItem(109, "electrode.blaze");
			GAMetaItems.ELECTRODE_BRONZE = addItem(110, "electrode.bronze");
			GAMetaItems.ELECTRODE_COPPER = addItem(111, "electrode.copper");
			GAMetaItems.ELECTRODE_DIAMOND = addItem(112, "electrode.diamond");
			GAMetaItems.ELECTRODE_EMERALD = addItem(113, "electrode.emerald");
			GAMetaItems.ELECTRODE_ENDER = addItem(114, "electrode.ender");
			GAMetaItems.ELECTRODE_GOLD = addItem(115, "electrode.gold");
			if (Loader.isModLoaded("ic2") || Loader.isModLoaded("binniecore")) GAMetaItems.ELECTRODE_IRON = addItem(116, "electrode.iron");
			GAMetaItems.ELECTRODE_LAPIS = addItem(117, "electrode.lapis");
			GAMetaItems.ELECTRODE_OBSIDIAN = addItem(118, "electrode.obsidian");
			if (Loader.isModLoaded("extrautils2")) GAMetaItems.ELECTRODE_ORCHID = addItem(119, "electrode.orchid");
			if (Loader.isModLoaded("ic2") || Loader.isModLoaded("techreborn") || Loader.isModLoaded("binniecore")) GAMetaItems.ELECTRODE_RUBBER = addItem(120, "electrode.rubber");
			GAMetaItems.ELECTRODE_TIN = addItem(121, "electrode.tin");
		}

		if (GAConfig.GT5U.enableZPMandUVBats) {
			GAMetaItems.ENERGY_MODULE = addItem(122, "energy.module").addStats(new IMetaItemStats[] { ElectricStats.createRechargeableBattery(10000000000L, 7) }).setModelAmount(8);
			GAMetaItems.ENERGY_CLUSTER = addItem(123, "energy.cluster").addStats(new IMetaItemStats[] { ElectricStats.createRechargeableBattery(100000000000L, 8) }).setModelAmount(8);
		}

		if (GAConfig.GT5U.replaceUVwithMAXBat) {
			GAMetaItems.MAX_BATTERY = addItem(124, "max.battery").addStats(new IMetaItemStats[] { ElectricStats.createRechargeableBattery(9223372036854775807L, 9) }).setModelAmount(8);
			MetaItems.ZPM2.setInvisible();
		}

		GAMetaItems.PLANK_OAK = addItem(125, "plank.oak").setBurnValue(75);
		GAMetaItems.PLANK_SPRUCE = addItem(126, "plank.spruce").setBurnValue(75);
		GAMetaItems.PLANK_BIRCH = addItem(127, "plank.birch").setBurnValue(75);
		GAMetaItems.PLANK_JUNGLE = addItem(128, "plank.jungle").setBurnValue(75);
		GAMetaItems.PLANK_ACACIA = addItem(129, "plank.acacia").setBurnValue(75);
		GAMetaItems.PLANK_DARKOAK = addItem(130, "plank.darkoak").setBurnValue(75);

		GAMetaItems.SCHEMATIC = addItem(131, "schematic").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.StainlessSteel, 7257600L)));
		GAMetaItems.SCHEMATIC_2X2 = addItem(132, "schematic.2by2").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.StainlessSteel, 7257600L)));
		GAMetaItems.SCHEMATIC_3X3 = addItem(133, "schematic.3by3").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.StainlessSteel, 7257600L)));
		GAMetaItems.SCHEMATIC_DUST = addItem(134, "schematic.dust").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.StainlessSteel, 7257600L)));
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {

		int[] idsToKeepInGrid = new int[] { GAMetaItems.ACACIA_FORM.getStackForm().getMetadata(), GAMetaItems.BIRCH_FORM.getStackForm().getMetadata(), GAMetaItems.DARK_OAK_FORM.getStackForm().getMetadata(), GAMetaItems.JUNGLE_FORM.getStackForm().getMetadata(), GAMetaItems.OAK_FORM.getStackForm().getMetadata(), GAMetaItems.SPRUCE_FORM.getStackForm().getMetadata() };

		return ArrayUtils.contains(idsToKeepInGrid, stack.getMetadata());
	}

	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		return stack.copy();
	}
}
