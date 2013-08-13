package com.qsoft.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.qsoft.controller.ButtonPanelController;
import com.qsoft.controller.MainPanelController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * User: luult
 * Date: 8/8/13
 * Time: 8:49 AM
 */
public class MainWindow extends JFrame
{
    public static final String MAIN_WINDOW_NAME = "Tic tac toe game";
    public static final String APPLICATION_TITLE = "Tic tac toe game";
    public static final String START_BUTTON_NAME = "btStart";
    public static final String STOP_BUTTON_NAME = "btStop";
    public static final String LABEL_STATUS_NAME = "lbStatus";
    public static final String HISTORY_BUTTON_NAME = "btHistory";
    private JPanel panel1;
    private JButton btStart;
    private JLabel lbStatus;
    private JButton btStop;
    private JPanel mainPanel;
    private JButton btHistory;
    private ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ButtonPanelController buttonPanelController;
    MainPanelController mainPanelController;

    public JButton getBtStart()
    {
        return btStart;
    }

    public JButton getBtStop()
    {
        return btStop;
    }

    public MainWindow()
    {
        $$$setupUI$$$();
        setName(MAIN_WINDOW_NAME);
        setTitle(APPLICATION_TITLE);
        setMinimumSize(new Dimension(500, 500));
        setContentPane(panel1);

        pack();

//        JButton button = new JButton();
//        try {
//            Image img = ImageIO.read(getClass().getResource("/cross.png"));
//            button.setIcon(new ImageIcon(img));
//        } catch (IOException ex) {
//        }
//        panel1.add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        buttonPanelController = new ButtonPanelController();
        buttonPanelController.setMainWindow(this);
        mainPanelController = new MainPanelController(this);
        btStart.addActionListener(buttonPanelController);
        btStop.addActionListener(buttonPanelController);
        btHistory.addActionListener(buttonPanelController);
        addButtonToView();
        mainPanel.setEnabled(false);
        mainPanel.setVisible(false);
    }

    public void addButtonToView()
    {
        mainPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++)
        {
            JButton jButton = new JButton("");
            jButton.setActionCommand(i + "");
            jButton.setName("button" + i);
            jButton.addActionListener(mainPanelController);
            mainPanel.add(jButton);
            buttonList.add(jButton);
        }
    }

    public JLabel getLbStatus()
    {
        return lbStatus;
    }

    public void setLbStatus(JLabel lbStatus)
    {
        this.lbStatus = lbStatus;
    }


    public JButton getButton(String name)
    {
        return buttonList.get(Integer.parseInt(name));  //To change body of created methods use File | Settings | File Templates.
    }

    public void resetMainPanel()
    {
        mainPanel.setEnabled(true);
        mainPanel.setVisible(true);
        for (int i = 0; i < 9; i++)
        {
            buttonList.get(i).setText("");
            buttonList.get(i).setEnabled(true);
        }
    }

    public void disableAllButtonGame()
    {
        for (int i = 0; i < 9; i++)
        {
            buttonList.get(i).setEnabled(false);
        }
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel1.add(panel2, BorderLayout.NORTH);
        lbStatus = new JLabel();
        lbStatus.setHorizontalAlignment(0);
        lbStatus.setMinimumSize(new Dimension(40, 20));
        lbStatus.setName("lbStatus");
        lbStatus.setPreferredSize(new Dimension(40, 20));
        lbStatus.setText("");
        panel2.add(lbStatus, BorderLayout.NORTH);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        panel1.add(panel3, BorderLayout.CENTER);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, BorderLayout.NORTH);
        btStart = new JButton();
        btStart.setName("btStart");
        btStart.setText("Start");
        panel4.add(btStart, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel4.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btStop = new JButton();
        btStop.setEnabled(false);
        btStop.setName("btStop");
        btStop.setText("Stop");
        panel4.add(btStop, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btHistory = new JButton();
        btHistory.setName("btHistory");
        btHistory.setText("History");
        panel4.add(btHistory, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel1;
    }
}
