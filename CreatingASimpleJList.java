package baiTap;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class CreatingASimpleJList extends JFrame implements ListSelectionListener{
	
	private JList<String> listEntry;
	private JTextField textField;
	
	public CreatingASimpleJList() {
		setTitle("Creating a simple JList");
		setSize(320,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		
		JPanel topJPanel = new JPanel();
		topJPanel.setBorder(BorderFactory.createTitledBorder("Simple Jlist"));
		
		String[] entries= {"Entry 1", "Entry 2", "Entry 3", "Entry 4", "Entry 5", "Entry 6"};
		
		listEntry = new JList<String>(entries);
		listEntry.setVisibleRowCount(4);
		JScrollPane listPanel = new JScrollPane(listEntry);	
		topJPanel.add(listPanel);
		
		
		JPanel bottomJPanel = new JPanel();
		bottomJPanel.setBorder(BorderFactory.createTitledBorder("List Selection"));
		
		JLabel label = new JLabel("Last selection");
		bottomJPanel.add(label);
		textField = new JTextField(15);
		bottomJPanel.add(textField);
		
		this.add(topJPanel, BorderLayout.CENTER);
		this.add(bottomJPanel, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		new CreatingASimpleJList().setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		textField.setText(listEntry.getSelectedValue().toString());
		
	}
}
