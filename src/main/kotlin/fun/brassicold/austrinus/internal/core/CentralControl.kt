package `fun`.brassicold.austrinus.internal.core

import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_maxOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_percentOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_minOrder
import `fun`.brassicold.austrinus.util.percentInto
import taboolib.common.util.random


object CentralControl {
    private fun dropItemOrder(): Any? {
        val dropItemOrder = setting_DropItemOrder_percentOrder?.let { percentInto(it) }
        if (dropItemOrder == null) {
            if (setting_DropItemOrder_maxOrder == setting_DropItemOrder_minOrder) {
                return setting_DropItemOrder_maxOrder
            }
            return setting_DropItemOrder_minOrder?.let { setting_DropItemOrder_maxOrder?.let { it1 -> random(it, it1) } }
        }
        return dropItemOrder
    }
    fun DropOrder(inventoryOrder: Int): Int {
        val dropOrder = dropItemOrder().toString().toDouble()
       if (dropOrder > inventoryOrder) {
           return inventoryOrder
       } else if (dropOrder < 1) {
           return (inventoryOrder * dropOrder).toInt()
       }
        return dropOrder.toInt()
    }
}