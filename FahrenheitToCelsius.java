package baiTap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FahrenheitToCelsius extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel F, C;
	private JTextField txtF;
	
	public FahrenheitToCelsius() {
		setTitle("Fahrenheit To Celsius");
		setSize(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		panel = new JPanel();
		
		panel.add(F = new JLabel("Enter Fahrenheit temperature:"));
		panel.add(txtF = new JTextField(4));
		txtF.addActionListener(this);
		panel.add(C = new JLabel("Temperature in Celsius:---"));
		
		add(panel);	
		
	}
	
	public static void main(String[] args) {
		new FahrenheitToCelsius().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int fahrenheit, celsius;
		
		String text = txtF.getText();
		fahrenheit = Integer.parseInt(text);
		
		celsius = (fahrenheit-32)*5/9;
		
		C.setText("Temperature in Celsius: " + Integer.toString(celsius));
		
	}
}
