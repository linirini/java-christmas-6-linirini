package christmas.util;

public enum ExceptionEnum {
    ;
    private static final String ERROR = "[ERROR] ";
    private final String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }
}
