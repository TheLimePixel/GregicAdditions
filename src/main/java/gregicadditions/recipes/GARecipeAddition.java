package gregicadditions.recipes;

import gregicadditions.item.GAMetaItems;
import gregicadditions.machines.CokeOvenRecipe;
import gregtech.api.items.ToolDictNames;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
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
        ModHandler.addShapedRecipe("fireclay_bricks", MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS), "BB", "BB", 'B', GAMetaItems.FIRECLAY_BRICK.getStackForm());
        ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_FIRECLAY.getStackForm(), GAMetaItems.FIRECLAY_BRICK.getStackForm());

        //GT%U Misc Recipes
        ModHandler.addSmeltingRecipe(new ItemStack(Items.SLIME_BALL), MetaItems.RUBBER_DROP.getStackForm());
        ModHandler.removeRecipeByName(new ResourceLocation("minecraft:bone_meal_from_bone"));
        ModHandler.addShapelessRecipe("harder_bone_meal", new ItemStack(Items.DYE, 3, 15), new ItemStack(Items.BONE), ToolDictNames.craftingToolMortar);

        //Wood To Pulp
        ModHandler.addShapelessRecipe("log_to_pulp", OreDictUnifier.get(OrePrefix.dust, Materials.Wood, 1), "logWood", ToolDictNames.craftingToolMortar);


        GARecipeMaps.COKE_OVEN_RECIPES.add(new CokeOvenRecipe(CountableIngredient.from("dirt"), new ItemStack(Items.DIAMOND), new FluidStack(FluidRegistry.WATER, 50), 400));
    }
}
