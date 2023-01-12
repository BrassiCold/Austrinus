package `fun`.brassicold.austrinus.internal

import taboolib.common.platform.function.console
import taboolib.module.lang.sendLang

object AustrinusLoader {

    fun load() {
        console().sendLang("plugin-load")
    }

    fun enable() {
        console().sendLang("plugin-enable")
    }

    fun disable() {
        console().sendLang("plugin-disable")
    }
}