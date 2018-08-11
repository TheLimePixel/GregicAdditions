package gregicadditions.recipes;

import gregicadditions.GAMaterials;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;

public class GeneratorFuels {
    public static void init() {
        //Gas Turbine Fuels
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.NaturalGas.getFluid(200)).EUt(-32).duration(94).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.Hydrogen.getFluid(200)).EUt(-32).duration(125).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.SulfuricGas.getFluid(200)).EUt(-32).duration(125).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.CarbonMonoxde.getFluid(200)).EUt(-32).duration(150).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.WoodGas.getFluid(200)).EUt(-32).duration(150).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.SulfuricNaphtha.getFluid(200)).EUt(-32).duration(200).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.BioGas.getFluid(200)).EUt(-32).duration(200).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.Methane.getFluid(200)).EUt(-32).duration(650).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.Gas.getFluid(200)).EUt(-32).duration(800).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Ethylene.getFluid(200)).EUt(-32).duration(800).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Ethane.getFluid(200)).EUt(-32).duration(1050).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Propene.getFluid(200)).EUt(-32).duration(1200).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Butadiene.getFluid(200)).EUt(-32).duration(1288).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Propane.getFluid(200)).EUt(-32).duration(1450).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Butene.getFluid(200)).EUt(-32).duration(1400).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.RocketFuel.getFluid(200)).EUt(-32).duration(1563).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.LPG.getFluid(200)).EUt(-32).duration(1600).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.Naphtha.getFluid(200)).EUt(-32).duration(1600).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Phenol.getFluid(200)).EUt(-32).duration(1800).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Benzene.getFluid(200)).EUt(-32).duration(1800).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(GAMaterials.Butane.getFluid(200)).EUt(-32).duration(1850).buildAndRegister();
        RecipeMaps.GAS_TURBINE_FUELS.recipeBuilder().fluidInputs(Materials.Toluene.getFluid(200)).EUt(-32).duration(2050).buildAndRegister();

        //Diesel Generator Fluids
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.BioFuel.getFluid(200)).EUt(-32).duration(38).buildAndRegister();
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.SulfuricLightFuel.getFluid(200)).EUt(-32).duration(200).buildAndRegister();
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(GAMaterials.Methanol.getFluid(200)).EUt(-32).duration(525).buildAndRegister();
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.Fuel.getFluid(200)).EUt(-32).duration(800).buildAndRegister();
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.Ethanol.getFluid(200)).EUt(-32).duration(925).buildAndRegister();
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(GAMaterials.BioDiesel.getFluid(200)).EUt(-32).duration(1200).buildAndRegister();
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.LightFuel.getFluid(200)).EUt(-32).duration(1600).buildAndRegister();
        RecipeMaps.DIESEL_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.NitroFuel.getFluid(200)).EUt(-32).duration(3200).buildAndRegister();

        //Naquadah Reactor
        GARecipeMaps.NAQUADAH_REACTOR_FUELS.recipeBuilder().fluidInputs(Materials.NaquadahEnriched.getFluid(200)).fluidOutputs(Materials.NaquadahEnriched.getFluid(200)).EUt(-2048).duration(1465).buildAndRegister();

        //Plasma Generator
        RecipeMaps.PLASMA_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.Helium.getPlasma(1000)).EUt(-524288).duration(8).buildAndRegister();
        RecipeMaps.PLASMA_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.Nitrogen.getPlasma(1000)).EUt(-524288).duration(27).buildAndRegister();
        RecipeMaps.PLASMA_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.Oxygen.getPlasma(1000)).EUt(-524288).duration(30).buildAndRegister();
        RecipeMaps.PLASMA_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.Iron.getPlasma(1000)).EUt(-524288).duration(109).buildAndRegister();
        RecipeMaps.PLASMA_GENERATOR_FUELS.recipeBuilder().fluidInputs(Materials.Nickel.getPlasma(1000)).EUt(-524288).duration(113).buildAndRegister();
    }
}
