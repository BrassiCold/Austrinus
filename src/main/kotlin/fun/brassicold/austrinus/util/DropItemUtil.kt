package `fun`.brassicold.austrinus.util

import org.bukkit.entity.Player
import org.bukkit.inventory.PlayerInventory

fun dropItemAtDeath(dropList: ArrayList<Int>, inventory: PlayerInventory, player: Player) {
    if (dropList.isEmpty() || obtainNumber(dropList, inventory).isEmpty()) return
    val playerLocation = player.location
    val world = player.world
    val amountList = obtainNumber(dropList, inventory)
    for ((index, slot) in dropList.withIndex()) {
        val itemStack = inventory.getItem(slot)
        val amount = amountList[index]
        val item = itemStack?.clone()
        if (item != null) {
            item.amount = amount
        }
        item?.let { world.dropItem(playerLocation, it) }
        inventory.clear(slot)
    }
}