package baiTap;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NguyenHung_19500461_DemoBoxLayout extends JFrame {
	
	
	public NguyenHung_19500461_DemoBoxLayout() {
		setTitle("Bai Tap Tuan 04 - BoxLayout");
		setSize(300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Box boxMain, boxUser, boxPass;
		boxMain = Box.createVerticalBox();
		boxUser = Box.createHorizontalBox();
		boxPass = Box.createHorizontalBox();
		
		boxUser.add(new JLabel("User Name: "));
		boxUser.add(new JTextField(30));
		boxMain.add(boxUser);
		
		boxPass.add(new JLabel("Password: "));
		boxPass.add(new JTextField(30));
		boxMain.add(boxPass);
		
		this.add(boxMain, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		new NguyenHung_19500461_DemoBoxLayout().setVisible(true);
	}
}
