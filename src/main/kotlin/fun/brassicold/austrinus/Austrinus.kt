package `fun`.brassicold.austrinus

import `fun`.brassicold.austrinus.internal.AustrinusLoader.disable
import `fun`.brassicold.austrinus.internal.AustrinusLoader.enable
import `fun`.brassicold.austrinus.internal.AustrinusLoader.load
import taboolib.common.platform.Plugin

object Austrinus : Plugin() {

    override fun onLoad() {
        load()
    }

    override fun onEnable() {
        enable()
    }

    override fun onDisable() {
        disable()
    }
}