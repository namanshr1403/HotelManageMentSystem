package hotelmanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        
        JLabel l1 = new JLabel("Document");
        l1.setBounds(10,10,100,20);
        l1.setFont(new Font("serif",Font.PLAIN,20));
        add(l1);
        
        JLabel l2  = new JLabel("Number");
        l2.setBounds(160,10,100,20);
        l2.setFont(new Font("serif",Font.PLAIN,20));
        add(l2);
      
        JLabel cleaningstatus  = new JLabel("Name");
        cleaningstatus.setBounds(290,10,100,20);
        cleaningstatus.setFont(new Font("serif",Font.PLAIN,20));
        add(cleaningstatus);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(410,10 ,100 , 20);
        l3.setFont(new Font("serif",Font.PLAIN,20));
        add(l3);
        
        JLabel l4 = new JLabel("Country");
        l4.setBounds(550 ,10 ,100 , 20);
        l4.setFont(new Font("serif",Font.PLAIN,20));
        add(l4);
        
        
                
        JLabel l5 = new JLabel("Room number");
        l5.setBounds(660,10 ,130 , 20);
        l5.setFont(new Font("serif",Font.PLAIN,20));
        add(l5);
        
        
                
        JLabel l6 = new JLabel("Checkin time");
        l6.setBounds(800,10 ,130 , 20);
        l6.setFont(new Font("serif",Font.PLAIN,20));
        add(l6);    
        
        
                      
        JLabel l7 = new JLabel("Deposit");
        l7.setBounds(930,10 ,100 , 20);
        l7.setFont(new Font("serif",Font.PLAIN,20));
        add(l7); 
        
        
        table = new JTable();
        table.setBounds(0,40,1050,700);
        table.setFont(new Font("Serif",Font.PLAIN,15));
        add(table);

        try{
            
            Conn c = new Conn();         
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));          
        }catch(Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 300,150, 30);
        back.setFont(new Font("serif",Font.PLAIN,18));
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1080,730);
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new CustomerInfo();

    }
}
