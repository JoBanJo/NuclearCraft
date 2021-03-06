package nc.multiblock.heatExchanger;

import java.util.HashSet;
import java.util.Set;

import nc.Global;
import nc.config.NCConfig;
import nc.multiblock.IMultiblockPart;
import nc.multiblock.MultiblockBase;
import nc.multiblock.TileBeefBase.SyncReason;
import nc.multiblock.container.ContainerHeatExchangerController;
import nc.multiblock.cuboidal.CuboidalMultiblockBase;
import nc.multiblock.heatExchanger.tile.TileHeatExchangerController;
import nc.multiblock.heatExchanger.tile.TileHeatExchangerTube;
import nc.multiblock.heatExchanger.tile.TileHeatExchangerVent;
import nc.multiblock.network.HeatExchangerUpdatePacket;
import nc.multiblock.validation.IMultiblockValidator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class HeatExchanger extends CuboidalMultiblockBase<HeatExchangerUpdatePacket> {
	
	private Set<TileHeatExchangerController> controllers;
	private Set<TileHeatExchangerVent> vents;
	private Set<TileHeatExchangerTube> tubes;
	
	private TileHeatExchangerController controller;
	
	private int updateCount = 0;
	
	public double fractionOfTubesActive, efficiency;
	
	public boolean isHeatExchangerOn;
	
	public HeatExchanger(World world) {
		super(world);
		
		controllers = new HashSet<TileHeatExchangerController>();
		vents = new HashSet<TileHeatExchangerVent>();
		tubes = new HashSet<TileHeatExchangerTube>();
	}
	
	// Multiblock Part Getters
	
	public Set<TileHeatExchangerController> getControllers() {
		return controllers;
	}
	
	public Set<TileHeatExchangerVent> getVents() {
		return vents;
	}
	
	public Set<TileHeatExchangerTube> getTubes() {
		return tubes;
	}
	
	// Multiblock Size Limits
	
	@Override
	protected int getMinimumInteriorLength() {
		return NCConfig.heat_exchanger_min_size;
	}
	
	@Override
	protected int getMaximumInteriorLength() {
		return NCConfig.heat_exchanger_max_size;
	}
	
	// Multiblock Methods
	
	@Override
	public void onAttachedPartWithMultiblockData(IMultiblockPart part, NBTTagCompound data) {
		syncDataFrom(data, SyncReason.FullSync);
	}
	
	@Override
	protected void onBlockAdded(IMultiblockPart newPart) {
		if (newPart instanceof TileHeatExchangerController) controllers.add((TileHeatExchangerController) newPart);
		if (newPart instanceof TileHeatExchangerVent) vents.add((TileHeatExchangerVent) newPart);
		if (newPart instanceof TileHeatExchangerTube) tubes.add((TileHeatExchangerTube) newPart);
	}
	
	@Override
	protected void onBlockRemoved(IMultiblockPart oldPart) {
		if (oldPart instanceof TileHeatExchangerController) controllers.remove(oldPart);
		if (oldPart instanceof TileHeatExchangerVent) vents.remove(oldPart);
		if (oldPart instanceof TileHeatExchangerTube) tubes.remove(oldPart);
	}
	
	@Override
	protected void onMachineAssembled() {
		for (TileHeatExchangerController contr : controllers) controller = contr;
		for (TileHeatExchangerTube tube : tubes) tube.updateFlowDir();
		updateHeatExchanger();
	}
	
	@Override
	protected void onMachineRestored() {
		for (TileHeatExchangerTube tube : tubes) tube.updateFlowDir();
		updateHeatExchanger();
	}
	
	@Override
	protected void onMachinePaused() {
		
	}
	
	@Override
	protected void onMachineDisassembled() {
		isHeatExchangerOn = false;
	}
	
	@Override
	protected boolean isMachineWhole(IMultiblockValidator validatorCallback) {
		if (controllers.size() == 0) {
			validatorCallback.setLastError(Global.MOD_ID + ".multiblock_validation.no_controller", null);
			return false;
		}
		if (controllers.size() > 1) {
			validatorCallback.setLastError(Global.MOD_ID + ".multiblock_validation.too_many_controllers", null);
			return false;
		}
		return super.isMachineWhole(validatorCallback);
	}
	
	@Override
	protected void onAssimilate(MultiblockBase assimilated) {
		
	}
	
	@Override
	protected void onAssimilated(MultiblockBase assimilator) {
		
	}
	
	// Server
	
	@Override
	protected boolean updateServer() {
		setIsHeatExchangerOn();
		if (shouldUpdate()) updateHeatExchanger();
		if (shouldUpdate()) sendUpdateToListeningPlayers();
		incrementUpdateCount();
		return true;
	}
	
	protected void setIsHeatExchangerOn() {
		boolean oldIsHeatExchangerOn = isHeatExchangerOn;
		isHeatExchangerOn = isRedstonePowered() && isAssembled();
		if (isHeatExchangerOn != oldIsHeatExchangerOn) sendUpdateToAllPlayers();
	}
	
	protected boolean isRedstonePowered() {
		if (controller.isRedstonePowered()) return true;
		return false;
	}
	
	protected void updateHeatExchanger() {
		if (tubes.size() < 1) {
			fractionOfTubesActive = 0;
			efficiency = 0;
			return;
		}
		int activeCount = 0;
		double efficiencyCount = 0;
		
		for (TileHeatExchangerTube tube : tubes) {
			int eff = tube.checkPosition();
			if (eff > 0) activeCount++;
			efficiencyCount += eff;
		}
		
		fractionOfTubesActive = (double)activeCount/tubes.size();
		efficiency = activeCount == 0 ? 0 : efficiencyCount/(double)activeCount;
	}
	
	private void incrementUpdateCount() {
		updateCount++; updateCount %= updateTime();
	}
	
	private int updateTime() {
		return NCConfig.machine_update_rate;
	}
	
	private boolean shouldUpdate() {
		return updateCount == 0;
	}
	
	// Client
	
	@Override
	protected void updateClient() {
		
	}
	
	// NBT
	
	@Override
	protected void syncDataTo(NBTTagCompound data, SyncReason syncReason) {
		data.setBoolean("isHeatExchangerOn", isHeatExchangerOn);
		data.setDouble("fractionOfTubesActive", fractionOfTubesActive);
		data.setDouble("efficiency", efficiency);
	}
	
	@Override
	protected void syncDataFrom(NBTTagCompound data, SyncReason syncReason) {
		isHeatExchangerOn = data.getBoolean("isHeatExchangerOn");
		fractionOfTubesActive = data.getDouble("fractionOfTubesActive");
		efficiency = data.getDouble("efficiency");
	}
	
	// Packets
	
	@Override
	protected HeatExchangerUpdatePacket getUpdatePacket() {
		return new HeatExchangerUpdatePacket(controller.getPos(), isHeatExchangerOn, fractionOfTubesActive, efficiency);
	}
	
	public void onPacket(boolean isHeatExchangerOn, double fractionOfTubesActive, double efficiency) {
		this.isHeatExchangerOn = isHeatExchangerOn;
		this.fractionOfTubesActive = fractionOfTubesActive;
		this.efficiency = efficiency;
	}
	
	public Container getContainer(EntityPlayer player) {
		return new ContainerHeatExchangerController(player, controller);
	}
	
	// Multiblock Validators
	
	@Override
	protected boolean isBlockGoodForInterior(World world, int x, int y, int z, IMultiblockValidator validatorCallback) {
		return true;
	}
}
