import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MasterMind {
    JFrame mainFrame;
    AnswerPanel[] MAB;
    ResultPanel[] BAM;
    ButtonPanel BBB;
    JComboBox<String>[] CBC;
    AnswerPanel secretPanel;
    int currentPanel;

    int y_axis = 10;

    public MasterMind() {

        mainFrame = new JFrame("MasterMind by Julius Anton V. Aquino of BSCPE 231");

        mainFrame.setLayout(null);
        mainFrame.setLocation(400, 0);
        mainFrame.setSize(350, 650);

        MAB = new AnswerPanel[10];
        BAM = new ResultPanel[10];
        currentPanel = 0;

        for (int i = 0; i != 10; i++) {
            MAB[i] = new AnswerPanel();
            BAM[i] = new ResultPanel();
            MAB[i].AnsPanel.setBounds(20, y_axis, 230, 40);
            BAM[i].ResPanel.setBounds(270, y_axis, 40, 40);
            mainFrame.add(MAB[i].AnsPanel);
            mainFrame.add(BAM[i].ResPanel);
            y_axis += 45;
        }
        y_axis = 10;

        CBC = new JComboBox[4];
        BBB = new ButtonPanel();
        for (int i = 0; i < 4; i++) {
            CBC[i] = BBB.createButtonPanel();
            CBC[i].setBounds(20 + (i * 60), 470, 50, 20);
            mainFrame.add(CBC[i]);
            final int j = i;

            CBC[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int select = CBC[j].getSelectedIndex();
                    switch (select) {
                        case 1 -> MAB[currentPanel].L[j].setForeground(Color.BLUE);
                        case 2 -> MAB[currentPanel].L[j].setForeground(Color.GREEN);
                        case 3 -> MAB[currentPanel].L[j].setForeground(Color.RED);
                        case 4 -> MAB[currentPanel].L[j].setForeground(Color.YELLOW);
                        case 5 -> MAB[currentPanel].L[j].setForeground(Color.PINK);
                        case 6 -> MAB[currentPanel].L[j].setForeground(Color.ORANGE);
                        default -> MAB[currentPanel].L[j].setForeground(Color.GRAY);
                    }
                    MAB[currentPanel].colors[j] = MAB[currentPanel].L[j].getForeground();
                }
            });
        }

        JButton sub = new JButton("Submit"),
                exit = new JButton("Exit");
        sub.setBounds(20, 505, 100, 30);
        exit.setBounds(150, 505, 100, 30);
        mainFrame.add(sub);
        mainFrame.add(exit);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                for (int i = 0; i < 4; i++) {
                    if (MAB[currentPanel].L[i].getForeground() == Color.GRAY) {
                        JOptionPane.showMessageDialog(null, "Choose a color for all boxes to submit!", "Alert", JOptionPane.ERROR_MESSAGE);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int win = 0;
                    int[] hold = {0, 0, 0, 0};
                    boolean[] taken = {true, true, true, true};
                    for (int i = 0; i < 4; i++) {
                        boolean flagf = false;
                        for (int j = 0; j < 4; j++) {
                            JLabel obj = MAB[currentPanel].L[j];
                            if (obj.getForeground() == secretPanel.colors[i] && taken[j]) {
                                flagf = true;
                                break;
                            }
                        }
                        if (flagf) {
                            hold[i]++;
                            taken[i] = false;
                            if (secretPanel.colors[i] == MAB[currentPanel].L[i].getForeground()) {
                                hold[i]++;
                                win++;
                            }
                        }
                    }
                    Arrays.sort(hold);
                    int count = 0;
                    for (int i = 3; i >= 0; i--) {
                        switch (hold[i]) {
                            case 1 -> BAM[currentPanel].L[count++].setForeground(Color.WHITE);
                            case 2 -> BAM[currentPanel].L[count++].setForeground(Color.BLACK);
                        }
                    }
                    currentPanel++;
                    for (int i = 0; i < 4; i++) CBC[i].setSelectedIndex(0);
                    if (currentPanel > 10 || win == 4) {
                        if (win == 4) JOptionPane.showMessageDialog(null, "You Win :)", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        else JOptionPane.showMessageDialog(null, "You Lose :(", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        mainFrame.dispose();
                        MasterMind start = new MasterMind();
                    }
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });

        secretPanel = new AnswerPanel();
        secretPanel.makeSecret();
        for (int i = 0; i < 4; i++) {
            secretPanel.L[i].setText("?");
        }
        secretPanel.AnsPanel.setBounds(20,550,230, 48);
        mainFrame.add(secretPanel.AnsPanel);

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MasterMind startProgram = new MasterMind();
    }
}
