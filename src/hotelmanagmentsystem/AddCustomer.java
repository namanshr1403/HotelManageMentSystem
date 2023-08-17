package hotelmanagmentsystem;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField tfnumber,tfName,jtextfieldCountry,tfDeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel lblcheckintime,lbltime;
    JButton Add, back;
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("New Customer Forum");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Georgia",Font.PLAIN,20));
        add(text);
        
        JLabel lbild = new JLabel("ID");
        lbild.setBounds(35,80,100,20);
        lbild.setFont(new Font("Georgia",Font.PLAIN,20));
        add(lbild);
        
        String options[]= {"Adhaar Card","Passport","Driving License","Voter-ID","Ration Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        comboid.setFont(new Font("Georgia",Font.PLAIN,15));
        add(comboid);
        
        JLabel label = new JLabel("Number");
        label.setBounds(35,120,100,20);
        label.setFont(new Font("Georgia",Font.PLAIN,20));
        add(label);
        
        
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120 ,150 , 25);
        tfnumber.setFont(new Font("Georgia",Font.PLAIN,15));
        add(tfnumber);
        
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(35,160,100,20);
        labelname.setFont(new Font("Georgia",Font.PLAIN,20));
        add(labelname);
        
        
        tfName = new JTextField();
        tfName.setBounds(200,160 ,150 ,25);
        tfName.setFont(new Font("Georgia",Font.PLAIN,15));
        tfName.setBackground(Color.WHITE);
        add(tfName);
        

        JLabel jlabel = new JLabel("Gender");
        jlabel.setBounds(35,200,100,20);
        jlabel.setBackground(Color.WHITE);
        jlabel.setFont(new Font("Georgia",Font.PLAIN,20));
        add(jlabel);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60,25);
        rmale.setFont(new Font("Georgia",Font.PLAIN,15));
        add(rmale);
        
        
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        rfemale.setFont(new Font("Georgia",Font.PLAIN,15));
        add(rfemale);
        
        
        ButtonGroup button = new ButtonGroup();
        button.add(rmale);
        button.add(rfemale);
        
        
        JLabel country = new JLabel("Country");
        country.setBounds(35,240,100,20);
        country.setBackground(Color.WHITE);
        country.setFont(new Font("Georgia",Font.PLAIN,20));
        add(country);
        
        jtextfieldCountry = new JTextField();
        jtextfieldCountry.setBounds(200,240,150,25);
        jtextfieldCountry.setFont(new Font("Georgia",Font.PLAIN,15));
        add(jtextfieldCountry);
        
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setBackground(Color.WHITE);
        lblroom.setFont(new Font("Georgia",Font.PLAIN,20));
        add(lblroom);
        
        croom = new Choice();
        
        try {
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        croom.setBounds(200,280,150,30);
        croom.setFont(new Font("Georgia",Font.PLAIN,15));
        add(croom);
        
        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Georgia",Font.PLAIN,20));
        add(lbltime);
        
        Date date = new Date();
        
        lblcheckintime = new JLabel("" + date);
        lblcheckintime.setBounds(200, 320, 200, 25);
        lblcheckintime.setFont(new Font("Georgia",Font.PLAIN,16));
        add(lblcheckintime);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,30);
        lbldeposit.setFont(new Font("Georgia",Font.PLAIN,20));
        add(lbldeposit);
        
        
        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,360 ,150 ,25);
        tfDeposit.setBackground(Color.WHITE);
        tfDeposit.setFont(new Font("Georgia",Font.PLAIN,15));
        add(tfDeposit);
        
        Add = new JButton("Add");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(50,410,120,25);
        Add.setFont(new Font("Georgia",Font.PLAIN,20));
        Add.addActionListener(this);
        add(Add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,25);
        back.setFont(new Font("Georgia",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        ImageIcon ig = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i1 = ig.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i1);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == Add){
             String id = (String)comboid.getSelectedItem();
             String number = tfnumber.getText();
             String name = tfName.getText();
             String gender = null;
             if (rmale.isSelected()) {
                 gender = "Male";
             }
             else{
                 gender = "Female";
             }
            String country = jtextfieldCountry.getText();
            String room = croom.getSelectedItem();
            String time = lblcheckintime.getText();
            String deposit = tfDeposit.getText();
            
            
            try{
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2  = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
         }
         else if(ae.getSource()==back){
             setVisible(false);
             new Reception();
             
         }
    }
    
    public static void main(String[] args) {
     new AddCustomer();
    }
   
}
