package gregicadditions;

import java.util.function.Predicate;

import gregtech.api.GTValues;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.MaterialIconType;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraftforge.common.util.EnumHelper;

public class GAEnums {

	public static void preInit() {
		EnumHelper.addEnum(Element.class, "Nt", new Class[] { long.class, long.class, long.class, String.class, String.class, boolean.class }, 0L, 5000L, -1L, null, "NEUTRONIUM", false);

		EnumHelper.addEnum(MaterialIconSet.class, "COKE", new Class[0]);

		if (GAConfig.GT6.addCurvedPlates) {
			EnumHelper.addEnum(MaterialIconType.class, "plateCurved", new Class[0]);
			EnumHelper.addEnum(OrePrefix.class, "plateCurved", new Class[] { String.class, long.class, Material.class, MaterialIconType.class, long.class, Predicate.class }, "Curved Plate", GTValues.M, null, MaterialIconType.valueOf("plateCurved"), OrePrefix.Flags.ENABLE_UNIFICATION, pred(mat -> ingot.test(mat) && mat.hasFlag(DustMaterial.MatFlags.GENERATE_PLATE)));
		}

		if (GAConfig.GT6.addDoubleIngots) {
			EnumHelper.addEnum(MaterialIconType.class, "ingotDouble", new Class[0]);
			EnumHelper.addEnum(OrePrefix.class, "ingotDouble", new Class[] { String.class, long.class, Material.class, MaterialIconType.class, long.class, Predicate.class }, "Double Ingot", GTValues.M, null, MaterialIconType.valueOf("ingotDouble"), OrePrefix.Flags.ENABLE_UNIFICATION, pred(mat -> ingot.test(mat) && mat.hasFlag(DustMaterial.MatFlags.GENERATE_PLATE)));
		}

		if (GAConfig.GT6.addRounds) {
			EnumHelper.addEnum(MaterialIconType.class, "round", new Class[0]);
			EnumHelper.addEnum(OrePrefix.class, "round", new Class[] { String.class, long.class, Material.class, MaterialIconType.class, long.class, Predicate.class }, "Round", GTValues.M, null, MaterialIconType.valueOf("round"), OrePrefix.Flags.ENABLE_UNIFICATION, pred(mat -> ingot.test(mat) && mat.hasFlag(IngotMaterial.MatFlags.GENERATE_SMALL_GEAR)));
		}
	}

	public static final Predicate<Material> dust = mat -> mat instanceof DustMaterial;
	public static final Predicate<Material> ingot = mat -> mat instanceof IngotMaterial;

	private static Predicate<Material> pred(Predicate<Material> in) {
		return mat -> in.test(mat);
	}
}
