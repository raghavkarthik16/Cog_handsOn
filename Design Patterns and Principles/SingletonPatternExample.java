
class Logger {
    private static volatile Logger instance;

    private Logger() {
        System.out.println(" Logger initialized.");
    }

    public static Logger getInstance() {
        if (instance == null) { 
            synchronized (Logger.class) {
                if (instance == null) { 
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class SingletonPatternExample{
    
    public static void main(String[] args) {
        System.out.println("Starting the application...\n");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("System booted up.");
        logger2.log("Connecting to database.");

        System.out.println("\n--- Verification ---");
        
        if (logger1 == logger2) {
            System.out.println("SUCCESS: logger1 and logger2 are the exact same instance in memory.");
        } else {
            System.out.println("FAILURE: Multiple instances were created.");
        }
    }
}