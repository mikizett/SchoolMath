package de.mz.schoolmath.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

@DisplayName("Test TextLabelProperties")
public class TextLabelPropertiesTest {
    @Test
    @DisplayName("Should load DE text label properties successful")
    void testLoadTextLabelDE() throws IOException {
        TextLabelProperties.loadTextProperties(TextLabelFile.DE);

        Assertions.assertEquals("german", TextLabelProperties.get("german"));
    }

    @Test
    @DisplayName("Should load default DE text label properties successful if TextLabelFile is null")
    void testLoadDefaultTextLabelDEIfTextLabelFileNull() throws IOException {
        TextLabelProperties.loadTextProperties(null);

        Assertions.assertEquals("german", TextLabelProperties.get("german"));
    }

    @Test
    @DisplayName("Should load EN text label properties successful")
    void testLoadTextLabelEN() throws IOException {
        TextLabelProperties.loadTextProperties(TextLabelFile.EN);

        Assertions.assertEquals("english", TextLabelProperties.get("english"));
    }

    @Test
    @DisplayName("Should fire text label change if DE text label properties are loaded")
    void testFireTextLabelChange() throws IOException {
        final TextLabelProperties.TextLabelChangeListener listener = Mockito.mock(TextLabelProperties.TextLabelChangeListener.class);

        TextLabelProperties.registerTextLabelChangeListener(listener);

        TextLabelProperties.loadTextProperties(TextLabelFile.DE);

        Mockito.verify(listener, Mockito.times(1)).textLabelChanged();
    }
}
