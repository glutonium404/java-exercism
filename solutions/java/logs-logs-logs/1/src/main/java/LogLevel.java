public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42),
    UNKNOWN(0);

    private final int encodedValue;

    LogLevel(int encodedValue) {
        this.encodedValue = encodedValue;
    }

    public int value() {
        return this.encodedValue;
    }
}
