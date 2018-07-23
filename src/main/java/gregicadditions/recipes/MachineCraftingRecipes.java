package gregicadditions.recipes;

import gregicadditions.GAMaterials;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMetaItems;
import gregicadditions.item.GATransparentCasing;
import gregicadditions.machines.GATileEntities;
import gregtech.api.items.OreDictNames;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials.*;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.load.MetaTileEntityLoader.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

import static gregtech.api.GTValues.W;

public class MachineCraftingRecipes {

    public static String[] tiers = {
            "lv",
            "mv",
            "hv",
            "ev"
    };

    public static void init() {
        for (String tier : tiers) {
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.alloy.smelter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.assembler." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.bender." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.canner." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.compressor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.cutter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.electric.furnace." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.extractor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.extruder." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.lathe." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.macerator." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.microwave." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.wiremill." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.centrifuge." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.electrolyzer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.thermal.centrifuge." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.ore.washer" + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.unpacker." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.chemical.reactor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid.canner." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.brewer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fermenter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid.extractor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid.solidifier." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.distillery." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.chemical.bath." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.polarizor." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.electromagnetic.separator." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.autoclave." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.mixer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.laser.engraver." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.forming.press." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.forge.hammer." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.fluid.heater." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.sifter." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.arc.furnace." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.plasma.arc.furnace." + tier));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.pump." + tier));
        }
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.pump.iv"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:gregtech.machine.pump.ulv"));

        registerMachineRecipe(GATileEntities.CLUSTERMILL,"MMM","CHC","MMM",'M',Type.MOTOR,'C',Type.CIRCUIT,'H',Type.HULL);
        registerMachineRecipe(GATileEntities.CIRCUITASSEMBLER, "ACE", "VMV", "WCW", 'M',Type.HULL, 'V', Type.CONVEYOR, 'A', Type.ROBOT_ARM, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'E', Type.EMITTER);
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
        registerMachineRecipe(MetaTileEntities.PUMP, "WGW", "GMG", "TGT", 'M', Type.HULL, 'W', Type.CIRCUIT, 'G', Type.PUMP, 'T', Type.PISTON);
    }

    public static <T extends MetaTileEntity> void registerMachineRecipe(T[] metaTileEntities, Object... recipe) {
        for (int i = 0; i < metaTileEntities.length; i++) {
            ModHandler.addShapedRecipe(String.format("%s", metaTileEntities[i].getMetaName()), metaTileEntities[i].getStackForm(), prepareRecipe(i + 1, Arrays.copyOf(recipe, recipe.length)));
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
                    case 8:
                        recipe[i] = new UnificationEntry(OrePrefix.cableGtSingle, Tier.Superconductor);
                        break;
                    case 9:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Tier.Superconductor);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.GLASS) {
                switch (tier) {
                    case 6:
                    case 7:
                    case 8:
                        recipe[1] = GAMetaBlocks.TRANSPARENT_CASING.getItemVariant(GATransparentCasing.CasingType.REINFORCED_GLASS);
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
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.Darmstadtium);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.PIPE) {
                switch (tier) {
                    case 0:
                    case 1:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGA"), Materials.Bronze);
                        break;
                    case 2:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGA"), Materials.Steel);
                        break;
                    case 3:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGA"), Materials.StainlessSteel);
                        break;
                    case 4:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGA"), Materials.Titanium);
                        break;
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.valueOf("pipeGA"), Materials.TungstenSteel);
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
