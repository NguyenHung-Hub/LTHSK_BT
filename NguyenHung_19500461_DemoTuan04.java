package baiTap;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NguyenHung_19500461_DemoTuan04 extends JFrame implements ActionListener {
	
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JPanel p;
	private JButton btnLogin;
	private JButton btnExit;
	
	
	public NguyenHung_19500461_DemoTuan04() {
		setTitle("Bai Tap Tuan 04");
		setSize(300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
//		setUndecorated(true);
		
		setResizable(false);
		p = new JPanel();
//		p.setBackground(new Color(40, 42, 54, 164));
		
		
		
		
		JLabel lblUserJLabel = new JLabel("User Name: ");
		txtUserName = new JTextField(20);
		JLabel lblPassJLabel = new JLabel("Password: ");
		txtPassword = new JTextField(20);
		
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		
		
		p.add(lblUserJLabel);
		p.add(txtUserName);
		p.add(lblPassJLabel);
		p.add(txtPassword);
		
		p.add(btnLogin);
		p.add(btnExit);
		
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		add(p);
	}
	public static void main(String[] args) {
		new NguyenHung_19500461_DemoTuan04().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnLogin)) {
			if (txtPassword.getText().equalsIgnoreCase("123")) {
				JOptionPane.showMessageDialog(this, "Corect password");
			}
			else
				JOptionPane.showMessageDialog(this, "Wrong password");
		}
		
		if(obj.equals(btnExit))
			System.exit(0);
	}
}
