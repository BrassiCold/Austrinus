package `fun`.brassicold.austrinus.internal.command

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

    @CommandBody(aliases = ["reload"], permission = "austrinus.command.help", permissionDefault = PermissionDefault.OP)
    val reload = subCommand {
        execute<ProxyCommandSender> { sender, _, _, ->
            PluginReloadEvent.call()
            sender.sendLang("command-reload", pluginId)
        }
    }
}