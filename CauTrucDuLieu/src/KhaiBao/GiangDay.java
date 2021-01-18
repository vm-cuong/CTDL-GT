package KhaiBao;

import java.util.Scanner;

public class GiangDay implements NhapXuat {
	private byte hocKy;
	private int namHoc;
	private int soTietLT;
	private int soTietTH;
	private int soTinChi;

	public GiangDay(byte hocKy, int namHoc, int soTietLT, int soTietTH, int soTinChi) {
		super();
		this.hocKy = hocKy;
		this.namHoc = namHoc;
		this.soTietLT = soTietLT;
		this.soTietTH = soTietTH;
		this.soTinChi = soTinChi;
	}

	public GiangDay() {
		super();
	}

	public byte getHocKy() {
		return hocKy;
	}

	public void setHocKy(byte hocKy) {
		this.hocKy = hocKy;
	}

	public int getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
	}

	public int getSoTietLT() {
		return soTietLT;
	}

	public void setSoTietLT(int soTietLT) {
		this.soTietLT = soTietLT;
	}

	public int getSoTietTH() {
		return soTietTH;
	}

	public void setSoTietTH(int soTietTH) {
		this.soTietTH = soTietTH;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	Scanner sr = new Scanner(System.in);

	@Override
	public void input() {
		do {
			System.out.println("Nhap Hoc ky( Luu y: Mot nam hoc chi co 3 hoc ky): ");
			this.hocKy = sr.nextByte();

			if (this.hocKy < 1 || this.hocKy > 3) {
				System.out.println("Nam hoc khong co hoc ky nay, Moi ban nhap lai");

			} else
				break;
		} while (true);

		do {
			System.out.println("Nhap vao nam hoc giang day: ");
			this.namHoc = sr.nextInt();
			if (this.namHoc <= 0 || this.namHoc > 2020) {
				System.out.println("Nam hoc khong hop le! Ban hay nhap dung nam hoc!");
			} else {
				break;
			}

		} while (true);

		do {
			System.out.println("Nhap so tiet ly thuyet: ");
			this.soTietLT = sr.nextInt();

			if (this.soTietLT <= 0 || this.soTietLT > 55) {
				System.out.println("Vui long nhap dung so tiet ly thuyet");
			} else
				break;
		} while (true);

		do {
			System.out.println("Nhap so tiet thuc hanh: ");
			this.soTietTH = sr.nextInt();

			if (this.soTietTH <= 0 || this.soTietTH > 55) {
				System.out.println("Vui long nhap dung so tiet thuc hanh");
			} else
				break;
		} while (true);

		do {
			System.out.println("Nhap vao so tin chi: ");
			this.soTinChi = sr.nextInt();
			if (this.soTinChi <= 0) {
				System.out.println("Vui long nhap dung so tin chi");
			} else
				break;
		} while (true);
	}

	@Override
	public void output() {
		System.out.println("Hoc ky: " + this.hocKy);
		System.out.println("Nam hoc: " + this.namHoc);
		System.out.println("So tiet Ly thuyet: " + this.soTietLT);
		System.out.println("So tiet Thuc hanh: " + this.soTietTH);
		System.out.println("So tin chi: " + this.soTinChi);

	}

}
