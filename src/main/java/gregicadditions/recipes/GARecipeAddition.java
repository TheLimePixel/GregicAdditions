package gregicadditions.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import forestry.core.ModuleCore;
import forestry.core.fluids.Fluids;
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
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.GemMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
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

public class GARecipeAddition {

	private static final MaterialStack[] cableFluids = { new MaterialStack(Materials.Rubber, 144), new MaterialStack(Materials.StyreneButadieneRubber, 108), new MaterialStack(Materials.SiliconeRubber, 72) };

	private static final MaterialStack[] cableDusts = { new MaterialStack(Materials.Polydimethylsiloxane, 1), new MaterialStack(Materials.PolyvinylChloride, 1) };

	private static final MaterialStack[] firstMetal = { new MaterialStack(Materials.Iron, 1), new MaterialStack(Materials.Nickel, 1), new MaterialStack(Materials.Invar, 2), new MaterialStack(Materials.Steel, 2), new MaterialStack(Materials.StainlessSteel, 3), new MaterialStack(Materials.Titanium, 3), new MaterialStack(Materials.Tungsten, 4), new MaterialStack(Materials.TungstenSteel, 5) };

	private static final MaterialStack[] lastMetal = { new MaterialStack(Materials.Tin, 0), new MaterialStack(Materials.Zinc, 0), new MaterialStack(Materials.Aluminium, 1) };

	private static final MaterialStack[] ironOres = { new MaterialStack(Materials.Pyrite, 1), new MaterialStack(Materials.BrownLimonite, 1), new MaterialStack(Materials.YellowLimonite, 1), new MaterialStack(Materials.Magnetite, 1), new MaterialStack(Materials.Iron, 1) };

	private static final MaterialStack[] lubeDusts = { new MaterialStack(Materials.Talc, 1), new MaterialStack(Materials.Soapstone, 1), new MaterialStack(Materials.Redstone, 1) };

	private static final MaterialStack[] lapisLike = { new MaterialStack(Materials.Lapis, 1), new MaterialStack(Materials.Lazurite, 1), new MaterialStack(Materials.Sodalite, 1) };

	public static void init() {

		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(80).EUt(32).fluidInputs(Materials.Redstone.getFluid(144 * 3), Materials.Copper.getFluid(144)).fluidOutputs(Materials.RedAlloy.getFluid(144)).buildAndRegister();
		RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).fluidInputs(Materials.Redstone.getFluid(144 * 2)).inputs(CountableIngredient.from(OrePrefix.ingot, Materials.Copper)).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.RedAlloy)).buildAndRegister();
		RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(160).EUt(240).fluidInputs(Materials.Redstone.getFluid(144)).inputs(CountableIngredient.from(OrePrefix.ingot, Materials.AnnealedCopper)).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.RedAlloy)).buildAndRegister();

		RecipeMaps.FLUID_SOLIDFICATION_RECIPES.recipeBuilder().fluidInputs(Materials.Glass.getFluid(144)).notConsumable(MetaItems.SHAPE_MOLD_BALL.getStackForm()).outputs(MetaItems.GLASS_TUBE.getStackForm()).EUt(16).duration(80).buildAndRegister();

		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().inputs(new ItemStack(Items.GLOWSTONE_DUST, 4)).outputs(new ItemStack(Blocks.GLOWSTONE)).EUt(16).duration(40).buildAndRegister();

		//GTNH Bricks
		ModHandler.removeFurnaceSmelting(new ItemStack(Items.CLAY_BALL, 1, OreDictionary.WILDCARD_VALUE));
		ModHandler.removeFurnaceSmelting(MetaItems.COMPRESSED_CLAY.getStackForm());
		ModHandler.addSmeltingRecipe(MetaItems.COMPRESSED_CLAY.getStackForm(), new ItemStack(Items.BRICK));
		RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(200).EUt(2).inputs(new ItemStack(Items.CLAY_BALL)).notConsumable(MetaItems.SHAPE_MOLD_INGOT).outputs(new ItemStack(Items.BRICK)).buildAndRegister();
		OreDictionary.registerOre("formWood", MetaItems.WOODEN_FORM_BRICK.getStackForm());
		ModHandler.addShapelessRecipe("clay_brick", MetaItems.COMPRESSED_CLAY.getStackForm(), new ItemStack(Items.CLAY_BALL), "formWood");
		ModHandler.addShapedRecipe("eight_clay_brick", MetaItems.COMPRESSED_CLAY.getStackForm(8), "BBB", "BFB", "BBB", 'B', new ItemStack(Items.CLAY_BALL), 'F', "formWood");
		ModHandler.addShapedRecipe("coke_brick", GAMetaItems.COMPRESSED_COKE_CLAY.getStackForm(3), "BBB", "SFS", "SSS", 'B', new ItemStack(Items.CLAY_BALL), 'S', new ItemStack(Blocks.SAND), 'F', "formWood");
		ModHandler.addSmeltingRecipe(GAMetaItems.COMPRESSED_COKE_CLAY.getStackForm(), MetaItems.COKE_OVEN_BRICK.getStackForm());

		//GT5U Misc Recipes
		ModHandler.addSmeltingRecipe(new ItemStack(Items.SLIME_BALL), MetaItems.RUBBER_DROP.getStackForm());
		ModHandler.removeRecipeByName(new ResourceLocation("minecraft:bone_meal_from_bone"));
		ModHandler.addShapelessRecipe("harder_bone_meal", new ItemStack(Items.DYE, 3, 15), new ItemStack(Items.BONE), ToolDictNames.craftingToolMortar);
		RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().inputs(new ItemStack(Items.BONE)).outputs(new ItemStack(Items.DYE, 3, 15)).duration(16).EUt(10).buildAndRegister();
		RecipeMaps.MACERATOR_RECIPES.recipeBuilder().inputs(new ItemStack(Items.BONE)).outputs(new ItemStack(Items.DYE, 3, 15)).duration(300).EUt(2).buildAndRegister();

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
		for (Material m : Material.MATERIAL_REGISTRY) {
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
			if (!OreDictUnifier.get(OrePrefix.wireGtSingle, m).isEmpty() && !OreDictUnifier.get(OrePrefix.wireFine, m).isEmpty() && GAConfig.GT5U.OldFineWireRecipes && GAConfig.GT6.BendingCylinders) {
				RecipeMaps.WIREMILL_RECIPES.recipeBuilder().EUt(9).duration(200).inputs(OreDictUnifier.get(OrePrefix.wireGtSingle, m)).outputs(OreDictUnifier.get(OrePrefix.wireFine, m, 4)).buildAndRegister();
			}

			if (!OreDictUnifier.get(OrePrefix.valueOf("round"), m).isEmpty()) {
				ModHandler.addShapedRecipe("round" + m.toString(), OreDictUnifier.get(OrePrefix.valueOf("round"), m), "fN", "N ", 'N', OreDictUnifier.get(OrePrefix.nugget, m));
				RecipeMaps.LATHE_RECIPES.recipeBuilder().EUt(8).duration((int) m.getMass()).inputs(OreDictUnifier.get(OrePrefix.nugget, m)).outputs(OreDictUnifier.get(OrePrefix.valueOf("round"), m)).buildAndRegister();
			}

			//ModHandler.addShapedRecipe("plasma_pipe", OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Plasma), "ESE", "NTN", "ESE", 'E', "platePlastic", 'S', OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor), 'N', "plateNeodymiumMagnetic", 'T', OreDictUnifier.get(OrePrefix.pipeSmall, Materials.Titanium));

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
		for (Material m : Material.MATERIAL_REGISTRY) {
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

		//Rubbers
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Isoprene.getFluid(144), Materials.Air.getFluid(2000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.RawRubber)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(30).fluidInputs(Materials.Isoprene.getFluid(144), Materials.Oxygen.getFluid(2000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.RawRubber, 3)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(240).fluidInputs(Materials.Butadiene.getFluid(108), Materials.Styrene.getFluid(36), Materials.Air.getFluid(2000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.RawStyreneButadieneRubber)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(240).fluidInputs(Materials.Butadiene.getFluid(108), Materials.Styrene.getFluid(36), Materials.Oxygen.getFluid(2000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.RawStyreneButadieneRubber, 3)).buildAndRegister();

		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(120).EUt(30).notConsumable(new IntCircuitIngredient(2)).fluidInputs(Materials.Propene.getFluid(2000)).fluidOutputs(Materials.Methane.getFluid(1000), Materials.Isoprene.getFluid(1000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(3500).EUt(30).input(OrePrefix.dust, Materials.Carbon).notConsumable(new IntCircuitIngredient(0)).fluidInputs(Materials.Hydrogen.getFluid(4000)).fluidOutputs(Materials.Methane.getFluid(5000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(120).EUt(30).fluidInputs(Materials.Ethylene.getFluid(1000), Materials.Propene.getFluid(1000)).fluidOutputs(Materials.Hydrogen.getFluid(2000), Materials.Isoprene.getFluid(1000)).buildAndRegister();

		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dust, Materials.RawStyreneButadieneRubber, 9).input(OrePrefix.dust, Materials.Sulfur).fluidOutputs(Materials.StyreneButadieneRubber.getFluid(1296)).buildAndRegister();

		//Polyphenylene Process
		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(60).EUt(30).input(OrePrefix.dust, Materials.Sodium, 2).input(OrePrefix.dust, Materials.Sulfur).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.SodiumSulfide)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(360).input(OrePrefix.dust, Materials.SodiumSulfide).fluidInputs(Materials.Dichlorobenzene.getFluid(1000), Materials.Air.getFluid(16000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Salt, 2)).fluidOutputs(Materials.PolyphenyleneSulfide.getFluid(1000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(360).input(OrePrefix.dust, Materials.SodiumSulfide).fluidInputs(Materials.Dichlorobenzene.getFluid(1000), Materials.Oxygen.getFluid(8000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Salt, 2)).fluidOutputs(Materials.PolyphenyleneSulfide.getFluid(1500)).buildAndRegister();

		//Platinum Sludge
		//RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(50).EUt(30).inputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Chalcopyrite)).fluidInputs(Materials.NitricAcid.getFluid(1000)).outputs(OreDictUnifier.get(OrePrefix.dustTiny, Materials.PlatinumGroupSludge)).fluidOutputs(Materials.BlueVitriolSolution.getFluid(9000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(50).EUt(30).inputs(OreDictUnifier.get(OrePrefix.crushedPurified, Materials.Pentlandite)).fluidInputs(Materials.NitricAcid.getFluid(1000)).outputs(OreDictUnifier.get(OrePrefix.dustTiny, Materials.PlatinumGroupSludge)).fluidOutputs(Materials.NickelSulfateSolution.getFluid(9000)).buildAndRegister();

		RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder().duration(900).EUt(30).input(OrePrefix.dust, Materials.PlatinumGroupSludge).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.SiliconDioxide), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Gold), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Platinum)).chancedOutput(OreDictUnifier.get(OrePrefix.dustTiny, Materials.Palladium), 8000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.dustTiny, Materials.Iridium), 6000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.dustTiny, Materials.Osmium), 6000, 0).buildAndRegister();

		//Ultimate Pipes
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(300).EUt(96).inputs(OreDictUnifier.get(OrePrefix.pipeSmall, Materials.TungstenSteel), MetaItems.ELECTRIC_PUMP_EV.getStackForm()).outputs(OreDictUnifier.get(OrePrefix.pipeSmall, Materials.Ultimet)).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(400).EUt(148).inputs(OreDictUnifier.get(OrePrefix.pipeMedium, Materials.TungstenSteel), MetaItems.ELECTRIC_PUMP_IV.getStackForm()).outputs(OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Ultimet)).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(256).inputs(OreDictUnifier.get(OrePrefix.pipeLarge, Materials.TungstenSteel), MetaItems.ELECTRIC_PUMP_IV.getStackForm(2)).outputs(OreDictUnifier.get(OrePrefix.pipeLarge, Materials.Ultimet)).buildAndRegister();

		//Reinforced Glass
		int multiplier2;
		for (MaterialStack metal1 : firstMetal) {
			IngotMaterial material1 = (IngotMaterial) metal1.material;
			int multiplier1 = (int) metal1.amount;
			for (MaterialStack metal2 : lastMetal) {
				IngotMaterial material2 = (IngotMaterial) metal2.material;
				if ((int) metal1.amount == 1) multiplier2 = 0;
				else multiplier2 = (int) metal2.amount;
				ModHandler.addShapedRecipe("mixed_metal_1_" + material1.toString() + "_" + material2.toString(), MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2), "F", "M", "L", 'F', new UnificationEntry(OrePrefix.plate, material1), 'M', "plateBronze", 'L', OreDictUnifier.get(OrePrefix.plate, material2));
				ModHandler.addShapedRecipe("mixed_metal_2_" + material1.toString() + "_" + material2.toString(), MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2), "F", "M", "L", 'F', new UnificationEntry(OrePrefix.plate, material1), 'M', "plateBrass", 'L', OreDictUnifier.get(OrePrefix.plate, material2));

				RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40 * multiplier1 + multiplier2 * 40).EUt(8).input(OrePrefix.plate, material1).input(OrePrefix.plank, Materials.Bronze).input(OrePrefix.plate, material2).outputs(MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2)).buildAndRegister();
				RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(40 * multiplier1 + multiplier2 * 40).EUt(8).input(OrePrefix.plate, material1).input(OrePrefix.plate, Materials.Brass).input(OrePrefix.plate, material2).outputs(MetaItems.INGOT_MIXED_METAL.getStackForm(multiplier1 + multiplier2)).buildAndRegister();
			}
		}

		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(MetaItems.INGOT_MIXED_METAL.getStackForm()).outputs(MetaItems.ADVANCED_ALLOY_PLATE.getStackForm()).buildAndRegister();

		RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(4).inputs(MetaItems.ADVANCED_ALLOY_PLATE.getStackForm()).input(OrePrefix.dust, Materials.Glass, 3).outputs(GAMetaBlocks.TRANSPARENT_CASING.getItemVariant(GATransparentCasing.CasingType.REINFORCED_GLASS, 4)).buildAndRegister();
		RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().duration(400).EUt(4).inputs(MetaItems.ADVANCED_ALLOY_PLATE.getStackForm(), new ItemStack(Blocks.GLASS, 3)).outputs(GAMetaBlocks.TRANSPARENT_CASING.getItemVariant(GATransparentCasing.CasingType.REINFORCED_GLASS, 4)).buildAndRegister();

		//Machine Components
		ModHandler.removeRecipes(MetaItems.EMITTER_LV.getStackForm());
		ModHandler.removeRecipes(MetaItems.EMITTER_MV.getStackForm());
		ModHandler.removeRecipes(MetaItems.EMITTER_HV.getStackForm());
		ModHandler.removeRecipes(MetaItems.EMITTER_EV.getStackForm());
		ModHandler.removeRecipes(MetaItems.EMITTER_IV.getStackForm());

		ModHandler.removeRecipes(MetaItems.SENSOR_LV.getStackForm());
		ModHandler.removeRecipes(MetaItems.SENSOR_MV.getStackForm());
		ModHandler.removeRecipes(MetaItems.SENSOR_HV.getStackForm());
		ModHandler.removeRecipes(MetaItems.SENSOR_EV.getStackForm());
		ModHandler.removeRecipes(MetaItems.SENSOR_IV.getStackForm());

		ModHandler.removeRecipes(MetaItems.ROBOT_ARM_LV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ROBOT_ARM_MV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ROBOT_ARM_HV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ROBOT_ARM_EV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ROBOT_ARM_IV.getStackForm());

		ModHandler.removeRecipes(MetaItems.FIELD_GENERATOR_LV.getStackForm());
		ModHandler.removeRecipes(MetaItems.FIELD_GENERATOR_MV.getStackForm());
		ModHandler.removeRecipes(MetaItems.FIELD_GENERATOR_HV.getStackForm());
		ModHandler.removeRecipes(MetaItems.FIELD_GENERATOR_EV.getStackForm());
		ModHandler.removeRecipes(MetaItems.FIELD_GENERATOR_IV.getStackForm());

		ModHandler.removeRecipes(MetaItems.ELECTRIC_PUMP_LV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ELECTRIC_PUMP_MV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ELECTRIC_PUMP_HV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ELECTRIC_PUMP_EV.getStackForm());
		ModHandler.removeRecipes(MetaItems.ELECTRIC_PUMP_IV.getStackForm());

		ModHandler.addShapedRecipe("ga_lv_emitter", MetaItems.EMITTER_LV.getStackForm(), "RRS", "CGR", "SCR", 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Brass), 'S', "circuitBasic", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin), 'G', OreDictUnifier.get(OrePrefix.gem, Materials.Quartzite));
		ModHandler.addShapedRecipe("ga_mv_emitter", MetaItems.EMITTER_MV.getStackForm(), "RRS", "CGR", "SCR", 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Electrum), 'S', "circuitGood", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper), 'G', OreDictUnifier.get(OrePrefix.gem, Materials.NetherQuartz));
		ModHandler.addShapedRecipe("ga_hv_emitter", MetaItems.EMITTER_HV.getStackForm(), "RRS", "CGR", "SCR", 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Chrome), 'S', "circuitAdvanced", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Gold), 'G', OreDictUnifier.get(OrePrefix.gem, Materials.Emerald));
		ModHandler.addShapedRecipe("ga_ev_emitter", MetaItems.EMITTER_EV.getStackForm(), "RRS", "CGR", "SCR", 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Platinum), 'S', "circuitExtreme", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Aluminium), 'G', OreDictUnifier.get(OrePrefix.gem, Materials.EnderPearl));
		ModHandler.addShapedRecipe("ga_iv_emitter", MetaItems.EMITTER_IV.getStackForm(), "RRS", "CGR", "SCR", 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Osmium), 'S', "circuitElite", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tungsten), 'G', OreDictUnifier.get(OrePrefix.gem, Materials.EnderEye));

		ModHandler.addShapedRecipe("ga_lv_sensor", MetaItems.SENSOR_LV.getStackForm(), "P G", "PR ", "SPP", 'P', "plateSteel", 'G', "gemQuartzite", 'R', "stickBrass", 'S', "circuitBasic");
		ModHandler.addShapedRecipe("ga_mv_sensor", MetaItems.SENSOR_MV.getStackForm(), "P G", "PR ", "SPP", 'P', "plateAluminium", 'G', "gemNetherQuartz", 'R', "stickElectrum", 'S', "circuitGood");
		ModHandler.addShapedRecipe("ga_hv_sensor", MetaItems.SENSOR_HV.getStackForm(), "P G", "PR ", "SPP", 'P', "plateStainlessSteel", 'G', "gemEmerald", 'R', "stickChrome", 'S', "circuitAdvanced");
		ModHandler.addShapedRecipe("ga_ev_sensor", MetaItems.SENSOR_EV.getStackForm(), "P G", "PR ", "SPP", 'P', "plateTitanium", 'G', "gemEnderPearl", 'R', "stickPlatinum", 'S', "circuitExtreme");
		ModHandler.addShapedRecipe("ga_iv_sensor", MetaItems.SENSOR_IV.getStackForm(), "P G", "PR ", "SPP", 'P', "plateTungstenSteel", 'G', "gemEnderEye", 'R', "stickOsmium", 'S', "circuitElite");

		ModHandler.addShapedRecipe("ga_lv_robot_arm", MetaItems.ROBOT_ARM_LV.getStackForm(), "CCC", "MRM", "PSR", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin), 'M', MetaItems.ELECTRIC_MOTOR_LV.getStackForm(), 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Steel), 'P', MetaItems.ELECTRIC_PISTON_LV.getStackForm(), 'S', "circuitBasic");
		ModHandler.addShapedRecipe("ga_mv_robot_arm", MetaItems.ROBOT_ARM_MV.getStackForm(), "CCC", "MRM", "PSR", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper), 'M', MetaItems.ELECTRIC_MOTOR_MV.getStackForm(), 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Aluminium), 'P', MetaItems.ELECTRIC_PISTON_MV.getStackForm(), 'S', "circuitGood");
		ModHandler.addShapedRecipe("ga_hv_robot_arm", MetaItems.ROBOT_ARM_HV.getStackForm(), "CCC", "MRM", "PSR", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Gold), 'M', MetaItems.ELECTRIC_MOTOR_HV.getStackForm(), 'R', OreDictUnifier.get(OrePrefix.stick, Materials.StainlessSteel), 'P', MetaItems.ELECTRIC_PISTON_HV.getStackForm(), 'S', "circuitAdvanced");
		ModHandler.addShapedRecipe("ga_ev_robot_arm", MetaItems.ROBOT_ARM_EV.getStackForm(), "CCC", "MRM", "PSR", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Aluminium), 'M', MetaItems.ELECTRIC_MOTOR_EV.getStackForm(), 'R', OreDictUnifier.get(OrePrefix.stick, Materials.Titanium), 'P', MetaItems.ELECTRIC_PISTON_EV.getStackForm(), 'S', "circuitExtreme");
		ModHandler.addShapedRecipe("ga_iv_robot_arm", MetaItems.ROBOT_ARM_IV.getStackForm(), "CCC", "MRM", "PSR", 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tungsten), 'M', MetaItems.ELECTRIC_MOTOR_IV.getStackForm(), 'R', OreDictUnifier.get(OrePrefix.stick, Materials.TungstenSteel), 'P', MetaItems.ELECTRIC_PISTON_IV.getStackForm(), 'S', "circuitElite");

		ModHandler.addShapedRecipe("ga_lv_field_generator", MetaItems.FIELD_GENERATOR_LV.getStackForm(), "WSW", "SGS", "WSW", 'W', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Osmium), 'S', "circuitBasic", 'G', OreDictUnifier.get(OrePrefix.gem, Materials.EnderPearl));
		ModHandler.addShapedRecipe("ga_mv_field_generator", MetaItems.FIELD_GENERATOR_MV.getStackForm(), "WSW", "SGS", "WSW", 'W', OreDictUnifier.get(OrePrefix.wireGtDouble, Materials.Osmium), 'S', "circuitGood", 'G', OreDictUnifier.get(OrePrefix.gem, Materials.EnderEye));
		ModHandler.addShapedRecipe("ga_hv_field_generator", MetaItems.FIELD_GENERATOR_HV.getStackForm(), "WSW", "SGS", "WSW", 'W', OreDictUnifier.get(OrePrefix.wireGtQuadruple, Materials.Osmium), 'S', "circuitAdvanced", 'G', MetaItems.QUANTUM_EYE.getStackForm());
		ModHandler.addShapedRecipe("ga_ev_field_generator", MetaItems.FIELD_GENERATOR_EV.getStackForm(), "WSW", "SGS", "WSW", 'W', OreDictUnifier.get(OrePrefix.wireGtOctal, Materials.Osmium), 'S', "circuitExtreme", 'G', OreDictUnifier.get(OrePrefix.gem, Materials.NetherStar));
		ModHandler.addShapedRecipe("iga_v_field_generator", MetaItems.FIELD_GENERATOR_IV.getStackForm(), "WSW", "SGS", "WSW", 'W', OreDictUnifier.get(OrePrefix.wireGtHex, Materials.Osmium), 'S', "circuitElite", 'G', MetaItems.QUANTUM_STAR.getStackForm());

		ModHandler.addShapedRecipe("lv_electric_pump_paper", MetaItems.ELECTRIC_PUMP_LV.getStackForm(), "SRH", "dPw", "HMC", 'S', OreDictUnifier.get(OrePrefix.screw, Materials.Tin), 'R', OreDictUnifier.get(OrePrefix.rotor, Materials.Tin), 'H', OreDictUnifier.get(OrePrefix.ring, Materials.Paper), 'P', OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Bronze), 'M', MetaItems.ELECTRIC_MOTOR_LV.getStackForm(), 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin));
		for (MaterialStack stackFluid : cableFluids) {
			IngotMaterial m = (IngotMaterial) stackFluid.material;
			ModHandler.addShapedRecipe("lv_electric_pump_" + m.toString(), MetaItems.ELECTRIC_PUMP_LV.getStackForm(), "SRH", "dPw", "HMC", 'S', OreDictUnifier.get(OrePrefix.screw, Materials.Tin), 'R', OreDictUnifier.get(OrePrefix.rotor, Materials.Tin), 'H', OreDictUnifier.get(OrePrefix.ring, m), 'P', OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Bronze), 'M', MetaItems.ELECTRIC_MOTOR_LV.getStackForm(), 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin));
			ModHandler.addShapedRecipe("mv_electric_pump_" + m.toString(), MetaItems.ELECTRIC_PUMP_MV.getStackForm(), "SRH", "dPw", "HMC", 'S', OreDictUnifier.get(OrePrefix.screw, Materials.Bronze), 'R', OreDictUnifier.get(OrePrefix.rotor, Materials.Bronze), 'H', OreDictUnifier.get(OrePrefix.ring, m), 'P', OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Steel), 'M', MetaItems.ELECTRIC_MOTOR_MV.getStackForm(), 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper));
			ModHandler.addShapedRecipe("hv_electric_pump_" + m.toString(), MetaItems.ELECTRIC_PUMP_HV.getStackForm(), "SRH", "dPw", "HMC", 'S', OreDictUnifier.get(OrePrefix.screw, Materials.Steel), 'R', OreDictUnifier.get(OrePrefix.rotor, Materials.Steel), 'H', OreDictUnifier.get(OrePrefix.ring, m), 'P', OreDictUnifier.get(OrePrefix.pipeMedium, Materials.StainlessSteel), 'M', MetaItems.ELECTRIC_MOTOR_HV.getStackForm(), 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Gold));
			ModHandler.addShapedRecipe("ev_electric_pump_" + m.toString(), MetaItems.ELECTRIC_PUMP_EV.getStackForm(), "SRH", "dPw", "HMC", 'S', OreDictUnifier.get(OrePrefix.screw, Materials.StainlessSteel), 'R', OreDictUnifier.get(OrePrefix.rotor, Materials.StainlessSteel), 'H', OreDictUnifier.get(OrePrefix.ring, m), 'P', OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Titanium), 'M', MetaItems.ELECTRIC_MOTOR_EV.getStackForm(), 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Aluminium));
			ModHandler.addShapedRecipe("iv_electric_pump_" + m.toString(), MetaItems.ELECTRIC_PUMP_IV.getStackForm(), "SRH", "dPw", "HMC", 'S', OreDictUnifier.get(OrePrefix.screw, Materials.TungstenSteel), 'R', OreDictUnifier.get(OrePrefix.rotor, Materials.TungstenSteel), 'H', OreDictUnifier.get(OrePrefix.ring, m), 'P', OreDictUnifier.get(OrePrefix.pipeMedium, Materials.TungstenSteel), 'M', MetaItems.ELECTRIC_MOTOR_IV.getStackForm(), 'C', OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tungsten));
		}

		//Automatic Machine Component Recipes
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(30).inputs(CountableIngredient.from(OrePrefix.circuit, Tier.Basic, 4), CountableIngredient.from(OrePrefix.dust, Materials.EnderPearl)).fluidInputs(Materials.Osmium.getFluid(288)).outputs(MetaItems.FIELD_GENERATOR_LV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(120).inputs(CountableIngredient.from(OrePrefix.circuit, Tier.Good, 4), CountableIngredient.from(OrePrefix.dust, Materials.EnderEye)).fluidInputs(Materials.Osmium.getFluid(576)).outputs(MetaItems.FIELD_GENERATOR_MV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(480).inputs(CountableIngredient.from(OrePrefix.circuit, Tier.Advanced, 4), CountableIngredient.from(MetaItems.QUANTUM_EYE.getStackForm())).fluidInputs(Materials.Osmium.getFluid(1152)).outputs(MetaItems.FIELD_GENERATOR_HV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(1920).inputs(CountableIngredient.from(OrePrefix.circuit, MarkerMaterials.Tier.Extreme, 4), CountableIngredient.from(OrePrefix.dust, Materials.NetherStar)).fluidInputs(Materials.Osmium.getFluid(2304)).outputs(MetaItems.FIELD_GENERATOR_EV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(7680).inputs(CountableIngredient.from(OrePrefix.circuit, Tier.Elite, 4), CountableIngredient.from(MetaItems.QUANTUM_STAR.getStackForm())).fluidInputs(Materials.Osmium.getFluid(4608)).outputs(MetaItems.FIELD_GENERATOR_IV.getStackForm()).buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(10).inputs(CountableIngredient.from(OrePrefix.cableGtSingle, Materials.Tin, 2), CountableIngredient.from(OrePrefix.stick, Materials.Iron, 2), CountableIngredient.from(OrePrefix.stick, Materials.IronMagnetic)).fluidInputs(Materials.Copper.getFluid(288)).outputs(MetaItems.ELECTRIC_MOTOR_LV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(10).inputs(CountableIngredient.from(OrePrefix.cableGtSingle, Materials.Tin, 2), CountableIngredient.from(OrePrefix.stick, Materials.Steel, 2), CountableIngredient.from(OrePrefix.stick, Materials.SteelMagnetic)).fluidInputs(Materials.Copper.getFluid(288)).outputs(MetaItems.ELECTRIC_MOTOR_LV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(40).inputs(CountableIngredient.from(OrePrefix.cableGtSingle, Materials.Copper, 2), CountableIngredient.from(OrePrefix.stick, Materials.Aluminium, 2), CountableIngredient.from(OrePrefix.stick, Materials.SteelMagnetic)).fluidInputs(Materials.Copper.getFluid(576)).outputs(MetaItems.ELECTRIC_MOTOR_MV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(160).inputs(CountableIngredient.from(OrePrefix.cableGtSingle, Materials.Gold, 2), CountableIngredient.from(OrePrefix.stick, Materials.StainlessSteel, 2), CountableIngredient.from(OrePrefix.stick, Materials.SteelMagnetic)).fluidInputs(Materials.Copper.getFluid(1152)).outputs(MetaItems.ELECTRIC_MOTOR_HV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(640).inputs(CountableIngredient.from(OrePrefix.cableGtSingle, Materials.Aluminium, 2), CountableIngredient.from(OrePrefix.stick, Materials.Titanium, 2), CountableIngredient.from(OrePrefix.stick, Materials.NeodymiumMagnetic)).fluidInputs(Materials.AnnealedCopper.getFluid(2304)).outputs(MetaItems.ELECTRIC_MOTOR_EV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(2560).inputs(CountableIngredient.from(OrePrefix.cableGtSingle, Materials.Tungsten, 2), CountableIngredient.from(OrePrefix.stick, Materials.TungstenSteel, 2), CountableIngredient.from(OrePrefix.stick, Materials.NeodymiumMagnetic)).fluidInputs(Materials.AnnealedCopper.getFluid(4608)).outputs(MetaItems.ELECTRIC_MOTOR_IV.getStackForm()).buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(15).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin), MetaItems.ELECTRIC_MOTOR_LV.getStackForm(2)).fluidInputs(Materials.Rubber.getFluid(864)).outputs(MetaItems.CONVEYOR_MODULE_LV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(60).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper), MetaItems.ELECTRIC_MOTOR_MV.getStackForm(2)).fluidInputs(Materials.Rubber.getFluid(864)).outputs(MetaItems.CONVEYOR_MODULE_MV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(240).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Gold), MetaItems.ELECTRIC_MOTOR_HV.getStackForm(2)).fluidInputs(Materials.Rubber.getFluid(864)).outputs(MetaItems.CONVEYOR_MODULE_HV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(960).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Aluminium), MetaItems.ELECTRIC_MOTOR_EV.getStackForm(2)).fluidInputs(Materials.Rubber.getFluid(864)).outputs(MetaItems.CONVEYOR_MODULE_EV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(3840).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tungsten), MetaItems.ELECTRIC_MOTOR_IV.getStackForm(2)).fluidInputs(Materials.Rubber.getFluid(864)).outputs(MetaItems.CONVEYOR_MODULE_IV.getStackForm()).buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(15).input(OrePrefix.circuit, Tier.Basic, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tin, 2), OreDictUnifier.get(OrePrefix.gem, Materials.Quartzite)).fluidInputs(Materials.Brass.getFluid(576)).outputs(MetaItems.EMITTER_LV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(60).input(OrePrefix.circuit, Tier.Good, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Copper, 2), OreDictUnifier.get(OrePrefix.gem, Materials.NetherQuartz)).fluidInputs(Materials.Electrum.getFluid(576)).outputs(MetaItems.EMITTER_MV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(240).input(OrePrefix.circuit, Tier.Advanced, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Gold, 2), OreDictUnifier.get(OrePrefix.gem, Materials.Emerald)).fluidInputs(Materials.Chrome.getFluid(576)).outputs(MetaItems.EMITTER_HV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(960).input(OrePrefix.circuit, MarkerMaterials.Tier.Extreme, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Aluminium, 2), OreDictUnifier.get(OrePrefix.gem, Materials.EnderPearl)).fluidInputs(Materials.Platinum.getFluid(576)).outputs(MetaItems.EMITTER_EV.getStackForm()).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(600).EUt(3840).input(OrePrefix.circuit, Tier.Elite, 2).inputs(OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Tungsten, 2), OreDictUnifier.get(OrePrefix.gem, Materials.EnderEye)).fluidInputs(Materials.Osmium.getFluid(576)).outputs(MetaItems.EMITTER_IV.getStackForm()).buildAndRegister();

		//Pyrolise Oven Recipes
		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(0).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.Creosote.getFluid(4000)).duration(440).EUt(64).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(1).fluidInputs(Materials.Nitrogen.getFluid(400)).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.Creosote.getFluid(4000)).duration(200).EUt(96).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(2).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Ash, 4)).fluidOutputs(Materials.OilHeavy.getFluid(200)).duration(280).EUt(192).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(3).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.WoodVinegar.getFluid(3000)).duration(640).EUt(64).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(4).fluidInputs(Materials.Nitrogen.getFluid(400)).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.WoodVinegar.getFluid(3000)).duration(320).EUt(96).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(5).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.WoodGas.getFluid(1500)).duration(640).EUt(64).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(6).fluidInputs(Materials.Nitrogen.getFluid(400)).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.WoodGas.getFluid(1500)).duration(320).EUt(96).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(7).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.WoodTar.getFluid(1500)).duration(640).EUt(64).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(8).fluidInputs(Materials.Nitrogen.getFluid(400)).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.WoodTar.getFluid(1500)).duration(320).EUt(96).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().input(OrePrefix.log, Materials.Wood, 16).circuitMeta(9).fluidInputs(Materials.Nitrogen.getFluid(400)).outputs(new ItemStack(Items.COAL, 20, 1)).fluidOutputs(Materials.CharcoalByproducts.getFluid(4000)).duration(320).EUt(96).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().inputs(new ItemStack(Items.SUGAR, 23)).circuitMeta(1).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal, 12)).fluidOutputs(Materials.Water.getFluid(1500)).duration(640).EUt(64).buildAndRegister();

		RecipeMaps.PYROLYSE_RECIPES.recipeBuilder().inputs(new ItemStack(Items.SUGAR, 23)).circuitMeta(2).fluidInputs(Materials.Nitrogen.getFluid(400)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal, 12)).fluidOutputs(Materials.Water.getFluid(1500)).duration(320).EUt(96).buildAndRegister();

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

		//Distillation Recipes
		RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(16).EUt(96).fluidInputs(GAMaterials.FISH_OIL.getFluid(24)).fluidOutputs(Materials.Lubricant.getFluid(12)).buildAndRegister();

		//Fluid Heater Recipes
		RecipeMaps.FLUID_HEATER_RECIPES.recipeBuilder().duration(16).EUt(30).circuitMeta(1).fluidInputs(Materials.Acetone.getFluid(100)).fluidOutputs(Materials.Ethenone.getFluid(100)).buildAndRegister();
		RecipeMaps.FLUID_HEATER_RECIPES.recipeBuilder().duration(16).EUt(30).circuitMeta(1).fluidInputs(Materials.CalciumAcetate.getFluid(200)).fluidOutputs(Materials.Acetone.getFluid(200)).buildAndRegister();
		RecipeMaps.FLUID_HEATER_RECIPES.recipeBuilder().duration(30).EUt(24).circuitMeta(1).fluidInputs(GAMaterials.RAW_GROWTH_MEDIUM.getFluid(500)).fluidOutputs(GAMaterials.STERILE_GROWTH_MEDIUM.getFluid(500)).buildAndRegister();

		//Fermenter Recipe
		RecipeMaps.FERMENTING_RECIPES.recipeBuilder().duration(150).EUt(2).fluidInputs(Materials.Biomass.getFluid(100)).fluidOutputs(Materials.FermentedBiomass.getFluid(100)).buildAndRegister();

		//Oil Extractor Recipes
		RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH)).fluidOutputs(GAMaterials.FISH_OIL.getFluid(40)).buildAndRegister();
		RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH, 1, 1)).fluidOutputs(GAMaterials.FISH_OIL.getFluid(60)).buildAndRegister();
		RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH, 1, 2)).fluidOutputs(GAMaterials.FISH_OIL.getFluid(70)).buildAndRegister();
		RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.FISH, 1, 3)).fluidOutputs(GAMaterials.FISH_OIL.getFluid(30)).buildAndRegister();

		//Misc Blast Furnace Recipes
		RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Pentlandite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Garnierite), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();
		RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(120).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Pyrite).fluidInputs(Materials.Oxygen.getFluid(3000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.BandedIron), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.SulfurDioxide.getFluid(1000)).buildAndRegister();

		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Garnierite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Nickel, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.BandedIron, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();

		RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.SiliconDioxide).input(OrePrefix.dust, Materials.Carbon, 2).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Silicon), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash)).fluidOutputs(Materials.CarbonMonoxde.getFluid(2000)).buildAndRegister();

		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Malachite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Copper, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(3000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Magnetite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.GraniticMineralSand, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.BrownLimonite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.YellowLimonite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.BasalticMineralSand, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.Cassiterite, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Tin, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(240).EUt(120).blastFurnaceTemp(1200).input(OrePrefix.dust, Materials.CassiteriteSand, 2).input(OrePrefix.dust, Materials.Carbon).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Tin, 3), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Ash, 2)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();

		for (MaterialStack ore : ironOres) {
			Material materials = ore.material;
			RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(500).EUt(120).blastFurnaceTemp(1500).input(OrePrefix.ore, materials).input(OrePrefix.dust, Materials.Calcite).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 3), OreDictUnifier.get(OrePrefix.dustSmall, Materials.DarkAsh)).buildAndRegister();
			RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(500).EUt(120).blastFurnaceTemp(1500).input(OrePrefix.ore, materials).input(OrePrefix.dustTiny, Materials.Quicklime, 3).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Iron, 2), OreDictUnifier.get(OrePrefix.dustSmall, Materials.DarkAsh)).buildAndRegister();
		}

		//RecipeMaps.BLAST_RECIPES.recipeBuilder().duration(944).EUt(120).input(OrePrefix.dust, Materials.Silicon).notConsumable(new IntCircuitIngredient(1)).blastFurnaceTemp(1687).outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.Silicon)).buildAndRegister();

		//Misc Centrifuging
		RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder().duration(300).EUt(192).fluidInputs(Materials.LeadZincSolution.getFluid(8000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Lead), OreDictUnifier.get(OrePrefix.dust, Materials.Silver), OreDictUnifier.get(OrePrefix.dust, Materials.Zinc), OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 3)).fluidOutputs(Materials.Water.getFluid(2000)).buildAndRegister();

		//Mince Meat Recipes
		RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16).inputs(new ItemStack(Items.PORKCHOP)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, GAMaterials.MEAT, 6)).buildAndRegister();
		RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16).inputs(new ItemStack(Items.BEEF)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, GAMaterials.MEAT, 6)).buildAndRegister();
		RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(60).EUt(16).inputs(new ItemStack(Items.RABBIT)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, GAMaterials.MEAT, 6)).buildAndRegister();
		RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(40).EUt(16).inputs(new ItemStack(Items.CHICKEN)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.MEAT)).buildAndRegister();
		RecipeMaps.MACERATOR_RECIPES.recipeBuilder().duration(40).EUt(16).inputs(new ItemStack(Items.MUTTON)).outputs(OreDictUnifier.get(OrePrefix.dust, GAMaterials.MEAT)).buildAndRegister();

		//Ash-Related Recipes
		RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder().duration(250).EUt(6).input(OrePrefix.dust, Materials.DarkAsh).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Ash), OreDictUnifier.get(OrePrefix.dust, Materials.Carbon)).buildAndRegister();
		RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder().duration(240).EUt(30).input(OrePrefix.dust, Materials.Ash).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Quicklime, 2), 9900, 0).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Potash), 6400, 0).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Magnesia), 6000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.PhosphorousPentoxide), 500, 0).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.SodaAsh), 5000, 0).buildAndRegister();

		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(80).EUt(30).input(OrePrefix.dust, Materials.Quicklime).fluidInputs(Materials.CarbonDioxide.getFluid(1000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Calcite)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(80).EUt(30).input(OrePrefix.dust, Materials.Magnesia).fluidInputs(Materials.CarbonDioxide.getFluid(1000)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Magnesite)).buildAndRegister();

		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(30).input(OrePrefix.dust, Materials.Calcite).notConsumable(new IntCircuitIngredient(1)).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Quicklime)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(30).input(OrePrefix.dust, Materials.Magnesite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Magnesia)).fluidOutputs(Materials.CarbonDioxide.getFluid(1000)).buildAndRegister();

		ModHandler.addShapedRecipe("assline_casing", GAMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GAMultiblockCasing.CasingType.TUNGSTENSTEEL_GEARBOX_CASING, 2), "PhP", "AFA", "PwP", 'P', "plateSteel", 'A', MetaItems.ROBOT_ARM_IV.getStackForm(), 'F', OreDictUnifier.get(OrePrefix.frameGt, Materials.TungstenSteel));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_assembler_casing"));
		ModHandler.addShapedRecipe("ga_assmbler_casing", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING, 3), "CCC", "CFC", "CMC", 'C', "circuitElite", 'F', "frameGtTungstenSteel", 'M', MetaItems.ELECTRIC_MOTOR_IV.getStackForm());

		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(160).EUt(16).inputs(new ItemStack(Items.SUGAR, 4), OreDictUnifier.get(OrePrefix.dust, GAMaterials.MEAT), OreDictUnifier.get(OrePrefix.dustTiny, Materials.Salt)).fluidInputs(Materials.DistilledWater.getFluid(4000)).fluidOutputs(GAMaterials.RAW_GROWTH_MEDIUM.getFluid(4000)).buildAndRegister();

	}

	public static void init2() {
		//Fuel Rabbit Hole - Layer 1
		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(20).EUt(480).fluidInputs(Materials.BioDiesel.getFluid(1000), Materials.Tetranitromethane.getFluid(40)).fluidOutputs(Materials.NitroFuel.getFluid(750)).buildAndRegister();
		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(20).EUt(480).fluidInputs(Materials.Fuel.getFluid(1000), Materials.Tetranitromethane.getFluid(20)).fluidOutputs(Materials.NitroFuel.getFluid(1000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(1000).EUt(388).notConsumable(new IntCircuitIngredient(1)).fluidInputs(Materials.NitrogenDioxide.getFluid(1000), Materials.Hydrogen.getFluid(3000), Materials.Oxygen.getFluid(500)).fluidOutputs(Materials.Water.getFluid(4000), Materials.RocketFuel.getFluid(3000)).buildAndRegister();
		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(60).EUt(16).fluidInputs(Materials.Oxygen.getFluid(1000), Materials.Dimethylhydrazine.getFluid(1000)).fluidOutputs(Materials.RocketFuel.getFluid(3000)).buildAndRegister();
		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(60).EUt(16).fluidInputs(Materials.DinitrogenTetroxide.getFluid(1000), Materials.Dimethylhydrazine.getFluid(1000)).fluidOutputs(Materials.RocketFuel.getFluid(6000)).buildAndRegister();
		RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder().duration(20).EUt(5).fluidInputs(Materials.Butane.getFluid(320)).fluidOutputs(Materials.LPG.getFluid(370)).buildAndRegister();
		RecipeMaps.CENTRIFUGE_RECIPES.recipeBuilder().duration(20).EUt(5).fluidInputs(Materials.Propane.getFluid(320)).fluidOutputs(Materials.LPG.getFluid(290)).buildAndRegister();
		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(16).EUt(120).fluidInputs(Materials.LightFuel.getFluid(5000), Materials.HeavyFuel.getFluid(1000)).fluidOutputs(Materials.Fuel.getFluid(6000)).buildAndRegister();

		//Fuel Rabbit Hole - Layer 2
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(480).EUt(120).fluidInputs(Materials.NitricAcid.getFluid(8000), Materials.Ethenone.getFluid(1000)).fluidOutputs(Materials.Tetranitromethane.getFluid(2000), Materials.Water.getFluid(9000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(480).EUt(30).notConsumable(new IntCircuitIngredient(3)).fluidInputs(Materials.Oxygen.getFluid(7000), Materials.Ammonia.getFluid(2000)).fluidOutputs(Materials.DinitrogenTetroxide.getFluid(1000), Materials.Water.getFluid(3000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(640).EUt(30).notConsumable(new IntCircuitIngredient(2)).fluidInputs(Materials.NitrogenDioxide.getFluid(2000)).fluidOutputs(Materials.DinitrogenTetroxide.getFluid(1000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(1100).EUt(480).notConsumable(new IntCircuitIngredient(23)).fluidInputs(Materials.Oxygen.getFluid(7000), Materials.Nitrogen.getFluid(2000), Materials.Hydrogen.getFluid(6000)).fluidOutputs(Materials.DinitrogenTetroxide.getFluid(1000), Materials.Water.getFluid(3000)).buildAndRegister();

		//Fuel Rabbit Hole - Layer 3
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).notConsumable(new IntCircuitIngredient(2)).fluidInputs(Materials.Oxygen.getFluid(4000), Materials.Ammonia.getFluid(1000)).fluidOutputs(Materials.NitricAcid.getFluid(1000), Materials.Water.getFluid(1000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(30).notConsumable(new IntCircuitIngredient(4)).fluidInputs(Materials.Water.getFluid(1000), Materials.Oxygen.getFluid(1000), Materials.NitrogenDioxide.getFluid(2000)).fluidOutputs(Materials.NitricAcid.getFluid(2000)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(480).notConsumable(new IntCircuitIngredient(24)).fluidInputs(Materials.Oxygen.getFluid(4000), Materials.Nitrogen.getFluid(1000), Materials.Hydrogen.getFluid(3000)).fluidOutputs(Materials.NitricAcid.getFluid(1000), Materials.Water.getFluid(1000)).buildAndRegister();

		//Assline Recipes
		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.stickLong, Materials.NeodymiumMagnetic, 1), OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSG, 2), OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 64), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 2)).fluidInputs(Materials.SolderingAlloy.getFluid(144), Materials.Lubricant.getFluid(250)).outputs(MetaItems.ELECTRIC_MOTOR_LUV.getStackForm()).duration(600).EUt(10240).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.stickLong, Materials.NeodymiumMagnetic, 2), OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSE, 4), OreDictUnifier.get(OrePrefix.ring, Materials.HSSE, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSE, 16), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 2)).fluidInputs(Materials.SolderingAlloy.getFluid(288), Materials.Lubricant.getFluid(750)).outputs(MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm()).duration(600).EUt(40960).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.block, Materials.NeodymiumMagnetic, 1), OreDictUnifier.get(OrePrefix.stickLong, GAMaterials.NEUTRONIUM, 4), OreDictUnifier.get(OrePrefix.ring, GAMaterials.NEUTRONIUM, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), GAMaterials.NEUTRONIUM, 16), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 64), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 64), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 64), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 2)).fluidInputs(Materials.SolderingAlloy.getFluid(1296), Materials.Lubricant.getFluid(2000)).outputs(MetaItems.ELECTRIC_MOTOR_UV.getStackForm()).duration(600).EUt(163840).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(), OreDictUnifier.get(OrePrefix.pipeSmall, Materials.Ultimet, 2), OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 2), OreDictUnifier.get(OrePrefix.screw, Materials.HSSG, 8), OreDictUnifier.get(OrePrefix.ring, Materials.SiliconeRubber, 4), OreDictUnifier.get(OrePrefix.rotor, Materials.HSSG, 2), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 2)).fluidInputs(Materials.SolderingAlloy.getFluid(144), Materials.Lubricant.getFluid(250)).outputs(MetaItems.ELECTRIC_PUMP_LUV.getStackForm()).duration(600).EUt(15360).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(), OreDictUnifier.get(OrePrefix.pipeMedium, Materials.Ultimet, 2), OreDictUnifier.get(OrePrefix.plate, Materials.HSSE, 2), OreDictUnifier.get(OrePrefix.screw, Materials.HSSE, 8), OreDictUnifier.get(OrePrefix.ring, Materials.SiliconeRubber, 16), OreDictUnifier.get(OrePrefix.rotor, Materials.HSSE, 2), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 2)).fluidInputs(Materials.SolderingAlloy.getFluid(288), Materials.Lubricant.getFluid(750)).outputs(MetaItems.ELECTRIC_PUMP_ZPM.getStackForm()).duration(600).EUt(61440).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_UV.getStackForm(), OreDictUnifier.get(OrePrefix.pipeLarge, Materials.Ultimet, 2), OreDictUnifier.get(OrePrefix.plate, GAMaterials.NEUTRONIUM, 2), OreDictUnifier.get(OrePrefix.screw, GAMaterials.NEUTRONIUM, 8), OreDictUnifier.get(OrePrefix.ring, Materials.SiliconeRubber, 16), OreDictUnifier.get(OrePrefix.rotor, GAMaterials.NEUTRONIUM, 2), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 2)).fluidInputs(Materials.SolderingAlloy.getFluid(1296), Materials.Lubricant.getFluid(2000)).outputs(MetaItems.ELECTRIC_PUMP_UV.getStackForm()).duration(600).EUt(245760).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(2), OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 2), OreDictUnifier.get(OrePrefix.ring, Materials.HSSG, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSG, 32), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 2)).notConsumable(new IntCircuitIngredient(1)).fluidInputs(Materials.StyreneButadieneRubber.getFluid(1440), Materials.Lubricant.getFluid(250)).outputs(MetaItems.CONVEYOR_MODULE_LUV.getStackForm()).duration(600).EUt(15360).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(2), OreDictUnifier.get(OrePrefix.plate, Materials.HSSE, 2), OreDictUnifier.get(OrePrefix.ring, Materials.HSSE, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSE, 32), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 2)).notConsumable(new IntCircuitIngredient(1)).fluidInputs(Materials.StyreneButadieneRubber.getFluid(2880), Materials.Lubricant.getFluid(750)).outputs(MetaItems.CONVEYOR_MODULE_ZPM.getStackForm()).duration(600).EUt(61440).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_UV.getStackForm(2), OreDictUnifier.get(OrePrefix.plate, GAMaterials.NEUTRONIUM, 2), OreDictUnifier.get(OrePrefix.ring, GAMaterials.NEUTRONIUM, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), GAMaterials.NEUTRONIUM, 32), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 2)).notConsumable(new IntCircuitIngredient(1)).fluidInputs(Materials.StyreneButadieneRubber.getFluid(2880), Materials.Lubricant.getFluid(2000)).outputs(MetaItems.CONVEYOR_MODULE_UV.getStackForm()).duration(600).EUt(245760).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 6), OreDictUnifier.get(OrePrefix.ring, Materials.HSSG, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSG, 32), OreDictUnifier.get(OrePrefix.stick, Materials.HSSG, 4), OreDictUnifier.get(OrePrefix.gear, Materials.HSSG, 1), OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSG, 2), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 4)).notConsumable(new IntCircuitIngredient(2)).fluidInputs(Materials.SolderingAlloy.getFluid(144), Materials.Lubricant.getFluid(250)).outputs(MetaItems.ELECTRIC_PISTON_LUV.getStackForm()).duration(600).EUt(15360).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.HSSE, 6), OreDictUnifier.get(OrePrefix.ring, Materials.HSSE, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), Materials.HSSE, 32), OreDictUnifier.get(OrePrefix.stick, Materials.HSSE, 4), OreDictUnifier.get(OrePrefix.gear, Materials.HSSE, 1), OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSE, 2), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 4)).notConsumable(new IntCircuitIngredient(2)).fluidInputs(Materials.SolderingAlloy.getFluid(288), Materials.Lubricant.getFluid(750)).outputs(MetaItems.ELECTRIC_PISTON_ZPM.getStackForm()).duration(600).EUt(61440).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.ELECTRIC_MOTOR_UV.getStackForm(), OreDictUnifier.get(OrePrefix.plate, GAMaterials.NEUTRONIUM, 6), OreDictUnifier.get(OrePrefix.ring, GAMaterials.NEUTRONIUM, 4), OreDictUnifier.get(OrePrefix.valueOf("round"), GAMaterials.NEUTRONIUM, 32), OreDictUnifier.get(OrePrefix.stick, GAMaterials.NEUTRONIUM, 4), OreDictUnifier.get(OrePrefix.gear, GAMaterials.NEUTRONIUM, 1), OreDictUnifier.get(OrePrefix.gearSmall, GAMaterials.NEUTRONIUM, 2), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 4)).notConsumable(new IntCircuitIngredient(2)).fluidInputs(Materials.SolderingAlloy.getFluid(1296), Materials.Lubricant.getFluid(2000)).outputs(MetaItems.ELECTRIC_PISTON_UV.getStackForm()).duration(600).EUt(245760).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSG, 4), OreDictUnifier.get(OrePrefix.gear, Materials.HSSG, 1), OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSG, 3), MetaItems.ELECTRIC_MOTOR_LUV.getStackForm(2), MetaItems.ELECTRIC_PISTON_LUV.getStackForm(), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 6)).input(OrePrefix.circuit, Tier.Master, 2).input(OrePrefix.circuit, Tier.Elite, 2).input(OrePrefix.circuit, MarkerMaterials.Tier.Extreme, 6).fluidInputs(Materials.SolderingAlloy.getFluid(576), Materials.Lubricant.getFluid(250)).outputs(MetaItems.ROBOT_ARM_LUV.getStackForm()).duration(600).EUt(20480).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.stickLong, Materials.HSSE, 4), OreDictUnifier.get(OrePrefix.gear, Materials.HSSE, 1), OreDictUnifier.get(OrePrefix.gearSmall, Materials.HSSE, 3), MetaItems.ELECTRIC_MOTOR_ZPM.getStackForm(2), MetaItems.ELECTRIC_PISTON_ZPM.getStackForm(), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 6)).input(OrePrefix.circuit, Tier.Master, 4).input(OrePrefix.circuit, Tier.Elite, 4).input(OrePrefix.circuit, MarkerMaterials.Tier.Extreme, 12).fluidInputs(Materials.SolderingAlloy.getFluid(1152), Materials.Lubricant.getFluid(750)).outputs(MetaItems.ROBOT_ARM_ZPM.getStackForm()).duration(600).EUt(81920).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.stickLong, GAMaterials.NEUTRONIUM, 4), OreDictUnifier.get(OrePrefix.gear, GAMaterials.NEUTRONIUM, 1), OreDictUnifier.get(OrePrefix.gearSmall, GAMaterials.NEUTRONIUM, 3), MetaItems.ELECTRIC_MOTOR_UV.getStackForm(2), MetaItems.ELECTRIC_PISTON_UV.getStackForm(), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 6)).input(OrePrefix.circuit, Tier.Master, 8).input(OrePrefix.circuit, Tier.Elite, 8).input(OrePrefix.circuit, MarkerMaterials.Tier.Extreme, 24).fluidInputs(Materials.SolderingAlloy.getFluid(2304), Materials.Lubricant.getFluid(2000)).outputs(MetaItems.ROBOT_ARM_UV.getStackForm()).duration(600).EUt(327680).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSG, 1), MetaItems.EMITTER_IV.getStackForm(), MetaItems.EMITTER_EV.getStackForm(2), MetaItems.EMITTER_HV.getStackForm(4), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 7)).input(OrePrefix.circuit, MarkerMaterials.Tier.Extreme, 7).fluidInputs(Materials.SolderingAlloy.getFluid(576)).outputs(MetaItems.EMITTER_LUV.getStackForm()).duration(600).EUt(15360).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSE, 1), MetaItems.EMITTER_LUV.getStackForm(), MetaItems.EMITTER_IV.getStackForm(2), MetaItems.EMITTER_EV.getStackForm(4), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 7)).input(OrePrefix.circuit, Tier.Elite, 7).fluidInputs(Materials.SolderingAlloy.getFluid(576)).outputs(MetaItems.EMITTER_ZPM.getStackForm()).duration(600).EUt(61440).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, GAMaterials.NEUTRONIUM, 1), MetaItems.EMITTER_ZPM.getStackForm(), MetaItems.EMITTER_LUV.getStackForm(2), MetaItems.EMITTER_IV.getStackForm(4), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 7)).input(OrePrefix.circuit, Tier.Master, 7).fluidInputs(Materials.SolderingAlloy.getFluid(576)).outputs(MetaItems.EMITTER_UV.getStackForm()).duration(600).EUt(245760).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSG, 1), MetaItems.SENSOR_IV.getStackForm(), MetaItems.SENSOR_EV.getStackForm(2), MetaItems.SENSOR_HV.getStackForm(4), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 64), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 7)).input(OrePrefix.circuit, MarkerMaterials.Tier.Extreme, 7).fluidInputs(Materials.SolderingAlloy.getFluid(576)).outputs(MetaItems.SENSOR_LUV.getStackForm()).duration(600).EUt(15360).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSE, 1), MetaItems.SENSOR_LUV.getStackForm(), MetaItems.SENSOR_IV.getStackForm(2), MetaItems.SENSOR_EV.getStackForm(4), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 7)).input(OrePrefix.circuit, Tier.Elite, 7).fluidInputs(Materials.SolderingAlloy.getFluid(576)).outputs(MetaItems.SENSOR_ZPM.getStackForm()).duration(600).EUt(61440).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, GAMaterials.NEUTRONIUM, 1), MetaItems.SENSOR_ZPM.getStackForm(), MetaItems.SENSOR_LUV.getStackForm(2), MetaItems.SENSOR_IV.getStackForm(4), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 7)).input(OrePrefix.circuit, Tier.Master, 7).fluidInputs(Materials.SolderingAlloy.getFluid(576)).outputs(MetaItems.SENSOR_UV.getStackForm()).duration(600).EUt(245760).buildAndRegister();

		RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(30).EUt(480).fluidInputs(GAMaterials.POSITIVE_MATTER.getFluid(10), GAMaterials.NEUTRAL_MATTER.getFluid(10)).fluidOutputs(Materials.UUMatter.getFluid(20)).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.HSSG, 1), OreDictUnifier.get(OrePrefix.plate, Materials.HSSG, 6), MetaItems.QUANTUM_STAR.getStackForm(), MetaItems.EMITTER_LUV.getStackForm(4), GAMetaItems.NEURO_PROCESSOR.getStackForm(8), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate, 8)).input(OrePrefix.circuit, Tier.Master, 8).input(OrePrefix.circuit, Tier.Elite, 8).fluidInputs(Materials.SolderingAlloy.getFluid(576)).outputs(MetaItems.FIELD_GENERATOR_LUV.getStackForm()).duration(600).EUt(30720).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, GAMaterials.HSSE, 1), OreDictUnifier.get(OrePrefix.plate, GAMaterials.HSSE, 6), MetaItems.QUANTUM_STAR.getStackForm(4), MetaItems.EMITTER_ZMP.getStackForm(4), MetaItems.CRYSTAL_PROCESSOR_IV.getStackForm(16), GAMetaItems.NEURO_PROCESSOR.getStackForm(16), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.foil, Materials.Osmiridium, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium, 8)).input(OrePrefix.circuit, Tier.Elite, 16).fluidInputs(Materials.SolderingAlloy.getFluid(1152)).outputs(MetaItems.FIELD_GENERATOR_ZPM.getStackForm()).duration(600).EUt(122880).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, GAMaterials.NEUTRONIUM, 1), OreDictUnifier.get(OrePrefix.plate, GAMaterials.NEUTRONIUM, 6), MetaItems.GRAVI_STAR.getStackForm(), MetaItems.EMITTER_UV.getStackForm(4), MetaItems.MULTILAYER_FIBER_BOARD.getStackForm(64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.wireFine, Materials.Osmium, 64), OreDictUnifier.get(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium, 8)).fluidInputs(Materials.SolderingAlloy.getFluid(2304)).outputs(MetaItems.FIELD_GENERATOR_UV.getStackForm()).duration(600).EUt(491520).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Tritanium, 4), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(8), MetaItems.SMALL_COIL.getStackForm(4), MetaItems.SMD_CAPACITOR.getStackForm(24), MetaItems.SMD_RESISTOR.getStackForm(64), MetaItems.SMD_TRANSISTOR.getStackForm(32), MetaItems.SMD_DIODE.getStackForm(16), MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 32), OreDictUnifier.get(OrePrefix.foil, Materials.SiliconeRubber, 64)).fluidInputs(Materials.SolderingAlloy.getFluid(2880), Materials.Water.getFluid(10000)).outputs(MetaItems.WETWARE_MAINFRAME_MAX.getStackForm()).duration(2000).EUt(300000).buildAndRegister();

		RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder().duration(600).EUt(512).inputs(new ItemStack(Items.EGG)).chancedOutput(GAMetaItems.STEM_CELLS.getStackForm(), 2500, 0).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaItems.WETWARE_BOARD.getStackForm(), GAMetaItems.STEM_CELLS.getStackForm(8), MetaItems.GLASS_TUBE.getStackForm(8), OreDictUnifier.get(OrePrefix.foil, Materials.SiliconeRubber, 64)).input(OrePrefix.plate, Materials.Gold, 8).input(OrePrefix.plate, Materials.StainlessSteel, 4).fluidInputs(GAMaterials.STERILE_GROWTH_MEDIUM.getFluid(250), Materials.UUMatter.getFluid(100), Materials.Water.getFluid(250), Materials.Lava.getFluid(1000)).outputs(GAMetaItems.NEURO_PROCESSOR.getStackForm()).duration(200).EUt(80000).buildAndRegister();

		ItemStack last_bat = (GAConfig.GT5U.replaceUVwithMAXBat ? GAMetaItems.MAX_BATTERY : MetaItems.ZPM2).getStackForm();

		if (GAConfig.GT5U.enableZPMandUVBats) {
			GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.plate, Materials.Europium, 16), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm(8), MetaItems.FIELD_GENERATOR_LUV.getStackForm(2), MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(64), MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(64), MetaItems.SMD_DIODE.getStackForm(8), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.Naquadah, 32)).fluidInputs(Materials.SolderingAlloy.getFluid(2880), Materials.Water.getFluid(8000)).outputs(GAMetaItems.ENERGY_MODULE.getStackForm()).duration(2000).EUt(100000).buildAndRegister();

			GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.plate, Materials.Americium, 16), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), MetaItems.WETWARE_SUPER_COMPUTER_UV.getStackForm(), GAMetaItems.ENERGY_MODULE.getStackForm(8), MetaItems.FIELD_GENERATOR_ZPM.getStackForm(2), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64), MetaItems.SMD_DIODE.getStackForm(16), OreDictUnifier.get(OrePrefix.cableGtSingle, Materials.NaquadahAlloy, 32)).fluidInputs(Materials.SolderingAlloy.getFluid(2880), Materials.Water.getFluid(16000)).outputs(GAMetaItems.ENERGY_CLUSTER.getStackForm()).duration(2000).EUt(200000).buildAndRegister();

			GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.plate, GAMaterials.NEUTRONIUM, 16), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), GAMetaItems.ENERGY_CLUSTER.getStackForm(8), MetaItems.FIELD_GENERATOR_UV.getStackForm(2), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64), MetaItems.SMD_DIODE.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 32)).fluidInputs(Materials.SolderingAlloy.getFluid(2880), Materials.Water.getFluid(16000), Materials.Naquadria.getFluid(1152)).outputs(last_bat).duration(2000).EUt(300000).buildAndRegister();
		} else GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(OreDictUnifier.get(OrePrefix.plate, GAMaterials.NEUTRONIUM, 16), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm(8), MetaItems.FIELD_GENERATOR_UV.getStackForm(2), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64), MetaItems.SMD_DIODE.getStackForm(16), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 32)).fluidInputs(Materials.SolderingAlloy.getFluid(2880), Materials.Water.getFluid(16000)).outputs(last_bat).duration(2000).EUt(300000).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL), OreDictUnifier.get(OrePrefix.plate, Materials.Plutonium241), OreDictUnifier.get(OrePrefix.plate, Materials.NetherStar), MetaItems.FIELD_GENERATOR_IV.getStackForm(2), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(32), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 32)).input(OrePrefix.circuit, Tier.Ultimate).input(OrePrefix.circuit, Tier.Ultimate).input(OrePrefix.circuit, Tier.Ultimate).input(OrePrefix.circuit, Tier.Ultimate).fluidInputs(Materials.SolderingAlloy.getFluid(2880)).outputs(GATileEntities.FUSION_REACTOR[0].getStackForm()).duration(1000).EUt(30000).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL), OreDictUnifier.get(OrePrefix.plate, Materials.Europium, 4), MetaItems.FIELD_GENERATOR_LUV.getStackForm(2), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(48), OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor, 32)).input(OrePrefix.circuit, Tier.Superconductor).input(OrePrefix.circuit, Tier.Superconductor).input(OrePrefix.circuit, Tier.Superconductor).input(OrePrefix.circuit, Tier.Superconductor).fluidInputs(Materials.SolderingAlloy.getFluid(2880)).outputs(GATileEntities.FUSION_REACTOR[1].getStackForm()).duration(1000).EUt(60000).buildAndRegister();

		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder().inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), MetaItems.WETWARE_MAINFRAME_MAX.getStackForm(), OreDictUnifier.get(OrePrefix.plate, Materials.Americium, 4), MetaItems.FIELD_GENERATOR_ZPM.getStackForm(2), MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(64), OreDictUnifier.get(OrePrefix.wireGtQuadruple, Tier.Superconductor, 32)).fluidInputs(Materials.SolderingAlloy.getFluid(2880)).outputs(GATileEntities.FUSION_REACTOR[2].getStackForm()).duration(1000).EUt(90000).buildAndRegister();

		//Star Recipes
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(60000).EUt(8).input(OrePrefix.ingot, Materials.Plutonium, 3).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Plutonium, 3)).fluidOutputs(Materials.Radon.getFluid(50)).buildAndRegister();
		RecipeMaps.AUTOCLAVE_RECIPES.recipeBuilder().duration(480).EUt(7680).inputs(new ItemStack(Items.NETHER_STAR)).fluidInputs(GAMaterials.NEUTRONIUM.getFluid(288)).outputs(MetaItems.GRAVI_STAR.getStackForm()).buildAndRegister();

		//Fusion Recipes
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Deuterium.getFluid(125), Materials.Tritium.getFluid(125)).fluidOutputs(Materials.Helium.getPlasma(125)).duration(16).EUt(4096).EUToStart(40000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Deuterium.getFluid(125), Materials.Helium3.getFluid(125)).fluidOutputs(Materials.Helium.getPlasma(125)).duration(16).EUt(2048).EUToStart(60000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Carbon.getFluid(125), Materials.Helium3.getFluid(125)).fluidOutputs(Materials.Oxygen.getPlasma(125)).duration(32).EUt(4096).EUToStart(80000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Beryllium.getFluid(16), Materials.Deuterium.getFluid(375)).fluidOutputs(Materials.Nitrogen.getPlasma(175)).duration(16).EUt(16384).EUToStart(180000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Silicon.getFluid(16), Materials.Magnesium.getFluid(16)).fluidOutputs(Materials.Iron.getPlasma(125)).duration(32).EUt(8192).EUToStart(360000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Potassium.getFluid(16), Materials.Fluorine.getFluid(125)).fluidOutputs(Materials.Nickel.getPlasma(125)).duration(16).EUt(32768).EUToStart(480000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Beryllium.getFluid(16), Materials.Tungsten.getFluid(16)).fluidOutputs(Materials.Platinum.getFluid(16)).duration(32).EUt(32768).EUToStart(150000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Neodymium.getFluid(16), Materials.Hydrogen.getFluid(48)).fluidOutputs(Materials.Europium.getFluid(16)).duration(64).EUt(24576).EUToStart(150000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Lutetium.getFluid(16), Materials.Chrome.getFluid(16)).fluidOutputs(Materials.Americium.getFluid(16)).duration(96).EUt(49152).EUToStart(200000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Plutonium.getFluid(16), Materials.Thorium.getFluid(16)).fluidOutputs(Materials.Naquadah.getFluid(16)).duration(64).EUt(32768).EUToStart(300000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Americium.getFluid(16), Materials.Naquadria.getFluid(16)).fluidOutputs(GAMaterials.NEUTRONIUM.getFluid(2)).duration(200).EUt(98304).EUToStart(600000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Tungsten.getFluid(16), Materials.Helium.getFluid(16)).fluidOutputs(Materials.Osmium.getFluid(16)).duration(64).EUt(24578).EUToStart(150000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Manganese.getFluid(16), Materials.Hydrogen.getFluid(16)).fluidOutputs(Materials.Iron.getFluid(16)).duration(64).EUt(8192).EUToStart(120000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Mercury.getFluid(16), Materials.Magnesium.getFluid(16)).fluidOutputs(Materials.Uranium.getFluid(16)).duration(64).EUt(49152).EUToStart(240000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Gold.getFluid(16), Materials.Aluminium.getFluid(16)).fluidOutputs(Materials.Uranium.getFluid(16)).duration(64).EUt(49152).EUToStart(240000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Uranium.getFluid(16), Materials.Helium.getFluid(16)).fluidOutputs(Materials.Plutonium.getFluid(16)).duration(128).EUt(49152).EUToStart(480000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Vanadium.getFluid(16), Materials.Hydrogen.getFluid(125)).fluidOutputs(Materials.Chrome.getFluid(16)).duration(64).EUt(24576).EUToStart(140000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Gallium.getFluid(16), Materials.Radon.getFluid(125)).fluidOutputs(Materials.Duranium.getFluid(16)).duration(64).EUt(16384).EUToStart(140000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Titanium.getFluid(48), Materials.Duranium.getFluid(32)).fluidOutputs(Materials.Tritanium.getFluid(16)).duration(64).EUt(32768).EUToStart(200000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Gold.getFluid(16), Materials.Mercury.getFluid(16)).fluidOutputs(Materials.Radon.getFluid(125)).duration(64).EUt(32768).EUToStart(200000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Tantalum.getFluid(16), Materials.Tritium.getFluid(16)).fluidOutputs(Materials.Tungsten.getFluid(16)).duration(16).EUt(24576).EUToStart(200000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Silver.getFluid(16), Materials.Lithium.getFluid(16)).fluidOutputs(Materials.Indium.getFluid(16)).duration(32).EUt(24576).EUToStart(380000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.NaquadahEnriched.getFluid(15), Materials.Radon.getFluid(125)).fluidOutputs(Materials.Naquadria.getFluid(3)).duration(64).EUt(49152).EUToStart(400000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Lithium.getFluid(16), Materials.Tungsten.getFluid(16)).fluidOutputs(Materials.Iridium.getFluid(16)).duration(32).EUt(32768).EUToStart(300000000).buildAndRegister();
		RecipeMaps.FUSION_RECIPES.recipeBuilder().fluidInputs(Materials.Lanthanum.getFluid(16), Materials.Silicon.getFluid(16)).fluidOutputs(Materials.Lutetium.getFluid(16)).duration(16).EUt(8192).EUToStart(80000000).buildAndRegister();

		//FUsion Casing Recipes
		ModHandler.addShapedRecipe("fusion_casing_1", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING), "PhP", "PHP", "PwP", 'P', "plateTungstenSteel", 'H', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV));
		ModHandler.addShapedRecipe("fusion_casing_2", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING_MK2), "PhP", "PHP", "PwP", 'P', "plateAmericium", 'H', MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING));
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().EUt(16).inputs(MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING)).input(OrePrefix.plate, Materials.Americium, 6).outputs(MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING_MK2)).duration(50).buildAndRegister();

		ModHandler.addShapedRecipe("fusion_coil", MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL), "CRC", "FSF", "CRC", 'C', "circuitMaster", 'R', MetaItems.NEUTRON_REFLECTOR.getStackForm(), 'F', MetaItems.FIELD_GENERATOR_MV.getStackForm(), 'S', MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.SUPERCONDUCTOR));

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(4000).EUt(120).inputs(MetaItems.PLATE_IRIDIUM_ALLOY.getStackForm()).input(OrePrefix.plate, Materials.Beryllium, 30).input(OrePrefix.plate, Materials.TungstenCarbide, 3).fluidInputs(Materials.TinAlloy.getFluid(13824)).outputs(MetaItems.NEUTRON_REFLECTOR.getStackForm()).buildAndRegister();

		//Explosive Recipes
		ModHandler.removeRecipes(new ItemStack(Blocks.TNT));
		ModHandler.removeRecipes(MetaItems.DYNAMITE.getStackForm());
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(4).inputs(new ItemStack(Items.PAPER), new ItemStack(Items.STRING)).fluidInputs(Materials.Glyceryl.getFluid(500)).outputs(MetaItems.DYNAMITE.getStackForm()).buildAndRegister();

		//Electromagnetic Separator Recipes
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.BrownLimonite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.BrownLimonite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.YellowLimonite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.YellowLimonite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Nickel).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Nickel)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Pentlandite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Pentlandite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.BandedIron).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.BandedIron)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Ilmenite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Ilmenite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Pyrite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Pyrite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Tin).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Tin)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Chromite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Chromite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Iron), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Iron), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Monazite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Monazite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Neodymium), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Neodymium), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Bastnasite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Bastnasite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Neodymium), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Neodymium), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.VanadiumMagnetite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.VanadiumMagnetite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Gold), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Gold), 2000, 0).buildAndRegister();
		RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder().duration(400).EUt(24).input(OrePrefix.dustPure, Materials.Magnetite).outputs(OreDictUnifier.get(OrePrefix.dust, Materials.Magnetite)).chancedOutput(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Gold), 4000, 0).chancedOutput(OreDictUnifier.get(OrePrefix.nugget, Materials.Gold), 2000, 0).buildAndRegister();

		//Lapotron Crystal Recipes
		for (MaterialStack m : lapisLike) {
			GemMaterial gem = (GemMaterial) m.material;
			ModHandler.addShapedRecipe("lapotron_crystal_shaped" + gem.toString(), MetaItems.LAPOTRON_CRYSTAL.getStackForm(), "PCP", "RFR", "PCP", 'P', new UnificationEntry(OrePrefix.plate, gem), 'C', "circuitAdvanced", 'R', OreDictUnifier.get(OrePrefix.stick, gem), 'F', OreDictUnifier.get(OrePrefix.gemFlawless, Materials.Sapphire));
			ModHandler.addShapelessRecipe("lapotron_crystal_shapeless" + gem.toString(), MetaItems.LAPOTRON_CRYSTAL.getStackForm(), OreDictUnifier.get(OrePrefix.gemExquisite, Materials.Sapphire), OreDictUnifier.get(OrePrefix.stick, gem), MetaItems.CAPACITOR.getStackForm());
		}

		//Add Missing Superconducter Wire Tiering Recipes
		ModHandler.addShapelessRecipe("superonducter_wire_gtsingle_doubling", OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor));
		ModHandler.addShapelessRecipe("superonducter_wire_gtdouble_doubling", OreDictUnifier.get(OrePrefix.wireGtQuadruple, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor));
		ModHandler.addShapelessRecipe("superonducter_wire_gtquadruple_doubling", OreDictUnifier.get(OrePrefix.wireGtOctal, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtQuadruple, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtQuadruple, Tier.Superconductor));
		ModHandler.addShapelessRecipe("superonducter_wire_gtoctal_doubling", OreDictUnifier.get(OrePrefix.wireGtHex, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtOctal, Tier.Superconductor), OreDictUnifier.get(OrePrefix.wireGtOctal, Tier.Superconductor));
		ModHandler.addShapelessRecipe("superonducter_wire_gtdouble_splitting", OreDictUnifier.get(OrePrefix.wireGtSingle, Tier.Superconductor, 2), OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor));
		ModHandler.addShapelessRecipe("superonducter_wire_gtquadruple_splitting", OreDictUnifier.get(OrePrefix.wireGtDouble, Tier.Superconductor, 2), OreDictUnifier.get(OrePrefix.wireGtQuadruple, Tier.Superconductor));
		ModHandler.addShapelessRecipe("superonducter_wire_gtoctal_splitting", OreDictUnifier.get(OrePrefix.wireGtQuadruple, Tier.Superconductor, 2), OreDictUnifier.get(OrePrefix.wireGtOctal, Tier.Superconductor));
		ModHandler.addShapelessRecipe("superonducter_wire_gthex_splitting", OreDictUnifier.get(OrePrefix.wireGtOctal, Tier.Superconductor, 2), OreDictUnifier.get(OrePrefix.wireGtHex, Tier.Superconductor));

		//Dust Packing
		for (Material m : Material.MATERIAL_REGISTRY) {
			if (!OreDictUnifier.get(OrePrefix.dust, m).isEmpty() && GAConfig.Misc.PackagerDustRecipes) {
				RecipeMaps.PACKER_RECIPES.recipeBuilder().duration(100).EUt(4).input(OrePrefix.dustSmall, m, 4).notConsumable(GAMetaItems.SCHEMATIC_DUST.getStackForm()).outputs(OreDictUnifier.get(OrePrefix.dust, m)).buildAndRegister();
				RecipeMaps.PACKER_RECIPES.recipeBuilder().duration(100).EUt(4).input(OrePrefix.dustTiny, m, 9).notConsumable(GAMetaItems.SCHEMATIC_DUST.getStackForm()).outputs(OreDictUnifier.get(OrePrefix.dust, m)).buildAndRegister();
			}
		}

		//Schematic Recipes
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(3200).EUt(4).input(OrePrefix.circuit, Tier.Good, 4).input(OrePrefix.plate, Materials.StainlessSteel, 2).outputs(GAMetaItems.SCHEMATIC.getStackForm()).buildAndRegister();
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:schematic/schematic_1"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:schematic/schematic_c"));

		//Configuration Circuit
		//ModHandler.removeRecipes(MetaItems.BASIC_CIRCUIT_LV.getStackForm());
		ModHandler.removeRecipes(MetaItems.INTEGRATED_CIRCUIT.getStackForm());
		ModHandler.addShapelessRecipe("basic_to_configurable_circuit", MetaItems.INTEGRATED_CIRCUIT.getStackForm(), "circuitBasic");

		//MAX Machine Hull
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_max"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:hull_max"));
		ModHandler.addShapedRecipe("ga_casing_max", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, GAMaterials.NEUTRONIUM));
		ModHandler.addShapedRecipe("ga_hull_max", MetaTileEntities.HULL[GTValues.MAX].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX), 'C', new UnificationEntry(OrePrefix.wireGtSingle, Tier.Superconductor), 'H', new UnificationEntry(OrePrefix.plate, GAMaterials.NEUTRONIUM), 'P', new UnificationEntry(OrePrefix.plate, Materials.Polytetrafluoroethylene));
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(16).input(OrePrefix.plate, GAMaterials.NEUTRONIUM, 8).outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX)).circuitMeta(8).duration(50).buildAndRegister();
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder().duration(50).EUt(16).inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.MAX)).input(OrePrefix.wireGtSingle, Tier.Superconductor, 2).fluidInputs(Materials.Polytetrafluoroethylene.getFluid(288)).outputs(MetaTileEntities.HULL[9].getStackForm()).buildAndRegister();

		OreDictionary.getOres("treeLeaves").stream().flatMap(stack -> ModHandler.getAllSubItems(stack).stream()).collect(Collectors.toList());

		List<ItemStack> allSaplings = OreDictionary.getOres("treeSapling").stream().flatMap(stack -> ModHandler.getAllSubItems(stack).stream()).collect(Collectors.toList());

		//Biomass Process
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(1440).EUt(3).inputs(MetaItems.PLANT_BALL.getStackForm()).fluidInputs(Materials.Water.getFluid(180)).fluidOutputs(Materials.Biomass.getFluid(180)).buildAndRegister();
		for (ItemStack stack : allSaplings)
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(800).EUt(3).inputs(GTUtility.copyAmount(1, stack)).fluidInputs(Materials.Water.getFluid(100)).fluidOutputs(Materials.Biomass.getFluid(100)).buildAndRegister();
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(160).EUt(3).inputs(new ItemStack(Items.POTATO)).fluidInputs(Materials.Water.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(20)).buildAndRegister();
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(160).EUt(3).inputs(new ItemStack(Items.CARROT)).fluidInputs(Materials.Water.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(20)).buildAndRegister();
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(160).EUt(3).inputs(new ItemStack(Blocks.CACTUS)).fluidInputs(Materials.Water.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(20)).buildAndRegister();
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(160).EUt(3).inputs(new ItemStack(Items.REEDS)).fluidInputs(Materials.Water.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(20)).buildAndRegister();
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(160).EUt(3).inputs(new ItemStack(Blocks.BROWN_MUSHROOM)).fluidInputs(Materials.Water.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(20)).buildAndRegister();
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(160).EUt(3).inputs(new ItemStack(Blocks.RED_MUSHROOM)).fluidInputs(Materials.Water.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(20)).buildAndRegister();
		RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(160).EUt(3).inputs(new ItemStack(Items.BEETROOT)).fluidInputs(Materials.Water.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(20)).buildAndRegister();

		for (ItemStack stack : allSaplings)
			RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(GTUtility.copyAmount(8, stack)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Items.WHEAT, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Items.POTATO, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Items.CARROT, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Blocks.CACTUS, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Items.REEDS, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Blocks.BROWN_MUSHROOM, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Blocks.RED_MUSHROOM, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();
		RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(300).EUt(2).inputs(new ItemStack(Items.BEETROOT, 8)).outputs(MetaItems.PLANT_BALL.getStackForm()).buildAndRegister();

		//Redstone and glowstone melting
		RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(80).EUt(32).input(OrePrefix.dust, Materials.Redstone).fluidOutputs(Materials.Redstone.getFluid(144)).buildAndRegister();
		RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(80).EUt(32).input(OrePrefix.dust, Materials.Glowstone).fluidOutputs(Materials.Glowstone.getFluid(144)).buildAndRegister();

		//Gem Tool Part Fixes
		for (Material material : Material.MATERIAL_REGISTRY) {
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
		for (Material m : Material.MATERIAL_REGISTRY) {
			if (!OreDictUnifier.get(OrePrefix.dustSmall, m).isEmpty()) {
				ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.dustSmall, m));
				ModHandler.addShapedRecipe("dust_small_" + m.toString(), OreDictUnifier.get(OrePrefix.dustSmall, m, 4), " D", "  ", 'D', new UnificationEntry(OrePrefix.dust, m));
			}
		}

		ModHandler.addShapedRecipe("3x3_schematic", GAMetaItems.SCHEMATIC_3X3.getStackForm(), "  d", " S ", "   ", 'S', GAMetaItems.SCHEMATIC.getStackForm());
		ModHandler.addShapedRecipe("2x2_schematic", GAMetaItems.SCHEMATIC_2X2.getStackForm(), " d ", " S ", "   ", 'S', GAMetaItems.SCHEMATIC.getStackForm());
		ModHandler.addShapedRecipe("dust_schematic", GAMetaItems.SCHEMATIC_DUST.getStackForm(), "   ", " S ", "  d", 'S', GAMetaItems.SCHEMATIC.getStackForm());

	}

	public static void forestrySupport() {
		//Distillation Support
		if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) {
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(16).EUt(96).fluidInputs(Fluids.SEED_OIL.getFluid(24)).fluidOutputs(Materials.Lubricant.getFluid(12)).buildAndRegister();
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(40).EUt(256).fluidInputs(Materials.WoodVinegar.getFluid(1000)).fluidOutputs(Materials.AceticAcid.getFluid(100), Materials.Water.getFluid(500), Fluids.BIO_ETHANOL.getFluid(10), Materials.Methanol.getFluid(300), Materials.Acetone.getFluid(50), Materials.MethylAcetate.getFluid(10)).buildAndRegister();
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(75).EUt(180).fluidInputs(Materials.FermentedBiomass.getFluid(1000)).fluidOutputs(Materials.AceticAcid.getFluid(25), Materials.Water.getFluid(375), Fluids.BIO_ETHANOL.getFluid(150), Materials.Methanol.getFluid(150), Materials.Ammonia.getFluid(100), Materials.CarbonDioxide.getFluid(400), Materials.Methane.getFluid(600)).buildAndRegister();
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(32).EUt(400).fluidInputs(Materials.Biomass.getFluid(1000)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Wood, 2)).fluidOutputs(Fluids.BIO_ETHANOL.getFluid(600), Materials.Water.getFluid(300)).buildAndRegister();
		} else {
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(16).EUt(96).fluidInputs(Materials.SeedOil.getFluid(24)).fluidOutputs(Materials.Lubricant.getFluid(12)).buildAndRegister();
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(40).EUt(256).fluidInputs(Materials.WoodVinegar.getFluid(1000)).fluidOutputs(Materials.AceticAcid.getFluid(100), Materials.Water.getFluid(500), Materials.Ethanol.getFluid(10), Materials.Methanol.getFluid(300), Materials.Acetone.getFluid(50), Materials.MethylAcetate.getFluid(10)).buildAndRegister();
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(75).EUt(180).fluidInputs(Materials.FermentedBiomass.getFluid(1000)).fluidOutputs(Materials.AceticAcid.getFluid(25), Materials.Water.getFluid(375), Materials.Ethanol.getFluid(150), Materials.Methanol.getFluid(150), Materials.Ammonia.getFluid(100), Materials.CarbonDioxide.getFluid(400), Materials.Methane.getFluid(600)).buildAndRegister();
			RecipeMaps.DISTILLATION_RECIPES.recipeBuilder().duration(32).EUt(400).fluidInputs(Materials.Biomass.getFluid(1000)).outputs(OreDictUnifier.get(OrePrefix.dustSmall, Materials.Wood, 2)).fluidOutputs(Materials.Ethanol.getFluid(600), Materials.Water.getFluid(300)).buildAndRegister();
		}

		//Extracting Seed Oil
		if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) {
			RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(128).EUt(5).inputs(new ItemStack(Items.WHEAT_SEEDS)).fluidOutputs(Fluids.SEED_OIL.getFluid(10)).buildAndRegister();
			RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(128).EUt(5).inputs(new ItemStack(Items.MELON_SEEDS)).fluidOutputs(Fluids.SEED_OIL.getFluid(10)).buildAndRegister();
			RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(128).EUt(5).inputs(new ItemStack(Items.PUMPKIN_SEEDS)).fluidOutputs(Fluids.SEED_OIL.getFluid(10)).buildAndRegister();
		} else {
			RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(32).EUt(2).inputs(new ItemStack(Items.WHEAT_SEEDS)).fluidOutputs(Materials.SeedOil.getFluid(10)).buildAndRegister();
			RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(32).EUt(2).inputs(new ItemStack(Items.MELON_SEEDS)).fluidOutputs(Materials.SeedOil.getFluid(10)).buildAndRegister();
			RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(32).EUt(2).inputs(new ItemStack(Items.PUMPKIN_SEEDS)).fluidOutputs(Materials.SeedOil.getFluid(10)).buildAndRegister();
			RecipeMaps.FLUID_EXTRACTION_RECIPES.recipeBuilder().duration(32).EUt(2).inputs(new ItemStack(Items.BEETROOT_SEEDS)).fluidOutputs(Materials.SeedOil.getFluid(10)).buildAndRegister();
		}

		//Making BioDiesel
		if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) {
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(Fluids.SEED_OIL.getFluid(6000), Materials.Methanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(Fluids.SEED_OIL.getFluid(6000), Fluids.BIO_ETHANOL.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(GAMaterials.FISH_OIL.getFluid(6000), Materials.Methanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(GAMaterials.FISH_OIL.getFluid(6000), Fluids.BIO_ETHANOL.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
		} else {
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(Materials.SeedOil.getFluid(6000), Materials.Methanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(Materials.SeedOil.getFluid(6000), Materials.Ethanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(GAMaterials.FISH_OIL.getFluid(6000), Materials.Methanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
			RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(30).input(OrePrefix.dustTiny, Materials.SodiumHydroxide).fluidInputs(GAMaterials.FISH_OIL.getFluid(6000), Materials.Ethanol.getFluid(1000)).fluidOutputs(Materials.Glycerol.getFluid(1000), Materials.BioDiesel.getFluid(6000)).buildAndRegister();
		}

		//Lube Mixer Recipes
		for (MaterialStack lubeDust : lubeDusts) {
			DustMaterial dust = (DustMaterial) lubeDust.material;
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(128).EUt(4).input(OrePrefix.dust, dust).fluidInputs(Materials.Oil.getFluid(750)).fluidOutputs(Materials.Lubricant.getFluid(750)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(128).EUt(4).input(OrePrefix.dust, dust).fluidInputs(Materials.Creosote.getFluid(750)).fluidOutputs(Materials.Lubricant.getFluid(750)).buildAndRegister();
			if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(128).EUt(4).input(OrePrefix.dust, dust).fluidInputs(Fluids.SEED_OIL.getFluid(750)).fluidOutputs(Materials.Lubricant.getFluid(750)).buildAndRegister();
			else RecipeMaps.MIXER_RECIPES.recipeBuilder().duration(128).EUt(4).input(OrePrefix.dust, dust).fluidInputs(Materials.SeedOil.getFluid(750)).fluidOutputs(Materials.Lubricant.getFluid(750)).buildAndRegister();
		}

		List<ItemStack> allSaplings = OreDictionary.getOres("treeSapling").stream().flatMap(stack -> ModHandler.getAllSubItems(stack).stream()).collect(Collectors.toList());

		//Biomass
		if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) {
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(2880).EUt(3).inputs(MetaItems.PLANT_BALL.getStackForm()).fluidInputs(Fluids.FOR_HONEY.getFluid(180)).fluidOutputs(Materials.Biomass.getFluid(270)).buildAndRegister();
			for (ItemStack stack : allSaplings)
				RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(1200).EUt(3).inputs(GTUtility.copyAmount(1, stack)).fluidInputs(Fluids.FOR_HONEY.getFluid(100)).fluidOutputs(Materials.Biomass.getFluid(150)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.POTATO)).fluidInputs(Fluids.FOR_HONEY.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.CARROT)).fluidInputs(Fluids.FOR_HONEY.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Blocks.CACTUS)).fluidInputs(Fluids.FOR_HONEY.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.REEDS)).fluidInputs(Fluids.FOR_HONEY.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Blocks.BROWN_MUSHROOM)).fluidInputs(Fluids.FOR_HONEY.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Blocks.RED_MUSHROOM)).fluidInputs(Fluids.FOR_HONEY.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.BEETROOT)).fluidInputs(Fluids.FOR_HONEY.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
		}

		if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) {
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(2880).EUt(3).inputs(MetaItems.PLANT_BALL.getStackForm()).fluidInputs(Fluids.JUICE.getFluid(180)).fluidOutputs(Materials.Biomass.getFluid(270)).buildAndRegister();
			for (ItemStack stack : allSaplings)
				RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(1200).EUt(3).inputs(GTUtility.copyAmount(1, stack)).fluidInputs(Fluids.JUICE.getFluid(100)).fluidOutputs(Materials.Biomass.getFluid(150)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.POTATO)).fluidInputs(Fluids.JUICE.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.CARROT)).fluidInputs(Fluids.JUICE.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Blocks.CACTUS)).fluidInputs(Fluids.JUICE.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.REEDS)).fluidInputs(Fluids.JUICE.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Blocks.BROWN_MUSHROOM)).fluidInputs(Fluids.JUICE.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Blocks.RED_MUSHROOM)).fluidInputs(Fluids.JUICE.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
			RecipeMaps.BREWING_RECIPES.recipeBuilder().duration(320).EUt(3).inputs(new ItemStack(Items.BEETROOT)).fluidInputs(Fluids.JUICE.getFluid(20)).fluidOutputs(Materials.Biomass.getFluid(30)).buildAndRegister();
		}

		//Making Ethylene
		if (Loader.isModLoaded("forestry") && GAConfig.Misc.ForestryIntegration) RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(1200).EUt(120).fluidInputs(Materials.SulfuricAcid.getFluid(1000), Fluids.BIO_ETHANOL.getFluid(1000)).fluidOutputs(Materials.Ethylene.getFluid(1000), Materials.DilutedSulfuricAcid.getFluid(1000)).buildAndRegister();

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
						if (GAConfig.GT5U.Remove3x3BlockRecipes) recipesToRemove.add(recipe.getRegistryName());
						if (GAConfig.GT5U.GenerateCompressorRecipes) RecipeMaps.COMPRESSOR_RECIPES.recipeBuilder().duration(400).EUt(2).inputs(CountableIngredient.from(recipe.getIngredients().get(0).getMatchingStacks()[0], recipe.getIngredients().size())).outputs(recipe.getRecipeOutput()).buildAndRegister();
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
						RecipeMaps.PACKER_RECIPES.recipeBuilder().duration(100).EUt(4).inputs(CountableIngredient.from(recipe.getIngredients().get(0).getMatchingStacks()[0], recipe.getIngredients().size())).notConsumable(GAMetaItems.SCHEMATIC_3X3.getStackForm()).outputs(recipe.getRecipeOutput()).buildAndRegister();
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
						RecipeMaps.PACKER_RECIPES.recipeBuilder().duration(100).EUt(4).inputs(CountableIngredient.from(recipe.getIngredients().get(0).getMatchingStacks()[0], recipe.getIngredients().size())).notConsumable(GAMetaItems.SCHEMATIC_2X2.getStackForm()).outputs(recipe.getRecipeOutput()).buildAndRegister();
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
				if (GAConfig.GT5U.RemoveBlockUncraftingRecipes) recipesToRemove.add(recipe.getRegistryName());
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
			if (recipe.getRecipeOutput().isEmpty()) continue;
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
		List<ItemStack> allWoodLogs = OreDictionary.getOres("logWood").stream().flatMap(stack -> ModHandler.getAllSubItems(stack).stream()).collect(Collectors.toList());

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
