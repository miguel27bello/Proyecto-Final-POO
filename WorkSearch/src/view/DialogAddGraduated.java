package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import constants.Constants;
import constants.ConstantsGUI;
import controller.Controller;
import entity.Career;
import entity.Graduated;
import exceptions.ErrorMissingData;
import exceptions.ErrorOnlyNumbers;

public class DialogAddGraduated extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelCenter;
	private JLabel lblId, lblName, lblLastName, lblCareer, lblPhone, lblAddress, lblPassword;
	private JTextField txtId, txtName, txtLastName, txtPhone, txtAddress, txtPassword;
	private JButton btnRegister, btnCancel;
	private JComboBox<String> cmbCareer;

	public DialogAddGraduated(Controller controller) {
		this.setSize(ConstantsGUI.DIALOG_GRD_ANCHO, ConstantsGUI.DIALOG_GRD_ALTO);
		this.setTitle(ConstantsGUI.T_CREATE_USER);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.setModal(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addObjects(controller);
	}

	private void addObjects(Controller controller) {

		panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.setBackground(Color.WHITE);

		Font f = new Font("Franklin Gothic Demi", Font.PLAIN, 15);

		lblId = new JLabel(ConstantsGUI.T_SUBTITLE_ID_GRADUATED);
		lblId.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblId.setFont(f);
		txtId = new JTextField();
		txtId.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblName = new JLabel(ConstantsGUI.T_SUBTITLE_NAME);
		lblName.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblName.setFont(f);
		txtName = new JTextField();
		txtName.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblLastName = new JLabel(ConstantsGUI.T_SUBTITLE_LAST_NAME);
		lblLastName.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblLastName.setFont(f);
		txtLastName = new JTextField();
		txtLastName.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblCareer = new JLabel(ConstantsGUI.T_SUBTITLE_CAREER);
		lblCareer.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblCareer.setFont(f);
		cmbCareer = new JComboBox<String>();
		cmbCareer.setBackground(Color.WHITE);
		for (int i = 0; i < Career.values().length; i++) {
			cmbCareer.addItem(Career.values()[i].getTipo());
		}
		cmbCareer.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblPhone = new JLabel(ConstantsGUI.T_SUBTITLE_PHONE);
		lblPhone.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblPhone.setFont(f);
		txtPhone = new JTextField();
		txtPhone.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblAddress = new JLabel(ConstantsGUI.T_SUBTITLE_ADDRESS);
		lblAddress.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblAddress.setFont(f);
		txtAddress = new JTextField();
		txtAddress.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblPassword = new JLabel(ConstantsGUI.T_SUBTITLE_PASSWORD);
		lblPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblPassword.setFont(f);
		txtPassword = new JTextField();
		txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

		btnRegister = new JButton(ConstantsGUI.T_REGISTER_CONFIRM);
		btnRegister.setActionCommand(Constants.C_REGISTER_GRADUATED_CONFIRM);
		btnRegister.addActionListener(controller);

		btnCancel = new JButton(ConstantsGUI.T_CANCEL);
		btnCancel.setActionCommand(Constants.C_CANCEL_GRADUATED);
		btnCancel.addActionListener(controller);

		JPanel pnlBtns = new JPanel();
		pnlBtns.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlBtns.setBackground(Color.WHITE);
		pnlBtns.add(btnRegister);
		pnlBtns.add(btnCancel);

		panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));
		panelCenter.add(lblId);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtId);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblName);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtName);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblLastName);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtLastName);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblCareer);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(cmbCareer);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblPhone);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtPhone);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblAddress);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtAddress);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblPassword);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtPassword);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));
		panelCenter.add(pnlBtns);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));

		this.add(Box.createRigidArea(new Dimension(20, 0)));
		this.add(panelCenter);
		this.add(Box.createRigidArea(new Dimension(20, 0)));
	}

	
	private boolean isOnlyNumbers(String stringValue) {
		boolean auxBoolean = true;
		for (short i = 0; (i < stringValue.length() && auxBoolean); i++) {
			int charAux = (int) stringValue.charAt(i);
			if ((charAux >= 48 && charAux <= 57)) {
				auxBoolean = true;
			} else
				auxBoolean = false;
		}
		return auxBoolean;
	}
	
	public void validateData() throws ErrorMissingData, ErrorOnlyNumbers {
		if (txtAddress.getText().equals("") || txtId.getText().equals("") || txtLastName.getText().equals("")
				|| txtName.getText().equals("") || txtPassword.getText().equals("") || txtPhone.getText().equals("")) {
			throw new ErrorMissingData();
		} else if (!isOnlyNumbers(txtId.getText())) {
			throw new ErrorOnlyNumbers();
		}
	}

	public Graduated getGraduatedToAdd() {
		Graduated graduated = new Graduated();
		graduated.setAddress(txtAddress.getText());
		String careerAux = cmbCareer.getSelectedItem().toString();
		for (int i = 0; i < Career.values().length; i++) {
			if (careerAux.equals(Career.values()[i].getTipo())) {
				graduated.setCareer(Career.values()[i]);
			}
		}
		graduated.setId(Long.valueOf(txtId.getText()));
		graduated.setLastName(txtLastName.getText());
		graduated.setName(txtName.getText());
		graduated.setPassword(txtPassword.getText());
		graduated.setPhone(txtPhone.getText());
		return graduated;
	}

	public void clearDialog() {
		txtId.setText("");
		txtName.setText("");
		txtLastName.setText("");
		txtPhone.setText("");
		txtAddress.setText("");
		txtPassword.setText("");
		this.repaint();
	}
}
