
package hotelmanagmentsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;


public class EmpolyeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    EmpolyeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,10,100,20);
        l1.setFont(new Font("Georgia",Font.PLAIN,15));
        add(l1);
        
        JLabel l2  = new JLabel("Age");
        l2.setBounds(190,10,100,20);
        l2.setFont(new Font("Georgia",Font.PLAIN,15));
        add(l2);
      
        JLabel cleaningstatus  = new JLabel("Gender");
        cleaningstatus.setBounds(330,10,100,20);
        cleaningstatus.setFont(new Font("Georgia",Font.PLAIN,15));
        add(cleaningstatus);
        
        JLabel l3 = new JLabel("Job");
        l3.setBounds(480,10 ,100 , 20);
        l3.setFont(new Font("Georgia",Font.PLAIN,15));
        add(l3);
        
        JLabel l4 = new JLabel("Salary");
        l4.setBounds(600 ,10 ,100 , 20);
        l4.setFont(new Font("Georgia",Font.PLAIN,15));
        add(l4);
        
        
                
        JLabel l5 = new JLabel("Phone number");
        l5.setBounds(750,10 ,100 , 20);
        l5.setFont(new Font("Georgia",Font.PLAIN,15));
        add(l5);
        
        
                
        JLabel l6 = new JLabel("Email ID");
        l6.setBounds(890,10 ,100 , 20);
        l6.setFont(new Font("Georgia",Font.PLAIN,15));
        add(l6);       
        
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        table.setFont(new Font("Georgia",Font.PLAIN,15));
        add(table);

        try{
            
            Conn c = new Conn();         
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));          
        }catch(Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500,150, 30);
        back.setFont(new Font("serif",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1080,630);
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new EmpolyeeInfo();

    }
}
