package gregicadditions.recipes;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.function.DoubleSupplier;

public class RecipeMapDistillTower<R extends RecipeBuilder<R>> extends RecipeMap {
    private TextureArea progressBarTexture;
    private ProgressWidget.MoveType moveType;

    public RecipeMapDistillTower(String unlocalizedName, int minInputs, int maxInputs, int minOutputs, int maxOutputs, int minFluidInputs, int maxFluidInputs, int minFluidOutputs, int maxFluidOutputs, int amperage, R defaultRecipe) {
        super(unlocalizedName, minInputs, maxInputs, minOutputs, maxOutputs, minFluidInputs, maxFluidInputs, minFluidOutputs, maxFluidOutputs, amperage, defaultRecipe);
    }

    public ModularUI.Builder createUITemplate(DoubleSupplier progressSupplier, IItemHandlerModifiable importItems, IItemHandlerModifiable exportItems, FluidTankList importFluids, FluidTankList exportFluids) {
        ModularUI.Builder builder = new ModularUI.Builder(GuiTextures.BACKGROUND_EXTENDED, 176, 216) {
            public ModularUI.Builder bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                this.bindPlayerInventory(inventoryPlayer, 134);
                return this;
            }

        };
        builder.widget(new ProgressWidget(progressSupplier, 77, 22, 20, 20, GuiTextures.PROGRESS_BAR_ARROW, this.moveType));
        this.addInventorySlotGroup(builder, importItems, importFluids, false);
        this.addInventorySlotGroup(builder, exportItems, exportFluids, true);
        return builder;
    }


    private void addInventorySlotGroup(ModularUI.Builder builder, IItemHandlerModifiable itemHandler, FluidTankList fluidHandler, boolean isOutputs) {
        int itemInputsCount = itemHandler.getSlots();
        int fluidInputsCount = fluidHandler.getTanks();
        boolean invertFluids = false;
        if (itemInputsCount == 0) {
            int tmp = itemInputsCount;
            itemInputsCount = fluidInputsCount;
            fluidInputsCount = tmp;
            invertFluids = true;
        }
        int[] inputSlotGrid = determineSlotsGrid(itemInputsCount);
        int itemSlotsToLeft = inputSlotGrid[0];
        int itemSlotsToDown = inputSlotGrid[1];
        int startInputsX = isOutputs ? 106 : (69 - itemSlotsToLeft * 18);
        int startInputsY = 32 - (int) (itemSlotsToDown / 2.0 * 18);
        for (int i = 0; i < itemSlotsToDown; i++) {
            for (int j = 0; j < itemSlotsToLeft; j++) {
                int slotIndex = i * itemSlotsToLeft + j;
                addSlot(builder, startInputsX + 18 * j, startInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, invertFluids, isOutputs);
            }
        }

        int fitemSlotsToLeft = 3;
        int fitemSlotsToDown = 4;
        int fstartInputsX = isOutputs ? 124 : (69 - fitemSlotsToLeft * 18);
        int fstartInputsY = 32 - (int) (fitemSlotsToDown / 2.0 * 18);
        for (int i = 0; i < fitemSlotsToDown; i++) {
            for (int j = 0; j < fitemSlotsToLeft; j++) {
                int slotIndex = i * fitemSlotsToLeft + j;
                if (slotIndex >= fluidInputsCount)
                    continue;
                addSlot(builder, fstartInputsX + 18 * j, fstartInputsY + 18 * i, slotIndex, itemHandler, fluidHandler, true, isOutputs);
            }
        }
    }

    private static int[] determineSlotsGrid(int itemInputsCount) {
        int itemSlotsToLeft = 0;
        int itemSlotsToDown = 0;
        double sqrt = Math.sqrt(itemInputsCount);
        if (sqrt % 1 == 0) { //check if square root is integer
            //case for 1, 4, 9 slots - it's square inputs (the most common case)
            itemSlotsToLeft = itemSlotsToDown = (int) sqrt;
        } else if (itemInputsCount % 3 == 0) {
            //case for 3 and 6 slots - 3 by horizontal and i / 3 by vertical (common case too)
            itemSlotsToDown = itemInputsCount / 3;
            itemSlotsToLeft = 3;
        } else if (itemInputsCount % 2 == 0) {
            //case for 2 inputs - 2 by horizontal and i / 3 by vertical (for 2 slots)
            itemSlotsToDown = itemInputsCount / 2;
            itemSlotsToLeft = 2;
        }
        return new int[]{itemSlotsToLeft, itemSlotsToDown};
    }
}