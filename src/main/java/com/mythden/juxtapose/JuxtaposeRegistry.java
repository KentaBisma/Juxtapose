package com.mythden.juxtapose;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JuxtaposeRegistry {

    public static final Block MUSIC_BOX = new MusicBoxBlock();
    public static final BlockItem MUSIC_BOX_ITEM = new BlockItem(JuxtaposeRegistry.MUSIC_BOX, new Item.Settings().group(ItemGroup.DECORATIONS));

    public static void register() {
       Registry.register(net.minecraft.util.registry.Registry.BLOCK, new Identifier(Juxtapose.MOD_ID, "music_box"), MUSIC_BOX);
       Registry.register(net.minecraft.util.registry.Registry.ITEM, new Identifier(Juxtapose.MOD_ID, "music_box"), MUSIC_BOX_ITEM);
    }
}
