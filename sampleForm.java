//Source Code By CodingMagazine.blogspot.in
//program starts
//import packages

import java.awt.*;
import javax.swing.*;

//class starts
class addFormWin{
  JFrame f1;
  JLabel lblName,lblCity,lblState,lblMail;
  JTextField txtName,txtCity,txtState,txtMail;
  JButton btnClear,btnClose,btnSave,btnDelete,btnUpdate,btnView;
  JPanel p1,p2;
  GridLayout gl42,gl21;
  FlowLayout fl;
  //contructor starts
 addFormWin()
 {
   f1=new JFrame("Address Book");

   lblName=new JLabel("Name :");
   lblCity=new JLabel("City :");
   lblState=new JLabel("State :");
   lblMail=new JLabel("E-Mail :");

   txtName=new JTextField(40);
   txtCity=new JTextField(40);
   txtState=new JTextField(40);
   txtMail=new JTextField(40);

   btnClose=new JButton("Close");
   btnSave=new JButton("Save");
   btnDelete=new JButton("Delete");
   btnUpdate=new JButton("Update");
   btnView=new JButton("View");
   btnClear=new JButton("Clear");

   p1=new JPanel();
   p2=new JPanel();

   gl42=new GridLayout(4,2);
   gl21=new GridLayout(2,1);
   fl=new FlowLayout();

   p1.setLayout(gl42);
   p1.add(lblName);
   p1.add(txtName);
   p1.add(lblCity);
   p1.add(txtCity);
   p1.add(lblState);
   p1.add(txtState);
   p1.add(lblMail);
   p1.add(txtMail);

   p2.setLayout(fl);
   p2.add(btnClear);
   p2.add(btnSave);
   p2.add(btnUpdate);
   p2.add(btnDelete);
   p2.add(btnView);
   p2.add(btnClose);

   f1.setLayout(gl21);
   f1.add(p1);
   f1.add(p2);
   f1.setSize(400,200);
   f1.setVisible(true);

  
  }//Contructor Ends

}//class ends

//main class starts
class addForm
  {
   public static void main(String[] args)
   {
    addFormWin a1;
    a1=new addFormWin();
   }
 }
//main class ends
//program ends
