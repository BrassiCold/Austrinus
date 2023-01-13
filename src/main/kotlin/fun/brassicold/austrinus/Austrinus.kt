package `fun`.brassicold.austrinus

import `fun`.brassicold.austrinus.internal.AustrinusLoader.disable
import `fun`.brassicold.austrinus.internal.AustrinusLoader.enable
import `fun`.brassicold.austrinus.internal.AustrinusLoader.load
import taboolib.common.platform.Platform
import taboolib.common.platform.Plugin
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigFile
import taboolib.module.metrics.Metrics
import taboolib.platform.BukkitPlugin

object Austrinus : Plugin() {

    @Config("setting.yml", true, autoReload = true)
    lateinit var setting: ConfigFile

    override fun onLoad() {

        load()
    }

    override fun onEnable() {
        Metrics(17402, BukkitPlugin.getInstance().description.version, Platform.BUKKIT)
        enable()
    }

    override fun onDisable() {
        disable()
    }
}