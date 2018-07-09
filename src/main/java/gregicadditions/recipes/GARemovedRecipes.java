package gregicadditions.recipes;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GARemovedRecipes {

    public static void postInit() {
        for (Material m : IngotMaterial.MATERIAL_REGISTRY) {

            removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                    OreDictUnifier.get(OrePrefix.plate, m),
                    IntCircuitIngredient.getIntegratedCircuit(0));
        }
    }

    private static void removeRecipesByInputs(RecipeMap map, ItemStack... itemInputs) {
        List<ItemStack> inputs = new ArrayList();
        for (ItemStack s : itemInputs)
            inputs.add(s);
        map.removeRecipe(map.findRecipe(Integer.MAX_VALUE, inputs, Collections.EMPTY_LIST));
    }
}
