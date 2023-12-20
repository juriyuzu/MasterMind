import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class AnswerPanel {
    JPanel AnsPanel;
    JLabel[] L;
    Color[] colors;

    public AnswerPanel() {
        AnsPanel = new JPanel();
        colors = new Color[4];

        L = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            L[i] = new JLabel("■");
            L[i].setForeground(Color.GRAY);
        }

        AnsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        AnsPanel.setLayout(null);

        L[0].setBounds(25, 10, 20, 20);
        L[1].setBounds(80, 10, 20, 20);
        L[2].setBounds(135, 10, 20, 20);
        L[3].setBounds(190, 10, 20, 20);

        for (int i = 0; i < 4; i++) AnsPanel.add(L[i]);
    }
    public void makeSecret(){
        Color[] set = {Color.BLUE, Color.GREEN,Color.RED, Color.YELLOW, Color.PINK, Color.ORANGE};

        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            colors[i] = set[rnd.nextInt(6)];
        }
        System.out.println(Arrays.toString(colors));
    }
}
