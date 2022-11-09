package de.mz.schoolmath.model;

import de.mz.schoolmath.exception.ValidateException;

import java.beans.PropertyChangeListener;

/**
 * Represents the model for the UI for each math task like addition, subtraction ...
 */
public interface IDocumentModel extends PropertyChangeListener {
    /**
     * Validates the input data
     * @throws ValidateException
     */
    void validate() throws ValidateException;

    /**
     * The math task type like addition, subtraction and so on
     * @return
     */
    MathTaskType getMathTaskType();
}
