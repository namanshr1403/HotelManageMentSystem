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

public class UpdateCheck extends JFrame implements ActionListener{

    Choice customer; 
    JTextField tfroom,tfname,tfCheckIn,tfpaid,tfpendingAmount;
    JButton check , update,back;
    UpdateCheck() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Georgia",Font.TYPE1_FONT,30));
        text.setBounds(90, 20, 300, 30);
        text.setForeground(Color.BLUE);
        add(text);
        
        
        
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,200,20);
        lblid.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblid);
        
        customer = new Choice();
        customer.setBounds(300, 80, 150, 30);
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
        tfroom.setBounds(300,120,150,25);
        add(tfroom);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,160,200,20);
        lblName.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblName);
        
        tfname = new JTextField();
        tfname.setBounds(300,160,150,25);
        add(tfname);
        
        JLabel lblCheckIn = new JLabel("CheckInTime");
        lblCheckIn.setBounds(30,200,200,20);
        lblCheckIn.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblCheckIn);
        
        tfCheckIn = new JTextField();
        tfCheckIn.setBounds(300,200,150,25);
        add(tfCheckIn);
        
        
        
        JLabel lblAmtPaid = new JLabel("Amount Paid");
        lblAmtPaid.setBounds(30,240,200,20);
        lblAmtPaid.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblAmtPaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(300,240,150,25);
        add(tfpaid);
        
        JLabel lblPendingAmt = new JLabel("Pending Amount");
        lblPendingAmt.setBounds(30,280,200,25);
        lblPendingAmt.setFont(new Font("Georgia",Font.BOLD,20));
        add(lblPendingAmt);
        
        tfpendingAmount = new JTextField();
        tfpendingAmount.setBounds(300,280,150,25);
        add(tfpendingAmount);
        
        
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 340, 100, 30);
        check.setFont(new Font("Georgia",Font.PLAIN,20));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 340, 100, 30);
        update.setFont(new Font("Georgia",Font.PLAIN,20));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 340, 100, 30);
        back.setFont(new Font("Georgia",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(450,40,500,300);
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
                   tfname.setText(rs.getString("name"));
                   tfCheckIn.setText(rs.getString("checkintime"));
                   tfpaid.setText(rs.getString("deposit"));
               }
               ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
               while(rs2.next()){
                   String price = rs2.getString("price");
                   int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                   tfpendingAmount.setText(""+amountPaid);
               }
           }
           catch(Exception ae){
               ae.printStackTrace();
           }
       
        }else if(e.getSource() == update){
            String number = customer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkintime = tfCheckIn.getText();
            String deposit = tfpaid.getText();
            
            
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"',name = '"+name+"',checkintime = '"+checkintime+"',deposit = '"+deposit+"' where number = '"+number+"'");
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
     new UpdateCheck();
    }
}
