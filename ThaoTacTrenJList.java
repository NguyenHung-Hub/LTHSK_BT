package baiTap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class ThaoTacTrenJList extends JFrame implements ActionListener, ItemListener {

	private JButton btnHighlightEven, btnHighlightOdd, btnHighlightPrime;
	private JButton btnRemoveHighlight, btnDeleteValueHighlight, btnTotal;
	private JButton btnInput, btnExit, btnRandom;
	private JTextField txtInput;
	private JCheckBox chkNegative;
	private JList<Integer> numberJList;
	private DefaultListModel<Integer> numberListModel;
	private boolean chkNegativeBool;

	private boolean deleted = false;

	public ThaoTacTrenJList() {
		setTitle("Thao tác trên Jlist");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);

		/* Begin: actionPanel */
		JPanel actionJPanel = new JPanel();
		actionJPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Chọn tác vụ"));
		actionJPanel.setPreferredSize(new Dimension(200, getHeight()));

		btnHighlightEven = new JButton("Tô đen số chẵn");
		btnHighlightEven.setPreferredSize(new Dimension(185, 25));
		btnHighlightEven.addActionListener(this);
		actionJPanel.add(btnHighlightEven);

		btnHighlightOdd = new JButton("Tô đen số lẻ");
		btnHighlightOdd.setPreferredSize(new Dimension(185, 25));
		btnHighlightOdd.addActionListener(this);
		actionJPanel.add(btnHighlightOdd);

		btnHighlightPrime = new JButton("Tô đen số nguyên tố");
		btnHighlightPrime.setPreferredSize(new Dimension(185, 25));
		btnHighlightPrime.addActionListener(this);
		actionJPanel.add(btnHighlightPrime);

		btnRemoveHighlight = new JButton("Bỏ tô đen");
		btnRemoveHighlight.setPreferredSize(new Dimension(185, 25));
		btnRemoveHighlight.addActionListener(this);
		actionJPanel.add(btnRemoveHighlight);

		btnDeleteValueHighlight = new JButton("Xóa các giá trị đang tô đen");
		btnDeleteValueHighlight.setPreferredSize(new Dimension(185, 25));
		btnDeleteValueHighlight.addActionListener(this);
		actionJPanel.add(btnDeleteValueHighlight);

		btnTotal = new JButton("Tổng giá trị trong JList");
		btnTotal.setPreferredSize(new Dimension(185, 25));
		btnTotal.addActionListener(this);
		actionJPanel.add(btnTotal);

		this.add(actionJPanel, BorderLayout.WEST);
		/* End: actionPanel */

		/* Begin: centerPanel */
		JPanel centerJPanel = new JPanel();
		centerJPanel.setLayout(new BorderLayout());
		centerJPanel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Nhập thông tin"));

		// Nhập số
		JPanel inputJPanel = new JPanel();
		inputJPanel.setPreferredSize(new Dimension(getWidth(), 50));

		btnInput = new JButton("Nhập");
		btnInput.addActionListener(this);
		inputJPanel.add(btnInput);

		txtInput = new JTextField(15);
		txtInput.setFont(new Font("Arial", Font.PLAIN, 14));
		txtInput.addActionListener(this);
		inputJPanel.add(txtInput);
		
		//Check box
		chkNegative = new JCheckBox();
		chkNegative.addItemListener(this);
		inputJPanel.add(chkNegative);
		inputJPanel.add(new JLabel("Cho nhập số âm"));

		centerJPanel.add(inputJPanel, BorderLayout.NORTH);
		
		// Hiển thị
		numberListModel = new DefaultListModel<Integer>();
		numberJList = new JList<Integer>(numberListModel);
		numberJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		numberJList.setFont(new Font("Arial", Font.PLAIN, 14));
		centerJPanel.add(new JScrollPane(numberJList), BorderLayout.CENTER);

		JPanel southCenter = new JPanel();
		btnRandom = new JButton("Số ngẫu nhiên");
		btnRandom.addActionListener(this);
		southCenter.add(btnRandom);
		centerJPanel.add(southCenter, BorderLayout.SOUTH);

		this.add(centerJPanel, BorderLayout.CENTER);

		JPanel exitJPanel = new JPanel();
		exitJPanel.setPreferredSize(new Dimension(getWidth(), 40));
		exitJPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		btnExit = new JButton("Đóng chương trình");
		btnExit.addActionListener(this);
		exitJPanel.add(btnExit);
		this.add(exitJPanel, BorderLayout.SOUTH);
		/* End: centerPanel */
	}

	public static void main(String[] args) {
		new ThaoTacTrenJList().setVisible(true);
	}

	/**
	 * Chuyển từ arrayList sang array bình thường.
	 * 
	 * @param integer
	 * @return int[]
	 */
	public int[] convertInteger(ArrayList<Integer> integer) {
		int[] size = new int[integer.size()];
		for (int i = 0; i < size.length; i++)
			size[i] = integer.get(i).intValue();
		return size;
	}

	/**
	 * Kiểm tra danh sách có rỗng hay không
	 * 
	 * @return true nếu rỗng
	 */
	public boolean isEmptyList() {
		if (numberListModel.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Danh sách rỗng.");
			txtInput.selectAll();
			txtInput.requestFocus();
			return true;
		}
		return false;
	}

	public void focusInput() {
		txtInput.selectAll();
		txtInput.requestFocus();
		return;
	}

	/**
	 * Kiểm tra số nguyên tố
	 * 
	 * @param number
	 * @return true nếu là số nguyên tố
	 */
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
		
		//Nhập
		if (object.equals(btnInput) || object.equals(txtInput)) {
			String numberString = txtInput.getText();

			if (numberString.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Chưa nhập số.");
				return;
			} else {
				try {
					int number = Integer.parseInt(numberString);

					if (number < 0 && chkNegativeBool == false) {
						JOptionPane.showMessageDialog(this, "Bạn chưa chọn Nhập số âm.");
						txtInput.selectAll();
						txtInput.requestFocus();
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Hãy nhập số.");
					txtInput.selectAll();
					txtInput.requestFocus();
					return;
				}

				numberListModel.addElement(Integer.parseInt(numberString));
			}

			txtInput.selectAll();
			txtInput.requestFocus();
		}

		// Khai báo cho phần tô đen
		ArrayList<Integer> arraySelect = new ArrayList<Integer>();
		int sizeListModel = numberListModel.getSize();
		int[] arraySelected;
		// Tô đen các số chẵn
		if (object.equals(btnHighlightEven)) {
			if (!isEmptyList()) {
				for (int i = 0; i < sizeListModel; i++)
					if (numberListModel.getElementAt(i) % 2 == 0)
						arraySelect.add(i);

				arraySelected = convertInteger(arraySelect);
				if (arraySelected.length == 0)
					JOptionPane.showMessageDialog(this, "Không có số chẵn");
				else
					numberJList.setSelectedIndices(arraySelected);
			}

			focusInput();
		}

		// Tô đen các số lẻ
		if (object.equals(btnHighlightOdd)) {
			if (!isEmptyList()) {
				for (int i = 0; i < sizeListModel; i++)
					if (numberListModel.getElementAt(i) % 2 != 0)
						arraySelect.add(i);

				arraySelected = convertInteger(arraySelect);
				if (arraySelected.length == 0)
					JOptionPane.showMessageDialog(this, "Không có số lẻ");
				else
					numberJList.setSelectedIndices(arraySelected);
			}

			focusInput();
		}

		// Tô đen các số nguyên tố
		if (object.equals(btnHighlightPrime)) {
			if (!isEmptyList()) {

				for (int i = 0; i < sizeListModel; i++)
					if (checkPrimes(numberListModel.getElementAt(i)))
						arraySelect.add(i);

				arraySelected = convertInteger(arraySelect);
				if (arraySelected.length == 0)
					JOptionPane.showMessageDialog(this, "Không có số nguyên tố");
				else
					numberJList.setSelectedIndices(arraySelected);
			}

			focusInput();
		}

		// Bỏ tô đen
		if (object.equals(btnRemoveHighlight)) {
			if (!isEmptyList())
				numberJList.clearSelection();
		}

		// Xóa các giá trị đang tô đen
		if (object.equals(btnDeleteValueHighlight)) {

			if (!isEmptyList()) {
				if (!numberJList.isSelectionEmpty()) {
					int[] getSelected = numberJList.getSelectedIndices();

					for (int i = getSelected.length - 1; i > -1; i--)
						numberListModel.removeElementAt(getSelected[i]);
					deleted = true;
				} else {
					if (deleted == false) {
						JOptionPane.showMessageDialog(this, "Chưa tô đen giá trị.");
						return;
					}
				}
			}
			focusInput();
		}

		// Tổng các giá trị trong danh sách
		if (object.equals(btnTotal)) {
			if (!isEmptyList()) {
				int total = 0;
				for (int i = 0; i < sizeListModel; i++)
					total += numberListModel.getElementAt(i);

				JOptionPane.showMessageDialog(this, "Tổng: " + total);
			}
			focusInput();
		}

		// Số ngẫu nhiên
		if (object.equals(btnRandom)) {
			int sizeRandom = (int) (Math.random() * (10 - 1 + 1) + 1);

			if (chkNegativeBool)
				for (int i = 0; i < sizeRandom; i++)
					numberListModel.addElement((int) (Math.random() * (100 + 100 + 1) - 100));
			else
				for (int i = 0; i < sizeRandom; i++)
					numberListModel.addElement((int) (Math.random() * (100 - 1 + 1) + 1));
			
			focusInput();
		}

		// Thoát chương trình
		if (object.equals(btnExit)) {
			System.exit(0);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItem() == chkNegative)
			chkNegativeBool = true;
		else
			chkNegativeBool = false;
		
		focusInput();
	}
}
