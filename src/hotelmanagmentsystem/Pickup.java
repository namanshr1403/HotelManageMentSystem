package hotelmanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    Pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text = new JLabel("Pick Up Service");
        text.setFont(new Font("serif",Font.BOLD,25));
        text.setBounds(400,30,200 ,30);
        text.setForeground(Color.red);
        add(text);
        
        JLabel bedtypelbl= new JLabel("Car Name");
        bedtypelbl.setBounds(50, 100, 100, 20);
        bedtypelbl.setFont(new Font("serif",Font.PLAIN,18));
        add(bedtypelbl);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150, 100, 200,25);
        typeofcar.setFont(new Font("serif",Font.PLAIN,18));
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                typeofcar.add(rs.getString("company"));
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
       
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,160,150,20);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
        JLabel l2  = new JLabel("Age");
        l2.setBounds(200,160,100,20);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);
      
        JLabel cleaningstatus  = new JLabel("Gender");
        cleaningstatus.setBounds(330,160,100,20);
        cleaningstatus.setFont(new Font("serif",Font.BOLD,17));
        add(cleaningstatus);
        
        JLabel l3 = new JLabel("Company");
        l3.setBounds(460,160 ,100 , 20);
        l3.setFont(new Font("serif",Font.BOLD,17));
        add(l3);
        
        JLabel l4 = new JLabel("Brand");
        l4.setBounds(630,160 ,100 , 20);
        l4.setFont(new Font("serif",Font.BOLD,17));
        add(l4);
        
        JLabel l5 = new JLabel("Location");
        l5.setBounds(740,160 ,100 , 20);
        l5.setFont(new Font("serif",Font.BOLD,17));
        add(l5);
        
        JLabel l6 = new JLabel("Availablity");
        l6.setBounds(890,160 ,100 , 20);
        l6.setFont(new Font("serif",Font.BOLD,17));
        add(l6);
 
        table = new JTable();
        table.setBounds(0,200,1000 ,300);
        table.setFont(new Font("serif",Font.PLAIN,17));
        add(table);
        
        
        try{  
            Conn c = new Conn();         
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));          
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520 ,120 ,30 );
        submit.setFont(new Font("serif",Font.PLAIN,20));
        add(submit);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 520,120, 30);
        back.addActionListener(this);
        back.setFont(new Font("serif",Font.PLAIN,20));
        add(back);

        setBounds(300,200,1090,680);
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
            try{
                String query1 = "select * from driver where company = '"+typeofcar.getSelectedItem()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
        setVisible(false);
        new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Pickup();
    }
}
