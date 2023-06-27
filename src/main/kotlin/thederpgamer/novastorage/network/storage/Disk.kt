package thederpgamer.novastorage.network.storage

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
class Disk(id: Int, name: String, capacity: Long, data: ByteArray) {

    init {
        deserialize(data)
    }

    /**
     * The unique ID of the disk.
     */
    var id: Int = id

    /**
     * The name of the disk.
     */
    var name: String = name

    /**
     * The capacity of the disk.
     */
    val capacity: Long = capacity

    /**
     * The amount of data stored on the disk.
     */
    val dataAmount: Long = data.size.toLong()

    /**
     * The amount of free space on the disk.
     */
    val freeSpace: Long = capacity - dataAmount

    /**
     * The percentage of the disk that is full.
     */
    val percentFull: Double = dataAmount.toDouble() / capacity.toDouble()

    /**
     * The percentage of the disk that is empty.
     */
    val percentEmpty: Double = freeSpace.toDouble() / capacity.toDouble()

    /**
     * The items stored on the disk.
     */
    val items: MutableMap<String, Int> = mutableMapOf()

    /**
     * Serializes the disk into a byte array.
     */
    fun serialize(): ByteArray {
        val bytes = mutableListOf<Byte>()
        val idBytes = id.toString().toByteArray()
        bytes.add(idBytes.size.toByte())
        bytes.addAll(idBytes.toList())
        val nameBytes = name.toByteArray()
        bytes.add(nameBytes.size.toByte())
        bytes.addAll(nameBytes.toList())
        val capacityBytes = capacity.toString().toByteArray()
        bytes.add(capacityBytes.size.toByte())
        bytes.addAll(capacityBytes.toList())
        val dataAmountBytes = dataAmount.toString().toByteArray()
        bytes.add(dataAmountBytes.size.toByte())
        bytes.addAll(dataAmountBytes.toList())
        val itemsSize = items.size
        bytes.add(itemsSize.toByte())
        for(item in items) {
            val itemBytes = item.key.toByteArray()
            bytes.add(itemBytes.size.toByte())
            bytes.addAll(itemBytes.toList())
            val amountBytes = item.value.toString().toByteArray()
            bytes.add(amountBytes.size.toByte())
            bytes.addAll(amountBytes.toList())
        }
        return bytes.toByteArray()
    }

    /**
     * Deserializes the disk from a byte array.
     */
    fun deserialize(data: ByteArray) {
        items.clear()
        var index = 0
        val idSize = data[index].toInt()
        index ++
        val idBytes = data.copyOfRange(index, index + idSize)
        index += idSize
        val id = String(idBytes).toInt()

        val nameSize = data[index].toInt()
        index ++
        val nameBytes = data.copyOfRange(index, index + nameSize)
        index += nameSize
        val name = String(nameBytes)

        val capacitySize = data[index].toInt()
        index ++
        val capacityBytes = data.copyOfRange(index, index + capacitySize)
        index += capacitySize
        val capacity = String(capacityBytes).toLong()

        val dataAmountSize = data[index].toInt()
        index ++
        val dataAmountBytes = data.copyOfRange(index, index + dataAmountSize)
        index += dataAmountSize
        val dataAmount = String(dataAmountBytes).toLong()
        val itemsSize = data[index].toInt()
        index ++
        this.id = id
        this.name = name
        for(i in 0 until itemsSize) {
            val itemNameSize = data[index].toInt()
            index ++
            val itemNameBytes = data.copyOfRange(index, index + itemNameSize)
            index += itemNameSize
            val itemName = String(itemNameBytes)
            val itemAmountSize = data[index].toInt()
            index ++
            val itemAmountBytes = data.copyOfRange(index, index + itemAmountSize)
            index += itemAmountSize
            val itemAmount = String(itemAmountBytes).toInt()
            items[itemName] = itemAmount
        }
    }
}