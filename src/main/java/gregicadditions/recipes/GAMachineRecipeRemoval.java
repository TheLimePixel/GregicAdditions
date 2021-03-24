package gregicadditions.recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gregicadditions.GAConfig;
import gregicadditions.GregicAdditions;
import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
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

public class GAMachineRecipeRemoval {

	private static final MaterialStack[] solderingList = { new MaterialStack(Materials.Tin, 2L), new MaterialStack(Materials.SolderingAlloy, 1L), new MaterialStack(Materials.Lead, 4L) };

	public static void init() {
		for (Material m : Material.MATERIAL_REGISTRY) {

			//Foil recipes
			if(m instanceof IngotMaterial && m.hasFlag("GENERATE_FOIL")) {
				removeRecipesByInputs(RecipeMaps.BENDER_RECIPES, OreDictUnifier.get(OrePrefix.plate, m), IntCircuitIngredient.getIntegratedCircuit(0));
			}

			//Remove Old Wrench Recipes
			if (m instanceof IngotMaterial && !m.hasFlag(DustMaterial.MatFlags.NO_SMASHING) && GAConfig.GT6.ExpensiveWrenches) {
				ModHandler.removeRecipeByName(new ResourceLocation(String.format("gregtech:wrench_%s", m.toString())));
			}

			//Remove EV+ Cable Recipes
			if (GAConfig.GT5U.CablesGT5U) {
				if(m instanceof IngotMaterial) {
					if(((IngotMaterial) m).cableProperties != null && ((IngotMaterial) m).cableProperties.voltage >= GTValues.EV) {
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { Materials.Rubber.getFluid(144) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 2), IntCircuitIngredient.getIntegratedCircuit(25) }, new FluidStack[] { Materials.Rubber.getFluid(288) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 4), IntCircuitIngredient.getIntegratedCircuit(26) }, new FluidStack[] { Materials.Rubber.getFluid(576) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 8), IntCircuitIngredient.getIntegratedCircuit(27) }, new FluidStack[] { Materials.Rubber.getFluid(1152) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 16), IntCircuitIngredient.getIntegratedCircuit(28) }, new FluidStack[] { Materials.Rubber.getFluid(2304) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtDouble, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { Materials.Rubber.getFluid(288) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { Materials.Rubber.getFluid(576) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtOctal, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { Materials.Rubber.getFluid(1152) });
						removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtHex, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { Materials.Rubber.getFluid(2304) });

					}
				}
			}
		}

		//Remove Old Bucket Recipe
		if (GAConfig.GT6.BendingCurvedPlates && GAConfig.GT6.addCurvedPlates) {
			removeRecipesByInputs(RecipeMaps.BENDER_RECIPES, OreDictUnifier.get(OrePrefix.plate, Materials.Iron, 12), IntCircuitIngredient.getIntegratedCircuit(1));
			removeRecipesByInputs(RecipeMaps.BENDER_RECIPES, OreDictUnifier.get(OrePrefix.plate, Materials.WroughtIron, 12), IntCircuitIngredient.getIntegratedCircuit(1));
		}

		//Fix Brick Exploit
		removeRecipesByInputs(RecipeMaps.MACERATOR_RECIPES, new ItemStack(Items.BRICK));

		//Remove GTCE Circuit recipes
		removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm(8), OreDictUnifier.get(OrePrefix.plate, Materials.Darmstadtium, 16));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:primitive_circuit"));

		//Remove GT5 Ash Centrifuging
		removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.DarkAsh, 2));
		removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Ash));

		//Star Recipes
		removeRecipesByInputs(RecipeMaps.AUTOCLAVE_RECIPES, new ItemStack[] { new ItemStack(Items.NETHER_STAR) }, new FluidStack[] { Materials.Darmstadtium.getFluid(288) });

		//MAX Hull Recipes
		removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(OrePrefix.plate, Materials.Darmstadtium, 8), IntCircuitIngredient.getIntegratedCircuit(8));
		removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX), OreDictUnifier.get(OrePrefix.wireGtSingle, MarkerMaterials.Tier.Superconductor, 2) }, new FluidStack[] { Materials.Polytetrafluoroethylene.getFluid(288) });

		//Electrolyzing Fixes
		removeRecipesByInputs(RecipeMaps.ELECTROLYZER_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Sphalerite, 2));

		//Remove Cheap Diesel Recipe
		removeRecipesByInputs(RecipeMaps.MIXER_RECIPES, Materials.LightFuel.getFluid(5000), Materials.HeavyFuel.getFluid(1000));

		//Remove duplicate seed oil recipes if we are generating our own
		if(GAConfig.GTBees.GenerateExtractorRecipes) {
			removeRecipesByInputs(RecipeMaps.FLUID_EXTRACTION_RECIPES, new ItemStack(Items.WHEAT_SEEDS));
			removeRecipesByInputs(RecipeMaps.FLUID_EXTRACTION_RECIPES, new ItemStack(Items.MELON_SEEDS));
			removeRecipesByInputs(RecipeMaps.FLUID_EXTRACTION_RECIPES, new ItemStack(Items.PUMPKIN_SEEDS));
		}

		//Remove Conflicting Redstone Plate Recipe
		removeRecipesByInputs(RecipeMaps.COMPRESSOR_RECIPES, OreDictUnifier.get(OrePrefix.dust, Materials.Redstone));

		//Remove Incorrect Quartz Plate Recipes
		removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[] { new ItemStack(Blocks.QUARTZ_BLOCK) }, new FluidStack[] { Materials.Water.getFluid(73) });
		removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.block, Materials.CertusQuartz) }, new FluidStack[] { Materials.Water.getFluid(73) });
		removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[] { new ItemStack(Blocks.QUARTZ_BLOCK) }, new FluidStack[] { Materials.DistilledWater.getFluid(55) });
		removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.block, Materials.CertusQuartz) }, new FluidStack[] { Materials.DistilledWater.getFluid(55) });
		removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[] { new ItemStack(Blocks.QUARTZ_BLOCK) }, new FluidStack[] { Materials.Lubricant.getFluid(18) });
		removeRecipesByInputs(RecipeMaps.CUTTER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.block, Materials.CertusQuartz) }, new FluidStack[] { Materials.Lubricant.getFluid(18) });

	}

	private static <R extends RecipeBuilder<R>> void removeRecipesByInputs(RecipeMap<R> map, ItemStack... itemInputs) {
		List<ItemStack> inputs = new ArrayList<>();
		List<String> names = new ArrayList<>();
		for (ItemStack s : itemInputs) {
			inputs.add(s);
			names.add(s.getDisplayName() + " x " + s.getCount());
		}

		if(map.removeRecipe(map.findRecipe(Long.MAX_VALUE, inputs, Collections.emptyList(), Integer.MAX_VALUE))) {
			GregicAdditions.LOGGER.info("Removed Recipe for Item Input(s): " + names);
		}
		else {
			GregicAdditions.LOGGER.warn("Failed to Remove Recipe for Item Input(s): " + names);
		}
	}

	private static <R extends RecipeBuilder<R>> void removeRecipesByInputs(RecipeMap<R> map, FluidStack... fluidInputs) {
		List<FluidStack> inputs = new ArrayList<>();
		List<String> names = new ArrayList<>();
		for (FluidStack s : fluidInputs) {
			inputs.add(s);
			names.add(s.getFluid().getName() + " x " + s.amount);
		}

		if(map.removeRecipe(map.findRecipe(Long.MAX_VALUE, Collections.emptyList(), inputs, Integer.MAX_VALUE))) {
			GregicAdditions.LOGGER.info("Removed Recipe for Fluid Input(s): " + names);
		}
		else {
			GregicAdditions.LOGGER.warn("Failed to Remove Recipe for Fluid Input(s): " + names);
		}
	}

	private static <R extends RecipeBuilder<R>> void removeRecipesByInputs(RecipeMap<R> map, ItemStack[] itemInputs, FluidStack[] fluidInputs) {
		List<ItemStack> itemIn = new ArrayList<>();
		List<String> fluidNames = new ArrayList<>();
		List<String> itemNames = new ArrayList<>();
		for (ItemStack s : itemInputs) {
			itemIn.add(s);
			itemNames.add(s.getDisplayName() + " x " + s.getCount());
		}

		List<FluidStack> fluidIn = new ArrayList<>();
		for (FluidStack s : fluidInputs) {
			fluidIn.add(s);
			fluidNames.add(s.getFluid().getName() + " x " + s.amount);
		}

		if(map.removeRecipe(map.findRecipe(Long.MAX_VALUE, itemIn, fluidIn, Integer.MAX_VALUE))) {
			GregicAdditions.LOGGER.info("Removed Recipe for inputs: Items: " + itemNames + " Fluids: " + fluidNames);
		}
		else {
			GregicAdditions.LOGGER.info("Failed to Remove Recipe for inputs: Items: " + itemNames + " Fluids: " + fluidNames);
		}
	}

	private static <R extends RecipeBuilder<R>> void removeAllRecipes(RecipeMap<R> map) {

		List<Recipe> recipes = new ArrayList<>();
		recipes.addAll(map.getRecipeList());

		for (Recipe r : recipes)
			map.removeRecipe(r);
	}
}
