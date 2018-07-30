package gregicadditions.recipes;

import gregicadditions.GAMaterials;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMetaItems;
import gregicadditions.item.GATransparentCasing;
import gregicadditions.machines.GATileEntities;
import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType;
import gregtech.common.blocks.BlockMachineCasing.MachineCasingType;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.load.MetaTileEntityLoader.Type;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

import static gregtech.api.GTValues.W;

public class MachineCraftingRecipes {

    private static String[] tiers = {
            "lv",
            "mv",
            "hv",
            "ev"
    };

    public static void init() {
        //Removal
        for (String tier : tiers) {
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.alloy_smelter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.assembler." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.bender." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.canner." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.compressor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.cutter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.electric_furnace." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.extractor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.extruder." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.lathe." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.macerator." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.microwave." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.wiremill." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.centrifuge." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.electrolyzer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.thermal_centrifuge." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.ore_washer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.packer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.unpacker." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.chemical_reactor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid_canner." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.brewery." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fermenter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid_extractor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid_solidifier." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.distillery." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.chemical_bath." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.polarizor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.electromagnetic_separator." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.autoclave." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.mixer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.laser_engraver." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.forming_press." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.forge_hammer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid_heater." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.sifter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.arc_furnace." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.plasma_arc_furnace." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.pump." + tier));
        }
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.pump.iv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.pump.luv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_boiler_solar_bronze"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_furnace_bronze"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_furnace_steel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_macerator_bronze"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_macerator_steel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_extractor_bronze"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_extractor_steel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_hammer_bronze"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_hammer_steel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_compressor_bronze"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_compressor_steel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_alloy_smelter_bronze"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_alloy_smelter_steel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:bronze_primitive_blast_furnace"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:electric_blast_furnace"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:vacuum_freezer"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:implosion_compressor"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:distillation_tower"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:cracking_unit"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:pyroyise_oven"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:diesel_engine"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:engine_intake_casing"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:multi_furnace"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_steam_boiler"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_gas_turbine"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_plasma_turbine"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_bronze_boiler"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_steel_boiler"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_titanium_boiler"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_tungstensteel_boiler"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:diesel_generator_lv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gas_turbine_lv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_turbine_lv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:diesel_generator_mv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gas_turbine_mv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_turbine_mv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:diesel_generator_hv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gas_turbine_hv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:steam_turbine_hv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:magic_energy_absorber"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_ulv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_lv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_mv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_hv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_ev"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_iv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_luv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_zpm"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_uv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:charger_max"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:transformer_ev"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:transformer_iv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:transformer_luv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:transformer_zpm"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:transformer_uv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:transformer_max"));

        //Casing
        ModHandler.addShapedRecipe("ga_casing_bronze_pipe", MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.BRONZE_PIPE, 2), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Bronze), 'I', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Bronze));
        ModHandler.addShapedRecipe("ga_casing_steel_pipe", MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.STEEL_PIPE, 2), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'I', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Steel));
        ModHandler.addShapedRecipe("ga_casing_titanium_pipe", MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.TITANIUM_PIPE, 2), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium), 'I', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Titanium));
        ModHandler.addShapedRecipe("ga_casing_tungstensteel_pipe", MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.TUNGSTENSTEEL_PIPE, 2), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel), 'I', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.TungstenSteel));

        //Power Manipulation Machines
        ModHandler.addShapedRecipe("ga_charger_ulv", MetaTileEntities.CHARGER[GTValues.ULV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.ULV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Lead), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_ULV_TANTALUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Primitive));
        ModHandler.addShapedRecipe("ga_charger_lv", MetaTileEntities.CHARGER[GTValues.LV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Tin), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_LV_LITHIUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic));
        ModHandler.addShapedRecipe("ga_charger_mv", MetaTileEntities.CHARGER[GTValues.MV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Copper), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_MV_LITHIUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good));
        ModHandler.addShapedRecipe("ga_charger_hv", MetaTileEntities.CHARGER[GTValues.HV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Gold), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_HV_LITHIUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced));
        ModHandler.addShapedRecipe("ga_charger_ev", MetaTileEntities.CHARGER[GTValues.EV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Aluminium), 'T', OreDictNames.chestWood, 'B', new UnificationEntry(OrePrefix.battery, Tier.Master), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme));
        ModHandler.addShapedRecipe("ga_charger_iv", MetaTileEntities.CHARGER[GTValues.IV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Tungsten), 'T', OreDictNames.chestWood, 'B', MetaItems.ENERGY_LAPOTRONIC_ORB, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite));
        ModHandler.addShapedRecipe("ga_charger_luv", MetaTileEntities.CHARGER[GTValues.LuV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.VanadiumGallium), 'T', OreDictNames.chestWood, 'B', MetaItems.ENERGY_LAPOTRONIC_ORB2, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Master));
        ModHandler.addShapedRecipe("ga_charger_zpm", MetaTileEntities.CHARGER[GTValues.ZPM].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.ZPM].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Naquadah), 'T', OreDictNames.chestWood, 'B', MetaItems.ENERGY_LAPOTRONIC_ORB2, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Ultimate));
        ModHandler.addShapedRecipe("ga_charger_uv", MetaTileEntities.CHARGER[GTValues.UV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.NaquadahAlloy), 'T', OreDictNames.chestWood, 'B', MetaItems.ZPM2, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Superconductor));
        ModHandler.addShapedRecipe("ga_charger_max", MetaTileEntities.CHARGER[GTValues.MAX].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.MAX].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Tier.Superconductor), 'T', OreDictNames.chestWood, 'B', MetaItems.ZPM2, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Infinite));

        ModHandler.addShapedRecipe("ga_transformer_ev", MetaTileEntities.TRANSFORMER[GTValues.EV - 1].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'K', GAMetaItems.SMALL_COIL);
        ModHandler.addShapedRecipe("ga_transformer_iv", MetaTileEntities.TRANSFORMER[GTValues.IV - 1].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'K', GAMetaItems.SMALL_COIL);
        ModHandler.addShapedRecipe("ga_transformer_luv", MetaTileEntities.TRANSFORMER[GTValues.LuV - 1].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten), 'K', GAMetaItems.PIC);
        ModHandler.addShapedRecipe("ga_transformer_zpm", MetaTileEntities.TRANSFORMER[GTValues.ZPM - 1].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Naquadah), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium), 'K', GAMetaItems.PIC);
        ModHandler.addShapedRecipe("ga_transformer_uv", MetaTileEntities.TRANSFORMER[GTValues.UV - 1].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.ZPM].getStackForm(), 'C', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Naquadah), 'K', GAMetaItems.HPIC);
        ModHandler.addShapedRecipe("ga_transformer_max", MetaTileEntities.TRANSFORMER[GTValues.MAX - 1].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', new UnificationEntry(OrePrefix.wireGtSingle, Tier.Superconductor), 'B', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy), 'K', GAMetaItems.HPIC);

        //Steam Machines
        ModHandler.addShapedRecipe("ga_steam_boiler_solar_bronze", MetaTileEntities.STEAM_BOILER_SOLAR_BRONZE.getStackForm(), "GGG", "SSS", "PMP", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.BRONZE_BRICKS_HULL), 'P', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Bronze), 'S', new UnificationEntry(OrePrefix.plate, Materials.Silver), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("ga_steam_furnace_bronze", MetaTileEntities.STEAM_FURNACE_BRONZE.getStackForm(), "XXX", "XMX", "XFX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.BRONZE_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Bronze), 'F', OreDictNames.craftingFurnace);
        ModHandler.addShapedRecipe("ga_steam_furnace_steel", MetaTileEntities.STEAM_FURNACE_STEEL.getStackForm(), "XXX", "XMX", "XFX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.STEEL_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Steel), 'F', OreDictNames.craftingFurnace);
        ModHandler.addShapedRecipe("ga_steam_macerator_bronze", MetaTileEntities.STEAM_MACERATOR_BRONZE.getStackForm(), "DXD", "XMX", "PXP", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Bronze), 'P', OreDictNames.craftingPiston, 'D', new ItemStack(Items.FLINT));
        ModHandler.addShapedRecipe("ga_steam_macerator_steel", MetaTileEntities.STEAM_MACERATOR_STEEL.getStackForm(), "DXD", "XMX", "PXP", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Steel), 'P', OreDictNames.craftingPiston, 'D', new ItemStack(Items.FLINT));
        ModHandler.addShapedRecipe("ga_steam_extractor_bronze", MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm(), "XXX", "PMG", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Bronze), 'P', OreDictNames.craftingPiston, 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("ga_steam_extractor_steel", MetaTileEntities.STEAM_EXTRACTOR_STEEL.getStackForm(), "XXX", "PMG", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Steel), 'P', OreDictNames.craftingPiston, 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("ga_steam_hammer_bronze", MetaTileEntities.STEAM_HAMMER_BRONZE.getStackForm(), "XPX", "XMX", "XAX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Bronze), 'P', OreDictNames.craftingPiston, 'A', OreDictNames.craftingAnvil);
        ModHandler.addShapedRecipe("ga_steam_hammer_steel", MetaTileEntities.STEAM_HAMMER_STEEL.getStackForm(), "XPX", "XMX", "XAX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Steel), 'P', OreDictNames.craftingPiston, 'A', OreDictNames.craftingAnvil);
        ModHandler.addShapedRecipe("ga_steam_compressor_bronze", MetaTileEntities.STEAM_COMPRESSOR_BRONZE.getStackForm(), "XXX", "PMP", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Bronze), 'P', OreDictNames.craftingPiston);
        ModHandler.addShapedRecipe("ga_steam_compressor_steel", MetaTileEntities.STEAM_COMPRESSOR_STEEL.getStackForm(), "XXX", "PMP", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Steel), 'P', OreDictNames.craftingPiston);
        ModHandler.addShapedRecipe("ga_steam_alloy_smelter_bronze", MetaTileEntities.STEAM_ALLOY_SMELTER_BRONZE.getStackForm(), "XXX", "FMF", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.BRONZE_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Bronze), 'F', OreDictNames.craftingFurnace);
        ModHandler.addShapedRecipe("ga_steam_alloy_smelter_steel", MetaTileEntities.STEAM_ALLOY_SMELTER_STEEL.getStackForm(), "XXX", "FMF", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.STEEL_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.valueOf("pipeGaSmall"), Materials.Steel), 'F', OreDictNames.craftingFurnace);

        //MultiBlock Controllers
        ModHandler.addShapedRecipe("ga_primitive_blast_furnace", MetaTileEntities.PRIMITIVE_BLAST_FURNACE.getStackForm(), "BBB", "BPB", "BBB", 'B', GAMetaItems.FIRECLAY_BRICK.getStackForm(), 'P', OreDictUnifier.get(OrePrefix.plate, Materials.Iron));
        ModHandler.addShapedRecipe("ga_electric_blast_furnace", MetaTileEntities.ELECTRIC_BLAST_FURNACE.getStackForm(), "FFF", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF), 'F', OreDictNames.craftingFurnace, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("ga_vacuum_freezer", MetaTileEntities.VACUUM_FREEZER.getStackForm(), "PPP", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.ALUMINIUM_FROSTPROOF), 'P', MetaItems.ELECTRIC_PUMP_HV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));
        ModHandler.addShapedRecipe("ga_implosion_compressor", MetaTileEntities.IMPLOSION_COMPRESSOR.getStackForm(), "OOO", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID), 'O', new UnificationEntry(OrePrefix.stone, Materials.Obsidian), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium));
        ModHandler.addShapedRecipe("ga_distillation_tower", GATileEntities.DISTILL_TOWER.getStackForm(), "CBC", "FMF", "CBC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MachineCasingType.EV), 'B', new UnificationEntry(OrePrefix.valueOf("pipeGaLarge"), Materials.StainlessSteel), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme), 'F', MetaItems.ELECTRIC_PUMP_EV);
        ModHandler.addShapedRecipe("ga_cracking_unit", MetaTileEntities.CRACKER.getStackForm(), "CEC", "PHP", "CEC", 'C', MetaBlocks.WIRE_COIL.getItemVariant(CoilType.CUPRONICKEL), 'E', MetaItems.ELECTRIC_PUMP_HV, 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'H', MetaTileEntities.HULL[GTValues.HV].getStackForm());
        ModHandler.addShapedRecipe("ga_pyrolyse_oven", MetaTileEntities.PYROLYSE_OVEN.getStackForm(), "WEP", "EME", "WCP", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', MetaItems.ELECTRIC_PISTON_MV, 'P', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Cupronickel), 'E', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'C', MetaItems.ELECTRIC_PUMP_MV);
        ModHandler.addShapedRecipe("ga_diesel_engine", MetaTileEntities.DIESEL_ENGINE.getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_EV, 'E', MetaItems.ELECTRIC_MOTOR_EV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.TungstenSteel), 'G', new UnificationEntry(OrePrefix.gear, Materials.Titanium));
        ModHandler.addShapedRecipe("ga_engine_intake_casing", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ENGINE_INTAKE_CASING), "PhP", "RFR", "PwP", 'R', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Titanium), 'F', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.TITANIUM_STABLE), 'P', new UnificationEntry(OrePrefix.rotor, Materials.Titanium));
        ModHandler.addShapedRecipe("ga_multi_furnace", MetaTileEntities.MULTI_FURNACE.getStackForm(), "PPP", "ASA", "CAC", 'P', Blocks.FURNACE, 'A', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'S', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.AnnealedCopper));
        ModHandler.addShapedRecipe("ga_large_steam_turbine", MetaTileEntities.LARGE_STEAM_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.Steel), 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'A', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', OreDictUnifier.get(OrePrefix.valueOf("pipeGaLarge"), Materials.Steel));
        ModHandler.addShapedRecipe("ga_large_gas_turbine", MetaTileEntities.LARGE_GAS_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.StainlessSteel), 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme), 'A', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', OreDictUnifier.get(OrePrefix.valueOf("pipeGaLarge"), Materials.StainlessSteel));
        ModHandler.addShapedRecipe("ga_large_plasma_turbine", MetaTileEntities.LARGE_PLASMA_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.TungstenSteel), 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Master), 'A', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', OreDictUnifier.get(OrePrefix.valueOf("pipeGaLarge"), Materials.TungstenSteel));
        ModHandler.addShapedRecipe("ga_large_bronze_boiler", MetaTileEntities.LARGE_BRONZE_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.BRONZE_FIREBOX));
        ModHandler.addShapedRecipe("ga_large_steel_boiler", MetaTileEntities.LARGE_STEEL_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.STEEL_FIREBOX));
        ModHandler.addShapedRecipe("ga_large_titanium_boiler", MetaTileEntities.LARGE_TITANIUM_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.TITANIUM_FIREBOX));
        ModHandler.addShapedRecipe("ga_large_tungstensteel_boiler", MetaTileEntities.LARGE_TUNGSTENSTEEL_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Master), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BoilerCasingType.TUNGSTENSTEEL_FIREBOX));
        ModHandler.addShapedRecipe("ga_assline", GATileEntities.ASSEMBLY_LINE.getStackForm(), "CRC", "SAS", "CRC", 'A', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'R', MetaItems.ROBOT_ARM_IV, 'C', MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite));

        //Generators
        registerMachineRecipe(GATileEntities.NAQUADAH_REACTOR, "RCR", "FMF", "QCQ", 'M', Type.HULL, 'Q', Type.CABLE_QUAD, 'C', Type.BETTER_CIRCUIT, 'F', Type.FIELD_GENERATOR, 'R', Type.valueOf("STICK_RADIOACTIVE"));
        ModHandler.addShapedRecipe("ga_diesel_generator_lv", MetaTileEntities.DIESEL_GENERATOR[0].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_LV, 'E', MetaItems.ELECTRIC_MOTOR_LV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'G', new UnificationEntry(OrePrefix.gear, Materials.Steel));
        ModHandler.addShapedRecipe("ga_diesel_generator_mv", MetaTileEntities.DIESEL_GENERATOR[1].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_MV, 'E', MetaItems.ELECTRIC_MOTOR_MV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'G', new UnificationEntry(OrePrefix.gear, Materials.Aluminium));
        ModHandler.addShapedRecipe("ga_diesel_generator_hv", MetaTileEntities.DIESEL_GENERATOR[2].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_HV, 'E', MetaItems.ELECTRIC_MOTOR_HV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'G', new UnificationEntry(OrePrefix.gear, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("ga_gas_turbine_lv", MetaTileEntities.GAS_TURBINE[0].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_LV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Tin), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("ga_gas_turbine_mv", MetaTileEntities.GAS_TURBINE[1].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_MV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper));
        ModHandler.addShapedRecipe("ga_gas_turbine_hv", MetaTileEntities.GAS_TURBINE[2].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_HV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Steel), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));
        ModHandler.addShapedRecipe("ga_steam_turbine_lv", MetaTileEntities.STEAM_TURBINE[0].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_LV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Tin), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'P', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Bronze));
        ModHandler.addShapedRecipe("ga_steam_turbine_mv", MetaTileEntities.STEAM_TURBINE[1].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_MV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'P', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Steel));
        ModHandler.addShapedRecipe("ga_steam_turbine_hv", MetaTileEntities.STEAM_TURBINE[2].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_HV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Steel), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'P', new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.StainlessSteel));
        ModHandler.addShapedRecipe("ga_magic_energy_absorber", MetaTileEntities.MAGIC_ENERGY_ABSORBER.getStackForm(), "PCP", "PMP", "PCP", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'P', MetaItems.SENSOR_EV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite));
        if (MetaTileEntities.MAGIC_ENERGY_CONVERTER != null) {
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:magic_energy_converter"));
            ModHandler.addShapedRecipe("ga_magic_energy_converter", MetaTileEntities.MAGIC_ENERGY_CONVERTER.getStackForm(), "PCP", "SMS", "PCP", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'P', MetaItems.ELECTRIC_PUMP_MV, 'S', MetaItems.SENSOR_MV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good));
        }

        registerMachineRecipe(GATileEntities.CLUSTERMILL, "MMM", "CHC", "MMM", 'M', Type.MOTOR, 'C', Type.CIRCUIT, 'H', Type.HULL);
        registerMachineRecipe(GATileEntities.CIRCUITASSEMBLER, "ACE", "VMV", "WCW", 'M', Type.HULL, 'V', Type.CONVEYOR, 'A', Type.ROBOT_ARM, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'E', Type.EMITTER);
        registerMachineRecipe(MetaTileEntities.ALLOY_SMELTER, "ECE", "CMC", "WCW", 'M', Type.HULL, 'E', Type.CIRCUIT, 'W', Type.CABLE, 'C', Type.COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.ASSEMBLER, "ACA", "VMV", "WCW", 'M', Type.HULL, 'V', Type.CONVEYOR, 'A', Type.ROBOT_ARM, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.BENDER, "PwP", "CMC", "EWE", 'M', Type.HULL, 'E', Type.MOTOR, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.CANNER, "WPW", "CMC", "GGG", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.COMPRESSOR, " C ", "PMP", "WCW", 'M', Type.HULL, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.CUTTER, "WCG", "VMB", "CWE", 'M', Type.HULL, 'E', Type.MOTOR, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS, 'B', OreDictNames.craftingDiamondBlade);
        registerMachineRecipe(MetaTileEntities.ELECTRIC_FURNACE, "ECE", "CMC", "WCW", 'M', Type.HULL, 'E', Type.CIRCUIT, 'W', Type.CABLE, 'C', Type.COIL_HEATING);
        registerMachineRecipe(MetaTileEntities.EXTRACTOR, "GCG", "EMP", "WCW", 'M', Type.HULL, 'E', Type.PISTON, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.EXTRUDER, "CCE", "XMP", "CCE", 'M', Type.HULL, 'X', Type.PISTON, 'E', Type.CIRCUIT, 'P', Type.PIPE, 'C', Type.COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.LATHE, "WCW", "EMD", "CWP", 'M', Type.HULL, 'E', Type.MOTOR, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'D', Type.DIAMOND);
        registerMachineRecipe(MetaTileEntities.MACERATOR, "PEG", "WWM", "CCW", 'M', Type.HULL, 'E', Type.MOTOR, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GRINDER);
        registerMachineRecipe(MetaTileEntities.MICROWAVE, "LWC", "LMR", "LEC", 'M', Type.HULL, 'E', Type.MOTOR, 'R', Type.EMITTER, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'L', new UnificationEntry(OrePrefix.plate, Materials.Lead));
        registerMachineRecipe(MetaTileEntities.WIREMILL, "EWE", "CMC", "EWE", 'M', Type.HULL, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.CENTRIFUGE, "CEC", "WMW", "CEC", 'M', Type.HULL, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.ELECTROLYZER, "IGI", "IMI", "CWC", 'M', Type.HULL, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'I', Type.WIRE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.THERMAL_CENTRIFUGE, "CEC", "OMO", "WEW", 'M', Type.HULL, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'O', Type.COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.ORE_WASHER, "RGR", "CEC", "WMW", 'M', Type.HULL, 'R', Type.ROTOR, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.PACKER, "BCB", "RMV", "WCW", 'M', Type.HULL, 'R', Type.ROBOT_ARM, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(MetaTileEntities.UNPACKER, "BCB", "VMR", "WCW", 'M', Type.HULL, 'R', Type.ROBOT_ARM, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(MetaTileEntities.CHEMICAL_REACTOR, "GRG", "WEW", "CMC", 'M', Type.HULL, 'R', Type.ROTOR, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.FLUID_CANNER, "GCG", "GMG", "WPW", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.BREWERY, "GPG", "WMW", "CBC", 'M', Type.HULL, 'P', MetaItems.ELECTRIC_PUMP_LV, 'B', Type.STICK_DISTILLATION, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', new ItemStack(Blocks.GLASS));
        registerMachineRecipe(MetaTileEntities.FERMENTER, "WPW", "GMG", "WCW", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.FLUID_EXTRACTOR, "GCG", "PME", "WCW", 'M', Type.HULL, 'E', Type.PISTON, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.FLUID_SOLIDIFIER, "PGP", "WMW", "CBC", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS, 'B', OreDictNames.chestWood);
        registerMachineRecipe(MetaTileEntities.DISTILLERY, "GBG", "CMC", "WPW", 'M', Type.HULL, 'P', Type.PUMP, 'B', Type.STICK_DISTILLATION, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.CHEMICAL_BATH, "VGW", "PGV", "CMC", 'M', Type.HULL, 'P', Type.PUMP, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.POLARIZER, "ZSZ", "WMW", "ZSZ", 'M', Type.HULL, 'S', Type.STICK_ELECTROMAGNETIC, 'Z', Type.COIL_ELECTRIC, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.ELECTROMAGNETIC_SEPARATOR, "VWZ", "WMS", "CWZ", 'M', Type.HULL, 'S', Type.STICK_ELECTROMAGNETIC, 'Z', Type.COIL_ELECTRIC, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.AUTOCLAVE, "IGI", "IMI", "CPC", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'I', Type.PLATE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.MIXER, "GRG", "GEG", "CMC", 'M', Type.HULL, 'E', Type.MOTOR, 'R', Type.ROTOR, 'C', Type.CIRCUIT, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.LASER_ENGRAVER, "PEP", "CMC", "WCW", 'M', Type.HULL, 'E', Type.EMITTER, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.FORMING_PRESS, "WPW", "CMC", "WPW", 'M', Type.HULL, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.FORGE_HAMMER, "WPW", "CMC", "WAW", 'M', Type.HULL, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'A', OreDictNames.craftingAnvil);
        registerMachineRecipe(MetaTileEntities.FLUID_HEATER, "OGO", "PMP", "WCW", 'M', Type.HULL, 'P', Type.PUMP, 'O', Type.COIL_HEATING_DOUBLE, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(MetaTileEntities.SIFTER, "WFW", "PMP", "CFC", 'M', Type.HULL, 'P', Type.PISTON, 'F', OreDictNames.craftingFilter, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(MetaTileEntities.ARC_FURNACE, "WGW", "CMC", "PPP", 'M', Type.HULL, 'P', Type.PLATE, 'C', Type.CIRCUIT, 'W', Type.CABLE_QUAD, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(MetaTileEntities.PLASMA_ARC_FURNACE, "WGW", "CMC", "TPT", 'M', Type.HULL, 'P', Type.PLATE, 'C', Type.BETTER_CIRCUIT, 'W', Type.CABLE_QUAD, 'T', Type.PUMP, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(MetaTileEntities.PUMP, "WGW", "GMG", "TGT", 'M', Type.HULL, 'W', Type.CIRCUIT, 'G', Type.PUMP, 'T', Type.PIPE);
        registerMachineRecipe(GATileEntities.ALLOY_SMELTER, "ECE", "CMC", "WCW", 'M', Type.HULL, 'E', Type.CIRCUIT, 'W', Type.CABLE, 'C', Type.COIL_HEATING_DOUBLE);
        registerMachineRecipe(GATileEntities.ASSEMBLER, "ACA", "VMV", "WCW", 'M', Type.HULL, 'V', Type.CONVEYOR, 'A', Type.ROBOT_ARM, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.BENDER, "PWP", "CMC", "EWE", 'M', Type.HULL, 'E', Type.MOTOR, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.CANNER, "WPW", "CMC", "GGG", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.COMPRESSOR, " C ", "PMP", "WCW", 'M', Type.HULL, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.CUTTER, "WCG", "VMB", "CWE", 'M', Type.HULL, 'E', Type.MOTOR, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS, 'B', OreDictNames.craftingDiamondBlade);
        registerMachineRecipe(GATileEntities.ELECTRIC_FURNACE, "ECE", "CMC", "WCW", 'M', Type.HULL, 'E', Type.CIRCUIT, 'W', Type.CABLE, 'C', Type.COIL_HEATING);
        registerMachineRecipe(GATileEntities.EXTRACTOR, "GCG", "EMP", "WCW", 'M', Type.HULL, 'E', Type.PISTON, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.EXTRUDER, "CCE", "XMP", "CCE", 'M', Type.HULL, 'X', Type.PISTON, 'E', Type.CIRCUIT, 'P', Type.PIPE, 'C', Type.COIL_HEATING_DOUBLE);
        registerMachineRecipe(GATileEntities.LATHE, "WCW", "EMD", "CWP", 'M', Type.HULL, 'E', Type.MOTOR, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'D', Type.DIAMOND);
        registerMachineRecipe(GATileEntities.MACERATOR, "PEG", "WWM", "CCW", 'M', Type.HULL, 'E', Type.MOTOR, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GRINDER);
        registerMachineRecipe(GATileEntities.MICROWAVE, "LWC", "LMR", "LEC", 'M', Type.HULL, 'E', Type.MOTOR, 'R', Type.EMITTER, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'L', new UnificationEntry(OrePrefix.plate, Materials.Lead));
        registerMachineRecipe(GATileEntities.WIREMILL, "EWE", "CMC", "EWE", 'M', Type.HULL, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.CENTRIFUGE, "CEC", "WMW", "CEC", 'M', Type.HULL, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.ELECTROLYZER, "IGI", "IMI", "CWC", 'M', Type.HULL, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'I', Type.WIRE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.THERMAL_CENTRIFUGE, "CEC", "OMO", "WEW", 'M', Type.HULL, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'O', Type.COIL_HEATING_DOUBLE);
        registerMachineRecipe(GATileEntities.ORE_WASHER, "RGR", "CEC", "WMW", 'M', Type.HULL, 'R', Type.ROTOR, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.PACKER, "BCB", "RMV", "WCW", 'M', Type.HULL, 'R', Type.ROBOT_ARM, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(GATileEntities.UNPACKER, "BCB", "VMR", "WCW", 'M', Type.HULL, 'R', Type.ROBOT_ARM, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(GATileEntities.CHEMICAL_REACTOR, "GRG", "WEW", "CMC", 'M', Type.HULL, 'R', Type.ROTOR, 'E', Type.MOTOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.FLUID_CANNER, "GCG", "GMG", "WPW", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.BREWERY, "GPG", "WMW", "CBC", 'M', Type.HULL, 'P', MetaItems.ELECTRIC_PUMP_LV, 'B', Type.STICK_DISTILLATION, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', new ItemStack(Blocks.GLASS));
        registerMachineRecipe(GATileEntities.FERMENTER, "WPW", "GMG", "WCW", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.FLUID_EXTRACTOR, "GCG", "PME", "WCW", 'M', Type.HULL, 'E', Type.PISTON, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.FLUID_SOLIDIFIER, "PGP", "WMW", "CBC", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS, 'B', OreDictNames.chestWood);
        registerMachineRecipe(GATileEntities.DISTILLERY, "GBG", "CMC", "WPW", 'M', Type.HULL, 'P', Type.PUMP, 'B', Type.STICK_DISTILLATION, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.CHEMICAL_BATH, "VGW", "PGV", "CMC", 'M', Type.HULL, 'P', Type.PUMP, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.POLARIZER, "ZSZ", "WMW", "ZSZ", 'M', Type.HULL, 'S', Type.STICK_ELECTROMAGNETIC, 'Z', Type.COIL_ELECTRIC, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.ELECTROMAGNETIC_SEPARATOR, "VWZ", "WMS", "CWZ", 'M', Type.HULL, 'S', Type.STICK_ELECTROMAGNETIC, 'Z', Type.COIL_ELECTRIC, 'V', Type.CONVEYOR, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.AUTOCLAVE, "IGI", "IMI", "CPC", 'M', Type.HULL, 'P', Type.PUMP, 'C', Type.CIRCUIT, 'I', Type.PLATE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.MIXER, "GRG", "GEG", "CMC", 'M', Type.HULL, 'E', Type.MOTOR, 'R', Type.ROTOR, 'C', Type.CIRCUIT, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.LASER_ENGRAVER, "PEP", "CMC", "WCW", 'M', Type.HULL, 'E', Type.EMITTER, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.FORMING_PRESS, "WPW", "CMC", "WPW", 'M', Type.HULL, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.FORGE_HAMMER, "WPW", "CMC", "WAW", 'M', Type.HULL, 'P', Type.PISTON, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'A', OreDictNames.craftingAnvil);
        registerMachineRecipe(GATileEntities.FLUID_HEATER, "OGO", "PMP", "WCW", 'M', Type.HULL, 'P', Type.PUMP, 'O', Type.COIL_HEATING_DOUBLE, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'G', Type.GLASS);
        registerMachineRecipe(GATileEntities.SIFTER, "WFW", "PMP", "CFC", 'M', Type.HULL, 'P', Type.PISTON, 'F', OreDictNames.craftingFilter, 'C', Type.CIRCUIT, 'W', Type.CABLE);
        registerMachineRecipe(GATileEntities.ARC_FURNACE, "WGW", "CMC", "PPP", 'M', Type.HULL, 'P', Type.PLATE, 'C', Type.CIRCUIT, 'W', Type.CABLE_QUAD, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(GATileEntities.PLASMA_ARC_FURNACE, "WGW", "CMC", "TPT", 'M', Type.HULL, 'P', Type.PLATE, 'C', Type.BETTER_CIRCUIT, 'W', Type.CABLE_QUAD, 'T', Type.PUMP, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(GATileEntities.MASS_FAB, "CFC", "QMQ", "CFC", 'M', Type.HULL, 'Q', Type.CABLE_QUAD, 'C', Type.BETTER_CIRCUIT, 'F', Type.FIELD_GENERATOR);
        registerMachineRecipe(GATileEntities.REPLICATOR, "EFE", "CMC", "EQE", 'M', Type.HULL, 'Q', Type.CABLE_QUAD, 'C', Type.BETTER_CIRCUIT, 'F', Type.FIELD_GENERATOR, 'E', Type.EMITTER);
    }

    public static <T extends MetaTileEntity> void registerMachineRecipe(T[] metaTileEntities, Object... recipe) {
        for (int i = 0; i < metaTileEntities.length; i++) {
            if (metaTileEntities[i] != null)
                ModHandler.addShapedRecipe(String.format("ga_%s", metaTileEntities[i].getMetaName()), metaTileEntities[i].getStackForm(), prepareRecipe(i + 1, Arrays.copyOf(recipe, recipe.length)));
        }
    }

    private static Object[] prepareRecipe(int tier, Object... recipe) {
        for (int i = 3; i < recipe.length; i++) {
            if (recipe[i] == Type.CIRCUIT || recipe[i] == Type.BETTER_CIRCUIT) {
                switch (recipe[i] == Type.BETTER_CIRCUIT ? tier + 1 : tier) {
                    case 0:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Primitive);
                        break;
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Master);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Ultimate);
                        break;
                    case 8:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Superconductor);
                        break;
                    case 9:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Infinite);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.WORSE_HULL) {
                recipe[i] = MetaTileEntities.HULL[tier - 1].getStackForm();
                continue;
            }

            if (recipe[i] == Type.HULL) {
                recipe[i] = MetaTileEntities.HULL[tier].getStackForm();
                continue;
            }

            if (recipe[i] == Type.GRINDER) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.gem, Materials.Diamond);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.gem, Materials.Diamond);
                        break;
                    default:
                        recipe[i] = OreDictNames.craftingGrinder;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.valueOf("STICK_RADIOACTIVE")) {
                switch (tier) {
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.Uranium235);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.Plutonium241);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.NaquadahEnriched);
                        break;
                }
            }

            if (recipe[i] == Type.WIRE) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Gold);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Silver);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Electrum);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Platinum);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.DIAMOND) {
                switch (tier) {
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.gem, Materials.Diamond);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.CABLE) {
                switch (tier) {
                    case 0:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.Lead);
                        break;
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.Platinum);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.NiobiumTitanium);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Materials.Naquadah);
                        break;
                    case 8:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy);
                        break;
                    case 9:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Tier.Superconductor);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.CABLE_QUAD) {
                switch (tier) {
                    case 0:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Lead);
                        break;
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Tin);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Copper);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Gold);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Aluminium);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Platinum);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Naquadah);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.NaquadahAlloy);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.GLASS) {
                switch (tier) {
                    case 6:
                    case 7:
                    case 8:
                        recipe[i] = GAMetaBlocks.TRANSPARENT_CASING.getItemVariant(GATransparentCasing.CasingType.REINFORCED_GLASS);
                        break;
                    default:
                        recipe[i] = new ItemStack(Blocks.GLASS, 1, W);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.PLATE) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.Steel);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.Aluminium);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.Titanium);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.HSSG);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.HSSE);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, GAMaterials.Neutronium);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.PIPE) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Bronze);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Steel);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.StainlessSteel);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.Titanium);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGa"), Materials.TungstenSteel);
                        break;
                    case 6:
                        recipe[i] = GAMetaItems.ULTIMATE_PIPE_SMALL;
                        break;
                    case 7:
                        recipe[i] = GAMetaItems.ULTIMATE_PIPE;
                        break;
                    default:
                        recipe[i] = GAMetaItems.ULTIMATE_PIPE_LARGE;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.COIL_HEATING) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.Cupronickel);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.Kanthal);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.Nichrome);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.TungstenSteel);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.HSSG);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.Naquadah);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.NaquadahAlloy);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.COIL_HEATING_DOUBLE) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Cupronickel);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Kanthal);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Nichrome);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.TungstenSteel);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.HSSG);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Naquadah);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.STICK_DISTILLATION) {
                switch (tier) {
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.Blaze);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.STICK_MAGNETIC) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.IronMagnetic);
                        break;
                    case 2:
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.SteelMagnetic);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.block, Materials.NeodymiumMagnetic);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.STICK_ELECTROMAGNETIC) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.Iron);
                        break;
                    case 2:
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.Steel);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.Neodymium);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.VanadiumGallium);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.COIL_ELECTRIC) {
                switch (tier) {
                    case 0:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Tin);
                        break;
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.Tin);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtOctal, Materials.AnnealedCopper);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtOctal, Materials.AnnealedCopper);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.YttriumBariumCuprate);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtOctal, Tier.Superconductor);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtHex, Tier.Superconductor);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.ROBOT_ARM) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.ROBOT_ARM_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.ROBOT_ARM_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.ROBOT_ARM_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.ROBOT_ARM_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.ROBOT_ARM_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.ROBOT_ARM_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.ROBOT_ARM_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.ROBOT_ARM_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.PUMP) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.ELECTRIC_PUMP_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.ROTOR) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.Tin);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.Bronze);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.Steel);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.StainlessSteel);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.TungstenSteel);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.Chrome);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.Iridium);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.rotor, Materials.Osmium);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.MOTOR) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.ELECTRIC_MOTOR_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.PISTON) {
                switch (tier) {
                    case 0:
                        recipe[i] = new ItemStack(Blocks.PISTON);
                        break;
                    case 1:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.ELECTRIC_PISTON_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.CONVEYOR) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.CONVEYOR_MODULE_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.EMITTER) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.EMITTER_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.EMITTER_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.EMITTER_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.EMITTER_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.EMITTER_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.EMITTER_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.EMITTER_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.EMITTER_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.SENSOR) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.SENSOR_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.SENSOR_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.SENSOR_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.SENSOR_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.SENSOR_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.SENSOR_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.SENSOR_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.SENSOR_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.FIELD_GENERATOR) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.FIELD_GENERATOR_LV;
                        break;
                    case 2:
                        recipe[i] = MetaItems.FIELD_GENERATOR_MV;
                        break;
                    case 3:
                        recipe[i] = MetaItems.FIELD_GENERATOR_HV;
                        break;
                    case 4:
                        recipe[i] = MetaItems.FIELD_GENERATOR_EV;
                        break;
                    case 5:
                        recipe[i] = MetaItems.FIELD_GENERATOR_IV;
                        break;
                    case 6:
                        recipe[i] = MetaItems.FIELD_GENERATOR_LUV;
                        break;
                    case 7:
                        recipe[i] = MetaItems.FIELD_GENERATOR_ZPM;
                        break;
                    default:
                        recipe[i] = MetaItems.FIELD_GENERATOR_UV;
                        break;
                }
                continue;
            }

            if (recipe[i] instanceof Type)
                throw new IllegalArgumentException("Missing Type mapping for: " + recipe[i] + " at tier " + tier);
        }
        return recipe;
    }
}
