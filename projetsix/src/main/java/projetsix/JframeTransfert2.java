package projetsix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class JframeTransfert2 extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JFrame frameParent;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public JframeTransfert2(JFrame frame) {
		frameParent = frame;
		setTitle("Frame2");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		list = new JList(new DefaultListModel());
		contentPane.add(list, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Film film = new Film();
			film.setAnnee(new Date());
			film.setId(32);
			film.setTitre("tototototo");
			((JframeTransfert1)frameParent).recevoirFilm(film);
				
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	public void addFilm(Film film) {
		((DefaultListModel)list.getModel()).addElement(film.toString());
		
	}
	
}
