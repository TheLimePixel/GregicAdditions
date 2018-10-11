package gregicadditions;

import net.minecraftforge.common.config.Config;

@Config(modid = GregicAdditions.MODID)
public class GAConfig {

    @Config.Comment("Config options for GT6 features")
    public static GT6 GT6 = new GT6();

    public static class GT6 {
        @Config.Comment("Bending Recipes (disabling Bending Cylinders' recipes disables all of them)")
        @Config.Name("Bending - Bending Cylinders' recipes")
        public boolean BendingCylinders = true;
        @Config.Name("Bending - Curved Plates' recipes")
        public boolean BendingCurvedPlates = true;
        @Config.Name("Bending - Rotors require Curved Plates")
        public boolean BendingRotors = true;
        @Config.Name("Bending - Rings are crafted with Bending Cyliders")
        public boolean BendingRings = true;
        @Config.Name("Bending - Foils are made with Bending Cylinders")
        public boolean BendingFoils = true;
        @Config.Name("Bending - Foils are automated in the Cluster Mill instead of the Bending Machine")
        public boolean BendingFoilsAutomatic = true;
        @Config.Name("Bending - Pipes are crafted with Curved Plates")
        public boolean BendingPipes = true;

        @Config.Comment("Set this to false to disable Plates being crafted from Double Ingots")
        @Config.Name("Plates are crafted from Double Ingots")
        public boolean PlateDoubleIngot = true;

        @Config.Comment("Set this to false to enable the GT5 Wrench recipes")
        @Config.Name("Wrenches are crafted with Plates instead of Ingots")
        public boolean ExpensiveWrenches = true;

        @Config.Comment("Set this to false to disable Drums")
        @Config.Name("Should Drums be registered?")
        public boolean registerDums = true;
    }

    @Config.Comment("Config options for GT5U features")
    public static GT5U GT5U = new GT5U();

    public static class GT5U {
        @Config.Comment("Set to false to disable GT5U Cable isolation recipes")
        @Config.Name("Cables can be isolated with different combinations of Rubbers and Dusts with varying efficiencies")
        public boolean CablesGT5U = true;

        @Config.Comment("Set these to false to disable the generated Compressor recipes for blocks")
        @Config.Name("Compression - Generate Compressor recipes for blocks")
        public boolean GenerateCompressorRecipes = true;
        @Config.Name("Compression - Remove 3x3 crafting recipes for blocks")
        public boolean Remove3x3BlockRecipes = true;

        @Config.Comment("Set to false to enable Log>Charcoal smelting recipes")
        @Config.Name("All Log to Charcoal smelting recipes will be removed")
        public boolean DisableLogToCharcoalSmeltg = true;

        @Config.Comment("Set to false to disable generated wood sawing recipes")
        @Config.Name("A saw is required to get 4 Planks per Log")
        public boolean GeneratedSawingRecipes = true;

        @Config.Comment("Set to false to enable GTCE's Fine Wire recipes")
        @Config.Name("Fine Wires are made from Foils")
        public boolean OldFineWireRecipes = true;
    }

    @Config.Comment("Config options of miscellaneous features")
    public static Misc Misc = new Misc();

    public static class Misc {
        @Config.Comment("Set these to flase to disable the generated Packager and Unpackaker recipes")
        @Config.Name("Packaging - 1x1 recipes with 9 outputs can be automated with the Unpackaker")
        public boolean Unpackager3x3Recipes = true;
        @Config.Name("Packaging - 3x3 recipes can automated with the Packagers")
        public boolean Packager3x3Recipes = true;
        @Config.Name("Packaging - 2x2 recipes can automated with the Packagers")
        public boolean Packager2x2Recipes = true;
        @Config.Name("Packaging - Dust compressing can automated with the Packagers")
        public boolean PackagerDustRecipes = true;

        @Config.Comment("Set this to false to disable the Forestry Integration")
        @Config.Name("Forestry's Ethanol and Seed Oil are used in recipes instead of GTCE's")
        public boolean ForestryIntegration = true;

        @Config.Comment("Set this to false to disable Crates")
        @Config.Name("Should Crates be registered?")
        public boolean registerCrates = true;

        @Config.Comment("Set this to false to disable the high tier Air Collectors")
        @Config.Name("Air Collector have IV and LuV version")
        public boolean highTierCollector = true;
    }
}
