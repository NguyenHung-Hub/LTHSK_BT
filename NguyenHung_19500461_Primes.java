package baiTap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NguyenHung_19500461_Primes extends JFrame implements ActionListener {

	private JTextField txtInput;
	private JTextArea txtResulTextArea;
	private JButton btnGenerate;

	public NguyenHung_19500461_Primes() {
		setTitle("Primes");
		setSize(400, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel inputPanel = new JPanel();
		
		JPanel resultPanel = new JPanel();

		txtInput = new JTextField(10);
		txtInput.addActionListener(this);
		inputPanel.add(txtInput);
		btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(this);
		inputPanel.add(btnGenerate);
		mainPanel.add(inputPanel, BorderLayout.NORTH);

		txtResulTextArea = new JTextArea(10, 20);

		JScrollPane scrollPane = new JScrollPane(txtResulTextArea);

		resultPanel.add(scrollPane);
		mainPanel.add(resultPanel, BorderLayout.CENTER);

		this.add(mainPanel);

	}

	public static void main(String[] args) {
		new NguyenHung_19500461_Primes().setVisible(true);
	}

	public boolean checkPrimes(int number) {
		if (number < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(number); i++)
			if (number % i == 0)
				return false;

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object.equals(btnGenerate) || object.equals(txtInput)) {

			txtResulTextArea.setText("");
			int quantity = 0;

			try {
				quantity = Integer.parseInt(txtInput.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Nhập sai !");
				txtInput.selectAll();
				txtInput.requestFocus();
				return;
			}

			quantity = Integer.parseInt(txtInput.getText());
			int i = 2;
			int count = 0;
			while (count < quantity) {
				if (checkPrimes(i) == true) {
					count++;
//					txtResulTextArea.setText(txtResulTextArea.getText() + "\n" + i);
					txtResulTextArea.append(i + "\n");
				}
				i++;
			}
			txtInput.requestFocus();
		}

	}
}
