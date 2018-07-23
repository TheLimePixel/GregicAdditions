package gregicadditions.recipes;

import gregicadditions.GAMaterials;
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

import java.util.Arrays;

import static gregtech.api.GTValues.W;

public class MachineCraftingRecipes {

    public static void init() {
        registerMachineRecipe(GATileEntities.CLUSTERMILL,"MMM","CHC","MMM",'M',Type.MOTOR,'C',Type.CIRCUIT,'H',Type.HULL);
        registerMachineRecipe(GATileEntities.CIRCUITASSEMBLER, "ACE", "VMV", "WCW", 'M',Type.HULL, 'V', Type.CONVEYOR, 'A', Type.ROBOT_ARM, 'C', Type.CIRCUIT, 'W', Type.CABLE, 'E', Type.EMITTER);
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
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.circuit, Tier.Superconductor);
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
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium);
                        break;
                    case 6:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium);
                        break;
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium);
                        break;
                    case 8:
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
                    default:
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
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Tier.Superconductor);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.GLASS) {
                switch (tier) {
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
                    case 8:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.Darmstadtium);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel);
                        break;
                }
                continue;
            }

            if (recipe[i] == Type.PIPE) {
                switch (tier) {
//                    case 0:
//                    case 1:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeMedium, Materials.Bronze);
//                        break;
//                    case 2:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeMedium, Materials.Steel);
//                        break;
//                    case 3:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeMedium, Materials.StainlessSteel);
//                        break;
//                    case 4:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeMedium, Materials.Titanium);
//                        break;
//                    case 5:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeMedium, Materials.TungstenSteel);
//                        break;
//                    case 6:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeSmall, MarkerMaterials.Tier.Ultimate);
//                        break;
//                    case 7:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeMedium, MarkerMaterials.Tier.Ultimate);
//                        break;
//                    case 8:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeLarge, MarkerMaterials.Tier.Ultimate);
//                        break;
//                    default:
//                        recipe[i] = new UnificationEntry(OrePrefix.pipeMedium, Materials.TungstenSteel);
//                        break;
                    case 0:
                    case 1:
                        recipe[i] = MetaItems.SMALL_BRONZE_PIPE;
                        break;
                    default:
                        recipe[i] = MetaItems.SMALL_STEEL_PIPE;
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
                    case 8:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtDouble, Materials.NaquadahAlloy);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtOctal, Materials.Nichrome);
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
                    case 8:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy);
                        break;
                    default:
                        recipe[i] = new UnificationEntry(OrePrefix.wireGtHex, Materials.Nichrome);
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
                    case 4:
                    case 5:
                        recipe[i] = new UnificationEntry(OrePrefix.stick, Materials.NeodymiumMagnetic);
                        break;
                    case 6:
                    case 7:
                        recipe[i] = new UnificationEntry(OrePrefix.stickLong, Materials.NeodymiumMagnetic);
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
