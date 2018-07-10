package gregicadditions;

import gregicadditions.item.GAMetaItems;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = GregicAdditions.MODID)
public class CommonProxy {

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        GAMetaItems.registerOreDict();
    }


}
