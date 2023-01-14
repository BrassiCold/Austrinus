package `fun`.brassicold.austrinus.util

import org.bukkit.inventory.PlayerInventory

fun dropItem(dropList: ArrayList<Int>, inventory: PlayerInventory) {
    for (slot in dropList) {
        val itemStack = inventory.getItem(slot)
        if (itemStack != null) {
            inventory.clear(slot)
        }
    }
}