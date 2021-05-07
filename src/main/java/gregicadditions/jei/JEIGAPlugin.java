package gregicadditions.jei;

import gregicadditions.item.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.block.*;

@JEIPlugin
public class JEIGAPlugin implements IModPlugin {

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new GAMultiblockInfoCategory(registry.getJeiHelpers()));
	}

	@Override
	public void register(IModRegistry registry) {
		GAMultiblockInfoCategory.registerRecipes(registry);
		// Workaround - hide the Coke Oven blocks until we can remove them without ID shift
		registry.getJeiHelpers()
		        .getIngredientBlacklist()
		        .addIngredientToBlacklist(GAMetaBlocks.MUTLIBLOCK_CASING
			                                  .getItemVariant(GAMultiblockCasing.CasingType.COKE_OVEN_BRICKS));
	}
}
