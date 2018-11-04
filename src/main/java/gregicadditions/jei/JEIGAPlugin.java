package gregicadditions.jei;

import gregicadditions.machines.GATileEntities;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@JEIPlugin
public class JEIGAPlugin implements IModPlugin {

    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new GAMultiblockInfoCategory(registry.getJeiHelpers()));
    }

    @Override
    public void register(IModRegistry registry) {
        GAMultiblockInfoCategory.registerRecipes(registry);

        registry.addRecipeCatalyst(GATileEntities.COKE_OVEN.getStackForm(), "gregtech:coke_oven");
    }
}
