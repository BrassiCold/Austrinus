package `fun`.brassicold.austrinus.util

import `fun`.brassicold.austrinus.Austrinus.setting

object ObtainSettingUtil  {
        var setting_DropItemOrder_maxOrder = setting["ItemDropOrder.maxOrder"]?.toString()?.toInt()
        var setting_DropItemOrder_minOrder = setting["ItemDropOrder.minOrder"]?.toString()?.toInt()
        var setting_DropItemOrder_percentOrder = setting["ItemDropOrder.percentOrder"]?.toString()
        var setting_InventoryItemDrop: Boolean = setting["InventoryItemDrop"].toString().toBoolean()
}