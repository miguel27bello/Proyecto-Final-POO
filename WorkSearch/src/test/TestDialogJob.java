package test;

import view.DialogAddJob;

public class TestDialogJob {

	public static void main(String[] args) {
		String[] enterprise = { "12344", "Subway", "7454017" };
		DialogAddJob addJob = new DialogAddJob(null, 1, enterprise);
		addJob.setVisible(true);
	}
}
