package `fun`.brassicold.austrinus.internal.core

import `fun`.brassicold.austrinus.internal.core.CentralControl.DropOrder
import `fun`.brassicold.austrinus.util.*
import org.bukkit.entity.Player


object PlayerDeathRandomDrop {
    fun playerDeathRandomDrop(deathPlayer: Player) {
        val deathPlayerInventory = deathPlayer.inventory //获取死亡玩家背包
        val deathPlayerInventoryOrder = itemInventoryNumber(deathPlayerInventory)  //获取玩家非空格子的数量
        val deathPlayerDropItemOrder = DropOrder(deathPlayerInventoryOrder) //获取定义的掉落数量
        val itemLocations: ArrayList<Int> = obtainPlayerInventoryLocation(deathPlayerInventory) //获取非空格子位置
        itemLocations.shuffle() //打乱顺序
        val dropList = ArrayList<Int>()
        if (deathPlayerDropItemOrder <= itemLocations.size) { for (i in 0 until deathPlayerDropItemOrder) { dropList.add(itemLocations[i]) } }
        dropList.sort()
        val obtainItemNumber = obtainNumber(dropList, deathPlayerInventory)
        dropItem(dropList, deathPlayerInventory)
        dropItemAtDeath(dropList, deathPlayerInventory, deathPlayer)
    }
}

