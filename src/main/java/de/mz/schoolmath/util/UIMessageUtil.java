package de.mz.schoolmath.util;

import javax.swing.*;
import java.awt.*;

public final class UIMessageUtil {

    public static void showErrMsg(final String msg) {
        showErrMsg(null, msg, "Error");
    }

    public static void showErrMsg(final Component parentComp, final String msg, final String title) {
        JOptionPane.showMessageDialog(parentComp, msg, title, JOptionPane.ERROR_MESSAGE);
    }
}
