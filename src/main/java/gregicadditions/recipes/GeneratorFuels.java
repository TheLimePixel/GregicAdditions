package gregicadditions.recipes;

import forestry.core.fluids.Fluids;
import gregicadditions.GAConfig;
import gregicadditions.GAMaterials;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.machines.FuelRecipeMap;
import gregtech.api.recipes.recipes.FuelRecipe;
import gregtech.api.unification.material.Materials;
import gregtech.loaders.recipe.FuelRecipes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.List;

public class GeneratorFuels {
    public static void init() {
        //Removal
        removeAllRecipes(RecipeMaps.DIESEL_GENERATOR_FUELS);
        removeAllRecipes(RecipeMaps.GAS_TURBINE_FUELS);
        removeAllRecipes(RecipeMaps.SEMI_FLUID_GENERATOR_FUELS);
        removeAllRecipes(RecipeMaps.STEAM_TURBINE_FUELS);

        //Steam Turbine
        FuelRecipes.registerSteamGeneratorFuel(Materials.Steam.getFluid(64), 1, GTValues.LV);

        //Gas Turbine Fuels
        FuelRecipes.registerGasGeneratorFuel(Materials.NaturalGas.getFluid(8), 5, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Hydrogen.getFluid(8), 5, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.CarbonMonoxde.getFluid(8), 6, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.WoodGas.getFluid(8), 6, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.SulfuricGas.getFluid(32), 25, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.SulfuricNaphtha.getFluid(4), 5, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Methane.getFluid(4), 14, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Ethylene.getFluid(1), 4, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Gas.getFluid(1), 5, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Ethane.getFluid(4), 21, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Propene.getFluid(1), 6, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Butadiene.getFluid(16), 103, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Propane.getFluid(4), 29, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.RocketFuel.getFluid(16), 125, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Butene.getFluid(1), 8, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Phenol.getFluid(1), 9, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Benzene.getFluid(1), 9, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Butane.getFluid(4), 37, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.LPG.getFluid(1), 10, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Naphtha.getFluid(1), 10, GTValues.LV);
        FuelRecipes.registerGasGeneratorFuel(Materials.Toluene.getFluid(4), 41, GTValues.LV);

        //Diesel Generator Fluids
        FuelRecipes.registerDieselGeneratorFuel(Materials.Oil.getFluid(2), 1, GTValues.LV);
        FuelRecipes.registerDieselGeneratorFuel(Materials.SulfuricLightFuel.getFluid(4), 5, GTValues.LV);
        FuelRecipes.registerDieselGeneratorFuel(Materials.Methanol.getFluid(8), 21, GTValues.LV);
        FuelRecipes.registerDieselGeneratorFuel(Materials.RocketFuel.getFluid(2), 7, GTValues.LV);
        if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration)
            FuelRecipes.registerDieselGeneratorFuel(Fluids.BIO_ETHANOL.getFluid(1), 6, GTValues.LV);
        else
            FuelRecipes.registerDieselGeneratorFuel(Materials.Ethanol.getFluid(1), 6, GTValues.LV);
        FuelRecipes.registerDieselGeneratorFuel(Materials.BioDiesel.getFluid(1), 8, GTValues.LV);
        FuelRecipes.registerDieselGeneratorFuel(Materials.LightFuel.getFluid(32), 305, GTValues.LV);
        FuelRecipes.registerDieselGeneratorFuel(Materials.Fuel.getFluid(1), 15, GTValues.LV);
        FuelRecipes.registerDieselGeneratorFuel(Materials.NitroFuel.getFluid(2), 45, GTValues.LV);

        //Naquadah Reactor
        registerNaquadahReactorFuel(Materials.NaquadahEnriched.getFluid(1), 750, GTValues.LV);

        //Smefuels
        FuelRecipes.registerSemiFluidGeneratorFuel(GAMaterials.FishOil.getFluid(64), 1, GTValues.LV);
        if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration)
            FuelRecipes.registerSemiFluidGeneratorFuel(Fluids.SEED_OIL.getFluid(64), 1, GTValues.LV);
        else
            FuelRecipes.registerSemiFluidGeneratorFuel(Materials.SeedOil.getFluid(64), 1, GTValues.LV);
        FuelRecipes.registerSemiFluidGeneratorFuel(Materials.Creosote.getFluid(16), 1, GTValues.LV);
        FuelRecipes.registerSemiFluidGeneratorFuel(Materials.Biomass.getFluid(16), 1, GTValues.LV);
        FuelRecipes.registerSemiFluidGeneratorFuel(Materials.OilLight.getFluid(32), 5, GTValues.LV);
        FuelRecipes.registerSemiFluidGeneratorFuel(Materials.OilMedium.getFluid(64), 15, GTValues.LV);
        FuelRecipes.registerSemiFluidGeneratorFuel(Materials.OilHeavy.getFluid(16), 5, GTValues.LV);
        FuelRecipes.registerSemiFluidGeneratorFuel(Materials.SulfuricHeavyFuel.getFluid(16), 5, GTValues.LV);
        FuelRecipes.registerSemiFluidGeneratorFuel(Materials.HeavyFuel.getFluid(8), 15, GTValues.LV);
    }

    //Register Methods
    public static void registerNaquadahReactorFuel(FluidStack fuelStack, int duration, int tier) {
        GARecipeMaps.NAQUADAH_REACTOR_FUELS.addRecipe(new FuelRecipe(fuelStack, duration, GTValues.V[tier]));
    }

    private static void removeAllRecipes(FuelRecipeMap map) {

        List<FuelRecipe> recipes = new ArrayList();
        recipes.addAll(map.getRecipeList());

        for (FuelRecipe r : recipes)
            map.removeRecipe(r);
    }
}
