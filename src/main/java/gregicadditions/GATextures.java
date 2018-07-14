package gregicadditions;

import gregtech.api.gui.resources.TextureArea;
import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.SimpleCubeRenderer;

public class GATextures {
    public static SimpleCubeRenderer COKE_OVEN_BRICKS;


    public static OrientedOverlayRenderer COKE_OVEN_OVERLAY;

    //Gui Textures
    public static final TextureArea BRONZE_FLUID_SLOT = TextureArea.fullImage("textures/gui/steam/fluid_slot.png");
    public static final TextureArea COAL_OVERLAY = TextureArea.fullImage("textures/gui/steam/bronze/overlay_bronze_coal.png");


    static {
        COKE_OVEN_BRICKS = new SimpleCubeRenderer("casings/solid/machine_coke_oven_bricks");

        COKE_OVEN_OVERLAY = new OrientedOverlayRenderer("machines/coke_oven", new OrientedOverlayRenderer.OverlayFace[]{OrientedOverlayRenderer.OverlayFace.FRONT});
    }
}
