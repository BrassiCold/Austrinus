package `fun`.brassicold.austrinus.internal.core

import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_maxOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_minOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_percentOrder
import `fun`.brassicold.austrinus.util.percentInto
import taboolib.common.util.random

object CentralControl {
    fun DropItemOrder(): Int {
        val dropItemOrder = percentInto(setting_DropItemOrder_percentOrder)
        if (dropItemOrder == null) {
            if (setting_DropItemOrder_maxOrder == setting_DropItemOrder_minOrder) {
                return setting_DropItemOrder_maxOrder
            }
            return random(setting_DropItemOrder_minOrder, setting_DropItemOrder_maxOrder)
        }
        return dropItemOrder
    }
}