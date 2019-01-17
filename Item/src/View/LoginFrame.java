package View;

import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.DataHandler; 

/**
 * Login frame used for logging into the system
 */
public class LoginFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton loginButton = new JButton("Upload Files");
	private JButton cancelButton = new JButton("EXIT"); 
	private JButton aboutButton = new JButton("About");
	private DataHandler sysData;
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	public LoginFrame() {
		super("Item-Based Collaborative Filtering");
		this.sysData = DataHandler.getInstance();
		setBounds(500, 200, 670, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(new Color(127, 255, 212));
		

		// define the layout of the frame to be borderLayout
		getContentPane().setLayout(new BorderLayout());

		// panel that contains the user name and password
		JPanel userDetailsPanel = new JPanel();
		userDetailsPanel.setLayout(null);
		userDetailsPanel.setBackground(Color.WHITE);
		
	    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aa.jpg"))); // NOI18N
        userDetailsPanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 670, 600);
		

 

		//JPanel buttonsPanel = new JPanel(new FlowLayout());
		loginButton.setFont(new Font("", Font.BOLD, 12));
		loginButton.setBounds(50, 490, 144, 20);
		loginButton.setBackground(new Color(59, 89, 182));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusPainted(false);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		//JPanel buttonsPanel = new JPanel(new FlowLayout());
		aboutButton.setFont(new Font("", Font.BOLD, 12));
		aboutButton.setBounds(250, 490, 144, 20);
		aboutButton.setBackground(new Color(59, 89, 182));
		aboutButton.setForeground(Color.WHITE);
		aboutButton.setFocusPainted(false);
		aboutButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		cancelButton.setFont(new Font("", Font.BOLD, 12));
		cancelButton.setBounds(450, 490, 144, 20);
		cancelButton.setBackground(new Color(59, 89, 182));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFocusPainted(false);
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		//buttonsPanel.add(loginButton);
		/////buttonsPanel.add(cancelButton);
		
		loginButton.addActionListener(this);
		aboutButton.addActionListener(this);
		cancelButton.addActionListener(this); 
		jLabel1.add(loginButton);
		jLabel1.add(aboutButton);
		jLabel1.add(cancelButton);
		getContentPane().add(userDetailsPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String commandName = ev.getActionCommand();
		if (commandName.equals("Upload Files")) {
			SplashScreen win = new SplashScreen(this);
			this.dispose(); 
			win.setVisible(true);
			// this.dispose();
		} else if (commandName.equals("EXIT")) {
			this.dispose();
		}else if (commandName.equals("About")) {
			about win = new about();
			this.dispose();
			win.setVisible(true);
		}
	}

	
	
}
