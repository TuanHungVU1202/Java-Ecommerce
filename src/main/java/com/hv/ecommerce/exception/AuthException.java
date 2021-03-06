package com.hv.ecommerce.exception;

import com.hv.ecommerce.common.DynamicObj;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

public class AuthException extends RuntimeException {

    private HttpStatus httpStatus;
    private Model model;
    private DynamicObj dynamicObj;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *                method.
     */
    public AuthException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public AuthException(HttpStatus httpStatus, Model model) {
        this.model = model;
        this.httpStatus = httpStatus;
    }

    public AuthException(HttpStatus httpStatus, DynamicObj obj) {
        this.dynamicObj = obj;
        this.httpStatus = httpStatus;
    }

    public AuthException() {
        super();
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthException(String message) {
        super(message);
    }

    public AuthException(Throwable cause) {
        super(cause);
    }
}
