package view.panels.start;

import player.*;
import utils.ImageLoader;
import view.MyPanel;
import view.ViewController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectPlayerPanel extends MyPanel {
    private CharacterPanel character1Panel;
    private CharacterPanel character2Panel;
    private CharacterPanel character3Panel;
    private CharacterPanel character4Panel;
    private JButton startButton;
    private Player[] players;

    public SelectPlayerPanel(ViewController viewController) {
        super(viewController);
        players = new Player[3];
        character1Panel = new CharacterPanel(ImageLoader.getCautiousKiller(), "Cautious Killer");
        character3Panel = new CharacterPanel(ImageLoader.getCouper(), "Couper");
        character2Panel = new CharacterPanel(ImageLoader.getParanoid(), "Paranoid");
        character4Panel = new CharacterPanel(ImageLoader.getMystery(), "Mystery");
        startButton = new javax.swing.JButton();
        initComponents();
    }

    private void initComponents() {
        startButton.setText("start");
        setMouseListenerToPanels();

        startButton.setEnabled(false);
        startButton.addActionListener(this::startButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(character1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(character2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(character3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(character4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(8, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(character4Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(character3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(character2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(character1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(startButton)
                                .addContainerGap())
        );
    }

    private void startButtonActionPerformed(ActionEvent e) {
        //todo start with 3 player
    }

    private void setMouseListenerToPanels() {
        character1Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedActionPerformed(new CautiousKiller(), character1Panel);
            }
        });

        character2Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedActionPerformed(new Paranoid(), character2Panel);
            }
        });

        character3Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedActionPerformed(new Couper(), character3Panel);
            }
        });

        character4Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClickedActionPerformed(new Mystery(), character4Panel);
            }
        });
    }

    private void mouseClickedActionPerformed(Player player, CharacterPanel characterPanel) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i].getClass().equals(player.getClass())) {
                unSelectPlayer(i, characterPanel);
                return;
            }
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                selectPlayer(i, player, characterPanel);
                return;
            }
        }
    }

    private void selectPlayer(int playerNumber, Player player, CharacterPanel characterPanel) {
        players[playerNumber] = player;
        if (players[0] != null && players[1] != null && players[2] != null) {
            startButton.setEnabled(true);
        }
        characterPanel.setBorder(new LineBorder(Color.yellow, 3));
    }

    private void unSelectPlayer(int playerNumber, CharacterPanel characterPanel) {
        players[playerNumber] = null;
        characterPanel.setBorder(null);
        startButton.setEnabled(false);
    }
}
