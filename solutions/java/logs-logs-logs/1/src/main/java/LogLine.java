public class LogLine {

    String ll;

    public LogLine(String logLine) {
        ll = logLine;
    }

    public LogLevel getLogLevel() {
        switch (ll.substring(1, 4)) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {
        LogLevel logLevel = getLogLevel();
        return "" + logLevel.value() + ":" + ll.substring(7);
    }
}
