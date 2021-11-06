package com.mythden.juxtapose;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.math.BlockPos;

public class MusicBoxBlockEntity extends BlockEntity {
    public MusicBoxBlockEntity(BlockEntityType<?> type) {
        super(type);
    }
//    public MusicBoxBlockEntity(BlockPos pos, BlockState state) {
//        super(JuxtaposeRegistry.MUSIC_BLOCK_ENTITY, pos, state);
//    }
}
