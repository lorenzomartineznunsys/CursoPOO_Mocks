package com.nunsys.cursoPOO.exceptions;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public class SkuNotFoundException extends Exception {
    public SkuNotFoundException() {
    }

    public SkuNotFoundException(String message) {
        super(message);
    }

    public SkuNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkuNotFoundException(Throwable cause) {
        super(cause);
    }
}
