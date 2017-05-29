package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import constants.Constants;
import constants.ConstantsGUI;
import controller.Controller;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnlBack, pnlGraduated, pnlEnterprise;
	private JTextField txtIdGraduated, txtPasswordGraduated, txtIdEnterprise, txtPasswordEnterprise;
	private JButton btnLoginGraduated, btnRegisterGraduated, btnLoginEnterprise, btnRegisterEnterprise;
	private JLabel lblGraduated, lblIdGraduated, lblPasswordGraduated, lblEnterprise, lblIdEnterprise,
			lblPasswordEnterprise;

	public Login(Controller controller) {
		this.setSize(ConstantsGUI.LOGIN_ANCHO, ConstantsGUI.LOGIN_ALTO);
		this.setTitle(ConstantsGUI.T_LOGIN);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addObjects(controller);
	}

	public String[] getGraduatedData() {
		String[] aux = new String[2];
		aux[0] = txtIdGraduated.getText();
		aux[1] = txtPasswordGraduated.getText();
		return aux;
	}

	public String[] getEnterpriseData() {
		String[] aux = new String[2];
		aux[0] = txtIdEnterprise.getText();
		aux[1] = txtPasswordEnterprise.getText();
		return aux;
	}

	private void addObjects(Controller controller) {

		pnlBack = new JPanel();
		pnlBack.setLayout(new BoxLayout(pnlBack, BoxLayout.X_AXIS));

		panelObjectsEmployee(controller);
		panelObjectsEnterprise(controller);

		pnlBack.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlBack.add(pnlGraduated);
		pnlBack.add(Box.createRigidArea(new Dimension(60, 0)));
		pnlBack.add(pnlEnterprise);
		pnlBack.add(Box.createRigidArea(new Dimension(20, 0)));

		this.add(pnlBack);
	}

	private void panelObjectsEmployee(Controller controller) {

		pnlGraduated = new JPanel();
		pnlGraduated.setLayout(new BoxLayout(pnlGraduated, BoxLayout.Y_AXIS));

		Font title = new Font("Franklin Gothic Demi", Font.PLAIN, 40);
		Font subtitle = new Font("Franklin Gothic Demi", Font.PLAIN, 15);

		lblGraduated = new JLabel(ConstantsGUI.T_TITLE_GRADUATED);
		lblGraduated.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGraduated.setFont(title);

		lblIdGraduated = new JLabel(ConstantsGUI.T_SUBTITLE_ID_GRADUATED);
		lblIdGraduated.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIdGraduated.setFont(subtitle);
		txtIdGraduated = new JTextField();
		txtIdGraduated.setAlignmentX(Component.CENTER_ALIGNMENT);

		lblPasswordGraduated = new JLabel(ConstantsGUI.T_SUBTITLE_PASSWORD);
		lblPasswordGraduated.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPasswordGraduated.setFont(subtitle);
		txtPasswordGraduated = new JTextField();
		txtPasswordGraduated.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnLoginGraduated = new JButton(ConstantsGUI.T_CONNECT);
		btnLoginGraduated.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLoginGraduated.setActionCommand(Constants.C_LOGIN_GRADUATED);
		btnLoginGraduated.addActionListener(controller);

		btnRegisterGraduated = new JButton(ConstantsGUI.T_REGISTER);
		btnRegisterGraduated.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegisterGraduated.setActionCommand(Constants.C_REGISTER_GRADUATED);
		btnRegisterGraduated.addActionListener(controller);

		JPanel aux_button_reg = new JPanel();
		aux_button_reg.add(btnLoginGraduated);
		aux_button_reg.add(btnRegisterGraduated);
		aux_button_reg.setOpaque(false);
		aux_button_reg.setAlignmentX(Component.CENTER_ALIGNMENT);

		pnlGraduated.add(Box.createRigidArea(new Dimension(0, 30)));
		pnlGraduated.add(lblGraduated);
		pnlGraduated.add(Box.createRigidArea(new Dimension(0, 40)));
		pnlGraduated.add(lblIdGraduated);
		pnlGraduated.add(Box.createRigidArea(new Dimension(0, 5)));
		pnlGraduated.add(txtIdGraduated);
		pnlGraduated.add(Box.createRigidArea(new Dimension(0, 30)));
		pnlGraduated.add(lblPasswordGraduated);
		pnlGraduated.add(Box.createRigidArea(new Dimension(0, 5)));
		pnlGraduated.add(txtPasswordGraduated);
		pnlGraduated.add(Box.createRigidArea(new Dimension(0, 40)));
		pnlGraduated.add(aux_button_reg);
		pnlGraduated.add(Box.createRigidArea(new Dimension(0, 30)));
	}

	private void panelObjectsEnterprise(Controller controller) {

		pnlEnterprise = new JPanel();
		pnlEnterprise.setLayout(new BoxLayout(pnlEnterprise, BoxLayout.Y_AXIS));

		Font title = new Font("Franklin Gothic Demi", Font.PLAIN, 40);
		Font subtitle = new Font("Franklin Gothic Demi", Font.PLAIN, 15);

		lblEnterprise = new JLabel(ConstantsGUI.T_TITLE_ENTERPRISE);
		lblEnterprise.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEnterprise.setFont(title);

		lblIdEnterprise = new JLabel(ConstantsGUI.T_SUBTITLE_ID_ENTERPRISE);
		lblIdEnterprise.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIdEnterprise.setFont(subtitle);
		txtIdEnterprise = new JTextField();
		txtIdEnterprise.setAlignmentX(Component.CENTER_ALIGNMENT);

		lblPasswordEnterprise = new JLabel(ConstantsGUI.T_SUBTITLE_PASSWORD);
		lblPasswordEnterprise.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPasswordEnterprise.setFont(subtitle);
		txtPasswordEnterprise = new JTextField();
		txtPasswordEnterprise.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnLoginEnterprise = new JButton(ConstantsGUI.T_CONNECT);
		btnLoginEnterprise.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLoginEnterprise.setActionCommand(Constants.C_LOGIN_ENTERPRISE);
		btnLoginEnterprise.addActionListener(controller);

		btnRegisterEnterprise = new JButton(ConstantsGUI.T_REGISTER);
		btnRegisterEnterprise.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegisterEnterprise.setActionCommand(Constants.C_REGISTER_ENTERPRISE);
		btnRegisterEnterprise.addActionListener(controller);

		JPanel aux_button_reg = new JPanel();
		aux_button_reg.add(btnLoginEnterprise);
		aux_button_reg.add(btnRegisterEnterprise);
		aux_button_reg.setOpaque(false);
		aux_button_reg.setAlignmentX(Component.CENTER_ALIGNMENT);

		pnlEnterprise.add(Box.createRigidArea(new Dimension(0, 30)));
		pnlEnterprise.add(lblEnterprise);
		pnlEnterprise.add(Box.createRigidArea(new Dimension(0, 40)));
		pnlEnterprise.add(lblIdEnterprise);
		pnlEnterprise.add(Box.createRigidArea(new Dimension(0, 5)));
		pnlEnterprise.add(txtIdEnterprise);
		pnlEnterprise.add(Box.createRigidArea(new Dimension(0, 30)));
		pnlEnterprise.add(lblPasswordEnterprise);
		pnlEnterprise.add(Box.createRigidArea(new Dimension(0, 5)));
		pnlEnterprise.add(txtPasswordEnterprise);
		pnlEnterprise.add(Box.createRigidArea(new Dimension(0, 40)));
		pnlEnterprise.add(aux_button_reg);
		pnlEnterprise.add(Box.createRigidArea(new Dimension(0, 30)));
	}

	public void clearWindow() {
		txtIdEnterprise.setText("");
		txtIdGraduated.setText("");
		txtPasswordEnterprise.setText("");
		txtPasswordGraduated.setText("");
		this.repaint();
	}
}
