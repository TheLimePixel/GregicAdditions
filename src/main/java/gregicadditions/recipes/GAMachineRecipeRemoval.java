package gregicadditions.recipes;

import gregicadditions.GAConfig;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Color;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GAMachineRecipeRemoval {

    private static final MaterialStack[] solderingList = {
            new MaterialStack(Materials.Tin, 2L),
            new MaterialStack(Materials.SolderingAlloy, 1L),
            new MaterialStack(Materials.Lead, 4L)
    };

    public static void init() {
        for (Material m : IngotMaterial.MATERIAL_REGISTRY) {

            //Foil recipes
            removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                    OreDictUnifier.get(OrePrefix.plate, m),
                    IntCircuitIngredient.getIntegratedCircuit(0));

            //Remove Old Rotor Recipe
            if (!OreDictUnifier.get(OrePrefix.rotor, m).isEmpty() && GAConfig.GT6.BendingRotors == true && GAConfig.GT6.BendingCylinders == true)
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.plate, m, 4), OreDictUnifier.get(OrePrefix.ring, m)},
                        new FluidStack[]{Materials.SolderingAlloy.getFluid(32)});

            //Remove Old Wrench Recipes
            if (m instanceof IngotMaterial && !m.hasFlag(DustMaterial.MatFlags.NO_SMASHING) && GAConfig.GT6.ExpensiveWrenches == true) {
                ModHandler.removeRecipeByName(new ResourceLocation(String.format("gregtech:wrench_%s", m.toString())));
            }

            //Remove GTCE's weird fine wire recipes
            if (!OreDictUnifier.get(OrePrefix.wireFine, m).isEmpty() && !OreDictUnifier.get(OrePrefix.stick, m).isEmpty() && GAConfig.GT5U.OldFineWireRecipes == true) {
                removeRecipesByInputs(RecipeMaps.WIREMILL_RECIPES, OreDictUnifier.get(OrePrefix.stick, m));
            }


            //Remove EV+ Cable Recipes
            if (GAConfig.GT5U.CablesGT5U == true) {
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtSingle, m), IntCircuitIngredient.getIntegratedCircuit(24)},
                        new FluidStack[]{Materials.Rubber.getFluid(144)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtSingle, m, 2), IntCircuitIngredient.getIntegratedCircuit(25)},
                        new FluidStack[]{Materials.Rubber.getFluid(288)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtSingle, m, 4), IntCircuitIngredient.getIntegratedCircuit(26)},
                        new FluidStack[]{Materials.Rubber.getFluid(576)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtSingle, m, 8), IntCircuitIngredient.getIntegratedCircuit(27)},
                        new FluidStack[]{Materials.Rubber.getFluid(1152)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtSingle, m, 16), IntCircuitIngredient.getIntegratedCircuit(28)},
                        new FluidStack[]{Materials.Rubber.getFluid(2304)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtDouble, m), IntCircuitIngredient.getIntegratedCircuit(24)},
                        new FluidStack[]{Materials.Rubber.getFluid(288)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), IntCircuitIngredient.getIntegratedCircuit(24)},
                        new FluidStack[]{Materials.Rubber.getFluid(576)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtOctal, m), IntCircuitIngredient.getIntegratedCircuit(24)},
                        new FluidStack[]{Materials.Rubber.getFluid(1152)});
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtHex, m), IntCircuitIngredient.getIntegratedCircuit(24)},
                        new FluidStack[]{Materials.Rubber.getFluid(2304)});
            }
        }
        //Remove Old Bucket Recipe
        if (GAConfig.GT6.BendingCurvedPlates == true) {
            removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                    OreDictUnifier.get(OrePrefix.plate, Materials.Iron, 12),
                    IntCircuitIngredient.getIntegratedCircuit(1));
            removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                    OreDictUnifier.get(OrePrefix.plate, Materials.WroughtIron, 12),
                    IntCircuitIngredient.getIntegratedCircuit(1));
        }

        //Fix Brick Exploit
        removeRecipesByInputs(RecipeMaps.MACERATOR_RECIPES, new ItemStack(Items.BRICK));

        //Remove GTCE Circuit recipes
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Silicon, 2),
                OreDictUnifier.get(OrePrefix.plate, Materials.Polytetrafluoroethylene));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Silicon),
                OreDictUnifier.get(OrePrefix.plate, Materials.Plastic));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil, Materials.Platinum),
                OreDictUnifier.get(OrePrefix.craftingLens, Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil, Materials.Gold),
                OreDictUnifier.get(OrePrefix.craftingLens, Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil, Materials.Electrum),
                OreDictUnifier.get(OrePrefix.craftingLens, Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil, Materials.Copper),
                OreDictUnifier.get(OrePrefix.craftingLens, Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil, Materials.AnnealedCopper),
                OreDictUnifier.get(OrePrefix.craftingLens, Color.Red));
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Lapis),
                OreDictUnifier.get(OrePrefix.dust, Materials.Glowstone));
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Lazurite),
                OreDictUnifier.get(OrePrefix.dust, Materials.Glowstone));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Lazurite, 15),
                OreDictUnifier.get(OrePrefix.lens, Materials.Diamond));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Emerald),
                OreDictUnifier.get(OrePrefix.craftingLens, Color.Lime));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Olivine),
                OreDictUnifier.get(OrePrefix.craftingLens, Color.Lime));
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                MetaItems.CIRCUIT_PARTS_WIRING_ELITE.getStackForm(4),
                MetaItems.EMPTY_BOARD_ELITE.getStackForm());
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                MetaItems.CIRCUIT_PARTS_WIRING_ADVANCED.getStackForm(4),
                MetaItems.EMPTY_BOARD_BASIC.getStackForm());
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                MetaItems.CIRCUIT_PARTS_WIRING_BASIC.getStackForm(4),
                MetaItems.EMPTY_BOARD_BASIC.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_ELITE.getStackForm(18),
                MetaItems.CIRCUIT_ELITE.getStackForm(2));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_MASTER.getStackForm(18),
                MetaItems.CIRCUIT_MASTER.getStackForm(2));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.ENERGY_LAPOTRONIC_ORB.getStackForm(8),
                OreDictUnifier.get(OrePrefix.plate, Materials.Europium, 4));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm(8),
                OreDictUnifier.get(OrePrefix.plate, Materials.Darmstadtium, 16));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(OrePrefix.dust, Materials.Tantalum), OreDictUnifier.get(OrePrefix.plate, Materials.Manganese)},
                new FluidStack[]{Materials.Plastic.getFluid(144)});

        for (MaterialStack stack : solderingList) {
            IngotMaterial material = (IngotMaterial) stack.material;
            int multiplier = (int) stack.amount;

            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_MASTER.getStackForm(3),
                            MetaItems.CIRCUIT_BOARD_ELITE.getStackForm()},
                    new FluidStack[]{material.getFluid(144 * multiplier)});
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{MetaItems.CIRCUIT_DATA.getStackForm(3),
                            MetaItems.CIRCUIT_BOARD_ELITE.getStackForm()},
                    new FluidStack[]{material.getFluid(144 * multiplier)});
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{MetaItems.CIRCUIT_BOARD_ADVANCED.getStackForm(),
                            MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_ELITE.getStackForm()},
                    new FluidStack[]{material.getFluid(72 * multiplier)});
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{MetaItems.CIRCUIT_PARTS_ADVANCED.getStackForm(2),
                            MetaItems.CIRCUIT_BOARD_ADVANCED.getStackForm()},
                    new FluidStack[]{material.getFluid(72 * multiplier)});
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{MetaItems.CIRCUIT_PRIMITIVE.getStackForm(2),
                            MetaItems.CIRCUIT_BASIC.getStackForm()},
                    new FluidStack[]{material.getFluid(36 * multiplier)});
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{MetaItems.CIRCUIT_PRIMITIVE.getStackForm(2),
                            MetaItems.CIRCUIT_BOARD_BASIC.getStackForm()},
                    new FluidStack[]{material.getFluid(36 * multiplier)});
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:basic_circuit"));
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{OreDictUnifier.get(OrePrefix.plate, Materials.Plastic),
                            OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.RedAlloy)},
                    new FluidStack[]{material.getFluid(18 * multiplier)});
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.RedAlloy, 2),
                            OreDictUnifier.get(OrePrefix.plate, Materials.Steel)},
                    new FluidStack[]{material.getFluid(18 * multiplier)});
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:primitive_circuit"));
            removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                    new ItemStack[]{OreDictUnifier.get(OrePrefix.plate, Materials.Plastic, 2),
                            MetaItems.CIRCUIT_DATA.getStackForm()},
                    new FluidStack[]{material.getFluid(72 * multiplier)});
        }
        //Circuit Rabbit Hole-Related Recipe Removal
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(OrePrefix.dust, Materials.Silicon)},
                new FluidStack[]{Materials.Epichlorhydrin.getFluid(144)});

        //Remove Cracker recipe
        removeAllRecipes(RecipeMaps.CRACKING_RECIPES);
        removeAllRecipes(RecipeMaps.DISTILLERY_RECIPES);
        removeAllRecipes(RecipeMaps.DISTILLATION_RECIPES);

        //Remove Pyrolise Oven Recipes
        removeAllRecipes(RecipeMaps.PYROLYSE_RECIPES);

        //Remove Hydrogen Sulfide Recipes
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.NaturalGas.getFluid(16000), Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.SulfuricGas.getFluid(16000), Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.SulfuricLightFuel.getFluid(6000), Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.SulfuricHeavyFuel.getFluid(4000), Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.SulfuricNaphtha.getFluid(7000), Materials.Hydrogen.getFluid(1000));

        //Remove GTCE Titanium Tetrachloride Recipe
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,
                new ItemStack[]{OreDictUnifier.get(OrePrefix.dust, Materials.Carbon, 3), OreDictUnifier.get(OrePrefix.dust, Materials.Rutile)},
                new FluidStack[]{Materials.Chlorine.getFluid(2000)});

        //Remove GT5 Ash Centrifuging
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.DarkAsh, 2));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Ash));

        //Remove Alloy Smelter Rubber Recipe
        removeRecipesByInputs(RecipeMaps.ALLOY_SMELTER_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.RawRubber, 3), OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur));

        //Remove Old Regular And Field Generator Recipes
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaItems.CIRCUIT_BASIC.getStackForm(2), MetaItems.ELECTRIC_PUMP_LV.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaItems.CIRCUIT_GOOD.getStackForm(2), MetaItems.ELECTRIC_PUMP_MV.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaItems.CIRCUIT_ADVANCED.getStackForm(2), MetaItems.ELECTRIC_PUMP_HV.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaItems.CIRCUIT_ELITE.getStackForm(2), MetaItems.ELECTRIC_PUMP_EV.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaItems.CIRCUIT_MASTER.getStackForm(2), MetaItems.ELECTRIC_PUMP_IV.getStackForm());

        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaItems.CIRCUIT_BASIC.getStackForm(4), OreDictUnifier.get(OrePrefix.dust, Materials.EnderPearl)}, new FluidStack[]{Materials.Osmium.getFluid(288)});
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaItems.CIRCUIT_GOOD.getStackForm(4), OreDictUnifier.get(OrePrefix.dust, Materials.EnderEye)}, new FluidStack[]{Materials.Osmium.getFluid(576)});
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaItems.CIRCUIT_ADVANCED.getStackForm(4), MetaItems.QUANTUM_EYE.getStackForm()}, new FluidStack[]{Materials.Osmium.getFluid(1152)});
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaItems.CIRCUIT_ELITE.getStackForm(4), OreDictUnifier.get(OrePrefix.dust, Materials.NetherStar)}, new FluidStack[]{Materials.Osmium.getFluid(2304)});
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaItems.CIRCUIT_MASTER.getStackForm(4), MetaItems.QUANTUM_STAR.getStackForm()}, new FluidStack[]{Materials.Osmium.getFluid(4608)});

        //Star Recipes
        removeRecipesByInputs(RecipeMaps.AUTOCLAVE_RECIPES,
                new ItemStack[]{new ItemStack(Items.NETHER_STAR)},
                new FluidStack[]{Materials.Darmstadtium.getFluid(288)});
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, OreDictUnifier.get(OrePrefix.ingot, Materials.Plutonium, 6));

        //Remove The Bad Nitric Acid Recipe
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Water.getFluid(2000), Materials.NitrogenDioxide.getFluid(4000), Materials.Oxygen.getFluid(1000));

        //Remove Old Schematic Recipe
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaItems.CIRCUIT_GOOD.getStackForm(4), OreDictUnifier.get(OrePrefix.plate, Materials.StainlessSteel, 2));

        //Remove Simple Copper Cable Recipes
        removeRecipesByInputs(RecipeMaps.ALLOY_SMELTER_RECIPES, OreDictUnifier.get(OrePrefix.ingot, Materials.Rubber, 2), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper));

        //Remove Deprecated Recipes
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Naphtha.getFluid(288), Materials.Air.getFluid(2000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.dustTiny, Materials.Titanium)}, new FluidStack[]{Materials.Naphtha.getFluid(1296), Materials.Oxygen.getFluid(16000)});
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Epichlorhydrin.getFluid(432), Materials.Naphtha.getFluid(3000), Materials.Fluorine.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.dust, Materials.Carbon)}, new FluidStack[]{Materials.LPG.getFluid(432), Materials.Chlorine.getFluid(1000)});

        //MAX Hull Recipes
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(OrePrefix.plate, Materials.Darmstadtium, 8), IntCircuitIngredient.getIntegratedCircuit(8));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[]{MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX), OreDictUnifier.get(OrePrefix.wireGtSingle, MarkerMaterials.Tier.Superconductor, 2)}, new FluidStack[]{Materials.Polytetrafluoroethylene.getFluid(288)});

        //Electrolyzing Fixes
        removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Sphalerite, 2));
        removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Bentonite, 66));

        //Remove Silicon incompatability with Boule recipes
        removeRecipesByInputs(RecipeMaps.BLAST_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Silicon));

        //Remove Default Recipes Without Circuits
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Oxygen.getFluid(500), Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Hydrogen.getFluid(2000), Materials.Oxygen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.dust, Materials.Carbon)}, new FluidStack[]{Materials.Hydrogen.getFluid(4000)});
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Nitrogen.getFluid(1000), Materials.Oxygen.getFluid(2000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Oxygen.getFluid(2000), Materials.Nitrogen.getFluid(1000));

        //Remove Simple Cetane-Boosted Diesel Recipes
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Glyceryl.getFluid(250), Materials.LightFuel.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Glyceryl.getFluid(250), Materials.Fuel.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.Fuel.getFluid(4000), Materials.Glyceryl.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES, Materials.LightFuel.getFluid(4000), Materials.Glyceryl.getFluid(1000));

        //Remove Cheap Diesel Recipe
        removeRecipesByInputs(RecipeMaps.MIXER_RECIPES, Materials.LightFuel.getFluid(5000), Materials.HeavyFuel.getFluid(1000));

        //Fix Seed Oil Recipe
        removeRecipesByInputs(RecipeMaps.FLUID_EXTRACTION_RECIPES, new ItemStack(Items.WHEAT_SEEDS));
        removeRecipesByInputs(RecipeMaps.FLUID_EXTRACTION_RECIPES, new ItemStack(Items.MELON_SEEDS));
        removeRecipesByInputs(RecipeMaps.FLUID_EXTRACTION_RECIPES, new ItemStack(Items.PUMPKIN_SEEDS));

        //Remove expensive Iridium recipe
        removeRecipesByInputs(RecipeMaps.FUSION_RECIPES, Materials.Lithium.getFluid(16), Materials.Tungsten.getFluid(16));

        //Remove Conflicting Redstone Plate Recipe
        removeRecipesByInputs(RecipeMaps.COMPRESSOR_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Redstone));

        //Remove Incorrect Quartz Plate Recipes
        removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[]{new ItemStack(Blocks.QUARTZ_BLOCK)}, new FluidStack[]{Materials.Water.getFluid(73)});
        removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.block, Materials.CertusQuartz)}, new FluidStack[]{Materials.Water.getFluid(73)});
        removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[]{new ItemStack(Blocks.QUARTZ_BLOCK)}, new FluidStack[]{Materials.DistilledWater.getFluid(55)});
        removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.block, Materials.CertusQuartz)}, new FluidStack[]{Materials.DistilledWater.getFluid(55)});
        removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[]{new ItemStack(Blocks.QUARTZ_BLOCK)}, new FluidStack[]{Materials.Lubricant.getFluid(18)});
        removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(OrePrefix.block, Materials.CertusQuartz)}, new FluidStack[]{Materials.Lubricant.getFluid(18)});
    }

    private static void removeRecipesByInputs(RecipeMap map, ItemStack... itemInputs) {
        List<ItemStack> inputs = new ArrayList<>();
        for (ItemStack s : itemInputs)
            inputs.add(s);
        map.removeRecipe(map.findRecipe(Integer.MAX_VALUE, inputs, Collections.EMPTY_LIST));
    }

    private static void removeRecipesByInputs(RecipeMap map, FluidStack... fluidInputs) {
        List<FluidStack> inputs = new ArrayList<>();
        for (FluidStack s : fluidInputs)
            inputs.add(s);
        map.removeRecipe(map.findRecipe(Integer.MAX_VALUE, Collections.EMPTY_LIST, inputs));
    }

    private static void removeRecipesByInputs(RecipeMap map, ItemStack[] itemInputs, FluidStack[] fluidInputs) {
        List<ItemStack> itemIn = new ArrayList<>();
        for (ItemStack s : itemInputs)
            itemIn.add(s);
        List<FluidStack> fluidIn = new ArrayList<>();
        for (FluidStack s : fluidInputs)
            fluidIn.add(s);
        map.removeRecipe(map.findRecipe(Integer.MAX_VALUE, itemIn, fluidIn));
    }

    private static void removeAllRecipes(RecipeMap map) {

        List<Recipe> recipes = new ArrayList();
        recipes.addAll(map.getRecipeList());

        for (Recipe r : recipes)
            map.removeRecipe(r);
    }
}
