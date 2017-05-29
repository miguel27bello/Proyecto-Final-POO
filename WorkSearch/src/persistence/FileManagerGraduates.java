package persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import entity.Career;
import entity.Graduated;

public class FileManagerGraduates {

	private File file;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	public static final int READ = 1;
	public static final int WRITE = 2;

	public void openGraduatedsFile(int aux, String fileNameAux) throws IOException {
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

	public Graduated readGraduated() throws EOFException, IOException {
		Graduated graduated = new Graduated();
		try {
			graduated.setId(dataInputStream.readLong());
			graduated.setName(dataInputStream.readUTF());
			graduated.setLastName(dataInputStream.readUTF());
			graduated.setCareer(Career.valueOf(dataInputStream.readUTF()));
			graduated.setAddress(dataInputStream.readUTF());
			graduated.setPhone(dataInputStream.readUTF());
			graduated.setPassword(dataInputStream.readUTF());
			return graduated;
		} catch (EOFException e) {
			return null;
		}
	}

	public void writeGraduated(Graduated graduated) throws IOException {
		dataOutputStream.writeLong(graduated.getId());
		dataOutputStream.writeUTF(graduated.getName());
		dataOutputStream.writeUTF(graduated.getLastName());
		dataOutputStream.writeUTF(graduated.getCareer().toString());
		dataOutputStream.writeUTF(graduated.getAddress());
		dataOutputStream.writeUTF(graduated.getPhone());
		dataOutputStream.writeUTF(graduated.getPassword());
	}

	public void closeReadGraduates() throws IOException {
		if (dataInputStream != null) {
			dataInputStream.close();
		}
		if (fileInputStream != null) {
			fileInputStream.close();
		}
	}

	public void closeWriteGraduates() throws IOException {
		if (dataOutputStream != null) {
			dataOutputStream.close();
		}
		if (fileOutputStream != null) {
			fileOutputStream.close();
		}
	}
}
