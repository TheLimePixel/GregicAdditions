package gregicadditions.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import stanhebben.zenscript.annotations.ZenProperty;

public class GARecipeMaps {
    @ZenProperty
    public static final RecipeMap<IntCircuitRecipeBuilder> CIRCUIT_ASSEMBLER_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> CLUSTER_MILL_RECIPES;

    static {
        CIRCUIT_ASSEMBLER_RECIPES = (new RecipeMap("circuit_assembler", 1, 6, 1, 1, 0, 1, 0, 0, 1, new AssemblerRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL);
        CLUSTER_MILL_RECIPES = (new RecipeMap("cluster_mill", 1, 1, 1, 1, 0, 0, 0, 0, 1, new SimpleRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.BENDER_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);

    }
}
