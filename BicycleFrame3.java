// version 3 Save and Open implemented

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;  // NEW : NB CHANGE REQUIRED IN BICYCLE AT THIS STAGE
/** manages an array of bikes, including saving and loading */
public class BicycleFrame3 extends JFrame implements ActionListener{
    
     JMenu fileMenu,bikeMenu;
     Bicycle [] bikes; // an array of bikes
     int count; // number of valid bikes in the array
     
    // driver 
    public static void main( String[] args ) {
        BicycleFrame3 frame = new BicycleFrame3();
        frame.setVisible(true);
    }
    
    // constructor
    public BicycleFrame3( ) {
        newSystem();
        //set the frame default properties
        setTitle     ( "Bike repair shop system" );
        setSize      ( 400,200 );
        setLocation  ( 100,100 );
        Container pane = getContentPane();
      //  pane.setBackground(Color.blue);
        pane.setBackground(new Color(240,210,240));
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
        createFileMenu();
        createBikeMenu();
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(bikeMenu);
     }     
    
      public void newSystem() {
      	bikes = new Bicycle[10];
      	count = 0;
      }
      
      /** writes the array of bicycles to the file "bikes.dat"
       */   // NEW
      public void save() throws IOException {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("bikes.dat"));
      	os.writeObject(bikes);
      	os.close();
      }
      
      /** loads an array of bicycles from the file "bikes.dat"
       */  // NEW
      public void open() {
      	count = 0;
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("bikes.dat"));
         	bikes  = (Bicycle []) is.readObject();
      	  is.close(); 
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();
      	}
      	
      	// how many valid bike records?
      	while (bikes[count] !=null)
      	   count++;
      } // end open()
      
     
      public void addBicycle(){
      	Bicycle temp = new Bicycle();
      	temp.setOwner(JOptionPane.showInputDialog("Who owns this bike?"));
      	bikes[count] = temp; // 'default bike
      	// set the attributes: ask the user for owner name etc
      	count++; // now there is one more bike in the system
      }
      
      public void display(){
      	JTextArea area = new JTextArea();
      	if (count>0) {
      	  area.setText("Bicycle List: needs better output formatting\n\n");
      	  for (int i = 0; i<count; i++) // loop over existing bikes, rather than array size
      	    area.append("Bike no: " + i + " " +bikes[i].toString()+"\n");
      	  showMessage(area);
      	}
      	else
      	    showMessage("No bicycles in the system");
      } // end display
      
      public void actionPerformed (ActionEvent e) {
      	if (e.getActionCommand() .equals ("Quit")){
      	 showMessage("Shutting down the system");
      	 System.exit(0);
      	}
      	else if (e.getActionCommand() .equals ("Add")){
      	   addBicycle(); // branch to a separate method
      	}
      	else if (e.getActionCommand() .equals ("Display")){
           display();
      	}
      	else if (e.getActionCommand() .equals ("New File")){
      		newSystem();
        }
      	else if (e.getActionCommand() .equals ("Save")){
      	// NEW BLOCK OF ERROR-HANDLING HERE: MUST BE INCLUDED
      	 try{
      	 	save();
      	 	showMessage("Data saved successfully");
      	 } // try
      	 catch (IOException f){
      	 	showMessage("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }// catch
      	}// else if
      	
      	else if (e.getActionCommand() .equals ("Open")){
      	 open();
         display();
      	}
      	else
      	  showMessage("I have no idea what you clicked");
      } // actionPerformed
      
        private void createFileMenu(){
         // create the menu
      	fileMenu = new JMenu("File");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	item = new JMenuItem("Save");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	item = new JMenuItem("Open");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	item = new JMenuItem("New File");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	// create the 'quit' option
      	fileMenu.addSeparator();
      	item = new JMenuItem("Quit");
      	item.addActionListener(this);
      	fileMenu.add(item);
      }
      
      private void createBikeMenu(){
      	// create the menu
      	bikeMenu = new JMenu("Bicycle");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	
      	item = new JMenuItem("Add");
      	item.addActionListener(this);
      	bikeMenu.add(item);
      	
      	item = new JMenuItem("Display");
      	item.addActionListener(this);
      	bikeMenu.add(item);
      }
       /** utility methods to make the code simpler */
      public void showMessage (String s){
      	JOptionPane.showMessageDialog(null,s);
      }
      
      public void showMessage (JTextArea s){
      	JOptionPane.showMessageDialog(null,s);
      }
}