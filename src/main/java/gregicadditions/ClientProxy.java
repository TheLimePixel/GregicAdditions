package gregicadditions;

import gregicadditions.item.GAMetaBlocks;

public class ClientProxy extends CommonProxy {
    public void preInit()
    {
        super.preInit();
        new GATextures();
        GAMetaBlocks.registerItemModels();
    }
}
