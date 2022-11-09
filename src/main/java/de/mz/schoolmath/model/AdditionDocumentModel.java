package de.mz.schoolmath.model;

import de.mz.schoolmath.exception.ValidateException;
import de.mz.schoolmath.validator.AdditionValidator;

public class AdditionDocumentModel extends AbstractDocumentModel {
    @Override
    public void validate() throws ValidateException {
        new AdditionValidator(getFromNo(), getToNo(), getColumnAmount(), getPageAmount(), getTotalSum()).validate();
    }

    @Override
    public MathTaskType getMathTaskType() {
        return MathTaskType.ADDITION;
    }
}
