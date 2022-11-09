package de.mz.schoolmath.model;

import de.mz.schoolmath.exception.ValidateException;
import de.mz.schoolmath.i18n.TextLabelProperties;
import de.mz.schoolmath.validator.ErrorEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

@DisplayName("Test AdditionDocumentModel")
public class AdditionDocumentModelTest {
    @Test
    @DisplayName("Should validate all fields without exception")
    void testValidateAllFieldsWithoutException() {
        final AdditionDocumentModel model = new AdditionDocumentModel();
        model.setColumnAmount(3);
        model.setFromNo(1);
        model.setToNo(100);
        model.setPageAmount(1);
        model.setTotalSum(100);

        Assertions.assertDoesNotThrow(() -> {
            model.validate();
        }, "Validation fine");
    }

    @Test
    @DisplayName("Should validate all fields with an exception")
    void testValidateAllFieldsWithException() {
        MockedStatic<TextLabelProperties> mockedStatic = Mockito.mockStatic(TextLabelProperties.class);

        mockedStatic
                .when(() -> TextLabelProperties.get(ErrorEnum.FROM_NUMBER.getErrorKey()))
                .thenReturn("Error appeared");

        final AdditionDocumentModel model = new AdditionDocumentModel();

        ValidateException thrown = Assertions.assertThrows(
                ValidateException.class,
                () -> model.validate(),
                "Expected validate() to throw, but it didn't"
        );

        Assertions.assertEquals("Error appeared", thrown.getMessage());
    }
}
