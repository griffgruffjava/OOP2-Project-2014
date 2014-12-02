//Source Code By CodingMagazine.blogspot.in
//program starts

//import packages

 import java.awt.*;
 import java.sql.*;
 import java.awt.event.*;
 import javax.swing.*;

 //class starts
 class sampleForm2 implements ActionListener{
   JFrame f1;
   JLabel lblName,lblCity,lblState,lblMail;
   JTextField txtName,txtCity,txtState,txtMail;
   JButton btnClear,btnClose,btnSave,btnDelete,btnUpdate,btnNext,btnPrev;
   JPanel p1,p2;
   GridLayout gl42,gl21;
   FlowLayout fl;
   Connection scon;
   Statement stmtSave,stmtSelect1,stmtSelect2,stmtUpdate,stmtDelete;
   String na,ct,st,mid,mid1;
   Box vb,hb;
   BorderLayout bl;
   ResultSet rs,rs1;
   int n=0,n1=0,n2;

 //connect() starts
 public void Connect()
  {
   try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    }
   catch(ClassNotFoundException cnfe)
    {
     System.out.println("Error"+cnfe);
    }
   try
    {
      scon=DriverManager.getConnection("Jdbc:Odbc:LocalServer","sa","");
      stmtSelect1=scon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmtSave=scon.createStatement();
      stmtSelect2=scon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmtUpdate=scon.createStatement();
      stmtDelete=scon.createStatement();
    }
   catch(SQLException se)
    {
     System.out.println("Error"+se);
    }
   try
    {
    rs=stmtSelect1.executeQuery("select * from tblAdd");
    rs1=stmtSelect2.executeQuery("select * from tblAdd");
    rs1.last();
    }
   catch(SQLException se)
    {
     System.out.println("Error"+se);
    }
  }//Connect() Ends 
   //contructor starts
   sampleForm2()
    {
   scon=null;   
      f1=new JFrame("Address Book");

      vb=Box.createVerticalBox();
      hb=Box.createHorizontalBox();

      bl=new BorderLayout();

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
      btnClear=new JButton("Clear");
      btnNext=new JButton("Next");
      btnPrev=new JButton("Previous");

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
      p2.add(btnNext);
      p2.add(btnPrev);
      p2.add(btnDelete);
      p2.add(btnClose);

      btnClear.addActionListener(this);
      btnClose.addActionListener(this);
      btnSave.addActionListener(this);
      btnNext.addActionListener(this);
      btnPrev.addActionListener(this);
      btnUpdate.addActionListener(this);
      btnDelete.addActionListener(this);

      Connect();

      vb.add(Box.createVerticalStrut(25));
      vb.add(p1);
      vb.add(Box.createVerticalStrut(50));
      vb.add(p2);
      vb.add(Box.createVerticalStrut(25));
      hb.add(Box.createHorizontalStrut(25));
      hb.add(vb);
      hb.add(Box.createHorizontalStrut(25));
     // f1.setLayout(gl21);
     // f1.add(p1);
     // f1.add(p2);
     f1.setLayout(bl);
     f1.add(hb,BorderLayout.CENTER);
      f1.setSize(600,300);
      f1.setVisible(true);
      f1.setLocation(200,100);

  }//Contructor Ends

 //Event Starts
 public void actionPerformed(ActionEvent ae)
   {    //implementing clear button
        if(ae.getSource()==btnClear)
         {
           txtName.setText("");
           txtCity.setText("");
           txtState.setText("");
           txtMail.setText("");
           JOptionPane.showMessageDialog(f1,"All Fields Cleared !");
         }
         //implementing Close button
        else if(ae.getSource()==btnClose)
         {
           n2=JOptionPane.showConfirmDialog(f1,"Want To Exit ?");
                if(1>n2)
                   {
                    f1.setVisible(false);
                    f1.dispose();
                   }
         }
        //implementing Save button
        else if(ae.getSource()==btnSave)
         {
          na=txtName.getText();
          ct=txtCity.getText();
          st=txtState.getText();
          mid=txtMail.getText();
              try
               {
                 stmtSave.executeUpdate("insert into tblAdd values('"+na+"','"+ct+"','"+st+"','"+mid+"')");
                 JOptionPane.showMessageDialog(f1,"One Record Saved !!!");
               }
              catch(SQLException se)
               {
                System.out.println("Error"+se);
               }
          
         }
         //implementing Next button
        else if(ae.getSource()==btnNext)
         {
          try
           {
              if(rs.next())
               {
                 na=rs.getString(1);
                 ct=rs.getString(2);
                 st=rs.getString(3);
                 mid=rs.getString(4);
                 txtName.setText(na);
                 txtCity.setText(ct);
                 txtState.setText(st);
                 txtMail.setText(mid);
               }
              else
               {
                 JOptionPane.showMessageDialog(f1,"No More Records");
                 rs.last();
               }
           }
          catch(SQLException se)
            {
             System.out.println("Error"+se);
             }
            }
          //implementing previous button
        else if(ae.getSource()==btnPrev)
         {
          try
           {
              if(rs.previous())
               {
                 na=rs.getString(1);
                 ct=rs.getString(2);
                 st=rs.getString(3);
                 mid=rs.getString(4);
                 txtName.setText(na);
                 txtCity.setText(ct);
                 txtState.setText(st);
                 txtMail.setText(mid);
               }
              else
               {
                 JOptionPane.showMessageDialog(f1,"No More Records");
                 rs.first();
               }
           }
          catch(SQLException se)
            {
             System.out.println("Error"+se);
             }
         }
        //implementing update button
       else if(ae.getSource()==btnUpdate)
        {
         try
          {
           na=txtName.getText();
           ct=txtCity.getText();
           st=txtState.getText();
           mid=txtMail.getText();
           n=stmtUpdate.executeUpdate("update tblAdd set name='"+na+"',city='"+ct+"',state='"+st+"',mail='"+mid+"' where mail='"+mid+"'");
            JOptionPane.showMessageDialog(f1,"One Record Updated !!!");
             
          }
         catch(SQLException se)
          {
            JOptionPane.showMessageDialog(f1,"Error ");
          }
        }
      //implementing delete button
      else if(ae.getSource()==btnDelete)
       {
         try
          {
           mid1=txtMail.getText();
           n1=stmtDelete.executeUpdate("delete from tblAdd where mail='"+mid1+"'");
           JOptionPane.showMessageDialog(f1,"One Record Deleted !!!");
          }
         catch(SQLException se)
          {
            JOptionPane.showMessageDialog(f1,"Error ");
          }
        }

   }//Event Handling ends

}//class ends

 //main class starts
 class addForm
   {
     public static void main(String[] args)
      {
       sampleForm2 a1;
       a1=new sampleForm2();
      }
   }
 //main class ends
//program ends 
