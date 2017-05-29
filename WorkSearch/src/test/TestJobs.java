package test;

import java.io.IOException;

import entity.Career;
import entity.Job;
import persistence.FileManagerJobs;

public class TestJobs {

	public static void main(String[] args) throws IOException {

		FileManagerJobs jobs = new FileManagerJobs();

		jobs.openJobsFile(2, "registers/jobs.byn");
		jobs.writeJob(new Job(1, "Camarero", "", "Subway", Career.ADMINISTRACION, 12344, "6456806"));
		jobs.writeJob(new Job(2, "Aseador", "", "Subway", Career.ADMINISTRACION, 12344, "6456806"));
		jobs.writeJob(new Job(3, "Cocinero", "", "Subway", Career.ADMINISTRACION, 12344, "6456806"));
		jobs.writeJob(new Job(3, "Cajero", "", "Banco Corpbanca", Career.ADMINISTRACION, 12343, "6456807"));
		jobs.closeWriteJobs();

		Job job = new Job();

		jobs.openJobsFile(1, "registers/jobs.byn");
		job = jobs.readJob();
		while (job != null) {
			System.out.println(job.getId());
			System.out.println(job.getName());
			System.out.println(job.getPrincipalCareer());
			System.out.println(job.getRequirements());
			System.out.println(job.getId_enterprise());
			System.out.println(job.getName_enterprise());
			System.out.println(job.getPhone_enterprise());
			System.out.println();
			job = jobs.readJob();
		}
		jobs.closeReadJobs();
	}
}