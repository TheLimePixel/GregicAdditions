package gregicadditions;

import java.util.function.Function;

import gregicadditions.tconstruct.GtRecipes;
import gregicadditions.tconstruct.Materials;
import net.minecraft.util.NonNullList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gregicadditions.bees.CommonProxy;
import gregicadditions.bees.GTBees;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMetaItems;
import gregicadditions.machines.GATileEntities;
import gregicadditions.recipes.GAMachineRecipeRemoval;
import gregicadditions.recipes.GARecipeAddition;
import gregicadditions.recipes.GeneratorFuels;
import gregicadditions.recipes.MachineCraftingRecipes;
import gregicadditions.recipes.MatterReplication;
import gregtech.common.blocks.VariantItemBlock;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import slimeknights.tconstruct.library.events.TinkerRegisterEvent;

@Mod(modid = GregicAdditions.MODID, name = GregicAdditions.NAME, version = GregicAdditions.VERSION, dependencies = "required-after:gregtech@[1.8.6.437,);after:forestry;after:tconstruct")
public class GregicAdditions {
	public static final String MODID = "gtadditions";
	public static final String NAME = "Shadows of Greg";
	public static final String VERSION = "@VERSION@";

	@SidedProxy(modId = MODID, clientSide = "gregicadditions.bees.ClientProxy", serverSide = "gregicadditions.bees.CommonProxy")
	public static CommonProxy proxy;

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public GregicAdditions() {
		GAEnums.preInit();

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GAMetaItems.init();
		GAMetaBlocks.init();
		GATileEntities.init();
		Materials.preInit();
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		if (GAConfig.GTBees.EnableGTCEBees && Loader.isModLoaded("forestry")) GTBees.initBees();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		GARecipeAddition.generatedRecipes();
		if (GAConfig.GTBees.EnableGTCEBees && Loader.isModLoaded("forestry")) proxy.postInit();
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.register(GAMetaBlocks.MUTLIBLOCK_CASING);
		registry.register(GAMetaBlocks.TRANSPARENT_CASING);
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(createItemBlock(GAMetaBlocks.MUTLIBLOCK_CASING, VariantItemBlock::new));
		registry.register(createItemBlock(GAMetaBlocks.TRANSPARENT_CASING, VariantItemBlock::new));
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		GAMachineRecipeRemoval.init();
		GARecipeAddition.init();
		GARecipeAddition.init2();
		GARecipeAddition.forestrySupport();
		MatterReplication.init();
		MachineCraftingRecipes.init();
		GeneratorFuels.init();
		GAMetaItems.registerOreDict();
		GAMetaItems.registerRecipes();
	}

	private <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
		ItemBlock itemBlock = producer.apply(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return itemBlock;
	}

	@Mod.EventBusSubscriber
	public static class events {
		@SubscribeEvent(priority = EventPriority.LOW)
		public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
			GtRecipes.init();
		}

		@SubscribeEvent(priority = EventPriority.HIGH)
		public static void smeltingRemoval(TinkerRegisterEvent.MeltingRegisterEvent event) {
			for (Material mat : Material.MATERIAL_REGISTRY)
				if (mat instanceof IngotMaterial && ((IngotMaterial) mat).blastFurnaceTemperature > 0 && (matches(event, OrePrefix.ore, mat) || matches(event, OrePrefix.dust, mat) || matches(event, OrePrefix.dustSmall, mat) || matches(event, OrePrefix.dustTiny, mat)))
					event.setCanceled(true);
		}

		@SubscribeEvent(priority = EventPriority.HIGH)
		public static void alloyRemoval(TinkerRegisterEvent.AlloyRegisterEvent event) {
			if (event.getRecipe().getResult() == gregtech.api.unification.material.Materials.Brass.getFluid(3))
				event.setCanceled(true);
		}

		private static boolean matches(TinkerRegisterEvent.MeltingRegisterEvent e, OrePrefix prefix, Material mat) {
			return e.getRecipe().input.matches(NonNullList.withSize(1, OreDictUnifier.get(prefix, mat))).isPresent();
		}
	}
}
