package `fun`.brassicold.austrinus.util


import `fun`.brassicold.austrinus.Austrinus
import `fun`.brassicold.austrinus.Austrinus.setting
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_maxOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_minOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_percentOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_InventoryItemDrop
import taboolib.common.platform.event.SubscribeEvent

object SettingManager {
    private fun loadSetting() {
        setting_DropItemOrder_maxOrder = setting["ItemDropOrder.maxOrder"]?.toString()?.toInt()
        setting_DropItemOrder_minOrder = setting["ItemDropOrder.minOrder"]?.toString()?.toInt()
        setting_DropItemOrder_percentOrder = setting["ItemDropOrder.percentOrder"]?.toString()
        setting_InventoryItemDrop = setting["InventoryItemDrop"].toString().toBoolean()
    }

    @SubscribeEvent
    fun opr(opr: PluginReloadEvent) {
        setting.reload()
        loadSetting()
    }
}