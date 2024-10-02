// SingletonPattern.java
//Use Case: Logger System
public class SingletonPattern {
    public static void main(String[] args) {
        // Attempt to get two instances of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Application running.");

        // Verify that both logger references point to the same instance
        System.out.println("logger1 and logger2 are the same instance: " + (logger1 == logger2));
    }
}

// Logger class implementing Singleton Pattern using Double-Checked Locking
class Logger {
    // Volatile keyword ensures that multiple threads handle the instance correctly
    private static volatile Logger instance;
    private static final Object lock = new Object();

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize logger (e.g., open log file, set up resources)
    }

    // Public method to provide access to the singleton instance
    public static Logger getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (lock) { // Locking
                if (instance == null) { // Second check (with locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
