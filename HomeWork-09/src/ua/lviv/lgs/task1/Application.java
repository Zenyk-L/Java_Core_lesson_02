/*
 * LOGOS It Academy
 **/
package ua.lviv.lgs.task1;

/**
 *@version 1.2 09.09.2020
 *@author Zinovij Livchanyn 
 */

import java.io.IOException;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws WrongInputConsoleParametersException {

		Month[] mas = Month.values();
		Seasons[] se = Seasons.values();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Enter month:");
			String mInputed = sc.next().toUpperCase();

			Month eMonth = monthExist(mas, mInputed);

			menu();

			if (eMonth != null) {
				mInputed = sc.next();
				while (!(mInputed.equals("0"))) {
					int ordinal = eMonth.season.ordinal();
					switch (mInputed) {

					case "1": {

						for (Month m : mas) {
							if (m.season.equals(eMonth.season)) {
								System.out.println("In season: " + m.season + " are month: " + m.name());
							}
						}
						menu();
						break;
					}
					case "2": {

						for (Month m : mas) {
							if (!(m.name().equals(eMonth.name())) && (m.day == eMonth.day)) {
								System.out.println("The same number of " + m.day + " days have month: " + m.name());
							}
						}
						menu();
						break;
					}

					case "3": {
						for (Month m : mas) {
							if (m.day < eMonth.day) {
								System.out.println("Have less days " + m.name());
							}
						}

						menu();
						break;
					}

					case "4": {
						for (Month m : mas) {
							if (m.day > eMonth.day) {
								System.out.println("Have more days " + m.name());
							}
						}

						menu();
						break;
					}

					case "5": {

						if (ordinal < 3) {
							System.out.println(se[eMonth.season.ordinal() + 1]);
						} else {
							System.out.println(se[0]);
						}

						menu();
						break;
					}

					case "6": {
						if (ordinal > 0) {
							System.out.println(se[eMonth.season.ordinal() - 1]);
						} else {
							System.out.println(se[3]);
						}
						menu();
						break;
					}

					case "7": {
						for (Month m : mas) {
							if (m.day % 2 == 0) {
								System.out.println("̳���� " + m.name() + " �� ����� ������� ����");
							}
						}

						menu();
						break;
					}

					case "8": {
						for (Month m : mas) {
							if (m.day % 2 == 1) {
								System.out.println("̳���� " + m.name() + " �� �� ����� ������� ����");
							}
						}

						menu();
						break;
					}

					case "9": {
						if (eMonth.day % 2 == 0) {
							System.out.println("̳���� " + eMonth.name() + " �� ����� ������� ����");
						} else {
							System.out.println("̳���� " + eMonth.name() + " �� �� ����� ������� ����");						
						}
						menu();
						break;
					}

					default: {
						System.out.println("������ ������ ���� �� ����!!!");
						break;
					}
					}
					mInputed = sc.next();

				}

			}

		}

	}
	
	/**
	 * @param array, String
	 * @author Zinovij Livchanyn
	 * @return enum value 
	 * @see java code convention
	 * */
	private static Month monthExist(Month[] mas, String mInputed) throws WrongInputConsoleParametersException {
		boolean flag = false;
		Month m1 = null;
		for (Month m : mas) {
			if (m.name().equals(mInputed)) {
				System.out.println("Entered month exist: " + m.name() + " day = " + m.day + " season: " + m.season);

				flag = true;
				m1 = m;
			}
		}
		if (!flag) {
//			System.out.println("Entered month dosnt exist.");
			throw new WrongInputConsoleParametersException();
		}
		return m1;
	}

	/**
	 * @param no input params
	 * @author Zinovij Livchanyn
	 * @return print on screen 
	 * @see java code convention
	 * */
	static void menu() {
		System.out.println("===============================================================================");
		System.out.println("��������� 1, ��� ������� �� ����� � ����� � ����� ����");
		System.out.println("��������� 2, ��� ������� �� ����� �� ����� ���� ���� ������� ����");
		System.out.println("��������� 3, ��� ������� �� ����� �� ����� �� ����� ����� ������� ����");
		System.out.println("��������� 4, ��� ������� �� ����� �� ����� �� ����� ����� ������� ����");
		System.out.println("��������� 5, ��� ������� �� ����� �������� ���� ����");
		System.out.println("��������� 6, ��� ������� �� ����� ��������� ���� ����");
		System.out.println("��������� 7, ��� ������� �� ����� �� ����� �� ����� ����� ������� ����");
		System.out.println("��������� 8, ��� ������� �� ����� �� ����� �� ����� ������� ������� ����");
		System.out.println("��������� 9, ��� ������� �� ����� �� �������� � ������ ����� �� ����� ������� ����");
		System.out.println("��������� 0, ������ ����� �����");
	}

}
