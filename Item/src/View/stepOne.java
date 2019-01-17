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
public class stepOne extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton cancelButton = new JButton("<- Previous"); 
	private JButton StepOneButton = new JButton("Next ->");
	private DataHandler sysData;
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	public stepOne() {
		super("Algorithm Explaination Steps");
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
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/step1.jpg"))); // NOI18N
	    
        userDetailsPanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 670, 600); 
 

		
		
		cancelButton.setFont(new Font("", Font.BOLD, 12));
		cancelButton.setBounds(50, 490, 144, 20);
		cancelButton.setBackground(new Color(59, 89, 182));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFocusPainted(false);
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		//buttonsPanel.add(loginButton);
		/////buttonsPanel.add(cancelButton);
		
		cancelButton.addActionListener(this); 
		jLabel1.add(cancelButton);
		
		
		StepOneButton.setFont(new Font("", Font.BOLD, 12));
		StepOneButton.setBounds(350, 490, 144, 20);
		StepOneButton.setBackground(new Color(59, 89, 182));
		StepOneButton.setForeground(Color.WHITE);
		StepOneButton.setFocusPainted(false);
		StepOneButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		//buttonsPanel.add(loginButton);
		/////buttonsPanel.add(cancelButton);
		
		StepOneButton.addActionListener(this); 
		jLabel1.add(StepOneButton);
		
		getContentPane().add(userDetailsPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		String commandName = ev.getActionCommand();
		if (commandName.equals("<- Previous")) {
			about win = new about();
			this.dispose(); 
            win.setVisible(true); 
			// this.dispose();
		} else if (commandName.equals("Next ->")) {
			stepTwo win = new stepTwo();
			this.dispose(); 
            win.setVisible(true); 
			// this.dispose();
		}
	}

	
	
}
