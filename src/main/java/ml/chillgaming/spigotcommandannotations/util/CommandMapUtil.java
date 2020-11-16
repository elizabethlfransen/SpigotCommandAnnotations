package ml.chillgaming.spigotcommandannotations.util;

import ml.chillgaming.spigotcommandannotations.exception.CommandFrameworkInitializationException;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class CommandMapUtil {
    private static CommandMap commandMap;
    private static Constructor<PluginCommand> pluginCommandConstructor;

    private CommandMapUtil() {
    }

    public static CommandMap getCommandMap(Server server) {
        if(commandMap == null) {
            try {
                Method getter = server.getClass().getDeclaredMethod("getCommandMap");
                getter.setAccessible(true);
                commandMap = (CommandMap) getter.invoke(server);
                if(commandMap == null) {
                    throw new CommandFrameworkInitializationException("getCommandMap returned null.");
                }
            } catch (NoSuchMethodException e) {
                throw new CommandFrameworkInitializationException("Method getCommandMap does not exist on server.", e);
            } catch (Exception e) {
                throw new CommandFrameworkInitializationException("Unable to access getCommandMap method on server.", e);
            }
        }
        return commandMap;
    }

    public static CommandMap getCommandMap() {
        return getCommandMap(Bukkit.getServer());
    }
}
