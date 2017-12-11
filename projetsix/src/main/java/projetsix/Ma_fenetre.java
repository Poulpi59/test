package projetsix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Ma_fenetre extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel monLabel;
	private JCheckBox maCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ma_fenetre frame = new Ma_fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ma_fenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"toto", "tutu", "titi", null},
				{null, null, null, null},
				{null, "tata", "araa", null},
				{null, null, null, "vrbg"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(12, 134, 408, 95);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object o = table.getModel().getValueAt(0, 2);
//				table.getModel().setValueAt("iop" ,0, 2);
				System.out.println(o.toString());
				monLabel.setText("testtestetst");
				maCheckBox.isSelected();
				maCheckBox.setSelected(true);
				}
		});
		btnNewButton.setBounds(22, 228, 387, 25);
		contentPane.add(btnNewButton);
		
		monLabel = DefaultComponentFactory.getInstance().createLabel("fichier");
		monLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		monLabel.setBounds(22, 14, 99, 25);
		contentPane.add(monLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 14, 259, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		maCheckBox = new JCheckBox("New check box");
		maCheckBox.setBounds(46, 45, 113, 25);
		contentPane.add(maCheckBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(32, 85, 127, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(181, 85, 127, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
	}
}
