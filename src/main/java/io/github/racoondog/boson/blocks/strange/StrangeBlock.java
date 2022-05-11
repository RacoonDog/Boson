package io.github.racoondog.boson.blocks.strange;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StrangeBlock extends Block {
    private final List<Block> BLOCK_LIST;

    public StrangeBlock(Settings settings, List<Block> list) {
        super(settings);
        this.BLOCK_LIST = list;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        replace(state, this.BLOCK_LIST.get(world.random.nextInt(this.BLOCK_LIST.size())).getDefaultState(), world, pos, 0);
    }
}
