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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import constants.Constants;
import constants.ConstantsGUI;
import controller.Controller;
import entity.Career;
import entity.Job;
import exceptions.ErrorMissingData;

public class DialogAddJob extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelCenter;
	private JLabel lblId, lblName, lblCareer, lblDescription;
	private JTextField txtName;
	private JTextArea txtDescripcion;
	private JButton btnAdd, btnCancel;
	private JComboBox<String> cmbCareer;
	private Job job;

	public DialogAddJob(Controller controller, int id, String[] enterpriseData) {
		this.setSize(ConstantsGUI.DIALOG_GRD_ANCHO, ConstantsGUI.DIALOG_GRD_ALTO);
		this.setTitle(ConstantsGUI.T_CREATE_USER);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.setModal(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.job = new Job();
		this.job.setId(id);
		this.job.setId_enterprise(Long.valueOf(enterpriseData[0]));
		this.job.setName_enterprise(enterpriseData[1]);
		this.job.setPhone_enterprise(enterpriseData[2]);
		this.addObjects(controller);
	}

	private void addObjects(Controller controller) {

		panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.setBackground(Color.WHITE);

		Font f = new Font("Franklin Gothic Demi", Font.PLAIN, 15);

		lblId = new JLabel(ConstantsGUI.T_SUBTITLE_ID + "  " + job.getId());
		lblId.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblId.setFont(f);

		lblName = new JLabel(ConstantsGUI.T_SUBTITLE_BUSSINESS_CARGO);
		lblName.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblName.setFont(f);
		txtName = new JTextField();
		txtName.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblCareer = new JLabel(ConstantsGUI.T_SUBTITLE_PRINCIPAL_CAREER);
		lblCareer.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblCareer.setFont(f);
		cmbCareer = new JComboBox<String>();
		cmbCareer.setBackground(Color.WHITE);
		for (int i = 0; i < Career.values().length; i++) {
			cmbCareer.addItem(Career.values()[i].getTipo());
		}
		cmbCareer.setAlignmentX(Component.LEFT_ALIGNMENT);

		lblDescription = new JLabel(ConstantsGUI.T_SUBTITLE_DESCRIPTION);
		lblDescription.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblDescription.setFont(f);

		txtDescripcion = new JTextArea(15, 5);
		txtDescripcion.setLineWrap(true);
		JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
		scrollDescripcion.setBackground(Color.white);
		scrollDescripcion.getVerticalScrollBar().setBackground(Color.white);
		scrollDescripcion.getHorizontalScrollBar().setBackground(Color.white);
		scrollDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

		btnAdd = new JButton(ConstantsGUI.T_ADD_CONFIRM);
		btnAdd.setActionCommand(Constants.C_ADD_JOB_CONFIRM);
		btnAdd.addActionListener(controller);

		btnCancel = new JButton(ConstantsGUI.T_CANCEL);
		btnCancel.setActionCommand(Constants.C_CANCEL_JOB);
		btnCancel.addActionListener(controller);

		JPanel pnlBtns = new JPanel();
		pnlBtns.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlBtns.setBackground(Color.WHITE);
		pnlBtns.add(btnAdd);
		pnlBtns.add(btnCancel);

		panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));
		panelCenter.add(lblId);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblName);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(txtName);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblCareer);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(cmbCareer);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));
		panelCenter.add(lblDescription);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));
		panelCenter.add(scrollDescripcion);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));
		panelCenter.add(pnlBtns);
		panelCenter.add(Box.createRigidArea(new Dimension(0, 20)));

		this.add(Box.createRigidArea(new Dimension(20, 0)));
		this.add(panelCenter);
		this.add(Box.createRigidArea(new Dimension(20, 0)));
	}

	public void validateData() throws ErrorMissingData {
		if (txtName.getText().equals("")) {
			throw new ErrorMissingData();
		}
	}

	public Job getJobToAdd() {
		String careerAux = cmbCareer.getSelectedItem().toString();
		for (int i = 0; i < Career.values().length; i++) {
			if (careerAux.equals(Career.values()[i].getTipo())) {
				job.setPrincipalCareer(Career.values()[i]);
			}
		}
		job.setName(txtName.getText());
		job.setRequirements(txtDescripcion.getText());
		return job;
	}
}
