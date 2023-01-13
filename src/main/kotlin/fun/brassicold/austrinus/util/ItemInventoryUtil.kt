package `fun`.brassicold.austrinus.util

import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_InventoryItemDrop
import org.bukkit.inventory.PlayerInventory

fun itemInventoryNumber(inventory: PlayerInventory): Int {
    val list =ArrayList<Int>()
    if (setting_InventoryItemDrop) {
        for (i in 9 until 37) {
            if (inventory.getItem(i) != null) {
                list.add(i)
            }
        }
        return list.size
    }
    return inventory.filterNotNull().size
}