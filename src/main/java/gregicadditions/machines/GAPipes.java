package gregicadditions.machines;

import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.pipelike.fluidpipe.FluidPipeProperties;

public class GAPipes {
    public static void preInit() {
        MetaBlocks.createFluidPipeBlock(MarkerMaterials.Tier.Ultimate, new FluidPipeProperties(1500, 48000, true));
        MetaBlocks.createFluidPipeBlock(MarkerMaterials.Tier.Superconductor, new FluidPipeProperties(1000000, 30, true));
    }
}
