
package school.management;

import javax.swing.JOptionPane;


public class Alert {
    public static void viewWarningMessage(String string) {
        JOptionPane.showMessageDialog(null, string, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    public static void viewSuccessMessage(String string) {
        JOptionPane.showMessageDialog(null, string, "Warning", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void viewErrorMessage(String string) {
        JOptionPane.showMessageDialog(null, string, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
