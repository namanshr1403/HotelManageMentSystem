package hotelmanagmentsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    JMenuItem addEmpoloyee,addrooms,adddriver;
    JMenuItem reception;
    Dashboard(){
         setBounds(0,0,1920 ,1080);
         setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg")); 
         Image i2 = i1.getImage().getScaledInstance(1920, 1080,Image.SCALE_DEFAULT);
         ImageIcon imageicon = new ImageIcon(i2);
         JLabel jlabel = new JLabel(imageicon);
         jlabel.setBounds(0,0,1920,1080);
         add(jlabel);
         JLabel text = new JLabel("THE TAJ GROUP WELCOME YOU");
         text.setBounds(400,80,1000,50);
         text.setFont(new Font("Georgia",Font.PLAIN,50));
         text.setForeground(Color.WHITE);
         jlabel.add(text);
         
         JMenuBar mb = new JMenuBar();
         mb.setBounds(0,0,1920,40);
         jlabel.add(mb);
         
         JMenu hotel = new JMenu("HOTEL MANGEMENT");
         hotel.setFont(new Font("Georgia",Font.BOLD,20));
         hotel.setForeground(Color.red);
         mb.add(hotel);
         
         reception = new JMenuItem("RECEPTION");
         reception.addActionListener(this);
         reception.setFont(new Font("Georgia",Font.PLAIN,20));
         hotel.add(reception);
      
         JMenu admin = new JMenu("Admin");
         admin.setForeground(Color.BLUE);
         admin.setFont(new Font("Georgia",Font.BOLD,20));
         mb.add(admin);
         
         addEmpoloyee = new JMenuItem("Add Employee");
         addEmpoloyee.addActionListener(this);
         addEmpoloyee.setFont(new Font("Georgia",Font.PLAIN,20));
         admin.add(addEmpoloyee);
         
         addrooms = new JMenuItem("Add Rooms");
         addrooms.addActionListener(this);
         addrooms.setFont(new Font("Georgia",Font.PLAIN,20));
         admin.add(addrooms);
         
         adddriver = new JMenuItem("Add Drivers");
         adddriver.addActionListener(this);
         adddriver.setFont(new Font("Georgia",Font.PLAIN,20));
         admin.add(adddriver);
         
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRoom();
        }
        else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDriver();
        }
        else if (ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
    
}
