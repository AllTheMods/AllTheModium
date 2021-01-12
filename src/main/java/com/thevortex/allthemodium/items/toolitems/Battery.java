package com.thevortex.allthemodium.items.toolitems;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.energy.IEnergyStorage;

public class Battery extends Item implements IEnergyStorage {
		public static final int MAX_POWER = 100000000;
		public static final int FE_PER_TICK = 200000;
		private int STORED_POWER = 0;
		public Battery(Properties properties) {
			super(properties.maxStackSize(1));
		}
	    @CapabilityInject(IEnergyStorage.class)
	    static Capability<IEnergyStorage> ENERGY_HANDLER_CAPABILITY = null;
	    
	    @CapabilityInject(IEnergyStorage.class)
	    public static void capRegistered(Capability<IEnergyStorage> capability)
	    {
	    	ENERGY_HANDLER_CAPABILITY = capability;
	    }
		
		@Override
		public int receiveEnergy(int maxReceive, boolean simulate) {
			if(!simulate) {
			this.STORED_POWER += maxReceive;
			return maxReceive;
			}
			return 0;
		}
		@Override
		public int extractEnergy(int maxExtract, boolean simulate) {
			if(!simulate) {
				this.STORED_POWER -= maxExtract;
				return maxExtract;
				}
			return 0;
		}
		@Override
		public int getEnergyStored() {
			
			return this.STORED_POWER;
		}
		@Override
		public int getMaxEnergyStored() {
			return this.MAX_POWER;
		}
		@Override
		public boolean canExtract() {
			return true;
		}
		@Override
		public boolean canReceive() {
			return true;
		}

		public static void setENERGY_HANDLER_CAPABILITY(Capability<IEnergyStorage> eNERGY_HANDLER_CAPABILITY) {
			ENERGY_HANDLER_CAPABILITY = eNERGY_HANDLER_CAPABILITY;
		}
		public void setSTORED_POWER(int sTORED_POWER) {
			STORED_POWER = sTORED_POWER;
		}
		public static Capability<IEnergyStorage> getENERGY_HANDLER_CAPABILITY() {
			return ENERGY_HANDLER_CAPABILITY;
		}
}

