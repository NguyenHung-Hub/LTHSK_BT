package baiTap;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class EditTable extends JFrame implements ActionListener{
	private JTextField txtFirstName, txtLastName;
	private JButton btnAdd, btnDelete, btnExit;
	private DefaultTableModel tableModel;
	private JTable table;
	
	public EditTable() {
		setTitle("Edit Table");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(400, 300));
		setMaximumSize(new Dimension(500, 400));
		
		/*Begin: top*/
		JPanel topJPanel = new JPanel();
		topJPanel.setPreferredSize(new Dimension(getWidth(), 130));
		
		//Ho
		JPanel firstNameJPanel = new JPanel();	
		
		JLabel firstNameJLabel = new JLabel("Ho:");
		txtFirstName = new JTextField(20);
		txtFirstName.addActionListener(this);
		firstNameJPanel.add(firstNameJLabel);
		firstNameJPanel.add(txtFirstName);
		
		topJPanel.add(firstNameJPanel);
		
		//Ten
		JPanel lastNameJPanel = new JPanel();
		
		JLabel lastNameJLabel = new JLabel("Ten:");
		txtLastName = new JTextField(20);
		txtLastName.addActionListener(this);
		lastNameJPanel.add(lastNameJLabel);
		lastNameJPanel.add(txtLastName);
		
		topJPanel.add(lastNameJPanel);
		
		//Button
		JPanel btnJPanel = new JPanel();
		
		btnAdd = new JButton("Them");
		btnAdd.addActionListener(this);
		btnJPanel.add(btnAdd);
		
		btnDelete = new JButton("Xoa");
		btnDelete.addActionListener(this);
		btnJPanel.add(btnDelete);
		
		btnExit = new JButton("Thoat");
		btnExit.addActionListener(this);
		btnJPanel.add(btnExit);
		
		topJPanel.add(btnJPanel);
		
		this.add(topJPanel, BorderLayout.NORTH);
		/*End: top*/
		
		/*Begin: table*/
		JPanel bottomJPanel = new JPanel();
		String []header = {"Ho", "Ten"};
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		table.setRowHeight(30);
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		
		/*End: table*/
		
		
		
	}
	
	public static void main(String[] args) {
		new EditTable().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if (object.equals(btnAdd) || object.equals(txtLastName) || object.equals(txtFirstName)) {
			if (txtFirstName.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Hãy nhập họ.");
				txtFirstName.selectAll();
				txtFirstName.requestFocus();
				return;
			}
			
			if (txtLastName.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Hãy nhập tên.");
				txtLastName.selectAll();
				txtLastName.requestFocus();
				return;
			}
			
			Object[] hoTenObjects = new Object[2];
			hoTenObjects[0] = txtFirstName.getText().trim();
			hoTenObjects[1] = txtLastName.getText().trim();
			
			tableModel.addRow(hoTenObjects);
			txtFirstName.setText("");
			txtLastName.setText("");
			
			txtFirstName.requestFocus();
		}
		
		if (object.equals(btnDelete)) {
			
			if (table.getModel().getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Bảng rỗng.");
				return;
			}else {
				if (table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa.");
				}else {
					if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng này không!", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
						tableModel.removeRow(table.getSelectedRow());
				}
			}
			
			txtFirstName.requestFocus();
		}
		
		if (object.equals(btnExit)) {
			System.exit(0);
		}
	}
}
