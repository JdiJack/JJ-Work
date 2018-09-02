package it.jdijack.jjwork.util;

import it.jdijack.jjwork.entity.EntityChestCart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.shadowmage.ancientwarfare.core.network.NetworkHandler;
import net.shadowmage.ancientwarfare.npc.entity.NpcBase;
import net.shadowmage.ancientwarfare.vehicle.entity.VehicleBase;
import net.shadowmage.ancientwarfare.vehicle.entity.types.VehicleTypeChestCart;
import net.shadowmage.ancientwarfare.vehicle.helpers.VehicleFiringVarsHelper;

public class ACVehicleHelper extends VehicleFiringVarsHelper {

	private EntityChestCart chestcart;

	public ACVehicleHelper(VehicleBase vehicle, EntityChestCart chestcart) {
		super(vehicle);
		this.chestcart = chestcart;
	}

	public boolean interact(EntityPlayer player) {
		if(player.world.isRemote) 
			return true;
		
	
		/*if(chestcart.getPassengers().size()>0) {
			Entity entity = chestcart.getPassengers().get(0);
			entity.dismountRidingEntity();
		}*/
		
		if(chestcart.vehicleType instanceof VehicleTypeChestCart && player.isRiding() && player.getRidingEntity() instanceof EntityHorse && !chestcart.isBeingRidden()) {
			EntityHorse horse = (EntityHorse)player.getRidingEntity();
			
			horse.startRiding(chestcart, true);
            player.startRiding(chestcart, true);
            chestcart.startRiding(horse, true);
			
			
			//player.startRiding(chestcart, true);
			//horse.startRiding(chestcart, true);
			//player.startRiding(chestcart);
			//player.dismountRidingEntity();
			//chestcart.startRiding(horse, true);
			
			//horse.startRiding(vehicle, false);
			//vehicle.startRiding(horse, true);
			//player.startRiding(horse, true);
			//horse.startRiding(vehicle, true);
			//player.startRiding(player, true);
			//horse.startRiding(vehicle, false);
			//player.startRiding(vehicle, true);
			//vehicle.startRiding(horse, true);
			//horse.setLocationAndAngles(horse.getPosition().getX(), horse.getPosition().getY()+10, horse.getPosition().getZ(), 0, 0);
			//player.height+=5;
			//horse.height-=5;
			//vehicle.height-=4;
			return true;
		}	
		
		if(!player.isSneaking()){
			player.startRiding(chestcart);
			return true;
		}else if (player.isSneaking()) {
			NetworkHandler.INSTANCE.openGui(player, NetworkHandler.GUI_VEHICLE_INVENTORY, chestcart.getEntityId());
		}else if (chestcart.isBeingRidden() && chestcart.getPassengers().get(0) instanceof NpcBase) {
			NpcBase npc = (NpcBase) chestcart.getPassengers().get(0);
			npc.dismountRidingEntity();
		}
		
		
		return true;
	}
	
	public NBTTagCompound serializeNBT() {
		return new NBTTagCompound();
	}

	public void deserializeNBT(NBTTagCompound nbt) {
	}
	public float getVar1() {return 0;}
	public float getVar2() {return 0;}
	public float getVar3() {return 0;}
	public float getVar4() {return 0;}
	public float getVar5() {return 0;}
	public float getVar6() {return 0;}
	public float getVar7() {return 0;}
	public float getVar8() {return 0;}
	public void onFiringUpdate() {}
	public void onLaunchingUpdate() {}
	public void onReloadUpdate() {}
	public void onReloadingFinished() {}
}