package `fun`.brassicold.austrinus.internal.listener

import org.bukkit.event.entity.PlayerDeathEvent
import taboolib.common.platform.event.SubscribeEvent
import `fun`.brassicold.austrinus.internal.core.PlayerDeathRandomDrop.playerDeathRandomDrop
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_Enabled
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_WorldOpen
import taboolib.common.platform.function.console
import taboolib.common.platform.function.pluginId
import taboolib.module.lang.sendLang


object PlayerDeathListener {
    private lateinit var DeathEvent: PlayerDeathEvent
    @SubscribeEvent
    fun onPluginDeath(event: PlayerDeathEvent): Boolean {
        if (!(setting_Enabled)) {
            return false
        }
        val playerOnWorld = event.entity.world.name
        if (setting_WorldOpen?.contains(playerOnWorld) == false) {
            console().sendLang("plugin-playerInWorld-false", pluginId)
            return false
        }
        DeathEvent = event
        DeathEvent.keepInventory = true
        playerDeathRandomDrop(DeathEvent.entity)
        console().sendLang("plugin-playerInWorld-true", pluginId)
        return true
    }
}

