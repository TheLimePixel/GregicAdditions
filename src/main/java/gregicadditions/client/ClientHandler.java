package gregicadditions.client;

import gregicadditions.GregicAdditions;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.machines.CrateRenderer;
import gregicadditions.machines.DrumRenderer;
import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.OrientedOverlayRenderer.OverlayFace;
import gregtech.api.render.SimpleCubeRenderer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = GregicAdditions.MODID, value = Side.CLIENT)
public class ClientHandler {

	public static SimpleCubeRenderer FUSION_TEXTURE = new SimpleCubeRenderer("casings/fusion/machine_casing_fusion_glass");
	//Commented out until it is decided if we want to implement this
	//public static SimpleCubeRenderer ACTIVE_FUSION_TEXTURE = new SimpleCubeRenderer("gregtech:casings/fusion/machine_casing_fusion_glass_yellow");
	public static OrientedOverlayRenderer NAQUADAH_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor", OverlayFace.FRONT, OverlayFace.BACK, OverlayFace.TOP);
	public static OrientedOverlayRenderer REPLICATOR_OVERLAY = new OrientedOverlayRenderer("machines/replicator", OverlayFace.FRONT);
	public static OrientedOverlayRenderer MASS_FAB_OVERLAY = new OrientedOverlayRenderer("machines/mass_fab", OverlayFace.FRONT);
	public static OrientedOverlayRenderer FUSION_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/fusion_reactor", OverlayFace.FRONT);
	public static DrumRenderer BARREL = new DrumRenderer("storage/drums/barrel");
	public static DrumRenderer DRUM = new DrumRenderer("storage/drums/drum");
	public static CrateRenderer WOODEN_CRATE = new CrateRenderer("storage/crates/wooden_crate");
	public static CrateRenderer METAL_CRATE = new CrateRenderer("storage/crates/metal_crate");

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		GAMetaBlocks.registerItemModels();
	}
}
