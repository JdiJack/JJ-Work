package it.jdijack.jjwork.blocks;

import it.jdijack.jjwork.JJFixAWMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockExe extends Block {
	
	public BlockExe(String unlocalizedName, String registryName){
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(JJFixAWMod.tab);
	}
}