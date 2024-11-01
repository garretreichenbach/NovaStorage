package thederpgamer.novastorage.element.blocks.system;

import org.jetbrains.annotations.NotNull;
import thederpgamer.novastorage.element.blocks.BlocksOld;
import xyz.xenondevs.cbf.Compound;
import xyz.xenondevs.nova.data.config.NovaConfig;
import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState;
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class ControllerBlock extends NetworkedTileEntity {
	
	public ControllerBlock(@NotNull NovaTileEntityState blockState) {
		super(blockState);
		NovaConfig.INSTANCE.get(BlocksOld.CONTROLLER_BLOCK);
	}

	@Override
	public @NotNull Compound getData() {
		return null;
	}
}
