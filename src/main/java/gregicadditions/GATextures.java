package gregicadditions;

import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.SimpleCubeRenderer;

public class GATextures {
    public static SimpleCubeRenderer COKE_OVEN_BRICKS;


    public static OrientedOverlayRenderer COKE_OVEN_OVERLAY;

    static {
        COKE_OVEN_BRICKS = new SimpleCubeRenderer("casings/solid/machine_coke_oven_bricks");

        COKE_OVEN_OVERLAY = new OrientedOverlayRenderer("machines/coke_oven", new OrientedOverlayRenderer.OverlayFace[]{OrientedOverlayRenderer.OverlayFace.FRONT});
    }
}
