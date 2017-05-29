package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import constants.Constants;
import constants.ConstantsGUI;
import controller.Controller;
import entity.Enterprise;
import exceptions.ErrorMissingData;
import exceptions.ErrorOnlyNumbers;

public class DialogAddEnterprise extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelCenter;
	private JLabel lblId, lblName, lblPhone, lblPassword;
	private JTextField txtId, txtName, txtPhone, txtPassword;
	private JButton btnRegister, btnCancel;

	public DialogAddEnterprise(Controller controller) {
		this.setSize(ConstantsGUI.DIALOG_ENT_ANCHO, ConstantsGUI.DIALOG_ENT_ALTO);
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

		lblId = new JLabel(ConstantsGUI.T_SUBTITLE_ID_ENTERPRISE);
		lblId.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblId.setFont(f);
		txtId = new JTextField();
		txtId.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblName = new JLabel(ConstantsGUI.T_SUBTITLE_SOCIAL_NAME);
		lblName.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblName.setFont(f);
		txtName = new JTextField();
		txtName.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblPhone = new JLabel(ConstantsGUI.T_SUBTITLE_PHONE);
		lblPhone.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblPhone.setFont(f);
		txtPhone = new JTextField();
		txtPhone.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblPassword = new JLabel(ConstantsGUI.T_SUBTITLE_PASSWORD);
		lblPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblPassword.setFont(f);
		txtPassword = new JTextField();
		txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

		btnRegister = new JButton(ConstantsGUI.T_REGISTER_CONFIRM);
		btnRegister.setActionCommand(Constants.C_REGISTER_ENTERPRISE_CONFIRM);
		btnRegister.addActionListener(controller);

		btnCancel = new JButton(ConstantsGUI.T_CANCEL);
		btnCancel.setActionCommand(Constants.C_CANCEL_ENTERPRISE);
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
		panelCenter.add(lblPhone);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtPhone);
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
		if (txtId.getText().equals("") || txtName.getText().equals("") || txtPassword.getText().equals("")
				|| txtPhone.getText().equals("")) {
			throw new ErrorMissingData();
		} else if (!isOnlyNumbers(txtId.getText())) {
			throw new ErrorOnlyNumbers();
		}
	}

	public Enterprise getEnterpriseToAdd() {
		Enterprise enterprise = new Enterprise();
		enterprise.setNit(Long.valueOf(txtId.getText()));
		enterprise.setName(txtName.getText());
		enterprise.setPassword(txtPassword.getText());
		enterprise.setPhone(txtPhone.getText());
		return enterprise;
	}

	public void clearDialog() {
		txtId.setText("");
		txtName.setText("");
		txtPhone.setText("");
		txtPassword.setText("");
		this.repaint();
	}
}
