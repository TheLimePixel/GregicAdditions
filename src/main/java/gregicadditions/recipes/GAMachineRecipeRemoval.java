package gregicadditions.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GAMachineRecipeRemoval {

    public static void postInit() {
        for (Material m : IngotMaterial.MATERIAL_REGISTRY) {

            //Foil recipes
            removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                    OreDictUnifier.get(OrePrefix.plate, m),
                    IntCircuitIngredient.getIntegratedCircuit(0));

            //Remove Old Rotor Recipe
            if (!OreDictUnifier.get(OrePrefix.rotor,m).isEmpty())
                removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                        OreDictUnifier.get(OrePrefix.plate,m,4),
                        OreDictUnifier.get(OrePrefix.ring,m));
        }
        //Remove Old Bucket Recipe
        removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Iron,12),
                IntCircuitIngredient.getIntegratedCircuit(1));
        removeRecipesByInputs(RecipeMaps.BENDER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.WroughtIron,12),
                IntCircuitIngredient.getIntegratedCircuit(1));

        //Fix Brick Exploit
        removeRecipesByInputs(RecipeMaps.MACERATOR_RECIPES,new ItemStack(Items.BRICK));

        //Remove GTCE Circuit recipes
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Silicon,2),
                OreDictUnifier.get(OrePrefix.plate,Materials.Polytetrafluoroethylene));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Silicon),
                OreDictUnifier.get(OrePrefix.plate,Materials.Plastic));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil,Materials.Platinum),
                OreDictUnifier.get(OrePrefix.lens,MarkerMaterials.Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil,Materials.Gold),
                OreDictUnifier.get(OrePrefix.lens,MarkerMaterials.Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil,Materials.Electrum),
                OreDictUnifier.get(OrePrefix.lens,MarkerMaterials.Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil,Materials.Copper),
                OreDictUnifier.get(OrePrefix.lens,MarkerMaterials.Color.Red));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.foil,Materials.AnnealedCopper),
                OreDictUnifier.get(OrePrefix.lens,MarkerMaterials.Color.Red));
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Lapis),
                OreDictUnifier.get(OrePrefix.dust,Materials.Glowstone));
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Lazurite),
                OreDictUnifier.get(OrePrefix.dust,Materials.Glowstone));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Lazurite,15),
                OreDictUnifier.get(OrePrefix.lens,Materials.Diamond));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Emerald,15),
                OreDictUnifier.get(OrePrefix.lens,MarkerMaterials.Color.Lime));
        removeRecipesByInputs(RecipeMaps.LASER_ENGRAVER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Olivine,15),
                OreDictUnifier.get(OrePrefix.lens,MarkerMaterials.Color.Lime));
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                MetaItems.CIRCUIT_PARTS_WIRING_ELITE.getStackForm(4),
                MetaItems.EMPTY_BOARD_ELITE.getStackForm());
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                MetaItems.CIRCUIT_PARTS_WIRING_ADVANCED.getStackForm(4),
                MetaItems.EMPTY_BOARD_BASIC.getStackForm());
        removeRecipesByInputs(RecipeMaps.FORMING_PRESS_RECIPES,
                MetaItems.CIRCUIT_PARTS_WIRING_BASIC.getStackForm(4),
                MetaItems.EMPTY_BOARD_BASIC.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_MASTER.getStackForm(3),
                MetaItems.EMPTY_BOARD_ELITE.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_DATA.getStackForm(3),
                MetaItems.EMPTY_BOARD_ELITE.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_BOARD_ADVANCED.getStackForm(),
                MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_ELITE.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_PARTS_ADVANCED.getStackForm(2),
                MetaItems.CIRCUIT_ADVANCED.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_PRIMITIVE.getStackForm(2),
                MetaItems.CIRCUIT_BASIC.getStackForm());
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_PRIMITIVE.getStackForm(2),
                MetaItems.CIRCUIT_BOARD_BASIC.getStackForm());
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:basic_circuit"));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Plastic),
                OreDictUnifier.get(OrePrefix.cableGtSingle,Materials.RedAlloy));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                OreDictUnifier.get(OrePrefix.cableGtSingle,Materials.RedAlloy,2),
                OreDictUnifier.get(OrePrefix.plate,Materials.Steel));
        ModHandler.removeRecipeByName(new ResourceLocation("gregtech:primitive_circuit"));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                MetaItems.CIRCUIT_PARTS_CRYSTAL_CHIP_ELITE.getStackForm(18),
                MetaItems.CIRCUIT_ELITE.getStackForm(2));
        removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES,
                OreDictUnifier.get(OrePrefix.plate,Materials.Plastic,2),
                MetaItems.CIRCUIT_DATA.getStackForm());

    }

    private static void removeRecipesByInputs(RecipeMap map, ItemStack... itemInputs) {
        List<ItemStack> inputs = new ArrayList<>();
        for (ItemStack s : itemInputs)
            inputs.add(s);
        map.removeRecipe(map.findRecipe(Integer.MAX_VALUE, inputs, Collections.EMPTY_LIST));
    }
}
