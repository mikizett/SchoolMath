package de.mz.schoolmath.validator;

import de.mz.schoolmath.exception.ValidateException;

/**
 * Validates input data
 */
public interface IValidator {
    void validate() throws ValidateException;
}
