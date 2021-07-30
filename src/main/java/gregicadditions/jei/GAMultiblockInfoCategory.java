package gregicadditions.jei;

import com.google.common.collect.ImmutableMap;
import gregtech.api.gui.GuiTextures;
import gregtech.integration.jei.multiblock.MultiblockInfoRecipeWrapper;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.gui.recipes.RecipeLayout;
import net.minecraft.client.resources.I18n;

import javax.annotation.Nullable;

public class GAMultiblockInfoCategory implements IRecipeCategory<MultiblockInfoRecipeWrapper> {
	private final IDrawable background;
	private final IGuiHelper guiHelper;

	public GAMultiblockInfoCategory(IJeiHelpers helpers) {
		this.guiHelper = helpers.getGuiHelper();
		this.background = guiHelper.createBlankDrawable(176, 166);
	}

	public static final ImmutableMap<String, MultiblockInfoRecipeWrapper> multiblockRecipes = ImmutableMap.of(
		"assembly_line", new MultiblockInfoRecipeWrapper(new AssemblyLineInfo()),
		"fusion_reactor_1", new MultiblockInfoRecipeWrapper(new FusionReactor1Info()),
		"fusion_reactor_2", new MultiblockInfoRecipeWrapper(new FusionReactor2Info()),
		"fusion_reactor_3", new MultiblockInfoRecipeWrapper(new FusionReactor3Info()),
		"processing_array", new MultiblockInfoRecipeWrapper(new ProcessingArrayInfo()));


	public static void registerRecipes(IModRegistry registry) {
		registry.addRecipes(multiblockRecipes.values(), "gtadditions:multiblock_info");
	}

	@Override
	public String getUid() {
		return "gtadditions:multiblock_info";
	}

	@Override
	public String getTitle() {
		return I18n.format("gregtech.multiblock.title");
	}

	@Override
	public String getModName() {
		return "gtadditions";
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, MultiblockInfoRecipeWrapper recipeWrapper, IIngredients ingredients) {
		recipeWrapper.setRecipeLayout((RecipeLayout) recipeLayout, guiHelper);

		IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
		itemStackGroup.addTooltipCallback(recipeWrapper::addBlockTooltips);
	}

	@Nullable
	@Override
	public IDrawable getIcon() {
		return guiHelper.drawableBuilder(GuiTextures.MULTIBLOCK_CATEGORY.imageLocation, 0, 0, 18, 18).setTextureSize(18, 18).build();
	}
}
