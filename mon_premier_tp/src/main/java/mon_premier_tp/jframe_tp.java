package mon_premier_tp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;

public class jframe_tp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList jList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe_tp frame = new jframe_tp();
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
	public jframe_tp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Parcourir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickParcourir(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(43, 13, 97, 25);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(185, 14, 220, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		jList = new JList(new DefaultListModel<String>());
		jList.setBounds(25, 56, 260, 184);
		jList.setAutoscrolls(true);
		contentPane.add(jList);
	}

	private void clickParcourir(ActionEvent e) throws IOException {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File myFile = jfc.getSelectedFile();
			((DefaultListModel<String>) jList.getModel()).addElement(myFile.getName());
			textField.setText(myFile.getAbsolutePath());
			try {
				FileReader monFichier = new FileReader(myFile);
				BufferedReader br = new BufferedReader(monFichier);
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
