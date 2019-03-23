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
    public static FluidMaterial NeutralMatter;
    public static FluidMaterial PositiveMatter;
    public static IngotMaterial Neutronium;
    public static BasicMaterial Plasma;
    public static GemMaterial LigniteCoke;
    public static IngotMaterial MVSuperconductorBase;
    public static IngotMaterial HVSuperconductorBase;
    public static IngotMaterial EVSuperconductorBase;
    public static IngotMaterial IVSuperconductorBase;
    public static IngotMaterial LuVSuperconductorBase;
    public static IngotMaterial ZPMSuperconductorBase;
    public static BasicMaterial MVSuperconductor;
    public static BasicMaterial HVSuperconductor;
    public static BasicMaterial EVSuperconductor;
    public static BasicMaterial IVSuperconductor;
    public static BasicMaterial LuVSuperconductor;
    public static BasicMaterial ZPMSuperconductor;
    public static IngotMaterial Enderium;
    public static DustMaterial AluminoSilicateWool;
    public static DustMaterial MicaPulp;
    public static IngotMaterial Ultima;
    public static FluidMaterial IronChloride;
    public static DustMaterial QuartzSand;
    public static DustMaterial Massicot;
    public static DustMaterial AntimonyTrioxide;
    public static DustMaterial Zincite;
    public static DustMaterial CobaltOxide;
    public static DustMaterial ArsenicTrioxide;
    public static DustMaterial CupricOxide;
    public static DustMaterial Ferrosilite;

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
        NeutralMatter = new FluidMaterial(993, "neutral_matter", 3956968, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        PositiveMatter = new FluidMaterial(992, "positive_matter", 11279131, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        Plasma = new BasicMaterial(990, "plasma", 15389725, MaterialIconSet.SHINY);
        LigniteCoke = new GemMaterial(989, "lignite_coke", 0x8b6464, MaterialIconSet.LIGNITE, 1, ImmutableList.of(new MaterialStack(Materials.Carbon, 1)), Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING | SolidMaterial.MatFlags.MORTAR_GRINDABLE | Material.MatFlags.FLAMMABLE | DustMaterial.MatFlags.NO_SMELTING | DustMaterial.MatFlags.NO_SMASHING);
        LigniteCoke.setBurnTime(2400);
        MVSuperconductorBase = new IngotMaterial(988, "mv_superconductor_base", 0x535353, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Materials.Cadmium, 5), new MaterialStack(Materials.Magnesium, 1), new MaterialStack(Materials.Oxygen, 6)), STD_METAL, null, 2500);
        HVSuperconductorBase = new IngotMaterial(987, "hv_superconductor_base", 0x4a2400, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Materials.Titanium, 1), new MaterialStack(Materials.Barium, 9), new MaterialStack(Materials.Copper, 10), new MaterialStack(Materials.Oxygen, 20)), STD_METAL, null, 3300);
        EVSuperconductorBase = new IngotMaterial(986, "ev_superconductor_base", 0x005800, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Materials.Uranium, 1), new MaterialStack(Materials.Platinum, 3)), STD_METAL, null, 4400);
        IVSuperconductorBase = new IngotMaterial(985, "iv_superconductor_base", 0x300030, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Materials.Vanadium, 1), new MaterialStack(Materials.Indium, 3)), STD_METAL, null, 5200);
        LuVSuperconductorBase = new IngotMaterial(984, "luv_superconductor_base", 0x7a3c00, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Materials.Indium, 4), new MaterialStack(Materials.Bronze, 8), new MaterialStack(Materials.Barium, 2), new MaterialStack(Materials.Titanium, 1), new MaterialStack(Materials.Oxygen, 14)), STD_METAL, null, 6000);
        ZPMSuperconductorBase = new IngotMaterial(983, "zpm_superconductor_base", 0x111111, MaterialIconSet.SHINY, 1, ImmutableList.of(new MaterialStack(Materials.Naquadah, 4), new MaterialStack(Materials.Indium, 2), new MaterialStack(Materials.Palladium, 6), new MaterialStack(Materials.Osmium, 1)), STD_METAL, null, 8100);
        MVSuperconductor = new BasicMaterial(982, "mv_superconductor", 0x535353, MaterialIconSet.SHINY);
        HVSuperconductor = new BasicMaterial(981, "hv_superconductor", 0x4a2400, MaterialIconSet.SHINY);
        EVSuperconductor = new BasicMaterial(980, "ev_superconductor", 0x005800, MaterialIconSet.SHINY);
        IVSuperconductor = new BasicMaterial(979, "iv_superconductor", 0x300030, MaterialIconSet.SHINY);
        LuVSuperconductor = new BasicMaterial(978, "luv_superconductor", 0x7a3c00, MaterialIconSet.SHINY);
        ZPMSuperconductor = new BasicMaterial(977, "zpm_superconductor", 0x111111, MaterialIconSet.SHINY);
        Enderium = new IngotMaterial(976, "enderium", 0x23524a, MaterialIconSet.METALLIC, 3, ImmutableList.of(new MaterialStack(Materials.Lead, 3), new MaterialStack(Materials.Platinum, 1), new MaterialStack(Materials.EnderPearl, 1)), EXT_METAL | Material.MatFlags.DISABLE_DECOMPOSITION, null, 8.0F, 3.0F, 1280, 4500);
        AluminoSilicateWool = new DustMaterial(975, "alumino_silicate_wool", 0xbbbbbb, MaterialIconSet.SAND, 1, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        MicaPulp = new DustMaterial(974, "mica_based", 0x917445, MaterialIconSet.SAND, 1, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        Ultima = new IngotMaterial(973, "ultima", 0x443d4f, MaterialIconSet.SHINY, 3, ImmutableList.of(new MaterialStack(Materials.TinAlloy,1), new MaterialStack(Materials.Ultimet,1), new MaterialStack(Materials.Magnalium,1), new MaterialStack(Materials.BlueSteel, 1), new MaterialStack(Materials.VanadiumSteel, 1), new MaterialStack(Materials.NiobiumNitride, 1), new MaterialStack(Materials.NaquadahAlloy, 1)), EXT2_METAL | Material.MatFlags.DISABLE_DECOMPOSITION, null, 9000);
        IronChloride = new FluidMaterial(972, "iron_chloride", 0x060b0b, MaterialIconSet.FLUID, ImmutableList.of(new MaterialStack(Materials.Iron, 1), new MaterialStack(Materials.Chlorine, 3)), Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        QuartzSand = new DustMaterial(971, "sand", 0xd2cfbc, MaterialIconSet.SAND, 1, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
        Massicot = new DustMaterial(970, "massicot", 8943149, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Materials.Lead, 1), new MaterialStack(Materials.Oxygen, 1)), 0);
        AntimonyTrioxide = new DustMaterial(969, "antimony_trioxide", 8092544, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Materials.Antimony, 2), new MaterialStack(Materials.Oxygen, 3)), 0);
        Zincite = new DustMaterial(968, "zincite", 8947843, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Materials.Zinc, 1), new MaterialStack(Materials.Oxygen, 1)), 0);
        CobaltOxide = new DustMaterial(967, "cobalt_oxide", 3556352, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Materials.Cobalt, 1), new MaterialStack(Materials.Oxygen, 1)), 0);
        ArsenicTrioxide = new DustMaterial(966, "arsenic_trioxide", 15856113, MaterialIconSet.ROUGH, 1, ImmutableList.of(new MaterialStack(Materials.Arsenic, 2), new MaterialStack(Materials.Oxygen, 3)), 0);
        CupricOxide = new DustMaterial(964, "cupric_oxide", 526344, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Materials.Copper, 1), new MaterialStack(Materials.Oxygen, 1)), 0);
        Ferrosilite = new DustMaterial(963, "ferrosilite", 5256470, MaterialIconSet.SAND, 1, ImmutableList.of(new MaterialStack(Materials.Iron, 1), new MaterialStack(Materials.Silicon, 1), new MaterialStack(Materials.Oxygen, 3)), 0);

        MVSuperconductorBase.setCableProperties(128, 1, 2);
        HVSuperconductorBase.setCableProperties(512, 1, 2);
        EVSuperconductorBase.setCableProperties(2048, 2, 2);
        IVSuperconductorBase.setCableProperties(8192, 2, 2);
        LuVSuperconductorBase.setCableProperties(32768, 4, 2);
        ZPMSuperconductorBase.setCableProperties(131072, 4, 2);
        Ultima.setCableProperties(524288, 3, 2);

        Materials.NiobiumTitanium.setFluidPipeProperties(450, 2900, true);
        Enderium.setFluidPipeProperties(650, 1500, true);
        Materials.Naquadah.setFluidPipeProperties(1000, 19000, true);
        Neutronium.setFluidPipeProperties(2800, 1000000, true);

        Materials.Diatomite.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.GarnetSand.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.Mica.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.Asbestos.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.Kyanite.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.Pollucite.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.BasalticMineralSand.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.GraniticMineralSand.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.FullersEarth.addFlag(DustMaterial.MatFlags.GENERATE_ORE);
        Materials.Gypsum.addFlag(DustMaterial.MatFlags.GENERATE_ORE);

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
        Materials.Ash.addFlag(Material.MatFlags.DISABLE_DECOMPOSITION);

        OrePrefix.gemChipped.setIgnored(LigniteCoke);
        OrePrefix.gemFlawed.setIgnored(LigniteCoke);
        OrePrefix.gemFlawless.setIgnored(LigniteCoke);
        OrePrefix.gemExquisite.setIgnored(LigniteCoke);
    }
}