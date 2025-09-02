import java.util.Scanner;

interface Logger {
    void log(String message);
}

class FileLogger implements Logger {
    public void log(String message) {
        System.out.println("FileLogger: " + message);
    }
}

class CloudLogger implements Logger {
    public void log(String message) {
        System.out.println("CloudLogger: " + message);
    }
}

class DatabaseLogger implements Logger {
    public void log(String message) {
        System.out.println("DatabaseLogger: " + message);
    }
}

class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void doSomething() {
        logger.log("Application started");
        logger.log("Processing some task...");
        logger.log("Application finished");
    }
}

public class exp2b2 {
    public static void main(String[] args) {
        System.out.println("Do you want the default FileLogger ? (Y/N) :");
        Scanner sc = new Scanner(System.in);
        String basic = sc.nextLine();
        String d = basic.toLowerCase();
        Logger logger = null; 
        if (d.equals("y")){
             logger = new FileLogger();
        }
        else {
            System.out.println("Which FileLogger do you want to use ? Cloud(c) or Database(db) :");
            String choice = sc.nextLine();
            String ch = choice.toLowerCase();
            if(ch.equals("c")){
                 logger = new CloudLogger();
            }
            else{
                 logger = new DatabaseLogger();
            }
        }
        Application app = new Application(logger);
        app.doSomething();
    }
}
