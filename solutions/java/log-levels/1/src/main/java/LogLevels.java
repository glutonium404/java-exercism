public class LogLevels {
    
    public static String message(String logLine) {
        return logLine.split(":", 2)[1].strip();
    }

    public static String logLevel(String logLine) {
        String a = logLine.split(":", 2)[0];
        a = a.replace("[", "");
        a = a.replace("]", "");
        return a.strip().toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
