package gregicadditions.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.machines.FuelRecipeMap;

public class GARecipeMaps {

	public static final RecipeMap<SimpleRecipeBuilder> CLUSTER_MILL_RECIPES;
	public static final RecipeMapAssemblyLine<SimpleRecipeBuilder> ASSEMBLY_LINE_RECIPES;
	public static final FuelRecipeMap NAQUADAH_REACTOR_FUELS;
	public static final RecipeMap<SimpleRecipeBuilder> MASS_FAB_RECIPES;
	public static final RecipeMap<SimpleRecipeBuilder> REPLICATOR_RECIPES;
	public static final RecipeMap<SimpleRecipeBuilder> CRACKER_UNIT_RECIPES;
	public static final RecipeMap<NoEURecipeBuilder> COKE_OVEN_RECIPES;
	
	static {
		CLUSTER_MILL_RECIPES = (new RecipeMap<>("cluster_mill", 1, 1, 1, 1, 0, 0, 0, 0, 1, new SimpleRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.BENDER_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
		ASSEMBLY_LINE_RECIPES = (new RecipeMapAssemblyLine<>("assembly_line", 4, 16, 1, 1, 0, 4, 0, 0, 1, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
		ASSEMBLY_LINE_RECIPES.setSlotOverlay(false, false, GuiTextures.MOLD_OVERLAY);
		NAQUADAH_REACTOR_FUELS = new FuelRecipeMap("naquadah_reactor");
		MASS_FAB_RECIPES = (new RecipeMap<>("mass_fab", 0, 1, 0, 0, 0, 1, 1, 2, 8, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
		REPLICATOR_RECIPES = (new RecipeMap<>("replicator", 0, 1, 0, 1, 1, 2, 0, 1, 8, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
		COKE_OVEN_RECIPES = new RecipeMap<>("coke_oven", 1, 1, 0, 1, 0, 0, 0, 1, 0, (new NoEURecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
		CRACKER_UNIT_RECIPES = new RecipeMap<>("cracker_unit", 0, 0, 0, 0, 2, 2, 1, 1, 1, (new SimpleRecipeBuilder()).notOptimized());
		
	}
}
