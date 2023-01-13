package `fun`.brassicold.austrinus.internal.listener

import `fun`.brassicold.austrinus.internal.core.PlayerDeathRandomDrop
import org.bukkit.event.entity.PlayerDeathEvent
import taboolib.common.platform.event.SubscribeEvent

@SubscribeEvent
fun onPluginDeath(event: PlayerDeathEvent) {
        event.keepInventory = true
        event.drops.clear()
        PlayerDeathRandomDrop()
}
