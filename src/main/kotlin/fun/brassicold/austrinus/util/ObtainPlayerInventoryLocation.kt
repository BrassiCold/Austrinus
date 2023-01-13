package `fun`.brassicold.austrinus.util

import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_InventoryItemDrop
import org.bukkit.inventory.PlayerInventory

fun obtainPlayerInventoryLocation(playerInventory: PlayerInventory): ArrayList<Int> {
    val itemLocations = ArrayList<Int>()
    if (setting_InventoryItemDrop) {
        for (i in 10 until playerInventory.size) {
            if (playerInventory.getItem(i) != null) {
                itemLocations.add(i)
            }
        }
        return itemLocations
    }
    for (i in 0 until playerInventory.size) {
        if (playerInventory.getItem(i) != null) {
            itemLocations.add(i)
        }
    }
    return itemLocations
}