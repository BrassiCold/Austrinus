package `fun`.brassicold.austrinus.internal.command

import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_maxOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_minOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_DropItemOrder_percentOrder
import `fun`.brassicold.austrinus.util.ObtainSettingUtil.setting_InventoryItemDrop
import `fun`.brassicold.austrinus.util.PluginReloadEvent
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.function.pluginId
import taboolib.module.lang.sendLang

@CommandHeader(
    name = "austrinus",
    aliases = ["au"],
    permission = "austrinus.command",
    permissionDefault = PermissionDefault.OP,
    description = "Austrinus Main Command"
)

object AustrinusCommand {
    @CommandBody(aliases = ["help"], permission = "austrinus.command.help", permissionDefault = PermissionDefault.OP)
    val main = mainCommand {
        execute<ProxyCommandSender> { sender, _, _, ->
            sender.sendLang("command-help")
        }
    }

    @CommandBody(aliases = ["help"], permission = "austrinus.command.help", permissionDefault = PermissionDefault.OP)
    val help = subCommand {
        execute<ProxyCommandSender> { sender, _, _, ->
            sender.sendLang("command-help")
        }
    }

    @CommandBody(aliases = ["reload"], permission = "austrinus.command.help", permissionDefault = PermissionDefault.OP)
    val reload = subCommand {
        execute<ProxyCommandSender> { sender, _, _, ->
            PluginReloadEvent.call()
            sender.sendLang("command-reload", pluginId)
            if (setting_DropItemOrder_percentOrder == null) {
                if (setting_DropItemOrder_minOrder == setting_DropItemOrder_maxOrder) {
                    setting_DropItemOrder_maxOrder?.let { sender.sendLang("plugin-mode-number", pluginId, it) }
                } else {
                    setting_DropItemOrder_minOrder?.let {
                        setting_DropItemOrder_maxOrder?.let { it1 ->
                            sender.sendLang("plugin-mode-Order", pluginId,
                                it,
                                it1
                            )
                        }
                    }
                }
            } else {
                sender.sendLang("plugin-mode-percent", pluginId, setting_DropItemOrder_percentOrder!!)
            }
            if (setting_InventoryItemDrop) {
                sender.sendLang("plugin-mods-inventory-true", pluginId)
            } else {
                sender.sendLang("plugin-mode-inventory-false", pluginId)
            }
        }
    }
}