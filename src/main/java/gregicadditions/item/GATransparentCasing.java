package gregicadditions.item;

import gregtech.common.blocks.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class GATransparentCasing extends VariantBlock<GATransparentCasing.CasingType> {
    public GATransparentCasing() {
        super(Material.IRON);
        setUnlocalizedName("ga_transparent_casing");
        setHardness(5.0f);
        setResistance(5000.0f);
        setSoundType(SoundType.GLASS);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(CasingType.REINFORCED_GLASS));
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return false;
    }


    public enum CasingType implements IStringSerializable {

        REINFORCED_GLASS("reinforced_glass");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

    }
}
