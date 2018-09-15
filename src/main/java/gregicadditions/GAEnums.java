package gregicadditions;

import gregtech.api.GTValues;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.MaterialIconType;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.Condition;
import gregtech.loaders.load.MetaTileEntityLoader;
import net.minecraftforge.common.util.EnumHelper;

public class GAEnums {
    public static void preInit() {
        EnumHelper.addEnum(MaterialIconType.class, "plateCurved", new Class[0]);
        EnumHelper.addEnum(MaterialIconType.class, "ingotDouble", new Class[0]);
        EnumHelper.addEnum(MaterialIconType.class, "round", new Class[0]);

        EnumHelper.addEnum(Element.class, "Nt", new Class[]{long.class, long.class, long.class, String.class,String.class, boolean.class}, 0L, 5000L, -1L, null, "NEUTRONIUM", false);

        EnumHelper.addEnum(MaterialIconSet.class, "COKE", new Class[0]);

        EnumHelper.addEnum(OrePrefix.class, "plateCurved",
                new Class[]{String.class, long.class, Material.class, MaterialIconType.class, long.class, Condition.class},
                "Curved Plate", GTValues.M, null, MaterialIconType.valueOf("plateCurved"), OrePrefix.Flags.ENABLE_UNIFICATION,
                OrePrefix.and(instanceOfIngotMat(), OrePrefix.hasFlag(DustMaterial.MatFlags.GENERATE_PLATE)));
        EnumHelper.addEnum(OrePrefix.class, "ingotDouble",
                new Class[]{String.class, long.class, Material.class, MaterialIconType.class, long.class, Condition.class},
                "Double Ingot", GTValues.M, null, MaterialIconType.valueOf("ingotDouble"), OrePrefix.Flags.ENABLE_UNIFICATION,
                OrePrefix.and(instanceOfIngotMat(), OrePrefix.hasFlag(DustMaterial.MatFlags.GENERATE_PLATE)));
        EnumHelper.addEnum(OrePrefix.class, "round",
                new Class[]{String.class, long.class, Material.class, MaterialIconType.class, long.class, Condition.class},
                "Round", GTValues.M, null, MaterialIconType.valueOf("round"), OrePrefix.Flags.ENABLE_UNIFICATION,
                OrePrefix.and(instanceOfIngotMat(), OrePrefix.hasFlag(IngotMaterial.MatFlags.GENERATE_SMALL_GEAR)));

        EnumHelper.addEnum(OrePrefix.class, "circuitGA",
                new Class[]{String.class, long.class, Material.class, MaterialIconType.class, long.class, Condition.class},
                "GA Circuits", -1L, null, null, OrePrefix.Flags.ENABLE_UNIFICATION | OrePrefix.Flags.DISALLOW_RECYCLING,
                null);
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
