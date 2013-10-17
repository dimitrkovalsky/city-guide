package com.guide.city.types;


public interface ResponseErrorCode {
    public static int INVALID_REQUEST = 300;
    public static int UNKNOWN_COMMAND = 301;
    public static int VALIDATION_ERROR = 302;
    public static int NULL_COMMAND = 303;
    public static int MALFORMED_COMMAND = 304;
    public static int APPLICATION_EXCEPTION = 305;
    public static int AUTHENTICATION_FAILED = 310;
}
