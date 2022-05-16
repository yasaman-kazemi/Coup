package view.panels.start;

import player.*;
import utils.ImageLoader;
import view.MyPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectPlayerPanel extends MyPanel {
    private CharacterPanel character1Panel;
    private CharacterPanel character2Panel;
    private CharacterPanel character3Panel;
    private CharacterPanel character4Panel;
    private JButton startButton;
    private Player[] players;

    public SelectPlayerPanel() {
        super();
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

    private void setMouseListenerToPanels() {
        character1Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (players[0] != null && players[0] instanceof CautiousKiller) {
                    players[0] = null;
                    character1Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[1] != null && players[1] instanceof CautiousKiller) {
                    players[1] = null;
                    character1Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[2] != null && players[2] instanceof CautiousKiller) {
                    players[2] = null;
                    character1Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else {
                    if (players[0] == null) {
                        players[0] = new CautiousKiller();
                        if (players[1] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character1Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[1] == null) {
                        players[1] = new CautiousKiller();
                        if (players[0] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character1Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[2] == null) {
                        players[2] = new CautiousKiller();
                        if (players[1] != null && players[0] != null) {
                            startButton.setEnabled(true);
                        }
                        character1Panel.setBorder(new LineBorder(Color.yellow, 3));
                    }
                }
            }
        });

        character2Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (players[0] != null && players[0] instanceof Paranoid) {
                    players[0] = null;
                    character2Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[1] != null && players[1] instanceof Paranoid) {
                    players[1] = null;
                    character2Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[2] != null && players[2] instanceof Paranoid) {
                    players[2] = null;
                    character2Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else {
                    if (players[0] == null) {
                        players[0] = new Paranoid();
                        if (players[1] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character2Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[1] == null) {
                        players[1] = new Paranoid();
                        if (players[0] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character2Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[2] == null) {
                        players[2] = new Paranoid();
                        if (players[1] != null && players[0] != null) {
                            startButton.setEnabled(true);
                        }
                        character2Panel.setBorder(new LineBorder(Color.yellow, 3));
                    }
                }
            }
        });

        character3Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (players[0] != null && players[0] instanceof Couper) {
                    players[0] = null;
                    character3Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[1] != null && players[1] instanceof Couper) {
                    players[1] = null;
                    character3Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[2] != null && players[2] instanceof Couper) {
                    players[2] = null;
                    character3Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else {
                    if (players[0] == null) {
                        players[0] = new Couper();
                        if (players[1] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character3Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[1] == null) {
                        players[1] = new Couper();
                        if (players[0] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character3Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[2] == null) {
                        players[2] = new Couper();
                        if (players[1] != null && players[0] != null) {
                            startButton.setEnabled(true);
                        }
                        character3Panel.setBorder(new LineBorder(Color.yellow, 3));
                    }
                }
            }
        });

        character4Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (players[0] != null && players[0] instanceof Mystery) {
                    players[0] = null;
                    character4Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[1] != null && players[1] instanceof Mystery) {
                    players[1] = null;
                    character4Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else if (players[2] != null && players[2] instanceof Mystery) {
                    players[2] = null;
                    character4Panel.setBorder(null);
                    startButton.setEnabled(false);
                } else {
                    if (players[0] == null) {
                        players[0] = new Mystery();
                        if (players[1] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character4Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[1] == null) {
                        players[1] = new Mystery();
                        if (players[0] != null && players[2] != null) {
                            startButton.setEnabled(true);
                        }
                        character4Panel.setBorder(new LineBorder(Color.yellow, 3));
                    } else if (players[2] == null) {
                        players[2] = new Mystery();
                        if (players[1] != null && players[0] != null) {
                            startButton.setEnabled(true);
                        }
                        character4Panel.setBorder(new LineBorder(Color.yellow, 3));
                    }
                }
            }
        });
    }
}
