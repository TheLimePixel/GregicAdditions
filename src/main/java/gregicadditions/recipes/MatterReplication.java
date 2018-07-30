package gregicadditions.recipes;

import gregicadditions.GAMaterials;
import gregicadditions.item.GAMetaItems;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.FluidMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;

public class MatterReplication {
    public static void init() {
        //Mass Fab
        GARecipeMaps.MASS_FAB_RECIPES.recipeBuilder().duration((int) (Materials.Hydrogen.getMass() * 1000)).EUt(32).fluidInputs((Materials.Hydrogen.getFluid(1000))).fluidOutputs(GAMaterials.PositiveMatter.getFluid((1))).buildAndRegister();
        for (Material m : FluidMaterial.MATERIAL_REGISTRY) {
            if (m.getProtons() > 0 && m.getNeutrons() > 0 && m.getMass() != 98 && m instanceof FluidMaterial && OreDictUnifier.get(OrePrefix.dust, m).isEmpty()) {
                GARecipeMaps.MASS_FAB_RECIPES.recipeBuilder().duration((int) (m.getMass() * 1000)).EUt(32).fluidInputs(((FluidMaterial) m).getFluid(1000)).fluidOutputs(GAMaterials.PositiveMatter.getFluid((int) m.getProtons()), GAMaterials.NeutralMatter.getFluid((int) m.getNeutrons())).buildAndRegister();
            }
        }
        for (Material m : DustMaterial.MATERIAL_REGISTRY) {
            if (m.getProtons() >= 1 && m.getNeutrons() >= 0 && m.getMass() != 98 && m instanceof DustMaterial) {
                GARecipeMaps.MASS_FAB_RECIPES.recipeBuilder().duration((int) (m.getMass() * 1000)).EUt(32).inputs((OreDictUnifier.get(OrePrefix.dust, m))).fluidOutputs(GAMaterials.PositiveMatter.getFluid((int) m.getProtons()), GAMaterials.NeutralMatter.getFluid((int) m.getNeutrons())).buildAndRegister();
            }
        }

        //Replicator
        GARecipeMaps.REPLICATOR_RECIPES.recipeBuilder().duration((int) (Materials.Hydrogen.getMass() * 1000)).EUt(32).notConsumable(GAMetaItems.getFilledCell((Materials.Hydrogen.getMaterialFluid()))).fluidOutputs((Materials.Hydrogen.getFluid(1000))).fluidInputs(GAMaterials.PositiveMatter.getFluid(1)).buildAndRegister();
        for (Material m : FluidMaterial.MATERIAL_REGISTRY) {
            if (m.getProtons() > 0 && m.getNeutrons() > 0 && m.getMass() != 98 && m instanceof FluidMaterial && OreDictUnifier.get(OrePrefix.dust, m).isEmpty()) {
                GARecipeMaps.REPLICATOR_RECIPES.recipeBuilder().duration((int) (m.getMass() * 1000)).EUt(32).notConsumable(GAMetaItems.getFilledCell(((FluidMaterial) m).getMaterialFluid())).fluidOutputs(((FluidMaterial) m).getFluid(1000)).fluidInputs(GAMaterials.PositiveMatter.getFluid((int) m.getProtons()), GAMaterials.NeutralMatter.getFluid((int) m.getNeutrons())).buildAndRegister();
            }
        }
        for (Material m : DustMaterial.MATERIAL_REGISTRY) {
            if (m.getProtons() >= 1 && m.getNeutrons() >= 0 && m.getMass() != 98 && m instanceof DustMaterial) {
                GARecipeMaps.REPLICATOR_RECIPES.recipeBuilder().duration((int) (m.getMass() * 1000)).EUt(32).notConsumable(OreDictUnifier.get(OrePrefix.dust, m)).outputs((OreDictUnifier.get(OrePrefix.dust, m))).fluidInputs(GAMaterials.PositiveMatter.getFluid((int) m.getProtons()), GAMaterials.NeutralMatter.getFluid((int) m.getNeutrons())).buildAndRegister();
            }
        }
    }
}
