package baiTap;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListEditDemo extends JFrame implements ActionListener {

	DefaultListModel<String> listModelName;
	JList<String> listName;
	private JTextField txtName;
	private JButton addButton, removeButton, editButton;

	public ListEditDemo() {
		setTitle("List Edit Demo");
		setSize(550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		listModelName = new DefaultListModel<String>();
		listName = new JList<String>(listModelName);
		this.add(new JScrollPane(listName), BorderLayout.CENTER);

		JPanel rightJPanel = new JPanel();
		rightJPanel.setPreferredSize(new Dimension(250, getHeight()));

		JLabel inputName = new JLabel("Input Name");
		rightJPanel.add(inputName);

		txtName = new JTextField(15);
		txtName.addActionListener(this);
		rightJPanel.add(txtName);

		addButton = new JButton("Add item");
		addButton.addActionListener(this);
		removeButton = new JButton("Remove item");
		removeButton.addActionListener(this);
		editButton = new JButton("Edit item");
		editButton.addActionListener(this);

		rightJPanel.add(addButton);
		rightJPanel.add(removeButton);
		rightJPanel.add(editButton);

		this.add(rightJPanel, BorderLayout.EAST);

	}

	public static void main(String[] args) {
		new ListEditDemo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
//		txtName.requestFocus();

		if (object.equals(addButton) || object.equals(txtName)) {
			String nameString = txtName.getText().trim();

			if (nameString.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please input name !");
			} else {
				listModelName.addElement(nameString);
				txtName.setText("");
			}
		} else if (object.equals(removeButton)) {
			if (listModelName.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Erro: list empty!");
				txtName.requestFocus();
				return;
			}
			listModelName.removeElement(listName.getSelectedValue());
		} else if (object.equals(editButton)) {
			if (listModelName.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Erro: list empty!");
				txtName.requestFocus();
				return;
			}

			if (txtName.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please input name edit!");
				txtName.requestFocus();
				return;
			}
			listModelName.setElementAt(txtName.getText(), listName.getSelectedIndex());
			txtName.selectAll();
		}

		txtName.requestFocus();
	}
}
