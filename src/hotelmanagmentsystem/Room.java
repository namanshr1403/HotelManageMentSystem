
package hotelmanagmentsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,650,600);
        add(image);
        
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(0,10,100,20);
        l1.setFont(new Font("Georgia",Font.BOLD,12));
        add(l1);
        
        JLabel l2  = new JLabel("Availiblity");
        l2.setBounds(120,10,100,20);
        l2.setFont(new Font("Georgia",Font.BOLD,12));
        add(l2);
      
        JLabel cleaningstatus  = new JLabel("Status");
        cleaningstatus.setBounds(230,10,100,20);
        cleaningstatus.setFont(new Font("Georgia",Font.BOLD,12));
        add(cleaningstatus);
        
        JLabel l3 = new JLabel("Price");
        l3.setBounds(330,10 ,100 , 20);
        l3.setFont(new Font("Georgia",Font.BOLD,12));
        add(l3);
        
        JLabel l4 = new JLabel("Bed Type");
        l4.setBounds(410,10 ,100 , 20);
        l4.setFont(new Font("Georgia",Font.BOLD,12));
        add(l4);
        
        table = new JTable();
        table.setBounds(0,40,530,400);
        table.setFont(new Font("Georgia",Font.PLAIN,13));
        add(table);

        try{
            Conn c = new Conn();         
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));          
        }catch(Exception e){
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500,120, 30);
        back.setFont(new Font("Georgia",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1050,630);
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new Room();

    }
}
