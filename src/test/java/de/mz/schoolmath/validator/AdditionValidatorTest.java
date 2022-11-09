package de.mz.schoolmath.validator;

import de.mz.schoolmath.exception.ValidateException;
import de.mz.schoolmath.i18n.TextLabelProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

@DisplayName("Test AdditionValidator")
public class AdditionValidatorTest {
    @Test
    @DisplayName("Should validate all fields without exception")
    void testValidateAllFieldsWithoutException() {
        final AdditionValidator additionValidator = new AdditionValidator(1, 100, 3, 1, 100);

        Assertions.assertDoesNotThrow(() -> {
            additionValidator.validate();
        }, "Validation fine");
    }

    @Test
    @DisplayName("Should validate all fields with an exception")
    void testValidateAllFieldsWithException() {
        MockedStatic<TextLabelProperties> mockedStatic = Mockito.mockStatic(TextLabelProperties.class);

        mockedStatic
                .when(() -> TextLabelProperties.get(ErrorEnum.FROM_NUMBER.getErrorKey()))
                .thenReturn("Error appeared");

        final AdditionValidator additionValidator = new AdditionValidator(0, 0, 0, 1, 100);

        ValidateException thrown = Assertions.assertThrows(
                ValidateException.class,
                () -> additionValidator.validate(),
                "Expected validate() to throw, but it didn't"
        );

        Assertions.assertEquals("Error appeared", thrown.getMessage());
    }
}
