package de.mz.schoolmath.exception;

public class ValidateException extends Exception {
    private static final long serialVersionUID = -3372180557450261702L;

    public ValidateException(final String errorMessage) {
        super(errorMessage);
    }
}
