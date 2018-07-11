package gregicadditions;

import gregtech.api.GTValues;
import gregtech.api.unification.material.MaterialIconType;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.Condition;
import net.minecraftforge.common.util.EnumHelper;

public class GAEnums {
    public static void preInit() {
        EnumHelper.addEnum(MaterialIconType.class, "plateCurved", new Class[0]);
        EnumHelper.addEnum(MaterialIconType.class, "ingotDouble", new Class[0]);

        EnumHelper.addEnum(OrePrefix.class, "plateCurved",
                new Class[]{String.class, long.class, Material.class, MaterialIconType.class, long.class, Condition.class},
                "Curved Plates", GTValues.M, null, MaterialIconType.valueOf("plateCurved"), OrePrefix.Flags.ENABLE_UNIFICATION,
                OrePrefix.and(instanceOfIngotMat(), OrePrefix.hasFlag(IngotMaterial.MatFlags.GENERATE_FOIL)));
        EnumHelper.addEnum(OrePrefix.class, "ingotDouble",
                new Class[]{String.class, long.class, Material.class, MaterialIconType.class, long.class, Condition.class},
                "Double Ingot", GTValues.M, null, MaterialIconType.valueOf("ingotDouble"), OrePrefix.Flags.ENABLE_UNIFICATION,
                OrePrefix.and(instanceOfIngotMat(), OrePrefix.hasFlag(DustMaterial.MatFlags.GENERATE_PLATE)));
    }

    public static Condition<Material> instanceOfDustMat() {
        return (mat) -> {
            return mat instanceof DustMaterial;
        };
    }

    public static Condition<Material> instanceOfIngotMat() {
        return (mat) -> {
            return mat instanceof IngotMaterial;
        };
    }
}
