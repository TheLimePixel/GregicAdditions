package gregicadditions.machines;

import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.Textures;

public class GATileEntities {
    public static SimpleMachineMetaTileEntity[] CIRCUITASSEMBLER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] CLUSTERMILL = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] ALLOY_SMELTER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] AMPLIFABRICATOR = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] ARC_FURNACE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] ASSEMBLER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] AUTOCLAVE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] BENDER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] BREWERY = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] CANNER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] CENTRIFUGE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] CHEMICAL_BATH = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] CHEMICAL_REACTOR = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] COMPRESSOR = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] CUTTER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] DISTILLERY = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] ELECTROLYZER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] ELECTROMAGNETIC_SEPARATOR = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] EXTRACTOR = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] EXTRUDER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] FERMENTER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] FLUID_CANNER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] FLUID_EXTRACTOR = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] FLUID_HEATER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] FLUID_SOLIDIFIER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] FORGE_HAMMER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] FORMING_PRESS = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] LATHE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] MICROWAVE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] MIXER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] PLASMA_ARC_FURNACE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] POLARIZER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] LASER_ENGRAVER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] PRINTER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] SIFTER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] THERMAL_CENTRIFUGE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] WIREMILL = new SimpleMachineMetaTileEntity[8];

    public static TileEntityDistillTower DISTILL_TOWER;
    public static TileEntityAssemblyLine ASSEMBLY_LINE;

    public static TileEntityCokeOven COKE_OVEN;

    public static void init() {
        CIRCUITASSEMBLER[0] = GregTechAPI.registerMetaTileEntity(2000, new SimpleMachineMetaTileEntity("circuit_assembler.lv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 1));
        CIRCUITASSEMBLER[1] = GregTechAPI.registerMetaTileEntity(2001, new SimpleMachineMetaTileEntity("circuit_assembler.mv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 2));
        CIRCUITASSEMBLER[2] = GregTechAPI.registerMetaTileEntity(2002, new SimpleMachineMetaTileEntity("circuit_assembler.hv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 3));
        CIRCUITASSEMBLER[3] = GregTechAPI.registerMetaTileEntity(2003, new SimpleMachineMetaTileEntity("circuit_assembler.ev", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 4));
        CIRCUITASSEMBLER[4] = GregTechAPI.registerMetaTileEntity(2004, new SimpleMachineMetaTileEntity("circuit_assembler.iv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 5));
        CIRCUITASSEMBLER[5] = GregTechAPI.registerMetaTileEntity(2005, new SimpleMachineMetaTileEntity("circuit_assembler.luv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 6));
        CIRCUITASSEMBLER[6] = GregTechAPI.registerMetaTileEntity(2006, new SimpleMachineMetaTileEntity("circuit_assembler.zpm", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 7));
        CIRCUITASSEMBLER[7] = GregTechAPI.registerMetaTileEntity(2007, new SimpleMachineMetaTileEntity("circuit_assembler.uv", GARecipeMaps.CIRCUIT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, 8));

        CLUSTERMILL[0] = GregTechAPI.registerMetaTileEntity(2008, new SimpleMachineMetaTileEntity("cluster_mill.lv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 1));
        CLUSTERMILL[1] = GregTechAPI.registerMetaTileEntity(2009, new SimpleMachineMetaTileEntity("cluster_mill.mv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 2));
        CLUSTERMILL[2] = GregTechAPI.registerMetaTileEntity(2010, new SimpleMachineMetaTileEntity("cluster_mill.hv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 3));
        CLUSTERMILL[3] = GregTechAPI.registerMetaTileEntity(2011, new SimpleMachineMetaTileEntity("cluster_mill.ev", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 4));
        CLUSTERMILL[4] = GregTechAPI.registerMetaTileEntity(2012, new SimpleMachineMetaTileEntity("cluster_mill.iv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 5));
        CLUSTERMILL[5] = GregTechAPI.registerMetaTileEntity(2013, new SimpleMachineMetaTileEntity("cluster_mill.luv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 6));
        CLUSTERMILL[6] = GregTechAPI.registerMetaTileEntity(2014, new SimpleMachineMetaTileEntity("cluster_mill.zpm", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 7));
        CLUSTERMILL[7] = GregTechAPI.registerMetaTileEntity(2015, new SimpleMachineMetaTileEntity("cluster_mill.uv", GARecipeMaps.CLUSTER_MILL_RECIPES, Textures.WIREMILL_OVERLAY, 8));

        ALLOY_SMELTER[4] = GregTechAPI.registerMetaTileEntity(2016, new SimpleMachineMetaTileEntity("alloy_smelter.iv", RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 5));
        ALLOY_SMELTER[5] = GregTechAPI.registerMetaTileEntity(2017, new SimpleMachineMetaTileEntity("alloy_smelter.luv", RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 6));
        ALLOY_SMELTER[6] = GregTechAPI.registerMetaTileEntity(2018, new SimpleMachineMetaTileEntity("alloy_smelter.zpm", RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 7));
        ALLOY_SMELTER[7] = GregTechAPI.registerMetaTileEntity(2019, new SimpleMachineMetaTileEntity("alloy_smelter.uv", RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, 8));

        COKE_OVEN = GregTechAPI.registerMetaTileEntity(2500, new TileEntityCokeOven("coke_oven"));

        DISTILL_TOWER = GregTechAPI.registerMetaTileEntity(2501, new TileEntityDistillTower("distill_tower"));
        ASSEMBLY_LINE = GregTechAPI.registerMetaTileEntity(2502, new TileEntityAssemblyLine("assembly_line"));
    }
}
