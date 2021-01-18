package LopHoc;

import java.util.Scanner;

public class DSLopHoc {
	LopHoc firstLink;

	public DSLopHoc() {
		// TODO Auto-generated constructor stub
		firstLink = null;
	}

	public boolean isEmpty() {

		return (firstLink == null);

	}

	public void insertFirstLink(String maLop, int maKhoa, int stt, int nienKhoa) {
		LopHoc newLink = new LopHoc(maLop, maKhoa, stt, nienKhoa);

		// Connects the firstLink field to the new Link

		newLink.pNext = firstLink;

		firstLink = newLink;

	}

	public void display() {

		LopHoc theLink = firstLink;

		// Start at the reference stored in firstLink and

		// keep getting the references stored in next for

		// every Link until next returns null

		while (theLink != null) {

			theLink.display();
			System.out.println("Next Link: " + theLink.pNext);

			theLink = theLink.pNext;

			System.out.println();

		}

	}

	public void input() {
		String maLop;
		int maKhoa;
		int stt;
		int nienKhoa;

		Scanner sr = new Scanner(System.in);
		boolean flag = true;
		while (flag == true) {
			do {
				System.out.println("Nhập mã Lớp học: ");
				maLop = sr.nextLine();

				if (maLop.length() <= 0 || maLop.length() > 20) {
					System.out.println("Mã lớp học không được để trống và chứa tối đa 20 ký tự");
				} else
					break;
			} while (true);
			sr = new Scanner(System.in);

			do {
				String smaKhoa;
				try {
					System.out.println("Nhập mã khóa: ");
					smaKhoa = sr.nextLine();
					// String smaKhoa = String.valueOf(maKhoa);

					if (smaKhoa.length() <= 0 || smaKhoa.length() > 9) {
						System.out.println("Mã khóa không được để trống và tối đa 9 ký tự!");
					} else {
						maKhoa = Integer.parseInt(smaKhoa);
						break;
					}
				} catch (Exception e) {
					System.out.println("Mã khoa không thể chứ bất kỳ ký tự chữ cái nào");
					System.out.println("Mời nhập lại");
				}
			} while (true);

			do {
				String sstt;
				try {
					System.out.println("Nhập số thứ tự: ");
					sstt = sr.nextLine();

					if (sstt.length() <= 0) {
						System.out.println("Số thứ tự không được để trống!");
					} else if (Integer.parseInt(sstt) <= 0) {
						System.out.println("Số thứ tự không thể bé hơn không!");
					} else {
						stt = Integer.parseInt(sstt);
						break;
					}
				} catch (Exception e) {
					System.out.println("Số thứ tự không thể chứa ký tự là chữ cái. ");
					System.out.println("Mời nhập lại!");
				}
			} while (true);

			do {
				String snienKhoa;
				try {
					System.out.println("Nhập niên khóa: ");
					snienKhoa = sr.nextLine();

					if (snienKhoa.length() == 0) {
						System.out.println("Niên khóa không được để trống");
					} else if (Integer.parseInt(snienKhoa) <= 0) {
						System.out.println("Niên khóa phải lớn hơn không");
					} else {
						nienKhoa = Integer.parseInt(snienKhoa);
						break;
					}
				} catch (Exception e) {
					System.out.println("Niên khóa không thể chứa ký tự là chữ cái!");
					System.out.println("Mời nhập lại!");
				}
			} while (true);
			insertFirstLink(maLop, maKhoa, stt, nienKhoa);
			System.out.println("Bạn có muốn nhập tiếp? (Y/N): ");
			String choose = sr.nextLine();
			if (choose.equals("Y")) {
				flag = true;
			} else {
				flag = false;
			}
		}

	}
}
