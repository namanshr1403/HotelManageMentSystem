package hotelmanagmentsystem;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddDriver extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfieldage,jtextprice,jtextavailabel,tfieldName,jTextcarcompany,jTextcarmodel,jtextfieldLocation;
    JComboBox jcombobox,Jgender,jBedChoosenOption,jAvailableCombo;
    
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Georgia",Font.PLAIN,30));
        heading.setForeground(Color.red);
        heading.setBounds(150,10,200,30);
        add(heading);
        
        JLabel jlabel = new JLabel("Name");
        jlabel.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabel.setBounds(60,70,120,30);
        add(jlabel);
        
        tfieldName = new JTextField();
        tfieldName.setBounds(200,80,150,30);
        tfieldName.setFont(new Font("Georgia",Font.PLAIN,15));
        add(tfieldName);
        
        JLabel jlabelroomno = new JLabel("Age");
        jlabelroomno.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabelroomno.setBounds(60,110,120,30);
        add(jlabelroomno);
        
        tfieldage = new JTextField();
        tfieldage.setBounds(200,115,150,30);
        add(tfieldage);
        

        JLabel jlabelclean = new JLabel("Gender");
        jlabelclean.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabelclean.setBounds(60,150,120,30);
        add(jlabelclean);
        
        String cleancombo[] = {"Male","Female"};
        Jgender = new JComboBox(cleancombo);
        Jgender.setBounds(200,150,150,30);
        Jgender.setBackground(Color.white);
        Jgender.setFont(new Font("Georgia",Font.PLAIN,15));
        add(Jgender);
        
        
        JLabel jlabaleprice = new JLabel("Car Company");
        jlabaleprice.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabaleprice.setBounds(60,190,150,30);
        add(jlabaleprice);
        
        jTextcarcompany = new JTextField();
        jTextcarcompany.setBounds(200,190,150,30);
        jTextcarcompany.setFont(new Font("Georgia",Font.PLAIN,15));
        add(jTextcarcompany);

        
        
        JLabel jbedType = new JLabel("Car Model");
        jbedType.setFont(new Font("Georgia",Font.PLAIN,18));
        jbedType.setBounds(60,230,120,30);
        add(jbedType);
        
        jTextcarmodel = new JTextField();
        jTextcarmodel.setBounds(200,230,150,30);
        jTextcarmodel.setFont(new Font("Georgia",Font.PLAIN,15)); 
        add(jTextcarmodel);
        
        JLabel javailable = new JLabel("Available Status");
        javailable.setFont(new Font("Georgia",Font.PLAIN,18));
        javailable.setBounds(60,270,150,30);
        add(javailable);
        
        
        String available[] = {"Available","Busy"};
        jAvailableCombo = new JComboBox(available);
        jAvailableCombo.setBounds(200,270,150,30);
        jAvailableCombo.setBackground(Color.white);
        jAvailableCombo.setFont(new Font("Georgia",Font.PLAIN,15));
        add(jAvailableCombo);
        
        JLabel jlocation = new JLabel("Location");
        jlocation.setFont(new Font("Georgia",Font.PLAIN,18));
        jlocation.setBounds(60,310 ,120 ,30 );
        add(jlocation);
        
        
        jtextfieldLocation = new JTextField();
        jtextfieldLocation.setFont(new Font("Georgia",Font.PLAIN,15));
        jtextfieldLocation.setBounds(200,310,150,30);
        add(jtextfieldLocation);
   
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.setFont(new Font("Georgia",Font.PLAIN,18));
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.setFont(new Font("Georgia",Font.PLAIN,18));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = imageicon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400,60 ,500 , 300);
        add(image);
        
        setBounds(300,200,980,470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = tfieldName.getText();
            String age = tfieldage.getText();
            String carmodel = jTextcarmodel.getText();
            String carcompany = jTextcarcompany.getText();
            String location = jtextfieldLocation.getText();
            
            String available = (String)jAvailableCombo.getSelectedItem();
            String gender = (String)Jgender.getSelectedItem();
            
            try{
               Conn conn = new Conn();
               String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+location+"','"+available+"')";
               conn.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"New Driver Added Successfully ");
                setVisible(false);
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
