import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import javax.swing.border.LineBorder;


public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JPanel whitePanel = new JPanel();
    LineBorder lineBorder =new LineBorder(Color.white, 8, true);


    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("Reset");
    JButton registerButton = new JButton("Register");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField(20);
    JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");

    JLabel loginLabel = new JLabel("LOGIN");
    JLabel welcomeLabel = new JLabel("Welcome back! Please enter your account");
    JLabel userIDLabel = new JLabel("Username");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
    JLabel messageLabel = new JLabel();
        


    // Assuming these are the components you want to add to the background
    JLabel label = new JLabel();
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    HashMap<String, String> logininfo = new HashMap<String, String>();

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        // Create an instance of ImagePanel for background
        ImagePanel backgroundPanel = new ImagePanel(new ImageIcon("C:/Users/ASUS/Documents/LoginSystem/bg.png").getImage());
        ImagePanel backgroundPanel2 = new ImagePanel(new ImageIcon("C:/Users/ASUS/Documents/LoginSystem/bg2.png").getImage());


        // Set layout and bounds for the background panel
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, 985, 720);
        
        backgroundPanel2.setLayout(null);
        backgroundPanel2.setBounds(40, 90,485, 550);
        
        whitePanel.setLayout(null);
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(485, 90, 445, 550);


        logininfo = loginInfoOriginal;

        loginLabel.setBounds(105, 90, 150, 25);
        welcomeLabel.setBounds(105, 130, 250, 25);
        Font customFont = new Font(null, Font.BOLD, 25);
        loginLabel.setFont(customFont);
        userIDLabel.setBounds(90, 185, 200, 25);
        userPasswordLabel.setBounds(90, 260, 200, 25);

        messageLabel.setBounds(90, 320, 160, 35);

        userIDField.setBounds(90, 210, 300, 40);
        userPasswordField.setBounds(90, 290, 300, 40);

        loginButton.setBounds(90, 370, 300, 35);
        loginButton.addActionListener(this);

        resetButton.setBounds(250, 420, 140, 35);
        resetButton.addActionListener(this);

        registerButton.setBounds(90, 420, 140, 35);
        registerButton.addActionListener(this);

        // Set bounds for the components you want to add to the background
        label.setBounds(360, 300, 300, 100);
        forgotPasswordLabel.setBounds(285, 325, 290, 30);



        whitePanel.add(loginLabel);
        whitePanel.add(welcomeLabel);
        whitePanel.add(userIDLabel);
        whitePanel.add(userPasswordLabel);
        whitePanel.add(messageLabel);
        whitePanel.add(userIDField);
        whitePanel.add(userPasswordField);
        whitePanel.add(loginButton);
        whitePanel.add(resetButton);
        whitePanel.add(registerButton);
        whitePanel.add(forgotPasswordLabel);
        whitePanel.add(showPasswordCheckBox);

         showPasswordCheckBox.setBounds(90, 345, 140, 25);
         showPasswordCheckBox.setBackground(Color.WHITE);
        
        //Background settings
        
        //userIDField.setBackground(new Color(158, 158, 158));  
        //userPasswordField.setBackground(new Color(158, 158, 158));
        loginButton.setBackground(new Color(98, 98, 98));
        resetButton.setBackground(new Color(128, 128, 128));
        registerButton.setBackground(new Color(128, 128, 128));
        
        
        
        userIDField.setBorder(null);
        userPasswordField.setBorder(null);       
        loginButton.setBorderPainted(false);
        resetButton.setBorderPainted(false);
        registerButton.setBorderPainted(false);
         
        //placeholder
        String placeholder = "Enter your Username"; 
        someMethod();
       
        userPasswordField.setEchoChar((char) 0);

        //frame settings 
                
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setLayout(null);
        frame.add(backgroundPanel2);
        frame.add(whitePanel); 
        frame.add(backgroundPanel);
        frame.setVisible(true);
        
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
            userIDField.setBorder(null);
            userPasswordField.setBorder(null); 
        }
       
        if (e.getSource() == registerButton) {
            frame.dispose();
            RegisterPage registerPage = new RegisterPage();
            
        }
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    frame.dispose();

                    WelcomePage welcomePage = new WelcomePage();
                } else {
                    messageLabel.setForeground(Color.red);
                    userIDField.setBorder(null);
                    userPasswordField.setBorder(new LineBorder(Color.red,1));
                    messageLabel.setText("Wrong Password");
                }
            } else {
                messageLabel.setForeground(Color.red);
                userIDField.setBorder(new LineBorder(Color.red,2));
                userPasswordField.setBorder(new LineBorder(Color.red,2));

                messageLabel.setText("Username not found");
            }
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
        
      String password = new String(userPasswordField.getPassword());

                  
         private void setPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
    }
        
        
        
        
        
        
        
        public void someMethod() {
        
        showPasswordCheckBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox checkBox = (JCheckBox) e.getSource();
                 char echoChar = checkBox.isSelected() ? (char) 0 : '*';
                userPasswordField.setEchoChar(echoChar);                }
            });

               String placeholder = "Enter your username";
               String placeholder2 = "Enter your password";
              userIDField.addFocusListener(new FocusListener() {
               @Override
        public void focusGained(FocusEvent e) {
                if (userIDField.getText().equals(placeholder)) {
                    userIDField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userIDField.getText().isEmpty()) {
                    setPlaceholder(userIDField, placeholder);
                }
            }
        });
        
        userPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
               if (String.valueOf(userPasswordField.getPassword()).equals(placeholder2)) {
                     userPasswordField.setText("");
               }
            }

            @Override
            public void focusLost(FocusEvent e) {
               
               if (String.valueOf(userPasswordField.getPassword()).isEmpty()) {
                     
                     setPlaceholder(userPasswordField, placeholder2);
               }
            }
         });   
       }
    }