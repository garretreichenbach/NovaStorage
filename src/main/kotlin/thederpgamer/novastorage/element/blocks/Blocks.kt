package thederpgamer.novastorage.element.blocks

import org.bukkit.Material
import thederpgamer.novastorage.NovaStorage
import thederpgamer.novastorage.element.blocks.system.ControllerBlock
import thederpgamer.novastorage.element.blocks.system.DiskDriveBlock
import thederpgamer.novastorage.element.items.Items
import xyz.xenondevs.nova.addon.registry.BlockRegistry
import xyz.xenondevs.nova.data.world.block.property.Directional
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.item.options.BlockOptions
import xyz.xenondevs.nova.item.tool.VanillaToolCategories
import xyz.xenondevs.nova.item.tool.VanillaToolTiers
import xyz.xenondevs.nova.world.block.sound.SoundGroup

/**
 * [Description]
 *
 * @author TheDerpGamerX
 */
@Init
object Blocks : BlockRegistry by NovaStorage.registry {

    private val SYSTEM_BLOCK_PROPERTIES = BlockOptions(3.0, VanillaToolCategories.PICKAXE, VanillaToolTiers.STONE, true, SoundGroup.STONE, Material.STONE)

    val CONTROLLER_BLOCK = tileEntity("Controller Block", ::ControllerBlock).blockOptions(SYSTEM_BLOCK_PROPERTIES).properties(Directional.NORMAL).register()
    val DISK_DRIVE = tileEntity("Disk Drive", ::DiskDriveBlock).blockOptions(SYSTEM_BLOCK_PROPERTIES).properties(Directional.NORMAL).register()

    fun registerBlockItem() {
        Items.BLOCK_ITEMS[CONTROLLER_BLOCK] = Items.registerItem(CONTROLLER_BLOCK)
        Items.BLOCK_ITEMS[DISK_DRIVE] = Items.registerItem(DISK_DRIVE)
    }
}