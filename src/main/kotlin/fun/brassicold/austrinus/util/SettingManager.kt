package `fun`.brassicold.austrinus.util

import `fun`.brassicold.austrinus.Austrinus
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_maxOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_minOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_percentOrder
import taboolib.common.platform.event.SubscribeEvent

object SettingManager {
    private fun loadSetting() {
        setting_DropItemOrder_maxOrder = Austrinus.setting["ItemDropOrder.maxOrder"]?.toString()?.toInt()
        setting_DropItemOrder_minOrder = Austrinus.setting["ItemDropOrder.minOrder"]?.toString()?.toInt()
        setting_DropItemOrder_percentOrder = Austrinus.setting["ItemDropOrder.percentOrder"]?.toString()
    }

    @SubscribeEvent
    fun opr(opr: PluginReloadEvent) {
        Austrinus.setting.reload()
        loadSetting()
    }
}