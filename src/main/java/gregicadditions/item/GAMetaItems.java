package gregicadditions.item;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.toolitem.ToolMetaItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class GAMetaItems {


    public static List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();

    public static MetaItem<?>.MetaValueItem ITEM_TEST;

    public static MetaItem<?>.MetaValueItem TOOL_TEST;

    public static void init() {
        GAMetaItem item = new GAMetaItem();
        item.setRegistryName("ga_meta_item");
        GAMetaTool tool = new GAMetaTool();
        tool.setRegistryName("ga_meta_tool");
    }

    public static void registerOreDict() {
        for (MetaItem<?> item : ITEMS) {
            if (item instanceof GAMetaItem) {
                ((GAMetaItem) item).registerOreDict();
            }
        }
    }

    public static void registerRecipes() {
        for (MetaItem<?> item : ITEMS) {
            if (item instanceof GAMetaItem)
                ((GAMetaItem) item).registerRecipes();
            if (item instanceof GAMetaTool)
                ((GAMetaTool) item).registerRecipes();
        }
    }
}
