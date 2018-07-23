package gregicadditions.recipes;

import gregicadditions.machines.GATileEntities;
import gregtech.loaders.load.MetaTileEntityLoader;

public class MachineCraftingRecipes {

    public static void init() {
        MetaTileEntityLoader.registerMachineRecipe(GATileEntities.CLUSTERMILL,"MMM","CHC","MMM",'M',MetaTileEntityLoader.Type.MOTOR,'C',MetaTileEntityLoader.Type.CIRCUIT,'H',MetaTileEntityLoader.Type.HULL);
        MetaTileEntityLoader.registerMachineRecipe(GATileEntities.CIRCUITASSEMBLER, "ACE", "VMV", "WCW", 'M', MetaTileEntityLoader.Type.HULL, 'V', MetaTileEntityLoader.Type.CONVEYOR, 'A', MetaTileEntityLoader.Type.ROBOT_ARM, 'C', MetaTileEntityLoader.Type.CIRCUIT, 'W', MetaTileEntityLoader.Type.CABLE, 'E', MetaTileEntityLoader.Type.EMITTER);
    }
}
