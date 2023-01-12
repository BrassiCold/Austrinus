package `fun`.brassicold.austrinus.util

import `fun`.brassicold.austrinus.Austrinus.setting

object ObtainSettingUtil  {
    var setting_DropItemOrder_maxOrder = setting["ItemDropOrder.maxOrder"].toString().toInt()
    var setting_DropItemOrder_minOrder = setting["ItemDropOrder.minOrder"].toString().toInt()
    var setting_DropItemOrder_percentOrder = setting["ItemDropOrder.percentOrder"].toString()

    fun obtainSettingUtil() {
        setting_DropItemOrder_maxOrder = setting["ItemDropOrder.maxOrder"].toString().toInt()
        setting_DropItemOrder_minOrder = setting["ItemDropOrder.minOrder"].toString().toInt()
        setting_DropItemOrder_percentOrder = setting["ItemDropOrder.percentOrder"].toString()
    }
}