package baiTap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
//import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class N1_NguyenHung_19500461_CongTruNhanChia extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnSolve, btnClear, btnClose;
	private JTextField txtA, txtB, txtResult;
	private JRadioButton rbtnAdd, rbtnSub, rbtnMulti, rbtnDiv;
	private ButtonGroup group;

	public N1_NguyenHung_19500461_CongTruNhanChia() {
		setTitle("Cộng - Trừ - Nhân - Chia");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());

		/* Header */
		JLabel headerJLabel = new JLabel("Cộng Trừ Nhân Chia", SwingConstants.CENTER);
		headerJLabel.setFont(new Font("Arial", Font.BOLD, 24));
		headerJLabel.setForeground(Color.blue);
		headerJLabel.setPreferredSize(new Dimension(getWidth(), 50));
		this.add(headerJLabel, BorderLayout.NORTH);

		/* begin: Choose Action */
		JPanel actionJPanel = new JPanel();
		actionJPanel.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		actionJPanel.setPreferredSize(new Dimension(100, getHeight()));

		btnSolve = new JButton("Giải");
		btnSolve.setPreferredSize(new Dimension(80, 30));
		btnSolve.setMnemonic(KeyEvent.VK_G);
		actionJPanel.add(btnSolve);
		
		btnClear = new JButton("Xóa");
		btnClear.setPreferredSize(new Dimension(80, 30));
		btnClear.setMnemonic(KeyEvent.VK_X);
		actionJPanel.add(btnClear);
		
		btnClose = new JButton("Thoát");
		btnClose.setPreferredSize(new Dimension(80, 30));
		btnClose.setMnemonic(KeyEvent.VK_T);
		actionJPanel.add(btnClose);

		btnSolve.addActionListener(this);
		btnClear.addActionListener(this);
		btnClose.addActionListener(this);

		this.add(actionJPanel, BorderLayout.WEST);
		/* end: Choose Action */

		/* begin: Calculate */
		JPanel calculateJPanel = new JPanel();
		calculateJPanel.setBorder(BorderFactory.createTitledBorder("Tính toán"));

		JPanel aJPanel = new JPanel();
		JLabel numberA = new JLabel("Nhập a:");
		aJPanel.add(numberA);
		txtA = new JTextField(25);
		txtA.setFont(new Font("Arial", Font.PLAIN, 14));
		aJPanel.add(txtA);
		calculateJPanel.add(aJPanel);

		JPanel bJPanel = new JPanel();
		JLabel numberB = new JLabel("Nhập b:");
		bJPanel.add(numberB);
		txtB = new JTextField(25);
		txtB.setFont(new Font("Arial", Font.PLAIN, 14));
		bJPanel.add(txtB);
		calculateJPanel.add(bJPanel);

		/* begin: operation - phép toán */
		JPanel operationJPanel = new JPanel(new GridLayout(0, 2, 10, 10));
		operationJPanel.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		operationJPanel.setPreferredSize(new Dimension(225, 100));

		rbtnAdd = new JRadioButton("Cộng", true);
		rbtnAdd.addActionListener(this);
		rbtnAdd.setActionCommand("add");
		operationJPanel.add(rbtnAdd);

		rbtnSub = new JRadioButton("Trừ");
		rbtnSub.addActionListener(this);
		rbtnSub.setActionCommand("sub");
		operationJPanel.add(rbtnSub);

		rbtnMulti = new JRadioButton("Nhân");
		rbtnMulti.addActionListener(this);
		rbtnMulti.setActionCommand("multi");
		operationJPanel.add(rbtnMulti);

		rbtnDiv = new JRadioButton("Chia");
		rbtnDiv.addActionListener(this);
		rbtnDiv.setActionCommand("div");
		operationJPanel.add(rbtnDiv);

		group = new ButtonGroup();
		group.add(rbtnAdd);
		group.add(rbtnSub);
		group.add(rbtnMulti);
		group.add(rbtnDiv);
		calculateJPanel.add(operationJPanel);
		/* end: oparation */

		JPanel resultJPanel = new JPanel();
		JLabel resultJLabel = new JLabel("Kết quả:");
		resultJPanel.add(resultJLabel);
		txtResult = new JTextField(25);
		txtResult.setFont(new Font("Arial", Font.PLAIN, 14));
		txtResult.setEditable(false);
		resultJPanel.add(txtResult);

		calculateJPanel.add(resultJPanel);
		this.add(calculateJPanel, BorderLayout.CENTER);
		/* end: Calculate */

		/*begin: bottom*/
		JPanel bottomJPanel = new JPanel();
		bottomJPanel.setPreferredSize(new Dimension(getWidth(), 50));
		bottomJPanel.setBackground(Color.pink);

		JPanel blueJPanel = new JPanel();
		blueJPanel.setPreferredSize(new Dimension(25, 25));
		blueJPanel.setBackground(Color.blue);
		blueJPanel.setOpaque(true);
		bottomJPanel.add(blueJPanel);

		JPanel redJPanel = new JPanel();
		redJPanel.setPreferredSize(new Dimension(25, 25));
		redJPanel.setBackground(Color.red);
		redJPanel.setOpaque(true);
		bottomJPanel.add(redJPanel);

		JPanel yellowJPanel = new JPanel();
		yellowJPanel.setPreferredSize(new Dimension(25, 25));
		yellowJPanel.setBackground(Color.yellow);
		yellowJPanel.setOpaque(true);
		bottomJPanel.add(yellowJPanel);

		this.add(bottomJPanel, BorderLayout.SOUTH);
		/*end: bottom*/
	}

	public static void main(String[] args) {
		new N1_NguyenHung_19500461_CongTruNhanChia().setVisible(true);
	}

	public boolean checkValue() {
		try {
			double a = Double.parseDouble(txtA.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Nhập sai a!");
			txtA.selectAll();
			txtA.requestFocus();
			return false;
		}

		try {
			double b = Double.parseDouble(txtB.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Nhập sai b!");
			txtB.selectAll();
			txtB.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object.equals(btnSolve)) {
			if (checkValue()) {

				double a = Double.parseDouble(txtA.getText());
				double b = Double.parseDouble(txtB.getText());

				if (group.getSelection().getActionCommand().equals("add"))
					txtResult.setText(Double.toString(a + b));
				else if (group.getSelection().getActionCommand().equals("sub"))
					txtResult.setText(Double.toString(a - b));
				else if (group.getSelection().getActionCommand().equals("multi"))
					txtResult.setText(Double.toString(a * b));
				else if (group.getSelection().getActionCommand().equals("div")) {

					if (b == 0) {
						JOptionPane.showMessageDialog(this, "Không thể chia cho số 0.");
						txtB.selectAll();
						txtB.requestFocus();
						return;
					} else
						txtResult.setText(Double.toString(a / b));
				}

			}

		}

		if (object.equals(btnClear)) {
			txtA.setText("");
			txtB.setText("");
			txtResult.setText("");
			txtA.requestFocus();
		}

		if (object.equals(btnClose)) {
			System.exit(0);
		}
	}
}
