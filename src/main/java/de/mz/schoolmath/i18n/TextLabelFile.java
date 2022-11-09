package de.mz.schoolmath.i18n;

public enum TextLabelFile {
    DE("TextLabels_DE.properties"),
    EN("TextLabels_EN.properties")
    ;

    private final String fileName;

    TextLabelFile(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
