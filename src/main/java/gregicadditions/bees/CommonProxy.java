package gregicadditions.bees;

import gregicadditions.GregicAdditions;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GregicAdditions.MODID)
public class CommonProxy {

	public void postInit() {
		ForestryMachineRecipes.init();
	}
}