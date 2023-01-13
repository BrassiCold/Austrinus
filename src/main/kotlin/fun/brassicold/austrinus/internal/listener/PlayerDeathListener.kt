package `fun`.brassicold.austrinus.internal.listener

import org.bukkit.event.entity.PlayerDeathEvent
import taboolib.common.platform.event.SubscribeEvent
import `fun`.brassicold.austrinus.internal.core.PlayerDeathRandomDrop.playerDeathRandomDrop


object PlayerDeathListener {
    private lateinit var DeathEvent: PlayerDeathEvent
    @SubscribeEvent
    fun onPluginDeath(event: PlayerDeathEvent) {
        DeathEvent = event
        DeathEvent.keepInventory = true
        playerDeathRandomDrop(DeathEvent.entity)
    }
}

