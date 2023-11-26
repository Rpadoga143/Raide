import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.util.HashMap;

import java.awt.Color;

public class RegisterPage implements ActionListener {

    JFrame frame = new JFrame();
    
    ImagePanel backgroundPanel = new ImagePanel(new ImageIcon("C:/Users/ASUS/Documents/LoginSystem/bg.png").getImage());
     
    JPanel whitePanel = new JPanel();

   HashMap<String, String> logininfo = new HashMap<String, String>();



    JButton registrationButton = new JButton("Create an Account");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JPasswordField userConfirmPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User name");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel confirmUserPasswordLabel = new JLabel("Confirm Password");
    JLabel messageLabel = new JLabel();
    JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");

    
    
  

    public RegisterPage() {
    /*
      userIDLabel.setBounds(90, 185, 200, 25);
        userPasswordLabel.setBounds(90, 260, 200, 25);

        messageLabel.setBounds(90, 320, 150, 35);

        userIDField.setBounds(90, 210, 300, 40);
        userPasswordField.setBounds(90, 290, 300, 40);
    
    
    
    */
        userIDLabel.setBounds(300, 185, 200, 25);
        userPasswordLabel.setBounds(300, 260, 200, 25);
        confirmUserPasswordLabel.setBounds(300, 335, 200, 25);

        
        userIDField.setBounds(300, 210, 390, 40);
        userPasswordField.setBounds(300, 290, 390, 40);
        userConfirmPasswordField.setBounds(300, 370, 390, 40);
        showPasswordCheckBox.setBackground(Color.WHITE);

        someMethod();
        

        registrationButton.setBounds(20, 400, 390, 40);
        registrationButton.setBackground(Color.GRAY);
        registrationButton.addActionListener(this);
        
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, 985, 720);
        
               
        whitePanel.setLayout(null);
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(275, 90, 445, 550);

        showPasswordCheckBox.setBounds(300, 330, 140, 25);
        showPasswordCheckBox.setBackground(Color.WHITE);       
        
        whitePanel.add(showPasswordCheckBox);
        whitePanel.add(registrationButton);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(confirmUserPasswordLabel);
        frame.add(messageLabel); // Assuming you have a messageLabel
        frame.add(userIDField);
        frame.add(whitePanel); 
        frame.add(backgroundPanel);
       

        frame.add(userPasswordField);
        frame.add(userConfirmPasswordField);
       
        
        userIDField.setBorder(null);
        userPasswordField.setBorder(null);
        userConfirmPasswordField.setBorder(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
              
        if (e.getSource() == registrationButton) {
            // Handle registration logic here
            String userID = userIDField.getText();
            String password = new String(userPasswordField.getPassword());
            
            IDandPasswords registeredIDs = new IDandPasswords();
            registeredIDs.addLoginInfo(userID, password);   
            
           
             
            frame.dispose();
            
            
         
            LoginPage loginPage = new LoginPage(registeredIDs.getLoginInfo());

                    
        }
         
        
        
        
    }
      static class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    
    
   public void someMethod() {
    showPasswordCheckBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            userPasswordField.setEchoChar(checkBox.isSelected() ? '\0' : '*');
            userConfirmPasswordField.setEchoChar(checkBox.isSelected() ? '\0' : '*');
        }
    });
}    
    
  }