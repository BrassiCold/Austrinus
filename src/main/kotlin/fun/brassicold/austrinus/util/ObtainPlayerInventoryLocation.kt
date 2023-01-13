package `fun`.brassicold.austrinus.util

import org.bukkit.inventory.PlayerInventory

fun obtainPlayerInventoryLocation(playerInventory: PlayerInventory): ArrayList<Int> {
    val itemLocations = ArrayList<Int>()
    for (i in 0 until playerInventory.size) {
        if (playerInventory.getItem(i) != null) {
            itemLocations.add(i)
        }
    }
    return itemLocations
}