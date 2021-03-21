package baiTap;

import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NguyenHung_19500461_JCheckBoxTest extends JFrame implements ItemListener{
	private JCheckBox chkBold, chkItalic;
	private JPanel p1, p2;
	private JTextField txtField;
	
	public NguyenHung_19500461_JCheckBoxTest() {
		setTitle("JCheckBox Test");
		setSize(400, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(2,1));
		
		p1 = new JPanel();
		
		
		p1.add(txtField = new JTextField("Watch the font style change", 20));
		txtField.setFont(new Font("Serif", Font.PLAIN, 16));
		this.add(p1);
		
		
		p2 = new JPanel();
		p2.add(chkBold = new JCheckBox("Bold"));
		p2.add(chkItalic = new JCheckBox("Italic"));
		
		chkBold.addItemListener(this);
		chkItalic.addItemListener(this);
		this.add(p2);
		
		
	}
	public static void main(String[] args) {
		new NguyenHung_19500461_JCheckBoxTest().setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Font font = txtField.getFont();
		
		if (e.getItem() == chkBold) {
			txtField.setFont(new Font(font.getName(), font.getStyle()^Font.BOLD, font.getSize()));
		}
		
		if (e.getItem() == chkItalic) {
			txtField.setFont(new Font(font.getName(), font.getStyle()^Font.ITALIC, font.getSize()));
		}
		
	}
}
