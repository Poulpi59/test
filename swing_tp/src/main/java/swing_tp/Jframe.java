package swing_tp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe frame = new Jframe();
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
	public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickBoutonAjouter();
			}
		});
		btnNewButton.setBounds(34, 13, 471, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afficher dans la console");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickBoutonAfficher();
			}
		});
		btnNewButton_1.setBounds(34, 300, 471, 25);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(85, 140, 359, 31);
		contentPane.add(comboBox);
	}
	
	private void clickBoutonAjouter() {
		comboBox.addItem("toto1");
		comboBox.addItem("toto2");
		comboBox.addItem("toto3");
		comboBox.addItem("toto4");
	}
	
private void clickBoutonAfficher() {
		Object recup = comboBox.getSelectedItem();
		System.out.println(recup.toString());
	}
}
