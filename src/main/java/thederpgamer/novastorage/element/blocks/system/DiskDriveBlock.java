/*
package thederpgamer.novastorage.element.blocks.system

import thederpgamer.novastorage.element.blocks.BlocksOld
import thederpgamer.novastorage.network.storage.Disk
import xyz.xenondevs.nova.data.config.NovaConfig
import xyz.xenondevs.nova.data.config.configReloadable
import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.tileentity.network.NetworkConnectionType
import xyz.xenondevs.nova.tileentity.network.energy.holder.ConsumerEnergyHolder
import xyz.xenondevs.nova.util.BlockSide

/**
 * [Description]
 *
 * @author TheDerpGamer
 */

private val BASE_CAPACITY = configReloadable { NovaConfig[BlocksOld.DISK_DRIVE].getLong("base_energy_capacity") }
private val BASE_USAGE = configReloadable { NovaConfig[BlocksOld.DISK_DRIVE].getLong("base_energy_usage") }
class DiskDriveBlock(blockState: NovaTileEntityState) : NetworkedTileEntity(blockState) {

	override val energyHolder = ConsumerEnergyHolder(this, BASE_CAPACITY, BASE_USAGE, null) {
		createSideConfig(NetworkConnectionType.BUFFER, BlockSide.FRONT)
		createSideConfig(NetworkConnectionType.BUFFER, BlockSide.BACK)
		createSideConfig(NetworkConnectionType.BUFFER, BlockSide.LEFT)
		createSideConfig(NetworkConnectionType.BUFFER, BlockSide.RIGHT)
		createSideConfig(NetworkConnectionType.BUFFER, BlockSide.TOP)
		createSideConfig(NetworkConnectionType.BUFFER, BlockSide.BOTTOM)
	}

	/**
	 * Called every tick on server side.
	 */
	override fun handleTick() {
		super.handleTick()
	}

	/**
	 * Called every tick on both sides.
	 */
	override fun handleAsyncTick() {
		super.handleAsyncTick()
	}

	/**
	 * Called when the TileEntity is loaded/placed.
	 */
	override fun handleInitialized(first: Boolean) {
		super.handleInitialized(first)
	}

	/**
	 * Called when the TileEntity is unloaded/broken.
	 */
	override fun handleRemoved(unload: Boolean) {
		super.handleRemoved(unload)
	}

	override fun saveData() {
		super.saveData()
	}

	public fun getDiskById(id: Int): Disk {
		val disks = getDisks()
		for(disk in disks) if(disk.id == id) return disk
		return Disk(-1, "Empty Disk", 0, ByteArray(0))
	}

	public fun getDiskBySlotNum(slotNum: Int): Disk {
		val disks = getDisks()
		return if(slotNum < disks.size) disks[slotNum] else Disk(slotNum, "Empty Disk", 0, ByteArray(0))
	}

	/**
	 * Returns the disk array.
	 */
	public fun getDisks(): Array<Disk> {
		val disks = ArrayList<Disk>()
		for(i in 0 until 16) {
			val disk = retrieveDataOrNull<Disk>("disk_$i")
			if(disk != null) disks.add(disk)
		}
		return disks.toTypedArray()
	}

	public fun serialize(): ByteArray {
		val disks = getDisks()
		val bytes = ByteArray(disks.size * 1024) //Todo: Make sure 1024 will be enough to hold all item data, even in larger sizes
		for(i in disks.indices) {
			val disk = disks[i]
			val diskBytes = disk.serialize()
			for(j in diskBytes.indices) bytes[(i * 1024) + j] = diskBytes[j]
		}
		return bytes
	}
}
 */