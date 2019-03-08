package gregicadditions;

import com.google.common.collect.ImmutableList;
import gregicadditions.item.BasicMaterial;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.IMaterialHandler;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;

@IMaterialHandler.RegisterMaterialHandler
public class GAMaterials {
    public static FluidMaterial FishOil;
    public static FluidMaterial RawGrowthMedium;
    public static FluidMaterial SterilizedGrowthMedium;
    public static DustMaterial Meat;
    public static DustMaterial GASodiumSulfide;
    public static FluidMaterial NeutralMatter;
    public static FluidMaterial PositiveMatter;
    public static IngotMaterial Neutronium;
    public static BasicMaterial Ultimate;
    public static BasicMaterial Plasma;
    public static GemMaterial LigniteCoke;

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

        FishOil = new FluidMaterial(999, "fish_oil", 14467421, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        Neutronium = new IngotMaterial(998, "neutronium", 12829635, MaterialIconSet.METALLIC, 6, ImmutableList.of(), EXT2_METAL | gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_RING | gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_ROTOR | gregtech.api.unification.material.type.IngotMaterial.MatFlags.GENERATE_SMALL_GEAR | gregtech.api.unification.material.type.SolidMaterial.MatFlags.GENERATE_LONG_ROD | SolidMaterial.MatFlags.GENERATE_FRAME, Element.valueOf("Nt"), 24.0F, 12, 655360);
        RawGrowthMedium = new FluidMaterial(997, "raw_growth_medium", 10777425, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        SterilizedGrowthMedium = new FluidMaterial(996, "sterilized_growth_medium", 11306862, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        Meat = new DustMaterial(995, "meat", 12667980, MaterialIconSet.SAND, 1, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        GASodiumSulfide = new DustMaterial(994, "ga_sodium_sulfide", 8944452, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Materials.Sodium, 2), new MaterialStack(Materials.Sulfur, 1)), Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        NeutralMatter = new FluidMaterial(993, "neutral_matter", 3956968, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        PositiveMatter = new FluidMaterial(992, "positive_matter", 11279131, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        Ultimate = new BasicMaterial(991, "ultimate", 13434880, MaterialIconSet.SHINY);
        Plasma = new BasicMaterial(990, "plasma", 15389725, MaterialIconSet.SHINY);
        LigniteCoke = new GemMaterial(989, "lignite_coke", 0x8b6464, MaterialIconSet.LIGNITE, 1, ImmutableList.of(new MaterialStack(Materials.Carbon, 1)), Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING | SolidMaterial.MatFlags.MORTAR_GRINDABLE | Material.MatFlags.FLAMMABLE | DustMaterial.MatFlags.NO_SMELTING | DustMaterial.MatFlags.NO_SMASHING);
        LigniteCoke.setBurnTime(2400);

        Materials.Naquadah.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
        Materials.NaquadahEnriched.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
        Materials.Duranium.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
        Materials.Graphene.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);

        Materials.GreenSapphire.addFlag(DustMaterial.MatFlags.GENERATE_PLATE);

        Materials.Apatite.addFlag(SolidMaterial.MatFlags.GENERATE_ROD);

        Materials.Rubber.addFlag(IngotMaterial.MatFlags.GENERATE_BOLT_SCREW);
        Materials.Apatite.addFlag(IngotMaterial.MatFlags.GENERATE_BOLT_SCREW);

        Materials.Tritanium.addFlag(SolidMaterial.MatFlags.GENERATE_FRAME);

        Materials.NitroFuel.addFlag(Material.MatFlags.DISABLE_DECOMPOSITION);

        OrePrefix.gemChipped.setIgnored(LigniteCoke);
        OrePrefix.gemFlawed.setIgnored(LigniteCoke);
        OrePrefix.gemFlawless.setIgnored(LigniteCoke);
        OrePrefix.gemExquisite.setIgnored(LigniteCoke);
    }
}