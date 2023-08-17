package hotelmanagmentsystem;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddRoom extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfield,jtextprice;
    JComboBox jcombobox,jclean,jBedChoosenOption;
    
    AddRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Georgia",Font.BOLD,20));
        heading.setForeground(Color.BLUE);
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel jlabel = new JLabel("Room number");
        jlabel.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabel.setBounds(60,80,120,30);
        add(jlabel);
        
        tfield = new JTextField();
        tfield.setBounds(200,80,150,30);
        tfield.setFont(new Font("Georgia",Font.PLAIN,18));
        add(tfield);
        
        JLabel jlabelroomno = new JLabel("Available");
        jlabelroomno.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabelroomno.setBounds(60,130,120,30);
        add(jlabelroomno);
        
        String availableoptions[] = {"Available","Occupied"};
        jcombobox = new JComboBox(availableoptions);
        jcombobox.setBounds(200,130,150,30);
        jcombobox.setFont(new Font("Georgia",Font.PLAIN,18));
        jcombobox.setBackground(Color.white);
        add(jcombobox);
        

        JLabel jlabelclean = new JLabel("Cleaning Status");
        jlabelclean.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabelclean.setBounds(60,180,120,30);
        add(jlabelclean);
        
        String cleancombo[] = {"Clean","Dirty"};
        jclean = new JComboBox(cleancombo);
        jclean.setBounds(200,180,150,30);
        jclean.setFont(new Font("Georgia",Font.PLAIN,18));
        jclean.setBackground(Color.white);
        add(jclean);
        
        
        JLabel jlabaleprice = new JLabel("Price");
        jlabaleprice.setFont(new Font("Georgia",Font.PLAIN,18));
        jlabaleprice.setBounds(60,230,120,30);
        add(jlabaleprice);
        
        jtextprice = new JTextField();
        jtextprice.setBounds(200,230,150,30);
        jtextprice.setFont(new Font("Georgia",Font.PLAIN,18));
        add(jtextprice);
        
        
        JLabel jbedType = new JLabel("Bed Type");
        jbedType.setFont(new Font("Georgia",Font.PLAIN,18));
        jbedType.setBounds(60,280,120,30);
        add(jbedType);
        
        
        
        String Bedtype[] = {"Single Bed","Double Bed"};
        jBedChoosenOption = new JComboBox(Bedtype);
        jBedChoosenOption.setBounds(200,280,150,30);
        jBedChoosenOption.setBackground(Color.WHITE);
        jBedChoosenOption.setFont(new Font("Georgia",Font.PLAIN,18));
        add(jBedChoosenOption);
        
        add = new JButton("Add Room");
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
        
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(imageicon);
        image.setBounds(400,60 ,500 , 300);
        add(image);
        
        setBounds(330,200,940,470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String roomnumber = tfield.getText();
            String price = jtextprice.getText();
            String available = (String)jcombobox.getSelectedItem();
            String status = (String)jclean.getSelectedItem();
            String bedtype = (String)jBedChoosenOption.getSelectedItem();

            try{
               Conn conn = new Conn();
               String str = "insert into room values('"+roomnumber+"','"+available+"','"+status+"','"+price+"','"+bedtype+"')";
               conn.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"New Room Added Successfully ");
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
        new AddRoom();
    }


}
