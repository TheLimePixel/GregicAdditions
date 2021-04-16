package gregicadditions.machines;

import gregicadditions.*;
import gregicadditions.recipes.*;
import gregtech.api.capability.*;
import gregtech.api.capability.impl.*;
import gregtech.api.metatileentity.*;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.multiblock.*;
import gregtech.api.recipes.*;
import gregtech.api.recipes.Recipe.*;
import gregtech.api.render.*;
import gregtech.api.util.*;
import gregtech.common.blocks.BlockMetalCasing.*;
import gregtech.common.blocks.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraftforge.fluids.*;
import net.minecraftforge.items.*;

import java.util.*;

public class TileEntityProcessingArray extends RecipeMapMultiblockController {

	private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
		MultiblockAbility.IMPORT_ITEMS,
		MultiblockAbility.EXPORT_ITEMS,
		MultiblockAbility.IMPORT_FLUIDS,
		MultiblockAbility.EXPORT_FLUIDS,
		MultiblockAbility.INPUT_ENERGY
	};

	public TileEntityProcessingArray(ResourceLocation metaTileEntityId) {
		super(metaTileEntityId, GARecipeMaps.PROCESSING_ARRAY_RECIPES);
		this.recipeMapWorkable = new ProcessingArrayWorkable(this);
	}

	@Override
	protected BlockPattern createStructurePattern() {

		return FactoryBlockPattern.start()
								  .aisle("XXX", "XXX", "XXX")
								  .aisle("XXX", "X#X", "XXX")
								  .aisle("XXX", "XSX", "XXX")
								  .setAmountAtLeast('L', 12)
								  .where('L', statePredicate(getCasingState()))
								  .where('S', selfPredicate())
								  .where('X',
										 statePredicate(getCasingState())
											 .or(abilityPartPredicate(ALLOWED_ABILITIES)))
								  .where('#', isAirPredicate()).build();
	}

	public IBlockState getCasingState() {
		return MetaBlocks.METAL_CASING.getState(MetalCasingType.TUNGSTENSTEEL_ROBUST);
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart arg0) {
		return Textures.ROBUST_TUNGSTENSTEEL_CASING;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
		return new TileEntityProcessingArray(metaTileEntityId);
	}

	protected static class ProcessingArrayWorkable extends MultiblockRecipeLogic {
		int machineTierVoltage = 0;
		int numberOfMachines = 0;
		int numberOfOperations = 0;
		ItemStack machineItemStack = null;
		String machineName = "";

		public ProcessingArrayWorkable(RecipeMapMultiblockController tileEntity) {
			super(tileEntity);
		}

		// FIXME: there's gotta be a better way to do this
		public RecipeMap<?> getRecipeMaps(String machineName) {
			switch(machineName) {
				case "macerator":
					return RecipeMaps.MACERATOR_RECIPES;
				case "cluster_mill":
					return GARecipeMaps.CLUSTER_MILL_RECIPES;
				case "lathe":
					return RecipeMaps.LATHE_RECIPES;
				case "extractor":
					return RecipeMaps.EXTRACTOR_RECIPES;
				case "fluid_extractor":
					return RecipeMaps.FLUID_EXTRACTION_RECIPES;
				case "alloy_smelter":
					return RecipeMaps.ALLOY_SMELTER_RECIPES;
				case "ore_washer":
					return RecipeMaps.ORE_WASHER_RECIPES;
				case "thermal_centrifuge":
					return RecipeMaps.THERMAL_CENTRIFUGE_RECIPES;
				case "centrifuge":
					return RecipeMaps.CENTRIFUGE_RECIPES;
				case "electrolyzer":
					return RecipeMaps.ELECTROLYZER_RECIPES;
				case "electric_furnace":
					return RecipeMaps.FURNACE_RECIPES;
				case "bender":
					return RecipeMaps.BENDER_RECIPES;
				case "arc_furnace":
					return RecipeMaps.ARC_FURNACE_RECIPES;
				case "autoclave":
					return RecipeMaps.AUTOCLAVE_RECIPES;
				case "assembler":
					return RecipeMaps.ASSEMBLER_RECIPES;
				case "brewery":
					return RecipeMaps.BREWING_RECIPES;
				case "canner":
					return RecipeMaps.CANNER_RECIPES;
				case "chemical_bath":
					return RecipeMaps.CHEMICAL_BATH_RECIPES;
				case "chemical_reactor":
					return RecipeMaps.CHEMICAL_RECIPES;
				case "compressor":
					return RecipeMaps.COMPRESSOR_RECIPES;
				case "cutter":
					return RecipeMaps.CUTTER_RECIPES;
				case "distillery":
					return RecipeMaps.DISTILLATION_RECIPES;
				case "electromagnetic_separator":
					return RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES;
				case "fermenter":
					return RecipeMaps.FERMENTING_RECIPES;
				case "fluid_canner":
					return RecipeMaps.FLUID_CANNER_RECIPES;
				case "fluid_heater":
					return RecipeMaps.FLUID_HEATER_RECIPES;
				case "fluid_solidifier":
					return RecipeMaps.FLUID_SOLIDFICATION_RECIPES;
				case "forge_hammer":
					return RecipeMaps.FORGE_HAMMER_RECIPES;
				case "forming_press":
					return RecipeMaps.FORMING_PRESS_RECIPES;
				case "microwave":
					return RecipeMaps.MICROWAVE_RECIPES;
				case "mixer":
					return RecipeMaps.MIXER_RECIPES;
				case "packer":
					return RecipeMaps.PACKER_RECIPES;
				case "unpacker":
					return RecipeMaps.UNPACKER_RECIPES;
				case "plasma_arc_furnace":
					return RecipeMaps.PLASMA_ARC_FURNACE_RECIPES;
				case "polarizer":
					return RecipeMaps.POLARIZER_RECIPES;
				case "laser_engraver":
					return RecipeMaps.LASER_ENGRAVER_RECIPES;
				case "wiremill":
					return RecipeMaps.WIREMILL_RECIPES;
				case "mass_fab":
					return GARecipeMaps.MASS_FAB_RECIPES;
				case "replicator":
					return GARecipeMaps.REPLICATOR_RECIPES;
				case "sifter":
					return RecipeMaps.SIFTER_RECIPES;
				case "extruder":
					return RecipeMaps.EXTRUDER_RECIPES;
				case "bundler":
					return GARecipeMaps.BUNDLER_RECIPES;
				default:
					return null;
			}

		}

		@Override
		protected Recipe findRecipe(long maxVoltage,
									IItemHandlerModifiable inputs,
									IMultipleTankHandler fluidInputs) {

			String machineName = findMachine(inputs);
			RecipeMap<?> recipeMap = getRecipeMaps(machineName);

			// No valid recipe map.
			if(recipeMap == null)
				return null;

			Recipe recipe = recipeMap.findRecipe(machineTierVoltage,
												 inputs,
												 fluidInputs,
												 this.getMinTankCapacity(this.getOutputTank()));

			// No matching recipe.
			if(recipe == null)
				return null;

			int itemMultiplier = getMinRatioItem(findIngredients(inputs), recipe, this.numberOfMachines);
			int fluidMultiplier = getMinRatioFluid(findFluid(fluidInputs), recipe, this.numberOfMachines);

			int minMultiplier = Math.min(itemMultiplier, fluidMultiplier);

			// No inputs or fluids
			if(minMultiplier == Integer.MAX_VALUE) {
				GTLog.logger.error("Cannot calculate ratio of items for processing array");
				return null;
			}

			List<CountableIngredient> newRecipeInputs = new ArrayList<>();
			List<FluidStack> newFluidInputs = new ArrayList<>();
			List<ItemStack> outputI = new ArrayList<>();
			List<FluidStack> outputF = new ArrayList<>();
			this.multiplyInputsAndOutputs(newRecipeInputs,
										  newFluidInputs,
										  outputI,
										  outputF,
										  recipe,
										  minMultiplier);

			RecipeBuilder<?> newRecipe = recipeMap.recipeBuilder()
												  .inputsIngredients(newRecipeInputs)
												  .fluidInputs(newFluidInputs)
												  .outputs(outputI)
												  .fluidOutputs(outputF)
												  .EUt(recipe.getEUt())
												  .duration(recipe.getDuration());

			copyChancedItemOutputs(newRecipe, recipe, minMultiplier);
			newRecipe.notConsumable(this.machineItemStack);
			this.numberOfOperations = minMultiplier;
			return newRecipe.build().getResult();
		}

		protected static void copyChancedItemOutputs(RecipeBuilder<?> newRecipe,
													 Recipe oldRecipe,
													 int numberOfOperations) {
			for(ChanceEntry entry : oldRecipe.getChancedOutputs()) {
				int chance = entry.getChance();
				ItemStack itemStack = entry.getItemStack().copy();
				int boost = entry.getBoostPerTier();
				itemStack.setCount(itemStack.getCount() * numberOfOperations);

				newRecipe.chancedOutput(itemStack, chance, boost);
			}
		}

		protected static Set<ItemStack> findIngredients(IItemHandlerModifiable inputs) {
			Set<ItemStack> countIngredients = new HashSet<>();
			for(int slot = 0; slot < inputs.getSlots(); slot++) {
				ItemStack wholeItemStack = inputs.getStackInSlot(slot);

				// skip empty slots
				if(wholeItemStack.isEmpty())
					continue;

				boolean found = false;
				for(ItemStack i : countIngredients)
					if(ItemStack.areItemsEqual(i, wholeItemStack)) {
						i.setCount(i.getCount() + wholeItemStack.getCount());
						found = true;
						break;
					}

				if(!found)
					countIngredients.add(wholeItemStack.copy());

			}
			return countIngredients;
		}

		protected int getMinRatioItem(Set<ItemStack> countIngredients,
									  Recipe recipe,
									  int numberOfMachines) {

			int minMultiplier = Integer.MAX_VALUE;
			for(CountableIngredient recipeInputs : recipe.getInputs()) {

				if(recipeInputs.getCount() == 0)
					continue;

				for(ItemStack wholeItemStack : countIngredients) {

					if(recipeInputs.getIngredient().apply(wholeItemStack)) {
						int ratio = Math.min(numberOfMachines, wholeItemStack.getCount() / recipeInputs.getCount());
						if(ratio < minMultiplier)
							minMultiplier = ratio;
						break;
					}

				}
			}
			return minMultiplier;
		}

		protected static Map<String, Integer> findFluid(IMultipleTankHandler fluidInputs) {

			Map<String, Integer> countFluid = new HashMap<>();
			for(IFluidTank tank : fluidInputs)
				if(tank.getFluid() != null) {

					String name = tank.getFluid().getUnlocalizedName();

					if(countFluid.containsKey(name)) {
						int existingValue = countFluid.get(name);
						countFluid.put(name, existingValue + tank.getFluidAmount());
					} else
						countFluid.put(name, tank.getFluidAmount());
				}
			return countFluid;
		}

		protected int getMinRatioFluid(Map<String, Integer> countFluid,
									   Recipe recipe,
									   int numberOfMachines) {

			int minMultiplier = Integer.MAX_VALUE;
			for(FluidStack fs : recipe.getFluidInputs()) {
				String name = fs.getFluid().getUnlocalizedName();
				int ratio = Math.min(numberOfMachines, countFluid.get(name) / fs.amount);

				if(ratio < minMultiplier)
					minMultiplier = ratio;
			}
			return minMultiplier;
		}

		protected static ItemStack copyItemStackWithCount(ItemStack itemStack, int count) {
			ItemStack itemCopy = itemStack.copy();
			itemCopy.setCount(count);
			return itemCopy;
		}

		protected static FluidStack copyFluidStackWithAmount(FluidStack fluidStack, int count) {
			FluidStack fluidCopy = fluidStack.copy();
			fluidCopy.amount = count;
			return fluidCopy;
		}

		protected void multiplyInputsAndOutputs(List<CountableIngredient> newRecipeInputs,
												List<FluidStack> newFluidInputs,
												List<ItemStack> outputItems,
												List<FluidStack> outputFluids,
												Recipe recipe,
												int numberOfOperations) {

			recipe.getInputs().forEach(ci ->
					newRecipeInputs.add(new CountableIngredient(ci.getIngredient(),
																ci.getCount() * numberOfOperations)));

			recipe.getFluidInputs().forEach(fluidStack ->
					newFluidInputs.add(new FluidStack(fluidStack.getFluid(),
													  fluidStack.amount * numberOfOperations)));

			recipe.getOutputs().forEach(itemStack ->
				outputItems.add(copyItemStackWithCount(itemStack,
													   itemStack.getCount() * numberOfOperations)));

			recipe.getFluidOutputs().forEach(fluidStack ->
				outputFluids.add(copyFluidStackWithAmount(fluidStack,
														  fluidStack.amount * numberOfOperations)));
		}

		protected String findMachine(IItemHandlerModifiable inputs) {

			for(int slot = 0; slot < inputs.getSlots(); slot++) {

				// find tileentity
				ItemStack wholeItemStack = inputs.getStackInSlot(slot);
				String unlocalizedName = wholeItemStack.getItem().getUnlocalizedNameInefficiently(wholeItemStack);

				if(unlocalizedName.contains("gregtech.machine") || unlocalizedName.contains("gtadditions.machine")) {
					this.numberOfMachines = Math.min(16, wholeItemStack.getCount());
					String trimmedName;
					String voltage = unlocalizedName.substring(unlocalizedName.lastIndexOf(".") + 1);
					trimmedName = unlocalizedName.substring(0, unlocalizedName.lastIndexOf("."));

					//Checks if the tile entity is actually a machine
					if(!GAEnums.voltageMap.containsKey(voltage))
						continue;

					this.machineName = trimmedName.substring(trimmedName.lastIndexOf(".") + 1);
					this.machineTierVoltage = GAEnums.voltageMap.get(voltage);
					this.machineItemStack = wholeItemStack;
					break;
				}
			}
			return machineName;
		}

		@Override
		protected boolean setupAndConsumeRecipeInputs(Recipe recipe) {

			IItemHandlerModifiable importInventory = getInputInventory();
			IItemHandlerModifiable exportInventory = getOutputInventory();
			IMultipleTankHandler importFluids = getInputTank();
			IMultipleTankHandler exportFluids = getOutputTank();

			int[] resultOverclock = calculateOverclock(recipe.getEUt(), machineTierVoltage, recipe.getDuration());
			int totalEUt = resultOverclock[0] * resultOverclock[1] * this.numberOfOperations;

			boolean enoughPower;
			if(totalEUt >= 0) {
				int capacity;
				if(totalEUt > getEnergyCapacity() / 2)
					capacity = resultOverclock[0];
				else
					capacity = totalEUt;
				enoughPower = getEnergyStored() >= capacity;
			} else {
				int power = resultOverclock[0] * this.numberOfOperations;
				enoughPower = getEnergyStored() - (long) power <= getEnergyCapacity();
			}

			if(!enoughPower)
				return false;

			return MetaTileEntity.addItemsToItemHandler(exportInventory,
														true,
														recipe.getAllItemOutputs(exportInventory.getSlots())) &&
				MetaTileEntity.addFluidsToFluidHandler(exportFluids, true, recipe.getFluidOutputs()) &&
				recipe.matches(true, importInventory, importFluids);
		}

		@Override
		protected void trySearchNewRecipe() {
			long maxVoltage = getMaxVoltage();
			Recipe currentRecipe = null;
			IItemHandlerModifiable importInventory = getInputInventory();
			IMultipleTankHandler importFluids = getInputTank();

			boolean dirty = checkRecipeInputsDirty(importInventory, importFluids);
			if(dirty || forceRecipeRecheck) {
				this.forceRecipeRecheck = false;

				// else, try searching new recipe for given inputs
				currentRecipe = findRecipe(maxVoltage, importInventory, importFluids);

				if(currentRecipe != null)
					this.previousRecipe = currentRecipe;

			} else if(previousRecipe != null &&
				previousRecipe.matches(false, importInventory, importFluids)) {
				// if previous recipe still matches inputs, try to use it
				currentRecipe = previousRecipe;
			}
			if(currentRecipe != null && setupAndConsumeRecipeInputs(currentRecipe))
				setupRecipe(currentRecipe);
		}

		@Override
		protected void setupRecipe(Recipe recipe) {
			int[] resultOverclock = calculateOverclock(recipe.getEUt(), machineTierVoltage, recipe.getDuration());
			this.progressTime = 1;
			setMaxProgress(resultOverclock[1]);
			this.recipeEUt = resultOverclock[0] * this.numberOfOperations;
			this.fluidOutputs = GTUtility.copyFluidList(recipe.getFluidOutputs());
			int tier = getMachineTierForRecipe(recipe);
			this.itemOutputs = GTUtility.copyStackList(recipe.getResultItemOutputs(getOutputInventory().getSlots(),
																				   random,
																				   tier));

			if(this.wasActiveAndNeedsUpdate)
				this.wasActiveAndNeedsUpdate = false;
			else
				setActive(true);
		}
	}
}
