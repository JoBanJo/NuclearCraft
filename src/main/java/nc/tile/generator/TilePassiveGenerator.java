package nc.tile.generator;

import nc.tile.dummy.IInterfaceable;
import nc.tile.energy.IEnergySpread;
import nc.tile.energy.ITileEnergy;
import nc.tile.energy.TileEnergy;
import nc.tile.internal.energy.EnergyConnection;
import nc.util.EnergyHelper;

public abstract class TilePassiveGenerator extends TileEnergy implements IInterfaceable, IEnergySpread {
	
	public final int power;
	
	public TilePassiveGenerator(int maxPowerGen) {
		super(2*6*maxPowerGen, 2*6*maxPowerGen, ITileEnergy.energyConnectionAll(EnergyConnection.OUT));
		power = maxPowerGen;
	}
	
	@Override
	public void update() {
		super.update();
		if(!world.isRemote) {
			getEnergyStorage().changeEnergyStored(getGenerated());
			pushEnergy();
			//spreadEnergy();
		}
	}
	
	public abstract int getGenerated();
	
	@Override
	public int getEUSourceTier() {
		return EnergyHelper.getEUTier(power);
	}
	
	@Override
	public int getEUSinkTier() {
		return 4;
	}
}
