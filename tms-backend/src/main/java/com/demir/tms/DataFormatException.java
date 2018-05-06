package com.demir.tms;

/**
 * User: muratdemir
 * Date: 6.05.2018
 * Time: 19:12
 */
public final class DataFormatException extends RuntimeException {

    public DataFormatException() {
        super();
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }
}