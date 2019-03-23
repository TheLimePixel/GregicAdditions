package gregicadditions.recipes;

import forestry.core.ModuleCore;
import forestry.core.items.EnumElectronTube;
import gregicadditions.GAConfig;
import gregicadditions.GAMaterials;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMetaItems;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.item.GATransparentCasing;
import gregicadditions.machines.GATileEntities;
import gregtech.api.GTValues;
import gregtech.api.items.ToolDictNames;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GARecipeAddition {

    private static final MaterialStack[] solderingList = {
            new MaterialStack(Materials.Tin, 2L),
            new MaterialStack(Materials.SolderingAlloy, 1L),
            new MaterialStack(Materials.Lead, 4L)
    };

    private static final MaterialStack[] sawLubricants = {
            new MaterialStack(Materials.Lubricant, 1L),
            new MaterialStack(Materials.DistilledWater, 3L),
            new MaterialStack(Materials.Water, 4L)
    };

    private static final MaterialStack[] cableFluids = {
            new MaterialStack(Materials.Rubber, 144),
            new MaterialStack(Materials.StyreneButadieneRubber, 108),
            new MaterialStack(Materials.SiliconeRubber, 72)
    };

    private static final MaterialStack[] cableDusts = {
            new MaterialStack(Materials.Polydimethylsiloxane, 1),
            new MaterialStack(Materials.PolyvinylChloride, 1)
    };

    private static final MaterialStack[] firstMetal = {
            new MaterialStack(Materials.Iron, 1),
            new MaterialStack(Materials.Nickel, 1),
            new MaterialStack(Materials.Invar, 2),
            new MaterialStack(Materials.Steel, 2),
            new MaterialStack(Materials.StainlessSteel, 3),
            new MaterialStack(Materials.Titanium, 3),
            new MaterialStack(Materials.Tungsten, 4),
            new MaterialStack(Materials.TungstenSteel, 5)
    };

    private static final MaterialStack[] lastMetal = {
            new MaterialStack(Materials.Tin, 0),
            new MaterialStack(Materials.Zinc, 0),
            new MaterialStack(Materials.Aluminium, 1)
    };

    private static final MaterialStack[] ironOres = {
            new MaterialStack(Materials.Pyrite, 1),
            new MaterialStack(Materials.BrownLimonite, 1),
            new MaterialStack(Materials.YellowLimonite, 1),
            new MaterialStack(Materials.Magnetite, 1),
            new MaterialStack(Materials.Iron, 1)
    };

    private static final MaterialStack[] lubeDusts = {
            new MaterialStack(Materials.Talc, 1),
            new MaterialStack(Materials.Soapstone, 1),
            new MaterialStack(Materials.Redstone, 1)
    };

    private static final MaterialStack[] lapisLike = {
            new MaterialStack(Materials.Lapis, 1),
            new MaterialStack(Materials.Lazurite, 1),
            new MaterialStack(Materials.Sodalite, 1)
    };

    private static final ItemStack[] molds = {
            MetaItems.SHAPE_MOLD_ANVIL.getStackForm(),
            MetaItems.SHAPE_MOLD_BALL.getStackForm(),
            MetaItems.SHAPE_MOLD_BLOCK.getStackForm(),
            MetaItems.SHAPE_MOLD_BOTTLE.getStackForm(),
            MetaItems.SHAPE_MOLD_CREDIT.getStackForm(),
            MetaItems.SHAPE_MOLD_CYLINDER.getStackForm(),
            MetaItems.SHAPE_MOLD_GEAR.getStackForm(),
            MetaItems.SHAPE_MOLD_INGOT.getStackForm(),
            MetaItems.SHAPE_MOLD_NAME.getStackForm(),
            MetaItems.SHAPE_MOLD_NUGGET.getStackForm(),
            MetaItems.SHAPE_MOLD_PLATE.getStackForm(),
            MetaItems.SHAPE_MOLD_GEAR_SMALL.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_AXE.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_BLOCK.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_BOLT.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_BOTTLE.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_CELL.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_FILE.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_GEAR.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_HAMMER.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_HOE.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_INGOT.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_PIPE_LARGE.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_PIPE_MEDIUM.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_PICKAXE.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_PLATE.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_RING.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_ROD.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_SAW.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_SHOVEL.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_PIPE_SMALL.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_SWORD.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_PIPE_TINY.getStackForm(),
            MetaItems.SHAPE_EXTRUDER_WIRE.getStackForm()
    };

    public static void init() {
        //GTNH Bricks
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_coke_bricks"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:compressed_clay"));
        ModHandler.removeFurnaceSmelting(MetaItems.COKE_OVEN_BRICK.getStackForm());
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_COKE_CLAY.getStackForm(), GAMetaItems.COKE_BRICK.getStackForm());
        ModHandler.removeFurnaceSmelting(new ItemStack(Items.CLAY_BALL, 1, OreDictionary.WILDCARD_VALUE));
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_CLAY.getStackForm(), new ItemStack(Items.BRICK));
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(8).inputs(GAMetaItems.COMPRESSED_CLAY.getStackForm(2), new ItemStack(Blocks.SAND)).outputs(GAMetaItems.COKE_BRICK.getStackForm(2)).buildAndRegister();
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(200).EUt(2).inputs(new ItemStack(Items.CLAY_BALL)).notConsumable(MetaItems.SHAPE_MOLD_INGOT).outputs(new ItemStack(Items.BRICK)).buildAndRegister();
        ModHandler.addShapelessRecipe("clay_brick", GAMetaItems.COMPRESSED_CLAY.getStackForm(), new ItemStack(Items.CLAY_BALL), MetaItems.WOODEN_FORM_BRICK);
        ModHandler.addShapedRecipe("eight_clay_brick", GAMetaItems.COMPRESSED_CLAY.getStackForm(8), "BBB", "BFB", "BBB", 'B', new ItemStack(Items.CLAY_BALL), 'F', MetaItems.WOODEN_FORM_BRICK);
        ModHandler.addShapedRecipe("coke_brick", GAMetaItems.COMPRESSED_COKE_CLAY.getStackForm(5), "SSS", "BFB", "BBB", 'B', new ItemStack(Items.CLAY_BALL), 'S', new ItemStack(Blocks.SAND), 'F', MetaItems.WOODEN_FORM_BRICK);
        ModHandler.addShapedRecipe("coke_bricks", GAMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GAMultiblockCasing.CasingType.COKE_OVEN_BRICKS), "BB", "BB", 'B', GAMetaItems.COKE_BRICK.getStackForm());

        //GT5U Old Primitive Brick Processing
        ModHandler.removeFurnaceSmelting(MetaItems.FIRECLAY_BRICK.getStackForm());
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_primitive_bricks"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:brick_to_dust"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:brick_block_to_dust"));
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_FIRECLAY.getStackForm(), GAMetaItems.FIRECLAY_BRICK.getStackForm());
        RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().input(OrePrefix.dust, Materials.Fireclay).outputs(GAMetaItems.COMPRESSED_FIRECLAY.getStackForm()).duration(100).EUt(2).buildAndRegister();
        ModHandler.addShapedRecipe("quartz_sand", OreDictUnifier.get(OrePrefix.dust, GAMaterials.QuartzSand), "S", "m", 'S', "sand");
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(200).EUt(8).input("sand", 1).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.QuartzSand)).chancedOutput(OreDictUnifier.get(OrePrefix.dust, GAMaterials.QuartzSand), 2500).chancedOutput(OreDictUnifier.get(OrePrefix.dust, GAMaterials.QuartzSand), 2000).buildAndRegister();
        ModHandler.addShapelessRecipe("glass_dust_ga", OreDictUnifier.get(OrePrefix.dust, Materials.Glass), "dustSand", "dustFlint");
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(200).EUt(8).input(OrePrefix.dust, Materials.Flint).input(OrePrefix.dust, GAMaterials.QuartzSand, 4).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Glass, 4)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(160).EUt(8).input(OrePrefix.dust, Materials.Flint).input(OrePrefix.dust, Materials.Quartzite, 4).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Glass, 4)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(100).EUt(16).input(OrePrefix.dust, Materials.Calcite, 2).input(OrePrefix.dust, Materials.Stone).input(OrePrefix.dust, Materials.Clay).input(OrePrefix.dust, GAMaterials.QuartzSand).fluidInputs(Materials.Water.getFluid(2000)).fluidOutputs(Materials.Concrete.getFluid(2304)).buildAndRegister();

        //GT5U Misc Recipes
        ModHandler.addSmeltingRecipe(new ItemStack(Items.SLIME_BALL), MetaItems.RUBBER_DROP.getStackForm());
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:bone_meal_from_bone"));
        ModHandler.addShapelessRecipe("harder_bone_meal", new ItemStack(Items.DYE, 3, 15), new ItemStack(Items.BONE), ToolDictNames.craftingToolMortar);
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().inputs(new ItemStack(Items.BONE)).outputs(new ItemStack(Items.DYE, 3, 15)).duration(16).EUt(10).buildAndRegister();
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().inputs(new ItemStack(Items.BONE)).outputs(new ItemStack(Items.DYE, 3, 15)).duration(300).EUt(2).buildAndRegister();
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_FIRECLAY.getStackForm(), GAMetaItems.FIRECLAY_BRICK.getStackForm());

        //GT6 Bending
        if (GAConfig.GT6.BendingCurvedPlates && GAConfig.GT6.BendingCylinders) {
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:iron_bucket"));
            ModHandler.addShapedRecipe("bucket", new ItemStack(Items.BUCKET), "ChC", " P ", 'C', "plateCurvedIron", 'P', "plateIron");
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(4).input(OrePrefix.valueOf("plateCurved"), Materials.Iron, 2).input(OrePrefix.plate, Materials.Iron).outputs(new ItemStack(Items.BUCKET)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(4).input(OrePrefix.valueOf("plateCurved"), Materials.WroughtIron, 2).input(OrePrefix.plate, Materials.WroughtIron).outputs(new ItemStack(Items.BUCKET)).buildAndRegister();
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_helmet"));
            ModHandler.addShapedRecipe("iron_helmet", new ItemStack(Items.IRON_HELMET), "PPP", "ChC", 'P', "plateIron", 'C', "plateCurvedIron");
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_chestplate"));
            ModHandler.addShapedRecipe("iron_chestplate", new ItemStack(Items.IRON_CHESTPLATE), "PhP", "CPC", "CPC", 'P', "plateIron", 'C', "plateCurvedIron");
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_leggings"));
            ModHandler.addShapedRecipe("iron_leggings", new ItemStack(Items.IRON_LEGGINGS), "PCP", "ChC", "C C", 'P', "plateIron", 'C', "plateCurvedIron");
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_boots"));
            ModHandler.addShapedRecipe("iron_boots", new ItemStack(Items.IRON_BOOTS), "P P", "ChC", 'P', "plateIron", 'C', "plateCurvedIron");
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_helmet"));
            ModHandler.addShapedRecipe("golden_helmet", new ItemStack(Items.GOLDEN_HELMET), "PPP", "ChC", 'P', "plateGold", 'C', "plateCurvedGold");
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_chestplate"));
            ModHandler.addShapedRecipe("golden_chestplate", new ItemStack(Items.GOLDEN_CHESTPLATE), "PhP", "CPC", "CPC", 'P', "plateGold", 'C', "plateCurvedGold");
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_leggings"));
            ModHandler.addShapedRecipe("golden_leggings", new ItemStack(Items.GOLDEN_LEGGINGS), "PCP", "ChC", "C C", 'P', "plateGold", 'C', "plateCurvedGold");
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_boots"));
            ModHandler.addShapedRecipe("golden_boots", new ItemStack(Items.GOLDEN_BOOTS), "P P", "ChC", 'P', "plateGold", 'C', "plateCurvedGold");
            ModHandler.addShapedRecipe("chain_helmet", new ItemStack(Items.CHAINMAIL_HELMET), "RRR", "RhR", 'R', "ringIron");
            ModHandler.addShapedRecipe("chain_chestplate", new ItemStack(Items.CHAINMAIL_CHESTPLATE), "RhR", "RRR", "RRR", 'R', "ringIron");
            ModHandler.addShapedRecipe("chain_leggings", new ItemStack(Items.CHAINMAIL_LEGGINGS), "RRR", "RhR", "R R", 'R', "ringIron");
            ModHandler.addShapedRecipe("chain_boots", new ItemStack(Items.CHAINMAIL_BOOTS), "R R", "RhR", 'R', "ringIron");
        }
        for (Material m : IngotMaterial.MATERIAL_REGISTRY) {
            if (!OreDictUnifier.get(OrePrefix.ring, m).isEmpty() && !OreDictUnifier.get(OrePrefix.stick, m).isEmpty() && m != Materials.Rubber && m != Materials.StyreneButadieneRubber && m != Materials.SiliconeRubber && GAConfig.GT6.BendingRings && GAConfig.GT6.BendingCylinders) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.ring, m));
                ModHandler.addShapedRecipe("tod_to_ring_" + m.toString(), OreDictUnifier.get(OrePrefix.ring, m), "hS", " C", 'S', OreDictUnifier.get(OrePrefix.stick, m), 'C', "craftingToolBendingCylinderSmall");
            }
            if (!OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m).isEmpty() && GAConfig.GT6.BendingCurvedPlates && GAConfig.GT6.BendingCylinders) {
                ModHandler.addShapedRecipe("curved_plate_" + m.toString(), OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m), "h", "P", "C", 'P', new UnificationEntry(OrePrefix.plate, m), 'C', "craftingToolBendingCylinder");
                ModHandler.addShapedRecipe("flatten_plate_" + m.toString(), OreDictUnifier.get(OrePrefix.plate, m), "h", "C", 'C', new UnificationEntry(OrePrefix.valueOf("plateCurved"), m));
                RecipeMaps.BENDER_RECIPES.recipeBuilder().EUt(24).duration((int) m.getMass()).input(OrePrefix.plate, m).circuitMeta(0).outputs(OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m)).buildAndRegister();
            }
            if (!OreDictUnifier.get(OrePrefix.rotor, m).isEmpty() && GAConfig.GT6.BendingRotors && GAConfig.GT6.BendingCylinders) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.rotor, m));
                ModHandler.addShapedRecipe("ga_rotor_" + m.toString(), OreDictUnifier.get(OrePrefix.rotor, m), "ChC", "SRf", "CdC", 'C', OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m), 'S', OreDictUnifier.get(OrePrefix.screw, m), 'R', OreDictUnifier.get(OrePrefix.ring, m));
                RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(240).EUt(24).inputs(OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m, 4), OreDictUnifier.get(OrePrefix.ring, m)).fluidInputs(Materials.SolderingAlloy.getFluid(32)).outputs(OreDictUnifier.get(OrePrefix.rotor, m)).buildAndRegister();
            }
            if (!OreDictUnifier.get(OrePrefix.foil, m).isEmpty()) {
                if (GAConfig.GT6.BendingFoils && GAConfig.GT6.BendingCylinders) {
                    ModHandler.addShapedRecipe("foil_" + m.toString(), OreDictUnifier.get(OrePrefix.foil, m, 2), "hPC", 'P', new UnificationEntry(OrePrefix.plate, m), 'C', "craftingToolBendingCylinder");
                }
                if (GAConfig.GT6.BendingFoilsAutomatic && GAConfig.GT6.BendingCylinders) {
                    GARecipeMaps.CLUSTER_MILL_RECIPES.recipeBuilder().EUt(24).duration((int) m.getMass()).input(OrePrefix.plate, m).outputs(OreDictUnifier.get(OrePrefix.foil, m, 4)).buildAndRegister();
                } else if (GAConfig.GT6.BendingFoilsAutomatic == false || GAConfig.GT6.BendingCylinders == false) {
                    RecipeMaps.BENDER_RECIPES.recipeBuilder().EUt(24).duration((int) m.getMass()).circuitMeta(4).input(OrePrefix.plate, m).outputs(OreDictUnifier.get(OrePrefix.foil, m, 4)).buildAndRegister();
                }
            }

            if (!OreDictUnifier.get(OrePrefix.valueOf("round"), m).isEmpty()) {
                ModHandler.addShapedRecipe("round" + m.toString(), OreDictUnifier.get(OrePrefix.valueOf("round"), m), "fN", "N ", 'N', OreDictUnifier.get(OrePrefix.nugget, m));
                RecipeMaps.LATHE_RECIPES.recipeBuilder().EUt(8).duration((int) m.getMass()).inputs(OreDictUnifier.get(OrePrefix.nugget, m)).outputs(OreDictUnifier.get(OrePrefix.valueOf("round"), m)).buildAndRegister();
            }

            ModHandler.addShapedRecipe("plasma_pipe", OreDictUnifier.get(OrePrefix.pipeMedium, GAMaterials.Plasma), "ESE", "NTN", "ESE", 'E', "platePlastic", 'S', OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor), 'N', "plateNeodymiumMagnetic", 'T', OreDictUnifier.get(OrePrefix.pipeSmall, Materials.Titanium));

            if (GAConfig.GT6.BendingPipes && GAConfig.GT6.BendingCylinders) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.pipeSmall, Materials.Wood));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Wood));
                ModHandler.addShapedRecipe("pipe_ga_wood", OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Wood, 2), "PPP", "sCh", "PPP", 'P', "plankWood", 'C', "craftingToolBendingCylinder");
                ModHandler.addShapedRecipe("pipe_ga_large_wood", OreDictUnifier.get(OrePrefix.pipeLarge, Materials.Wood), "PhP", "PCP", "PsP", 'P', "plankWood", 'C', "craftingToolBendingCylinder");
                ModHandler.addShapedRecipe("pipe_ga_small_wood", OreDictUnifier.get(OrePrefix.pipeSmall, Materials.Wood, 6), "PsP", "PCP", "PhP", 'P', "plankWood", 'C', "craftingToolBendingCylinder");
            }

            //Cables
            if (m instanceof IngotMaterial && !OreDictUnifier.get(OrePrefix.cableGtSingle, m).isEmpty() && m != Materials.RedAlloy && m != Materials.Cobalt && m != Materials.Zinc && m != Materials.SolderingAlloy && m != Materials.Tin && m != Materials.Lead && GAConfig.GT5U.CablesGT5U) {
                for (MaterialStack stackFluid : cableFluids) {
                    IngotMaterial fluid = (IngotMaterial) stackFluid.material;
                    int multiplier = (int) stackFluid.amount;
                    if (m == Materials.Tungsten || m == Materials.Osmium || m == Materials.Platinum || m == Materials.TungstenSteel || m == Materials.Graphene || m == Materials.VanadiumGallium || m == Materials.HSSG || m == Materials.YttriumBariumCuprate || m == Materials.NiobiumTitanium || m == Materials.Naquadah || m == Materials.NiobiumTitanium || m == Materials.NaquadahEnriched || m == Materials.Duranium || m == Materials.NaquadahAlloy) {
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m), OreDictUnifier.get(OrePrefix.foil, m)).fluidInputs(fluid.getFluid(multiplier)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtSingle, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, m), OreDictUnifier.get(OrePrefix.foil, m, 2)).fluidInputs(fluid.getFluid(multiplier * 2)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtDouble, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), OreDictUnifier.get(OrePrefix.foil, m, 4)).fluidInputs(fluid.getFluid(multiplier * 4)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtQuadruple, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtOctal, m), OreDictUnifier.get(OrePrefix.foil, m, 8)).fluidInputs(fluid.getFluid(multiplier * 8)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtOctal, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtHex, m), OreDictUnifier.get(OrePrefix.foil, m, 16)).fluidInputs(fluid.getFluid(multiplier * 16)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtHex, m)).buildAndRegister();

                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide)).fluidInputs(fluid.getFluid(multiplier)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtSingle, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 2)).fluidInputs(fluid.getFluid(multiplier * 2)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtDouble, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 4)).fluidInputs(fluid.getFluid(multiplier * 4)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtQuadruple, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtOctal, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 8)).fluidInputs(fluid.getFluid(multiplier * 8)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtOctal, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtHex, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 16)).fluidInputs(fluid.getFluid(multiplier * 16)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtHex, m)).buildAndRegister();
                        for (MaterialStack stackDust : cableDusts) {
                            Material dust = stackDust.material;
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m), OreDictUnifier.get(OrePrefix.foil, m), OreDictUnifier.get(OrePrefix.dustSmall, dust)).fluidInputs(fluid.getFluid(multiplier / 2)).outputs(OreDictUnifier.get(OrePrefix.cableGtSingle, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, m), OreDictUnifier.get(OrePrefix.foil, m, 2), OreDictUnifier.get(OrePrefix.dustSmall, dust, 2)).fluidInputs(fluid.getFluid(multiplier)).outputs(OreDictUnifier.get(OrePrefix.cableGtDouble, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), OreDictUnifier.get(OrePrefix.foil, m, 4), OreDictUnifier.get(OrePrefix.dustSmall, dust, 4)).fluidInputs(fluid.getFluid(multiplier * 2)).outputs(OreDictUnifier.get(OrePrefix.cableGtQuadruple, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtOctal, m), OreDictUnifier.get(OrePrefix.foil, m, 8), OreDictUnifier.get(OrePrefix.dustSmall, dust, 8)).fluidInputs(fluid.getFluid(multiplier * 4)).outputs(OreDictUnifier.get(OrePrefix.cableGtOctal, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtHex, m), OreDictUnifier.get(OrePrefix.foil, m, 16), OreDictUnifier.get(OrePrefix.dustSmall, dust, 16)).fluidInputs(fluid.getFluid(multiplier * 8)).outputs(OreDictUnifier.get(OrePrefix.cableGtHex, m)).buildAndRegister();

                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide), OreDictUnifier.get(OrePrefix.dustSmall, dust)).fluidInputs(fluid.getFluid(multiplier / 2)).outputs(OreDictUnifier.get(OrePrefix.cableGtSingle, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 2), OreDictUnifier.get(OrePrefix.dustSmall, dust, 2)).fluidInputs(fluid.getFluid(multiplier)).outputs(OreDictUnifier.get(OrePrefix.cableGtDouble, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 4), OreDictUnifier.get(OrePrefix.dustSmall, dust, 4)).fluidInputs(fluid.getFluid(multiplier * 2)).outputs(OreDictUnifier.get(OrePrefix.cableGtQuadruple, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtOctal, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 8), OreDictUnifier.get(OrePrefix.dustSmall, dust, 8)).fluidInputs(fluid.getFluid(multiplier * 4)).outputs(OreDictUnifier.get(OrePrefix.cableGtOctal, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtHex, m), OreDictUnifier.get(OrePrefix.foil, Materials.PolyphenyleneSulfide, 16), OreDictUnifier.get(OrePrefix.dustSmall, dust, 16)).fluidInputs(fluid.getFluid(multiplier * 8)).outputs(OreDictUnifier.get(OrePrefix.cableGtHex, m)).buildAndRegister();
                        }
                    } else {
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m)).fluidInputs(fluid.getFluid(multiplier)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtSingle, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, m)).fluidInputs(fluid.getFluid(multiplier * 2)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtDouble, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtQuadruple, m)).fluidInputs(fluid.getFluid(multiplier * 4)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtQuadruple, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtOctal, m)).fluidInputs(fluid.getFluid(multiplier * 8)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtOctal, m)).buildAndRegister();
                        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtHex, m)).fluidInputs(fluid.getFluid(multiplier * 16)).circuitMeta(24).outputs(OreDictUnifier.get(OrePrefix.cableGtHex, m)).buildAndRegister();
                        for (MaterialStack stackDust : cableDusts) {
                            Material dust = stackDust.material;
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m), OreDictUnifier.get(OrePrefix.dustSmall, dust)).fluidInputs(fluid.getFluid(multiplier / 2)).outputs(OreDictUnifier.get(OrePrefix.cableGtSingle, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m), OreDictUnifier.get(OrePrefix.dustSmall, dust)).fluidInputs(fluid.getFluid(multiplier / 2)).outputs(OreDictUnifier.get(OrePrefix.cableGtSingle, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, m), OreDictUnifier.get(OrePrefix.dustSmall, dust, 2)).fluidInputs(fluid.getFluid(multiplier)).outputs(OreDictUnifier.get(OrePrefix.cableGtDouble, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtQuadruple, m), OreDictUnifier.get(OrePrefix.dustSmall, dust, 4)).fluidInputs(fluid.getFluid(multiplier * 2)).outputs(OreDictUnifier.get(OrePrefix.cableGtQuadruple, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtOctal, m), OreDictUnifier.get(OrePrefix.dustSmall, dust, 8)).fluidInputs(fluid.getFluid(multiplier * 4)).outputs(OreDictUnifier.get(OrePrefix.cableGtOctal, m)).buildAndRegister();
                            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtHex, m), OreDictUnifier.get(OrePrefix.dustSmall, dust, 16)).fluidInputs(fluid.getFluid(multiplier * 8)).outputs(OreDictUnifier.get(OrePrefix.cableGtHex, m)).buildAndRegister();
                        }
                    }
                }
            }

            //GT6 Plate Recipe
            if (m instanceof IngotMaterial && !OreDictUnifier.get(OrePrefix.plate, m).isEmpty() && !OreDictUnifier.get(OrePrefix.valueOf("ingotDouble"), m).isEmpty() && GAConfig.GT6.PlateDoubleIngot) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.plate, m));
                ModHandler.addShapedRecipe("ingot_double_" + m.toString(), OreDictUnifier.get(OrePrefix.valueOf("ingotDouble"), m), "h", "I", "I", 'I', new UnificationEntry(OrePrefix.ingot, m));
                ModHandler.addShapedRecipe("double_ingot_to_plate_" + m.toString(), OreDictUnifier.get(OrePrefix.plate, m), "h", "I", 'I', OreDictUnifier.get(OrePrefix.valueOf("ingotDouble"), m));
            }
        }

        //Pipes
        for (Material m : IngotMaterial.MATERIAL_REGISTRY) {
            if (!OreDictUnifier.get(OrePrefix.pipeMedium, m).isEmpty() && GAConfig.GT6.BendingPipes) {
                ModHandler.removeRecipeByName(new ResourceLocation("gregtech:small_" + m.toString() + "_pipe"));
                ModHandler.removeRecipeByName(new ResourceLocation("gregtech:medium_" + m.toString() + "_pipe"));
                ModHandler.removeRecipeByName(new ResourceLocation("gregtech:large_" + m.toString() + "_pipe"));
                if (!OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m).isEmpty()) {
                    ModHandler.addShapedRecipe("pipe_ga_" + m.toString(), OreDictUnifier.get(OrePrefix.pipeMedium, m, 2), "PPP", "wCh", "PPP", 'P', OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m), 'C', "craftingToolBendingCylinder");
                    ModHandler.addShapedRecipe("pipe_ga_large_" + m.toString(), OreDictUnifier.get(OrePrefix.pipeLarge, m), "PhP", "PCP", "PwP", 'P', OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m), 'C', "craftingToolBendingCylinder");
                    ModHandler.addShapedRecipe("pipe_ga_small_" + m.toString(), OreDictUnifier.get(OrePrefix.pipeSmall, m, 4), "PwP", "PCP", "PhP", 'P', OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m), 'C', "craftingToolBendingCylinder");
                }
            }
        }

        //Tinker support
        if (Loader.isModLoaded("tconstruct") && GAConfig.Misc.TiCIntegration) {
            ModHandler.removeRecipes(MetaItems.SHAPE_EMPTY.getStackForm());
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EMPTY.getStackForm(), Materials.Steel.getMaterialFluid(), 576, 160));
            for (ItemStack mold : molds)
                ModHandler.removeRecipes(mold);
            ModHandler.addShapedRecipe("anvil_mold_form", GAMetaItems.MOLD_FORM_ANVIL.getStackForm(), "fx ", " M ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_ANVIL.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_ANVIL.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("ball_mold_form", GAMetaItems.MOLD_FORM_BALL.getStackForm(), "f x", " M ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_BALL.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_BALL.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("block_mold_form", GAMetaItems.MOLD_FORM_BLOCK.getStackForm(), "f  ", "xM ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_BLOCK.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_BLOCK.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("bottle_mold_form", GAMetaItems.MOLD_FORM_BOTTLE.getStackForm(), "f  ", " Mx", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_BOTTLE.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_BOTTLE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("coinage_mold_form", GAMetaItems.MOLD_FORM_COINAGE.getStackForm(), "f  ", " M ", "x  ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_CREDIT.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_COINAGE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("cylinder_mold_form", GAMetaItems.MOLD_FORM_CYLINDER.getStackForm(), "f  ", " M ", " x ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_CYLINDER.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_CYLINDER.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("gear_mold_form", GAMetaItems.MOLD_FORM_GEAR.getStackForm(), "f  ", " M ", "  x", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_GEAR.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_GEAR.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("ingot_mold_form", GAMetaItems.MOLD_FORM_INGOT.getStackForm(), "xf ", " M ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_INGOT.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_INGOT.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("name_mold_form", GAMetaItems.MOLD_FORM_NAME.getStackForm(), " fx", " M ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_NAME.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_NAME.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("nugget_mold_form", GAMetaItems.MOLD_FORM_NUGGETS.getStackForm(), " f ", "xM ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_NUGGET.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_NUGGETS.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("plate_mold_form", GAMetaItems.MOLD_FORM_PLATE.getStackForm(), " f ", " Mx", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_PLATE.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_PLATE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("small_gear_mold_form", GAMetaItems.MOLD_FORM_SMALL_GEAR.getStackForm(), " f ", " M ", "x  ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_MOLD_GEAR_SMALL.getStackForm(), RecipeMatch.of(GAMetaItems.MOLD_FORM_SMALL_GEAR.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));

            ModHandler.addShapedRecipe("axe_shape", GAMetaItems.SHAPE_AXE_HEAD.getStackForm(), " f ", " M ", " x ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_AXE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_AXE_HEAD.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("block_shape", GAMetaItems.SHAPE_BLOCK.getStackForm(), " f ", " M ", "  x", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_BLOCK.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_BLOCK.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("bolt_shape", GAMetaItems.SHAPE_BOLT.getStackForm(), "x f", " M ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_BOLT.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_BOLT.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("bottle_shape", GAMetaItems.SHAPE_BOTTLE.getStackForm(), " xf", " M ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_BOTTLE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_BOTTLE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("cell_shape", GAMetaItems.SHAPE_CELL.getStackForm(), "  f", "xM ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_CELL.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_CELL.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("file_shape", GAMetaItems.SHAPE_FILE_HEAD.getStackForm(), "  f", " Mx", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_FILE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_FILE_HEAD.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("gear_shape", GAMetaItems.SHAPE_GEAR.getStackForm(), "  f", " M ", "x  ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_GEAR.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_GEAR.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("hammer_shape", GAMetaItems.SHAPE_HAMMER_HEAD.getStackForm(), "  f", " M ", " x ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_HAMMER.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_HAMMER_HEAD.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("hoe_shape", GAMetaItems.SHAPE_HOE_HEAD.getStackForm(), "  f", " M ", "  x", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_HOE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_HOE_HEAD.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("ingot_shape", GAMetaItems.SHAPE_INGOT.getStackForm(), "x  ", "fM ", "  x", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_INGOT.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_INGOT.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("large_pipe_shape", GAMetaItems.SHAPE_LARGE_PIPE.getStackForm(), " x ", "fM ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_PIPE_LARGE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_LARGE_PIPE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("medium_pipe_shape", GAMetaItems.SHAPE_NORMAL_PIPE.getStackForm(), "  x", "fM ", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_PIPE_MEDIUM.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_NORMAL_PIPE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("pickaxe_shape", GAMetaItems.SHAPE_PICKAXE_HEAD.getStackForm(), "   ", "fMx", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_PICKAXE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_PICKAXE_HEAD.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("plate_shape", GAMetaItems.SHAPE_PLATE.getStackForm(), "   ", "fM ", "x  ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_PLATE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_PLATE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("ring_shape", GAMetaItems.SHAPE_RING.getStackForm(), "   ", "fM ", " x ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_RING.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_RING.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("rod_shape", GAMetaItems.SHAPE_ROD.getStackForm(), "   ", "fM ", "  x", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_ROD.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_ROD.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("saw_shape", GAMetaItems.SHAPE_SAW_BLADE.getStackForm(), "x  ", " Mf", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_SAW.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_SAW_BLADE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("shovel_shape", GAMetaItems.SHAPE_SHOVEL_HEAD.getStackForm(), " x ", " Mf", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_SHOVEL.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_SHOVEL_HEAD.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("small_pipe_shape", GAMetaItems.SHAPE_SMALL_PIPE.getStackForm(), "  x", " Mf", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_PIPE_SMALL.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_SMALL_PIPE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("sword_shape", GAMetaItems.SHAPE_SWORD_BLADE.getStackForm(), "   ", "xMf", "   ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_SWORD.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_SWORD_BLADE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("tiny_pipe_shape", GAMetaItems.SHAPE_TINY_PIPE.getStackForm(), "   ", " Mf", "x  ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_PIPE_TINY.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_TINY_PIPE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
            ModHandler.addShapedRecipe("wire_shape", GAMetaItems.SHAPE_WIRE.getStackForm(), "   ", " Mf", " x ", 'M', new ItemStack(TinkerSmeltery.cast));
            TinkerRegistry.registerTableCasting(new CastingRecipe(MetaItems.SHAPE_EXTRUDER_WIRE.getStackForm(), RecipeMatch.of(GAMetaItems.SHAPE_WIRE.getStackForm()), Materials.Steel.getMaterialFluid(), 576, true, false));
        }

        //Copying Molds
        for (ItemStack mold : molds)
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(256).inputs(MetaItems.SHAPE_EMPTY.getStackForm()).notConsumable(mold).outputs(mold).buildAndRegister();

        //Reinforced Glass
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:ingot_mixed_metal"));
        int multiplier2;
        for (MaterialStack metal1 : firstMetal) {
            IngotMaterial material1 = (IngotMaterial) metal1.material;
            int multiplier1 = (int) metal1.amount;
            for (MaterialStack metal2 : lastMetal) {
                IngotMaterial material2 = (IngotMaterial) metal2.material;
                if ((int) metal1.amount == 1)
                    multiplier2 = 0;
                else
                    multiplier2 = (int) metal2.amount;
                ModHandler.addShapedRecipe("mixed_metal_1_" + material1.toString() + "_" + material2.toString(), MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2), "F", "M", "L", 'F', new UnificationEntry(OrePrefix.plate, material1), 'M', "plateBronze", 'L', OreDictUnifier.get(OrePrefix.plate, material2));
                ModHandler.addShapedRecipe("mixed_metal_2_" + material1.toString() + "_" + material2.toString(), MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2), "F", "M", "L", 'F', new UnificationEntry(OrePrefix.plate, material1), 'M', "plateBrass", 'L', OreDictUnifier.get(OrePrefix.plate, material2));

                RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40 * multiplier1 + multiplier2 * 40).EUt(8).input(OrePrefix.plate, material1).input(OrePrefix.plank, Materials.Bronze).input(OrePrefix.plate, material2).outputs(MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2)).buildAndRegister();
                RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40 * multiplier1 + multiplier2 * 40).EUt(8).input(OrePrefix.plate, material1).input(OrePrefix.plate, Materials.Brass).input(OrePrefix.plate, material2).outputs(MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2)).buildAndRegister();
            }
        }

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(4).inputs(MetaItems.ADVANCED_ALLOY_PLATE.getStackForm()).input(OrePrefix.dust, Materials.Glass, 3).outputs(GAMetaBlocks.TRANSPARENT_CASING.getItemVariant(GATransparentCasing.CasingType.REINFORCED_GLASS, 4)).buildAndRegister();
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(4).inputs(MetaItems.ADVANCED_ALLOY_PLATE.getStackForm(), new ItemStack(Blocks.GLASS, 3)).outputs(GAMetaBlocks.TRANSPARENT_CASING.getItemVariant(GATransparentCasing.CasingType.REINFORCED_GLASS, 4)).buildAndRegister();

        //Iridium Alloy
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:ingot_iridium_alloy"));
        ModHandler.addShapedRecipe("iridium_alloy_plate", MetaItems.INGOT_IRIDIUM_ALLOY.getStackForm(), "AIA", "IDI", "AIA", 'A', MetaItems.ADVANCED_ALLOY_PLATE.getStackForm(), 'I', "plateIridium", 'D', "plateDiamond");
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(8).inputs(MetaItems.ADVANCED_ALLOY_PLATE.getStackForm(4)).input(OrePrefix.plate, Materials.Iridium, 4).input(OrePrefix.plate, Materials.Diamond).outputs(MetaItems.INGOT_IRIDIUM_ALLOY.getStackForm()).buildAndRegister();

        ModHandler.addShapelessRecipe("ultima", OreDictUnifier.get(OrePrefix.dust, GAMaterials.Ultima, 4), "dustTinAlloy", "dustUltimet", "dustMagnalium", "dustBlueSteel", "dustVanadiumSteel", "dustSterlingSilver", "dustHsss", "dustNaquadahAlloy");

        //Machine Component Recipes
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.circuit, Tier.Basic, 4).input(OrePrefix.dust, Materials.EnderPearl).input(OrePrefix.wireGtSingle, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.circuit, Tier.Basic, 4).input(OrePrefix.gem, Materials.EnderPearl).input(OrePrefix.wireGtSingle, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.circuit, Tier.Good, 4).input(OrePrefix.dust, Materials.EnderEye).input(OrePrefix.wireGtDouble, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_MV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.circuit, Tier.Good, 4).input(OrePrefix.gem, Materials.EnderEye).input(OrePrefix.wireGtDouble, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_MV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(480).input(OrePrefix.circuit, Tier.Advanced, 4).inputs(MetaItems.QUANTUM_EYE.getStackForm()).input(OrePrefix.wireGtQuadruple, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_HV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.circuit, Tier.Extreme, 4).input(OrePrefix.dust, Materials.NetherStar).input(OrePrefix.wireGtOctal, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_EV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.circuit, Tier.Extreme, 4).input(OrePrefix.gem, Materials.NetherStar).input(OrePrefix.wireGtOctal, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_EV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(640).EUt(7680).input(OrePrefix.circuit, Tier.Elite, 4).inputs(MetaItems.QUANTUM_STAR.getStackForm()).input(OrePrefix.wireGtHex, Materials.Osmium, 4).outputs(MetaItems.FIELD_GENERATOR_IV.getStackForm()).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.cableGtSingle, Materials.Tin, 2).input(OrePrefix.stick, Materials.Iron, 2).input(OrePrefix.stick, Materials.IronMagnetic).input(OrePrefix.wireGtSingle, Materials.Copper, 4).outputs(MetaItems.ELECTRIC_MOTOR_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.cableGtSingle, Materials.Tin, 2).input(OrePrefix.stick, Materials.Steel, 2).input(OrePrefix.stick, Materials.SteelMagnetic).input(OrePrefix.wireGtSingle, Materials.Copper, 4).outputs(MetaItems.ELECTRIC_MOTOR_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.cableGtSingle, Materials.Copper, 2).input(OrePrefix.stick, Materials.Aluminium, 2).input(OrePrefix.stick, Materials.SteelMagnetic).input(OrePrefix.wireGtDouble, Materials.Copper, 4).outputs(MetaItems.ELECTRIC_MOTOR_MV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(480).input(OrePrefix.cableGtSingle, Materials.Gold, 2).input(OrePrefix.stick, Materials.StainlessSteel, 2).input(OrePrefix.stick, Materials.SteelMagnetic).input(OrePrefix.wireGtQuadruple, Materials.Copper, 4).outputs(MetaItems.ELECTRIC_MOTOR_HV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.cableGtSingle, Materials.Aluminium, 2).input(OrePrefix.stick, Materials.Titanium, 2).input(OrePrefix.stick, Materials.NeodymiumMagnetic).input(OrePrefix.wireGtOctal, Materials.Copper, 4).outputs(MetaItems.ELECTRIC_MOTOR_EV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(640).EUt(7680).input(OrePrefix.cableGtSingle, Materials.Tungsten, 2).input(OrePrefix.stick, Materials.TungstenSteel, 2).input(OrePrefix.stick, Materials.NeodymiumMagnetic).input(OrePrefix.wireGtHex, Materials.Copper, 4).outputs(MetaItems.ELECTRIC_MOTOR_IV.getStackForm()).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.cableGtSingle, Materials.Tin).inputs(MetaItems.ELECTRIC_MOTOR_LV.getStackForm(2)).input(OrePrefix.plate, Materials.Rubber, 6).outputs(MetaItems.CONVEYOR_MODULE_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.cableGtSingle, Materials.Copper).inputs(MetaItems.ELECTRIC_MOTOR_MV.getStackForm(2)).input(OrePrefix.plate, Materials.Rubber, 6).outputs(MetaItems.CONVEYOR_MODULE_MV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(480).input(OrePrefix.cableGtSingle, Materials.Gold).inputs(MetaItems.ELECTRIC_MOTOR_HV.getStackForm(2)).input(OrePrefix.plate, Materials.Rubber, 6).outputs(MetaItems.CONVEYOR_MODULE_HV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.cableGtSingle, Materials.Aluminium).inputs(MetaItems.ELECTRIC_MOTOR_EV.getStackForm(2)).input(OrePrefix.plate, Materials.Rubber, 6).outputs(MetaItems.CONVEYOR_MODULE_EV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(640).EUt(7680).input(OrePrefix.cableGtSingle, Materials.Tungsten).inputs(MetaItems.ELECTRIC_MOTOR_IV.getStackForm(2)).input(OrePrefix.plate, Materials.Rubber, 6).outputs(MetaItems.CONVEYOR_MODULE_IV.getStackForm()).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.circuit, Tier.Basic, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin, 2), OreDictUnifier.get(OrePrefix.gem, Materials.Quartzite)).input(OrePrefix.stick, Materials.Brass, 4).outputs(MetaItems.EMITTER_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.circuit, Tier.Good, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper, 2), OreDictUnifier.get(OrePrefix.gem, Materials.NetherQuartz)).input(OrePrefix.stick, Materials.Electrum, 4).outputs(MetaItems.EMITTER_MV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(480).input(OrePrefix.circuit, Tier.Advanced, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Gold, 2), OreDictUnifier.get(OrePrefix.gem, Materials.Emerald)).input(OrePrefix.stick, Materials.Chrome, 4).outputs(MetaItems.EMITTER_HV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.circuit, Tier.Extreme, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Aluminium, 2), OreDictUnifier.get(OrePrefix.gem, Materials.EnderPearl)).input(OrePrefix.stick, Materials.Platinum, 4).outputs(MetaItems.EMITTER_EV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(640).EUt(7680).input(OrePrefix.circuit, Tier.Elite, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tungsten, 2), OreDictUnifier.get(OrePrefix.gem, Materials.EnderEye)).input(OrePrefix.stick, Materials.Osmium, 4).outputs(MetaItems.EMITTER_IV.getStackForm()).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.plate, Materials.Steel, 3).input(OrePrefix.cableGtSingle, Materials.Tin, 2).input(OrePrefix.stick, Materials.Steel, 2).input(OrePrefix.gearSmall, Materials.Steel).inputs(MetaItems.ELECTRIC_MOTOR_LV.getStackForm()).outputs(MetaItems.ELECTRIC_PISTON_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.plate, Materials.Aluminium, 3).input(OrePrefix.cableGtSingle, Materials.Copper, 2).input(OrePrefix.stick, Materials.Aluminium, 2).input(OrePrefix.gearSmall, Materials.Aluminium).inputs(MetaItems.ELECTRIC_MOTOR_MV.getStackForm()).outputs(MetaItems.ELECTRIC_PISTON_MV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(480).input(OrePrefix.plate, Materials.StainlessSteel, 3).input(OrePrefix.cableGtSingle, Materials.Gold, 2).input(OrePrefix.stick, Materials.StainlessSteel, 2).input(OrePrefix.gearSmall, Materials.StainlessSteel).inputs(MetaItems.ELECTRIC_MOTOR_HV.getStackForm()).outputs(MetaItems.ELECTRIC_PISTON_HV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.plate, Materials.Titanium, 3).input(OrePrefix.cableGtSingle, Materials.Aluminium, 2).input(OrePrefix.stick, Materials.Titanium, 2).input(OrePrefix.gearSmall, Materials.Titanium).inputs(MetaItems.ELECTRIC_MOTOR_EV.getStackForm()).outputs(MetaItems.ELECTRIC_PISTON_EV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(640).EUt(7680).input(OrePrefix.plate, Materials.TungstenSteel, 3).input(OrePrefix.cableGtSingle, Materials.Tungsten, 2).input(OrePrefix.stick, Materials.TungstenSteel, 2).input(OrePrefix.gearSmall, Materials.TungstenSteel).inputs(MetaItems.ELECTRIC_MOTOR_IV.getStackForm()).outputs(MetaItems.ELECTRIC_PISTON_IV.getStackForm()).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.circuit, Tier.Basic).input(OrePrefix.cableGtSingle, Materials.Tin, 3).input(OrePrefix.stick, Materials.Steel, 2).inputs(MetaItems.ELECTRIC_PISTON_LV.getStackForm(), MetaItems.ELECTRIC_MOTOR_LV.getStackForm(2)).outputs(MetaItems.ROBOT_ARM_LV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.circuit, Tier.Good).input(OrePrefix.cableGtSingle, Materials.Copper, 3).input(OrePrefix.stick, Materials.Aluminium, 2).inputs(MetaItems.ELECTRIC_PISTON_MV.getStackForm(), MetaItems.ELECTRIC_MOTOR_MV.getStackForm(2)).outputs(MetaItems.ROBOT_ARM_MV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(480).input(OrePrefix.circuit, Tier.Advanced).input(OrePrefix.cableGtSingle, Materials.Gold, 3).input(OrePrefix.stick, Materials.StainlessSteel, 2).inputs(MetaItems.ELECTRIC_PISTON_HV.getStackForm(), MetaItems.ELECTRIC_MOTOR_HV.getStackForm(2)).outputs(MetaItems.ROBOT_ARM_HV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.circuit, Tier.Extreme).input(OrePrefix.cableGtSingle, Materials.Aluminium, 3).input(OrePrefix.stick, Materials.Titanium, 2).inputs(MetaItems.ELECTRIC_PISTON_EV.getStackForm(), MetaItems.ELECTRIC_MOTOR_EV.getStackForm(2)).outputs(MetaItems.ROBOT_ARM_EV.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(640).EUt(7680).input(OrePrefix.circuit, Tier.Elite).input(OrePrefix.cableGtSingle, Materials.Tungsten, 3).input(OrePrefix.stick, Materials.TungstenSteel, 2).inputs(MetaItems.ELECTRIC_PISTON_IV.getStackForm(), MetaItems.ELECTRIC_MOTOR_IV.getStackForm(2)).outputs(MetaItems.ROBOT_ARM_IV.getStackForm()).buildAndRegister();

        for (MaterialStack stackFluid : cableFluids) {
            IngotMaterial m = (IngotMaterial) stackFluid.material;
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(30).input(OrePrefix.cableGtSingle, Materials.Tin).input(OrePrefix.screw, Materials.Tin).input(OrePrefix.rotor, Materials.Tin).input(OrePrefix.pipeMedium, Materials.Copper).inputs(MetaItems.ELECTRIC_MOTOR_LV.getStackForm()).input(OrePrefix.ring, m).outputs(MetaItems.ELECTRIC_PUMP_LV.getStackForm()).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(120).input(OrePrefix.cableGtSingle, Materials.Copper).input(OrePrefix.screw, Materials.Bronze).input(OrePrefix.rotor, Materials.Bronze).input(OrePrefix.pipeMedium, Materials.Steel).inputs(MetaItems.ELECTRIC_MOTOR_MV.getStackForm()).input(OrePrefix.ring, m).outputs(MetaItems.ELECTRIC_PUMP_MV.getStackForm()).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(480).input(OrePrefix.cableGtSingle, Materials.Gold).input(OrePrefix.screw, Materials.Steel).input(OrePrefix.rotor, Materials.Steel).input(OrePrefix.pipeMedium, Materials.StainlessSteel).inputs(MetaItems.ELECTRIC_MOTOR_HV.getStackForm()).input(OrePrefix.ring, m).outputs(MetaItems.ELECTRIC_PUMP_HV.getStackForm()).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(1920).input(OrePrefix.cableGtSingle, Materials.Aluminium).input(OrePrefix.screw, Materials.StainlessSteel).input(OrePrefix.rotor, Materials.StainlessSteel).input(OrePrefix.pipeMedium, Materials.Titanium).inputs(MetaItems.ELECTRIC_MOTOR_EV.getStackForm()).input(OrePrefix.ring, m).outputs(MetaItems.ELECTRIC_PUMP_EV.getStackForm()).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(640).EUt(7680).input(OrePrefix.cableGtSingle, Materials.Tungsten).input(OrePrefix.screw, Materials.TungstenSteel).input(OrePrefix.rotor, Materials.TungstenSteel).input(OrePrefix.pipeMedium, Materials.TungstenSteel).inputs(MetaItems.ELECTRIC_MOTOR_IV.getStackForm()).input(OrePrefix.ring, m).outputs(MetaItems.ELECTRIC_PUMP_IV.getStackForm()).buildAndRegister();
        }

        //Coke Oven Recipes
        GARecipeMaps.COKE_OVEN_RECIPES.recipeBuilder().duration(1800).input(OrePrefix.gem, Materials.Coal).outputs(OreDictUnifier.get(OrePrefix.gem, Materials.Coke)).fluidOutputs(Materials.Creosote.getFluid(500)).buildAndRegister();
        GARecipeMaps.COKE_OVEN_RECIPES.recipeBuilder().duration(1800).input(OrePrefix.gem, Materials.Lignite).outputs(OreDictUnifier.get(OrePrefix.gem, GAMaterials.LigniteCoke)).fluidOutputs(Materials.Creosote.getFluid(500)).buildAndRegister();
        GARecipeMaps.COKE_OVEN_RECIPES.recipeBuilder().duration(1800).input(OrePrefix.log, Materials.Wood).outputs(new ItemStack(Items.COAL, 1, 1)).fluidOutputs(Materials.Creosote.getFluid(500)).buildAndRegister();

        //Pyrolise Oven Recipes
        RecipeMaps.PYROLYSE_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Items.SUGAR, 23))
                .circuitMeta(1)
                .outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal, 12))
                .fluidOutputs(Materials.Water.getFluid(1500))
                .duration(640)
                .EUt(64)
                .buildAndRegister();

        RecipeMaps.PYROLYSE_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Items.SUGAR, 23))
                .circuitMeta(2)
                .fluidInputs(Materials.Nitrogen.getFluid(400))
                .outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal, 12))
                .fluidOutputs(Materials.Water.getFluid(1500))
                .duration(320)
                .EUt(96)
                .buildAndRegister();

        //Chemical Reactor Cracking
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Ethane.getFluid(1000)).fluidOutputs(Materials.HydroCrackedEthane.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Ethylene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedEthylene.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Propene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedPropene.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Propane.getFluid(1000)).fluidOutputs(Materials.HydroCrackedPropane.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.LightFuel.getFluid(1000)).fluidOutputs(Materials.HydroCrackedLightFuel.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Butane.getFluid(1000)).fluidOutputs(Materials.HydroCrackedButane.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Naphtha.getFluid(1000)).fluidOutputs(Materials.HydroCrackedNaphtha.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.HeavyFuel.getFluid(1000)).fluidOutputs(Materials.HydroCrackedHeavyFuel.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Gas.getFluid(1000)).fluidOutputs(Materials.HydroCrackedGas.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Butene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedButene.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Butadiene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedButadiene.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Ethane.getFluid(1000)).fluidOutputs(Materials.SteamCrackedEthane.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Ethylene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedEthylene.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Propene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedPropene.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Propane.getFluid(1000)).fluidOutputs(Materials.SteamCrackedPropane.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.LightFuel.getFluid(1000)).fluidOutputs(Materials.CrackedLightFuel.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Butane.getFluid(1000)).fluidOutputs(Materials.SteamCrackedButane.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Naphtha.getFluid(1000)).fluidOutputs(Materials.SteamCrackedNaphtha.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.HeavyFuel.getFluid(1000)).fluidOutputs(Materials.CrackedHeavyFuel.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Gas.getFluid(1000)).fluidOutputs(Materials.SteamCrackedGas.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Butene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedButene.getFluid(1000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Butadiene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedButadiene.getFluid(1000)).buildAndRegister();

        //Fish Oil
        RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(16).EUt(96).fluidInputs(GAMaterials.FishOil.getFluid(24)).fluidOutputs(Materials.Lubricant.getFluid(12)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(GAMaterials.FishOil.getFluid(6000), Materials.Methanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(GAMaterials.FishOil.getFluid(6000), Materials.Ethanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();

        //Fluid Heater Recipes
        RecipeMaps.FLUID_HEATER_RECIPES.recipeBuilder().duration(30).EUt(24).circuitMeta(1).fluidInputs(GAMaterials.RawGrowthMedium.getFluid(500)).fluidOutputs(GAMaterials.SterilizedGrowthMedium.getFluid(500)).buildAndRegister();

        //Oil Extractor Recipes
        RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH)).fluidOutputs(GAMaterials.FishOil.getFluid(40)).buildAndRegister();
        RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH, 1, 1)).fluidOutputs(GAMaterials.FishOil.getFluid(60)).buildAndRegister();
        RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH, 1, 2)).fluidOutputs(GAMaterials.FishOil.getFluid(70)).buildAndRegister();
        RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH, 1, 3)).fluidOutputs(GAMaterials.FishOil.getFluid(30)).buildAndRegister();

        //Misc Blast Furnace Recipes
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Galena).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.Massicot), OreDictUnifier.get(OrePrefix.nugget, Materials.Lead, 6)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Stibnite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.AntimonyTrioxide), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Sphalerite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.Zincite), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Cobaltite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.CobaltOxide), OreDictUnifier.get(OrePrefix.dust, GAMaterials.ArsenicTrioxide)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Tetrahedrite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.CupricOxide), OreDictUnifier.get(OrePrefix.dustTiny, GAMaterials.AntimonyTrioxide, 3)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Chalcopyrite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.CupricOxide), OreDictUnifier.get(OrePrefix.dust, GAMaterials.Ferrosilite)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Pentlandite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Garnierite), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Pyrite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.BandedIron), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, GAMaterials.Massicot, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Lead, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, GAMaterials.AntimonyTrioxide, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Antimony, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(3000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, GAMaterials.CobaltOxide, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Cobalt, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, GAMaterials.ArsenicTrioxide, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Arsenic, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, GAMaterials.CupricOxide, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Copper, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Garnierite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Nickel, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.BandedIron, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, GAMaterials.Massicot, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Lead, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, GAMaterials.Massicot, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Lead, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.SiliconDioxide).input(OrePrefix.dust, Materials.Carbon, 2).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Silicon), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.CarbonMonoxde.getFluid(2000)).buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Malachite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Copper, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(3000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Magnetite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.GraniticMineralSand, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.BrownLimonite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.YellowLimonite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.BasalticMineralSand, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Cassiterite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Tin, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.CassiteriteSand, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Tin, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();

        for (MaterialStack ore : ironOres) {
            Material materials = ore.material;
            RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(500).EUt(120).blastFurnaceTemp(1500).input(OrePrefix.ore, materials).input(OrePrefix.dust, Materials.Calcite).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustSmall, Materials.DarkAsh)).buildAndRegister();
            RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(500).EUt(120).blastFurnaceTemp(1500).input(OrePrefix.ore, materials).input(OrePrefix.dustTiny, Materials.Quicklime, 3).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 2), OreDictUnifier.get(OrePrefix.dustSmall, Materials.DarkAsh)).buildAndRegister();
        }

        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(944).EUt(120).input(OrePrefix.dust, Materials.Silicon).notConsumable(new IntCircuitIngredient(1)).blastFurnaceTemp(1687).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Silicon)).buildAndRegister();

        //Mince Meat Recipes
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16).inputs(new ItemStack(Items.PORKCHOP)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, GAMaterials.Meat, 6)).buildAndRegister();
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16).inputs(new ItemStack(Items.BEEF)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, GAMaterials.Meat, 6)).buildAndRegister();
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16).inputs(new ItemStack(Items.RABBIT)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, GAMaterials.Meat, 6)).buildAndRegister();
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(40).EUt(16).inputs(new ItemStack(Items.CHICKEN)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.Meat)).buildAndRegister();
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(40).EUt(16).inputs(new ItemStack(Items.MUTTON)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.Meat)).buildAndRegister();

        //Circuit Rabbit Hole - Layer 1
        ModHandler.removeRecipes(MetaItems.BASIC_CIRCUIT_LV.getStackForm());
        ModHandler.addShapedRecipe("basic_circuit_ga", MetaItems.BASIC_CIRCUIT_LV.getStackForm(), "RPR", "TBT", "CCC", 'R', MetaItems.RESISTOR, 'P', "plateSteel", 'T', MetaItems.VACUUM_TUBE, 'B', GAMetaItems.BASIC_BOARD, 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.RedAlloy));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:good_circuit"));
        ModHandler.addShapedRecipe("good_circuit_ga", GAMetaItems.GOOD_CIRCUIT.getStackForm(), "WPW", "CBC", "DCD", 'P', "plateSteel", 'C', MetaItems.BASIC_CIRCUIT_LV.getStackForm(), 'W', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper), 'D', MetaItems.DIODE.getStackForm(), 'B', GAMetaItems.GOOD_PHENOLIC_BOARD);

        for (MaterialStack stack : solderingList) {
            IngotMaterial material = (IngotMaterial) stack.material;
            int multiplier = (int) stack.amount;
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(16).inputs(GAMetaItems.BASIC_BOARD.getStackForm(), MetaItems.RESISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.RedAlloy, 2), MetaItems.VACUUM_TUBE.getStackForm(2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.BASIC_CIRCUIT_LV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(16).inputs(GAMetaItems.BASIC_BOARD.getStackForm(), MetaItems.SMD_RESISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.RedAlloy, 2), MetaItems.VACUUM_TUBE.getStackForm(2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.BASIC_CIRCUIT_LV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(300).EUt(30).inputs(GAMetaItems.GOOD_PHENOLIC_BOARD.getStackForm(), MetaItems.BASIC_CIRCUIT_LV.getStackForm(2), MetaItems.DIODE.getStackForm(2)).input(OrePrefix.wireGtSingle, Materials.Copper, 2).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.GOOD_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(300).EUt(30).inputs(GAMetaItems.GOOD_PHENOLIC_BOARD.getStackForm(), MetaItems.BASIC_CIRCUIT_LV.getStackForm(2), MetaItems.SMD_DIODE.getStackForm(2)).input(OrePrefix.wireGtSingle, Materials.Copper, 2).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.GOOD_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(8).inputs(GAMetaItems.BASIC_BOARD.getStackForm(), MetaItems.INTEGRATED_LOGIC_CIRCUIT.getStackForm(), MetaItems.RESISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.BASIC_ELECTRONIC_CIRCUIT_LV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(8).inputs(GAMetaItems.BASIC_BOARD.getStackForm(), MetaItems.INTEGRATED_LOGIC_CIRCUIT.getStackForm(), MetaItems.SMD_RESISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.BASIC_ELECTRONIC_CIRCUIT_LV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.CENTRAL_PROCESSING_UNIT.getStackForm(4), MetaItems.RESISTOR.getStackForm(4), MetaItems.CAPACITOR.getStackForm(4), MetaItems.TRANSISTOR.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.ADVANCED_CIRCUIT_PARTS_LV.getStackForm(4)).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.CENTRAL_PROCESSING_UNIT.getStackForm(4), MetaItems.SMD_RESISTOR.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(4), MetaItems.SMD_TRANSISTOR.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.ADVANCED_CIRCUIT_PARTS_LV.getStackForm(4)).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(600).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.SYSTEM_ON_CHIP.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.ADVANCED_CIRCUIT_PARTS_LV.getStackForm(4)).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(16).inputs(GAMetaItems.GOOD_PHENOLIC_BOARD.getStackForm(), MetaItems.BASIC_ELECTRONIC_CIRCUIT_LV.getStackForm(2), MetaItems.RESISTOR.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 8)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.GOOD_INTEGRATED_CIRCUIT_MV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(16).inputs(GAMetaItems.GOOD_PHENOLIC_BOARD.getStackForm(), MetaItems.BASIC_ELECTRONIC_CIRCUIT_LV.getStackForm(2), MetaItems.SMD_RESISTOR.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 8)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.GOOD_INTEGRATED_CIRCUIT_MV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.RESISTOR.getStackForm(2), MetaItems.CAPACITOR.getStackForm(2), MetaItems.TRANSISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.ADVANCED_CIRCUIT_MV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.SMD_RESISTOR.getStackForm(2), MetaItems.SMD_CAPACITOR.getStackForm(2), MetaItems.SMD_TRANSISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.ADVANCED_CIRCUIT_MV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(2400).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.ADVANCED_CIRCUIT_MV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(800).EUt(28).inputs(MetaItems.GOOD_INTEGRATED_CIRCUIT_MV.getStackForm(2), MetaItems.INTEGRATED_LOGIC_CIRCUIT.getStackForm(3), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(), MetaItems.TRANSISTOR.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 16)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.ADVANCED_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(800).EUt(28).inputs(MetaItems.GOOD_INTEGRATED_CIRCUIT_MV.getStackForm(2), MetaItems.INTEGRATED_LOGIC_CIRCUIT.getStackForm(3), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(), MetaItems.SMD_TRANSISTOR.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 16)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.ADVANCED_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.ADVANCED_CIRCUIT_MV.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.CAPACITOR.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 12)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.PROCESSOR_ASSEMBLY_HV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(80).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.ADVANCED_CIRCUIT_MV.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 12)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.PROCESSOR_ASSEMBLY_HV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(600).inputs(GAMetaItems.ADVANCED_BOARD.getStackForm(), MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.SMD_RESISTOR.getStackForm(2), MetaItems.SMD_CAPACITOR.getStackForm(2), MetaItems.SMD_TRANSISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.NANO_PROCESSOR_HV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(9600).inputs(GAMetaItems.ADVANCED_BOARD.getStackForm(), MetaItems.SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.NANO_PROCESSOR_HV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(2), MetaItems.PROCESSOR_ASSEMBLY_HV.getStackForm(2), MetaItems.DIODE.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.INTEGRATED_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(2), MetaItems.PROCESSOR_ASSEMBLY_HV.getStackForm(2), MetaItems.SMD_DIODE.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.INTEGRATED_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(600).inputs(GAMetaItems.ADVANCED_BOARD.getStackForm(), MetaItems.NANO_PROCESSOR_HV.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.NANO_PROCESSOR_ASSEMBLY_EV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(2400).inputs(GAMetaItems.EXTREME_BOARD.getStackForm(), MetaItems.QBIT_CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.SMD_CAPACITOR.getStackForm(2), MetaItems.SMD_TRANSISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.QUANTUM_PROCESSOR_EV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(38400).inputs(GAMetaItems.EXTREME_BOARD.getStackForm(), MetaItems.ADVANCED_SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.QUANTUM_PROCESSOR_EV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(480).inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium), GAMetaItems.INTEGRATED_COMPUTER.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.CAPACITOR.getStackForm(24), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.AnnealedCopper, 12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.INTEGRATED_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(480).inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium), GAMetaItems.INTEGRATED_COMPUTER.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(24), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.AnnealedCopper, 12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.INTEGRATED_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(600).inputs(GAMetaItems.ADVANCED_BOARD.getStackForm(2), MetaItems.NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2), MetaItems.SMD_DIODE.getStackForm(4), MetaItems.NOR_MEMORY_CHIP.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.NANO_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(2400).inputs(GAMetaItems.EXTREME_BOARD.getStackForm(), MetaItems.QUANTUM_PROCESSOR_EV.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.DATA_CONTROL_CIRCUIT_IV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(9600).inputs(GAMetaItems.ELITE_BOARD.getStackForm(), MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.SMD_CAPACITOR.getStackForm(2), MetaItems.SMD_TRANSISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CRYSTAL_PROCESSOR_IV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(153600).inputs(GAMetaItems.ELITE_BOARD.getStackForm(), MetaItems.CRYSTAL_SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CRYSTAL_PROCESSOR_IV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(1920).inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium), GAMetaItems.NANO_COMPUTER.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(24), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.AnnealedCopper, 12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.NANO_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(2400).inputs(GAMetaItems.EXTREME_BOARD.getStackForm(2), MetaItems.DATA_CONTROL_CIRCUIT_IV.getStackForm(2), MetaItems.SMD_DIODE.getStackForm(4), MetaItems.NOR_MEMORY_CHIP.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.QUANTUM_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(9600).inputs(GAMetaItems.ELITE_BOARD.getStackForm(), MetaItems.CRYSTAL_PROCESSOR_IV.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.ENERGY_FLOW_CIRCUIT_LUV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(38400).inputs(GAMetaItems.NEURO_PROCESSOR.getStackForm(), MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), MetaItems.SMD_CAPACITOR.getStackForm(2), MetaItems.SMD_TRANSISTOR.getStackForm(2), OreDictUnifier.get(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.WETWARE_PROCESSOR_LUV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(7680).inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium), GAMetaItems.QUANTUM_COMPUTER.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(24), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.AnnealedCopper, 12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.QUANTUM_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(9600).inputs(GAMetaItems.ELITE_BOARD.getStackForm(2), MetaItems.ENERGY_FLOW_CIRCUIT_LUV.getStackForm(2), MetaItems.SMD_DIODE.getStackForm(4), MetaItems.NOR_MEMORY_CHIP.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.CRYSTAL_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(38400).inputs(GAMetaItems.MASTER_BOARD.getStackForm(), MetaItems.WETWARE_PROCESSOR_LUV.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.WETWARE_PROCESSOR_ASSEMBLY_ZPM.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(30720).inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium), GAMetaItems.CRYSTAL_COMPUTER.getStackForm(2), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(24), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.LuVSuperconductor, 12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.CRYSTAL_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(38400).inputs(GAMetaItems.MASTER_BOARD.getStackForm(2), MetaItems.WETWARE_PROCESSOR_ASSEMBLY_ZPM.getStackForm(2), MetaItems.SMD_DIODE.getStackForm(4), MetaItems.NOR_MEMORY_CHIP.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(512).EUt(1024).inputs(GAMetaItems.EXTREME_BOARD.getStackForm(), MetaItems.POWER_INTEGRATED_CIRCUIT.getStackForm(4), MetaItems.ENGRAVED_LAPOTRON_CHIP.getStackForm(18), MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 16)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.ENERGY_LAPOTRONIC_ORB.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1024).EUt(4096).inputs(GAMetaItems.EXTREME_BOARD.getStackForm(), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(4), MetaItems.ENERGY_LAPOTRONIC_ORB.getStackForm(8), MetaItems.QBIT_CENTRAL_PROCESSING_UNIT.getStackForm(), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 16)).input(OrePrefix.plate, Materials.Europium, 4).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm(), MetaItems.ADVANCED_CIRCUIT_MV.getStackForm(), MetaItems.NAND_MEMORY_CHIP.getStackForm(32), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 8)).input(OrePrefix.plate, Materials.Plastic, 4).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.TOOL_DATA_STICK.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(1200).inputs(GAMetaItems.ADVANCED_BOARD.getStackForm(), MetaItems.NANO_PROCESSOR_HV.getStackForm(), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(32), MetaItems.NAND_MEMORY_CHIP.getStackForm(64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 32)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.TOOL_DATA_ORB.getStackForm()).buildAndRegister();
        }

        GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(30).EUt(4).input(OrePrefix.dust, Materials.Tantalum).input(OrePrefix.foil, Materials.Manganese).fluidInputs(Materials.Plastic.getFluid(144)).outputs(MetaItems.BATTERY_RE_ULV_TANTALUM.getStackForm(8)).buildAndRegister();

        //Circuit Rabbit Hole - Layer 2
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(480).inputs(GAMetaItems.ELITE_BOARD.getStackForm(), GAMetaItems.PETRI_DISH.getStackForm(), MetaItems.ELECTRIC_PUMP_LV.getStackForm(), MetaItems.SENSOR_LV.getStackForm()).input(OrePrefix.circuit, Tier.Good).fluidInputs(GAMaterials.SterilizedGrowthMedium.getFluid(250)).outputs(MetaItems.WETWARE_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(30).EUt(480).fluidInputs(GAMaterials.PositiveMatter.getFluid(10), GAMaterials.NeutralMatter.getFluid(10)).fluidOutputs(Materials.UUMatter.getFluid(20)).buildAndRegister();

        ModHandler.removeRecipes(MetaItems.COATED_BOARD.getStackForm(3));
        ModHandler.addShapedRecipe("coated_board_shaped", MetaItems.COATED_BOARD.getStackForm(3), "RRR", "BBB", "RRR", 'R', MetaItems.RUBBER_DROP, 'B', "plateWood");
        ModHandler.addShapelessRecipe("coated_board_shapeless", MetaItems.COATED_BOARD.getStackForm(), MetaItems.RUBBER_DROP, MetaItems.RUBBER_DROP, "plateWood");
        ModHandler.addShapedRecipe("basic_board", GAMetaItems.BASIC_BOARD.getStackForm(), "WWW", "WBW", "WWW", 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.Copper), 'B', MetaItems.COATED_BOARD);
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40).EUt(200).input(OrePrefix.plate, Materials.Wood).input(OrePrefix.foil, Materials.Copper, 4).fluidInputs(Materials.Glue.getFluid(72)).outputs(GAMetaItems.BASIC_BOARD.getStackForm()).buildAndRegister();
        ModHandler.addShapedRecipe("good_board", GAMetaItems.GOOD_PHENOLIC_BOARD.getStackForm(), "WWW", "WBW", "WWW", 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.Gold), 'B', MetaItems.PHENOLIC_BOARD);
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).inputs(MetaItems.PHENOLIC_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Gold, 4).fluidInputs(Materials.SodiumPersulfate.getFluid(200)).outputs(GAMetaItems.GOOD_PHENOLIC_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).inputs(MetaItems.PHENOLIC_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Gold, 4).fluidInputs(GAMaterials.IronChloride.getFluid(100)).outputs(GAMetaItems.GOOD_PHENOLIC_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(800).EUt(30).inputs(MetaItems.PLASTIC_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Copper, 6).fluidInputs(Materials.SodiumPersulfate.getFluid(500)).outputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(800).EUt(30).inputs(MetaItems.PLASTIC_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Copper, 6).fluidInputs(GAMaterials.IronChloride.getFluid(250)).outputs(GAMetaItems.GOOD_PLASTIC_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(1200).EUt(30).inputs(MetaItems.EPOXY_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Electrum, 8).fluidInputs(Materials.SodiumPersulfate.getFluid(1000)).outputs(GAMetaItems.ADVANCED_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(1200).EUt(30).inputs(MetaItems.EPOXY_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Electrum, 8).fluidInputs(GAMaterials.IronChloride.getFluid(500)).outputs(GAMetaItems.ADVANCED_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(1800).EUt(30).inputs(MetaItems.FIBER_BOARD.getStackForm()).input(OrePrefix.foil, Materials.AnnealedCopper, 12).fluidInputs(Materials.SodiumPersulfate.getFluid(2000)).outputs(GAMetaItems.EXTREME_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(1800).EUt(30).inputs(MetaItems.FIBER_BOARD.getStackForm()).input(OrePrefix.foil, Materials.AnnealedCopper, 12).fluidInputs(GAMaterials.IronChloride.getFluid(1000)).outputs(GAMetaItems.EXTREME_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(2400).EUt(120).inputs(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Platinum, 16).fluidInputs(Materials.SodiumPersulfate.getFluid(4000)).outputs(GAMetaItems.ELITE_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(2400).EUt(120).inputs(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm()).input(OrePrefix.foil, Materials.Platinum, 16).fluidInputs(GAMaterials.IronChloride.getFluid(2000)).outputs(GAMetaItems.ELITE_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(3000).EUt(480).inputs(MetaItems.WETWARE_BOARD.getStackForm()).input(OrePrefix.foil, Materials.NiobiumTitanium, 32).fluidInputs(Materials.SodiumPersulfate.getFluid(10000)).outputs(GAMetaItems.MASTER_BOARD.getStackForm()).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(3000).EUt(480).inputs(MetaItems.WETWARE_BOARD.getStackForm()).input(OrePrefix.foil, Materials.NiobiumTitanium, 32).fluidInputs(GAMaterials.IronChloride.getFluid(5000)).outputs(GAMetaItems.MASTER_BOARD.getStackForm()).buildAndRegister();

        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:diode"));
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.Copper, 4).input(OrePrefix.dustSmall, Materials.GalliumArsenide).fluidInputs(Materials.Glass.getFluid(288)).outputs(MetaItems.DIODE.getStackForm(2)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.AnnealedCopper, 4).input(OrePrefix.dustSmall, Materials.GalliumArsenide).fluidInputs(Materials.Glass.getFluid(288)).outputs(MetaItems.DIODE.getStackForm(2)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.Copper, 4).input(OrePrefix.dustSmall, Materials.GalliumArsenide).fluidInputs(Materials.Plastic.getFluid(144)).outputs(MetaItems.DIODE.getStackForm(4)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.AnnealedCopper, 4).input(OrePrefix.dustSmall, Materials.GalliumArsenide).fluidInputs(Materials.Plastic.getFluid(144)).outputs(MetaItems.DIODE.getStackForm(4)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.Copper, 4).inputs(MetaItems.SILICON_WAFER.getStackForm()).fluidInputs(Materials.Glass.getFluid(288)).outputs(MetaItems.DIODE.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.AnnealedCopper, 4).inputs(MetaItems.SILICON_WAFER.getStackForm()).fluidInputs(Materials.Glass.getFluid(288)).outputs(MetaItems.DIODE.getStackForm()).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.Copper, 4).inputs(MetaItems.SILICON_WAFER.getStackForm()).fluidInputs(Materials.Plastic.getFluid(144)).outputs(MetaItems.DIODE.getStackForm(2)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.AnnealedCopper, 4).inputs(MetaItems.SILICON_WAFER.getStackForm()).fluidInputs(Materials.Plastic.getFluid(144)).outputs(MetaItems.DIODE.getStackForm(2)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.wireFine, Materials.Platinum, 8).input(OrePrefix.dust, Materials.GalliumArsenide).fluidInputs(Materials.Plastic.getFluid(288)).outputs(MetaItems.SMD_DIODE.getStackForm(32)).buildAndRegister();

        ModHandler.removeRecipes(MetaItems.RESISTOR.getStackForm(3));
        for (Material m : new Material[]{Materials.Coal, Materials.Charcoal, Materials.Carbon}) {
            ModHandler.addShapedRecipe("resistor_" + m.toString(), MetaItems.RESISTOR.getStackForm(), "RWR", "CMC", " W ", 'M', new UnificationEntry(OrePrefix.dust, m), 'R', MetaItems.RUBBER_DROP, 'W', "wireFineCopper", 'C', "wireGtSingleCopper");
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(16).input(OrePrefix.dust, m).input(OrePrefix.wireFine, Materials.Copper, 4).input(OrePrefix.wireGtSingle, Materials.Copper, 4).fluidInputs(Materials.Glue.getFluid(200)).outputs(MetaItems.RESISTOR.getStackForm(8)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(320).EUt(16).input(OrePrefix.dust, m).input(OrePrefix.wireFine, Materials.AnnealedCopper, 4).input(OrePrefix.wireGtSingle, Materials.Copper, 4).fluidInputs(Materials.Glue.getFluid(200)).outputs(MetaItems.RESISTOR.getStackForm(8)).buildAndRegister();
        }

        //Cutting Machine Recipes
        for (MaterialStack stack : sawLubricants) {
            FluidMaterial material = (FluidMaterial) stack.material;
            int multiplier = (int) stack.amount;
            int time = multiplier == 1L ? 4 : 1;
            RecipeMaps.CUTTER_RECIPES.recipeBuilder().duration(960 / time).EUt(420).inputs(MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm()).fluidInputs(material.getFluid(2 * multiplier)).outputs(GAMetaItems.RAW_CRYSTAL_CHIP.getStackForm(2)).buildAndRegister();
        }

        //Assline Casing
        ModHandler.addShapedRecipe("assline_casing", GAMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GAMultiblockCasing.CasingType.TUNGSTENSTEEL_GEARBOX_CASING, 2), "PhP", "AFA", "PwP", 'P', "plateSteel", 'A', MetaItems.ROBOT_ARM_IV.getStackForm(), 'F', OreDictUnifier.get(OrePrefix.frameGt, Materials.TungstenSteel));

        //Circuit Rabbit Hole - Layer 3
        RecipeMaps.ELECTROLYZER_RECIPES.recipeBuilder().duration(900).EUt(30).fluidInputs(Materials.NickelSulfateSolution.getFluid(9000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Nickel)).fluidOutputs(Materials.Oxygen.getFluid(1000), Materials.SulfuricAcid.getFluid(8000)).buildAndRegister();
        RecipeMaps.ELECTROLYZER_RECIPES.recipeBuilder().duration(900).EUt(30).fluidInputs(Materials.CopperSulfateSolution.getFluid(9000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Copper)).fluidOutputs(Materials.Oxygen.getFluid(1000), Materials.SulfuricAcid.getFluid(8000)).buildAndRegister();
        RecipeMaps.FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(160).EUt(16).fluidInputs(Materials.Polystyrene.getFluid(36)).notConsumable(MetaItems.SHAPE_MOLD_CYLINDER.getStackForm()).outputs(GAMetaItems.PETRI_DISH.getStackForm()).buildAndRegister();
        RecipeMaps.FLUID_SOLIDFICATION_RECIPES.recipeBuilder().duration(160).EUt(16).fluidInputs(Materials.Polytetrafluoroethylene.getFluid(36)).notConsumable(MetaItems.SHAPE_MOLD_CYLINDER.getStackForm()).outputs(GAMetaItems.PETRI_DISH.getStackForm()).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(900).EUt(480).blastFurnaceTemp(5000).inputs(GAMetaItems.RAW_CRYSTAL_CHIP.getStackForm()).input(OrePrefix.plate, Materials.Emerald).fluidInputs(Materials.Helium.getFluid(1000)).outputs(MetaItems.ENGRAVED_CRYSTAL_CHIP.getStackForm()).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(900).EUt(480).blastFurnaceTemp(5000).inputs(GAMetaItems.RAW_CRYSTAL_CHIP.getStackForm()).input(OrePrefix.plate, Materials.Olivine).fluidInputs(Materials.Helium.getFluid(1000)).outputs(MetaItems.ENGRAVED_CRYSTAL_CHIP.getStackForm()).buildAndRegister();
        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder().duration(300).EUt(1024).inputs(new ItemStack(Items.EGG)).chancedOutput(GAMetaItems.STEMCELLS.getStackForm(), 500).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(400).EUt(30).input(OrePrefix.dust, Materials.Iron).fluidInputs(Materials.HydrochloricAcid.getFluid(2000)).fluidOutputs(GAMaterials.IronChloride.getFluid(3000), Materials.Hydrogen.getFluid(3000)).buildAndRegister();
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(400).EUt(1920).inputs(MetaItems.CENTRAL_PROCESSING_UNIT_WAFER.getStackForm(), MetaItems.CARBON_FIBERS.getStackForm(16)).fluidInputs(Materials.Glowstone.getFluid(576)).outputs(MetaItems.NANO_CENTRAL_PROCESSING_UNIT_WAFER.getStackForm()).buildAndRegister();

        //Circuit Rabbit Hole - Layer 4
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().duration(12000).EUt(320).inputs(OreDictUnifier.get(OrePrefix.gemExquisite, Materials.Olivine)).fluidInputs(Materials.Europium.getFluid(16)).chancedOutput(GAMetaItems.RAW_CRYSTAL_CHIP.getStackForm(), 1000).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().duration(12000).EUt(320).inputs(OreDictUnifier.get(OrePrefix.gemExquisite, Materials.Emerald)).fluidInputs(Materials.Europium.getFluid(16)).chancedOutput(GAMetaItems.RAW_CRYSTAL_CHIP.getStackForm(), 1000).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().duration(150).EUt(6).input(OrePrefix.dust, Materials.Carbon).fluidInputs(Materials.Lutetium.getFluid(1)).chancedOutput(MetaItems.CARBON_FIBERS.getStackForm(2), 3333).buildAndRegister();
        RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder().duration(100).EUt(10000).inputs(MetaItems.ENGRAVED_CRYSTAL_CHIP.getStackForm()).notConsumable(OrePrefix.craftingLens, MarkerMaterials.Color.Lime).outputs(MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm()).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(160).EUt(16).inputs(new ItemStack(Items.SUGAR, 4), OreDictUnifier.get(OrePrefix.dust, GAMaterials.Meat), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Salt)).fluidInputs(Materials.DistilledWater.getFluid(4000)).fluidOutputs(GAMaterials.RawGrowthMedium.getFluid(4000)).buildAndRegister();
        RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(9000).EUt(120).blastFurnaceTemp(1784).input(OrePrefix.dust, Materials.Silicon, 32).input(OrePrefix.dustSmall, Materials.GalliumArsenide).outputs(MetaItems.SILICON_BOULE.getStackForm()).buildAndRegister();
        //RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(640).EUt(30).inputs(OreDictUnifier.get(OrePrefix.dust, Materials.SodiumHydroxide)).fluidInputs(Materials.Water.getFluid(1000), Materials.Chlorine.getFluid(4000), Materials.Propene.getFluid(1000)).fluidOutputs(Materials.SaltWater.getFluid(1000), Materials.Epichlorhydrin.getFluid(1000), Materials.HydrochloricAcid.getFluid(2000)).buildAndRegister();
        //RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(640).EUt(30).inputs(OreDictUnifier.get(OrePrefix.dust, Materials.SodiumHydroxide)).fluidInputs(Materials.HypochlorousAcid.getFluid(1000), Materials.Chlorine.getFluid(2000), Materials.Propene.getFluid(1000)).fluidOutputs(Materials.SaltWater.getFluid(1000), Materials.Epichlorhydrin.getFluid(1000), Materials.HydrochloricAcid.getFluid(1000)).buildAndRegister();
    }

    public static void init2() {
        //Assline Recipes
        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.stickLong, Materials.NeodymiumMagnetic, 1),
                OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSG, 2),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(144),
                Materials.Lubricant.getFluid(250))
                .outputs(MetaItems.ELECTRIC_MOTOR_LUV.getStackForm()).duration(600).EUt(10240)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.stickLong, Materials.NeodymiumMagnetic, 2),
                OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSE, 4),
                OreDictUnifier.get(OrePrefix.ring, Materials.HSSE, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSE, 16),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(288),
                Materials.Lubricant.getFluid(750))
                .outputs(MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm()).duration(600).EUt(40960)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.block, Materials.NeodymiumMagnetic, 1),
                OreDictUnifier.get(OrePrefix.stickLong, GAMaterials.Neutronium, 4),
                OreDictUnifier.get(OrePrefix.ring, GAMaterials.Neutronium, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), GAMaterials.Neutronium, 16),
                OreDictUnifier.get(OrePrefix.wireFine, GAMaterials.Ultima, 64),
                OreDictUnifier.get(OrePrefix.wireFine, GAMaterials.Ultima, 64),
                OreDictUnifier.get(OrePrefix.wireFine, GAMaterials.Ultima, 64),
                OreDictUnifier.get(OrePrefix.wireFine, GAMaterials.Ultima, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(1296),
                Materials.Lubricant.getFluid(2000))
                .outputs(MetaItems.ELECTRIC_MOTOR_UV.getStackForm()).duration(600).EUt(163840)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(),
                OreDictUnifier.get(OrePrefix.pipeMedium, GAMaterials.Enderium, 2),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 2),
                OreDictUnifier.get(OrePrefix.screw, Materials.HSSG, 8),
                OreDictUnifier.get(OrePrefix.ring, Materials.SiliconeRubber, 4),
                OreDictUnifier.get(OrePrefix.rotor, Materials.HSSG, 2),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(144),
                Materials.Lubricant.getFluid(250))
                .outputs(MetaItems.ELECTRIC_PUMP_LUV.getStackForm()).duration(600).EUt(15360)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(),
                OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Naquadah, 2),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSE, 2),
                OreDictUnifier.get(OrePrefix.screw, Materials.HSSE, 8),
                OreDictUnifier.get(OrePrefix.ring, Materials.SiliconeRubber, 16),
                OreDictUnifier.get(OrePrefix.rotor, Materials.HSSE, 2),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(288),
                Materials.Lubricant.getFluid(750))
                .outputs(MetaItems.ELECTRIC_PUMP_ZPM.getStackForm()).duration(600).EUt(61440)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_UV.getStackForm(),
                OreDictUnifier.get(OrePrefix.pipeMedium, GAMaterials.Neutronium, 2),
                OreDictUnifier.get(OrePrefix.plate, GAMaterials.Neutronium, 2),
                OreDictUnifier.get(OrePrefix.screw, GAMaterials.Neutronium, 8),
                OreDictUnifier.get(OrePrefix.ring, Materials.SiliconeRubber, 16),
                OreDictUnifier.get(OrePrefix.rotor, GAMaterials.Neutronium, 2),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(1296),
                Materials.Lubricant.getFluid(2000))
                .outputs(MetaItems.ELECTRIC_PUMP_UV.getStackForm()).duration(600).EUt(245760)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(2),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 2),
                OreDictUnifier.get(OrePrefix.ring, Materials.HSSG, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSG, 32),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 2))
                .notConsumable(new IntCircuitIngredient(1)).fluidInputs(
                Materials.StyreneButadieneRubber.getFluid(1440),
                Materials.Lubricant.getFluid(250))
                .outputs(MetaItems.CONVEYOR_MODULE_LUV.getStackForm()).duration(600).EUt(15360)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(2),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSE, 2),
                OreDictUnifier.get(OrePrefix.ring, Materials.HSSE, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSE, 32),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 2))
                .notConsumable(new IntCircuitIngredient(1)).fluidInputs(
                Materials.StyreneButadieneRubber.getFluid(2880),
                Materials.Lubricant.getFluid(750))
                .outputs(MetaItems.CONVEYOR_MODULE_ZPM.getStackForm()).duration(600).EUt(61440)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_UV.getStackForm(2),
                OreDictUnifier.get(OrePrefix.plate, GAMaterials.Neutronium, 2),
                OreDictUnifier.get(OrePrefix.ring, GAMaterials.Neutronium, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), GAMaterials.Neutronium, 32),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 2))
                .notConsumable(new IntCircuitIngredient(1)).fluidInputs(
                Materials.StyreneButadieneRubber.getFluid(2880),
                Materials.Lubricant.getFluid(2000))
                .outputs(MetaItems.CONVEYOR_MODULE_UV.getStackForm()).duration(600).EUt(245760)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 6),
                OreDictUnifier.get(OrePrefix.ring, Materials.HSSG, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSG, 32),
                OreDictUnifier.get(OrePrefix.stick, Materials.HSSG, 4),
                OreDictUnifier.get(OrePrefix.gear, Materials.HSSG, 1),
                OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSG, 2),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 4))
                .notConsumable(new IntCircuitIngredient(2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(144),
                Materials.Lubricant.getFluid(250))
                .outputs(MetaItems.ELECTRIC_PISTON_LUV.getStackForm()).duration(600).EUt(15360)
                .buildAndRegister();


        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSE, 6),
                OreDictUnifier.get(OrePrefix.ring, Materials.HSSE, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSE, 32),
                OreDictUnifier.get(OrePrefix.stick, Materials.HSSE, 4),
                OreDictUnifier.get(OrePrefix.gear, Materials.HSSE, 1),
                OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSE, 2),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 4))
                .notConsumable(new IntCircuitIngredient(2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(288),
                Materials.Lubricant.getFluid(750))
                .outputs(MetaItems.ELECTRIC_PISTON_ZPM.getStackForm()).duration(600).EUt(61440)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaItems.ELECTRIC_MOTOR_UV.getStackForm(),
                OreDictUnifier.get(OrePrefix.plate, GAMaterials.Neutronium, 6),
                OreDictUnifier.get(OrePrefix.ring, GAMaterials.Neutronium, 4),
                OreDictUnifier.get(OrePrefix.valueOf("round"), GAMaterials.Neutronium, 32),
                OreDictUnifier.get(OrePrefix.stick, GAMaterials.Neutronium, 4),
                OreDictUnifier.get(OrePrefix.gear, GAMaterials.Neutronium, 1),
                OreDictUnifier.get(OrePrefix.gearSmall, GAMaterials.Neutronium, 2),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 4))
                .notConsumable(new IntCircuitIngredient(2)).fluidInputs(
                Materials.SolderingAlloy.getFluid(1296),
                Materials.Lubricant.getFluid(2000))
                .outputs(MetaItems.ELECTRIC_PISTON_UV.getStackForm()).duration(600).EUt(245760)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSG, 4),
                OreDictUnifier.get(OrePrefix.gear, Materials.HSSG, 1),
                OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSG, 3),
                MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(2),
                MetaItems.ELECTRIC_PISTON_LUV.getStackForm(),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 6))
                .input(OrePrefix.circuit, Tier.Master, 2)
                .input(OrePrefix.circuit, Tier.Elite, 2)
                .input(OrePrefix.circuit, Tier.Extreme, 6).fluidInputs(
                Materials.SolderingAlloy.getFluid(576),
                Materials.Lubricant.getFluid(250))
                .outputs(MetaItems.ROBOT_ARM_LUV.getStackForm()).duration(600).EUt(20480)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSE, 4),
                OreDictUnifier.get(OrePrefix.gear, Materials.HSSE, 1),
                OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSE, 3),
                MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(2),
                MetaItems.ELECTRIC_PISTON_ZPM.getStackForm(),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 6))
                .input(OrePrefix.circuit, Tier.Master, 4)
                .input(OrePrefix.circuit, Tier.Elite, 4)
                .input(OrePrefix.circuit, Tier.Extreme, 12).fluidInputs(
                Materials.SolderingAlloy.getFluid(1152),
                Materials.Lubricant.getFluid(750))
                .outputs(MetaItems.ROBOT_ARM_ZPM.getStackForm()).duration(600).EUt(81920)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.stickLong, GAMaterials.Neutronium, 4),
                OreDictUnifier.get(OrePrefix.gear, GAMaterials.Neutronium, 1),
                OreDictUnifier.get(OrePrefix.gearSmall, GAMaterials.Neutronium, 3),
                MetaItems.ELECTRIC_MOTOR_UV.getStackForm(2),
                MetaItems.ELECTRIC_PISTON_UV.getStackForm(),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 6))
                .input(OrePrefix.circuit, Tier.Master, 8)
                .input(OrePrefix.circuit, Tier.Elite, 8)
                .input(OrePrefix.circuit, Tier.Extreme, 24).fluidInputs(
                Materials.SolderingAlloy.getFluid(2304),
                Materials.Lubricant.getFluid(2000))
                .outputs(MetaItems.ROBOT_ARM_UV.getStackForm()).duration(600).EUt(327680)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSG, 1),
                MetaItems.EMITTER_IV.getStackForm(),
                MetaItems.EMITTER_EV.getStackForm(2),
                MetaItems.EMITTER_HV.getStackForm(4),
                OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 7))
                .input(OrePrefix.circuit, Tier.Extreme, 7).fluidInputs(
                Materials.SolderingAlloy.getFluid(576))
                .outputs(MetaItems.EMITTER_LUV.getStackForm()).duration(600).EUt(15360)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSE, 1),
                MetaItems.EMITTER_LUV.getStackForm(),
                MetaItems.EMITTER_IV.getStackForm(2),
                MetaItems.EMITTER_EV.getStackForm(4),
                OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 7))
                .input(OrePrefix.circuit, Tier.Elite, 7).fluidInputs(
                Materials.SolderingAlloy.getFluid(576))
                .outputs(MetaItems.EMITTER_ZPM.getStackForm()).duration(600).EUt(61440)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, GAMaterials.Neutronium, 1),
                MetaItems.EMITTER_ZPM.getStackForm(),
                MetaItems.EMITTER_LUV.getStackForm(2),
                MetaItems.EMITTER_IV.getStackForm(4),
                OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 7))
                .input(OrePrefix.circuit, Tier.Master, 7).fluidInputs(
                Materials.SolderingAlloy.getFluid(576))
                .outputs(MetaItems.EMITTER_UV.getStackForm()).duration(600).EUt(245760)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSG, 1),
                MetaItems.SENSOR_IV.getStackForm(),
                MetaItems.SENSOR_EV.getStackForm(2),
                MetaItems.SENSOR_HV.getStackForm(4),
                OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 7))
                .input(OrePrefix.circuit, Tier.Extreme, 7).fluidInputs(
                Materials.SolderingAlloy.getFluid(576))
                .outputs(MetaItems.SENSOR_LUV.getStackForm()).duration(600).EUt(15360)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSE, 1),
                MetaItems.SENSOR_LUV.getStackForm(),
                MetaItems.SENSOR_IV.getStackForm(2),
                MetaItems.SENSOR_EV.getStackForm(4),
                OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 7))
                .input(OrePrefix.circuit, Tier.Elite, 7).fluidInputs(
                Materials.SolderingAlloy.getFluid(576))
                .outputs(MetaItems.SENSOR_ZPM.getStackForm()).duration(600).EUt(61440)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, GAMaterials.Neutronium, 1),
                MetaItems.SENSOR_ZPM.getStackForm(),
                MetaItems.SENSOR_LUV.getStackForm(2),
                MetaItems.SENSOR_IV.getStackForm(4),
                OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64),
                OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 7))
                .input(OrePrefix.circuit, Tier.Master, 7).fluidInputs(
                Materials.SolderingAlloy.getFluid(576))
                .outputs(MetaItems.SENSOR_UV.getStackForm()).duration(600).EUt(245760)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSG, 1),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 6),
                MetaItems.QUANTUM_STAR.getStackForm(),
                MetaItems.EMITTER_LUV.getStackForm(4),
                GAMetaItems.NEURO_PROCESSOR.getStackForm(8),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 8))
                .input(OrePrefix.circuit, Tier.Master, 8)
                .input(OrePrefix.circuit, Tier.Elite, 8).fluidInputs(
                Materials.SolderingAlloy.getFluid(576))
                .outputs(MetaItems.FIELD_GENERATOR_LUV.getStackForm()).duration(600).EUt(30720)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSE, 1),
                OreDictUnifier.get(OrePrefix.plate, Materials.HSSE, 6),
                MetaItems.QUANTUM_STAR.getStackForm(4),
                MetaItems.EMITTER_ZPM.getStackForm(4),
                MetaItems.CRYSTAL_PROCESSOR_IV.getStackForm(16),
                GAMetaItems.NEURO_PROCESSOR.getStackForm(16),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 8))
                .input(OrePrefix.circuit, Tier.Elite, 16).fluidInputs(
                Materials.SolderingAlloy.getFluid(1152))
                .outputs(MetaItems.FIELD_GENERATOR_ZPM.getStackForm()).duration(600).EUt(122880)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, GAMaterials.Neutronium, 1),
                OreDictUnifier.get(OrePrefix.plate, GAMaterials.Neutronium, 6),
                MetaItems.GRAVI_STAR.getStackForm(),
                MetaItems.EMITTER_UV.getStackForm(4),
                GAMetaItems.NEURO_PROCESSOR.getStackForm(64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64),
                OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 8)).fluidInputs(
                Materials.SolderingAlloy.getFluid(2304))
                .outputs(MetaItems.FIELD_GENERATOR_UV.getStackForm()).duration(600).EUt(491520)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                GAMetaItems.MASTER_BOARD.getStackForm(),
                GAMetaItems.STEMCELLS.getStackForm(8),
                MetaItems.GLASS_TUBE.getStackForm(8),
                OreDictUnifier.get(OrePrefix.foil, Materials.SiliconeRubber, 64))
                .input(OrePrefix.plate, Materials.Gold, 8)
                .input(OrePrefix.plate, Materials.StainlessSteel, 4).fluidInputs(
                GAMaterials.SterilizedGrowthMedium.getFluid(250),
                Materials.UUMatter.getFluid(100), Materials.Water.getFluid(250), Materials.Lava.getFluid(1000))
                .outputs(GAMetaItems.NEURO_PROCESSOR.getStackForm()).duration(200).EUt(80000)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                OreDictUnifier.get(OrePrefix.frameGt, Materials.Tritanium, 4),
                MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(4),
                MetaItems.SMALL_COIL.getStackForm(4),
                MetaItems.SMD_CAPACITOR.getStackForm(24),
                MetaItems.SMD_RESISTOR.getStackForm(64),
                MetaItems.SMD_TRANSISTOR.getStackForm(32),
                MetaItems.SMD_DIODE.getStackForm(16),
                MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.Ultima, 32),
                OreDictUnifier.get(OrePrefix.foil, Materials.SiliconeRubber, 64)).fluidInputs(
                Materials.SolderingAlloy.getFluid(2880), Materials.Water.getFluid(10000))
                .outputs(MetaItems.WETWARE_MAINFRAME_MAX.getStackForm()).duration(2000).EUt(300000)
                .buildAndRegister();

        ItemStack last_bat = (GAConfig.GT5U.replaceUVwithMAXBat ? GAMetaItems.MAX_BATTERY : MetaItems.ZPM2).getStackForm();

        if (GAConfig.GT5U.enableZPMandUVBats) {
            GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                    OreDictUnifier.get(OrePrefix.plate, Materials.Europium, 16),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm(8),
                    MetaItems.FIELD_GENERATOR_LUV.getStackForm(2),
                    MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(64),
                    MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(64),
                    MetaItems.SMD_DIODE.getStackForm(8),
                    OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Naquadah, 32)).fluidInputs(
                    Materials.SolderingAlloy.getFluid(2880),
                    Materials.Water.getFluid(8000))
                    .outputs(GAMetaItems.ENERGY_MODULE.getStackForm()).duration(2000).EUt(100000)
                    .buildAndRegister();

            GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                    OreDictUnifier.get(OrePrefix.plate, Materials.Americium, 16),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(),
                    GAMetaItems.ENERGY_MODULE.getStackForm(8),
                    MetaItems.FIELD_GENERATOR_ZPM.getStackForm(2),
                    MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64),
                    MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64),
                    MetaItems.SMD_DIODE.getStackForm(16),
                    OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.NaquadahAlloy, 32)).fluidInputs(
                    Materials.SolderingAlloy.getFluid(2880),
                    Materials.Water.getFluid(16000))
                    .outputs(GAMetaItems.ENERGY_CLUSTER.getStackForm()).duration(2000).EUt(200000)
                    .buildAndRegister();

            GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                    OreDictUnifier.get(OrePrefix.plate, GAMaterials.Neutronium, 16),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    GAMetaItems.ENERGY_CLUSTER.getStackForm(8),
                    MetaItems.FIELD_GENERATOR_UV.getStackForm(2),
                    MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64),
                    MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64),
                    MetaItems.SMD_DIODE.getStackForm(16),
                    OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 32)).fluidInputs(
                    Materials.SolderingAlloy.getFluid(2880),
                    Materials.Water.getFluid(16000),
                    Materials.Naquadria.getFluid(1152))
                    .outputs(last_bat).duration(2000).EUt(300000)
                    .buildAndRegister();
        } else
            GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                    OreDictUnifier.get(OrePrefix.plate, GAMaterials.Neutronium, 16),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                    MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm(8),
                    MetaItems.FIELD_GENERATOR_UV.getStackForm(2),
                    MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64),
                    MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64),
                    MetaItems.SMD_DIODE.getStackForm(16),
                    OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 32)).fluidInputs(
                    Materials.SolderingAlloy.getFluid(2880), Materials.Water.getFluid(16000))
                    .outputs(last_bat).duration(2000).EUt(300000)
                    .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL),
                OreDictUnifier.get(OrePrefix.plate, Materials.Plutonium241),
                OreDictUnifier.get(OrePrefix.plate, Materials.NetherStar),
                MetaItems.FIELD_GENERATOR_IV.getStackForm(2),
                MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(32),
                OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.ZPMSuperconductor, 32))
                .input(OrePrefix.circuit, Tier.Ultimate)
                .input(OrePrefix.circuit, Tier.Ultimate)
                .input(OrePrefix.circuit, Tier.Ultimate)
                .input(OrePrefix.circuit, Tier.Ultimate).fluidInputs(
                Materials.SolderingAlloy.getFluid(2880))
                .outputs(GATileEntities.FUSION_REACTOR[0].getStackForm()).duration(1000).EUt(30000)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL),
                OreDictUnifier.get(OrePrefix.plate, Materials.Europium, 4),
                MetaItems.FIELD_GENERATOR_LUV.getStackForm(2),
                MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(48),
                OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor, 32))
                .input(OrePrefix.circuit, Tier.Superconductor)
                .input(OrePrefix.circuit, Tier.Superconductor)
                .input(OrePrefix.circuit, Tier.Superconductor)
                .input(OrePrefix.circuit, Tier.Superconductor).fluidInputs(
                Materials.SolderingAlloy.getFluid(2880))
                .outputs(GATileEntities.FUSION_REACTOR[1].getStackForm()).duration(1000).EUt(60000)
                .buildAndRegister();

        GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(
                MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL),
                MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(),
                OreDictUnifier.get(OrePrefix.plate, Materials.Americium, 4),
                MetaItems.FIELD_GENERATOR_ZPM.getStackForm(2),
                MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64),
                OreDictUnifier.get(OrePrefix.wireGtQuadruple, Tier.Superconductor, 32)).fluidInputs(
                Materials.SolderingAlloy.getFluid(2880))
                .outputs(GATileEntities.FUSION_REACTOR[2].getStackForm()).duration(1000).EUt(90000)
                .buildAndRegister();

        //Star Recipes
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(12000).EUt(8).input(OrePrefix.ingot, Materials.Plutonium, 8).input(OrePrefix.dustTiny, Materials.Uranium).fluidInputs(Materials.Air.getFluid(1000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Plutonium, 8)).fluidOutputs(Materials.Radon.getFluid(100)).buildAndRegister();
        RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().duration(480).EUt(7680).inputs(new ItemStack(Items.NETHER_STAR)).fluidInputs(GAMaterials.Neutronium.getFluid(288)).outputs(MetaItems.GRAVI_STAR.getStackForm()).buildAndRegister();

        //Fusion Recipes
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Deuterium.getFluid(125), Materials.Tritium.getFluid(125)).fluidOutputs(Materials.Helium.getPlasma(125)).duration(16).EUt(4096).EUToStart(400000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Deuterium.getFluid(125), Materials.Helium3.getFluid(125)).fluidOutputs(Materials.Helium.getPlasma(125)).duration(16).EUt(2048).EUToStart(600000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Carbon.getFluid(125), Materials.Helium3.getFluid(125)).fluidOutputs(Materials.Oxygen.getPlasma(125)).duration(32).EUt(4096).EUToStart(800000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Beryllium.getFluid(16), Materials.Deuterium.getFluid(375)).fluidOutputs(Materials.Nitrogen.getPlasma(175)).duration(16).EUt(16384).EUToStart(1800000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Silicon.getFluid(16), Materials.Magnesium.getFluid(16)).fluidOutputs(Materials.Iron.getPlasma(125)).duration(32).EUt(8192).EUToStart(3600000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Potassium.getFluid(16), Materials.Fluorine.getFluid(125)).fluidOutputs(Materials.Nickel.getPlasma(125)).duration(16).EUt(32768).EUToStart(4800000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Beryllium.getFluid(16), Materials.Tungsten.getFluid(16)).fluidOutputs(Materials.Platinum.getFluid(16)).duration(32).EUt(32768).EUToStart(1500000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Neodymium.getFluid(16), Materials.Hydrogen.getFluid(48)).fluidOutputs(Materials.Europium.getFluid(16)).duration(64).EUt(24576).EUToStart(1500000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Lutetium.getFluid(16), Materials.Chrome.getFluid(16)).fluidOutputs(Materials.Americium.getFluid(16)).duration(96).EUt(49152).EUToStart(2000000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Plutonium.getFluid(16), Materials.Thorium.getFluid(16)).fluidOutputs(Materials.Naquadah.getFluid(16)).duration(64).EUt(32768).EUToStart(3000000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Americium.getFluid(16), Materials.Naquadria.getFluid(16)).fluidOutputs(GAMaterials.Neutronium.getFluid(2)).duration(200).EUt(98304).EUToStart(6000000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Tungsten.getFluid(16), Materials.Helium.getFluid(16)).fluidOutputs(Materials.Osmium.getFluid(16)).duration(64).EUt(24578).EUToStart(1500000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Manganese.getFluid(16), Materials.Hydrogen.getFluid(16)).fluidOutputs(Materials.Iron.getFluid(16)).duration(64).EUt(8192).EUToStart(1200000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Mercury.getFluid(16), Materials.Magnesium.getFluid(16)).fluidOutputs(Materials.Uranium.getFluid(16)).duration(64).EUt(49152).EUToStart(2400000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Gold.getFluid(16), Materials.Aluminium.getFluid(16)).fluidOutputs(Materials.Uranium.getFluid(16)).duration(64).EUt(49152).EUToStart(2400000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Uranium.getFluid(16), Materials.Helium.getFluid(16)).fluidOutputs(Materials.Plutonium.getFluid(16)).duration(128).EUt(49152).EUToStart(4800000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Vanadium.getFluid(16), Materials.Hydrogen.getFluid(125)).fluidOutputs(Materials.Chrome.getFluid(16)).duration(64).EUt(24576).EUToStart(1400000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Gallium.getFluid(16), Materials.Radon.getFluid(125)).fluidOutputs(Materials.Duranium.getFluid(16)).duration(64).EUt(16384).EUToStart(1400000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Titanium.getFluid(48), Materials.Duranium.getFluid(32)).fluidOutputs(Materials.Tritanium.getFluid(16)).duration(64).EUt(32768).EUToStart(2000000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Gold.getFluid(16), Materials.Mercury.getFluid(16)).fluidOutputs(Materials.Radon.getFluid(125)).duration(64).EUt(32768).EUToStart(2000000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Tantalum.getFluid(16), Materials.Tritium.getFluid(16)).fluidOutputs(Materials.Tungsten.getFluid(16)).duration(16).EUt(24576).EUToStart(2000000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Silver.getFluid(16), Materials.Lithium.getFluid(16)).fluidOutputs(Materials.Indium.getFluid(16)).duration(32).EUt(24576).EUToStart(3800000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.NaquadahEnriched.getFluid(15), Materials.Radon.getFluid(125)).fluidOutputs(Materials.Naquadria.getFluid(3)).duration(64).EUt(49152).EUToStart(4000000).buildAndRegister();
        RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Lithium.getFluid(16), Materials.Tungsten.getFluid(16)).fluidOutputs(Materials.Iridium.getFluid(16)).duration(32).EUt(32768).EUToStart(3000000).buildAndRegister();

        //FUsion Casing Recipes
        ModHandler.addShapedRecipe("fusion_casing_1", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING.FUSION_CASING), "PhP", "PHP", "PwP", 'P', "plateTungstenSteel", 'H', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV));
        ModHandler.addShapedRecipe("fusion_casing_2", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING.FUSION_CASING_MK2), "PhP", "PHP", "PwP", 'P', "plateAmericium", 'H', MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING.FUSION_CASING));
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().EUt(16).inputs(MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING.FUSION_CASING)).input(OrePrefix.plate, Materials.Americium, 6).outputs(MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING.FUSION_CASING_MK2)).duration(50).buildAndRegister();

        ModHandler.addShapedRecipe("fusion_coil", MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL), "CRC", "FSF", "CRC", 'C', "circuitMaster", 'R', MetaItems.NEUTRON_REFLECTOR.getStackForm(), 'F', MetaItems.FIELD_GENERATOR_MV.getStackForm(), 'S', MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.SUPERCONDUCTOR));

        //Explosive Recipes
        ModHandler.removeRecipes(new ItemStack(Blocks.TNT));
        ModHandler.removeRecipes(MetaItems.DYNAMITE.getStackForm());
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.PAPER), new ItemStack(Items.STRING)).fluidInputs(Materials.Glyceryl.getFluid(500)).outputs(MetaItems.DYNAMITE.getStackForm()).buildAndRegister();

        //Electromagnetic Separator Recipes
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.BrownLimonite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.BrownLimonite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.YellowLimonite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.YellowLimonite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Nickel).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Nickel)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Pentlandite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Pentlandite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.BandedIron).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.BandedIron)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Ilmenite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Ilmenite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Pyrite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Pyrite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Tin).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Tin)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Chromite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Chromite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Monazite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Monazite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Neodymium), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Neodymium), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Bastnasite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Bastnasite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Neodymium), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Neodymium), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.VanadiumMagnetite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.VanadiumMagnetite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Gold), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Gold), 2000).buildAndRegister();
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Magnetite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Magnetite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Gold), 4000).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Gold), 2000).buildAndRegister();

        //Lapotron Crystal Recipes
        ModHandler.removeRecipes(MetaItems.LAPOTRON_CRYSTAL.getStackForm());
        for (MaterialStack m : lapisLike) {
            GemMaterial gem = (GemMaterial) m.material;
            ModHandler.addShapedRecipe("lapotron_crystal_shaped" + gem.toString(), MetaItems.LAPOTRON_CRYSTAL.getStackForm(), "PCP", "RFR", "PCP", 'P', new UnificationEntry(OrePrefix.plate, gem), 'C', "circuitAdvanced", 'R', OreDictUnifier.get(OrePrefix.stick, gem), 'F', OreDictUnifier.get(OrePrefix.gemFlawless, Materials.Sapphire));
            ModHandler.addShapedRecipe("lapotron_crystal_shaped_with_crystal" + gem.toString(), MetaItems.LAPOTRON_CRYSTAL.getStackForm(), "PCP", "RFR", "PCP", 'P', new UnificationEntry(OrePrefix.plate, gem), 'C', "circuitExtreme", 'R', OreDictUnifier.get(OrePrefix.stick, gem), 'F', MetaItems.ENERGY_CRYSTAL.getStackForm());
            ModHandler.addShapelessRecipe("lapotron_crystal_shapeless" + gem.toString(), MetaItems.LAPOTRON_CRYSTAL.getStackForm(), OreDictUnifier.get(OrePrefix.gemExquisite, Materials.Sapphire), OreDictUnifier.get(OrePrefix.stick, gem), MetaItems.CAPACITOR.getStackForm());
        }

        //Configuration Circuit
        ModHandler.removeRecipes(MetaItems.BASIC_ELECTRONIC_CIRCUIT_LV.getStackForm());
        ModHandler.removeRecipes(MetaItems.INTEGRATED_CIRCUIT.getStackForm());
        ModHandler.addShapelessRecipe("basic_to_configurable_circuit", MetaItems.INTEGRATED_CIRCUIT.getStackForm(), "circuitBasic");

        //MAX Machine Hull
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_max"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:hull_max"));
        ModHandler.addShapedRecipe("ga_casing_max", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, GAMaterials.Neutronium));
        ModHandler.addShapedRecipe("ga_hull_max", MetaTileEntities.HULL[GTValues.MAX].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX), 'C', new UnificationEntry(OrePrefix.wireGtSingle, Tier.Superconductor), 'H', new UnificationEntry(OrePrefix.plate, GAMaterials.Neutronium), 'P', new UnificationEntry(OrePrefix.plate, Materials.Polytetrafluoroethylene));
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(16).input(OrePrefix.plate, GAMaterials.Neutronium, 8).outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX)).circuitMeta(8).duration(50).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(16).inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX)).input(OrePrefix.wireGtSingle, Tier.Superconductor, 2).fluidInputs(Materials.Polytetrafluoroethylene.getFluid(288)).outputs(MetaTileEntities.HULL[9].getStackForm()).buildAndRegister();

        //Redstone and glowstone melting
        RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(80).EUt(32).input(OrePrefix.dust, Materials.Redstone).fluidOutputs(Materials.Redstone.getFluid(144)).buildAndRegister();
        RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(80).EUt(32).input(OrePrefix.dust, Materials.Glowstone).fluidOutputs(Materials.Glowstone.getFluid(144)).buildAndRegister();

        //Gem Tool Part Fixes
        for (Material material : GemMaterial.MATERIAL_REGISTRY) {
            if (!OreDictUnifier.get(OrePrefix.gem, material).isEmpty() && !OreDictUnifier.get(OrePrefix.toolHeadHammer, material).isEmpty() && material != Materials.Flint) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadAxe, material));
                ModHandler.addShapedRecipe("axe_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadAxe, material), "GG", "Gf", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadFile, material));
                ModHandler.addShapedRecipe("file_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadFile, material), "G", "G", "f", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadHammer, material));
                ModHandler.addShapedRecipe("hammer_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadHammer, material), "GG ", "GGf", "GG ", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadHoe, material));
                ModHandler.addShapedRecipe("hoe_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadHoe, material), "GGf", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadPickaxe, material));
                ModHandler.addShapedRecipe("pickaxe_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadPickaxe, material), "GGG", "f  ", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadPlow, material));
                ModHandler.addShapedRecipe("flow_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadPlow, material), "GG", "GG", " f", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadSaw, material));
                ModHandler.addShapedRecipe("saw_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadSaw, material), "GG", "f ", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadSense, material));
                ModHandler.addShapedRecipe("sense_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadSense, material), "GGG", " f ", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadShovel, material));
                ModHandler.addShapedRecipe("shovel_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadShovel, material), "fG", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadSword, material));
                ModHandler.addShapedRecipe("sword_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadSword, material), " G", "fG", 'G', new UnificationEntry(OrePrefix.gem, material));
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.toolHeadUniversalSpade, material));
                ModHandler.addShapedRecipe("universal_spade_head_" + material.toString(), OreDictUnifier.get(OrePrefix.toolHeadUniversalSpade, material), "GGG", "GfG", " G ", 'G', new UnificationEntry(OrePrefix.gem, material));
            }
        }

        //Misc Recipe Patches
        RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).input(OrePrefix.dust, Materials.NetherQuartz).outputs(OreDictUnifier.get(OrePrefix.plate, Materials.NetherQuartz)).buildAndRegister();
        RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).input(OrePrefix.dust, Materials.CertusQuartz).outputs(OreDictUnifier.get(OrePrefix.plate, Materials.CertusQuartz)).buildAndRegister();

        //Dust Uncrafting Fixes
        for (Material m : DustMaterial.MATERIAL_REGISTRY) {
            if (!OreDictUnifier.get(OrePrefix.dustSmall, m).isEmpty()) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.dustSmall, m));
                ModHandler.addShapedRecipe("dust_small_" + m.toString(), OreDictUnifier.get(OrePrefix.dustSmall, m, 4), " D", "  ", 'D', new UnificationEntry(OrePrefix.dust, m));
            }
        }

        //Change Solar Panel recipes
        ModHandler.removeRecipes(MetaItems.COVER_SOLAR_PANEL.getStackForm());
        ModHandler.addShapedRecipe("basic_solar_panel", MetaItems.COVER_SOLAR_PANEL.getStackForm(), "PGP", "WCW", "AAA", 'P', "plateSilicon", 'C', "circuitBasic", 'G', "paneGlass", 'W', "cableGtSingleCopper", 'A', "plateAluminium");
        ModHandler.removeRecipes(MetaItems.COVER_SOLAR_PANEL_ULV.getStackForm());
        ModHandler.addShapedRecipe("ulv_solar_panel", MetaItems.COVER_SOLAR_PANEL_ULV.getStackForm(), "SSS", "SCS", "SSS", 'C', "circuitBasic", 'S', MetaItems.COVER_SOLAR_PANEL);
        ModHandler.removeRecipes(MetaItems.COVER_SOLAR_PANEL_LV.getStackForm());
        ModHandler.addShapedRecipe("lv_solar_panel", MetaItems.COVER_SOLAR_PANEL_LV.getStackForm(), "SSS", "SCS", "SSS", 'C', "circuitGood", 'S', MetaItems.COVER_SOLAR_PANEL_ULV);

        //Improved Superconductor recipes
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(1200).EUt(120).input(OrePrefix.dust, Materials.Cadmium, 5).input(OrePrefix.dust, Materials.Magnesium).fluidInputs(Materials.Oxygen.getFluid(6000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.MVSuperconductorBase, 12)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(2400).EUt(120).input(OrePrefix.dust, Materials.Titanium).input(OrePrefix.dust, Materials.Barium, 9).input(OrePrefix.dust, Materials.Copper, 10).fluidInputs(Materials.Oxygen.getFluid(20000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.HVSuperconductorBase, 40)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(400).EUt(480).input(OrePrefix.dust, Materials.Uranium).input(OrePrefix.dust, Materials.Platinum, 3).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.EVSuperconductorBase, 4)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(400).EUt(480).input(OrePrefix.dust, Materials.Vanadium).input(OrePrefix.dust, Materials.Indium, 3).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.IVSuperconductorBase, 4)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(2400).EUt(1920).input(OrePrefix.dust, Materials.Indium, 4).input(OrePrefix.dust, Materials.Bronze, 8).input(OrePrefix.dust, Materials.Barium, 2).input(OrePrefix.dust, Materials.Titanium).fluidInputs(Materials.Oxygen.getFluid(14000)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.LuVSuperconductorBase, 29)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(1200).EUt(1920).input(OrePrefix.dust, Materials.Naquadah, 4).input(OrePrefix.dust, Materials.Indium, 2).input(OrePrefix.dust, Materials.Palladium, 6).input(OrePrefix.dust, Materials.Osmium).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.ZPMSuperconductorBase, 13)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(400).EUt(8).input(OrePrefix.dust, Materials.Lead, 3).input(OrePrefix.dust, Materials.Platinum).input(OrePrefix.dust, Materials.EnderPearl, 4).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.Enderium, 4)).buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(300).EUt(120).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.MVSuperconductorBase, 3), OreDictUnifier.get(OrePrefix.pipeTiny, Materials.StainlessSteel, 2), MetaItems.ELECTRIC_PUMP_MV.getStackForm(2)).fluidInputs(Materials.Nitrogen.getFluid(2000)).outputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.MVSuperconductor, 3)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(256).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.HVSuperconductorBase, 3), OreDictUnifier.get(OrePrefix.pipeTiny, Materials.Titanium, 2), MetaItems.ELECTRIC_PUMP_HV.getStackForm()).fluidInputs(Materials.Nitrogen.getFluid(2000)).outputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.HVSuperconductor, 3)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(500).EUt(480).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.EVSuperconductorBase, 9), OreDictUnifier.get(OrePrefix.pipeTiny, Materials.TungstenSteel, 6), MetaItems.ELECTRIC_PUMP_EV.getStackForm(2)).fluidInputs(Materials.Nitrogen.getFluid(6000)).outputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.EVSuperconductor, 9)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(300).EUt(1920).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.IVSuperconductorBase, 6), OreDictUnifier.get(OrePrefix.pipeTiny, Materials.NiobiumTitanium, 4), MetaItems.ELECTRIC_PUMP_IV.getStackForm()).fluidInputs(Materials.Nitrogen.getFluid(4000)).outputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.IVSuperconductor, 6)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(350).EUt(7680).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.LuVSuperconductorBase, 8), OreDictUnifier.get(OrePrefix.pipeTiny, GAMaterials.Enderium, 5), MetaItems.ELECTRIC_PUMP_LUV.getStackForm()).fluidInputs(Materials.Nitrogen.getFluid(6000)).outputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.LuVSuperconductor, 8)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(30720).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.ZPMSuperconductorBase, 16), OreDictUnifier.get(OrePrefix.pipeTiny, Materials.Naquadah, 6), MetaItems.ELECTRIC_PUMP_ZPM.getStackForm()).fluidInputs(Materials.Nitrogen.getFluid(8000)).outputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.ZPMSuperconductor, 16)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(500).EUt(122880).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, GAMaterials.ZPMSuperconductor, 32), OreDictUnifier.get(OrePrefix.pipeTiny, GAMaterials.Neutronium, 7), MetaItems.ELECTRIC_PUMP_ZPM.getStackForm()).fluidInputs(Materials.Nitrogen.getFluid(10000)).outputs(OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 32)).buildAndRegister();

        //GTNH Coils
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(400).EUt(8).input(OrePrefix.dust, Materials.Mica, 3).input(OrePrefix.dust, Materials.RawRubber, 2).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.MicaPulp, 4)).buildAndRegister();
        RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(400).EUt(8).input(OrePrefix.dust, Materials.Mica, 3).inputs(MetaItems.RUBBER_DROP.getStackForm()).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.MicaPulp, 4)).buildAndRegister();

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(1200).EUt(30).input(OrePrefix.dust, Materials.Sapphire).input(OrePrefix.dust, Materials.SiliconDioxide).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.AluminoSilicateWool, 2)).buildAndRegister();
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(1200).EUt(30).input(OrePrefix.dust, Materials.GreenSapphire).input(OrePrefix.dust, Materials.SiliconDioxide).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.AluminoSilicateWool, 2)).buildAndRegister();
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(1200).EUt(30).input(OrePrefix.dust, Materials.Ruby).input(OrePrefix.dust, Materials.SiliconDioxide).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.AluminoSilicateWool, 2)).buildAndRegister();

        RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(400).EUt(28).input(OrePrefix.dust, GAMaterials.MicaPulp, 4).input(OrePrefix.dust, Materials.Asbestos).outputs(GAMetaItems.MICA_SHHET.getStackForm(4)).buildAndRegister();

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(30).inputs(GAMetaItems.MICA_SHHET.getStackForm(4)).input(OrePrefix.dust, Materials.SiliconDioxide).outputs(GAMetaItems.MICA_INSULATOR_SHHET.getStackForm(4)).buildAndRegister();
        if (GAConfig.GT6.BendingFoilsAutomatic && GAConfig.GT6.BendingCylinders)
            GARecipeMaps.CLUSTER_MILL_RECIPES.recipeBuilder().duration(100).EUt(30).inputs(GAMetaItems.MICA_INSULATOR_SHHET.getStackForm()).outputs(GAMetaItems.MICA_INSULATOR_FOI.getStackForm(4)).buildAndRegister();
        else if (!GAConfig.GT6.BendingFoilsAutomatic || !GAConfig.GT6.BendingCylinders)
            RecipeMaps.BENDER_RECIPES.recipeBuilder().duration(100).EUt(30).inputs(GAMetaItems.MICA_INSULATOR_SHHET.getStackForm()).circuitMeta(1).outputs(GAMetaItems.MICA_INSULATOR_FOI.getStackForm(4)).buildAndRegister();

        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:heating_coil_cupronickel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:heating_coil_kanthal"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:heating_coil_nichrome"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:heating_coil_tungstensteel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:heating_coil_hss_g"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:heating_coil_naquadah"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:heating_coil_naquadah_alloy"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_cupronickel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_kanthal"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_nichrome"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_tungstensteel"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_hss_g"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_naquadah"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_naquadah_alloy"));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:wire_coil_superconductor"));

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.Cupronickel, 8), OreDictUnifier.get(OrePrefix.dust, GAMaterials.AluminoSilicateWool, 12)).fluidInputs(Materials.Tin.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.CUPRONICKEL)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(8).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.Cupronickel, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.Tin.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.CUPRONICKEL)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(300).EUt(30).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.Kanthal, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.Copper.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.KANTHAL)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(120).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.Nichrome, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.Aluminium.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.NICHROME)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(500).EUt(480).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.TungstenSteel, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.Nichrome.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.TUNGSTENSTEEL)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(1920).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.HSSG, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.Tungsten.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.HSS_G)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(700).EUt(4096).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.Naquadah, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.HSSG.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.NAQUADAH)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(800).EUt(7680).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.NaquadahAlloy, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.Naquadah.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.NAQUADAH_ALLOY)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(1000).EUt(9001).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor, 8), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(8)).fluidInputs(Materials.NaquadahAlloy.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.SUPERCONDUCTOR)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(1000).EUt(9001).inputs(OreDictUnifier.get(OrePrefix.wireGtDouble, GAMaterials.ZPMSuperconductor, 32), GAMetaItems.MICA_INSULATOR_FOI.getStackForm(16)).fluidInputs(Materials.NaquadahAlloy.getFluid(144)).outputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.SUPERCONDUCTOR)).buildAndRegister();
    }

    public static void forestrySupport() {
        if (Loader.isModLoaded("forestry") && GAConfig.GT6.electrodes) {
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_APATITE.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.APATITE, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Apatite, 2).input(OrePrefix.bolt, Materials.Apatite).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_APATITE.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Apatite, 4).input(OrePrefix.bolt, Materials.Apatite, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_APATITE.getStackForm(2)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_BLAZE.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.BLAZE, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.dust, Materials.Blaze, 2).input(OrePrefix.dustSmall, Materials.Blaze, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_BLAZE.getStackForm(2)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dust, Materials.Blaze, 5).input(OrePrefix.dust, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_BLAZE.getStackForm(4)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_BRONZE.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.BRONZE, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Bronze, 2).input(OrePrefix.bolt, Materials.Bronze).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_BRONZE.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Bronze, 4).input(OrePrefix.bolt, Materials.Bronze, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_BRONZE.getStackForm(2)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_COPPER.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.COPPER, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Copper, 2).input(OrePrefix.bolt, Materials.Copper).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_COPPER.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Copper, 4).input(OrePrefix.bolt, Materials.Copper, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_COPPER.getStackForm(2)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_DIAMOND.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.DIAMOND, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Diamond, 2).input(OrePrefix.bolt, Materials.Diamond).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_DIAMOND.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Diamond, 4).input(OrePrefix.bolt, Materials.Diamond, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_DIAMOND.getStackForm(2)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_EMERALD.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.EMERALD, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Emerald, 2).input(OrePrefix.bolt, Materials.Emerald).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_EMERALD.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Emerald, 4).input(OrePrefix.bolt, Materials.Emerald, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_EMERALD.getStackForm(2)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_ENDER.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.ENDER, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.dust, Materials.Endstone, 2).input(OrePrefix.dustSmall, Materials.Endstone, 2).input(OrePrefix.dust, Materials.EnderEye).outputs(GAMetaItems.ELECTRODE_ENDER.getStackForm(2)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dust, Materials.Endstone, 5).input(OrePrefix.dust, Materials.EnderEye, 2).outputs(GAMetaItems.ELECTRODE_ENDER.getStackForm(4)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_GOLD.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.GOLD, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Gold, 2).input(OrePrefix.bolt, Materials.Gold).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_GOLD.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Gold, 4).input(OrePrefix.bolt, Materials.Gold, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_GOLD.getStackForm(2)).buildAndRegister();
            if (Loader.isModLoaded("ic2") || Loader.isModLoaded("binniecore")) {
                RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_IRON.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.IRON, 1)).buildAndRegister();
                RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Iron, 2).input(OrePrefix.bolt, Materials.Iron).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_IRON.getStackForm()).buildAndRegister();
                RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Iron, 4).input(OrePrefix.bolt, Materials.Iron, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_IRON.getStackForm(2)).buildAndRegister();
            }
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_LAPIS.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.LAPIS, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Lapis, 2).input(OrePrefix.bolt, Materials.Lapis).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_LAPIS.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Lapis, 4).input(OrePrefix.bolt, Materials.Lapis, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_LAPIS.getStackForm(2)).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_OBSIDIAN.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.OBSIDIAN, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.dust, Materials.Obsidian, 2).input(OrePrefix.dustSmall, Materials.Obsidian, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_OBSIDIAN.getStackForm(2)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dust, Materials.Obsidian, 5).input(OrePrefix.dust, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_OBSIDIAN.getStackForm(4)).buildAndRegister();
            if (Loader.isModLoaded("extrautils2")) {
                RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_ORCHID.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.ORCHID, 1)).buildAndRegister();
                RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(400).EUt(24).inputs(new ItemStack(Blocks.REDSTONE_ORE, 5), OreDictUnifier.get(OrePrefix.dust, Materials.Redstone)).outputs(GAMetaItems.ELECTRODE_ORCHID.getStackForm(4)).buildAndRegister();
            }
            if (Loader.isModLoaded("ic2") || Loader.isModLoaded("techreborn")) {
                RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_RUBBER.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.RUBBER, 1)).buildAndRegister();
                RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Rubber, 2).input(OrePrefix.bolt, Materials.Rubber).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_RUBBER.getStackForm()).buildAndRegister();
                RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Rubber, 4).input(OrePrefix.bolt, Materials.Rubber, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_RUBBER.getStackForm(2)).buildAndRegister();
            }
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(150).EUt(16).inputs(GAMetaItems.ELECTRODE_TIN.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Glass)).outputs(ModuleCore.getItems().tubes.get(EnumElectronTube.TIN, 1)).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(100).EUt(24).input(OrePrefix.stick, Materials.Tin, 2).input(OrePrefix.bolt, Materials.Tin).input(OrePrefix.dustSmall, Materials.Redstone, 2).outputs(GAMetaItems.ELECTRODE_TIN.getStackForm()).buildAndRegister();
            RecipeMaps.FORMING_PRESS_RECIPES.recipeBuilder().duration(200).EUt(24).input(OrePrefix.stick, Materials.Tin, 4).input(OrePrefix.bolt, Materials.Tin, 2).input(OrePrefix.dust, Materials.Redstone).outputs(GAMetaItems.ELECTRODE_TIN.getStackForm(2)).buildAndRegister();
        }
    }

    public static void generatedRecipes() {
        //Tinker's Support
        if (Loader.isModLoaded("tconstruct") && GAConfig.Misc.TiCIntegration) {
            ModHandler.removeFurnaceSmelting(TinkerCommons.grout);
            ModHandler.addShapelessRecipe("seared_brick", GAMetaItems.COMPRESSED_GROUT.getStackForm(), TinkerCommons.grout, MetaItems.WOODEN_FORM_BRICK);
            ModHandler.addShapedRecipe("eight_seared_brick", GAMetaItems.COMPRESSED_GROUT.getStackForm(8), "BBB", "BFB", "BBB", 'B', TinkerCommons.grout, 'F', MetaItems.WOODEN_FORM_BRICK);
            ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_GROUT.getStackForm(), TinkerCommons.searedBrick);
            RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(200).EUt(2).inputs(TinkerCommons.grout).notConsumable(MetaItems.SHAPE_MOLD_INGOT.getStackForm()).outputs(TinkerCommons.searedBrick).buildAndRegister();
        }

        List<ResourceLocation> recipesToRemove = new ArrayList<>();

        for (IRecipe recipe : CraftingManager.REGISTRY) {
            if (recipe.getIngredients().size() == 9) {
                if (recipe.getIngredients().get(0).getMatchingStacks().length > 0 && Block.getBlockFromItem(recipe.getRecipeOutput().getItem()) != Blocks.AIR) {
                    boolean match = true;
                    for (int i = 1; i < recipe.getIngredients().size(); i++) {
                        if (recipe.getIngredients().get(i).getMatchingStacks().length == 0 || !recipe.getIngredients().get(0).getMatchingStacks()[0].isItemEqual(recipe.getIngredients().get(i).getMatchingStacks()[0])) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        if (GAConfig.GT5U.Remove3x3BlockRecipes)
                            recipesToRemove.add(recipe.getRegistryName());
                        if (GAConfig.GT5U.GenerateCompressorRecipes)
                            RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).inputs(CountableIngredient.from(recipe.getIngredients().get(0).getMatchingStacks()[0], recipe.getIngredients().size())).outputs(recipe.getRecipeOutput()).buildAndRegister();
                    }
                }
            }
            if (recipe.getIngredients().size() == 9) {
                if (recipe.getIngredients().get(0).getMatchingStacks().length > 0 && Block.getBlockFromItem(recipe.getRecipeOutput().getItem()) == Blocks.AIR) {
                    boolean match = true;
                    for (int i = 1; i < recipe.getIngredients().size(); i++) {
                        if (recipe.getIngredients().get(i).getMatchingStacks().length == 0 || !recipe.getIngredients().get(0).getMatchingStacks()[0].isItemEqual(recipe.getIngredients().get(i).getMatchingStacks()[0])) {
                            match = false;
                            break;
                        }
                    }
                    if (match && !recipesToRemove.contains(recipe.getRegistryName()) && !GAMetaItems.hasPrefix(recipe.getRecipeOutput(), "dust", "dustTiny") && recipe.getRecipeOutput().getCount() == 1 && GAConfig.Misc.Packager3x3Recipes) {
                        RecipeMaps.PACKER_RECIPES.recipeBuilder().duration(100).EUt(4).inputs(CountableIngredient.from(recipe.getIngredients().get(0).getMatchingStacks()[0], recipe.getIngredients().size())).notConsumable(new IntCircuitIngredient(3)).outputs(recipe.getRecipeOutput()).buildAndRegister();
                    }
                }
            }
            if (recipe.getIngredients().size() == 4) {
                if (recipe.getIngredients().get(0).getMatchingStacks().length > 0 && Block.getBlockFromItem(recipe.getRecipeOutput().getItem()) != Blocks.QUARTZ_BLOCK) {
                    boolean match = true;
                    for (int i = 1; i < recipe.getIngredients().size(); i++) {
                        if (recipe.getIngredients().get(i).getMatchingStacks().length == 0 || !recipe.getIngredients().get(0).getMatchingStacks()[0].isItemEqual(recipe.getIngredients().get(i).getMatchingStacks()[0])) {
                            match = false;
                            break;
                        }
                    }
                    if (match && !recipesToRemove.contains(recipe.getRegistryName()) && !GAMetaItems.hasPrefix(recipe.getRecipeOutput(), "dust", "dustSmall") && recipe.getRecipeOutput().getCount() == 1 && GAConfig.Misc.Packager2x2Recipes) {
                        RecipeMaps.PACKER_RECIPES.recipeBuilder().duration(100).EUt(4).inputs(CountableIngredient.from(recipe.getIngredients().get(0).getMatchingStacks()[0], recipe.getIngredients().size())).notConsumable(new IntCircuitIngredient(2)).outputs(recipe.getRecipeOutput()).buildAndRegister();
                    }
                }
            }
            if (recipe.getIngredients().size() == 1 && recipe.getIngredients().get(0).getMatchingStacks().length > 0 && recipe.getRecipeOutput().getCount() == 9 && Block.getBlockFromItem(recipe.getIngredients().get(0).getMatchingStacks()[0].getItem()) != Blocks.AIR && Block.getBlockFromItem(recipe.getIngredients().get(0).getMatchingStacks()[0].getItem()) != Blocks.SLIME_BLOCK) {
                boolean isIngot = false;
                for (int i : OreDictionary.getOreIDs(recipe.getRecipeOutput())) {
                    if (OreDictionary.getOreName(i).startsWith("ingot")) {
                        isIngot = true;
                        break;
                    }
                }
                if (GAConfig.GT5U.RemoveBlockUncraftingRecipes)
                    recipesToRemove.add(recipe.getRegistryName());
                if (!isIngot) {
                    RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().duration(100).EUt(24).inputs(recipe.getIngredients().get(0).getMatchingStacks()[0]).outputs(recipe.getRecipeOutput()).buildAndRegister();
                }
            }
            if (recipe.getIngredients().size() == 1 && recipe.getIngredients().get(0).getMatchingStacks().length > 0 && recipe.getRecipeOutput().getCount() == 9) {
                if (!recipesToRemove.contains(recipe.getRegistryName()) && GAConfig.Misc.Unpackager3x3Recipes) {
                    RecipeMaps.UNPACKER_RECIPES.recipeBuilder().duration(100).EUt(8).inputs(recipe.getIngredients().get(0).getMatchingStacks()[0]).outputs(recipe.getRecipeOutput()).buildAndRegister();
                }
            }
        }

        for (ResourceLocation r : recipesToRemove)
            ModHandler.removeRecipeByName(r);
        recipesToRemove.clear();

        if (GAConfig.GT5U.GenerateCompressorRecipes) {
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:glowstone"));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:block_compress_glowstone"));
            ModHandler.removeRecipeByName(new ResourceLocation("minecraft:quartz_block"));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:block_compress_nether_quartz"));
            ModHandler.removeRecipeByName(new ResourceLocation("gregtech:block_decompress_nether_quartz"));
            RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().duration(100).EUt(24).inputs(OreDictUnifier.get(OrePrefix.block, Materials.NetherQuartz)).outputs(OreDictUnifier.get(OrePrefix.gem, Materials.NetherQuartz, 4)).buildAndRegister();
        }

        //Generate Plank Recipes
        for (IRecipe recipe : CraftingManager.REGISTRY) {
            if (recipe.getRecipeOutput().isEmpty())
                continue;
            for (int i : OreDictionary.getOreIDs(recipe.getRecipeOutput())) {
                if (OreDictionary.getOreName(i).equals("plankWood") && recipe.getIngredients().size() == 1 && recipe.getRecipeOutput().getCount() == 4) {
                    if (GAConfig.GT5U.GeneratedSawingRecipes) {
                        ModHandler.removeRecipeByName(recipe.getRegistryName());
                        ModHandler.addShapelessRecipe("log_to_4_" + recipe.getRecipeOutput().toString(), GTUtility.copyAmount(4, recipe.getRecipeOutput()), recipe.getIngredients().get(0).getMatchingStacks()[0], ToolDictNames.craftingToolSaw);
                        ModHandler.addShapelessRecipe("log_to_2_" + recipe.getRecipeOutput().toString(), GTUtility.copyAmount(2, recipe.getRecipeOutput()), recipe.getIngredients().get(0).getMatchingStacks()[0]);
                    }
                    RecipeMaps.CUTTER_RECIPES.recipeBuilder().duration(200).EUt(8).inputs(recipe.getIngredients().get(0).getMatchingStacks()[0]).fluidInputs(Materials.Lubricant.getFluid(1)).outputs(GTUtility.copyAmount(6, recipe.getRecipeOutput()), OreDictUnifier.get(OrePrefix.dust, Materials.Wood, 2)).buildAndRegister();
                }
                if (OreDictionary.getOreName(i).equals("slabWood") && recipe.getRecipeOutput().getCount() == 6) {
                    RecipeMaps.CUTTER_RECIPES.recipeBuilder().duration(50).EUt(4).inputs(recipe.getIngredients().get(0).getMatchingStacks()[0]).outputs(GTUtility.copyAmount(2, recipe.getRecipeOutput())).buildAndRegister();
                }
            }
        }

        //Disable Wood To Charcoal Recipes
        List<ItemStack> allWoodLogs = OreDictionary.getOres("logWood").stream()
                .flatMap(stack -> ModHandler.getAllSubItems(stack).stream())
                .collect(Collectors.toList());

        for (ItemStack stack : allWoodLogs) {
            ItemStack smeltingOutput = ModHandler.getSmeltingOutput(stack);
            if (!smeltingOutput.isEmpty() && smeltingOutput.getItem() == Items.COAL && smeltingOutput.getMetadata() == 1 && GAConfig.GT5U.DisableLogToCharcoalSmeltg) {
                ItemStack woodStack = stack.copy();
                woodStack.setItemDamage(OreDictionary.WILDCARD_VALUE);
                ModHandler.removeFurnaceSmelting(woodStack);
            }
        }
    }
}
