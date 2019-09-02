package gregicadditions.bees;

import forestry.api.core.IModelManager;
import forestry.api.core.Tabs;
import forestry.core.items.IColoredItem;
import forestry.core.items.ItemForestry;
import gregicadditions.GregicAdditions;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTCombItem extends ItemForestry implements IColoredItem {
    public GTCombItem() {
        setMaxDamage(0);
        setHasSubtypes(true);
        setCreativeTab(Tabs.tabApiculture);
        setRegistryName(GregicAdditions.MODID, "comb");
        setTranslationKey(GregicAdditions.MODID + ":comb");
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel(Item item, IModelManager manager) {
        for (int i = 0; i < GTCombs.VALUES.length; i++) {
            manager.registerItemModel(item, i, GregicAdditions.MODID, "comb");
        }
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        GTCombs honeyComb = GTCombs.get(stack.getItemDamage());
        return super.getTranslationKey(stack) + "." + honeyComb.name;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (tab == Tabs.tabApiculture)
            for (int i = 0; i < GTCombs.VALUES.length; i++) {
                subItems.add(new ItemStack(this, 1, i));
            }
    }


    public static ItemStack getComb(GTCombs honeyComb, int amount) {
        return new ItemStack(GTCombs.combItem, amount, honeyComb.ordinal());
    }

    @Override
    public int getColorFromItemstack(ItemStack itemstack, int tintIndex) {
        GTCombs honeyComb = GTCombs.get(itemstack.getItemDamage());
        if (tintIndex == 1) {
            return honeyComb.primaryColor;
        } else {
            return honeyComb.secondaryColor;
        }
    }
}