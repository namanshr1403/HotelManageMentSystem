package hotelmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Reception extends JFrame implements ActionListener{
    JButton reception,newcustomer,addroom,department,allemployees,
            customerinfo,managerinfo,checkout,updatestatus,roomstatus,
            pickupservice,searchroom,logout;
    Reception() {
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10,30 ,200 ,30 );
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        newcustomer.addActionListener(this);
        newcustomer.setLayout(null);
        add(newcustomer);
        
        addroom = new JButton("Rooms");
        addroom.setBounds(10,70 ,200 ,30 );
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        addroom.addActionListener(this);
        add(addroom);
        
        
        department = new JButton("Department");
        department.setBounds(10,110 ,200 ,30 );
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        department.addActionListener(this);
        add(department);
        
        allemployees = new JButton("All Employees");
        allemployees.setBounds(10,150 ,200 ,30 );
        allemployees.setBackground(Color.BLACK);
        allemployees.setForeground(Color.WHITE);
        allemployees.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        allemployees.addActionListener(this);
        add(allemployees);
        
        
        customerinfo = new JButton("Customer info");
        customerinfo.setBounds(10,190 ,200 ,30 );
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        customerinfo.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        add(customerinfo);
        
                
        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10,230,200 ,30 );
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200 ,30 );
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        checkout.addActionListener(this);
        add(checkout);
        
        
        
        updatestatus = new JButton("Update Status");
        updatestatus.setBounds(10,310,200 ,30 );
        updatestatus.setBackground(Color.BLACK);
        updatestatus.setForeground(Color.WHITE);
        updatestatus.addActionListener(this);
        updatestatus.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        add(updatestatus);
        
        
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200 ,30 );
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickupservice = new JButton("PickUp Service");
        pickupservice.setBounds(10,390,200 ,30 );
        pickupservice.setBackground(Color.BLACK);
        pickupservice.setForeground(Color.WHITE);
        pickupservice.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        pickupservice.addActionListener(this);
        add(pickupservice);
        
        searchroom = new JButton("Search Room");
        searchroom.setBounds(10,430,200 ,30 );
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
         searchroom.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        add(searchroom);
        
        
        logout = new JButton("Logout");
        logout.setBounds(10,470,200 ,30 );
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Georgia",Font.TYPE1_FONT,13));
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel jlabel = new JLabel(i1);
        jlabel.setBounds(250,30,500,470);
        add(jlabel);
        
        
        setBounds(300,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == newcustomer) {
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()== addroom){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allemployees){
            setVisible(false);
            new EmpolyeeInfo();
        }
        else if (ae.getSource() == managerinfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == customerinfo){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == searchroom){
            setVisible(false);
            new SearchRoom();
        }
        else if (ae.getSource() == updatestatus){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource() == roomstatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if (ae.getSource() == pickupservice){
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
}
