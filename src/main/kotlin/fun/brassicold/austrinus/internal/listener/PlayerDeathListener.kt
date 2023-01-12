package `fun`.brassicold.austrinus.internal.listener

import `fun`.brassicold.austrinus.internal.core.PlayerDeathRandomDrop
import org.bukkit.event.entity.PlayerDeathEvent

object PlayerDeathListener {
    fun onPluginDeath(event: PlayerDeathEvent) {
        event.keepInventory = true
        PlayerDeathRandomDrop()
    }
}