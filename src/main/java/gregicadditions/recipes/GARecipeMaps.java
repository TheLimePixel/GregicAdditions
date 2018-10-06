package gregicadditions.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.builders.UniversalDistillationRecipeBuilder;
import gregtech.api.recipes.machines.RecipeMapLiquidFuel;
import stanhebben.zenscript.annotations.ZenProperty;

public class GARecipeMaps {
    @ZenProperty
    public static final RecipeMap<IntCircuitRecipeBuilder> CIRCUIT_ASSEMBLER_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> CLUSTER_MILL_RECIPES;
    public static final RecipeMapAssemblyLine<SimpleRecipeBuilder> ASSEMBLY_LINE_RECIPES;
    public static final RecipeMapLiquidFuel NAQUADAH_REACTOR_FUELS;
    public static final RecipeMap<SimpleRecipeBuilder> MASS_FAB_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> REPLICATOR_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> CRACKER_UNIT_RECIPES;
    public static final RecipeMap<NoEURecipeBuilder> COKE_OVEN_RECIPES;
    public static final RecipeMapDistillTower<UniversalDistillationRecipeBuilder> DISTILLATION_RECIPES;

    static {
        CIRCUIT_ASSEMBLER_RECIPES = (new RecipeMap("circuit_assembler", 1, 6, 1, 1, 0, 1, 0, 0, 1, new AssemblerRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL);
        CLUSTER_MILL_RECIPES = (new RecipeMap("cluster_mill", 1, 1, 1, 1, 0, 0, 0, 0, 1, new SimpleRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.BENDER_OVERLAY).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
        ASSEMBLY_LINE_RECIPES = (new RecipeMapAssemblyLine("assembly_line", 4, 16, 1, 1, 0, 4, 0, 0, 1, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
        ASSEMBLY_LINE_RECIPES.setSlotOverlay(false, false, GuiTextures.MOLD_OVERLAY);
        NAQUADAH_REACTOR_FUELS = new RecipeMapLiquidFuel("naquadah_reactor", 1, 1, 1, new SimpleRecipeBuilder());
        MASS_FAB_RECIPES = (new RecipeMap("mass_fab", 0, 1, 0, 0, 0, 1, 1, 2, 1, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
        REPLICATOR_RECIPES = (new RecipeMap("replicator", 0, 1, 0, 1, 1, 2, 0, 1, 1, new SimpleRecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);
        COKE_OVEN_RECIPES = new RecipeMap("coke_oven", 1, 1, 0, 1, 0, 0, 0, 1, 0, (new NoEURecipeBuilder())).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
        CRACKER_UNIT_RECIPES = new RecipeMap("cracker_unit", 0, 0, 0, 0, 2, 2, 1, 1, 1, (new SimpleRecipeBuilder()).notOptimized());
        DISTILLATION_RECIPES = new RecipeMapDistillTower("distill_tower", 0, 0, 0, 1, 1, 1, 1, 11, 1, (new UniversalDistillationRecipeBuilder()).notOptimized());
    }
}
