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

public class CardLayoutEX2 extends JFrame implements ActionListener {
    
    JPanel cards; //a panel that uses CardLayout
    JComboBox cb;
    
     public static void main(String[] args) {
        
         //Create and set up the content pane.
        CardLayoutEX2 demo = new CardLayoutEX2();
        demo.setVisible(true);
       
    }
    
    
     private  CardLayoutEX2() {
        //Create and set up the window.
        
        setSize(300,200);
        setLocation(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel panel = new JPanel(); //use FlowLayout
        String[] comboBoxItems = { "Card with JButtons", "Card with JTextField" };
        
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
        cards.add(card1, "Card with JButtons");
        cards.add(card2, "Card with JTextField");
        
        Container pane=getContentPane();
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
       cl.show(cards, "Card with JTextField");
       }
       else if (cb.getSelectedItem().equals("Card with JButtons")){	
       JOptionPane.showMessageDialog(null,"here");
       cl.show(cards, "Card with JButtons");
       
       } //end if
    } 
    
   
}
