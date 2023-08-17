package hotelmanagmentsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Date;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;
import net.proteanit.sql.*;

public class Checkout extends JFrame implements ActionListener{
    Choice customer;
    JLabel lblroomnumber,lblroomcheckintime,lblroomcheckoutime;
    JButton checkout,back;
    
     Checkout() {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel text = new JLabel("Checkout");
         text.setBounds(100, 20,100, 30);
         text.setForeground(Color.BLUE);
         text.setFont(new Font("serif",Font.PLAIN,20));
         add(text);
         
         
         JLabel lblid = new JLabel("Customer ID");
         lblid.setBounds(30, 80,100, 30);
         lblid.setFont(new Font("serif",Font.PLAIN,20));
         add(lblid);
         
         
        customer = new Choice();
        customer.setBounds(180, 85, 150, 30);
        customer.setFont(new Font("Georgia",Font.PLAIN,15));
        add(customer);
        
      
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel tick = new JLabel(i3);
         tick.setBounds(330,85,20,20);
         add(tick);
         
         JLabel lblroom = new JLabel("Room Number");
         lblroom.setBounds(30, 130,150, 30);
         lblroom.setFont(new Font("Georgia",Font.PLAIN,20));
         add(lblroom);
         
         
         lblroomnumber = new JLabel();
         lblroomnumber.setBounds(180,130,100,30);
         add(lblroomnumber);
         
         
         JLabel lblcheckin = new JLabel("CheckIn Time");
         lblcheckin.setBounds(30,180,180,30);
         lblcheckin.setFont(new Font("Georgia",Font.PLAIN,20));
         add(lblcheckin);
         
         
         
         lblroomcheckintime = new JLabel("");
         lblroomcheckintime.setBounds(180,180,100,30);
         add(lblroomcheckintime);
         
        
         JLabel lblcheckout = new JLabel("Checkout Time");
         lblcheckout.setBounds(30,230,180,30);
         lblcheckout.setFont(new Font("Georgia",Font.PLAIN,20));
         add(lblcheckout);
         
         Date date = new Date();
         lblroomcheckoutime = new JLabel("" + date);
         lblroomcheckoutime.setBounds(180,230,180,30);
         lblroomcheckoutime.setFont(new Font("serif",Font.PLAIN,15));
         add(lblroomcheckoutime);
         
         
         checkout = new JButton("Checkout");
         checkout.setBackground(Color.BLACK);
         checkout.setForeground(Color.WHITE);
         checkout.setBounds(30,280, 120, 30);
         checkout.setFont(new Font("serif",Font.PLAIN,18));
         checkout.addActionListener(this);
         add(checkout);
         
         
         back = new JButton("Back");
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.setBounds(170,280, 120, 30);
         back.setFont(new Font("serif",Font.PLAIN,18));
         back.addActionListener(this);
         add(back);
         
           try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblroomcheckintime.setText(rs.getString("checkintime"));
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
         
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
         Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         JLabel image = new JLabel(i6);
         image.setBounds(370,50,400,250);
         add(image);
         
         setBounds(300, 200, 800, 400);
         setVisible(true);
         
    }
     public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == checkout){
        String q1 = "delete from customer where number = '"+customer+"'";
        String q2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
        
        try{
            Conn c = new Conn();
            c.s.executeUpdate(q1);
            c.s.executeUpdate(q2);
            
            JOptionPane.showMessageDialog(null,"CheckOut Done");
            new Reception();
            setVisible(false);
        }catch(Exception e ){
            e.printStackTrace();
        }
        
        
        
     }else{
         setVisible(false);
         new Reception();
     }
     
     }
     
     
    public static void main(String[] args) {
        new Checkout();
    }
   
}
