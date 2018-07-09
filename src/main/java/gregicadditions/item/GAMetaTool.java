package gregicadditions.item;

import gregicadditions.tools.ToolTest;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.material.type.SolidMaterial;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GAMetaTool extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem> {

    public void registerSubItems() {
        GAMetaItems.TOOL_TEST = addItem(0, "tool.test").setToolStats(new ToolTest()).addOreDict("craftingToolTest");
    }

    public void registerRecipes() {
        for (Material material : IngotMaterial.MATERIAL_REGISTRY) {
            if (material instanceof IngotMaterial) {
                IngotMaterial toolMaterial = (IngotMaterial) material;
                SolidMaterial handleMaterial = toolMaterial.handleMaterial == null ? Materials.Wood : toolMaterial.handleMaterial;
                ModHandler.addShapedRecipe(String.format("hammer_%s", material.toString()),
                        ((ToolMetaItem<?>.MetaToolValueItem) GAMetaItems.TOOL_TEST).getStackForm(toolMaterial, handleMaterial),
                        "XX ", "XS ", "  S",
                        'X', new UnificationEntry(OrePrefix.ingot, toolMaterial),
                        'S', new UnificationEntry(OrePrefix.stick, handleMaterial));
            }
        }

        ModHandler.addShapedRecipe("dirtDiamondTest", new ItemStack(Items.DIAMOND), "D", "T", 'D', "dirt", 'T', "craftingToolTest");
    }
}
