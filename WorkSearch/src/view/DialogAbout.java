package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import constants.ConstantsGUI;
import constants.ConstantsURL;

public class DialogAbout extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblCredits, lblAuthor, lblVersion, lblUN;

	public DialogAbout() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(ConstantsGUI.DIALOG_CREDITS_ANCHO, ConstantsGUI.DIALOG_CREDITS_ALTO);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setLocationRelativeTo(null);
		setTitle(ConstantsGUI.T_ABOUT);
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setModal(true);
		addObjects();
	}

	public void addObjects() {

		Font f = new Font("Harrington", Font.PLAIN, 20);

		lblCredits = new JLabel(ConstantsGUI.T_CREDITOS);
		lblCredits.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCredits.setFont(f);

		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(lblCredits);

		lblAuthor = new JLabel(ConstantsGUI.T_AUTHOR);
		lblAuthor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAuthor.setFont(f);

		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(lblAuthor);

		lblVersion = new JLabel(ConstantsGUI.T_VERSION);
		lblVersion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblVersion.setFont(f);

		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(lblVersion);

		lblUN = new JLabel();
		lblUN.setIcon(new ImageIcon(ConstantsURL.URL_LOGO));
		lblUN.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(lblUN);
	}
}
