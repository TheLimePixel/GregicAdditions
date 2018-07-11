package gregicadditions.recipes;

import gregicadditions.GAMaterials;
import gregicadditions.item.GAMetaItems;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.machines.CokeOvenRecipe;
import gregtech.api.items.ToolDictNames;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.GemMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class GARecipeAddition {
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
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:compass"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:clock"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_helmet"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_chestplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_leggings"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:iron_boots"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:gold_helmet"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:gold_chestplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:gold_leggings"));
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:gol_boots"));

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
        GARecipeMaps.COKE_OVEN_RECIPES.add(new CokeOvenRecipe(CountableIngredient.from("dirt"), new ItemStack(Items.DIAMOND), new FluidStack(FluidRegistry.WATER, 50), 400));
    }
}
