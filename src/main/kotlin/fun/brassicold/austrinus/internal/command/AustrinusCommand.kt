package `fun`.brassicold.austrinus.internal.command

import `fun`.brassicold.austrinus.util.ObtainSettingUtil
import `fun`.brassicold.austrinus.util.PluginReloadEvent
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.function.console
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

    @CommandBody(aliases = ["reload"], permission = "austrinus.command.help", permissionDefault = PermissionDefault.OP)
    val reload = subCommand {
        execute<ProxyCommandSender> { sender, _, _, ->
            PluginReloadEvent.call()
            sender.sendLang("command-reload", pluginId)
            if (ObtainSettingUtil.setting_DropItemOrder_percentOrder == null) {
                if (ObtainSettingUtil.setting_DropItemOrder_minOrder == ObtainSettingUtil.setting_DropItemOrder_maxOrder) {
                    ObtainSettingUtil.setting_DropItemOrder_maxOrder?.let { sender.sendLang("plugin-mode-number", pluginId, it) }
                } else {
                    ObtainSettingUtil.setting_DropItemOrder_minOrder?.let {
                        ObtainSettingUtil.setting_DropItemOrder_maxOrder?.let { it1 ->
                            sender.sendLang("plugin-mode-Order", pluginId,
                                it,
                                it1
                            )
                        }
                    }
                }
            } else {
                sender.sendLang("plugin-mode-percent", pluginId, ObtainSettingUtil.setting_DropItemOrder_percentOrder!!)
            }
        }
    }
}