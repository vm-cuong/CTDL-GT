package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import DSChuongTrinh.DSChuongTrinh;
import DSKetQua.DSKetQua;
import Khoa.DSKhoa;
import KhoaHoc.DSKhoaHoc;
import LopHoc.DSLopHoc;
import MonHoc.DSMonHoc;
import SinhVien.DSSinhVien;

public class MENU {

	static Scanner sc = new Scanner(System.in);
	static DSKhoa theTree = new DSKhoa();

	public static void main(String[] args) throws IOException {

		menuChinh();

	}

	public static void menuChinh() throws IOException {
		int i;
		do {
			System.out.println("=======ĐỒ ÁN MÔN CTDL & GT: ========");
			System.out.println("(1) Nhập các thông tin và có kiểm tra các ràng buộc\n" + "(2) Xuất các thông tin\n"
					+ "(3) Tìm kiếm theo mã, theo tên của các thông tin\n" + "(4) Chèn và xoá các thông tin\n"
					+ "(5) Cập nhật thông tin\n" + "(6) Sắp xếp theo thứ tự theo mã số\n"
					+ "(7) Thống kê số lượng sinh viên theo từng lớp, từng khoa, từng học kỳ hoặc từng năm học\n"
					+ "(8) Cho biết số lượng môn học có nhiều sinh viên học nhất trong từng năm học\n"
					+ "(9) Danh sách những sinh viên thi lần II theo từng môn học, từng khoa, từng học kỳ, từng năm học\n"
					+ "(10) Ghi file Khoa\n" + "(11) Đọc file Khoa\n" + "(12) Ghi file Chương Trình\n"
					+ "(13) Đọc file Chương Trình\n" + "(14) Thoát chương trình\n");
			System.out.print("Chọn: ");
			i = sc.nextInt();
			sc.nextLine();
			switch (i) {
			case 1:
				System.out.println("=======(1) Nhập dữ liệu========");
				nhapdulieu();
				break;
			case 2:
				System.out.println("======(2) Xuất dữ liệu=======");
				xuatdulieu();
				break;
			case 3:
				System.out.println("======(3) Tìm kiếm=======");
				timkiem();
				break;
			case 4:
				System.out.println("======(4) Chèn và xoá======");
				chenvaxoa();
				break;
			case 5:
				System.out.println("======(5) Cập nhật======");
				capnhat();
				break;
			case 6:
				System.out.println("======(6) Sắp xếp======");
				sapxep();
				break;
			case 7:
				System.out.println("======(7) Thống kê======");
				thongke();
				break;
			case 8:
				System.out.println("======(8) Lớp có nhiều sinh viên nhất======");
				break;
			case 9:
				System.out.println("======(9) Danh sách sinh viên thi lại lần 2======");
				break;
			case 10:
				System.out.println("======(11) Ghi file Khoa======");
				GhifileKH();
				break;
			case 11:
				System.out.println("======(11) Đọc file Khoa======");
				docfileKH();
				break;
			case 12:
				System.out.println("======(12) Ghi file Chương Trình======");
				ghifileCT();
				break;
			case 13:
				System.out.println("======(13) Đọc file Chương Trình======");
				docfileCT();
				break;
			case 14:
				System.out.println("======ĐÃ THOÁT CHƯƠNG TRÌNH======");
				System.exit(0);
				break;
			default:
				System.out.println("==========================================");
				System.out.println("===lựa chọn không có vui lòng chọn lại====");
				System.out.println("==========================================");
				break;
			}
		} while (true);
	}

	static void chenvaxoa() throws IOException {
		// TODO Auto-generated method stub
		int j;
		while (true) {
			System.out.println("(1) Khoa\n" + "(2) Khoá học\n" + "(3) Sinh Viên\n" + "(4) Chương trình\n"
					+ "(5) Môn học\n" + "(6) Kết quả\n" + "(7) Lớp học\n" + "(8) Về menu chính\n");
			System.out.print("Chọn: ");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				System.out.println("======(1) Xóa dữ liệu khoa========");
				xoaKH();
				break;
			case 2:
				System.out.println("======(2) Xóa dữ liệu khoá học=======");
				break;
			case 3:
				System.out.println("======(3) Xóa dữ liệu sinh viên=======");
				break;
			case 4:
				System.out.println("======(4) Xóa dữ liệu chương trình học======");
				Xoa();
				break;
			case 5:
				System.out.println("======(5) Xóa dữ liệu môn học======");
				break;
			case 6:
				System.out.println("======(6) Xóa dữ liệu kết quả======");
				break;
			case 7:
				System.out.println("======(7) Xóa dữ liệu lớp học======");
				break;
			case 8:
				System.out.println("======(8) Về menu chính======");
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}
		}
	}

	static void xoaKH() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Nhập mã cần xóa: ");
		int maKhoa = sc.nextInt();
		if (theTree.findByID(maKhoa) == null) {
			System.out.println("Mã khoa không tồn tại!");
		} else {
			theTree.delete(maKhoa);
			System.out.println("Xóa thành công!");
		}
		theTree.preorderTraverseTree(theTree.getRoot());

	}

	static void nhapdulieu() throws IOException {
		int j;
		while (true) {
			System.out.println("(1) Khoa\n" + "(2) Khoá học\n" + "(3) Sinh Viên\n" + "(4) Chương trình\n"
					+ "(5) Môn học\n" + "(6) Kết quả\n" + "(7) Lớp học\n" + "(8) Về menu chính\n");
			System.out.print("Chọn: ");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				System.out.println("======(1) Nhập dữ liệu khoa========");
				nhapKH();
				break;
			case 2:
				System.out.println("======(2) Nhập dữ liệu khoá học=======");
				dskh.input();
				break;
			case 3:
				System.out.println("======(3) Nhập dữ liệu sinh viên=======");
				nhapSV();
				break;
			case 4:
				System.out.println("======(4) Nhập dữ liệu chương trình học======");
				nhapCT();
				break;
			case 5:
				System.out.println("======(5) Nhập dữ liệu môn học======");
				nhapMH();
				break;
			case 6:
				System.out.println("======(6) Nhập dữ liệu kết quả======");
				nhapKQ();
				break;
			case 7:
				System.out.println("======(7) Nhập dữ liệu lớp học======");
				nhapLH();
				break;
			case 8:
				System.out.println("======(8) Về menu chính======");
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}
		}
	}

	static void xuatdulieu() throws IOException {
		int j;

		while (true) {
			System.out.println("(1) Khoa\n" + "(2) Khoá học\n" + "(3) Sinh Viên\n" + "(4) Chương trình\n"
					+ "(5) Môn học\n" + "(6) Kết quả\n" + "(7) Lớp học\n" + "(8) Về menu chính\n");
			System.out.print("Chọn: ");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				System.out.println("=======(1) Xuất dữ liệu khoa========");
				xuatKhoa();
				break;
			case 2:
				System.out.println("=====(2) Xuất dữ liệu khoá học=======");
				xuatKH();
				break;
			case 3:
				System.out.println("======(3) Xuất dữ liệu sinh viên=======");
				xuatSV();
				break;
			case 4:
				System.out.println("======(4) Xuất dữ liệu chương trình học======");
				xuatCT();
				break;
			case 5:
				System.out.println("======(5) Xuất dữ liệu môn học======");
				xuatMH();
				break;
			case 6:
				System.out.println("======(6) Xuất dữ liệu kết quả======");
				xuatKQ();
				break;
			case 7:
				System.out.println("======(7) Xuất dữ liệu lớp học======");
				xuatLH();
				break;
			case 8:
				System.out.println("======(8) Về menu chính======");
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}
		}
	}

	static void xuatKhoa() {
		// TODO Auto-generated method stub
		theTree.preorderTraverseTree(theTree.getRoot());
	}

	static void timkiem() throws IOException {
		int j;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("(1) Khoa\n" + "(2) Khoá học\n" + "(3) Sinh Viên\n" + "(4) Chương trình\n"
					+ "(5) Môn học\n" + "(6) Lớp học\n" + "(7) Về menu chính\n");
			System.out.print("Chọn: ");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				System.out.println("=======(1) Tìm khoa========");
				timKH();
				break;
			case 2:
				System.out.println("=====(2) Tìm khoá học=======");
				break;
			case 3:
				System.out.println("======(3) Tìm sinh viên=======");
				break;
			case 4:
				System.out.println("======(4) Tìm chương trình học======");
				tim();
				break;
			case 5:
				System.out.println("======(5) Tìm môn học======");
				break;
			case 6:
				System.out.println("======(6) Tìm lớp học======");
				break;
			case 7:
				System.out.println("======(7) Về menu chính======");
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}
		}
	}

	static void timKH() {
		// TODO Auto-generated method stub
		theTree.inOrderTraverseTree(theTree.getRoot());
		System.out.println("Nhập mã cần tìm: ");
		int makhoa = sc.nextInt();
		sc.nextLine();
		theTree.findByID(makhoa);

	}

	static void tim() throws IOException {
		// TODO Auto-generated method stub

		int j;
		while (true) {
			System.out.println("===(1) Tìm theo ID===");
			System.out.println("===(2) Tìm theo Name===");
			System.out.println("===(3) Về menu chính===");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				timIDCT();
				break;
			case 2:
				timNameCT();
				break;
			case 3:
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}

		}
	}

	static void capnhat() throws IOException {
		int j;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("(1) Khoa\n" + "(2) Khoá học\n" + "(3) Sinh Viên\n" + "(4) Chương trình\n"
					+ "(5) Môn học\n" + "(6) Kết quả\n" + "(7) Lớp học\n" + "(8) Về menu chính\n");
			System.out.print("Chọn: ");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				System.out.println("=======(1) Cập nhật khoa========");
				updateKH();
				break;
			case 2:
				System.out.println("=====(2) Cập nhật khoá học=======");
				break;
			case 3:
				System.out.println("======(3) Cập nhật sinh viên=======");
				break;
			case 4:
				System.out.println("======(4) Cập nhật chương trình học======");
				updateCT();
				break;
			case 5:
				System.out.println("======(5) Cập nhật liệu môn học======");
				break;
			case 6:
				System.out.println("======(6) Cập nhật kết quả======");
				break;
			case 7:
				System.out.println("======(7) Cập nhật lớp học======");
				break;
			case 8:
				System.out.println("======(8) Về menu chính======");
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}
		}
	}

	static void updateKH() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Nhập mã cần cập nhật: ");
		int makh = sc.nextInt();
		System.out.println();
		if (theTree.findByID1(makh) == null) {
			System.out.println("Mã chương khoa không tồn tại!");
		} else {
			System.out.println("Mã chương khoa có tồn tại!");
			int j;
			String tenctr1;
			while (true) {
				System.out.println("thông tin muốn sửa?");
				System.out.println("===(1) Sửa Thông Tin===");
				System.out.println("===(2) Về menu chính===");
				j = sc.nextInt();
				sc.nextLine();
				switch (j) {
				case 1:
					System.out.println("Nhập ID muốn sửa: ");
					makh = sc.nextInt();
					sc.nextLine();
					System.out.println("Nhập Tên muốn sửa: ");
					tenctr1 = sc.nextLine();
					System.out.println("Nhập Năm muốn sửa: ");
					int nam = sc.nextInt();
					sc.nextLine();
					theTree.delete(makh);
					theTree.add(makh, tenctr1, nam);
					break;
				case 2:
					capnhat();
					break;
				default:
					break;
				}

			}
		}
	}

	static void updateCT() throws IOException {
		// TODO Auto-generated method stub
		String mactr;
		System.out.println("Nhập mã chương trình cần update: ");
		mactr = sc.nextLine();
		String tenctr1;
		if (linkedlist.findByID(mactr) == null) {
			System.out.println("Mã chương trình không tồn tại!");
		} else {
			int j;
			System.out.println("Mã chương trình có tồn tại!");
			while (true) {
				System.out.println("thông tin muốn sửa?");
				System.out.println("===(1) Sửa ID===");
				System.out.println("===(2) Sửa Name===");
				System.out.println("===(3) Về menu chính===");
				j = sc.nextInt();
				sc.nextLine();
				switch (j) {
				case 1:
					tenctr1 = linkedlist.findByIDGetName(mactr);
					SuaID(mactr, tenctr1);
					break;
				case 2:
					System.out.println("Nhập tên muốn sửa: ");
					tenctr1 = sc.nextLine();
					SuaName(mactr, tenctr1);
					break;
				case 3:
					capnhat();
					break;
				default:
					break;
				}

			}
		}
	}

	static void sapxep() throws IOException {
		int j;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Sắp xếp theo thứ tự mã tăng dần\n" + "(1) Khoa\n" + "(2) Khoá học\n" + "(3) Sinh Viên\n"
					+ "(4) Chương trình\n" + "(5) Môn học\n" + "(6) Lớp học\n" + "(7) Về menu chính\n");
			System.out.print("Chọn: ");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				System.out.println("=======(1) Đã sắp xếp khoa========");
				sapxepKH();
				break;
			case 2:
				System.out.println("======(2) Đã sắp xếp khoá học=======");
				break;
			case 3:
				System.out.println("======(3) Đã sắp xếp sinh viên=======");
				break;
			case 4:
				System.out.println("======(4) Đã sắp xếp chương trình học======");
				sapxepCT();
				break;
			case 5:
				System.out.println("======(5) Đã sắp xếp môn học======");
				break;
			case 6:
				System.out.println("======(6) Đã sắp xếp lớp học======");
				break;
			case 7:
				System.out.println("======(7) Về menu chính======");
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}
		}
	}

	static void sapxepCT() {
		// TODO Auto-generated method stub
		linkedlist.insertionSort(linkedlist.getFirstLink());
		linkedlist.display();
	}

	static void sapxepKH() {
		theTree.inOrderTraverseTree(theTree.getRoot());
	}

	static void thongke() throws IOException {
		int j;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Thống kê toàn bộ sinh viên danh sách\n" + "(1) Lớp học\n" + "(2) Khoa\n"
					+ "(3)Môn học\n" + "(4) Về menu chính\n");
			System.out.print("Chọn: ");
			j = sc.nextInt();
			sc.nextLine();
			switch (j) {
			case 1:
				System.out.println("======(1) Theo lớp========");
				break;
			case 2:
				System.out.println("======(2) Theo khoa=======");
				break;
			case 3:
				System.out.println("======(3) Theo môn=======");
				break;
			case 4:
				System.out.println("======(4) Về menu chính======");
				menuChinh();
				break;
			default:
				System.out.println("lựa chọn không có vui lòng chọn lại");
				break;
			}
		}
	}

	//
	static DSKetQua dskq = new DSKetQua();

	static void nhapKQ() {
		dskq.input();
	}

	static void xuatKQ() {
		dskq.display();
	}

	static DSSinhVien dssv = new DSSinhVien();

	static void nhapSV() {
		dssv.input();
	}

	static void xuatSV() {
		dssv.display();
	}

	static DSKhoaHoc dskh = new DSKhoaHoc();

	static void xuatKH() {
		dskh.preorderTraverseTree(dskh.getRoot());
	}

	static DSLopHoc dslh = new DSLopHoc();

	static void nhapLH() {
		dslh.input();
	}

	static void xuatLH() {
		dslh.display();
	}

	static DSMonHoc dsmh = new DSMonHoc();

	static void nhapMH() {
		dsmh.input();
	}

	static void xuatMH() {
		dsmh.preorderTraverseTree(dsmh.getRoot());
	}

	static DSChuongTrinh linkedlist = new DSChuongTrinh();

	public static void nhapCT() throws IOException {
		boolean flag = true;
		String mactr, tenctr;
		ArrayList<Byte> st = new ArrayList<Byte>();
		while (flag == true) {
			while (true) {

				System.out.println("Nhap Ma Chuong trinh: ");
				mactr = sc.nextLine();
				if (mactr.length() == 0 || mactr.length() > 20) {
					System.out.println("Ma Chuong trinh khong duoc de trong va khong duoc qua 20 ky tu");
				} else {
					if (linkedlist.findByID(mactr) != null) {
						System.out.println("Ma Chuong trinh da ton tai");
					} else {
						break;
					}
				}
			}

			while (true) {
				System.out.println("Nhap ten chuong trinh: ");
				tenctr = sc.nextLine();
				if (tenctr.length() == 0) {
					System.out.println("Ma ten chuong trinh khong duoc de trong");
				} else {
					break;
				}
			}
			linkedlist.insertFirstLink(mactr, tenctr);

			System.out.println("Bạn có muốn nhập tiếp? (Y/N) ");
			String chooss = sc.nextLine();
			if (chooss.equals("Y")) {
				flag = true;
			} else {
				flag = false;
			}
		}

	}

	static void ghifileCT() throws IOException {
		FileOutputStream fos = new FileOutputStream("D:\\Doc Ghi\\ChuongTrinh.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ArrayList<Byte> st = new ArrayList<Byte>();
		byte[] bt = linkedlist.toString().getBytes();
		for (int i = 0; i < bt.length; i++) {
			st.add(bt[i]);
		}
		try {

			String temp = "";
			for (byte scan : st) {
				String s1 = String.format("%8s", Integer.toBinaryString(scan & 0xFF)).replace(' ', '0');
				temp = temp + s1;

			}
			oos.writeObject(temp);

			System.out.println("Sucess");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
			oos.close();
		}
	}

	public static void nhapKH() throws IOException {
		int makhoa;
		String tenKhoa;
		int namThanhLap;
		String sMaKhoa = null;
		boolean flag = true;
		Scanner sr = new Scanner(System.in);
		while (flag == true) {
			do {
				try {

					System.out.println("Nhập mã Khoa: ");
					sMaKhoa = sr.nextLine();

					if (sMaKhoa.length() == 0) {
						System.out.println("Mã khoa không được để trống( tối đa 9 ký tự)!");
					} else if (sMaKhoa.length() > 9) {
						System.out.println("Mã khoa quá dài!");
					} else {
						makhoa = Integer.parseInt(sMaKhoa);
						if (theTree.getRoot() == null) {
							break;
						} else {
							if (theTree.findByID1(makhoa) != null) {
							} else {
								break;
							}
						}
//						 break;
					}
				} catch (Exception e) {

					System.out.println("Mã khoa không thể chứ bất kỳ ký tự chữ cái nào");

					System.out.println("Mời nhập lại");
				}
			} while (true);

			sr = new Scanner(System.in);
			do {
				System.out.println("Nhập tên khoa: ");
				tenKhoa = sr.nextLine();
				if (tenKhoa.length() == 0 || tenKhoa.length() > 30) {
					System.out.println("Tên khoa không được để trống và dài tối đa 30 ký tự");
				} else {
					break;
				}
			} while (true);

			sr = new Scanner(System.in);

			do {
				String snamThanhLap;
				try {
					System.out.println("Năm thành lập: ");
					snamThanhLap = sr.nextLine();
					if (Integer.parseInt(snamThanhLap) <= 0 || Integer.parseInt(snamThanhLap) > 2020) {
						System.out.println("Năm nhập vào chưa hợp lệ( Lưu ý: không được để trống và không thể là 0)");
					} else {
						namThanhLap = Integer.parseInt(snamThanhLap);
						break;
					}
				} catch (Exception e) {
					System.out.println(
							"Lưu ý: Năm thành lập không được để trống không thể bằng không và không thể chứa ký tự là chữ cái!");
				}
			} while (true);
			theTree.add(makhoa, tenKhoa, namThanhLap);
			sr = new Scanner(System.in);
			System.out.println("Bạn có muốn nhập tiếp? (Y/N): ");
			String choose = sr.nextLine();
			if (choose.equals("Y")) {
				flag = true;
			} else {
				flag = false;
			}
		}

	}

	public static void xuatCT() {
		linkedlist.display();
	}

	public static void timIDCT() {
		System.out.println("Nhập mã chương trình cần tìm: ");
		String mactr = sc.nextLine();
		if (linkedlist.findByID(mactr) == null) {
			System.out.println("Mã chương trình không tồn tại!");
		} else {
			System.out.println("Mã chương trình có tồn tại!");
		}
	}

	public static void timNameCT() {
		System.out.println("Nhập tên chương trình cần tìm: ");
		String tenctr = sc.nextLine();
		if (linkedlist.findByName(tenctr) == null) {
			System.out.println("Tên chương trình không tồn tại!");
		} else {
			System.out.println("Tên chương trình có tồn tại!");
		}
	}

	public static void Xoa() {
		System.out.println("Nhập mã chương trình xóa: ");
		String mactr = sc.nextLine();
		if (linkedlist.findByID(mactr) == null) {
			System.out.println("Mã chương trình không tồn tại!");
		} else {
			System.out.println("Mã chương trình có tồn tại!");
			linkedlist.removeLink(mactr);
			System.out.println("Chương trình đã bị xóa");
		}
		linkedlist.display();
	}

	static void SuaName(String mactr, String tennew) {
		// TODO Auto-generated method stub
		if (linkedlist.findByID(mactr) == null) {
			System.out.println("Mã chương trình không tồn tại!");
		} else {
			System.out.println(tennew);
			linkedlist.removeLink(mactr);
			linkedlist.insertFirstLink(mactr, tennew);
			linkedlist.display();
		}
	}

	static void SuaID(String mactr, String tenctr) {
		// TODO Auto-generated method stub
		System.out.println("Nhập mã muốn đổi: ");
		String maNew = sc.nextLine();
		linkedlist.insertFirstLink(maNew, tenctr);
		linkedlist.removeLink(mactr);
		linkedlist.display();
	}

	static void GhifileKH() throws IOException {
		ArrayList<Byte> st = new ArrayList<Byte>();
		FileOutputStream fos = new FileOutputStream("D:\\Doc Ghi\\Khoa.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		try {
			byte[] bt = theTree.toString(theTree.getRoot()).getBytes();
			for (int i = 0; i < bt.length; i++) {
				st.add(bt[i]);
			}

			String temp = "";
			for (byte scan : st) {
				String s1 = String.format("%8s", Integer.toBinaryString(scan & 0xFF)).replace(' ', '0');
				temp = temp + s1;

			}

			oos.writeObject(temp);

			System.out.println("Sucess");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
			oos.close();
		}
	}

	public static void docfileKH() {
		try {
			// Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileInputStream fis = new FileInputStream("D:/Doc Ghi/Khoa.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Bước 2: Đọc dữ liệu
			String s = (String) ois.readObject();

			byte[] temp;
			temp = binaryToBytes(s);

			s = toUTF8(temp);
			System.out.println(s);

			fis.close();
			ois.close();
		} catch (Exception ex) {
			System.out.println("Loi doc file: " + ex);
		}

	}

	public static void docfileCT() {
		try {
			// Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileInputStream fis = new FileInputStream("D:/Doc Ghi/ChuongTrinh.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Bước 2: Đọc dữ liệu
			String s = (String) ois.readObject();

			byte[] temp;
			temp = binaryToBytes(s);

			s = toUTF8(temp);
			System.out.println(s);

			fis.close();
			ois.close();
		} catch (Exception ex) {
			System.out.println("Loi doc file: " + ex);
		}

	}

	public static String binaryUnicodeToString(String binary) {

		byte[] array = ByteBuffer.allocate(4).putInt( // 4 bytes byte[]
				Integer.parseInt(binary, 2)).array();

		return new String(array, StandardCharsets.UTF_8);
	}

	public static byte[] binaryToBytes(String input) {
		// TODO: Argument validation (nullity, length)
		byte[] ret = new byte[input.length() / 8];
		for (int i = 0; i < ret.length; i++) {
			String chunk = input.substring(i * 8, i * 8 + 8);
			ret[i] = (byte) Short.parseShort(chunk, 2);
		}
		return ret;
	}

	static String toUTF8(byte[] bytes) {
		// TODO
		return new String(bytes, StandardCharsets.UTF_8);
	}
}