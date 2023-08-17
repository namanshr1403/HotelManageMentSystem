package hotelmanagmentsystem;

import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener{

    Choice customer; 
    JTextField tfroom,tfvailable,tfstatus,tfpaid,tfpendingAmount;
    JButton check , update,back;
    UpdateRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Georgia",Font.TYPE1_FONT,20));
        text.setBounds(90, 20, 300, 30);
        text.setForeground(Color.BLUE);
        add(text);
        
        
        
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,200,20);
        lblid.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblid);
        
        customer = new Choice();
        customer.setBounds(250, 80, 150, 30);
         customer.setFont(new Font("Georgia",Font.PLAIN,15));
        add(customer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("number"));
                
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30,120,200,20);
        lblRoom.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblRoom);
        
        tfroom = new JTextField();
        tfroom.setBounds(250,120,150,25);
        tfroom.setFont(new Font("Georgia",Font.PLAIN,15));
        add(tfroom);
        
        JLabel lblName = new JLabel("Availability");
        lblName.setBounds(30,160,200,20);
        lblName.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblName);
        
        tfvailable = new JTextField();
        tfvailable.setBounds(250,160,150,25);
            tfvailable.setFont(new Font("Georgia",Font.PLAIN,15));
        add(tfvailable);
        
        JLabel lblCheckIn = new JLabel("Cleaning Status");
        lblCheckIn.setBounds(30,200,200,20);
        lblCheckIn.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblCheckIn);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(250,200,150,25);
        tfstatus.setFont(new Font("Georgia",Font.PLAIN,15));
        add(tfstatus);
        

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 300, 100, 30);
        check.setFont(new Font("Georgia",Font.PLAIN,20));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 300, 100, 30);
        update.setFont(new Font("Georgia",Font.PLAIN,20));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 300, 100, 30);
        back.setFont(new Font("Georgia",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,500,300);
        add(image);
        
        
        
        
        
        setBounds(300,200,980,500);
        setVisible(true);
    }
   

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==check) {
            String id = customer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
           try {
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tfroom.setText(rs.getString("room"));
                   
               }
               ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
               while(rs2.next()){
                   tfvailable.setText(rs2.getString("availability"));
                   tfstatus.setText(rs2.getString("cleaning_status"));
               }
           }
           catch(Exception ae){
               ae.printStackTrace();
           }
       
        }else if(e.getSource() == update){
            String number = customer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfvailable.getText();
            String status = tfstatus.getText();
          
            
            
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"',cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception ae){
                ae.printStackTrace();
            }
                    
                    }else{
            setVisible(false);
            new Reception();
        }
         
    }
     public static void main(String[] args) {
     new UpdateRoom();
    }
}
