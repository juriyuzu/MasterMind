import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel {
    JComboBox<String> CBX;

    public JComboBox<String> createButtonPanel() {
        CBX = new JComboBox<>(new String[]{"?", "Blue", "Green", "Red", "Yellow", "Pink", "Orange"});
        CBX.setBounds(0, 0, 100, 40);

        return CBX;
    }
}
