package com.source.sourcestore.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION (9999, "Uncategorized Exception"),
    USER_EXCEPTED (1001, "User existed"),
    USERNAME_INVALID(1002, "Username must be at least 6 characters" ),
    INVALID_PASSWORD(1003, "Password must be at least 8 characters" ),
    INVALID_KEY(1004, "Invalid message KEY");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
