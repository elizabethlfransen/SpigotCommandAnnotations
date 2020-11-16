package ml.chillgaming.spigotcommandannotations.exception;

/**
 * An exception that can occur when trying to initialize the CommandFramework.
 */
public class CommandFrameworkInitializationException extends RuntimeException {
    public CommandFrameworkInitializationException() {
    }

    public CommandFrameworkInitializationException(String message) {
        super(message);
    }

    public CommandFrameworkInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandFrameworkInitializationException(Throwable cause) {
        super(cause);
    }

    public CommandFrameworkInitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
