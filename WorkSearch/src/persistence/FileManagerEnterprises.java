package persistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import entity.Enterprise;

public class FileManagerEnterprises {

	private File file;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	public static final int READ = 1;
	public static final int WRITE = 2;

	public void openEnterprisesFile(int aux, String fileNameAux) throws IOException {
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

	public Enterprise readEnterprise() throws EOFException, IOException {
		Enterprise enterprise = new Enterprise();
		try {
			enterprise.setNit(dataInputStream.readLong());
			enterprise.setName(dataInputStream.readUTF());
			enterprise.setPhone(dataInputStream.readUTF());
			enterprise.setPassword(dataInputStream.readUTF());
			return enterprise;
		} catch (EOFException e) {
			return null;
		}
	}

	public void writeEnterprise(Enterprise enterprise) throws IOException {
		dataOutputStream.writeLong(enterprise.getNit());
		dataOutputStream.writeUTF(enterprise.getName());
		dataOutputStream.writeUTF(enterprise.getPhone());
		dataOutputStream.writeUTF(enterprise.getPassword());
	}

	public void closeReadEnterprises() throws IOException {
		if (dataInputStream != null) {
			dataInputStream.close();
		}
		if (fileInputStream != null) {
			fileInputStream.close();
		}
	}

	public void closeWriteEnterprises() throws IOException {
		if (dataOutputStream != null) {
			dataOutputStream.close();
		}
		if (fileOutputStream != null) {
			fileOutputStream.close();
		}
	}
}
