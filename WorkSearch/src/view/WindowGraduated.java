package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import constants.Constants;
import constants.ConstantsGUI;
import controller.Controller;
import entity.Career;
import entity.Graduated;
import entity.Job;
import exceptions.ErrorUnselectedJob;

public class WindowGraduated extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu archive, account, help;
	private JMenuItem itmCloseSession, itmCloseApp, itmDeleteAccount, itmAbout;
	private JPanel panelCenter, panelTable, panelUser;
	private DefaultTableModel modelJobs;
	private JTable tableJobs;
	private JLabel lblOrdenar, lblName, lblLastName, lblId, lblAddress, lblPhone, lblCareer;
	private JComboBox<String> cmbCareer;
	private JButton btnMoreInfo;
	private long id_user;

	public WindowGraduated(Controller controller, Graduated graduated) {
		this.setSize(ConstantsGUI.WINDOW_ANCHO, ConstantsGUI.WINDOW_ALTO);
		this.setTitle(ConstantsGUI.T_JOBS_OFFER);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.addObjects(controller, graduated);
		id_user = graduated.getId();
	}

	private void addObjects(Controller controller, Graduated graduated) {

		menuBar = new JMenuBar();

		archive = new JMenu(ConstantsGUI.T_ARCHIVE);
		account = new JMenu(ConstantsGUI.T_ACCOUNT);
		help = new JMenu(ConstantsGUI.T_AYUDA);

		itmCloseSession = new JMenuItem(ConstantsGUI.T_CLOSE_SESSION);
		itmCloseSession.setActionCommand(Constants.C_CLOSE_SESSION_GRD);
		itmCloseSession.addActionListener(controller);

		itmCloseApp = new JMenuItem(ConstantsGUI.T_CLOSE_APP);
		itmCloseApp.setActionCommand(Constants.C_CLOSE_APP);
		itmCloseApp.addActionListener(controller);

		itmDeleteAccount = new JMenuItem(ConstantsGUI.T_DELETE_ACCOUNT);
		itmDeleteAccount.setActionCommand(Constants.C_DELETE_ACCOUNT_GRD);
		itmDeleteAccount.addActionListener(controller);

		itmAbout = new JMenuItem(ConstantsGUI.T_ABOUT);
		itmAbout.setActionCommand(Constants.C_ABOUT);
		itmAbout.addActionListener(controller);

		archive.add(itmCloseSession);
		archive.add(itmCloseApp);

		account.add(itmDeleteAccount);

		help.add(itmAbout);

		menuBar.add(archive);
		menuBar.add(account);
		menuBar.add(help);

		this.setJMenuBar(menuBar);

		addTopObjects(controller, graduated);
		addCenterObjects(controller);

		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelUser, BorderLayout.NORTH);
		panelCenter.add(panelTable, BorderLayout.CENTER);

		this.add(Box.createRigidArea(new Dimension(25, 0)));
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(Box.createRigidArea(new Dimension(25, 0)));
	}

	private void addTopObjects(Controller controller, Graduated graduated) {

		panelUser = new JPanel();
		panelUser.setLayout(new GridLayout(4, 3));
		panelUser.setBackground(Color.WHITE);

		Font f = new Font("Franklin Gothic Demi", Font.PLAIN, 16);

		lblName = new JLabel(ConstantsGUI.T_W_NAME + graduated.getName());
		lblName.setFont(f);
		lblLastName = new JLabel(ConstantsGUI.T_W_LAST_NAME + graduated.getLastName());
		lblLastName.setFont(f);
		lblId = new JLabel(ConstantsGUI.T_W_ID + graduated.getId());
		lblId.setFont(f);
		lblCareer = new JLabel(ConstantsGUI.T_W_CAREER + graduated.getCareer().getTipo());
		lblCareer.setFont(f);
		lblAddress = new JLabel(ConstantsGUI.T_W_ADDRESS + graduated.getAddress());
		lblAddress.setFont(f);
		lblPhone = new JLabel(ConstantsGUI.T_W_PHONE + graduated.getPhone());
		lblPhone.setFont(f);

		panelUser.add(new JLabel(""));
		panelUser.add(new JLabel(""));
		panelUser.add(new JLabel(""));
		panelUser.add(lblName);
		panelUser.add(lblId);
		panelUser.add(lblAddress);
		panelUser.add(new JLabel(""));
		panelUser.add(new JLabel(""));
		panelUser.add(new JLabel(""));
		panelUser.add(lblLastName);
		panelUser.add(lblCareer);
		panelUser.add(lblPhone);
	}

	private void addCenterObjects(Controller controller) {

		panelTable = new JPanel();
		panelTable.setLayout(new BoxLayout(panelTable, BoxLayout.PAGE_AXIS));
		panelTable.setBackground(Color.WHITE);

		modelJobs = new DefaultTableModel();
		modelJobs.addColumn(ConstantsGUI.T_H_NIT);
		modelJobs.addColumn(ConstantsGUI.T_H_ID);
		modelJobs.addColumn(ConstantsGUI.T_H_NAME);
		modelJobs.addColumn(ConstantsGUI.T_H_NAME_ENTERPRISE);
		modelJobs.addColumn(ConstantsGUI.T_H_PHONE_ENTERPRISE);
		modelJobs.addColumn(ConstantsGUI.T_H_PRINCIPAL_CAREER);

		Font fontHeader = new Font("Franklin Gothic Demi", Font.ITALIC, 14);

		tableJobs = new JTable();
		tableJobs.setModel(modelJobs);
		tableJobs.getTableHeader().setReorderingAllowed(false);
		tableJobs.getTableHeader().setFont(fontHeader);
		tableJobs.setBackground(Color.white);
		tableJobs.setBorder(null);

		lblOrdenar = new JLabel();
		lblOrdenar.setText(ConstantsGUI.T_SORT_CAREERS);

		btnMoreInfo = new JButton(ConstantsGUI.T_MORE_INFORMATION);
		btnMoreInfo.setActionCommand(Constants.C_MORE_INFORMATION_GRD);
		btnMoreInfo.addActionListener(controller);

		JPanel pnlTop = new JPanel();
		pnlTop.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlTop.setBackground(Color.WHITE);
		pnlTop.setLayout(new GridLayout(1, 4));
		pnlTop.add(lblOrdenar);
		pnlTop.add(new JLabel(""));
		pnlTop.add(new JLabel(""));
		pnlTop.add(btnMoreInfo);

		cmbCareer = new JComboBox<String>();
		cmbCareer.setBackground(Color.WHITE);
		cmbCareer.addItem(ConstantsGUI.T_ALL);
		for (int i = 0; i < Career.values().length; i++) {
			cmbCareer.addItem(Career.values()[i].getTipo());
		}
		cmbCareer.setAlignmentX(Component.LEFT_ALIGNMENT);
		cmbCareer.setActionCommand(Constants.C_REORDER_JOBS_WIN_GRD);
		cmbCareer.addActionListener(controller);

		JScrollPane jsTable = new JScrollPane(tableJobs);
		jsTable.setForeground(Color.white);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);

		panelTable.add(Box.createRigidArea(new Dimension(0, 20)));
		panelTable.add(pnlTop);
		panelTable.add(Box.createRigidArea(new Dimension(0, 5)));
		panelTable.add(cmbCareer);
		panelTable.add(Box.createRigidArea(new Dimension(0, 10)));
		panelTable.add(jsTable, BorderLayout.PAGE_END);
		panelTable.add(Box.createRigidArea(new Dimension(0, 20)));
	}

	public String getUserId() {
		return String.valueOf(id_user);
	}

	public void addRowToTable(Job job) {
		modelJobs.addRow(job.vectorStringToGraduated());
	}

	public String[] getIdJobSelected() throws ErrorUnselectedJob {
		int index = tableJobs.getSelectedRow();
		String[] aux = new String[2];
		if (index > -1) {
			aux[0] = String.valueOf(tableJobs.getValueAt(index, 1));
			aux[1] = String.valueOf(tableJobs.getValueAt(index, 0));
			return aux;
		} else {
			throw new ErrorUnselectedJob();
		}
	}

	public void deleteAllRows() {
		while (modelJobs.getRowCount() > 0) {
			modelJobs.removeRow(0);
		}
	}

	public void reorderTableData(ArrayList<Job> jobsList) {
		deleteAllRows();
		for (int i = 0; i < jobsList.size(); i++) {
			Job job = jobsList.get(i);
			if (cmbCareer.getSelectedItem() == ConstantsGUI.T_ALL) {
				modelJobs.addRow(job.vectorStringToGraduated());
			} else if (job.getPrincipalCareer().getTipo().equals(cmbCareer.getSelectedItem())) {
				modelJobs.addRow(job.vectorStringToGraduated());
			}
		}
		this.repaint();
	}
}
