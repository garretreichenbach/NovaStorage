package thederpgamer.novastorage.network.device

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
class Device(id: Int, type: String, data: ByteArray) {

    init {
        deserialize(data)
    }

    /**
     * The unique ID of the device.
     */
    var id: Int = id

    /**
     * The type of the device.
     */
    var type: String = type

    /**
     * The data of the device.
     */
    var data: ByteArray = data

    fun deserialize(data: ByteArray) {
        var index = 0
        val idSize = data[index].toInt()
        index ++
        val idBytes = data.copyOfRange(index, index + idSize)
        index += idSize
        val id = String(idBytes).toInt()

        val typeSize = data[index].toInt()
        index ++
        val typeBytes = data.copyOfRange(index, index + typeSize)
        index += typeSize
        val type = String(typeBytes)

        val dataSize = data[index].toInt()
        index ++
        val dataBytes = data.copyOfRange(index, index + dataSize)
        index += dataSize
        val data = dataBytes

        this.id = id
        this.type = type
        this.data = data
    }

    fun serialize(): ByteArray {
        val idBytes = id.toString().toByteArray()
        val typeBytes = type.toByteArray()
        val dataBytes = data

        val idSize = idBytes.size.toByte()
        val typeSize = typeBytes.size.toByte()
        val dataSize = dataBytes.size.toByte()

        val bytes = ByteArray(idBytes.size + typeBytes.size + dataBytes.size + 3)
        var index = 0
        bytes[index] = idSize
        index ++
        for(i in 0 until idBytes.size) {
            bytes[index] = idBytes[i]
            index ++
        }
        bytes[index] = typeSize
        index ++
        for(i in 0 until typeBytes.size) {
            bytes[index] = typeBytes[i]
            index ++
        }
        bytes[index] = dataSize
        index ++
        for(i in 0 until dataBytes.size) {
            bytes[index] = dataBytes[i]
            index ++
        }
        return bytes
    }

    fun getPowerUsage(): Long {

    }
}