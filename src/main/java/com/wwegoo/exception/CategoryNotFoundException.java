package com.wwegoo.exception;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends RuntimeException {
	public static final String DEFAULT_EXCEPTION = "category_not_found";
    /**
	 * 
	 */
	private static final long serialVersionUID = -8358289365844203865L;
	/**
	 * 
	 */
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *                method.
     */
    public CategoryNotFoundException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
