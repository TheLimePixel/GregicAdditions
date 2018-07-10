package gregicadditions.machines;

import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.render.Textures;

public class GATileEntities {
    public static SimpleMachineMetaTileEntity[] CIRCUITASSEMBLER = new SimpleMachineMetaTileEntity[4];
    public static SimpleMachineMetaTileEntity[] CLUSTERMILL = new SimpleMachineMetaTileEntity[4];

    public static void init() {
        CIRCUITASSEMBLER[0] = GregTechAPI.registerMetaTileEntity(2000, new SimpleMachineMetaTileEntity("circuit_assembler.lv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 1));
        CIRCUITASSEMBLER[1] = GregTechAPI.registerMetaTileEntity(2001, new SimpleMachineMetaTileEntity("circuit_assembler.mv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 2));
        CIRCUITASSEMBLER[2] = GregTechAPI.registerMetaTileEntity(2002, new SimpleMachineMetaTileEntity("circuit_assembler.hv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 3));
        CIRCUITASSEMBLER[3] = GregTechAPI.registerMetaTileEntity(2003, new SimpleMachineMetaTileEntity("circuit_assembler.ev", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 4));

        CLUSTERMILL[0] = GregTechAPI.registerMetaTileEntity(2004, new SimpleMachineMetaTileEntity("cluster_mill.lv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 1));
        CLUSTERMILL[1] = GregTechAPI.registerMetaTileEntity(2005, new SimpleMachineMetaTileEntity("cluster_mill.mv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 2));
        CLUSTERMILL[2] = GregTechAPI.registerMetaTileEntity(2006, new SimpleMachineMetaTileEntity("cluster_mill.hv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 3));
        CLUSTERMILL[3] = GregTechAPI.registerMetaTileEntity(2007, new SimpleMachineMetaTileEntity("cluster_mill.ev", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 4));

    }
}
