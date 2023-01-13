package `fun`.brassicold.austrinus.internal

import taboolib.common.platform.function.console
import taboolib.common.platform.function.pluginId
import taboolib.module.lang.sendLang

object AustrinusLoader {
    fun load() {
        console().sendLang("plugin-load", pluginId)
    }

    fun enable() {
        console().sendLang("plugin-enable", pluginId)
    }

    fun disable() {
        console().sendLang("plugin-disable", pluginId)
    }
}