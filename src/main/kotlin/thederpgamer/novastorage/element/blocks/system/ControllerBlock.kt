package thederpgamer.novastorage.element.blocks.system

import thederpgamer.novastorage.element.blocks.Blocks
import thederpgamer.novastorage.network.Network
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.nova.data.config.NovaConfig
import xyz.xenondevs.nova.data.config.configReloadable
import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.tileentity.TileEntity
import xyz.xenondevs.nova.tileentity.menu.TileEntityMenuClass
import xyz.xenondevs.nova.tileentity.network.NetworkConnectionType
import xyz.xenondevs.nova.tileentity.network.energy.holder.ConsumerEnergyHolder
import xyz.xenondevs.nova.ui.EnergyBar
import xyz.xenondevs.nova.util.BlockSide

/**
 * Controller block data. The controller is the central block of the network. It stores power and manages all the other
 * blocks in the network.
 *
 * @author TheDerpGamerX
 */

private val BASE_CAPACITY = configReloadable { NovaConfig[Blocks.CONTROLLER_BLOCK].getLong("base_energy_capacity") }
private val BASE_USAGE = configReloadable { NovaConfig[Blocks.CONTROLLER_BLOCK].getLong("base_energy_usage") }

class ControllerBlock(blockState: NovaTileEntityState) : NetworkedTileEntity(blockState) {

    override val energyHolder = ConsumerEnergyHolder(this, BASE_CAPACITY, BASE_USAGE, null) {
        createSideConfig(NetworkConnectionType.BUFFER, BlockSide.FRONT)
        createSideConfig(NetworkConnectionType.BUFFER, BlockSide.BACK)
        createSideConfig(NetworkConnectionType.BUFFER, BlockSide.LEFT)
        createSideConfig(NetworkConnectionType.BUFFER, BlockSide.RIGHT)
        createSideConfig(NetworkConnectionType.BUFFER, BlockSide.TOP)
        createSideConfig(NetworkConnectionType.BUFFER, BlockSide.BOTTOM)
    }

    @TileEntityMenuClass
    inner class ControllerMenu : TileEntity.GlobalTileEntityMenu() { //Todo: Replace with GUITexture
        override val gui = Gui.normal()
                .setStructure(
                        "1 - - - - - - - 2",
                        "| e # # # # # # |",
                        "| e # # # # # # |",
                        "| e # # # # # # |",
                        "3 - - - - - - - 4")
                .addIngredient('e', EnergyBar(3, energyHolder))
                .build()
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
        initNetwork()
        getNetwork().serialize()
    }

    /**
     * Called when the TileEntity is unloaded/broken.
     */
    override fun handleRemoved(unload: Boolean) {
        super.handleRemoved(unload)
        getNetwork().delete()
    }

    override fun saveData() {
        super.saveData()
        getNetwork().serialize()
    }

    fun getNetwork(): Network {

    }

    fun initNetwork() {
        //Create a new network

    }
}