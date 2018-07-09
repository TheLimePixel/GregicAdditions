package gregicadditions.item;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;

public class GAMetaItem extends MaterialMetaItem {

    public void registerSubItems() {
        GAMetaItems.ITEM_TEST = addItem(0, "item.test");
    }

    public void registerRecipes() {
        System.out.println("Adding GA Recipes");
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.dustTiny, Materials.Apatite).input(OrePrefix.wireGtSingle, Materials.RedAlloy, 4)
                .outputs(GAMetaItems.ITEM_TEST.getStackForm(2))
                .duration(800)
                .EUt(2)
                .buildAndRegister();
    }
}
