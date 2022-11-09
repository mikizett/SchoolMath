package de.mz.schoolmath.model;

public enum MathTaskType {

    ADDITION("addition"),
    SUBTRACTION("subtraction"),
    MULTIPLICATION("multiplication"),
    DIVISION("division")
    ;

    private final String mathTaskTypeName;

    MathTaskType(final String mathTaskTypeName) {
        this.mathTaskTypeName = mathTaskTypeName;
    }

    public String getValue() {
        return mathTaskTypeName;
    }

    public static final MathTaskType getFrom(String mathTaskTypeName) {
        for (MathTaskType mathTaskType : values()) {
            if (mathTaskType.mathTaskTypeName.equals(mathTaskTypeName)) {
                return mathTaskType;
            }
        }
        return null;
    }

    public static final String getBusinessName(final MathTaskType mathTaskType) {
        return mathTaskType.name();
    }

}
