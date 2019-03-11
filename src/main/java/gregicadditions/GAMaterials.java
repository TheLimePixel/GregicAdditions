package gregicadditions;

import com.google.common.collect.ImmutableList;

import gregtech.api.unification.Element;
import gregtech.api.unification.material.IMaterialHandler;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.FluidMaterial;
import gregtech.api.unification.material.type.GemMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.material.type.SolidMaterial;
import gregtech.api.unification.material.type.SolidMaterial.MatFlags;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;

@IMaterialHandler.RegisterMaterialHandler
public class GAMaterials implements IMaterialHandler {

	static long EXT2_METAL = DustMaterial.MatFlags.GENERATE_PLATE | SolidMaterial.MatFlags.GENERATE_ROD | IngotMaterial.MatFlags.GENERATE_BOLT_SCREW | SolidMaterial.MatFlags.GENERATE_GEAR | IngotMaterial.MatFlags.GENERATE_FOIL | IngotMaterial.MatFlags.GENERATE_FINE_WIRE;
	public static final FluidMaterial FISH_OIL = new FluidMaterial(975, "fish_oil", 14467421, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial RAW_GROWTH_MEDIUM = new FluidMaterial(940, "raw_growth_medium", 10777425, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial STERILE_GROWTH_MEDIUM = new FluidMaterial(939, "sterilized_growth_medium", 11306862, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final DustMaterial MEAT = new DustMaterial(938, "meat", 12667980, MaterialIconSet.SAND, 1, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial NEUTRAL_MATTER = new FluidMaterial(883, "neutral_matter", 3956968, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial POSITIVE_MATTER = new FluidMaterial(882, "positive_matter", 11279131, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final IngotMaterial NEUTRONIUM = new IngotMaterial(972, "neutronium", 12829635, MaterialIconSet.METALLIC, 6, ImmutableList.of(), EXT2_METAL | IngotMaterial.MatFlags.GENERATE_RING | IngotMaterial.MatFlags.GENERATE_ROTOR | IngotMaterial.MatFlags.GENERATE_SMALL_GEAR | SolidMaterial.MatFlags.GENERATE_LONG_ROD | MatFlags.GENERATE_FRAME, Element.valueOf("Nt"), 24.0F, 12F, 655360);
	public static final GemMaterial LIGNITE_COKE = new GemMaterial(879, "lignite_coke", 0x8b6464, MaterialIconSet.LIGNITE, 1, ImmutableList.of(new MaterialStack(Materials.Carbon, 1)), Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING | SolidMaterial.MatFlags.MORTAR_GRINDABLE | Material.MatFlags.FLAMMABLE | DustMaterial.MatFlags.NO_SMELTING | DustMaterial.MatFlags.NO_SMASHING);

	@Override
	public void onMaterialsInit() {
		LIGNITE_COKE.setBurnTime(2400);

		Materials.YttriumBariumCuprate.addFlag(IngotMaterial.MatFlags.GENERATE_FINE_WIRE);
		Materials.Manganese.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Naquadah.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.NaquadahEnriched.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Duranium.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Graphene.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Helium.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.Oxygen.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.Iron.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.Nickel.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.GreenSapphire.addFlag(DustMaterial.MatFlags.GENERATE_PLATE);
		Materials.GreenSapphire.addFlag(GemMaterial.MatFlags.GENERATE_LENSE);
		Materials.Tritanium.addFlag(MatFlags.GENERATE_FRAME);

		Materials.Apatite.addFlag(SolidMaterial.MatFlags.GENERATE_ROD);

		Materials.Iron.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);
		Materials.Bronze.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);
		Materials.Steel.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);
		Materials.StainlessSteel.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);

		Materials.Steel.addFlag(Material.MatFlags.DISABLE_DECOMPOSITION);

		Materials.Rubber.addFlag(IngotMaterial.MatFlags.GENERATE_BOLT_SCREW);
		Materials.Apatite.addFlag(IngotMaterial.MatFlags.GENERATE_BOLT_SCREW);

		Materials.Salt.addOreByProducts(Materials.Borax);
		Materials.RockSalt.addOreByProducts(Materials.Borax);
		Materials.Lepidolite.addOreByProducts(Materials.Boron);

		OrePrefix.gemChipped.setIgnored(LIGNITE_COKE);
		OrePrefix.gemFlawed.setIgnored(LIGNITE_COKE);
		OrePrefix.gemFlawless.setIgnored(LIGNITE_COKE);
		OrePrefix.gemExquisite.setIgnored(LIGNITE_COKE);

		Materials.Magnetite.setDirectSmelting(Materials.Iron);
	}
}