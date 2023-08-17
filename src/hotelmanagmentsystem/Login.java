package hotelmanagmentsystem;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField pass;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        user.setFont(new Font("Georgia",Font.PLAIN,20));
        add(user);
        
        username = new JTextField();
        username.setBounds(150,20,150,30);
        username.setFont(new Font("Georgia",Font.PLAIN,20));
        add(username);
        
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Georgia",Font.PLAIN,20));
        add(password);
        
        pass = new JPasswordField();
        pass.setBounds(150,70,150,30);
        pass.setFont(new Font("Georgia",Font.PLAIN,20));
        add(pass);
      
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Georgia",Font.PLAIN,20));
        login.addActionListener(this);
        add(login);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Georgia",Font.PLAIN,20));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon imageicon = new ImageIcon(i2);
        JLabel image = new JLabel(imageicon);
        image.setBounds(350,10,200,200);
        add(image);     
       setBounds(500,200,600,300);
       
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==login)
       {
           String user = username.getText();
           String pass_word = pass.getText();

           try{
               Conn c = new Conn();
               String query = "select * from login where username = '" + user + "' and password = '"+ pass_word +"'";
               ResultSet rs = c.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Dashboard();
              }
              else{
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
           }catch(Exception e){
               e.printStackTrace();
           }
           
       }
       else if(ae.getSource() == cancel){
           setVisible(false);
       }
    }
   
    public static void main(String[] args) {
        new Login();
    }
    
}
