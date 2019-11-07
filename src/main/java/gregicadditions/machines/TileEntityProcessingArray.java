package gregicadditions.machines;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.BlockWorldState;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.multiblock.PatternMatchContext;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.Textures;
import gregtech.api.util.GTUtility;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gregicadditions.GAEnums;
import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.GregTechAPI;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.capability.impl.MultiblockRecipeLogic;

public class TileEntityProcessingArray extends RecipeMapMultiblockController {

	private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = { MultiblockAbility.IMPORT_ITEMS,
			MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.IMPORT_FLUIDS, MultiblockAbility.EXPORT_FLUIDS,
			MultiblockAbility.INPUT_ENERGY };

	public TileEntityProcessingArray(ResourceLocation metaTileEntityId) {
		super(metaTileEntityId, GARecipeMaps.PROCESSING_ARRAY_RECIPES);
		ProcessingArrayWorkable recipeLogic = new ProcessingArrayWorkable(this);
		recipeLogic.initReflection();
		this.recipeMapWorkable = recipeLogic;

	}

	@Override
	protected BlockPattern createStructurePattern() {

		return FactoryBlockPattern.start().aisle("XXX", "XXX", "XXX").aisle("XXX", "X#X", "XXX")
				.aisle("XXX", "XSX", "XXX").where('S', selfPredicate())
				.where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
				.where('#', isAirPredicate()).build();

	}

	public IBlockState getCasingState() {
		return MetaBlocks.METAL_CASING.getState(MetalCasingType.TUNGSTENSTEEL_ROBUST);
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart arg0) {
		// TODO Auto-generated method stub
		return Textures.ROBUST_TUNGSTENSTEEL_CASING;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
		// TODO Auto-generated method stub
		return new TileEntityProcessingArray(metaTileEntityId);
	}

	protected class ProcessingArrayWorkable extends MultiblockRecipeLogic {


		int machineTierVoltage = 0;
		int numberOfMachines = 0;
		int numberOfOperations = 0;
		String machineName = "";
		Field isActiveField = null;
		Field wasActiveAndNeedsUpdateField = null;
		Field hasNotEnoughEnergyField = null;
		// Method setActiveMethod = null;

		public RecipeMap getRecipeMaps(String machineName) {
			switch (machineName) {
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
			case "furnace":
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
			default :
				return null;
			}

			

		}

		public void initReflection() {
			isActiveField = ObfuscationReflectionHelper.findField(AbstractRecipeLogic.class, "isActive");
			wasActiveAndNeedsUpdateField = ObfuscationReflectionHelper.findField(AbstractRecipeLogic.class,
					"wasActiveAndNeedsUpdate");
			// setActiveMethod =
			// ObfuscationReflectionHelper.findMethod(AbstractRecipeLogic.class,
			// "setActive", null, Boolean.class);
			hasNotEnoughEnergyField = ObfuscationReflectionHelper.findField(AbstractRecipeLogic.class,
					"hasNotEnoughEnergy");
		}

		public ProcessingArrayWorkable(RecipeMapMultiblockController tileEntity) {
			super(tileEntity);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected Recipe findRecipe(long maxVoltage, IItemHandlerModifiable inputs, IMultipleTankHandler fluidInputs) {

			String machineName = findMachine(inputs, fluidInputs);
			RecipeMap recipeM = getRecipeMaps(machineName);

			if (recipeM == null) {
				return null;
			}

			Recipe r = recipeM.findRecipe(machineTierVoltage, inputs, fluidInputs,
					this.getMinTankCapacity(this.getOutputTank()));		
			return r;

		}
		


		protected String findMachine(IItemHandlerModifiable inputs, IMultipleTankHandler fluidInputs) {

			for (int slot = 0; slot < inputs.getSlots(); slot++) {
				// find tileentity
				ItemStack wholeItemStack = inputs.getStackInSlot(slot);

				String unlocalizedName = wholeItemStack.getItem().getUnlocalizedNameInefficiently(wholeItemStack);
				if (unlocalizedName.contains("gregtech.machine") || unlocalizedName.contains("gtadditions.machine")) {
					this.numberOfMachines = Math.min(16, wholeItemStack.getCount());
					String trimmedName = "";
					String voltage = unlocalizedName.substring(unlocalizedName.lastIndexOf(".") + 1);
					trimmedName = unlocalizedName.substring(0, unlocalizedName.lastIndexOf("."));
					this.machineName = trimmedName.substring(trimmedName.lastIndexOf(".") + 1);
					this.machineTierVoltage = GAEnums.voltageMap.get(voltage);
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

			
			this.numberOfOperations = 0;

			for (int i = 0; i < numberOfMachines; i++) {
				if (MetaTileEntity.addItemsToItemHandler(exportInventory, true,
						recipe.getAllItemOutputs(exportInventory.getSlots()))
						&& MetaTileEntity.addFluidsToFluidHandler(exportFluids, true, recipe.getFluidOutputs())) {

				
					if (recipe.matches(true, importInventory, importFluids)) {
						numberOfOperations++;
					} else {
						break;
					}
				}
			}
			
			
			int[] resultOverclock = calculateOverclock(recipe.getEUt(), machineTierVoltage, recipe.getDuration());
			int totalEUt = resultOverclock[0] * resultOverclock[1] * this.numberOfOperations;

			
			
			boolean enoughPower = totalEUt >= 0
					? getEnergyStored() >= (totalEUt > getEnergyCapacity() / 2 ? resultOverclock[0] : totalEUt)
					: (getEnergyStored() - resultOverclock[0] <= getEnergyCapacity());

			if (!enoughPower) {
				return false;
			}

		
		

			return numberOfOperations > 0;
		}

		@Override
		protected void completeRecipe() {

			List<ItemStack> outputI = new ArrayList();
			List<FluidStack> outputF = new ArrayList();

			for (ItemStack s : itemOutputs) {
				int num = s.getCount() * numberOfOperations;
				int totalStacks = num / s.getMaxStackSize();
				ItemStack itemCopy = s.copy();
				itemCopy.setCount(num);
				outputI.add(itemCopy);

			}
			for (FluidStack f : fluidOutputs) {
				int fluidNum = f.amount * numberOfOperations;
				FluidStack fluidCopy = f.copy();
				fluidCopy.amount = fluidNum;
				outputF.add(fluidCopy);
			}

			
			MetaTileEntity.addItemsToItemHandler(getOutputInventory(), false, outputI);
			MetaTileEntity.addFluidsToFluidHandler(getOutputTank(), false,  outputF);
			this.progressTime = 0;
			setMaxProgress(0);
			this.recipeEUt = 0;
			this.fluidOutputs = null;
			this.itemOutputs = null;
			this.machineTierVoltage = 0;
			this.numberOfMachines = 0;
			this.numberOfOperations = 0;

			try {
				this.hasNotEnoughEnergyField.set(this, false);
				this.wasActiveAndNeedsUpdateField.set(this, true);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// force recipe recheck because inputs could have changed since last time
			// we checked them before starting our recipe, especially if recipe took long
			// time
			this.forceRecipeRecheck = true;
		}

		@Override
		protected void trySearchNewRecipe() {
			long maxVoltage = this.getMaxVoltage();
			Recipe currentRecipe = null;
			IItemHandlerModifiable importInventory = getInputInventory();
			IMultipleTankHandler importFluids = getInputTank();
			boolean dirty = checkRecipeInputsDirty(importInventory, importFluids);
			this.forceRecipeRecheck = false;
			// else, try searching new recipe for given inputs
			currentRecipe = findRecipe(maxVoltage, importInventory, importFluids);

			if (currentRecipe != null && setupAndConsumeRecipeInputs(currentRecipe)) {
				setupRecipe(currentRecipe);
			}

		}

	
		
		@Override
		protected void setupRecipe(Recipe recipe) {
			int[] resultOverclock = calculateOverclock(recipe.getEUt(), machineTierVoltage, recipe.getDuration());
			this.progressTime = 1;
			setMaxProgress(resultOverclock[1]);
			this.recipeEUt = resultOverclock[0] * this.numberOfOperations;
			this.fluidOutputs = GTUtility.copyFluidList(recipe.getFluidOutputs());
			int tier = getMachineTierForRecipe(recipe);
			this.itemOutputs = GTUtility
					.copyStackList(recipe.getResultItemOutputs(getOutputInventory().getSlots(), random, tier));
			try {
				if (this.wasActiveAndNeedsUpdateField.getBoolean(this)) {
					this.wasActiveAndNeedsUpdateField.set(this, false);
				} else {

					setActive(true);
					// this.setActiveMethod.invoke(this,true);
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		

		
		// hack over the internal AbstractRecipeLogic setActive method
		private void setActive(boolean active) {
			ObfuscationReflectionHelper.setPrivateValue(AbstractRecipeLogic.class, recipeMapWorkable, active,
					"isActive");
			metaTileEntity.markDirty();
			if (!metaTileEntity.getWorld().isRemote) {
				writeCustomData(1, buf -> buf.writeBoolean(active));
			}
		}
		

	}
}
