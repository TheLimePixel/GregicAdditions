package gregicadditions;

import com.google.common.collect.ImmutableList;
import com.sun.jna.platform.mac.Carbon;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.stack.MaterialStack;
import net.minecraft.enchantment.EnchantmentWaterWalker;

public class GAMaterials {
    public static DustMaterial Brick;
    public static DustMaterial Fireclay;
    public static DustMaterial PhosphorousPentoxide;
    public static FluidMaterial PhosphoricAcid;
    public static FluidMaterial PolyvinylAcetate;
    public static FluidMaterial Phenol;
    public static FluidMaterial BisphenolA;
    public static IngotMaterial EpoxyResin;
    public static IngotMaterial ReinforcedEpoxyResin;
    public static IngotMaterial BorosilicateGlass;
    public static IngotMaterial PolyvinylChloride;
    public static FluidMaterial VinylChloride;
    public static FluidMaterial Ethylene;
    public static FluidMaterial CharcoalByproducts;
    public static FluidMaterial Benzene;
    public static FluidMaterial WoodGas;
    public static FluidMaterial WoodVinegar;
    public static FluidMaterial WoodTar;
    public static DustMaterial SodiumHydroxide;
    public static DustMaterial Quicklime;
    public static FluidMaterial Acetone;
    public static FluidMaterial SulfurTrioxide;
    public static FluidMaterial SulfurDioxide;
    public static FluidMaterial Glycerol;
    public static FluidMaterial FishOil;
    public static FluidMaterial Methanol;
    public static FluidMaterial CarbonMonoxde;
    public static FluidMaterial CetaneBoostedDiesel;
    public static FluidMaterial DilutedSulfuricAcid;
    public static FluidMaterial LiquidAir;
    public static FluidMaterial NobleGases;
    public static DustMaterial SodiumBisulfate;
    public static FluidMaterial Chloroform;
    public static FluidMaterial DilutedHydrochloricAcid;
    public static FluidMaterial HypochlorousAcid;
    public static FluidMaterial Ammonia;
    public static FluidMaterial Chloramine;
    public static FluidMaterial Dimethylamine;
    public static FluidMaterial Dimethylhydrazine;
    public static FluidMaterial RocketFuel;
    public static FluidMaterial DinitrogenTetroxide;
    public static IngotMaterial SiliconeRubber;
    public static DustMaterial Polydimethylsiloxane;
    public static FluidMaterial Dimethyldichlorosilane;
    public static FluidMaterial Styrine;
    public static IngotMaterial Polysterine;
    public static DustMaterial RawStyrineButadieneRubber;
    public static IngotMaterial StyrineButadieneRubber;
    public static FluidMaterial Dichlorobenzene;
    public static FluidMaterial HydrochloricAcid;
    public static FluidMaterial AceticAcid;
    public static FluidMaterial FermentedBiomass;
    public static DustMaterial Potash;
    public static DustMaterial SodaAsh;
    public static FluidMaterial HydroflouricAcid;
    public static FluidMaterial NitrogenDioxide;
    public static FluidMaterial NitricOxide;
    public static FluidMaterial MethylAcetate;
    public static FluidMaterial Ethenone;
    public static FluidMaterial Tetranitromethane;
    public static FluidMaterial BioDiesel;
    public static FluidMaterial RawGrowthMedium;
    public static FluidMaterial SterilizedGrowthMedium;
    public static DustMaterial Meat;
    public static DustMaterial CookedMeat;
    public static FluidMaterial VinylAcetate;
    public static IngotMaterial GalliumArsenade;
    public static DustMaterial SodumSulfide;
    public static IngotMaterial PolyphenyleneSulfide;
    public static FluidMaterial NickelSulfateSolution;
    public static FluidMaterial BlueVitriolSolution;

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

        Brick = new DustMaterial(1000,"brick",0xB75A40,MaterialIconSet.ROUGH,1,ImmutableList.of(new MaterialStack(Materials.Aluminium,4),new MaterialStack(Materials.Silicon,3),new MaterialStack(Materials.Oxygen,12)),Material.MatFlags.DISABLE_DECOMPOSITION | DustMaterial.MatFlags.EXCLUDE_BLOCK_CRAFTING_RECIPES);
        Fireclay = new DustMaterial(999,"fireclay",0x928073,MaterialIconSet.ROUGH,1,ImmutableList.of(new MaterialStack(Materials.Clay,1),new MaterialStack(Brick,1)),Material.MatFlags.DISABLE_DECOMPOSITION | DustMaterial.MatFlags.EXCLUDE_BLOCK_CRAFTING_RECIPES);
        PhosphorousPentoxide = new DustMaterial(998,"prosphorous_pentoxide",0x7c7d00,MaterialIconSet.DULL,1,ImmutableList.of(new MaterialStack(Materials.Phosphor,4),new MaterialStack(Materials.Oxygen,10)),Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        PhosphoricAcid = new FluidMaterial(997,"phosphoric_acid",0xaeae10,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Hydrogen,3),new MaterialStack(Materials.Phosphor,4)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        PolyvinylAcetate = new FluidMaterial(996,"polyvinyl_acetate",0xc87e4c,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,4),new MaterialStack(Materials.Hydrogen,6),new MaterialStack(Materials.Oxygen,2)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK);
        Phenol = new FluidMaterial(995,"phenol",0x654027,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,6),new MaterialStack(Materials.Hydrogen,6),new MaterialStack(Materials.Oxygen,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        BisphenolA = new FluidMaterial(994,"bisphenol_b",0xa5870e,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,15),new MaterialStack(Materials.Hydrogen,16),new MaterialStack(Materials.Oxygen,2)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        EpoxyResin = new IngotMaterial(993,"epoxy_resin",0x9c6d10,MaterialIconSet.ROUGH,1,ImmutableList.of(new MaterialStack(Materials.Carbon,6),new MaterialStack(Materials.Hydrogen,4),new MaterialStack(Materials.Oxygen,1)),DustMaterial.MatFlags.GENERATE_PLATE, (Element)null,6.0F, 32);
        ReinforcedEpoxyResin = new IngotMaterial(992,"reinforced_epoxy_resin",0x72500b,MaterialIconSet.ROUGH,1,ImmutableList.of(new MaterialStack(Materials.Carbon,6),new MaterialStack(Materials.Hydrogen,4),new MaterialStack(Materials.Oxygen,1)),DustMaterial.MatFlags.GENERATE_PLATE, (Element)null,6.0F, 64);
        BorosilicateGlass = new IngotMaterial(991,"borosilicate_glass",0xccd7cc,MaterialIconSet.METALLIC,1,ImmutableList.of(new MaterialStack(Materials.Boron,1),new MaterialStack(Materials.SiliconDioxide,7)),Material.MatFlags.DISABLE_DECOMPOSITION);
        PolyvinylChloride = new IngotMaterial(990,"polyvinyl_chloride",0x99a4a4,MaterialIconSet.ROUGH,1,ImmutableList.of(new MaterialStack(Materials.Carbon,2),new MaterialStack(Materials.Hydrogen,3),new MaterialStack(Materials.Chlorine,1)),EXT_METAL | IngotMaterial.MatFlags.GENERATE_FOIL);
        VinylChloride = new FluidMaterial(989,"vinyl_chloride",0xb0bbbb,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,2),new MaterialStack(Materials.Hydrogen,3),new MaterialStack(Materials.Chlorine,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        Ethylene = new FluidMaterial(988,"ethylene",0xadadad,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,2),new MaterialStack(Materials.Hydrogen,4)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        CharcoalByproducts = new FluidMaterial(987,"charcoal_byproducts",0x664027,MaterialIconSet.FLUID,ImmutableList.of(),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        Benzene = new FluidMaterial(986,"benzene",0x1f1f1f,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,6),new MaterialStack(Materials.Hydrogen,6)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        WoodGas = new FluidMaterial(985,"wood_gas",0xb1a571,MaterialIconSet.GAS,ImmutableList.of(),FluidMaterial.MatFlags.STATE_GAS | Material.MatFlags.DISABLE_DECOMPOSITION);
        WoodVinegar = new FluidMaterial(984,"wood_vinegar",0xa54b0f,MaterialIconSet.FLUID,ImmutableList.of(),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        WoodTar = new FluidMaterial(983,"wood_tar",0x2d2118,MaterialIconSet.FLUID,ImmutableList.of(),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        SodiumHydroxide = new DustMaterial(982,"sodium_hydroxide",0x001942,MaterialIconSet.DULL,1,ImmutableList.of(new MaterialStack(Materials.Sodium,1),new MaterialStack(Materials.Oxygen,1),new MaterialStack(Materials.Hydrogen,1)),Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        Quicklime = new DustMaterial(981,"quicklime",0x808080,MaterialIconSet.DULL,1,ImmutableList.of(new MaterialStack(Materials.Calcium,1),new MaterialStack(Materials.Oxygen,1)),Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        Acetone = new FluidMaterial(980,"acetone",0x8e8e8e,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,3),new MaterialStack(Materials.Hydrogen,6),new MaterialStack(Materials.Oxygen,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        SulfurTrioxide = new FluidMaterial(979,"sulfur_trioxide",0x83831d,MaterialIconSet.GAS,ImmutableList.of(new MaterialStack(Materials.Sulfur,1),new MaterialStack(Materials.Oxygen,3)),FluidMaterial.MatFlags.STATE_GAS | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        SulfurDioxide = new FluidMaterial(978,"sulfur_dioxide",0x9c9c20,MaterialIconSet.GAS,ImmutableList.of(new MaterialStack(Materials.Sulfur,1),new MaterialStack(Materials.Oxygen,2)),FluidMaterial.MatFlags.STATE_GAS | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        Glycerol = new FluidMaterial(977,"glycerol",0x70af70,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,3),new MaterialStack(Materials.Hydrogen,8),new MaterialStack(Materials.Oxygen,3)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        FishOil = new FluidMaterial(976,"fish_oil",0xdcc15d,MaterialIconSet.FLUID,ImmutableList.of(),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        Methanol = new FluidMaterial(975,"methanol",0x887010,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,1),new MaterialStack(Materials.Hydrogen,4),new MaterialStack(Materials.Oxygen,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        CarbonMonoxde = new FluidMaterial(974,"carbon_monoxide",0x19436c,MaterialIconSet.GAS,ImmutableList.of(new MaterialStack(Materials.Carbon,1),new MaterialStack(Materials.Oxygen,1)),FluidMaterial.MatFlags.STATE_GAS | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        CetaneBoostedDiesel = new FluidMaterial(973,"cetane_boosted_diesel",0xc1cf31,MaterialIconSet.FLUID,ImmutableList.of(),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        DilutedSulfuricAcid = new FluidMaterial(972,"diluted_sulfuric_acid",0x986526,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Hydrogen,2),new MaterialStack(Materials.Sulfur,1),new MaterialStack(Materials.Oxygen,4)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        LiquidAir = new FluidMaterial(971,"liquid_air",0x89a5c0,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Nitrogen,40),new MaterialStack(Materials.Oxygen,11),new MaterialStack(Materials.Argon,1),new MaterialStack(GAMaterials.NobleGases,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_CENTRIFUGING);
        NobleGases = new FluidMaterial(970,"noble_gases",0x88a4bf,MaterialIconSet.GAS,ImmutableList.of(new MaterialStack(Materials.CarbonDioxide,21),new MaterialStack(Materials.Helium,9),new MaterialStack(Materials.Methane,3),new MaterialStack(Materials.Deuterium,1)),FluidMaterial.MatFlags.STATE_GAS | Material.MatFlags.DECOMPOSITION_BY_CENTRIFUGING);
        SodiumBisulfate = new DustMaterial(969,"sodium_bisulfate",0x002833,MaterialIconSet.DULL,1,ImmutableList.of(new MaterialStack(Materials.Sodium,1),new MaterialStack(Materials.Hydrogen,1),new MaterialStack(Materials.Sulfur,1),new MaterialStack(Materials.Oxygen,4)),Material.MatFlags.DISABLE_DECOMPOSITION);
        Chloroform = new FluidMaterial(968,"chloroform",0x702e80,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,1),new MaterialStack(Materials.Hydrogen,1),new MaterialStack(Materials.Chlorine,3)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        DilutedHydrochloricAcid = new FluidMaterial(967,"diluted_hydrochloric_acid",0x7c8684,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Hydrogen,1),new MaterialStack(Materials.Chlorine,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
        HypochlorousAcid = new FluidMaterial(966,"hypochlorous_acid",0x5d7075,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Hydrogen,1),new MaterialStack(Materials.Chlorine,1),new MaterialStack(Materials.Oxygen,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        Ammonia = new FluidMaterial(965,"ammonia",0x3d356b,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Nitrogen,1),new MaterialStack(Materials.Hydrogen,3)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
        Dimethylamine = new FluidMaterial(964,"dimethylamine",0x4b3f59,MaterialIconSet.FLUID,ImmutableList.of(new MaterialStack(Materials.Carbon,2),new MaterialStack(Materials.Hydrogen,7),new MaterialStack(Materials.Nitrogen,1)),FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING);
    }
}
