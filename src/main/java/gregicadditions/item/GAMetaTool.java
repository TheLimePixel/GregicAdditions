package gregicadditions.item;

import gregicadditions.tools.BendingCylinder;
import gregicadditions.tools.SmallBendingCylinder;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.material.type.SolidMaterial;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

public class GAMetaTool extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem> {

    public void registerSubItems() {
        GAMetaItems.BENDING_CYLINDER = addItem(0, "tool.bending_cylinder").setToolStats(new BendingCylinder()).addOreDict("craftingToolBendingCylinder");
        GAMetaItems.SMALL_BENDING_CYLINDER = addItem(1, "tool.bending_cylinder_small").setToolStats(new SmallBendingCylinder()).addOreDict("craftingToolBendingCylinderSmall");
    }

    public void registerRecipes() {
        for (Material material : IngotMaterial.MATERIAL_REGISTRY) {
            if (material instanceof IngotMaterial) {
                IngotMaterial toolMaterial = (IngotMaterial) material;
                SolidMaterial handleMaterial = toolMaterial.handleMaterial == null ? Materials.Wood : toolMaterial.handleMaterial;
                ModHandler.addShapedRecipe(String.format("hammer_%s", material.toString()),
                        ((ToolMetaItem<?>.MetaToolValueItem) GAMetaItems.BENDING_CYLINDER).getStackForm(toolMaterial,handleMaterial),
                        "sfh", "XXX", "XXX",
                        'X', new UnificationEntry(OrePrefix.ingot, toolMaterial));
                ModHandler.addShapedRecipe(String.format("hammer_%s", material.toString()),
                        ((ToolMetaItem<?>.MetaToolValueItem) GAMetaItems.SMALL_BENDING_CYLINDER).getStackForm(toolMaterial,handleMaterial),
                        "sfh", "XXX",
                        'X', new UnificationEntry(OrePrefix.ingot, toolMaterial));
            }
        }
    }
}
