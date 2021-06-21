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
import gregtech.api.unification.material.type.FluidMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.loaders.oreprocessing.WireRecipeHandler.INSULATION_MATERIALS;


public class GAMachineRecipeRemoval {

	private static final MaterialStack[] solderingList = { new MaterialStack(Materials.Tin, 2L), new MaterialStack(Materials.SolderingAlloy, 1L), new MaterialStack(Materials.Lead, 4L) };

	private static final FluidStack[] cableFluids = { Materials.Rubber.getFluid(144), Materials.StyreneButadieneRubber.getFluid(108), Materials.SiliconeRubber.getFluid(72) };


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
			//Since the cables are EV+ tier, they are only covered with SBR and SR
			if (GAConfig.GT5U.CablesGT5U) {
				if(m instanceof IngotMaterial) {
					if(((IngotMaterial) m).cableProperties != null && ((IngotMaterial) m).cableProperties.voltage >= GTValues.EV) {
						for(FluidMaterial insulationMaterial : INSULATION_MATERIALS.keySet()) {

							int cableTier = GTUtility.getTierByVoltage(((IngotMaterial) m).cableProperties.voltage);
							int insulationTier = INSULATION_MATERIALS.get(insulationMaterial);
							if(cableTier > insulationTier) {
								continue;
							}
							int fluidAmount = Math.max(36, 144 / (1 + (insulationTier - cableTier) / 2));

							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount) });
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 2), IntCircuitIngredient.getIntegratedCircuit(25) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 2)});
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 4), IntCircuitIngredient.getIntegratedCircuit(26) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 4)});
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 8), IntCircuitIngredient.getIntegratedCircuit(27) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 8)});
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtSingle, m, 16), IntCircuitIngredient.getIntegratedCircuit(28) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 16)});
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtDouble, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 2)});
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 4)});
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtOctal, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 8)});
							removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] { OreDictUnifier.get(OrePrefix.wireGtHex, m), IntCircuitIngredient.getIntegratedCircuit(24) }, new FluidStack[] { insulationMaterial.getFluid(fluidAmount * 16)});
						}
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


		//Remove the GTCE Pump assembler recipes to match our table recipes
		for(FluidStack stackFluid : cableFluids) {
			removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] {OreDictUnifier.get(OrePrefix.plate, Materials.Tin, 2), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin), OreDictUnifier.get(OrePrefix.screw, Materials.Tin), OreDictUnifier.get(OrePrefix.rotor, Materials.Tin), MetaItems.ELECTRIC_MOTOR_LV.getStackForm()}, new FluidStack[] {stackFluid});
			removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] {OreDictUnifier.get(OrePrefix.plate, Materials.Bronze, 2), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper), OreDictUnifier.get(OrePrefix.screw, Materials.Bronze), OreDictUnifier.get(OrePrefix.rotor, Materials.Bronze), MetaItems.ELECTRIC_MOTOR_MV.getStackForm()}, new FluidStack[] {stackFluid});
			removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] {OreDictUnifier.get(OrePrefix.plate, Materials.Steel, 2), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper), OreDictUnifier.get(OrePrefix.screw, Materials.Steel), OreDictUnifier.get(OrePrefix.rotor, Materials.Steel), MetaItems.ELECTRIC_MOTOR_HV.getStackForm()}, new FluidStack[] {stackFluid});
			removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] {OreDictUnifier.get(OrePrefix.plate, Materials.StainlessSteel, 2), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Aluminium), OreDictUnifier.get(OrePrefix.screw, Materials.StainlessSteel), OreDictUnifier.get(OrePrefix.rotor, Materials.StainlessSteel), MetaItems.ELECTRIC_MOTOR_EV.getStackForm()}, new FluidStack[] {stackFluid});
			removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, new ItemStack[] {OreDictUnifier.get(OrePrefix.plate, Materials.TungstenSteel, 2), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tungsten), OreDictUnifier.get(OrePrefix.screw, Materials.TungstenSteel), OreDictUnifier.get(OrePrefix.rotor, Materials.TungstenSteel), MetaItems.ELECTRIC_MOTOR_IV.getStackForm()}, new FluidStack[] {stackFluid});
		}


	}

	private static <R extends RecipeBuilder<R>> void removeRecipesByInputs(RecipeMap<R> map, ItemStack... itemInputs) {
		List<ItemStack> inputs = new ArrayList<>();
		List<String> names = new ArrayList<>();
		for (ItemStack s : itemInputs) {
			inputs.add(s);
			names.add(String.format("%s x %d", s.getDisplayName(), s.getCount()));
		}

		if(map.removeRecipe(map.findRecipe(Long.MAX_VALUE, inputs, Collections.emptyList(), Integer.MAX_VALUE))) {
			GregicAdditions.LOGGER.debug("Removed Recipe for Item Input(s): {}", names);
		}
		else {
			GregicAdditions.LOGGER.warn("Failed to Remove Recipe for Item Input(s): {}", names);
		}
	}

	private static <R extends RecipeBuilder<R>> void removeRecipesByInputs(RecipeMap<R> map, FluidStack... fluidInputs) {
		List<FluidStack> inputs = new ArrayList<>();
		List<String> names = new ArrayList<>();
		for (FluidStack s : fluidInputs) {
			inputs.add(s);
			names.add(String.format("%s x %d", s.getFluid().getName(), s.amount));
		}

		if(map.removeRecipe(map.findRecipe(Long.MAX_VALUE, Collections.emptyList(), inputs, Integer.MAX_VALUE))) {
			GregicAdditions.LOGGER.debug("Removed Recipe for Fluid Input(s): {}", names);
		}
		else {
			GregicAdditions.LOGGER.warn("Failed to Remove Recipe for Fluid Input(s): {}", names);
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
			GregicAdditions.LOGGER.debug("Removed Recipe for inputs: Items: {} Fluids: {}", itemNames, fluidNames);
		}
		else {
			GregicAdditions.LOGGER.warn("Failed to Remove Recipe for inputs: Items: {} Fluids: {}", itemNames, fluidNames);
		}
	}

	private static <R extends RecipeBuilder<R>> void removeAllRecipes(RecipeMap<R> map) {

		List<Recipe> recipes = new ArrayList<>();
		recipes.addAll(map.getRecipeList());

		for (Recipe r : recipes)
			map.removeRecipe(r);
	}
}
