package gregicadditions.item;

import gregicadditions.tools.BendingCylinder;
import gregicadditions.tools.SmallBendingCylinder;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;

public class GAMetaTool extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem> {

    public void registerSubItems() {
        GAMetaItems.BENDING_CYLINDER = addItem(0, "tool.bending_cylinder").setToolStats(new BendingCylinder()).addOreDict("craftingToolBendingCylinder");
        GAMetaItems.SMALL_BENDING_CYLINDER = addItem(1, "tool.bending_cylinder_small").setToolStats(new SmallBendingCylinder()).addOreDict("craftingToolBendingCylinderSmall");
    }

    public void registerRecipes() {
        for (Material material : IngotMaterial.MATERIAL_REGISTRY) {
            if (material instanceof IngotMaterial && !material.hasFlag(DustMaterial.MatFlags.NO_SMASHING)) {

                IngotMaterial toolMaterial = (IngotMaterial) material;

                ModHandler.addShapedRecipe(String.format("cylinder_%s", material.toString()),
                        ((ToolMetaItem<?>.MetaToolValueItem) GAMetaItems.BENDING_CYLINDER).getStackForm(toolMaterial, null),
                        "sfh", "XXX", "XXX",
                        'X', new UnificationEntry(OrePrefix.ingot, toolMaterial));

                ModHandler.addShapedRecipe(String.format("small_cylinder_%s", material.toString()),
                        ((ToolMetaItem<?>.MetaToolValueItem) GAMetaItems.SMALL_BENDING_CYLINDER).getStackForm(toolMaterial, null),
                        "sfh", "XXX",
                        'X', new UnificationEntry(OrePrefix.ingot, toolMaterial));

                //GT6 Wrench Recipe
                if (!OreDictUnifier.get(OrePrefix.plate, material).isEmpty() && ((IngotMaterial) material).toolDurability != 0)
                    ModHandler.addShapedRecipe(String.format("wrench_%s", material.toString()),
                            MetaItems.WRENCH.getStackForm(toolMaterial, null),
                            "XhX", "XXX", " X ",
                            'X', new UnificationEntry(OrePrefix.plate, toolMaterial));
            }
        }
    }
}
