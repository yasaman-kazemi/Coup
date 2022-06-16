package view;

import card.Card;
import utils.ImageLoader;
import view.panels.gamePanel.playerPanel.horizontal.CardPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class CardSelectionFrame extends JFrame {
    private ViewController viewController;
    private JPanel mainPanel;
    private CardPanel[] cardPanels;
    private int selectionNumber;
    private int[] selectedIndexes;
    private JButton button;
    private Card[] cards;

    public CardSelectionFrame(ViewController viewController, Card[] cards, int selectionNumber) {
        this.viewController = viewController;
        this.selectionNumber = selectionNumber;
        this.cardPanels = new CardPanel[4];
        this.selectedIndexes = new int[selectionNumber];
        Arrays.fill(selectedIndexes, -1);
        this.cards = cards;
        initComponents(cards);
    }

    private void initComponents(Card[] cards) {
        mainPanel = new JPanel();
        cardPanels[0] = new CardPanel(getImage(cards[0]));
        cardPanels[1] = new CardPanel(getImage(cards[1]));
        cardPanels[2] = new CardPanel(getImage(cards[2]));
        cardPanels[3] = new CardPanel(getImage(cards[3]));
        button = new JButton("done");

        button.addActionListener(e -> buttonActionPerformed());

        for (int i = 0; i < 4; i++) {
            if (!cards[i].equals("*")) {
                int finalI = i;
                cardPanels[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        mouseClickedActionPerformed(finalI);
                    }
                });
            }
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cardPanels[3], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardPanels[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardPanels[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardPanels[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button)
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cardPanels[3], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cardPanels[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cardPanels[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cardPanels[2], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setVisible(true);
    }

    private void buttonActionPerformed() {
        if (hasEmptyPlaceToSelect()) {
            JOptionPane.showMessageDialog(null, "please select " + selectionNumber + " card");
        } else {
            viewController.selectCards(cards, selectedIndexes, this);
        }
    }

    private void mouseClickedActionPerformed(int cardPanelIndex) {
        if (isSelected(cardPanelIndex)) {
            unSelect(cardPanelIndex);
        } else {
            select(cardPanelIndex);
        }
    }

    private void unSelect(int cardPanelIndex) {
        cardPanels[cardPanelIndex].setBorder(null);
        for (int i = 0; i < selectedIndexes.length; i++) {
            if (selectedIndexes[i] == cardPanelIndex) {
                selectedIndexes[i] = -1;
                break;
            }
        }
    }

    private void select(int cardPanelIndex) {
        if (hasEmptyPlaceToSelect()) {
            cardPanels[cardPanelIndex].setBorder(new LineBorder(Color.ORANGE, 3));
            for (int i = 0; i < selectedIndexes.length; i++) {
                if (selectedIndexes[i] == -1) {
                    selectedIndexes[i] = cardPanelIndex;
                    break;
                }
            }
        }
    }

    private boolean hasEmptyPlaceToSelect() {
        for (int index : selectedIndexes)
            if (index == -1)
                return true;
        return false;
    }

    private boolean isSelected(int cardId) {
        for (int index : selectedIndexes)
            if (index == cardId)
                return true;
        return false;
    }

    private String getImage(Card card) {
        if (card == null) {
            return ImageLoader.getBehindCard();
        } else {
            switch (card.getName()) {
                case "Ambassador":
                    return ImageLoader.getAmbassador();
                case "Assassin":
                    return ImageLoader.getAssassin();
                case "Commander":
                    return ImageLoader.getCommander();
                case "Duke":
                    return ImageLoader.getDuke();
                case "Princess":
                    return ImageLoader.getPrincess();
                default:
                    return ImageLoader.getBehindCard();
            }
        }
    }
}
