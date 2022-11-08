package de.mz.schoolmath.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

@DisplayName("Test TextLabelProperties")
public class TextLabelPropertiesTest {

    private final TextLabelProperties textLabelProperties = TextLabelProperties.getInstance();

    @Test
    @DisplayName("Should load DE text label properties successful")
    void testLoadTextLabelDE() throws IOException {
        textLabelProperties.loadTextProperties(TextLabelFile.DE);

        Assertions.assertEquals("german", textLabelProperties.get("german"));
    }

    @Test
    @DisplayName("Should load default DE text label properties successful if TextLabelFile is null")
    void testLoadDefaultTextLabelDEIfTextLabelFileNull() throws IOException {
        textLabelProperties.loadTextProperties(null);

        Assertions.assertEquals("german", textLabelProperties.get("german"));
    }

    @Test
    @DisplayName("Should load EN text label properties successful")
    void testLoadTextLabelEN() throws IOException {
        textLabelProperties.loadTextProperties(TextLabelFile.EN);

        Assertions.assertEquals("english", textLabelProperties.get("english"));
    }

    @Test
    @DisplayName("Should fire text label change if DE text label properties are loaded")
    void testFireTextLabelChange() throws IOException {
        final HostTextLabelChangeListener listener = Mockito.mock(HostTextLabelChangeListener.class);

        textLabelProperties.registerTextLabelChangeListener(listener);

        textLabelProperties.loadTextProperties(TextLabelFile.DE);
        
        Mockito.verify(listener, Mockito.times(1)).textLabelChanged();
    }

    public static class HostTextLabelChangeListener implements TextLabelProperties.TextLabelChangeListener {
        @Override
        public void textLabelChanged() {
            Assertions.assertTrue(true);
        }
    }
}
