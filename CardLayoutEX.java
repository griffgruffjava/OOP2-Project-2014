/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * modified version of cardlayout example
 * CardLayoutDemo.java
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutEX implements ActionListener {
    
    JPanel cards; //a panel that uses CardLayout
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";
    JComboBox cb;
    
     public static void main(String[] args) {
        
         createAndShowGUI();
       
    }
    
    
     private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setSize(300,200);
        frame.setLocation(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        CardLayoutEX demo = new CardLayoutEX();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel panel = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        
        cb.addActionListener(this);
        panel.add(cb);
        
        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
        
        pane.add(panel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    
    public void actionPerformed(ActionEvent evt) {	
        
        //associate a cardlayout object with the main panel by
        //getting the layout manager for the panel and casting it.
        CardLayout cl = (CardLayout)(cards.getLayout());
       
       //check the combo box for selected item and display appropriate panel
       if (cb.getSelectedItem().equals("Card with JTextField")){	
       JOptionPane.showMessageDialog(null,"here");
       cl.show(cards, TEXTPANEL);
       }
       else if (cb.getSelectedItem().equals("Card with JButtons")){	
       JOptionPane.showMessageDialog(null,"here");
       cl.show(cards, BUTTONPANEL);
       
       } //end if
    }
    
   
}
