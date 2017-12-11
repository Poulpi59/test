package mon_troisieme_tp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class JFrame3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame3 frame = new JFrame3();
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
	public JFrame3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(35, 13, 383, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Requete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clickRequete();
				} catch (Exception n) {
					n.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(130, 267, 204, 40);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 55, 383, 198);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	private void clickRequete() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing?"
				+ "user=swingUser&password=swingPass&useSSL=false&serverTimezone=GMT");
		Statement st = conn.createStatement();
		// st.execute("INSERT INTO personne VALUES (11, 33, 'abc', 'bcd', 7, 44)");
		String requeteSaisie = textField.getText();
		if (requeteSaisie.toLowerCase().contains("select")) {
			ResultSet rs = st.executeQuery(requeteSaisie);
			int nbColumn = rs.getMetaData().getColumnCount();
			table.setModel(new DefaultTableModel());
			Object[] o = new Object[nbColumn];
			for (int i = 1; i <= nbColumn; i++) {
				((DefaultTableModel) table.getModel()).addColumn(rs.getMetaData().getColumnName(i));
			}
			while (rs.next()) {
				for (int j = 0; j < nbColumn; j++) {
					o[j] = rs.getObject(j + 1);
				}
				((DefaultTableModel) table.getModel()).addRow(o);
			}
		} else if (requeteSaisie.toLowerCase().contains("insert") || requeteSaisie.toLowerCase().contains("delete")
				|| requeteSaisie.toLowerCase().contains("update")) {
			int nombreLignesAffectees = st.executeUpdate(requeteSaisie);
			JOptionPane popupConfirmation = new JOptionPane();
			if (nombreLignesAffectees > 0) {
				popupConfirmation.showMessageDialog(null, "La requete a été executée");
			} else {
				JOptionPane.showMessageDialog(null, "La requete a échouée");
			}
		}
		st.close();
	}

	// private void clickJtable() throws ClassNotFoundException, SQLException {
	// table.setModel(new DefaultTableModel());
	// ((DefaultTableModel)table.getModel()).addColumn("col1");
	// ((DefaultTableModel)table.getModel()).addColumn("col2");
	// Object[] tab = new Object[2];
	// tab[0] = "ligne1";
	// tab[1] = "ligne2";
	// ((DefaultTableModel)table.getModel()).addRow(tab);
	// Object[] tab2 = new Object[2];
	// tab2[0] ="ligne1";
	// tab2[0] ="ligne2";
	// ((DefaultTableModel)table.getModel()).addRow(tab);
	//
	// }

	// requete exemple : insert into personne values(23, 242, 'fef', 'qdzdqz', 13, 54")
}
