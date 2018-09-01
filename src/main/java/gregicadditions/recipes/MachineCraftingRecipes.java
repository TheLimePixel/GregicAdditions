package gregicadditions.recipes;

import gregicadditions.GAMaterials;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMetaItems;
import gregicadditions.item.GAMultiblockCasing;
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
import gregtech.common.blocks.*;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

import static gregicadditions.recipes.GACraftingComponents.*;

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
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:pyrolyse_oven"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:diesel_engine"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:engine_intake_casing"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:multi_furnace"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_steam_turbine"));
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

        //Power Manipulation Machines
        ModHandler.addShapedRecipe("ga_charger_ulv", MetaTileEntities.CHARGER[GTValues.ULV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.ULV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Lead), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_ULV_TANTALUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Primitive));
        ModHandler.addShapedRecipe("ga_charger_lv", MetaTileEntities.CHARGER[GTValues.LV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Tin), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_LV_LITHIUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic));
        ModHandler.addShapedRecipe("ga_charger_mv", MetaTileEntities.CHARGER[GTValues.MV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Copper), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_MV_LITHIUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good));
        ModHandler.addShapedRecipe("ga_charger_hv", MetaTileEntities.CHARGER[GTValues.HV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Gold), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_HV_LITHIUM, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced));
        ModHandler.addShapedRecipe("ga_charger_ev", MetaTileEntities.CHARGER[GTValues.EV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Aluminium), 'T', OreDictNames.chestWood, 'B', GAMetaItems.LAPOTRON_CRYSTAL, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme));
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
        ModHandler.addShapedRecipe("ga_steam_boiler_solar_bronze", MetaTileEntities.STEAM_BOILER_SOLAR_BRONZE.getStackForm(), "GGG", "SSS", "PMP", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_BRICKS_HULL), 'P', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'S', new UnificationEntry(OrePrefix.plate, Materials.Silver), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("ga_steam_furnace_bronze", MetaTileEntities.STEAM_FURNACE_BRONZE.getStackForm(), "XXX", "XMX", "XFX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'F', OreDictNames.craftingFurnace);
        ModHandler.addShapedRecipe("ga_steam_furnace_steel", MetaTileEntities.STEAM_FURNACE_STEEL.getStackForm(), "XXX", "XMX", "XFX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.STEEL_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Steel), 'F', OreDictNames.craftingFurnace);
        ModHandler.addShapedRecipe("ga_steam_macerator_bronze", MetaTileEntities.STEAM_MACERATOR_BRONZE.getStackForm(), "DXD", "XMX", "PXP", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', OreDictNames.craftingPiston, 'D', new ItemStack(Items.FLINT));
        ModHandler.addShapedRecipe("ga_steam_macerator_steel", MetaTileEntities.STEAM_MACERATOR_STEEL.getStackForm(), "DXD", "XMX", "PXP", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Steel), 'P', OreDictNames.craftingPiston, 'D', new ItemStack(Items.FLINT));
        ModHandler.addShapedRecipe("ga_steam_extractor_bronze", MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm(), "XXX", "PMG", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', OreDictNames.craftingPiston, 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("ga_steam_extractor_steel", MetaTileEntities.STEAM_EXTRACTOR_STEEL.getStackForm(), "XXX", "PMG", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Steel), 'P', OreDictNames.craftingPiston, 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("ga_steam_hammer_bronze", MetaTileEntities.STEAM_HAMMER_BRONZE.getStackForm(), "XPX", "XMX", "XAX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', OreDictNames.craftingPiston, 'A', OreDictNames.craftingAnvil);
        ModHandler.addShapedRecipe("ga_steam_hammer_steel", MetaTileEntities.STEAM_HAMMER_STEEL.getStackForm(), "XPX", "XMX", "XAX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Steel), 'P', OreDictNames.craftingPiston, 'A', OreDictNames.craftingAnvil);
        ModHandler.addShapedRecipe("ga_steam_compressor_bronze", MetaTileEntities.STEAM_COMPRESSOR_BRONZE.getStackForm(), "XXX", "PMP", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', OreDictNames.craftingPiston);
        ModHandler.addShapedRecipe("ga_steam_compressor_steel", MetaTileEntities.STEAM_COMPRESSOR_STEEL.getStackForm(), "XXX", "PMP", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.STEEL_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Steel), 'P', OreDictNames.craftingPiston);
        ModHandler.addShapedRecipe("ga_steam_alloy_smelter_bronze", MetaTileEntities.STEAM_ALLOY_SMELTER_BRONZE.getStackForm(), "XXX", "FMF", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'F', OreDictNames.craftingFurnace);
        ModHandler.addShapedRecipe("ga_steam_alloy_smelter_steel", MetaTileEntities.STEAM_ALLOY_SMELTER_STEEL.getStackForm(), "XXX", "FMF", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.STEEL_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Steel), 'F', OreDictNames.craftingFurnace);

        //MultiBlock Controllers
        ModHandler.addShapedRecipe("coke_oven", GATileEntities.COKE_OVEN.getStackForm(), "hRS", "PBR", "dRS", 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Iron), 'S', OreDictUnifier.get(OrePrefix.screw, Materials.Iron), 'P', OreDictUnifier.get(OrePrefix.plate, Materials.Iron), 'B', GAMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GAMultiblockCasing.CasingType.COKE_OVEN_BRICKS));
        ModHandler.addShapedRecipe("ga_primitive_blast_furnace", MetaTileEntities.PRIMITIVE_BLAST_FURNACE.getStackForm(), "hRS", "PBR", "dRS", 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Iron), 'S', OreDictUnifier.get(OrePrefix.screw, Materials.Iron), 'P', OreDictUnifier.get(OrePrefix.plate, Materials.Iron), 'B', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS));
        ModHandler.addShapedRecipe("ga_electric_blast_furnace", MetaTileEntities.ELECTRIC_BLAST_FURNACE.getStackForm(), "FFF", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF), 'F', OreDictNames.craftingFurnace, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("ga_vacuum_freezer", MetaTileEntities.VACUUM_FREEZER.getStackForm(), "PPP", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF), 'P', MetaItems.ELECTRIC_PUMP_HV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));
        ModHandler.addShapedRecipe("ga_implosion_compressor", MetaTileEntities.IMPLOSION_COMPRESSOR.getStackForm(), "OOO", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STEEL_SOLID), 'O', new UnificationEntry(OrePrefix.stone, Materials.Obsidian), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium));
        ModHandler.addShapedRecipe("ga_distillation_tower", GATileEntities.DISTILL_TOWER.getStackForm(), "CBC", "FMF", "CBC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.EV), 'B', new UnificationEntry(OrePrefix.pipeLarge, Materials.StainlessSteel), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme), 'F', MetaItems.ELECTRIC_PUMP_EV);
        ModHandler.addShapedRecipe("ga_cracker_unit", GATileEntities.CRACKER_UNIT.getStackForm(), "CEC", "PHP", "CEC", 'C', MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.CUPRONICKEL), 'E', MetaItems.ELECTRIC_PUMP_HV, 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'H', MetaTileEntities.HULL[GTValues.HV].getStackForm());
        ModHandler.addShapedRecipe("ga_pyrolyse_oven", MetaTileEntities.PYROLYSE_OVEN.getStackForm(), "WEP", "EME", "WCP", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', MetaItems.ELECTRIC_PISTON_MV, 'P', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Cupronickel), 'E', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'C', MetaItems.ELECTRIC_PUMP_MV);
        ModHandler.addShapedRecipe("ga_diesel_engine", MetaTileEntities.DIESEL_ENGINE.getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_EV, 'E', MetaItems.ELECTRIC_MOTOR_EV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.TungstenSteel), 'G', new UnificationEntry(OrePrefix.gear, Materials.Titanium));
        ModHandler.addShapedRecipe("ga_engine_intake_casing", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ENGINE_INTAKE_CASING), "PhP", "RFR", "PwP", 'R', new UnificationEntry(OrePrefix.pipeMedium, Materials.Titanium), 'F', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE), 'P', new UnificationEntry(OrePrefix.rotor, Materials.Titanium));
        ModHandler.addShapedRecipe("ga_multi_furnace", MetaTileEntities.MULTI_FURNACE.getStackForm(), "PPP", "ASA", "CAC", 'P', Blocks.FURNACE, 'A', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'S', MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.AnnealedCopper));
        ModHandler.addShapedRecipe("ga_large_steam_turbine", MetaTileEntities.LARGE_STEAM_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.Steel), 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'A', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', OreDictUnifier.get(OrePrefix.pipeLarge, Materials.Steel));
        ModHandler.addShapedRecipe("ga_large_gas_turbine", MetaTileEntities.LARGE_GAS_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.StainlessSteel), 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), GAMaterials.Extreme), 'A', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', OreDictUnifier.get(OrePrefix.pipeLarge, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("ga_large_plasma_turbine", MetaTileEntities.LARGE_PLASMA_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.TungstenSteel), 'P', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Master), 'A', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', OreDictUnifier.get(OrePrefix.pipeLarge, Materials.TungstenSteel));
        ModHandler.addShapedRecipe("ga_large_bronze_boiler", MetaTileEntities.LARGE_BRONZE_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.BRONZE_FIREBOX));
        ModHandler.addShapedRecipe("ga_large_steel_boiler", MetaTileEntities.LARGE_STEEL_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.STEEL_FIREBOX));
        ModHandler.addShapedRecipe("ga_large_titanium_boiler", MetaTileEntities.LARGE_TITANIUM_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.TITANIUM_FIREBOX));
        ModHandler.addShapedRecipe("ga_large_tungstensteel_boiler", MetaTileEntities.LARGE_TUNGSTENSTEEL_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Master), 'A', MetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_FIREBOX));
        ModHandler.addShapedRecipe("ga_assline", GATileEntities.ASSEMBLY_LINE.getStackForm(), "CRC", "SAS", "CRC", 'A', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'R', MetaItems.ROBOT_ARM_IV, 'C', MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLER_CASING), 'S', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite));

        //Generators
        registerMachineRecipe(GATileEntities.NAQUADAH_REACTOR, "RCR", "FMF", "QCQ", 'M', HULL, 'Q', CABLE_QUAD, 'C', BETTER_CIRCUIT, 'F', FIELD_GENERATOR, 'R', STICK_RADIOACTIVE);
        ModHandler.addShapedRecipe("ga_diesel_generator_lv", MetaTileEntities.DIESEL_GENERATOR[0].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_LV, 'E', MetaItems.ELECTRIC_MOTOR_LV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'G', new UnificationEntry(OrePrefix.gear, Materials.Steel));
        ModHandler.addShapedRecipe("ga_diesel_generator_mv", MetaTileEntities.DIESEL_GENERATOR[1].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_MV, 'E', MetaItems.ELECTRIC_MOTOR_MV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'G', new UnificationEntry(OrePrefix.gear, Materials.Aluminium));
        ModHandler.addShapedRecipe("ga_diesel_generator_hv", MetaTileEntities.DIESEL_GENERATOR[2].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_HV, 'E', MetaItems.ELECTRIC_MOTOR_HV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'G', new UnificationEntry(OrePrefix.gear, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("ga_gas_turbine_lv", MetaTileEntities.GAS_TURBINE[0].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_LV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Tin), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("ga_gas_turbine_mv", MetaTileEntities.GAS_TURBINE[1].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_MV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper));
        ModHandler.addShapedRecipe("ga_gas_turbine_hv", MetaTileEntities.GAS_TURBINE[2].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_HV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Steel), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));
        ModHandler.addShapedRecipe("ga_steam_turbine_lv", MetaTileEntities.STEAM_TURBINE[0].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_LV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Tin), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'P', new UnificationEntry(OrePrefix.pipeMedium, Materials.Bronze));
        ModHandler.addShapedRecipe("ga_steam_turbine_mv", MetaTileEntities.STEAM_TURBINE[1].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_MV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'P', new UnificationEntry(OrePrefix.pipeMedium, Materials.Steel));
        ModHandler.addShapedRecipe("ga_steam_turbine_hv", MetaTileEntities.STEAM_TURBINE[2].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_HV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Steel), 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'P', new UnificationEntry(OrePrefix.pipeMedium, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("ga_magic_energy_absorber", MetaTileEntities.MAGIC_ENERGY_ABSORBER.getStackForm(), "PCP", "PMP", "PCP", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'P', MetaItems.SENSOR_EV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Elite));
        if (MetaTileEntities.MAGIC_ENERGY_CONVERTER != null) {
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:magic_energy_converter"));
            ModHandler.addShapedRecipe("ga_magic_energy_converter", MetaTileEntities.MAGIC_ENERGY_CONVERTER.getStackForm(), "PCP", "SMS", "PCP", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'P', MetaItems.ELECTRIC_PUMP_MV, 'S', MetaItems.SENSOR_MV, 'C', new UnificationEntry(OrePrefix.valueOf("circuitGA"), Tier.Good));
        }

        registerMachineRecipe(GATileEntities.CLUSTERMILL, "MMM", "CHC", "MMM", 'M', MOTOR, 'C', CIRCUIT, 'H', HULL);
        registerMachineRecipe(GATileEntities.CIRCUITASSEMBLER, "ACE", "VMV", "WCW", 'M', HULL, 'V', CONVEYOR, 'A', ROBOT_ARM, 'C', CIRCUIT, 'W', CABLE, 'E', EMITTER);
        registerMachineRecipe(MetaTileEntities.ALLOY_SMELTER, "ECE", "CMC", "WCW", 'M', HULL, 'E', CIRCUIT, 'W', CABLE, 'C', COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.ASSEMBLER, "ACA", "VMV", "WCW", 'M', HULL, 'V', CONVEYOR, 'A', ROBOT_ARM, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.BENDER, "PwP", "CMC", "EWE", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.CANNER, "WPW", "CMC", "GGG", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.COMPRESSOR, " C ", "PMP", "WCW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.CUTTER, "WCG", "VMB", "CWE", 'M', HULL, 'E', MOTOR, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS, 'B', OreDictNames.craftingDiamondBlade);
        registerMachineRecipe(MetaTileEntities.ELECTRIC_FURNACE, "ECE", "CMC", "WCW", 'M', HULL, 'E', CIRCUIT, 'W', CABLE, 'C', COIL_HEATING);
        registerMachineRecipe(MetaTileEntities.EXTRACTOR, "GCG", "EMP", "WCW", 'M', HULL, 'E', PISTON, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.EXTRUDER, "CCE", "XMP", "CCE", 'M', HULL, 'X', PISTON, 'E', CIRCUIT, 'P', PIPE, 'C', COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.LATHE, "WCW", "EMD", "CWP", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'D', DIAMOND);
        registerMachineRecipe(MetaTileEntities.MACERATOR, "PEG", "WWM", "CCW", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'G', GRINDER);
        registerMachineRecipe(MetaTileEntities.MICROWAVE, "LWC", "LMR", "LEC", 'M', HULL, 'E', MOTOR, 'R', EMITTER, 'C', CIRCUIT, 'W', CABLE, 'L', new UnificationEntry(OrePrefix.plate, Materials.Lead));
        registerMachineRecipe(MetaTileEntities.WIREMILL, "EWE", "CMC", "EWE", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.CENTRIFUGE, "CEC", "WMW", "CEC", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.ELECTROLYZER, "IGI", "IMI", "CWC", 'M', HULL, 'C', CIRCUIT, 'W', CABLE, 'I', WIRE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.THERMAL_CENTRIFUGE, "CEC", "OMO", "WEW", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'O', COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.ORE_WASHER, "RGR", "CEC", "WMW", 'M', HULL, 'R', ROTOR, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.PACKER, "BCB", "RMV", "WCW", 'M', HULL, 'R', ROBOT_ARM, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(MetaTileEntities.UNPACKER, "BCB", "VMR", "WCW", 'M', HULL, 'R', ROBOT_ARM, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(MetaTileEntities.CHEMICAL_REACTOR, "GRG", "WEW", "CMC", 'M', HULL, 'R', ROTOR, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.FLUID_CANNER, "GCG", "GMG", "WPW", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.BREWERY, "GPG", "WMW", "CBC", 'M', HULL, 'P', PUMP, 'B', STICK_DISTILLATION, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.FERMENTER, "WPW", "GMG", "WCW", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.FLUID_EXTRACTOR, "GCG", "PME", "WCW", 'M', HULL, 'E', PISTON, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.FLUID_SOLIDIFIER, "PGP", "WMW", "CBC", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS, 'B', OreDictNames.chestWood);
        registerMachineRecipe(MetaTileEntities.DISTILLERY, "GBG", "CMC", "WPW", 'M', HULL, 'P', PUMP, 'B', STICK_DISTILLATION, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.CHEMICAL_BATH, "VGW", "PGV", "CMC", 'M', HULL, 'P', PUMP, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.POLARIZER, "ZSZ", "WMW", "ZSZ", 'M', HULL, 'S', STICK_ELECTROMAGNETIC, 'Z', COIL_ELECTRIC, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.ELECTROMAGNETIC_SEPARATOR, "VWZ", "WMS", "CWZ", 'M', HULL, 'S', STICK_ELECTROMAGNETIC, 'Z', COIL_ELECTRIC, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.AUTOCLAVE, "IGI", "IMI", "CPC", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'I', PLATE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.MIXER, "GRG", "GEG", "CMC", 'M', HULL, 'E', MOTOR, 'R', ROTOR, 'C', CIRCUIT, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.LASER_ENGRAVER, "PEP", "CMC", "WCW", 'M', HULL, 'E', EMITTER, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.FORMING_PRESS, "WPW", "CMC", "WPW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.FORGE_HAMMER, "WPW", "CMC", "WAW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'A', OreDictNames.craftingAnvil);
        registerMachineRecipe(MetaTileEntities.FLUID_HEATER, "OGO", "PMP", "WCW", 'M', HULL, 'P', PUMP, 'O', COIL_HEATING_DOUBLE, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(MetaTileEntities.SIFTER, "WFW", "PMP", "CFC", 'M', HULL, 'P', PISTON, 'F', OreDictNames.craftingFilter, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.ARC_FURNACE, "WGW", "CMC", "PPP", 'M', HULL, 'P', PLATE, 'C', CIRCUIT, 'W', CABLE_QUAD, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(MetaTileEntities.PLASMA_ARC_FURNACE, "WGW", "CMC", "TPT", 'M', HULL, 'P', PLATE, 'C', BETTER_CIRCUIT, 'W', CABLE_QUAD, 'T', PUMP, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(MetaTileEntities.PUMP, "WGW", "GMG", "TGT", 'M', HULL, 'W', CIRCUIT, 'G', PUMP, 'T', PIPE);
        registerMachineRecipe(GATileEntities.ALLOY_SMELTER, "ECE", "CMC", "WCW", 'M', HULL, 'E', CIRCUIT, 'W', CABLE, 'C', COIL_HEATING_DOUBLE);
        registerMachineRecipe(GATileEntities.ASSEMBLER, "ACA", "VMV", "WCW", 'M', HULL, 'V', CONVEYOR, 'A', ROBOT_ARM, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.BENDER, "PWP", "CMC", "EWE", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.CANNER, "WPW", "CMC", "GGG", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.COMPRESSOR, " C ", "PMP", "WCW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.CUTTER, "WCG", "VMB", "CWE", 'M', HULL, 'E', MOTOR, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS, 'B', OreDictNames.craftingDiamondBlade);
        registerMachineRecipe(GATileEntities.ELECTRIC_FURNACE, "ECE", "CMC", "WCW", 'M', HULL, 'E', CIRCUIT, 'W', CABLE, 'C', COIL_HEATING);
        registerMachineRecipe(GATileEntities.EXTRACTOR, "GCG", "EMP", "WCW", 'M', HULL, 'E', PISTON, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.EXTRUDER, "CCE", "XMP", "CCE", 'M', HULL, 'X', PISTON, 'E', CIRCUIT, 'P', PIPE, 'C', COIL_HEATING_DOUBLE);
        registerMachineRecipe(GATileEntities.LATHE, "WCW", "EMD", "CWP", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'D', DIAMOND);
        registerMachineRecipe(GATileEntities.MACERATOR, "PEG", "WWM", "CCW", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'G', GRINDER);
        registerMachineRecipe(GATileEntities.MICROWAVE, "LWC", "LMR", "LEC", 'M', HULL, 'E', MOTOR, 'R', EMITTER, 'C', CIRCUIT, 'W', CABLE, 'L', new UnificationEntry(OrePrefix.plate, Materials.Lead));
        registerMachineRecipe(GATileEntities.WIREMILL, "EWE", "CMC", "EWE", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.CENTRIFUGE, "CEC", "WMW", "CEC", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.ELECTROLYZER, "IGI", "IMI", "CWC", 'M', HULL, 'C', CIRCUIT, 'W', CABLE, 'I', WIRE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.THERMAL_CENTRIFUGE, "CEC", "OMO", "WEW", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'O', COIL_HEATING_DOUBLE);
        registerMachineRecipe(GATileEntities.ORE_WASHER, "RGR", "CEC", "WMW", 'M', HULL, 'R', ROTOR, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.PACKER, "BCB", "RMV", "WCW", 'M', HULL, 'R', ROBOT_ARM, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(GATileEntities.UNPACKER, "BCB", "VMR", "WCW", 'M', HULL, 'R', ROBOT_ARM, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'B', OreDictNames.chestWood);
        registerMachineRecipe(GATileEntities.CHEMICAL_REACTOR, "GRG", "WEW", "CMC", 'M', HULL, 'R', ROTOR, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.FLUID_CANNER, "GCG", "GMG", "WPW", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.BREWERY, "GPG", "WMW", "CBC", 'M', HULL, 'P', PUMP, 'B', STICK_DISTILLATION, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.FERMENTER, "WPW", "GMG", "WCW", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.FLUID_EXTRACTOR, "GCG", "PME", "WCW", 'M', HULL, 'E', PISTON, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.FLUID_SOLIDIFIER, "PGP", "WMW", "CBC", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS, 'B', OreDictNames.chestWood);
        registerMachineRecipe(GATileEntities.DISTILLERY, "GBG", "CMC", "WPW", 'M', HULL, 'P', PUMP, 'B', STICK_DISTILLATION, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.CHEMICAL_BATH, "VGW", "PGV", "CMC", 'M', HULL, 'P', PUMP, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.POLARIZER, "ZSZ", "WMW", "ZSZ", 'M', HULL, 'S', STICK_ELECTROMAGNETIC, 'Z', COIL_ELECTRIC, 'W', CABLE);
        registerMachineRecipe(GATileEntities.ELECTROMAGNETIC_SEPARATOR, "VWZ", "WMS", "CWZ", 'M', HULL, 'S', STICK_ELECTROMAGNETIC, 'Z', COIL_ELECTRIC, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.AUTOCLAVE, "IGI", "IMI", "CPC", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'I', PLATE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.MIXER, "GRG", "GEG", "CMC", 'M', HULL, 'E', MOTOR, 'R', ROTOR, 'C', CIRCUIT, 'G', GLASS);
        registerMachineRecipe(GATileEntities.LASER_ENGRAVER, "PEP", "CMC", "WCW", 'M', HULL, 'E', EMITTER, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.FORMING_PRESS, "WPW", "CMC", "WPW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.FORGE_HAMMER, "WPW", "CMC", "WAW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'A', OreDictNames.craftingAnvil);
        registerMachineRecipe(GATileEntities.FLUID_HEATER, "OGO", "PMP", "WCW", 'M', HULL, 'P', PUMP, 'O', COIL_HEATING_DOUBLE, 'C', CIRCUIT, 'W', CABLE, 'G', GLASS);
        registerMachineRecipe(GATileEntities.SIFTER, "WFW", "PMP", "CFC", 'M', HULL, 'P', PISTON, 'F', OreDictNames.craftingFilter, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(GATileEntities.ARC_FURNACE, "WGW", "CMC", "PPP", 'M', HULL, 'P', PLATE, 'C', CIRCUIT, 'W', CABLE_QUAD, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(GATileEntities.PLASMA_ARC_FURNACE, "WGW", "CMC", "TPT", 'M', HULL, 'P', PLATE, 'C', BETTER_CIRCUIT, 'W', CABLE_QUAD, 'T', PUMP, 'G', new UnificationEntry(OrePrefix.ingot, Materials.Graphite));
        registerMachineRecipe(GATileEntities.MASS_FAB, "CFC", "QMQ", "CFC", 'M', HULL, 'Q', CABLE_QUAD, 'C', BETTER_CIRCUIT, 'F', FIELD_GENERATOR);
        registerMachineRecipe(GATileEntities.REPLICATOR, "EFE", "CMC", "EQE", 'M', HULL, 'Q', CABLE_QUAD, 'C', BETTER_CIRCUIT, 'F', FIELD_GENERATOR, 'E', EMITTER);
    }

    public static <T extends MetaTileEntity> void registerMachineRecipe(T[] metaTileEntities, Object... recipe) {
        for (int i = 0; i < metaTileEntities.length; i++) {
            if (metaTileEntities[i] != null)
                ModHandler.addShapedRecipe(String.format("ga_%s", metaTileEntities[i].getMetaName()), metaTileEntities[i].getStackForm(), prepareRecipe(i + 1, Arrays.copyOf(recipe, recipe.length)));
        }
    }

    private static Object[] prepareRecipe(int tier, Object... recipe) {
        for (int i = 3; i < recipe.length; i++) {
            if (recipe[i] instanceof GACraftingComponents) {
                recipe[i] = ((GACraftingComponents) recipe[i]).getIngredient(tier);
            }
        }
        return recipe;
    }
}