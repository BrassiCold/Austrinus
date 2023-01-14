package `fun`.brassicold.austrinus.util

import org.bukkit.inventory.PlayerInventory

fun obtainNumber(slotList: ArrayList<Int>, inventory: PlayerInventory): ArrayList<Int> {
    val amountList = ArrayList<Int>()
    for (slot in slotList) {
        val itemStack = inventory.getItem(slot)
        val amount = itemStack?.amount
        amount?.let { amountList.add(it) }
    }
    return amountList
}