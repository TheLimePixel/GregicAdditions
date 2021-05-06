package gregicadditions.recipes;

import forestry.core.fluids.Fluids;
import gregicadditions.GAConfig;
import gregicadditions.GAMaterials;
import gregicadditions.GregicAdditions;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.machines.FuelRecipeMap;
import gregtech.api.recipes.recipes.FuelRecipe;
import gregtech.api.unification.material.Materials;
import gregtech.loaders.recipe.FuelRecipes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

public class GeneratorFuels {
	public static void init() {
		//Removal
		removeFuelRecipe(RecipeMaps.DIESEL_GENERATOR_FUELS, Materials.LightFuel.getFluid(1));
		removeFuelRecipe(RecipeMaps.SEMI_FLUID_GENERATOR_FUELS, Materials.Creosote.getFluid(14));
		removeFuelRecipe(RecipeMaps.SEMI_FLUID_GENERATOR_FUELS, Materials.OilLight.getFluid(64));
		removeFuelRecipe(RecipeMaps.SEMI_FLUID_GENERATOR_FUELS, Materials.OilMedium.getFluid(32));
		removeFuelRecipe(RecipeMaps.STEAM_TURBINE_FUELS, Materials.Steam.getFluid(60));

		//Steam Turbine
		FuelRecipes.registerSteamGeneratorFuel(Materials.Steam.getFluid(64), 1, GTValues.LV);

		//Gas Turbine Fuels
		FuelRecipes.registerGasGeneratorFuel(Materials.RocketFuel.getFluid(16), 125, GTValues.LV);

		//Diesel Generator Fluids
		FuelRecipes.registerDieselGeneratorFuel(Materials.RocketFuel.getFluid(2), 7, GTValues.LV);
		FuelRecipes.registerDieselGeneratorFuel(Materials.LightFuel.getFluid(32), 305, GTValues.LV);

		//Naquadah Reactor
		registerNaquadahReactorFuel(Materials.NaquadahEnriched.getFluid(1), 750, GTValues.LV);

		//Semifuels
		FuelRecipes.registerSemiFluidGeneratorFuel(GAMaterials.FISH_OIL.getFluid(64), 1, GTValues.LV);
		if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) FuelRecipes.registerSemiFluidGeneratorFuel(Fluids.SEED_OIL.getFluid(64), 1, GTValues.LV);
		else FuelRecipes.registerSemiFluidGeneratorFuel(Materials.SeedOil.getFluid(64), 1, GTValues.LV);
		FuelRecipes.registerSemiFluidGeneratorFuel(Materials.Creosote.getFluid(16), 1, GTValues.LV);
		FuelRecipes.registerSemiFluidGeneratorFuel(Materials.Biomass.getFluid(16), 1, GTValues.LV);
		FuelRecipes.registerSemiFluidGeneratorFuel(Materials.OilLight.getFluid(32), 5, GTValues.LV);
		FuelRecipes.registerSemiFluidGeneratorFuel(Materials.OilMedium.getFluid(64), 15, GTValues.LV);
	}

	//Register Methods
	public static void registerPlasmaFuel(FluidStack fuelStack, int duration, int tier) {
		RecipeMaps.PLASMA_GENERATOR_FUELS.addRecipe(new FuelRecipe(fuelStack, duration, GTValues.V[tier]));
	}

	//Register Methods
	public static void registerNaquadahReactorFuel(FluidStack fuelStack, int duration, int tier) {
		GARecipeMaps.NAQUADAH_REACTOR_FUELS.addRecipe(new FuelRecipe(fuelStack, duration, GTValues.V[tier]));
	}

	private static void removeFuelRecipe(FuelRecipeMap map, FluidStack fluidStack) {
		if(map.removeRecipe(map.findRecipe(Integer.MAX_VALUE, fluidStack))) {
			GregicAdditions.LOGGER.debug("Removed Generator Recipe for {} for Fluid: {}", map.getUnlocalizedName(), fluidStack.getLocalizedName());
		}
		else {
			GregicAdditions.LOGGER.warn("Failed to remove Generator Recipe for {} for Fluid: {}", map.getUnlocalizedName(), fluidStack.getLocalizedName());
		}
	}
}
