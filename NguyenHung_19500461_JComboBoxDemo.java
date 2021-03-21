package baiTap;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NguyenHung_19500461_JComboBoxDemo extends JFrame implements ActionListener{
	private JLabel label;
	private JComboBox faceComboBox;
	
	public NguyenHung_19500461_JComboBoxDemo() {
		setTitle("JComboBox Demo");
		setSize(400, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		label = new JLabel("The quick brow fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, 12));
		
		add(label, BorderLayout.CENTER);
		
		faceComboBox = new JComboBox();
		faceComboBox.addItem("Serif");
		faceComboBox.addItem("SansSerif");
		faceComboBox.addItem("Monospaced");
		
		add(faceComboBox, BorderLayout.SOUTH);
		faceComboBox.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new NguyenHung_19500461_JComboBoxDemo().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String fontNameString = (String)faceComboBox.getSelectedItem();
		label.setFont(new Font(fontNameString, label.getFont().getStyle(), label.getFont().getSize()));
		
	}
}
