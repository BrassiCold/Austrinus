package `fun`.brassicold.austrinus.util


import `fun`.brassicold.austrinus.Austrinus
import `fun`.brassicold.austrinus.Austrinus.setting
import `fun`.brassicold.austrinus.internal.core.CentralControl.DropOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_maxOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_minOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_percentOrder
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.console
import taboolib.common.platform.function.pluginId
import taboolib.module.lang.sendLang

object SettingManager {
    private fun loadSetting() {
        setting_DropItemOrder_maxOrder = setting["ItemDropOrder.maxOrder"]?.toString()?.toInt()
        setting_DropItemOrder_minOrder = setting["ItemDropOrder.minOrder"]?.toString()?.toInt()
        setting_DropItemOrder_percentOrder = setting["ItemDropOrder.percentOrder"]?.toString()
    }

    @SubscribeEvent
    fun opr(opr: PluginReloadEvent) {
        setting.reload()
        loadSetting()
        if (setting_DropItemOrder_percentOrder == null) {
            if (setting_DropItemOrder_minOrder == setting_DropItemOrder_maxOrder) {
                setting_DropItemOrder_maxOrder?.let { console().sendLang("plugin-mode-number", pluginId, it) }
            } else {
                setting_DropItemOrder_minOrder?.let {
                    setting_DropItemOrder_maxOrder?.let { it1 ->
                        console().sendLang("plugin-mode-Order", pluginId,
                            it,
                            it1
                        )
                    }
                }
            }
        } else {
            console().sendLang("plugin-mode-percent", pluginId, setting_DropItemOrder_percentOrder!!)
        }
    }
}