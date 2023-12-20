import javax.swing.*;
import java.awt.*;

public class ResultPanel {
    JPanel ResPanel;
    JLabel[] L;

    public ResultPanel() {
        ResPanel = new JPanel(); // Initialize AnsPanel

        L = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            L[i] = new JLabel("■");
            L[i].setForeground(Color.GRAY);
        }

        ResPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ResPanel.setLayout(null);

        L[0].setBounds(10, 5, 20, 20);
        L[2].setBounds(10, 15, 20, 20);
        L[1].setBounds(20, 5, 20, 20);
        L[3].setBounds(20, 15, 20, 20);

        for (int i = 0; i < 4; i++) ResPanel.add(L[i]);
    }
    public void makeSecret(){

    }
}
