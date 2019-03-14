package gregicadditions.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@JEIPlugin
public class JEIGAPlugin implements IModPlugin {

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new GAMultiblockInfoCategory(registry.getJeiHelpers()));
	}

	@Override
	public void register(IModRegistry registry) {
		GAMultiblockInfoCategory.registerRecipes(registry);

	}
}
