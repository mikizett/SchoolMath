package de.mz.schoolmath.validator;

public enum ErrorEnum {
    FROM_NUMBER("error.fromNumber"),
    TO_NUMBER("error.toNumber"),
    COLUMN_AMOUNT("error.columnAmount"),
    PAGE_AMOUNT("error.pageAmount"),
    TOTAL_SUM("error.totalSum")
    ;

    private final String errorKey;

    ErrorEnum(final String errorKey) {
        this.errorKey = errorKey;
    }

    public String getErrorKey() {
        return errorKey;
    }
}
