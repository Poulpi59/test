package mon_premier_projet;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;

public class jframe_test extends JFrame {

	private JPanel contentPane;
	private JTextField txtToto;
	private JList jList;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_test frame = new jframe_test();
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
	public jframe_test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// création du bouton + actionListener
		JButton btnNewButton = new JButton("Parcourir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickParcourir(e);
				buttonClick(e);
			}
		});
		btnNewButton.setBounds(24, 13, 97, 25);
		contentPane.add(btnNewButton);

		txtToto = new JTextField();
		txtToto.setText("toto");
		txtToto.setBounds(145, 14, 287, 22);
		contentPane.add(txtToto);
		txtToto.setColumns(10);

		jList = new JList(new DefaultListModel<String>());
		jList.setBounds(33, 48, 204, 181);
		jList.setAutoscrolls(true);
		contentPane.add(jList);

		btnNewButton_1 = new JButton("Parcourir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickParcourir(e);
			}
		});
		btnNewButton_1.setBounds(266, 119, 97, 25);
		contentPane.add(btnNewButton_1);

	}

	private void buttonClick(ActionEvent e) {
		JOptionPane.showMessageDialog(null, this.txtToto.getText(), "Mon titre", JOptionPane.INFORMATION_MESSAGE);
		// DefaultListModel<String> dlm = new DefaultListModel<String>();
		// dlm.addElement(this.txtToto.getText());
		// jlist.setmodel(dlm);
		((DefaultListModel<String>)jList.getModel()).addElement(this.txtToto.getText());

		// List<String> list = new ArrayList<String>(); // création d'une liste
		// list.add("Ma string1"); // ajout d'elements dans la liste
		// list.add("Ma string2");
		//
		// for (String s : list) {
		// System.out.println(s);
		// }
	}

	private void clickParcourir(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File myFile = jfc.getSelectedFile();
			System.out.println(myFile.getAbsolutePath());
		}
	}

}
