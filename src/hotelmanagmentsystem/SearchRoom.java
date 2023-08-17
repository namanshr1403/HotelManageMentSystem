
package hotelmanagmentsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedOptions;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text = new JLabel("Search Room");
        text.setFont(new Font("serif",Font.BOLD,25));
        text.setBounds(400,30,200 ,30);
        text.setForeground(Color.red);
        add(text);
        
        JLabel bedtypelbl= new JLabel("Bed Type");
        bedtypelbl.setBounds(50, 70, 280, 20);
        bedtypelbl.setFont(new Font("serif",Font.PLAIN,18));
        add(bedtypelbl);
        
        bedOptions = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedOptions.setBounds(150, 70, 150,25 );
        bedOptions.setBackground(Color.WHITE);
        bedOptions.setFont(new Font("serif",Font.PLAIN,18));
        add(bedOptions);
        
        
        available = new JCheckBox("Only display Available");
        available.setBounds(650,100 ,250 , 25);
        available.setBackground(Color.WHITE);
        available.setFont(new Font("serif",Font.PLAIN,20));
        add(available);

        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,160,150,20);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
        JLabel l2  = new JLabel("Availiblity");
        l2.setBounds(270,160,100,20);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);
      
        JLabel cleaningstatus  = new JLabel("Status");
        cleaningstatus.setBounds(450,160,100,20);
        cleaningstatus.setFont(new Font("serif",Font.BOLD,17));
        add(cleaningstatus);
        
        JLabel l3 = new JLabel("Price");
        l3.setBounds(670,160 ,100 , 20);
        l3.setFont(new Font("serif",Font.BOLD,17));
        add(l3);
        
        JLabel l4 = new JLabel("Bed Type");
        l4.setBounds(870,160 ,100 , 20);
        l4.setFont(new Font("serif",Font.BOLD,17));
        add(l4);
 
        table = new JTable();
        table.setBounds(0,200,1000 ,300);
        table.setFont(new Font("serif",Font.PLAIN,17));
        add(table);
        
        
        try{  
            Conn c = new Conn();         
            ResultSet rs = c.s.executeQuery("select * from room");
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

        setBounds(300,200,1090,630);
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                String query1 = "select * from room where bed_type = '"+bedOptions.getSelectedItem()+"'";
                String query2 ="select * from room where availablity = 'Available' AND bed_type = '"+bedOptions.getSelectedItem()+"'";
                
                Conn c = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = c.s.executeQuery(query2);
                }else{
                    rs = c.s.executeQuery(query1);
                }
               table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
        setVisible(false);
        new Reception();
        }
    }
    
    public static void main(String[] args) {
        new SearchRoom();

    }
}
