package nc.block.tile.radiation;

import nc.block.tile.BlockSimpleTile;
import nc.config.NCConfig;
import nc.enumm.BlockEnums.SimpleTileType;
import nc.tile.radiation.TileRadiationScrubber;
import nc.util.Lang;
import nc.util.UnitHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockScrubber extends BlockSimpleTile {

	public BlockScrubber() {
		super(SimpleTileType.RADIATION_SCRUBBER);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (hand != EnumHand.MAIN_HAND) return false;
		
		if (player != null) {
			if (player.getHeldItemMainhand().isEmpty() && world.getTileEntity(pos) instanceof TileRadiationScrubber) {
				if (!world.isRemote) {
					TileRadiationScrubber scrubber = (TileRadiationScrubber) world.getTileEntity(pos);
					scrubber.checkSurroundings();
					double radRemoval = scrubber.rawScrubberRate;
					player.sendMessage(new TextComponentString(Lang.localise("message.nuclearcraft.scrubber_removal_rate") + " " + (Math.abs(radRemoval) < NCConfig.radiation_lowest_rate ? "0 Rads/t" : UnitHelper.prefix(radRemoval, 3, "Rads/t", 0, -8)) + " [" + Math.abs(Math.round(100D*scrubber.getChunkBufferContributionFraction()/TileRadiationScrubber.MAX_SCRUBBER_RATE_FRACTION)) + "%]"));
				}
				return true;
			}
		}
		return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
	}
}
