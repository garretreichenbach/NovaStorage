package thederpgamer.novastorage;

import xyz.xenondevs.nova.addon.Addon;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class NovaStorage extends Addon {
	
	private static NovaStorage instance;
	
	public static NovaStorage getInstance() {
		return instance;
	}
	
	public NovaStorage() {
		instance = this;
	}
	
	@Override
	public void init() {
		// Called when the addon is initialized.
		instance = this;
	}
	
	@Override
	public void onEnable() {
		// Called when the addon is enabled.
		instance = this;
	}
	
	@Override
	public void onDisable() {
		// Called when the addon is disabled.
	}
}
