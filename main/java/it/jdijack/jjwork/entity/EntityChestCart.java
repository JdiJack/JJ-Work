package it.jdijack.jjwork.entity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.shadowmage.ancientwarfare.vehicle.VehicleVarHelpers.DummyVehicleHelper;
import net.shadowmage.ancientwarfare.vehicle.entity.VehicleBase;
import net.shadowmage.ancientwarfare.vehicle.helpers.VehicleAmmoHelper;
import net.shadowmage.ancientwarfare.vehicle.helpers.VehicleFiringHelper;
import net.shadowmage.ancientwarfare.vehicle.helpers.VehicleMoveHelper;
import net.shadowmage.ancientwarfare.vehicle.helpers.VehicleUpgradeHelper;
import net.shadowmage.ancientwarfare.vehicle.inventory.VehicleInventory;
import net.shadowmage.ancientwarfare.vehicle.pathing.Navigator;
import net.shadowmage.ancientwarfare.vehicle.pathing.PathWorldAccessEntity;
import net.shadowmage.ancientwarfare.vehicle.registry.VehicleRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.shadowmage.ancientwarfare.core.util.Trig;

public class EntityChestCart extends VehicleBase{

	public EntityChestCart(World world) {
		super(world);
	}
	
	public EntityChestCart(World world, VehicleBase base) {
		super(world);
		this.baseForwardSpeed = base.baseForwardSpeed;
		this.baseStrafeSpeed = base.baseStrafeSpeed;
		this.basePitchMin = base.basePitchMin;
		this.basePitchMax = base.basePitchMax;
		//this.baseTurretRotationMax = base.baseTurretRotationMax;
		this.baseHealth = base.baseHealth;
		//this.baseAccuracy = base.baseAccuracy;
		this.baseWeight = base.baseWeight;
		//this.baseReloadTicks = base.baseReloadTicks;
		//this.baseGenericResist = base.baseGenericResist;
		//this.baseFireResist = base.baseFireResist;
		//this.baseExplosionResist = base.baseExplosionResist;
		this.currentForwardSpeedMax = base.currentForwardSpeedMax;
		this.currentPitchSpeedMax = base.currentPitchSpeedMax;
		this.currentStrafeSpeedMax = base.currentStrafeSpeedMax;
		this.currentReloadTicks = base.currentReloadTicks;
		this.currentTurretPitchMin = base.currentTurretPitchMin;
		this.currentTurretPitchMax = base.currentTurretPitchMax;
		this.currentLaunchSpeedPowerMax = base.currentLaunchSpeedPowerMax;
		this.currentGenericResist = base.currentGenericResist;
		this.currentFireResist = base.currentFireResist;
		this.currentExplosionResist = base.currentExplosionResist;
		this.currentWeight = base.currentWeight;
		this.currentTurretPitchSpeed = base.currentTurretPitchSpeed;
		this.currentTurretYawSpeed = base.currentTurretYawSpeed;
		this.currentAccuracy = base.currentAccuracy;
		this.currentTurretRotationMax = base.currentTurretRotationMax;
		this.localTurretRotationHome = base.localTurretRotationHome;
		this.localTurretRotation = base.localTurretRotation;
		this.localTurretDestRot = base.localTurretDestRot;
		//this.localTurretRotInc = base.localTurretRotInc;
		this.localTurretRotationHome = base.localTurretRotationHome;
		this.localTurretRotation = base.localTurretRotation;
		this.localTurretDestRot = base.localTurretDestRot;
		//this.localTurretRotInc = base.localTurretRotInc;
		this.localTurretPitch = base.localTurretPitch;
		this.localTurretDestPitch = base.localTurretDestPitch;
		//this.localTurretPitchInc = base.localTurretPitchInc;
		this.localLaunchPower = base.localLaunchPower;
		this.wheelRotation = base.wheelRotation;
		this.wheelRotationPrev = base.wheelRotationPrev;
		//this.isSettingUp = base.isSettingUp;
		this.hitAnimationTicks = base.hitAnimationTicks;
		this.moveUpdateTicks = base.moveUpdateTicks;
		//this.assignedRider = base.assignedRider;
		this.ammoHelper = base.ammoHelper;
		this.upgradeHelper = base.upgradeHelper;
		this.baseForwardSpeed = base.baseForwardSpeed;
		this.baseForwardSpeed = base.baseForwardSpeed;
		this.moveHelper = base.moveHelper;
		this.firingHelper = base.firingHelper;
		this.firingVarsHelper = base.firingVarsHelper;
		this.inventory = base.inventory;
		this.nav = base.nav;
		this.worldAccess = base.worldAccess;
		this.vehicleType = VehicleRegistry.CHEST_CART;
		this.vehicleMaterialLevel = base.vehicleMaterialLevel;
		this.moveHelper = new VehicleMoveHelper(this);
		this.nav = new Navigator(this);
		this.nav.setStuckCheckTicks(100);
		//this.owner = base.owner;
		/*
		this.upgradeHelper = new VehicleUpgradeHelper(base);
		this.moveHelper = new VehicleMoveHelper(base);
		this.ammoHelper = new VehicleAmmoHelper(base);
		this.firingHelper = new VehicleFiringHelper(base);
		this.firingVarsHelper = new DummyVehicleHelper(base);
		this.inventory = base.inventory;
		this.worldAccess = new PathWorldAccessEntity(world, base);
		this.nav = new Navigator(base);
		this.nav.setStuckCheckTicks(100);
		this.stepHeight = 1.12f;
		this.entityCollisionReduction = 0.9f;
		this.onGround = false;*/
	}
	
	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand) {
		// TODO Auto-generated method stub
		return super.applyPlayerInteraction(player, vec, hand);
	}
	
	@Override
	public boolean startRiding(Entity entity, boolean force) {
		if (super.startRiding(entity, force)) {
			if (entity instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) entity;
				player.capabilities.allowFlying = true;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.world.isRemote) {
			this.updatePassenger(getControllingPassenger());
		} else {
			if (this.getControllingPassenger() instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) this.getControllingPassenger();
				if (player.isSneaking()) {
					int xMin = MathHelper.floor(this.posX - this.width / 2);
					int zMin = MathHelper.floor(this.posZ - this.width / 2);
					int yMin = MathHelper.floor(posY) - 2;

					if (player instanceof EntityPlayerMP) {
						((EntityPlayerMP) player).capabilities.allowFlying = false;
					}
					player.dismountRidingEntity();

					searchLabel:
					for (int y = yMin; y <= yMin + 3; y++) {
						for (int x = xMin; x <= xMin + (int) width; x++) {
							for (int z = zMin; z <= zMin + (int) width; z++) {
								BlockPos pos = new BlockPos(x, y, z);
								IBlockState state = world.getBlockState(pos);
								if (state.isSideSolid(world, pos, EnumFacing.UP) || state.getMaterial() == Material.WATER) {
									if (world.isAirBlock(pos.up()) && world.isAirBlock(pos.up().up())) {
										player.setPositionAndUpdate(x + 0.5d, y + 1, z + 0.5d);
										break searchLabel;
									}
								}
							}
						}
					}
					player.setSneaking(false);
				}
			}
		}
		this.moveHelper.onUpdate();
		this.firingHelper.onTick();
		this.firingVarsHelper.onTick();
		if (this.hitAnimationTicks > 0) {
			this.hitAnimationTicks--;
		}
	}
	
	@Override
	public void updatePassenger(Entity passenger) {
		if(passenger!=null) {
			double posX = this.posX;
			double posY = this.posY + this.getRiderVerticalOffset();
			double posZ = this.posZ;

			float yaw = this.vehicleType.moveRiderWithTurret() ? localTurretRotation : rotationYaw;
			
			
			//passenger.setPositionAndRotation(posX, posY + passenger.getYOffset(), posZ, 180 - localTurretRotation, passenger.rotationPitch);
			//passenger.setRenderYawOffset(180 - localTurretRotation);
			
			if(passenger instanceof EntityHorse) {
				posX += Trig.sinDegrees(yaw) * -vehicleType.getRiderForwardsOffset();
				posX += Trig.sinDegrees(yaw + 90) * vehicleType.getRiderHorizontalOffset();
				posZ += Trig.cosDegrees(yaw) * -vehicleType.getRiderForwardsOffset();
				posZ += Trig.cosDegrees(yaw + 90) * vehicleType.getRiderHorizontalOffset();
				passenger.setPositionAndRotation(posX, posY + passenger.getYOffset(), posZ, 180 - localTurretRotation, passenger.rotationPitch);
				passenger.setRenderYawOffset(180 - localTurretRotation);
				passenger.setPosition(posX, posY + passenger.getYOffset()-0.5, posZ);
				passenger.rotationYaw -= this.moveHelper.getRotationSpeed();
			}else {
				posX += Trig.sinDegrees(yaw) * -vehicleType.getRiderForwardsOffset();
				posX += Trig.sinDegrees(yaw + 90) * vehicleType.getRiderHorizontalOffset();
				posZ += Trig.cosDegrees(yaw) * -vehicleType.getRiderForwardsOffset();
				posZ += Trig.cosDegrees(yaw + 90) * vehicleType.getRiderHorizontalOffset();
				passenger.setPosition(posX, posY + passenger.getYOffset()+0.8, posZ);
				passenger.rotationYaw -= this.moveHelper.getRotationSpeed();
			}
			
		}
	}
}
