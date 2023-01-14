package `fun`.brassicold.austrinus.util

import `fun`.brassicold.austrinus.Austrinus.setting
import taboolib.common.util.asList

object ObtainSettingUtil  {
        var setting_DropItemOrder_maxOrder = setting["ItemDropOrder.maxOrder"]?.toString()?.toInt()
        var setting_DropItemOrder_minOrder = setting["ItemDropOrder.minOrder"]?.toString()?.toInt()
        var setting_DropItemOrder_percentOrder = setting["ItemDropOrder.percentOrder"]?.toString()
        var setting_InventoryItemDrop: Boolean = setting["InventoryItemDrop"].toString().toBoolean()
        var setting_WorldOpen: List<String>? = setting["World-open"]?.asList()
        var setting_Enabled: Boolean = setting["ItemDropOrder.enabled"].toString().toBoolean()
}