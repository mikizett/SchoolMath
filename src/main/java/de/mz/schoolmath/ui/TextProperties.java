package de.mz.schoolmath.ui;

import de.mz.schoolmath.model.OrderType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TextProperties {

    private static final String PROPERTY_FILE = "TextLabels.properties";
    private static final TextProperties INSTANCE = new TextProperties();

    private Properties props;

    private TextProperties() {}

    public void loadTextProperties() throws IOException {
        InputStream in = getClass().getResourceAsStream(PROPERTY_FILE);
        props = new Properties();
        props.load(in);
    }

    public static TextProperties getInstance() {
        return INSTANCE;
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    public String get(String key, OrderType orderType) {
        return props.getProperty(key + orderType.getValue());
    }

}
