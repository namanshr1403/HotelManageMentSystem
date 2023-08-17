package hotelmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import net.proteanit.sql.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    
    JTextField tfname,tfage,tfPhone,tfsalary,tfEmail;
    JLabel name,jlabelage,jgender,jjob,jlabelPhone,jlabelEmail,jlabelsalary;
    JRadioButton rbmale,rbfemale,rbother;
    JComboBox jbox;
    
    AddEmployee() {
        setLayout(null);
        
        name = new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Georgia",Font.PLAIN,20));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(200,30,200,30);
        tfname.setFont(new Font("Georgia",Font.PLAIN,18));
        add(tfname);
        
        jlabelage = new JLabel("AGE");
        jlabelage.setBounds(60,80,120,30);
        jlabelage.setFont(new Font("Georgia",Font.PLAIN,20));
        add(jlabelage);
        
        tfage = new JTextField();
        tfage.setBounds(200,80,200,30);
        tfage.setFont(new Font("Georgia",Font.PLAIN,18));
        add(tfage);
        
        
        jgender = new JLabel("GENDER");
        jgender.setBounds(60,130,120,30);
        jgender.setFont(new Font("Georgia",Font.PLAIN,20));
        add(jgender);
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Georgia",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(270, 130, 90, 30);
        rbfemale.setFont(new Font("Georgia",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        rbother = new JRadioButton("OTHERS");
        rbother.setBounds(360, 130, 100, 30);
        rbother.setFont(new Font("Georgia",Font.PLAIN,14));
        rbother.setBackground(Color.WHITE);
        add(rbother);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        bg.add(rbother);
        
        jjob = new JLabel("JOB");
        jjob.setBounds(60,180,120,30);
        jjob.setFont(new Font("Georgia",Font.PLAIN,20));
        add(jjob);
        
        String str[] ={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Services","Chefs","Waiter/Waitress","Accountant","Manager"};
        jbox = new JComboBox(str);
        jbox.setBounds(200,180,200,30);
        jbox.setBackground(Color.WHITE);
        jbox.setFont(new Font("Georgia",Font.PLAIN,18));
        add(jbox);
        
        jlabelPhone = new JLabel("PHONE");
        jlabelPhone.setBounds(60,230,120,30);
        jlabelPhone.setFont(new Font("Georgia",Font.PLAIN,20));
        add(jlabelPhone);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(200,230,200,30);
        tfPhone.setFont(new Font("Georgia",Font.PLAIN,18));
        add(tfPhone);
        
        jlabelsalary = new JLabel("SALARY");
        jlabelsalary.setBounds(60,280,120,30);
        jlabelsalary.setFont(new Font("Georgia",Font.PLAIN,20));
        add(jlabelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200,280,200,30);
        tfsalary.setFont(new Font("Georgia",Font.PLAIN,20));
        add(tfsalary);

        
        jlabelEmail = new JLabel("EMAIL");
        jlabelEmail.setBounds(60,330,120,30);
        jlabelEmail.setFont(new Font("Georgia",Font.PLAIN,20));
        add(jlabelEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(200,330,200,30);
        tfEmail.setFont(new Font("Georgia",Font.PLAIN,20));
        add(tfEmail);
        
        
        
        JButton submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.setFont(new Font("Georgia",Font.PLAIN,18));
        submit.addActionListener(this);
        add(submit);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 60, 450, 370);
        add(image);
                
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String gender = null;     
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }
        else if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone number should not be empty");
            return;
        }
        else if(email.isBlank() && email.isEmpty()){
            JOptionPane.showMessageDialog(null,"Email should be Proper Format");
        }
        if(rbmale.isSelected()){
            gender = "MALE";
        }
        else if(rbfemale.isSelected()){
        gender = "FEMALE";
    }
        else if(rbother.isSelected()){
        gender = "OTHER";
    }
        String cbox = (String)jbox.getSelectedItem();
        
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+cbox+"','"+salary+"','"+phone+"','"+email+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            setVisible(false); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    public static void main(String[] args) {
                new AddEmployee();
    }
    
}
