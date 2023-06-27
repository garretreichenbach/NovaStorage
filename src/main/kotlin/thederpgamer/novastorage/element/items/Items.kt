package thederpgamer.novastorage.element.items

import thederpgamer.novastorage.NovaStorage
import xyz.xenondevs.nova.addon.registry.ItemRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.item.NovaItem
import xyz.xenondevs.nova.world.block.NovaBlock

/**
 * [Description]
 *
 * @author TheDerpGamerX
 */
@Init
object Items : ItemRegistry by NovaStorage.registry {

    //Item Storage Parts
    val STORAGE_PART_1K = registerItem("1k Storage Part")
    val STORAGE_PART_4K = registerItem("4k Storage Part")
    val STORAGE_PART_16K = registerItem("16k Storage Part")
    val STORAGE_PART_64K = registerItem("64k Storage Part")
    val STORAGE_PART_256K = registerItem("256k Storage Part")
    val STORAGE_PART_1024K = registerItem("1024k Storage Part")
    val STORAGE_PART_4096K = registerItem("4096k Storage Part") //I honestly doubt anyone will ever use more than this in vanilla

    //Item Storage Disks
    val STORAGE_DISK_1K = registerItem("1k Storage Disk")
    val STORAGE_DISK_4K = registerItem("4k Storage Disk")
    val STORAGE_DISK_16K = registerItem("16k Storage Disk")
    val STORAGE_DISK_64K = registerItem("64k Storage Disk")
    val STORAGE_DISK_256K = registerItem("256k Storage Disk")
    val STORAGE_DISK_1024K = registerItem("1024k Storage Disk")
    val STORAGE_DISK_4096K = registerItem("4096k Storage Disk") //I honestly doubt anyone will ever use more than this in vanilla

    //Fluid Storage Parts
    val FLUID_STORAGE_PART_1K = registerItem("1k Fluid Storage Part")
    val FLUID_STORAGE_PART_4K = registerItem("4k Fluid Storage Part")
    val FLUID_STORAGE_PART_16K = registerItem("16k Fluid Storage Part")
    val FLUID_STORAGE_PART_64K = registerItem("64k Fluid Storage Part")
    val FLUID_STORAGE_PART_256K = registerItem("256k Fluid Storage Part")
    val FLUID_STORAGE_PART_1024K = registerItem("1024k Fluid Storage Part")
    val FLUID_STORAGE_PART_4096K = registerItem("4096k Fluid Storage Part") //I honestly doubt anyone will ever use more than this in vanilla

    //Fluid Storage Disks
    val FLUID_STORAGE_DISK_1K = registerItem("1k Fluid Storage Disk")
    val FLUID_STORAGE_DISK_4K = registerItem("4k Fluid Storage Disk")
    val FLUID_STORAGE_DISK_16K = registerItem("16k Fluid Storage Disk")
    val FLUID_STORAGE_DISK_64K = registerItem("64k Fluid Storage Disk")
    val FLUID_STORAGE_DISK_256K = registerItem("256k Fluid Storage Disk")
    val FLUID_STORAGE_DISK_1024K = registerItem("1024k Fluid Storage Disk")
    val FLUID_STORAGE_DISK_4096K = registerItem("4096k Fluid Storage Disk") //I honestly doubt anyone will ever use more than this in vanilla

    //Devices
    val WIRELESS_STORAGE_INTERFACE = registerItem("Wireless Storage Interface")
    val WIRELESS_FLUID_STORAGE_INTERFACE = registerItem("Wireless Fluid Storage Interface")
    val WIRELESS_CRAFTING_MONITOR = registerItem("Wireless Crafting Monitor") //Auto-crafting can be done in a later release, just registering the item for now
    val NETWORK_CARD = registerItem("Network Card")
    val WRENCH = registerItem("Wrench")
    val FILTER = registerItem("Filter")
    val QUARTZ_ENRICHED_IRON = registerItem("Quartz Enriched Iron")

    //Upgrades
    val UPGRADE_MODULE_BASE = registerItem("Upgrade Module")
    val UPGRADE_MODULE_SPEED = registerItem("Speed Upgrade Module")
    val UPGRADE_MODULE_STACK = registerItem("Stack Upgrade Module")
    val UPGRADE_MODULE_CRAFTING = registerItem("Crafting Upgrade Module")
    val UPGRADE_MODULE_SILK_TOUCH = registerItem("Silk Touch Upgrade Module")
    val UPGRADE_MODULE_FORTUNE = registerItem("Fortune Upgrade Module")
    val UPGRADE_MODULE_RANGE = registerItem("Range Upgrade Module")
    val UPGRADE_MODULE_REGULATOR = registerItem("Regulator Upgrade Module")
    val UPGRADE_MODULE_INTERDIMENSIONAL = registerItem("Interdimensional Upgrade Module")

    //Misc Items
    val STORAGE_HOUSING = registerItem("Storage Housing")
    val PROCESSOR_BINDING = registerItem("Processor Binding")
    val CONSTRUCTION_CORE = registerItem("Construction Core")
    val DESTRUCTION_CORE = registerItem("Destruction Core")
    val BLANK_PATTERN = registerItem("Blank Pattern")
    val PROCESSING_PATTERN = registerItem("Processing Pattern")
    val SECURITY_CARD = registerItem("Security Card")

    //Raw Processors
    val RAW_BASIC_PROCESSOR = registerItem("Raw Basic Processor")
    val RAW_IMPROVED_PROCESSOR = registerItem("Raw Improved Processor")
    val RAW_ADVANCED_PROCESSOR = registerItem("Raw Advanced Processor")
    val RAW_ELITE_PROCESSOR = registerItem("Raw Elite Processor")
    val RAW_ULTIMATE_PROCESSOR = registerItem("Raw Ultimate Processor")

    //Processors
    val BASIC_PROCESSOR = registerItem("Basic Processor")
    val IMPROVED_PROCESSOR = registerItem("Improved Processor")
    val ADVANCED_PROCESSOR = registerItem("Advanced Processor")
    val ELITE_PROCESSOR = registerItem("Elite Processor")
    val ULTIMATE_PROCESSOR = registerItem("Ultimate Processor")

    //Block Items
    val BLOCK_ITEMS = HashMap<NovaBlock, NovaItem>()
}