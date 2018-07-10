package gregicadditions.machines;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.crafttweaker.InputIngredient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Optional;
import stanhebben.zenscript.annotations.ZenGetter;

public class CokeOvenRecipe {
    private final CountableIngredient input;
    private final ItemStack output;
    private final FluidStack outputFluid;
    private final int duration;

    public CokeOvenRecipe(CountableIngredient input, ItemStack output, FluidStack outputFluid, int duration) {
        this.input = input;
        this.output = output;
        this.outputFluid = outputFluid;
        this.duration = duration;
    }

    public CountableIngredient getInput() {
        return this.input;
    }

    public ItemStack getOutput() {
        return this.output;
    }

    public FluidStack getOutputFluid() {
        return this.outputFluid;
    }

    @ZenGetter("duration")
    public int getDuration() {
        return this.duration;
    }

    @ZenGetter("input")
    @Optional.Method(
            modid = "crafttweaker"
    )
    public InputIngredient ctGetInput() {
        return new InputIngredient(this.getInput());
    }

    @ZenGetter("output")
    @Optional.Method(
            modid = "crafttweaker"
    )
    public IItemStack ctGetOutput() {
        return CraftTweakerMC.getIItemStack(this.getOutput());
    }
}
