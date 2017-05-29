package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import constants.Constants;
import constants.ConstantsGUI;
import constants.ConstantsURL;
import entity.Enterprise;
import entity.Graduated;
import entity.Job;
import exceptions.ErrorInvalidPassword;
import exceptions.ErrorLoginFail;
import exceptions.ErrorMissingData;
import exceptions.ErrorOnlyNumbers;
import exceptions.ErrorUnselectedJob;
import logic.DAOEnterprises;
import logic.DAOGraduates;
import logic.DAOJobs;
import persistence.FileManagerEnterprises;
import persistence.FileManagerGraduates;
import persistence.FileManagerJobs;
import view.DialogAbout;
import view.DialogAddEnterprise;
import view.DialogAddGraduated;
import view.DialogAddJob;
import view.Login;
import view.WindowEnterprise;
import view.WindowGraduated;

public class Controller implements ActionListener {

	private DAOEnterprises daoEnterprises;
	private DAOGraduates daoGraduates;
	private DAOJobs daoJobs;
	private FileManagerEnterprises fileManagerEnterprises;
	private FileManagerGraduates fileManagerGraduates;
	private FileManagerJobs fileManagerJobs;
	private Login login;
	private WindowGraduated windowGraduated;
	private WindowEnterprise windowEnterprise;
	private DialogAddEnterprise dialogAddEnterprise;
	private DialogAddGraduated dialogAddGraduated;
	private DialogAddJob dialogAddJob;
	private DialogAbout dialogAbout;

	public Controller() {
		daoEnterprises = new DAOEnterprises();
		daoGraduates = new DAOGraduates();
		daoJobs = new DAOJobs();
		fileManagerEnterprises = new FileManagerEnterprises();
		fileManagerGraduates = new FileManagerGraduates();
		fileManagerJobs = new FileManagerJobs();
		dialogAddEnterprise = new DialogAddEnterprise(this);
		dialogAddGraduated = new DialogAddGraduated(this);
		dialogAbout = new DialogAbout();
		loadData();
		login = new Login(this);
		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case Constants.C_LOGIN_GRADUATED:
			loginGraduated();
			break;

		case Constants.C_LOGIN_ENTERPRISE:
			loginEnterprise();
			break;

		case Constants.C_REORDER_JOBS_WIN_GRD:
			windowGraduated.reorderTableData(daoJobs.getJobsList());
			break;

		case Constants.C_REORDER_JOBS_WIN_ENT:
			windowEnterprise.reorderTableData(daoJobs.getJobsList());
			break;

		case Constants.C_MORE_INFORMATION_GRD:
			moreInfoGraduatedWindow();
			break;

		case Constants.C_MORE_INFORMATION_ENT:
			moreInfoEnterpriseWindow();
			break;

		case Constants.C_DELETE_ACCOUNT_GRD:
			deleteAccountGraduate();
			break;

		case Constants.C_DELETE_ACCOUNT_ENT:
			deleteAccountEnterprise();
			break;

		case Constants.C_CLOSE_SESSION_GRD:
			windowGraduated.dispose();
			login.setVisible(true);
			break;

		case Constants.C_CLOSE_SESSION_ENT:
			windowEnterprise.dispose();
			login.setVisible(true);
			break;

		case Constants.C_DELETE_JOB:
			deleteJob();
			break;

		case Constants.C_CLOSE_APP:
			closeAplication();
			break;

		case Constants.C_REGISTER_ENTERPRISE:
			dialogAddEnterprise.setVisible(true);
			break;

		case Constants.C_CANCEL_ENTERPRISE:
			cancelRegisterEnterprise();
			break;

		case Constants.C_REGISTER_GRADUATED:
			dialogAddGraduated.setVisible(true);
			break;

		case Constants.C_CANCEL_GRADUATED:
			cancelRegisterGraduated();
			break;

		case Constants.C_ADD_JOB:
			showDialogToAddAJob();
			break;

		case Constants.C_ADD_JOB_CONFIRM:
			addJob();
			break;

		case Constants.C_CANCEL_JOB:
			dialogAddJob.dispose();
			break;

		case Constants.C_REGISTER_GRADUATED_CONFIRM:
			addGraduated();
			break;

		case Constants.C_REGISTER_ENTERPRISE_CONFIRM:
			addEnterprise();
			break;

		case Constants.C_ABOUT:
			dialogAbout.setVisible(true);
			break;

		default:
			break;
		}
	}

	public void addJob() {
		try {
			dialogAddJob.validateData();
			Job job = dialogAddJob.getJobToAdd();
			windowEnterprise.addRowToTable(job);
			daoJobs.addJob(job);
			fileManagerJobs.openJobsFile(2, ConstantsURL.URL_JOBS);
			for (int i = 0; i < daoJobs.sizeList(); i++) {
				fileManagerJobs.writeJob(daoJobs.getJobsList().get(i));
			}
			fileManagerJobs.closeWriteJobs();
			dialogAddJob.dispose();
		} catch (ErrorMissingData | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void addGraduated() {
		try {
			dialogAddGraduated.validateData();
			daoGraduates.addGraduated(dialogAddGraduated.getGraduatedToAdd());
			fileManagerGraduates.openGraduatedsFile(2, ConstantsURL.URL_GRADUATES);
			for (int i = 0; i < daoGraduates.sizeList(); i++) {
				fileManagerGraduates.writeGraduated(daoGraduates.getGraduatesList().get(i));
			}
			fileManagerGraduates.closeWriteGraduates();
			cancelRegisterGraduated();
		} catch (ErrorMissingData | IOException | ErrorOnlyNumbers e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void addEnterprise() {
		try {
			dialogAddEnterprise.validateData();
			daoEnterprises.addEnterprise(dialogAddEnterprise.getEnterpriseToAdd());
			fileManagerEnterprises.openEnterprisesFile(2, ConstantsURL.URL_ENTERPRISES);
			for (int i = 0; i < daoEnterprises.sizeList(); i++) {
				fileManagerEnterprises.writeEnterprise(daoEnterprises.getEnterprisesList().get(i));
			}
			fileManagerEnterprises.closeWriteEnterprises();
			cancelRegisterEnterprise();
		} catch (ErrorMissingData | IOException | ErrorOnlyNumbers e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void showDialogToAddAJob() {
		try {
			dialogAddJob = new DialogAddJob(this, (daoJobs.getJobByIndex(daoJobs.sizeList() - 1).getId()) + 1,
					windowEnterprise.getDataEnterprise());
			dialogAddJob.setVisible(true);
		} catch (ErrorLoginFail e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	public void cancelRegisterEnterprise() {
		dialogAddEnterprise.clearDialog();
		dialogAddEnterprise.setVisible(false);
	}

	public void cancelRegisterGraduated() {
		dialogAddGraduated.clearDialog();
		dialogAddGraduated.setVisible(false);
	}

	public void deleteJob() {
		try {
			String[] jobToDelete = windowEnterprise.getIdJobSelected();
			daoJobs.deleteJob(jobToDelete[0], jobToDelete[1]);
			fileManagerJobs.openJobsFile(2, ConstantsURL.URL_JOBS);
			for (int i = 0; i < daoJobs.getJobsList().size(); i++) {
				fileManagerJobs.writeJob(daoJobs.getJobsList().get(i));
			}
			fileManagerJobs.closeWriteJobs();
			windowEnterprise.reorderTableData(daoJobs.getJobsList());
		} catch (ErrorUnselectedJob | ErrorLoginFail | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void deleteAccountGraduate() {
		try {
			daoGraduates.deleteGraduated(windowGraduated.getUserId());
			windowGraduated.dispose();
			fileManagerGraduates.openGraduatedsFile(2, ConstantsURL.URL_GRADUATES);
			for (int i = 0; i < daoGraduates.getGraduatesList().size(); i++) {
				fileManagerGraduates.writeGraduated(daoGraduates.getGraduatesList().get(i));
			}
			fileManagerGraduates.closeWriteGraduates();
			login.setVisible(true);
		} catch (ErrorLoginFail | IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	public void deleteAccountEnterprise() {
		try {
			daoEnterprises.deleteEnterprise(windowEnterprise.getUserId());
			windowEnterprise.dispose();
			fileManagerEnterprises.openEnterprisesFile(2, ConstantsURL.URL_ENTERPRISES);
			for (int i = 0; i < daoEnterprises.getEnterprisesList().size(); i++) {
				fileManagerEnterprises.writeEnterprise(daoEnterprises.getEnterprisesList().get(i));
			}
			fileManagerEnterprises.closeWriteEnterprises();
			login.setVisible(true);
		} catch (ErrorLoginFail | IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	public void moreInfoGraduatedWindow() {
		try {
			String[] jobSelected = windowGraduated.getIdJobSelected();
			Job job = daoJobs.getJob(jobSelected[0], jobSelected[1]);
			JOptionPane.showMessageDialog(null, job.getRequirements());
		} catch (ErrorUnselectedJob | ErrorLoginFail e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void moreInfoEnterpriseWindow() {
		try {
			String[] jobSelected = windowEnterprise.getIdJobSelected();
			Job job = daoJobs.getJob(jobSelected[0], jobSelected[1]);
			JOptionPane.showMessageDialog(null, job.getRequirements());
		} catch (ErrorUnselectedJob | ErrorLoginFail e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void loginGraduated() {
		String[] grdDataLog = login.getGraduatedData();
		try {
			Graduated graduated = daoGraduates.getGraduated(grdDataLog[0]);
			if (graduated.getPassword().equals(grdDataLog[1])) {
				windowGraduated = new WindowGraduated(this, graduated);
				for (int i = 0; i < daoJobs.getJobsList().size(); i++) {
					windowGraduated.addRowToTable(daoJobs.getJobsList().get(i));
				}
				windowGraduated.setVisible(true);
				login.clearWindow();
				login.setVisible(false);
			} else {
				throw new ErrorInvalidPassword();
			}
		} catch (ErrorLoginFail | ErrorInvalidPassword e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void loginEnterprise() {
		String[] etpDataLog = login.getEnterpriseData();
		try {
			Enterprise enterprise = daoEnterprises.getEnterprise(etpDataLog[0]);
			if (enterprise.getPassword().equals(etpDataLog[1])) {
				windowEnterprise = new WindowEnterprise(this, enterprise);
				for (int i = 0; i < daoJobs.getJobsList().size(); i++) {
					if (daoJobs.getJobsList().get(i).getId_enterprise() == Long.valueOf(windowEnterprise.getUserId())) {
						windowEnterprise.addRowToTable(daoJobs.getJobsList().get(i));
					}
				}
				windowEnterprise.setVisible(true);
				login.clearWindow();
				login.setVisible(false);
			} else {
				throw new ErrorInvalidPassword();
			}
		} catch (ErrorLoginFail | ErrorInvalidPassword e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	public void loadData() {
		try {
			fileManagerEnterprises.openEnterprisesFile(1, ConstantsURL.URL_ENTERPRISES);
			Enterprise enterpriseAux = new Enterprise();
			enterpriseAux = fileManagerEnterprises.readEnterprise();
			while (enterpriseAux != null) {
				daoEnterprises.addEnterprise(enterpriseAux);
				enterpriseAux = fileManagerEnterprises.readEnterprise();
			}
			fileManagerEnterprises.closeReadEnterprises();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileManagerGraduates.openGraduatedsFile(1, ConstantsURL.URL_GRADUATES);
			Graduated graduatedAux = new Graduated();
			graduatedAux = fileManagerGraduates.readGraduated();
			while (graduatedAux != null) {
				daoGraduates.addGraduated(graduatedAux);
				graduatedAux = fileManagerGraduates.readGraduated();
			}
			fileManagerGraduates.closeReadGraduates();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileManagerJobs.openJobsFile(1, ConstantsURL.URL_JOBS);
			Job jobAux = new Job();
			jobAux = fileManagerJobs.readJob();
			while (jobAux != null) {
				daoJobs.addJob(jobAux);
				jobAux = fileManagerJobs.readJob();
			}
			fileManagerJobs.closeReadJobs();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeAplication() {
		int reply = JOptionPane.showConfirmDialog(null, ConstantsGUI.T_CONFIRMACION_SALIDA,
				ConstantsGUI.P_CONFIRMACION_SALIDA, JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
