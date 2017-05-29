package persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import entity.Career;
import entity.Job;

public class FileManagerJobs {

	private File file;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	public static final int READ = 1;
	public static final int WRITE = 2;

	public void openJobsFile(int aux, String fileNameAux) throws IOException {
		file = new File(fileNameAux);
		if (aux == READ) {
			fileInputStream = new FileInputStream(file);
			dataInputStream = new DataInputStream(fileInputStream);
		}
		if (aux == WRITE) {
			fileOutputStream = new FileOutputStream(file);
			dataOutputStream = new DataOutputStream(fileOutputStream);
		}
	}

	public Job readJob() throws EOFException, IOException {
		Job job = new Job();
		try {
			job.setId(dataInputStream.readInt());
			job.setName(dataInputStream.readUTF());
			job.setPrincipalCareer(Career.valueOf(dataInputStream.readUTF()));
			job.setRequirements(dataInputStream.readUTF());
			job.setId_enterprise(dataInputStream.readLong());
			job.setName_enterprise(dataInputStream.readUTF());
			job.setPhone_enterprise(dataInputStream.readUTF());
			return job;
		} catch (EOFException e) {
			return null;
		}
	}

	public void writeJob(Job job) throws IOException {
		dataOutputStream.writeInt(job.getId());
		dataOutputStream.writeUTF(job.getName());
		dataOutputStream.writeUTF(job.getPrincipalCareer().toString());
		dataOutputStream.writeUTF(job.getRequirements());
		dataOutputStream.writeLong(job.getId_enterprise());
		dataOutputStream.writeUTF(job.getName_enterprise());
		dataOutputStream.writeUTF(job.getPhone_enterprise());
	}

	public void closeReadJobs() throws IOException {
		if (dataInputStream != null) {
			dataInputStream.close();
		}
		if (fileInputStream != null) {
			fileInputStream.close();
		}
	}

	public void closeWriteJobs() throws IOException {
		if (dataOutputStream != null) {
			dataOutputStream.close();
		}
		if (fileOutputStream != null) {
			fileOutputStream.close();
		}
	}
}
