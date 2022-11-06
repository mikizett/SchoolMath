package de.mz.schoolmath.model;

public enum OrderType {

    ADDITION("addition"),
    SUBTRACTION("subtraction"),
    MULTIPLICATION("multiplication"),
    DIVISION("division")
    ;

    private final String orderType;

    OrderType(final String orderType) {
        this.orderType = orderType;
    }

    public String getValue() {
        return orderType;
    }

    public static final OrderType getFrom(String orderTypeString) {
        for (OrderType orderType : values()) {
            if (orderType.orderType.equals(orderTypeString)) {
                return orderType;
            }
        }
        return null;
    }

    public static final String getBusinessName(final OrderType orderType) {
        return orderType.name();
    }

}
