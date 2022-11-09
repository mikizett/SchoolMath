package de.mz.schoolmath.validator;

import de.mz.schoolmath.exception.ValidateException;
import de.mz.schoolmath.i18n.TextLabelProperties;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractValidator implements IValidator {
    protected static final int NOT_INITIALIZED = 0;

    protected int fromNo = NOT_INITIALIZED;
    protected int toNo = NOT_INITIALIZED;
    protected int columnAmount = NOT_INITIALIZED;
    protected int pageAmount = NOT_INITIALIZED;
    protected int totalSum = NOT_INITIALIZED;

    @Override
    public void validate() throws ValidateException {
        if (fromNo == NOT_INITIALIZED) {
            throw new ValidateException(TextLabelProperties.get(ErrorEnum.FROM_NUMBER.getErrorKey()));
        }
        if (toNo == NOT_INITIALIZED) {
            throw new ValidateException(TextLabelProperties.get(ErrorEnum.TO_NUMBER.getErrorKey()));
        }
        if (columnAmount == NOT_INITIALIZED) {
            throw new ValidateException(TextLabelProperties.get(ErrorEnum.COLUMN_AMOUNT.getErrorKey()));
        }
        if (pageAmount == NOT_INITIALIZED) {
            throw new ValidateException(TextLabelProperties.get(ErrorEnum.PAGE_AMOUNT.getErrorKey()));
        }
        if (totalSum == NOT_INITIALIZED) {
            throw new ValidateException(TextLabelProperties.get(ErrorEnum.TOTAL_SUM.getErrorKey()));
        }
//		if (fromNo + toNo > totalSum) {
//			throw new ValidateException("Die Endsumme ist kleiner als die Summe der angegebenen Summanden");
//		}
    }
}
