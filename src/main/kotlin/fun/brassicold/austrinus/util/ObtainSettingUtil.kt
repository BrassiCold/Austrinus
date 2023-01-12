package `fun`.brassicold.austrinus.util

import `fun`.brassicold.austrinus.Austrinus.setting

object ObtainSettingUtil {
    val setting_DropItemOrder_maxOrder = setting["ItemDropOrder.maxOrder"].toString().toInt()
    val setting_DropItemOrder_minOrder = setting["ItemDropOrder.minOrder"].toString().toInt()
    val setting_DropItemOrder_percentOrder = setting["ItemDropOrder.percentOrder"].toString()
}