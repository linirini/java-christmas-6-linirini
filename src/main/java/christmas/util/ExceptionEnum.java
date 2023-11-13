package christmas.util;

public enum ExceptionEnum {

    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private static final String NOTICE = "[ERROR] ";

    private String message;

    ExceptionEnum(String message) {
        this.message = NOTICE + message;
    }

    public String getMessage() {
        return this.message;
    }
}
