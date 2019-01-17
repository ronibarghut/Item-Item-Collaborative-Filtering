package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Control.DataHandler;
import Control.Main;
import utils.MyFileLogWriter;
import utils.Utility; 
/**
 * This class is the main application frame of the system
 */
public class MainApplication extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktopPane = new JDesktopPane();
	
	private DataHandler sysData = DataHandler.getInstance();
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	
	private JButton addButton = new JButton("Choose File");
	private JButton RunButton = new JButton("Run");
	private JButton cancelButton = new JButton("Back"); 
	public  String StaticSelectedFile = null;
	protected JTextField matchIDTextField = new JTextField();
	/**
	 * Constructor of the class MainApplication
	 * @param loginFrame 
	 * @param user
	 */
	public MainApplication(JFrame loginFrame ) {
		super();
		 
		
		loginFrame.dispose();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 670, 600); 
		
        desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setBackground(Color.BLACK);
		this.setContentPane(desktopPane);
		
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
	    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aa.jpg"))); // NOI18N
	    jLabel1.setBounds(0, 0, 670, 600);
	    desktopPane.add(jLabel1);
		
	     


		matchIDTextField.setFont(new Font("", Font.BOLD, 12));
		matchIDTextField.setBounds(135, 460, 128, 20);
		jLabel1.add(matchIDTextField);
	    
	    addButton.setFont(new Font("", Font.BOLD, 12));
	    addButton.setBounds(30, 460, 90, 20);
	    addButton.setBackground(new Color(59, 89, 182));
	    addButton.setForeground(Color.WHITE);
	    addButton.setFocusPainted(false);
	    addButton.setBorder(new RoundedBorder(10));
	    addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    addButton.addActionListener(this);
	    jLabel1.add(addButton);
		
	    RunButton.setFont(new Font("", Font.BOLD, 12));
	    RunButton.setBounds(30, 519, 144, 20);
	    RunButton.setBackground(new Color(59, 89, 182));
	    RunButton.setForeground(Color.WHITE);
	    RunButton.setFocusPainted(false);
	    RunButton.setBorder(new RoundedBorder(10));
	    RunButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    
	    RunButton.addActionListener(this);
	    jLabel1.add(RunButton);
	    
	    
//		BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png")));
	    cancelButton.setFont(new Font("", Font.BOLD, 12));
		cancelButton.setBounds(450, 519, 144, 20);
		cancelButton.setBackground(new Color(59, 89, 182));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFocusPainted(false);
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		//buttonsPanel.add(loginButton);
		/////buttonsPanel.add(cancelButton);
		
		cancelButton.addActionListener(this); 
		jLabel1.add(cancelButton);
	    
	    
		
//	
//		this.addWindowListener(new WindowAdapter() {
//			public void windowClosing(final WindowEvent arg0) {
//				if(JOptionPane.showInternalConfirmDialog(desktopPane, 
//						"Do you want to save the changes?", getTitle(),
//						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//					sysData.save();
//				}
//				MyFileLogWriter.saveLogFile();
//				Utility.playSound("wav/notify.wav");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				dispose();
//			}
//		});

	}

	

	@Override
	public void actionPerformed(ActionEvent ev) {
		String  cmd = ev.getActionCommand(); 
		String commandName = ev.getActionCommand();
		if (commandName.equals("Choose File")) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setCurrentDirectory(new File("."));
				
				int result = jFileChooser.showOpenDialog(new JFrame());
			
			
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = jFileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    File userFile = new File(selectedFile.getAbsolutePath());
				    String filename = userFile.getName();
				    this.StaticSelectedFile = filename;
				    this.matchIDTextField.setText(filename);
				}
			
			
		}
		else if (commandName.equals("Run")) {
			if(StaticSelectedFile!= null){
			Main main = new Main(StaticSelectedFile);
			JOptionPane.showInternalMessageDialog(desktopPane, "Done! New file has been exported to the same location!");
			}
			else{
			 JOptionPane.showInternalMessageDialog(desktopPane, "No file chosen, Please choose file in order to run application!");
			}
		}
		else if (commandName.equals("Back")) {
			LoginFrame win = new LoginFrame();
			this.dispose(); 
            win.setVisible(true); 
			// this.dispose();
		}
//		if (commandName.equals("ConnectMenu")) {
//			connectPanel win = new connectPanel(this,user);
//			win.setVisible(true);
//			// this.dispose();
//		
//	}
//		if (commandName.equals("RemoveMenu")) {
//			RemovePanel win = new RemovePanel(this,user);
//			win.setVisible(true);
//			// this.dispose();
//		
//	}
//		if (commandName.equals("SysRepMenu")) {
//			SystemReports dlg = new SystemReports(user);
//			desktopPane.add(dlg);
//			dlg.setVisible(true);
//		
//	}
//		else if(cmd.equals ("Exit")) {
//			int res = JOptionPane.showInternalConfirmDialog(desktopPane, "Do you want to save the changes?", getTitle(),
//					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//			if(res == JOptionPane.YES_OPTION) {
//				sysData.save();
//			}
//			if(res != JOptionPane.CANCEL_OPTION) {
//				MyFileLogWriter.saveLogFile();
//				Utility.playSound("wav/notify.wav");
//				dispose();
//			}
//		}
		
		
	}
	
}
