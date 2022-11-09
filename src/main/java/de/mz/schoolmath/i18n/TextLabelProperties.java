package de.mz.schoolmath.i18n;

import de.mz.schoolmath.model.MathTaskType;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Static class to load text labels.
 */
public final class TextLabelProperties {

    private static final TextLabelFile DEFAULT_TEXT_LABEL_PROPERTY_FILE = TextLabelFile.DE;

    private static Properties props;

    private static final LinkedList<TextLabelChangeListener> listeners = new LinkedList<>();

    private TextLabelProperties() {}

    public static void loadTextProperties(final TextLabelFile textLabelFile) throws IOException {
        InputStream in = TextLabelProperties.class.getResourceAsStream(
                textLabelFile == null ? DEFAULT_TEXT_LABEL_PROPERTY_FILE.getFileName() : textLabelFile.getFileName());
        props = new Properties();
        props.load(in);

        fireTextLabelChange();
    }

    public static void registerTextLabelChangeListener(final TextLabelChangeListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    private static void fireTextLabelChange() {
        listeners.forEach(l -> l.textLabelChanged());
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String get(String key, MathTaskType mathTaskType) {
        return props.getProperty(key + mathTaskType.getValue());
    }

    public interface TextLabelChangeListener {
        void textLabelChanged();
    }

}
