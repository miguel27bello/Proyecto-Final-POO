package logic;

import java.util.ArrayList;
import entity.Graduated;
import exceptions.ErrorLoginFail;

public class DAOGraduates {

	private ArrayList<Graduated> graduatesList;

	public DAOGraduates() {
		graduatesList = new ArrayList<>();
	}

	public ArrayList<Graduated> getGraduatesList() {
		return graduatesList;
	}

	public void addGraduated(Graduated graduated) {
		graduatesList.add(graduated);
	}

	public void deleteGraduated(String id) throws ErrorLoginFail {
		graduatesList.remove(searchGraduated(id));
	}

	public int searchGraduated(String id) throws ErrorLoginFail {
		for (Graduated graduated : graduatesList) {
			try {
				if (graduated.getId() == Long.valueOf(id)) {
					return graduatesList.indexOf(graduated);
				}
			} catch (Exception e) {
				throw new ErrorLoginFail();
			}
		}
		throw new ErrorLoginFail();
	}

	public Graduated getGraduated(String id) throws ErrorLoginFail {
		for (Graduated graduated : graduatesList) {
			try {
				if (graduated.getId() == Long.valueOf(id)) {
					return graduated;
				}
			} catch (Exception e) {
				throw new ErrorLoginFail();
			}
		}
		throw new ErrorLoginFail();
	}

	public int sizeList() {
		return graduatesList.size();
	}
}
