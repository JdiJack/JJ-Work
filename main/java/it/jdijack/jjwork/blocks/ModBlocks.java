package it.jdijack.jjwork.blocks;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static ArrayList<Block> blocks;
	public static BlockExe exe_block;

	public static void init(){
		blocks = new ArrayList<Block>();
		exe_block = new BlockExe("exe_block", "exe_block");
		blocks.add(exe_block);
	}
}
