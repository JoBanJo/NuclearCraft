package nc.block;

import java.util.Iterator;

import javax.annotation.Nullable;

import nc.Global;
import nc.block.item.IMetaBlockName;
import nc.enumm.IBlockMeta;
import nc.enumm.MetaEnums;
import nc.tab.NCTabs;
import nc.util.ArrayHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockMeta<T extends Enum<T> & IStringSerializable & IBlockMeta> extends Block implements IMetaBlockName {
	
	public final T[] values;
	public final PropertyEnum type;
	
	protected final boolean canCreatureSpawn;
	
	public BlockMeta(String name, Class<T> enumm, PropertyEnum property, Material material) {
		this(name, enumm, property, material, false);
	}
	
	public BlockMeta(String name, Class<T> enumm, PropertyEnum property, Material material, boolean canCreatureSpawn) {
		super(material);
		setUnlocalizedName(Global.MOD_ID + "." + name);
		setRegistryName(new ResourceLocation(Global.MOD_ID, name));
		values = enumm.getEnumConstants();
		type = property;
		setDefaultState(blockState.getBaseState().withProperty(type, values[0]));
		setMetaHarvestLevels();
		setHardness(2F);
		setResistance(15F);
		this.canCreatureSpawn = canCreatureSpawn;
	}
	
	public static class BlockOre extends BlockMeta {
		
		public final static PropertyEnum TYPE = PropertyEnum.create("type", MetaEnums.OreType.class);
		
		public BlockOre(String name) {
			super(name, MetaEnums.OreType.class, TYPE, Material.ROCK, true);
			setCreativeTab(NCTabs.BASE_BLOCK_MATERIALS);
		}
		
		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, new IProperty[] {TYPE});
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.CUTOUT;
		}
	}
	
	public static class BlockIngot extends BlockMeta {
		
		public final static PropertyEnum TYPE = PropertyEnum.create("type", MetaEnums.IngotType.class);
		
		public BlockIngot(String name) {
			super(name, MetaEnums.IngotType.class, TYPE, Material.IRON);
			setCreativeTab(NCTabs.BASE_BLOCK_MATERIALS);
		}

		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, new IProperty[] {TYPE});
		}
	}
	
	public static class BlockFission extends BlockMeta {
		
		public final static PropertyEnum TYPE = PropertyEnum.create("type", MetaEnums.FissionBlockType.class);
		
		public BlockFission(String name) {
			super(name, MetaEnums.FissionBlockType.class, TYPE, Material.IRON);
			setCreativeTab(NCTabs.FISSION_BLOCKS);
		}
		
		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, new IProperty[] {TYPE});
		}
	}
	
	public static class BlockCooler extends BlockMeta {
		
		public final static PropertyEnum TYPE = PropertyEnum.create("type", MetaEnums.CoolerType.class);

		public BlockCooler(String name) {
			super(name, MetaEnums.CoolerType.class, TYPE, Material.IRON);
			setCreativeTab(NCTabs.FISSION_BLOCKS);
		}

		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, new IProperty[] {TYPE});
		}
	}
	
	public void setMetaHarvestLevels() {
		Iterator<T> itr = ArrayHelper.asList(values).iterator();
		while (itr.hasNext()) {
			T nextState = itr.next();
			setHarvestLevel(nextState.getHarvestTool(), nextState.getHarvestLevel(), getStateFromMeta(nextState.getID()));
		}
	}
	
	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
		return ((T) state.getValue(type)).getLightValue();
	}
	
	@Override
	public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
		return ((T) state.getValue(type)).getHardness();
	}
	
	@Override
	public float getExplosionResistance(World world, BlockPos pos, @Nullable Entity exploder, Explosion explosion) {
		return ((T) world.getBlockState(pos).getValue(type)).getResistance();
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((T) state.getValue(type)).getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(type, values[meta]);
	}
	
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i < values.length; i++) {
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(state));
	}
	
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {
		return canCreatureSpawn && super.canCreatureSpawn(state, world, pos, type);
	}
	
	@Override
	public String getSpecialName(ItemStack stack) {
		return values[stack.getItemDamage()].getName();
	}
}
