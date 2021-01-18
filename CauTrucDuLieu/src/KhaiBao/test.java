package KhaiBao;

import java.util.Scanner;

import DSChuongTrinh.DSChuongTrinh;
import Khoa.DSKhoa;

public class test {
	static Scanner scanner = new Scanner(System.in);
	static DSChuongTrinh linkedlist= new DSChuongTrinh();
	public static void main(String[] args) {
		
		// Tìm theo mã của cây nhị phân
//		DSKhoa theTree = new DSKhoa();
	
		String chooss;
//		int makhoa, namthanhlap;
//		String tenkhoa;
//		boolean flag = true;
//		while (flag == true) {
//			System.out.println("Nhập mã khoa:");
//			makhoa = scanner.nextInt();
//			scanner.nextLine();
//			System.out.println("Nhập tên khoa:");
//			tenkhoa = scanner.nextLine();
//			System.out.println("Năm thành lập:");
//			namthanhlap = scanner.nextInt();
//			theTree.add(makhoa, tenkhoa, namthanhlap);
//			scanner.nextLine();
//			System.out.println("Bạn có muốn nhập tiếp? (Y/N) ");
//			chooss = scanner.nextLine();
//			if (chooss.equals("Y")) {
//				flag = true;
//			} else {
//				flag = false;
//			}
//		}
//		theTree.inOrderTraverseTree(theTree.getRoot());
//		System.out.println("Nhập mã cần tìm: ");
//		makhoa = scanner.nextInt();
//		scanner.nextLine();
//		System.out.println(theTree.findByID(makhoa));
//		if(theTree.findByID(makhoa)!=null) {
//			
//		}
		
		//tìm theo mã danh sách liên kết
		
		String mactr,tenctr;
		boolean flag = true;
		while (flag == true) {
			System.out.println("Nhập mã chương trình:");
			mactr = scanner.nextLine();
			System.out.println("Nhập tên chuong trinh:");
			tenctr = scanner.nextLine();
			linkedlist.insertFirstLink(mactr, tenctr);
			System.out.println("Bạn có muốn nhập tiếp? (Y/N) ");
			chooss = scanner.nextLine();
			if (chooss.equals("Y")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		linkedlist.display();
//		System.out.println("Nhập mã chương trình cần tìm: ");
//		mactr = scanner.nextLine();
//		if (linkedlist.findByID(mactr)==null) {
//			System.out.println("Mã chương trình không tồn tại!");
//		}
//		else {
//			System.out.println("Mã chương trình có tồn tại!");
//		}
//		System.out.println("Nhập tên chương trình cần tìm: ");
//		tenctr = scanner.nextLine();
//		if (linkedlist.findByName(tenctr)==null) {
//			System.out.println("Tên chương trình không tồn tại!");
//		}
//		else {
//			System.out.println("Tên chương trình có tồn tại!");
//		}
		
		//Xóa list
//		System.out.println("Nhập mã chương trình xóa: ");
//		mactr = scanner.nextLine();
//		if (linkedlist.findByID(mactr)==null) {
//			System.out.println("Mã chương trình không tồn tại!");
//		}
//		else {
//			System.out.println("Mã chương trình có tồn tại!");
//			linkedlist.removeLink(mactr);
//			
//		}
//		linkedlist.display();
		System.out.println("Nhập mã chương trình cần update: ");
		mactr = scanner.nextLine();
		String tenctr1;
		if (linkedlist.findByID(mactr)==null) {
			System.out.println("Mã chương trình không tồn tại!");
		}
		else {
			int j;
			System.out.println("Mã chương trình có tồn tại!");
			while (true) {
				System.out.println("thông tin muốn sửa?");
				System.out.println("===(1) Sửa ID===");
				System.out.println("===(2) Sửa Name===");
				System.out.println("===(3) Về menu chính===");
				j=scanner.nextInt();
				scanner.nextLine();
				switch (j) {
				case 1:
					tenctr1= linkedlist.findByIDGetName(mactr);
					SuaID(mactr,tenctr1);
					break;
				case 2:
					System.out.println("Nhập tên muốn sửa: ");
					tenctr1=scanner.nextLine();
			 		SuaName(mactr, tenctr1);
					break;
				default:
					break;
				}
				
			}
		}	
	}

    static void SuaName(String mactr,String tennew) {
		// TODO Auto-generated method stub
    	if (linkedlist.findByID(mactr)==null) {
			System.out.println("Mã chương trình không tồn tại!");
		}
		else {
    	 System.out.println(tennew);		
 		linkedlist.removeLink(mactr);
 		linkedlist.insertFirstLink(mactr, tennew);
		linkedlist.display();}
	}

	static void SuaID(String mactr, String tenctr) {
		// TODO Auto-generated method stub
		System.out.println("Nhập mã muốn đổi: ");
		String maNew= scanner.nextLine();
		linkedlist.insertFirstLink(maNew, tenctr);
		linkedlist.removeLink(mactr);
		linkedlist.display();
	}
}
