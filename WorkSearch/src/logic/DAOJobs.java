package logic;

import java.util.ArrayList;
import entity.Job;
import exceptions.ErrorLoginFail;

public class DAOJobs {

	private ArrayList<Job> jobsList;

	public DAOJobs() {
		jobsList = new ArrayList<>();
	}

	public ArrayList<Job> getJobsList() {
		return jobsList;
	}

	public void addJob(Job job) {
		jobsList.add(job);
	}

	public void deleteJob(String id, String id_enterprise) throws ErrorLoginFail {
		jobsList.remove(searchJob(id, id_enterprise));
	}

	public int searchJob(String id, String id_enterprise) throws ErrorLoginFail {
		for (Job job : jobsList) {
			try {
				if (job.getId() == Long.valueOf(id) && job.getId_enterprise() == Long.valueOf(id_enterprise)) {
					return jobsList.indexOf(job);
				}
			} catch (Exception e) {
				throw new ErrorLoginFail();
			}
		}
		throw new ErrorLoginFail();
	}

	public Job getJob(String id, String id_enterprise) throws ErrorLoginFail {
		for (Job job : jobsList) {
			try {
				if (job.getId() == Long.valueOf(id) && job.getId_enterprise() == Long.valueOf(id_enterprise)) {
					return job;
				}
			} catch (Exception e) {
				throw new ErrorLoginFail();
			}
		}
		throw new ErrorLoginFail();
	}

	public Job getJobByIndex(int pos) throws ErrorLoginFail {
		if (jobsList.get(pos) != null) {
			return jobsList.get(pos);
		} else {
			throw new ErrorLoginFail();
		}
	}

	public int sizeList() {
		return jobsList.size();
	}
}
