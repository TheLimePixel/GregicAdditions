package gregicadditions.recipes;

import gregicadditions.GAMaterials;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMetaItems;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.machines.CokeOvenRecipe;
import gregicadditions.machines.GATileEntities;
import gregtech.api.items.ToolDictNames;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.GemMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class GARecipeAddition {

    private static final MaterialStack[] solderingList = {
            new MaterialStack(Materials.Tin, 2L),
            new MaterialStack(Materials.SolderingAlloy, 1L),
            new MaterialStack(Materials.Lead, 4L)
    };

    public static void postInit() {
        //GTNH Bricks
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_COKE_CLAY.getStackForm(), GAMetaItems.COKE_BRICK.getStackForm());
        ModHandler.removeFurnaceSmelting(new ItemStack(Items.CLAY_BALL, 1, OreDictionary.WILDCARD_VALUE));
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_CLAY.getStackForm(), new ItemStack(Items.BRICK));
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(200).EUt(8).inputs(new ItemStack(Items.CLAY_BALL), new ItemStack(Blocks.SAND, 2)).outputs(GAMetaItems.COKE_BRICK.getStackForm()).buildAndRegister();
        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(200).EUt(2).inputs(new ItemStack(Items.CLAY_BALL)).notConsumable(MetaItems.SHAPE_MOLD_INGOT).outputs(new ItemStack(Items.BRICK)).buildAndRegister();
        ModHandler.addShapelessRecipe("acacia_form", GAMetaItems.ACACIA_FORM.getStackForm(), MetaItems.PLANK_ACACIA.getStackForm(), ToolDictNames.craftingToolKnife);
        ModHandler.addShapelessRecipe("birch_form", GAMetaItems.BIRCH_FORM.getStackForm(), MetaItems.PLANK_BIRCH.getStackForm(), ToolDictNames.craftingToolKnife);
        ModHandler.addShapelessRecipe("darkoak_form", GAMetaItems.DARK_OAK_FORM.getStackForm(), MetaItems.PLANK_DARKOAK.getStackForm(), ToolDictNames.craftingToolKnife);
        ModHandler.addShapelessRecipe("jungle_form", GAMetaItems.JUNGLE_FORM.getStackForm(), MetaItems.PLANK_JUNGLE.getStackForm(), ToolDictNames.craftingToolKnife);
        ModHandler.addShapelessRecipe("oak_form", GAMetaItems.OAK_FORM.getStackForm(), MetaItems.PLANK_OAK.getStackForm(), ToolDictNames.craftingToolKnife);
        ModHandler.addShapelessRecipe("spruce_form", GAMetaItems.SPRUCE_FORM.getStackForm(), MetaItems.PLANK_SPRUCE.getStackForm(), ToolDictNames.craftingToolKnife);
        ModHandler.addShapelessRecipe("clay_brick", GAMetaItems.COMPRESSED_CLAY.getStackForm(), new ItemStack(Items.CLAY_BALL), "formWood");
        ModHandler.addShapedRecipe("eight_clay_brick", GAMetaItems.COMPRESSED_CLAY.getStackForm(8), "BBB", "BFB", "BBB", 'B', new ItemStack(Items.CLAY_BALL), 'F', "formWood");
        ModHandler.addShapedRecipe("coke_brick", GAMetaItems.COMPRESSED_COKE_CLAY.getStackForm(3), "BBB", "SFS", "SSS", 'B', new ItemStack(Items.CLAY_BALL), 'S', new ItemStack(Blocks.SAND), 'F', "formWood");
        ModHandler.addShapedRecipe("coke_bricks",GAMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GAMultiblockCasing.CasingType.COKE_OVEN_BRICKS),"BB","BB",'B',GAMetaItems.COKE_BRICK.getStackForm());
        ModHandler.addShapedRecipe("coke_oven",GATileEntities.COKE_OVEN.getStackForm(),"hRS","PBR","dRS",'R',OreDictUnifier.get(OrePrefix.stick,Materials.Iron),'S',OreDictUnifier.get(OrePrefix.screw,Materials.Iron),'P',OreDictUnifier.get(OrePrefix.plate,Materials.Iron),'B',GAMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GAMultiblockCasing.CasingType.COKE_OVEN_BRICKS));


        //GT5U Old Primitive Brick Processing
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_primitive_bricks"));
        ModHandler.addShapedRecipe("fireclay_bricks", MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS),"BB","BB",'B',GAMetaItems.FIRECLAY_BRICK.getStackForm());
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_FIRECLAY.getStackForm(),GAMetaItems.FIRECLAY_BRICK.getStackForm());
        ModHandler.addShapelessRecipe("fireclay",OreDictUnifier.get(OrePrefix.dust,GAMaterials.Fireclay,2),OreDictUnifier.get(OrePrefix.dust,GAMaterials.Brick),OreDictUnifier.get(OrePrefix.dust,Materials.Clay));
        RecipeMaps.MIXER_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.dust,GAMaterials.Brick),OreDictUnifier.get(OrePrefix.dust,Materials.Clay)).outputs(OreDictUnifier.get(OrePrefix.dust,GAMaterials.Fireclay,2)).duration(200).EUt(8).buildAndRegister();
        RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.dust,GAMaterials.Fireclay)).outputs(GAMetaItems.COMPRESSED_FIRECLAY.getStackForm()).duration(400).EUt(2).buildAndRegister();
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().inputs(new ItemStack(Items.BRICK)).outputs(OreDictUnifier.get(OrePrefix.dustSmall,GAMaterials.Brick)).duration(16).EUt(10).buildAndRegister();

        //GT5U Misc Recipes
        ModHandler.addSmeltingRecipe(new ItemStack(Items.SLIME_BALL),MetaItems.RUBBER_DROP.getStackForm());
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:bone_meal_from_bone"));
        ModHandler.addShapelessRecipe("harder_bone_meal",new ItemStack(Items.DYE, 3, 15),new ItemStack(Items.BONE),ToolDictNames.craftingToolMortar);
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().inputs(new ItemStack(Items.BONE)).outputs(new ItemStack(Items.DYE, 3, 15)).duration(16).EUt(10).buildAndRegister();
        RecipeMaps.MACERATOR_RECIPES.recipeBuilder().inputs(new ItemStack(Items.BONE)).outputs(new ItemStack(Items.DYE, 3, 15)).duration(300).EUt(2).buildAndRegister();
        ModHandler.addShapedRecipe("fireclay_bricks", MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS), "BB", "BB", 'B', GAMetaItems.FIRECLAY_BRICK.getStackForm());
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_FIRECLAY.getStackForm(), GAMetaItems.FIRECLAY_BRICK.getStackForm());

        //GT6 Bending
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:iron_bucket"));
        ModHandler.addShapedRecipe("bucket",new ItemStack(Items.BUCKET),"ChC"," P ",'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Iron),'P',OreDictUnifier.get(OrePrefix.plate,Materials.Iron));
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(4).inputs(OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Iron,2),OreDictUnifier.get(OrePrefix.plate,Materials.Iron)).outputs(new ItemStack(Items.BUCKET)).buildAndRegister();
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(4).inputs(OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.WroughtIron,2),OreDictUnifier.get(OrePrefix.plate,Materials.WroughtIron)).outputs(new ItemStack(Items.BUCKET)).buildAndRegister();
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_helmet"));
        ModHandler.addShapedRecipe("iron_helmet",new ItemStack(Items.IRON_HELMET),"PPP","ChC",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Iron),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Iron));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_chestplate"));
        ModHandler.addShapedRecipe("iron_chestplate",new ItemStack(Items.IRON_CHESTPLATE),"PhP","CPC","CPC",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Iron),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Iron));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_leggings"));
        ModHandler.addShapedRecipe("iron_leggings",new ItemStack(Items.IRON_LEGGINGS),"PCP","ChC","C C",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Iron),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Iron));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_boots"));
        ModHandler.addShapedRecipe("iron_boots",new ItemStack(Items.IRON_BOOTS),"P P","ChC",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Iron),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Iron));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_helmet"));
        ModHandler.addShapedRecipe("golden_helmet",new ItemStack(Items.GOLDEN_HELMET),"PPP","ChC",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Gold),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Gold));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_chestplate"));
        ModHandler.addShapedRecipe("golden_chestplate",new ItemStack(Items.GOLDEN_CHESTPLATE),"PhP","CPC","CPC",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Gold),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Gold));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_leggings"));
        ModHandler.addShapedRecipe("golden_leggings",new ItemStack(Items.GOLDEN_LEGGINGS),"PCP","ChC","C C",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Gold),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Gold));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:golden_boots"));
        ModHandler.addShapedRecipe("golden_boots",new ItemStack(Items.GOLDEN_BOOTS),"P P","ChC",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Gold),'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),Materials.Gold));
        ModHandler.addShapedRecipe("chain_helmet",new ItemStack(Items.CHAINMAIL_HELMET),"RRR","RhR",'R',OreDictUnifier.get(OrePrefix.ring,Materials.Iron));
        ModHandler.addShapedRecipe("chain_chestplate",new ItemStack(Items.CHAINMAIL_CHESTPLATE),"RhR","RRR","RRR",'R',OreDictUnifier.get(OrePrefix.ring,Materials.Iron));
        ModHandler.addShapedRecipe("chain_leggings",new ItemStack(Items.CHAINMAIL_LEGGINGS),"RRR","RhR","R R",'R',OreDictUnifier.get(OrePrefix.ring,Materials.Iron));
        ModHandler.addShapedRecipe("chain_boots",new ItemStack(Items.CHAINMAIL_BOOTS),"R R","RhR",'R',OreDictUnifier.get(OrePrefix.ring,Materials.Iron));
        for(Material m : IngotMaterial.MATERIAL_REGISTRY) {
            if (!OreDictUnifier.get(OrePrefix.ring, m).isEmpty()) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.ring,m));
                ModHandler.addShapedRecipe("ring_" + m.toString(), OreDictUnifier.get(OrePrefix.ring, m), "hS", " C", 'S', OreDictUnifier.get(OrePrefix.stick, m), 'C', "craftingToolBendingCylinderSmall");
            }
            if (!OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m).isEmpty()) {
                ModHandler.addShapedRecipe("curved_plate_" + m.toString(), OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m), "h", "P", "C", 'P', OreDictUnifier.get(OrePrefix.plate, m), 'C', "craftingToolBendingCylinder");
                ModHandler.addShapedRecipe("flatten_plate_"+m.toString(), OreDictUnifier.get(OrePrefix.plate,m),"h","C",'C',OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),m));
                RecipeMaps.BENDER_RECIPES.recipeBuilder().EUt(24).duration((int)m.getMass()).inputs(OreDictUnifier.get(OrePrefix.plate,m)).circuitMeta(0).outputs(OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),m)).buildAndRegister();
            }
            if (!OreDictUnifier.get(OrePrefix.rotor, m).isEmpty()) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.rotor,m));
                ModHandler.addShapedRecipe("rotor_" + m.toString(), OreDictUnifier.get(OrePrefix.rotor, m), "ChC", "SRf", "CdC", 'C', OreDictUnifier.get(OrePrefix.valueOf("plateCurved"), m), 'S', OreDictUnifier.get(OrePrefix.screw,m),'R',OreDictUnifier.get(OrePrefix.ring,m));
                RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(240).EUt(24).inputs(OreDictUnifier.get(OrePrefix.valueOf("plateCurved"),m,4),OreDictUnifier.get(OrePrefix.ring,m)).fluidInputs(Materials.SolderingAlloy.getFluid(32)).outputs(OreDictUnifier.get(OrePrefix.rotor,m)).buildAndRegister();
            }
            if (!OreDictUnifier.get(OrePrefix.foil,m).isEmpty()) {
                ModHandler.addShapedRecipe("foil_"+m.toString(), OreDictUnifier.get(OrePrefix.foil,m,2), "hPC",'P',OreDictUnifier.get(OrePrefix.plate,m),'C',"craftingToolBendingCylinder");
                GARecipeMaps.CLUSTER_MILL_RECIPES.recipeBuilder().EUt(24).duration((int)m.getMass()).inputs(OreDictUnifier.get(OrePrefix.plate,m)).outputs(OreDictUnifier.get(OrePrefix.foil,m,4)).buildAndRegister();
            }

            //GT6 Plate Recipe
            if (m instanceof IngotMaterial && !OreDictUnifier.get(OrePrefix.plate,m).isEmpty()) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.plate,m));
                ModHandler.addShapedRecipe("ingot_double_"+m.toString(),OreDictUnifier.get(OrePrefix.valueOf("ingotDouble"),m),"h","I","I",'I',OreDictUnifier.get(OrePrefix.ingot,m));
                ModHandler.addShapedRecipe("plate_"+m.toString(),OreDictUnifier.get(OrePrefix.plate,m),"h","I",'I',OreDictUnifier.get(OrePrefix.valueOf("ingotDouble"),m));
            }

            //GT5U Block Recipes
            if (m instanceof IngotMaterial && !m.hasFlag(DustMaterial.MatFlags.EXCLUDE_BLOCK_CRAFTING_RECIPES)) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.block, m));
                ModHandler.removeRecipeByName(new ResourceLocation("gregtech:block_decompress_" + m.toString()));
                RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).inputs(OreDictUnifier.get(OrePrefix.ingot, m, 9)).outputs(OreDictUnifier.get(OrePrefix.block, m)).buildAndRegister();
            }
        }
        for (Material m : GemMaterial.MATERIAL_REGISTRY) {
            if (m instanceof GemMaterial && !m.hasFlag(DustMaterial.MatFlags.EXCLUDE_BLOCK_CRAFTING_RECIPES)) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.block, m));
                ModHandler.removeRecipeByName(new ResourceLocation("gregtech:block_decompress_" + m.toString()));
                if (m!= Materials.NetherQuartz) {
                    RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).inputs(OreDictUnifier.get(OrePrefix.gem, m, 9)).outputs(OreDictUnifier.get(OrePrefix.block, m)).buildAndRegister();
                    RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().duration(100).EUt(24).inputs(OreDictUnifier.get(OrePrefix.block, m)).outputs(OreDictUnifier.get(OrePrefix.gem, m, 9)).buildAndRegister();
                }
            }
        }
        for (Material m : DustMaterial.MATERIAL_REGISTRY) {
            if (m instanceof DustMaterial && OreDictUnifier.get(OrePrefix.ingot,m).isEmpty() && OreDictUnifier.get(OrePrefix.gem,m).isEmpty() && !m.hasFlag(DustMaterial.MatFlags.EXCLUDE_BLOCK_CRAFTING_RECIPES)) {
                ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.block, m));
                ModHandler.removeRecipeByName(new ResourceLocation("gregtech:block_decompress_"+m.toString()));
                if (m!=Materials.Bone)
                    RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).inputs(OreDictUnifier.get(OrePrefix.dust, m, 9)).outputs(OreDictUnifier.get(OrePrefix.block, m)).buildAndRegister();
            }
        }
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().duration(100).EUt(24).inputs(OreDictUnifier.get(OrePrefix.block, Materials.NetherQuartz)).outputs(OreDictUnifier.get(OrePrefix.gem, Materials.NetherQuartz, 4)).buildAndRegister();
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_ingot_from_block"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:gold_ingot_from_block"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:redstone"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:diamond"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:emerald"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:coal"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:lapis_lazuli"));
        RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).inputs(new ItemStack(Items.DYE, 9,15)).outputs(OreDictUnifier.get(OrePrefix.block, Materials.Bone)).buildAndRegister();

        //Wood To Pulp
        ModHandler.addShapelessRecipe("log_to_pulp", OreDictUnifier.get(OrePrefix.dust, Materials.Wood, 1), "logWood", ToolDictNames.craftingToolMortar);

        //GT5U Slabs Are Made With A Saw
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:stone_slab"));
        ModHandler.addShapedRecipe("stone_slab",new ItemStack(Blocks.STONE_SLAB,2),"sS",'S',new ItemStack(Blocks.STONE));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:sandstone_slab"));
        ModHandler.addShapedRecipe("sandstone_slab",new ItemStack(Blocks.STONE_SLAB,2,1),"sS",'S',new ItemStack(Blocks.SANDSTONE));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:cobblestone_slab"));
        ModHandler.addShapedRecipe("cobblestone_slab",new ItemStack(Blocks.STONE_SLAB,2,3),"sC",'C',new ItemStack(Blocks.COBBLESTONE));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:brick_slab"));
        ModHandler.addShapedRecipe("brick_slab",new ItemStack(Blocks.STONE_SLAB,2,4),"sB",'B',new ItemStack(Blocks.BRICK_BLOCK));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:stone_brick_slab"));
        ModHandler.addShapedRecipe("stone_brick_slab",new ItemStack(Blocks.STONE_SLAB,2,5),"sB",'B',new ItemStack(Blocks.STONEBRICK));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:nether_brick_slab"));
        ModHandler.addShapedRecipe("nether_brick_slab",new ItemStack(Blocks.STONE_SLAB,2,6),"sB",'B',new ItemStack(Blocks.NETHER_BRICK));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:quartz_slab"));
        ModHandler.addShapedRecipe("quartz_slab",new ItemStack(Blocks.STONE_SLAB,2,7),"sQ",'Q',new ItemStack(Blocks.QUARTZ_BLOCK));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:oak_wooden_slab"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:spruce_wooden_slab"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:birch_wooden_slab"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:jungle_wooden_slab"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:acacia_wooden_slab"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:dark_oak_wooden_slab"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:red_sandstone_slab"));
        ModHandler.addShapedRecipe("red_sandstone_slab",new ItemStack(Blocks.STONE_SLAB2,2),"sS",'S',new ItemStack(Blocks.RED_SANDSTONE));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:purpur_slab"));
        ModHandler.addShapedRecipe("purpur",new ItemStack(Blocks.PURPUR_SLAB,2),"sP",'P',new ItemStack(Blocks.PURPUR_BLOCK));

        //Coke Oven Recipes
        GARecipeMaps.COKE_OVEN_RECIPES.add(new CokeOvenRecipe(CountableIngredient.from(OreDictUnifier.get(OrePrefix.gem,Materials.Coal)), OreDictUnifier.get(OrePrefix.gem,GAMaterials.Coke), Materials.Creosote.getFluid(500), 1800));

        //Circuit Rabbit Hole - Layer 1
        for (MaterialStack stack : solderingList) {
            IngotMaterial material = (IngotMaterial) stack.material;
            int multiplier = (int) stack.amount;

            ModHandler.addShapedRecipe("vacuum_tube_1", GAMetaItems.VACUUM_TUBE.getStackForm(), "PTP", "WWW", 'P', new ItemStack(Items.PAPER), 'T', GAMetaItems.GLASS_TUBE.getStackForm(), 'W', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper));
            ModHandler.addShapedRecipe("vacuum_tube_2", GAMetaItems.VACUUM_TUBE.getStackForm(), "PTP", "WWW", 'P', new ItemStack(Items.PAPER), 'T', GAMetaItems.GLASS_TUBE.getStackForm(), 'W', OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper));
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(120).EUt(8).inputs(GAMetaItems.GLASS_TUBE.getStackForm(), OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper, 2), new ItemStack(Items.PAPER, 2)).outputs(GAMetaItems.VACUUM_TUBE.getStackForm()).buildAndRegister();
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(120).EUt(8).inputs(GAMetaItems.GLASS_TUBE.getStackForm(), OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 2), new ItemStack(Items.PAPER, 2)).outputs(GAMetaItems.VACUUM_TUBE.getStackForm()).buildAndRegister();
            ModHandler.addShapedRecipe("basic_circuit", GAMetaItems.BASIC_CIRCUIT.getStackForm(), "RPR", "VBV", "CCC", 'R', GAMetaItems.RESISTOR.getStackForm(), 'P', OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 'V', GAMetaItems.VACUUM_TUBE.getStackForm(), 'B', GAMetaItems.COATED_BOARD.getStackForm(), 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.RedAlloy));
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(8).inputs(GAMetaItems.PHENOLIC_BOARD.getStackForm(),GAMetaItems.LOGIC_CIRCUIT.getStackForm(),GAMetaItems.RESISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.Copper)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_BASIC.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(8).inputs(GAMetaItems.PHENOLIC_BOARD.getStackForm(),GAMetaItems.LOGIC_CIRCUIT.getStackForm(),GAMetaItems.SMD_RESISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.Copper)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_BASIC.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),GAMetaItems.CPU.getStackForm(4),GAMetaItems.RESISTOR.getStackForm(4),GAMetaItems.CAPACITOR.getStackForm(4),GAMetaItems.TRANSISTOR.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Copper,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_PARTS_ADVANCED.getStackForm(4)).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),GAMetaItems.CPU.getStackForm(4),GAMetaItems.SMD_RESISTOR.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(4),GAMetaItems.SMD_TRANSISTOR.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Copper,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_PARTS_ADVANCED.getStackForm(4)).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(600).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),GAMetaItems.SOC.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Copper,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_PARTS_ADVANCED.getStackForm(4)).buildAndRegister();
            ModHandler.addShapedRecipe("good_circuit",MetaItems.CIRCUIT_GOOD.getStackForm(),"PCR","CDC","RCP",'P',OreDictUnifier.get(OrePrefix.plate,Materials.Steel),'C',GAMetaItems.BASIC_CIRCUIT.getStackForm(),'R',OreDictUnifier.get(OrePrefix.cableGtSingle,Materials.RedAlloy),'D',GAMetaItems.DIODE.getStackForm());
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(16).inputs(GAMetaItems.PHENOLIC_BOARD.getStackForm(),MetaItems.CIRCUIT_BASIC.getStackForm(3),GAMetaItems.RESISTOR.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,8)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.GOOD_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(16).inputs(GAMetaItems.PHENOLIC_BOARD.getStackForm(),MetaItems.CIRCUIT_BASIC.getStackForm(3),GAMetaItems.SMD_RESISTOR.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,8)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.GOOD_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),GAMetaItems.CPU.getStackForm(),GAMetaItems.RESISTOR.getStackForm(2),GAMetaItems.CAPACITOR.getStackForm(2),GAMetaItems.TRANSISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.RedAlloy,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_ADVANCED.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(60).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),GAMetaItems.CPU.getStackForm(),GAMetaItems.SMD_RESISTOR.getStackForm(2),GAMetaItems.SMD_CAPACITOR.getStackForm(2),GAMetaItems.SMD_TRANSISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.RedAlloy,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_ADVANCED.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(2400).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),GAMetaItems.SOC.getStackForm(),OreDictUnifier.get(OrePrefix.wireFine,Materials.RedAlloy,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(MetaItems.CIRCUIT_ADVANCED.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(800).EUt(28).inputs(GAMetaItems.GOOD_CIRCUIT.getStackForm(2),GAMetaItems.LOGIC_CIRCUIT.getStackForm(3),GAMetaItems.RAM.getStackForm(),GAMetaItems.TRANSISTOR.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,16)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.ADVANCED_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(800).EUt(28).inputs(GAMetaItems.GOOD_CIRCUIT.getStackForm(2),GAMetaItems.LOGIC_CIRCUIT.getStackForm(3),GAMetaItems.RAM.getStackForm(),GAMetaItems.SMD_TRANSISTOR.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,16)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.ADVANCED_CIRCUIT.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),MetaItems.CIRCUIT_ADVANCED.getStackForm(2),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.CAPACITOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.RedAlloy,12)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.INTEGRATED_ASSEMBLY.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(80).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),MetaItems.CIRCUIT_ADVANCED.getStackForm(2),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.RedAlloy,12)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.INTEGRATED_ASSEMBLY.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(600).inputs(GAMetaItems.EPOXY_BOARD.getStackForm(),GAMetaItems.NANOCPU.getStackForm(),GAMetaItems.SMD_RESISTOR.getStackForm(2),GAMetaItems.SMD_CAPACITOR.getStackForm(2),GAMetaItems.SMD_TRANSISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.NANOPROCESSOR.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(9600).inputs(GAMetaItems.EPOXY_BOARD.getStackForm(),GAMetaItems.SOC.getStackForm(),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.NANOPROCESSOR.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(2),GAMetaItems.INTEGRATED_ASSEMBLY.getStackForm(3),GAMetaItems.DIODE.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.CIRCUIT_DATA.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(2),GAMetaItems.INTEGRATED_ASSEMBLY.getStackForm(3),GAMetaItems.SMD_DIODE.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.CIRCUIT_DATA.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(600).inputs(GAMetaItems.EPOXY_BOARD.getStackForm(),GAMetaItems.NANOPROCESSOR.getStackForm(2),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.NANO_ASSEMBLY.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(2400).inputs(GAMetaItems.FIBER_BOARD.getStackForm(),GAMetaItems.QBIT_CPU.getStackForm(),GAMetaItems.NANOCPU.getStackForm(),GAMetaItems.SMD_CAPACITOR.getStackForm(2),GAMetaItems.SMD_TRANSISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.Platinum,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.QUANTUMPROCESSOR.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(38400).inputs(GAMetaItems.FIBER_BOARD.getStackForm(),GAMetaItems.ASOC.getStackForm(),OreDictUnifier.get(OrePrefix.wireFine,Materials.Platinum,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.QUANTUMPROCESSOR.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(480).inputs(OreDictUnifier.get(OrePrefix.frameGt,Materials.Aluminium),MetaItems.CIRCUIT_DATA.getStackForm(4),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.CAPACITOR.getStackForm(24),GAMetaItems.RAM.getStackForm(16),OreDictUnifier.get(OrePrefix.wireGtSingle,Materials.AnnealedCopper,12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.INTEGRATED_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(480).inputs(OreDictUnifier.get(OrePrefix.frameGt,Materials.Aluminium),MetaItems.CIRCUIT_DATA.getStackForm(4),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(24),GAMetaItems.RAM.getStackForm(16),OreDictUnifier.get(OrePrefix.wireGtSingle,Materials.AnnealedCopper,12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.INTEGRATED_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(600).inputs(GAMetaItems.EPOXY_BOARD.getStackForm(2),GAMetaItems.NANO_ASSEMBLY.getStackForm(3),GAMetaItems.SMD_DIODE.getStackForm(4),GAMetaItems.NOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Electrum,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.NANO_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(2400).inputs(GAMetaItems.FIBER_BOARD.getStackForm(),GAMetaItems.QUANTUMPROCESSOR.getStackForm(2),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Platinum,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.CIRCUIT_ELITE.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(9600).inputs(GAMetaItems.MULTILAYER_FIBER_BOARD.getStackForm(),GAMetaItems.CRYSTAL_CPU.getStackForm(),GAMetaItems.NANOCPU.getStackForm(),GAMetaItems.SMD_CAPACITOR.getStackForm(2),GAMetaItems.SMD_TRANSISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.NiobiumTitanium,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.CRYSTALPROCESSOR.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(153600).inputs(GAMetaItems.MULTILAYER_FIBER_BOARD.getStackForm(),GAMetaItems.CRYSTAL_SOC.getStackForm(),OreDictUnifier.get(OrePrefix.wireFine,Materials.NiobiumTitanium,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.CRYSTALPROCESSOR.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(1920).inputs(OreDictUnifier.get(OrePrefix.frameGt,Materials.Aluminium),GAMetaItems.NANO_COMPUTER.getStackForm(4),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(24),GAMetaItems.RAM.getStackForm(16),OreDictUnifier.get(OrePrefix.wireGtSingle,Materials.AnnealedCopper,12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.NANO_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(2400).inputs(GAMetaItems.FIBER_BOARD.getStackForm(2),MetaItems.CIRCUIT_ELITE.getStackForm(3),GAMetaItems.SMD_DIODE.getStackForm(4),GAMetaItems.NOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.Platinum,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.QUANTUM_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(9600).inputs(GAMetaItems.MULTILAYER_FIBER_BOARD.getStackForm(),GAMetaItems.CRYSTALPROCESSOR.getStackForm(2),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.NiobiumTitanium,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.CIRCUIT_MASTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(200).EUt(38400).inputs(MetaItems.CIRCUIT_BOARD_ELITE.getStackForm(),GAMetaItems.CRYSTAL_CPU.getStackForm(),GAMetaItems.NANOCPU.getStackForm(),GAMetaItems.SMD_CAPACITOR.getStackForm(2),GAMetaItems.SMD_TRANSISTOR.getStackForm(2),OreDictUnifier.get(OrePrefix.wireFine,Materials.YttriumBariumCuprate,2)).fluidInputs(material.getFluid(72 * multiplier)).outputs(GAMetaItems.WETWAREPROCESSOR.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(7680).inputs(OreDictUnifier.get(OrePrefix.frameGt,Materials.Aluminium),GAMetaItems.QUANTUM_COMPUTER.getStackForm(4),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(24),GAMetaItems.RAM.getStackForm(16),OreDictUnifier.get(OrePrefix.wireGtSingle,Materials.AnnealedCopper,12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.QUANTUM_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(9600).inputs(GAMetaItems.MULTILAYER_FIBER_BOARD.getStackForm(2),MetaItems.CIRCUIT_MASTER.getStackForm(3),GAMetaItems.SMD_DIODE.getStackForm(4),GAMetaItems.NOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.NiobiumTitanium,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.CRYSTAL_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(38400).inputs(GAMetaItems.WETWARE_BOARD.getStackForm(),GAMetaItems.WETWAREPROCESSOR.getStackForm(2),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.YttriumBariumCuprate,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.WETWARE_ASSEMBLY.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1600).EUt(30720).inputs(OreDictUnifier.get(OrePrefix.frameGt,Materials.Aluminium),GAMetaItems.CRYSTAL_COMPUTER.getStackForm(4),GAMetaItems.SMALL_COIL.getStackForm(4),GAMetaItems.SMD_CAPACITOR.getStackForm(24),GAMetaItems.RAM.getStackForm(16),OreDictUnifier.get(OrePrefix.wireGtSingle, MarkerMaterials.Tier.Superconductor,12)).fluidInputs(material.getFluid(288 * multiplier)).outputs(GAMetaItems.CRYSTAL_MAINFRAME.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(38400).inputs(GAMetaItems.WETWARE_BOARD.getStackForm(2),GAMetaItems.WETWARE_ASSEMBLY.getStackForm(3),GAMetaItems.SMD_DIODE.getStackForm(4),GAMetaItems.NOR.getStackForm(4),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.YttriumBariumCuprate,6)).fluidInputs(material.getFluid(144 * multiplier)).outputs(GAMetaItems.WETWARE_COMPUTER.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(512).EUt(1024).inputs(GAMetaItems.FIBER_BOARD.getStackForm(),GAMetaItems.PIC.getStackForm(4),MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_MASTER.getStackForm(18),GAMetaItems.NANOCPU.getStackForm(),OreDictUnifier.get(OrePrefix.wireFine,Materials.Platinum,16)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.ENERGY_LAPOTRONIC_ORB.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(1024).EUt(4096).inputs(GAMetaItems.FIBER_BOARD.getStackForm(),GAMetaItems.HPIC.getStackForm(4),MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm(8),GAMetaItems.QBIT_CPU.getStackForm(),OreDictUnifier.get(OrePrefix.wireFine,Materials.Platinum,16),OreDictUnifier.get(OrePrefix.plate,Materials.Europium,4)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(90).inputs(GAMetaItems.PLASTIC_BOARD.getStackForm(),MetaItems.CIRCUIT_ADVANCED.getStackForm(),GAMetaItems.NAND.getStackForm(32),GAMetaItems.RAM.getStackForm(4),OreDictUnifier.get(OrePrefix.wireFine,Materials.RedAlloy,8),OreDictUnifier.get(OrePrefix.plate,Materials.Plastic,4)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.TOOL_DATA_STICK.getStackForm()).buildAndRegister();
            GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(1200).inputs(GAMetaItems.EPOXY_BOARD.getStackForm(),GAMetaItems.NANOPROCESSOR.getStackForm(),GAMetaItems.RAM.getStackForm(4),GAMetaItems.NOR.getStackForm(32),GAMetaItems.NAND.getStackForm(64),OreDictUnifier.get(OrePrefix.wireFine,Materials.Platinum,32)).fluidInputs(material.getFluid(144 * multiplier)).outputs(MetaItems.TOOL_DATA_ORB.getStackForm()).buildAndRegister();
        }
        //Circuit Rabbit Hole - Layer 2
    }
}
