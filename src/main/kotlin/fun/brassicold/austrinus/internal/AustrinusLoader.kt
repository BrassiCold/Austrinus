package `fun`.brassicold.austrinus.internal

import `fun`.brassicold.austrinus.Austrinus.PluginName
import `fun`.brassicold.austrinus.Austrinus.setting
import `fun`.brassicold.austrinus.util.ObtainSettingUtil
import `fun`.brassicold.austrinus.util.PluginReloadEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.console
import taboolib.module.lang.sendLang

object AustrinusLoader {
    fun load() {
        console().sendLang("plugin-load", PluginName)
    }

    fun enable() {
        console().sendLang("plugin-enable", PluginName)
    }

    fun disable() {
        console().sendLang("plugin-disable", PluginName)
    }

    @SubscribeEvent
    fun opr(opr: PluginReloadEvent) {
        setting.reload()
        ObtainSettingUtil()
    }
}