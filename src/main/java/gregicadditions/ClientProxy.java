package gregicadditions;

import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.LocalizationChanges;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public void preInit() {
        super.preInit();
        new GATextures();
    }

    public void postInit() {
        LocalizationChanges.postInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GAMetaBlocks.registerItemModels();
    }
}
