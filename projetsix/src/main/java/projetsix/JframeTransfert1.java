package projetsix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class JframeTransfert1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitre;
	private JTextField textFieldAnnee;
	private JTextField textFieldId;
	private JframeTransfert2 frame2 = new JframeTransfert2(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeTransfert1 frame = new JframeTransfert1();
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
	public JframeTransfert1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(26, 28, 89, 31);
		contentPane.add(lblTitre);

		JLabel lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(26, 78, 94, 36);
		contentPane.add(lblAnnee);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(42, 141, 28, 31);
		contentPane.add(lblId);

		textFieldTitre = new JTextField();
		textFieldTitre.setBounds(68, 32, 307, 27);
		contentPane.add(textFieldTitre);
		textFieldTitre.setColumns(10);

		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(68, 82, 307, 29);
		contentPane.add(textFieldAnnee);
		textFieldAnnee.setColumns(10);

		textFieldId = new JTextField();
		textFieldId.setBounds(67, 143, 308, 27);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickAfficherFrame2();
			}
		});
		btnNewButton.setBounds(170, 193, 97, 25);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("jframe2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherFrame2();
			}
		});
		btnNewButton_1.setBounds(323, 204, 97, 25);
		contentPane.add(btnNewButton_1);
	}

	private void clickAfficherFrame2() {
		Film film = new Film();
		film.setTitre(textFieldTitre.getText());

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			film.setAnnee(sdf.parse(textFieldAnnee.getText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		film.setId(Integer.parseInt(textFieldId.getText()));
		frame2.addFilm(film);
		frame2.setVisible(true);
	}

	private void afficherFrame2() {
		JframeTransfert2 frame2 = new JframeTransfert2(this);
		frame2.setVisible(true);
	}
	
	public void recevoirFilm(Film film) {
		textFieldTitre.setText(film.getTitre());
		textFieldId.setText("" + film.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		textFieldAnnee.setText(sdf.format(film.getAnnee()));
	}
}
