package baiTap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NguyenHung_19500461_PhuongTrinhBacHai extends JFrame implements ActionListener {

	private JButton solveBtn, clearBtn, exitBtn;
	private JTextField aTextField, bTextField, cTextField, resultViewLabel;

	public NguyenHung_19500461_PhuongTrinhBacHai() {
		
		setTitle("Giai phuong trinh bac hai");
		setSize(600, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());

		// BEGIN HEADER
		JLabel lHeader = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI", SwingConstants.CENTER);
		lHeader.setBackground(Color.cyan);
		lHeader.setOpaque(true); 
		lHeader.setPreferredSize(new Dimension(600, 50));
		lHeader.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(lHeader, BorderLayout.NORTH);
		// END HEADER

		// BEGIN BODY
		Box mainBox = Box.createVerticalBox();
		mainBox.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		Box aBox, bBox, cBox, resultBox;

		aBox = Box.createHorizontalBox();
		aBox.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		bBox = Box.createHorizontalBox();
		bBox.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		cBox = Box.createHorizontalBox();
		cBox.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		resultBox = Box.createHorizontalBox();
		resultBox.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

		// Nhập a
		JLabel aLabel = new JLabel("Nhập a:");
		aLabel.setPreferredSize(new Dimension(100, 50));

		aTextField = new JTextField(5);
		aTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		aBox.add(aLabel);
		aBox.add(aTextField);
		mainBox.add(aBox);

		// Nhập b
		JLabel bLabel = new JLabel("Nhập b:");
		bLabel.setPreferredSize(new Dimension(100, 50));
		bTextField = new JTextField(5);
		bTextField.setFont(new Font("Arial", Font.PLAIN, 14));

		bBox.add(bLabel);
		bBox.add(bTextField);
		mainBox.add(bBox);

		// Nhập c
		JLabel cLabel = new JLabel("Nhập c:");
		cLabel.setPreferredSize(new Dimension(100, 50));
		cTextField = new JTextField(5);
		cTextField.setFont(new Font("Arial", Font.PLAIN, 14));

		cBox.add(cLabel);
		cBox.add(cTextField);
		mainBox.add(cBox);

		// Kết quả:
		JLabel resultLabel = new JLabel("Kết quả:");
		resultLabel.setPreferredSize(new Dimension(100, 50));

		resultViewLabel = new JTextField(30);
		resultViewLabel.setEditable(false);

		resultBox.add(resultLabel);
		resultBox.add(resultViewLabel);
		mainBox.add(resultBox);

		this.add(mainBox, BorderLayout.CENTER);
		// END BODY

		// BEGIN OPTION
		JPanel optPanel = new JPanel();
		optPanel.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		optPanel.setPreferredSize(new Dimension(600, 70));

		solveBtn = new JButton("Giải");
		solveBtn.addActionListener(this);
		optPanel.add(solveBtn);

		clearBtn = new JButton("Xóa rỗng");
		clearBtn.addActionListener(this);
		optPanel.add(clearBtn);

		exitBtn = new JButton("Thoát");
		exitBtn.addActionListener(this);
		optPanel.add(exitBtn);

		this.add(optPanel, BorderLayout.SOUTH);
		// END OPTION
	}

	public static void main(String[] args) {
		new NguyenHung_19500461_PhuongTrinhBacHai().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object.equals(solveBtn)) {
			String aText = aTextField.getText();
			String bText = bTextField.getText();
			String cText = cTextField.getText();

			double a, b, c;
			
			//BEGIN: Kiểm tra dữ liệu
			try {
				if (aText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy Nhập a.");
					aTextField.requestFocus();
					return;
				}
				a = Double.parseDouble(aText);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Nhập sai a. Hãy nhập lại.");
				aTextField.selectAll();
				aTextField.requestFocus();
				return;
			}

			try {
				if (bText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy nhập b.");
					bTextField.requestFocus();
					return;
				}
				b = Double.parseDouble(bText);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "Nhập sai b. Hãy nhập lại.");
				bTextField.selectAll();
				bTextField.requestFocus();
				return;
			}

			try {
				if (cText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy nhập c.");
					cTextField.requestFocus();
					return;
				}
				c = Double.parseDouble(cText);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "Nhập sai c. Hãy nhập lại.");
				cTextField.selectAll();
				cTextField.requestFocus();
				return;
			}

			a = Double.parseDouble(aText);
			b = Double.parseDouble(bText);
			c = Double.parseDouble(cText);
			//END: Kiểm tra dữ liệu

			//Giai phuong trinh
			double delta = b * b - 4 * a * c;
			
			if (delta < 0) {
				JOptionPane.showMessageDialog(this, "Phương trình vô nghiệm");
			} else if (delta == 0) {
				resultViewLabel.setText("x = " + Double.toString(-b / (2 * a)));
			} else if (delta > 0) {
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				resultViewLabel.setText("X1 = " + Double.toString(x1) + ", X2 = " + Double.toString(x2));
			}
			aTextField.selectAll();
			bTextField.selectAll();
			cTextField.selectAll();
			aTextField.requestFocus();
		}
		if (object.equals(clearBtn)) {
			aTextField.setText("");
			aTextField.requestFocus();
			bTextField.setText("");
			cTextField.setText("");
			resultViewLabel.setText("");
		}
		if (object.equals(exitBtn)) {
			System.exit(0);
		}
	}
}
