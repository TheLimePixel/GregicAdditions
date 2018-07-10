package gregicadditions;

import com.google.common.collect.ImmutableList;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.IngotMaterial;

public class GAMaterials {
    public static IngotMaterial Test;

    static {
        long STD_SOLID = DustMaterial.MatFlags.GENERATE_PLATE |
                gregtech.api.unification.material.type.SolidMaterial.MatFlags.GENERATE_ROD |
                gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_BOLT_SCREW;
        long STD_GEM = DustMaterial.MatFlags.GENERATE_ORE | STD_SOLID |
                gregtech.api.unification.material.type.GemMaterial.MatFlags.GENERATE_LENSE;
        long STD_METAL = DustMaterial.MatFlags.GENERATE_PLATE;
        long EXT_METAL = STD_METAL | gregtech.api.unification.material.type.SolidMaterial.MatFlags.GENERATE_ROD |
                gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_BOLT_SCREW;
        long EXT2_METAL = EXT_METAL | gregtech.api.unification.material.type.SolidMaterial.MatFlags.GENERATE_GEAR |
                gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_FOIL |
                gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_FINE_WIRE;
        Test = new IngotMaterial(400, "test", 12198312, MaterialIconSet.SHINY,
                4, ImmutableList.of(),
                EXT2_METAL | gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_SMALL_GEAR |
                        DustMaterial.MatFlags.GENERATE_ORE | gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_RING,
                Element.Yb, 10.0F, 400, 1700);
    }
}
