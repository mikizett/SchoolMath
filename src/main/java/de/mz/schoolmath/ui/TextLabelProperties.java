package de.mz.schoolmath.ui;

import de.mz.schoolmath.model.MathTaskType;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

public final class TextLabelProperties {

    private static final TextLabelFile DEFAULT_TEXT_LABEL_PROPERTY_FILE = TextLabelFile.DE;
    private static final TextLabelProperties INSTANCE = new TextLabelProperties();

    private Properties props;

    private final LinkedList<TextLabelChangeListener> listeners = new LinkedList<>();

    private TextLabelProperties() {}

    public void loadTextProperties(final TextLabelFile textLabelFile) throws IOException {
        InputStream in = getClass().getResourceAsStream(
                textLabelFile == null ? DEFAULT_TEXT_LABEL_PROPERTY_FILE.getFileName() : textLabelFile.getFileName());
        props = new Properties();
        props.load(in);

        fireTextLabelChange();
    }

    public void registerTextLabelChangeListener(final TextLabelChangeListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    private void fireTextLabelChange() {
        listeners.forEach(l -> l.textLabelChanged());
    }

    public static TextLabelProperties getInstance() {
        return INSTANCE;
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    public String get(String key, MathTaskType mathTaskType) {
        return props.getProperty(key + mathTaskType.getValue());
    }

    public static interface TextLabelChangeListener {
        public void textLabelChanged();
    }

}
