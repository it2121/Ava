package ai;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class homw {

	private JFrame frame;
	private JTextField txtIkliouo;
	final static JLabel lblNewLabel = new JLabel("\r\n");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homw window = new homw();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public homw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("");
		txtIkliouo = new JTextField();
		txtIkliouo.setHorizontalAlignment(SwingConstants.CENTER);
		txtIkliouo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String[] sarray = methodes.sintoarray(txtIkliouo.getText());

					int[] iarray = methodes.getstype(sarray);
					int re = methodes.getreTypeFword(sarray[0]);
					int[] result = methodes.respondform(re, iarray);

					String[] array = methodes.endline(result, sarray);
					String anser = "";
					for (int i = 0; i < array.length; i++) {
						if (array.length - i > 1) {

							anser += array[i] + " ";
						} else {
							anser += array[i] + ".";
						}
						// anser += array[i] + " ";
					}
					String a = "\n";
					lblNewLabel.setText("");
					methodes.reset();
					methodes.showtext("-" + anser);

					txtIkliouo.setText("");
				}

			}
		});
		txtIkliouo.setFont(new Font("Tw Cen MT Condensed Extra Bold",
				Font.PLAIN, 16));
		txtIkliouo.setForeground(new Color(127, 255, 0));
		txtIkliouo.setBackground(Color.BLACK);
		txtIkliouo.setBounds(0, 532, 582, 26);
		frame.getContentPane().add(txtIkliouo);
		txtIkliouo.setColumns(10);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold",
				Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(127, 255, 0));
		lblNewLabel.setBounds(0, 11, 592, 486);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText("");
		methodes.reset();
		methodes.showtext("- Hi my name is Ava what is your name ?");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(
				"C:\\Users\\Mohammad\\Desktop\\20sss17-10-21_220744.png"));
		label.setBounds(0, 0, 592, 568);
		frame.getContentPane().add(label);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
