package gregicadditions.bees;

import com.google.common.collect.ImmutableMap;

import forestry.api.recipes.ICentrifugeRecipe;
import forestry.api.recipes.ISqueezerRecipe;
import forestry.api.recipes.RecipeManagers;
import forestry.apiculture.ModuleApiculture;
import forestry.core.ModuleCore;
import forestry.core.items.ItemFluidContainerForestry;
import gregicadditions.GAConfig;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;

import java.util.Collections;

public class ForestryMachineRecipes {
	public static void init() {

		if (GAConfig.GTBees.GenerateCentrifugeRecipes) for (ICentrifugeRecipe recipe : RecipeManagers.centrifugeManager.recipes()) {
			SimpleRecipeBuilder builder = RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder();
			builder.inputs(recipe.getInput().copy());
			for (ItemStack stack : recipe.getAllProducts().keySet()) {
				builder.chancedOutput(stack.copy(), (int) (recipe.getAllProducts().get(stack) * Recipe.getMaxChancedValue()), 1000);
			}
			builder.EUt(5);
			builder.duration(128);
			builder.buildAndRegister();
		}

		if (GAConfig.GTBees.GenerateExtractorRecipes) for (ISqueezerRecipe recipe : RecipeManagers.squeezerManager.recipes()) {
			if (recipe.getResources().size() != 1 || recipe.getResources().get(0).getItem() instanceof ItemFluidContainerForestry) continue;
			if (RecipeMaps.FLUID_EXTRACTION_RECIPES.findRecipe(Integer.MAX_VALUE, recipe.getResources(), Collections.emptyList(), Integer.MAX_VALUE) != null) continue;
			SimpleRecipeBuilder builder = RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder();
			builder.inputs(recipe.getResources().get(0).copy());
			if (!recipe.getRemnants().isEmpty()) builder.chancedOutput(recipe.getRemnants().copy(), (int) (recipe.getRemnantsChance() * Recipe.getMaxChancedValue()), 1000);
			if (recipe.getFluidOutput() != null) builder.fluidOutputs(recipe.getFluidOutput());
			builder.EUt(5);
			builder.duration(128);
			builder.buildAndRegister();
		}

		RecipeManagers.centrifugeManager.addRecipe(20, ModuleApiculture.getItems().propolis.getItemStack(), ImmutableMap.of(MetaItems.RUBBER_DROP.getStackForm(), 1.0f));

		//Combs
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.LIGNITE, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.gem, Materials.Lignite), 0.9f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f));
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.COAL, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.gem, Materials.Coal), 0.4f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f));
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.RUBBERY, 1), ImmutableMap.of(MetaItems.RUBBER_DROP.getStackForm(), 0.7f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f));
		RecipeManagers.squeezerManager.addRecipe(20, GTCombItem.getComb(GTCombs.OIL, 1), Materials.Oil.getFluid(150), ModuleCore.getItems().beeswax.getItemStack(), 30);
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.STONE, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.dust, Materials.Stone), 0.7f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f, OreDictUnifier.get(OrePrefix.dust, Materials.Salt), 0.2f, OreDictUnifier.get(OrePrefix.dust, Materials.RockSalt), 0.2f));
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.SLAG, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.dust, Materials.Stone), 0.5f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f, OreDictUnifier.get(OrePrefix.dust, Materials.GraniteBlack), 0.2f, OreDictUnifier.get(OrePrefix.dust, Materials.GraniteRed), 0.2f));
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.COPPON, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.dustTiny, Materials.Copper), 0.7f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f));
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.TINE, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.dustTiny, Materials.Tin), 0.6f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f));
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.PLUMBIA, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.dustTiny, Materials.Lead), 0.45f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f));
		RecipeManagers.centrifugeManager.addRecipe(20, GTCombItem.getComb(GTCombs.ARGENTIA, 1), ImmutableMap.of(OreDictUnifier.get(OrePrefix.dustTiny, Materials.Silver), 0.3f, ModuleCore.getItems().beeswax.getItemStack(), 0.3f));
	}
}