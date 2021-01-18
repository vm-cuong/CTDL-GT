package SinhVien;

import DSKetQua.DSKetQua;
import KhoaHoc.DSKhoaHoc;
import LopHoc.DSLopHoc;
import MonHoc.DSMonHoc;

public class test {
	public static void main(String[] args) {
		System.out.println("--ket qua");
		DSKetQua dskq = new DSKetQua();
		dskq.input();
		dskq.display();
		System.out.println("--sinh vien");
		DSSinhVien dssv = new DSSinhVien();
		dssv.input();
		dssv.display();
		System.out.println("--khoa hoc");
		DSKhoaHoc dskh = new DSKhoaHoc();
		dskh.input();
		dskh.preorderTraverseTree(dskh.getRoot());
		System.out.println("--lop hoc--");
		DSLopHoc dslh = new DSLopHoc();
		dslh.input();
		dslh.display();
		System.out.println("--mon hoc");
		DSMonHoc dsmh = new DSMonHoc();
		dsmh.input();
		dsmh.preorderTraverseTree(dsmh.getRoot());
	}
}
