package gregicadditions.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials.Color;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.items.MetaItems;
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

    public static void postInit() {
        for (Material m : IngotMaterial.MATERIAL_REGISTRY) {

            //Foil recipes
            removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                    OreDictUnifier.get(OrePrefix.plate, m),
                    IntCircuitIngredient.getIntegratedCircuit(0));

            //Remove Old Rotor Recipe
            if (!OreDictUnifier.get(OrePrefix.rotor, m).isEmpty())
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        new ItemStack[]{OreDictUnifier.get(OrePrefix.plate, m, 4), OreDictUnifier.get(OrePrefix.ring, m)},
                        new FluidStack[]{Materials.SolderingAlloy.getFluid(32)});

            //Remove old wrench recipes
            if (m instanceof IngotMaterial && !m.hasFlag(DustMaterial.MatFlags.NO_SMASHING)) {
                ModHandler.removeRecipeByName(new ResourceLocation(String.format("gregtech:wrench_%s", m.toString())));
            }
        }
        //Remove Old Bucket Recipe
        removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.Iron, 12),
                IntCircuitIngredient.getIntegratedCircuit(1));
        removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate, Materials.WroughtIron, 12),
                IntCircuitIngredient.getIntegratedCircuit(1));

        //Fix Brick Exploit
        removeRecipesByInputs(RecipeMaps.MACERATOR_RECIPES,new ItemStack(Items.BRICK));

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
                OreDictUnifier.get(OrePrefix.plate,Materials.Europium,4));

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
                new ItemStack[]{OreDictUnifier.get(OrePrefix.dust,Materials.Silicon)},
                new FluidStack[]{Materials.Epichlorhydrin.getFluid(144)});

        //Remove Cracker recipe
        removeAllRecipes(RecipeMaps.CRACKING_RECIPES);
        removeAllRecipes(RecipeMaps.DISTILLATION_RECIPES);
        removeRecipesByInputs(RecipeMaps.DISTILLERY_RECIPES,Materials.CrackedHeavyFuel.getFluid(25));
        removeRecipesByInputs(RecipeMaps.DISTILLERY_RECIPES,Materials.CrackedLightFuel.getFluid(25));

        //Remove Pyrolise Oven Recipes
        removeAllRecipes(RecipeMaps.PYROLYSE_RECIPES);

        //Remove Hydrogen Sulfide Recipes
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,Materials.NaturalGas.getFluid(1600),Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,Materials.SulfuricGas.getFluid(1600),Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,Materials.SulfuricLightFuel.getFluid(1600),Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,Materials.SulfuricHeavyFuel.getFluid(1600),Materials.Hydrogen.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,Materials.SulfuricNaphtha.getFluid(1600),Materials.Hydrogen.getFluid(1000));
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
