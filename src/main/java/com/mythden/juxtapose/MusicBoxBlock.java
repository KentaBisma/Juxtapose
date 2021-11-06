package com.mythden.juxtapose;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class MusicBoxBlock extends Block {
    public static final VoxelShape  SHAPE = Stream.of(
            Block.createCuboidShape(4, 13, 13, 12, 16, 15),
            Block.createCuboidShape(2, 0, 3, 14, 13, 13),
            Block.createCuboidShape(3, 13, 3, 13, 15, 13),
            Block.createCuboidShape(12, 0, 1, 15, 15, 3),
            Block.createCuboidShape(4, 13, 1, 12, 16, 3),
            Block.createCuboidShape(4, 0, 2, 12, 3, 3),
            Block.createCuboidShape(1, 0, 1, 4, 15, 3),
            Block.createCuboidShape(1, 0, 13, 4, 15, 15),
            Block.createCuboidShape(12, 0, 13, 15, 15, 15),
            Block.createCuboidShape(4, 0, 13, 12, 3, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    protected MusicBoxBlock(Settings settings) {
        super(settings);
    }

//    @Nullable
//    @Override
//    public BlockEntity createBlockEntity(BlockView world) {
//        return null;
//    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
