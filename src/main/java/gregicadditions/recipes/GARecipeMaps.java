package gregicadditions.recipes;

import gregicadditions.machines.CokeOvenRecipe;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import stanhebben.zenscript.annotations.ZenProperty;

import java.util.ArrayList;
import java.util.List;

public class GARecipeMaps {
    @ZenProperty
    public static final RecipeMap<IntCircuitRecipeBuilder> CIRCUIT_ASSEMBLER_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> CLUSTER_MILL_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> ASSEMBLY_LINE_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> NAQUADAH_REACTOR;
    public static final RecipeMap<SimpleRecipeBuilder> MASS_FAB_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> REPLICATOR_RECIPES;
    public static final List<CokeOvenRecipe> COKE_OVEN_RECIPES;

    static {
        CIRCUIT_ASSEMBLER_RECIPES = (new RecipeMap("circuit_assembler", 1, 6, 1, 1, 0, 1, 0, 0, 1, new AssemblerRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL);
        CLUSTER_MILL_RECIPES = (new RecipeMap("cluster_mill", 1, 1, 1, 1, 0, 0, 0, 0, 1, new SimpleRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.BENDER_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
        ASSEMBLY_LINE_RECIPES = (new RecipeMap("assembly_line", 4, 15, 1, 1, 0, 4, 0, 0, 1, new SimpleRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.MOLD_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
        NAQUADAH_REACTOR = new RecipeMap("naquadah_reactor",1,1,1,1,0,0,0,0,1, new SimpleRecipeBuilder()).setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
        MASS_FAB_RECIPES = (new RecipeMap("mass_fab", 0, 1, 0, 0, 0, 1, 1, 2, 1, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
        REPLICATOR_RECIPES = (new RecipeMap("replicator", 0, 1, 0, 1, 1, 2, 0, 1, 1, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
        COKE_OVEN_RECIPES = new ArrayList();
    }
}
