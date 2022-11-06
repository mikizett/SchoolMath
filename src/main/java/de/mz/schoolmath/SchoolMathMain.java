package de.mz.schoolmath;

import de.mz.schoolmath.ui.TextProperties;
import de.mz.schoolmath.util.UIMessageUtil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchoolMathMain {

    private static final Logger LOG = Logger.getLogger(SchoolMathMain.class.getName());

    public static void main(String args[]) {
        /* Set the Nimbus look and feel
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        EventQueue.invokeLater(() -> {
            try {
                TextProperties.getInstance().loadTextProperties();
            } catch (Exception e) {
                UIMessageUtil.showErrMsg("Textdatei konnte nicht geladen werden!");
            }
        });
    }

}
