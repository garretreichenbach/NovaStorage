package thederpgamer.novastorage.network

import thederpgamer.novastorage.network.device.Device

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
class Network(id: Int, data: ByteArray) {

    init {
        deserialize(data)
    }

    /**
     * The unique ID of the network.
     */
    val id: Int = id

    /**
     * The map of device id's and devices on the network
     */
    val devices: MutableMap<Int, Device> = mutableMapOf()

    fun deserialize(data: ByteArray) {
        devices.clear()
        var index = 0
        val idSize = data[index].toInt()
        index ++
        val idBytes = data.copyOfRange(index, index + idSize)
        index += idSize
        val id = String(idBytes).toInt()
        val deviceCount = data[index].toInt()
        index ++
        for(i in 0 until deviceCount) {
            val deviceSize = data[index].toInt()
            index ++
            val deviceBytes = data.copyOfRange(index, index + deviceSize)
            index += deviceSize

            //Get the device id
            val deviceIdSize = deviceBytes[index].toInt()
            index ++
            val deviceIdBytes = deviceBytes.copyOfRange(index, index + deviceIdSize)
            index += deviceIdSize
            val deviceId = String(deviceIdBytes).toInt()

            //Get the device type
            val typeSize = deviceBytes[index].toInt()
            index ++
            val typeBytes = deviceBytes.copyOfRange(index, index + typeSize)
            index += typeSize
            val type = String(typeBytes)

            //Get the device data
            val deviceDataSize = deviceBytes[index].toInt()
            index ++
            val deviceDataBytes = deviceBytes.copyOfRange(index, index + deviceDataSize)
            index += deviceDataSize

            //Create the device
            devices[deviceId] = Device(deviceId, type, deviceDataBytes)
        }
    }

    fun serialize(): ByteArray {
        val bytes = mutableListOf<Byte>()
        val idBytes = id.toString().toByteArray()
        bytes.add(idBytes.size.toByte())
        bytes.addAll(idBytes.toList())
        bytes.add(devices.size.toByte())
        for(device in devices.values) {
            val deviceBytes = device.serialize()
            bytes.add(deviceBytes.size.toByte())
            bytes.addAll(deviceBytes.toList())
        }
        return bytes.toByteArray()
    }

    fun getTotalPowerUsage(): Long {
        var totalPowerUsage = 0L
        for(device in devices.values) totalPowerUsage += device.getPowerUsage()
        return totalPowerUsage
    }

    fun getDeviceCount(): Int {
        return devices.size
    }

    fun delete() {
        TODO("Not yet implemented")
    }
}