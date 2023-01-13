package `fun`.brassicold.austrinus.internal.core

import `fun`.brassicold.austrinus.internal.core.CentralControl.DropOrder
import `fun`.brassicold.austrinus.util.itemInventoryNumber
import `fun`.brassicold.austrinus.util.obtainPlayerInventoryLocation
import org.bukkit.entity.Player
import taboolib.common.platform.function.console
import java.util.Calendar


object PlayerDeathRandomDrop {
    fun playerDeathRandomDrop(deathPlayer: Player) {
        console().sendMessage("§7|---------------【§bDebug调试信息开始§7】---------------")
        console().sendMessage("§7|-传入的DeathPlayer值为$deathPlayer | 类型为${deathPlayer::class.simpleName}")
        val deathPlayerInventory = deathPlayer.inventory //获取死亡玩家背包
        console().sendMessage("§7|-定义的变量deathPlayerInventory的值为$deathPlayerInventory | 类型为${deathPlayerInventory::class.simpleName}")
        val deathPlayerInventoryOrder = itemInventoryNumber(deathPlayerInventory)  //获取玩家非空格子的数量
        console().sendMessage("§7|-定义的变量deathPlayerInventoryOrder的值为$deathPlayerInventoryOrder | 类型为${deathPlayerInventoryOrder::class.simpleName}")
        val deathPlayerDropItemOrder = DropOrder(deathPlayerInventoryOrder) //获取定义的掉落数量
        console().sendMessage("§7|-定义的变量deathPlayerDropItemOrder的值为$deathPlayerDropItemOrder | 类型为${deathPlayerDropItemOrder::class.simpleName}")
        val itemLocations: ArrayList<Int> = obtainPlayerInventoryLocation(deathPlayerInventory) //获取非空格子位置
        console().sendMessage("§7|-定义的变量itemLocation的值为$itemLocations | 类型为${itemLocations::class.simpleName}")
        itemLocations.shuffle() //打乱顺序
        console().sendMessage("§7|-打乱后的变量itemLocation的值为$itemLocations | 类型为${itemLocations::class.simpleName}")
        val dropList = ArrayList<Int>()
        if (deathPlayerDropItemOrder <= itemLocations.size) { for (i in 0 until deathPlayerDropItemOrder) { dropList.add(itemLocations[i]) } }
        console().sendMessage("§7|-定义的实际掉落物品格数量为$deathPlayerDropItemOrder | 类型为${deathPlayerDropItemOrder::class.simpleName}")
        console().sendMessage("§7|-定义的预备掉落物品格为$dropList | 数量[${dropList.size}] | 类型为${dropList::class.simpleName}")
        dropList.sort()
        console().sendMessage("§7|-定义的掉落格列表已排序完成 | $dropList | 类型为${dropList::class.simpleName}")
        console().sendMessage("§7|---------------【§bDebug调试信息结束§7】---------------")
    }
}

