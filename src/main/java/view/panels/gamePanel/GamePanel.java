package view.panels.gamePanel;

import player.Player;
import view.MyPanel;
import view.ViewController;
import view.panels.gamePanel.playerPanel.horizontal.UpDownPlayerPanel;
import view.panels.gamePanel.playerPanel.vertical.LeftRightPlayerPanel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends MyPanel {
    private CenterPanel centerPanel;
    private UpDownPlayerPanel downPlayerPanel;
    private UpDownPlayerPanel upPlayerPanel;
    private LeftRightPlayerPanel rightPlayerPanel;
    private LeftRightPlayerPanel leftPlayerPanel;
    private JComboBox<String> attackActionSelection;
    private JComboBox<String> defenseActionSelection;
    private JButton doButton;
    private JButton bluffButton;
    private String[] attackList;
    private String[] defenseList;

    public GamePanel(ViewController viewController) {
        super(viewController);
        initComponents();
    }

    private int getTurn() {
        return viewController.getTurn();
    }

    private void doButtonActionPerformed() {
        if (getTurn() == 0) {
            String attackOrder = (String) attackActionSelection.getSelectedItem();
            if (attackOrder != null) {
                switch (attackOrder) {
                    case "take 1 coin":
                        viewController.earn();
                        break;
                    case "take 2 coin":
                        viewController.foreignAid();
                        break;
                    case "coup":
                        viewController.coup();
                        break;
                    case "change card":
                        viewController.changeCard();
                        break;
                    case "duke: get 3 coin":
                        viewController.dukeStrategy();
                        break;
                    case "assassin: kill other":
                        viewController.assassinStrategy();
                        break;
                    case "commander: take 2 coin from other":
                        viewController.commanderStrategy();
                        break;
                    case "ambassador: change cards":
                        viewController.ambassadorStrategy();
                }
            }
        } else {
            viewController.getTurnPlayer().play();
            viewController.changeTurn();
        }
    }

    private void initComponents() {
        int turnPlayer = getTurn();
        centerPanel = new CenterPanel(viewController.getDeskCoin());
        downPlayerPanel = new UpDownPlayerPanel(viewController.getPlayer(0), true, turnPlayer == 0);
        rightPlayerPanel = new LeftRightPlayerPanel(viewController.getPlayer(1), false, turnPlayer == 1);
        upPlayerPanel = new UpDownPlayerPanel(viewController.getPlayer(2), false, turnPlayer == 2);
        leftPlayerPanel = new LeftRightPlayerPanel(viewController.getPlayer(3), true, turnPlayer == 3);
        bluffButton = new JButton("take bluff");

        setPreferredSize(new java.awt.Dimension(808, 588));

        JLabel attackLabel = new JLabel("attack:");
        JLabel defenseLabel = new JLabel("defense:");
        attackLabel.setForeground(Color.WHITE);
        defenseLabel.setForeground(Color.WHITE);

        attackActionSelection = new JComboBox<>();
        defenseActionSelection = new JComboBox<>();
        doButton = new JButton("do");
        attackList = new String[]{"take 1 coin", "take 2 coin", "coup", "change card", "duke: get 3 coin", "assassin: kill other", "commander: take 2 coin from other", "ambassador: change cards"};
        defenseList = new String[]{"duke: prevent taking 2 coin", "princess: prevent assault", "ambassador: prevent give 2 coins", "commander: prevent give 2 coins"};
        attackActionSelection.setModel(new javax.swing.DefaultComboBoxModel<>(attackList));
        defenseActionSelection.setModel(new javax.swing.DefaultComboBoxModel<>(defenseList));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(leftPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(116, 116, 116)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(upPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(downPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(76, 76, 76)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(rightPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(4, 4, 4)
                                                                .addComponent(defenseLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(attackLabel)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(defenseActionSelection, 0, 1, Short.MAX_VALUE)
                                                        .addComponent(attackActionSelection, 0, 1, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                                .addComponent(bluffButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(doButton))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(upPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(downPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(leftPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(rightPlayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(attackActionSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attackLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(defenseActionSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(defenseLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(doButton)
                                        .addComponent(bluffButton))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        doButton.setEnabled(true);
        attackActionSelection.setEnabled(true);
        defenseActionSelection.setEnabled(false);
        doButton.addActionListener(e -> doButtonActionPerformed());
    }
}
