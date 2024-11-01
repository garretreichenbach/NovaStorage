package thederpgamer.novastorage.element.blocks;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class Blocks {
	
	private static final BlockOptions SYSTEM_BLOCK_PROPERTIES = new BlockOptions(3.0, VanillaToolCategories.PICKAXE, VanillaToolTiers.STONE, true, SoundGroup.STONE, Material.STONE);

	public static final Block CONTROLLER_BLOCK = new ControllerBlock().blockOptions(SYSTEM_BLOCK_PROPERTIES).properties(Directional.NORMAL).register();
	public static final Block DISK_DRIVE = new DiskDriveBlock().blockOptions(SYSTEM_BLOCK_PROPERTIES).properties(Directional.NORMAL).register();

	public static void registerBlockItem() {
		Items.BLOCK_ITEMS.put(CONTROLLER_BLOCK, Items.registerItem(CONTROLLER_BLOCK));
		Items.BLOCK_ITEMS.put(DISK_DRIVE, Items.registerItem(DISK_DRIVE));
	}
}
