package com.mythden.juxtapose;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

import static net.minecraft.state.property.Properties.*;

public class MusicBoxBlock extends Block {

    public static final DirectionProperty FACING = HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_NS = Stream.of(
            Block.createCuboidShape(2, 0, 3, 14, 13, 13),
            Block.createCuboidShape(3, 13, 3, 13, 15, 13),
            Block.createCuboidShape(12, 0, 1, 15, 14, 3),
            Block.createCuboidShape(4, 13, 1, 12, 14, 3),
            Block.createCuboidShape(2, 14, 1, 14, 16, 3),
            Block.createCuboidShape(4, 0, 2, 12, 3, 3),
            Block.createCuboidShape(1, 0, 1, 4, 14, 3),
            Block.createCuboidShape(1, 0, 13, 4, 14, 15),
            Block.createCuboidShape(4, 13, 13, 12, 14, 15),
            Block.createCuboidShape(2, 14, 13, 14, 16, 15),
            Block.createCuboidShape(12, 0, 13, 15, 14, 15),
            Block.createCuboidShape(4, 0, 13, 12, 3, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final VoxelShape SHAPE_EW = Stream.of(
            Block.createCuboidShape(3, 0, 2, 13, 13, 14),
            Block.createCuboidShape(3, 13, 3, 13, 15, 13),
            Block.createCuboidShape(1, 0, 1, 3, 14, 4),
            Block.createCuboidShape(1, 13, 4, 3, 14, 12),
            Block.createCuboidShape(1, 14, 2, 3, 16, 14),
            Block.createCuboidShape(2, 0, 4, 3, 3, 12),
            Block.createCuboidShape(1, 0, 12, 3, 14, 15),
            Block.createCuboidShape(13, 0, 12, 15, 14, 15),
            Block.createCuboidShape(13, 13, 4, 15, 14, 12),
            Block.createCuboidShape(13, 14, 2, 15, 16, 14),
            Block.createCuboidShape(13, 0, 1, 15, 14, 4),
            Block.createCuboidShape(13, 0, 4, 14, 3, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    protected MusicBoxBlock() {
        super(AbstractBlock.Settings.copy(Blocks.JUKEBOX).luminance((state) -> 13));
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

//    @Nullable
//    @Override
//    public BlockEntity createBlockEntity(BlockView world) {
//        return null;
//    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case EAST, WEST -> SHAPE_EW;
            default -> SHAPE_NS;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING);
    }
}
