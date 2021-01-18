package SinhVien;

import java.util.Scanner;

public class DSSinhVien {
	SinhVien firstLink;

	public DSSinhVien() {
		// TODO Auto-generated constructor stub
		firstLink = null;
	}

	public boolean isEmpty() {

		return (firstLink == null);

	}

	public void insertFirstLink(String maSV, String hoTen, int namSinh, Boolean gioiTinh, String maLop) {
		SinhVien newLink = new SinhVien(maSV, hoTen, namSinh, gioiTinh, maLop);

		// Connects the firstLink field to the new Link

		newLink.pNext = firstLink;

		firstLink = newLink;

	}

	public void display() {

		SinhVien theLink = firstLink;

		// Start at the reference stored in firstLink and

		// keep getting the references stored in next for

		// every Link until next returns null

		while (theLink != null) {

			theLink.display(theLink.gioiTinh);
//			System.out.println("Next Link: " + theLink.pNext);
			theLink = theLink.pNext;

			System.out.println();

		}

	}

	public void input() {
		String maSV;
		String hoTen;
		int namSinh;
		Boolean gioiTinh;
		String maLop;

		Scanner sr = new Scanner(System.in);
		boolean flag = true;
		while (flag == true) {

			do {
				System.out.println("Nhập mã Sinh viên: ");
				maSV = sr.nextLine();
				if (maSV.length() <= 0 || maSV.length() > 20)
					System.out.println("Mã Sinh viên không được để trống và tối đa 20 ký tự!");
				else
					break;
			} while (true);

			do {
				System.out.println("Nhập Họ tên: ");
				hoTen = sr.nextLine();
				if (hoTen.length() <= 0 || hoTen.length() > 500)
					System.out.println("Họ tên Sinh viên không được để trống và dài tối đa 500 ký tự");
				else
					break;
			} while (true);

			sr = new Scanner(System.in);

			do {
				String sNamSinh;
				try {
					System.out.println("Nhập năm sinh: ");
					sNamSinh = sr.nextLine();
					if (Integer.parseInt(sNamSinh) <= 0 || (2020 - Integer.parseInt(sNamSinh)) < 15)
						System.out.println(
								"Năm sinh không hợp lệ! Vui lòng nhập lại( Lưu ý: Sinh viên học vượt ít nhất là 15 tuổi)");
					else if (sNamSinh.length() == 0) {
						System.out.println("Năm sinh không được để trống");
					} else {
						namSinh = Integer.parseInt(sNamSinh);
						break;
					}
				} catch (Exception e) {
					System.out.println(
							"Năm sinh không được để trống, lớn hơn không và không có ký tự chữ cái( Lưu ý: Sinh viên học vượt ít nhất là 15 tuổi)! ");
				}
			} while (true);

			sr = new Scanner(System.in);

			do {
				try {
					System.out.println("Nhập vào giới tính của Sinh viên: "); // Nam chon True/Nu chon False??
					String sGioiTinh = sr.nextLine();

					if (sGioiTinh.length() == 0) {
						System.out.println("Giới tính không được để trống");
					} else {
						if (sGioiTinh.equals("Nam")) {
							gioiTinh = true;

						} else if (sGioiTinh.equals("Nu") || sGioiTinh.equals("Nữ")) {
							gioiTinh = false;

						} else {
							System.out.println("Giới tính không hợp lệ. Vui lòng nhập lại!");
							continue;
						}
						break;
					}
				} catch (Exception e) {
					System.out.println("Giới tính không được để trống!");
					System.out.println("Vui lòng nhập lại");
				}
			} while (true);

			sr = new Scanner(System.in);

			do {
				sr = new Scanner(System.in);
				System.out.println("Nhập mã Lớp của Sinh viên: ");
				maLop = sr.nextLine();
				if (maLop.length() == 0 || maLop.length() > 20) {
					System.out.println("Mã lớp không được để trống và chứa tối đa 20 ký tự!");
				} else
					break;
			} while (true);
			insertFirstLink(maSV, hoTen, namSinh, gioiTinh, maLop);// lúc nhập ở đây nó chỉ nhận 1 giá trì này
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
