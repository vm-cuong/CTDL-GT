package DSKetQua;

class KetQua {
	double diem;
	int lanThi;
	int maMH;
	String maSV;
	KetQua pNext;

	public KetQua(double diem, int lanThi, int maMH, String maSV) {
		super();
		this.diem = diem;
		this.lanThi = lanThi;
		this.maMH = maMH;
		this.maSV = maSV;
		this.pNext = null;
	}

	public KetQua() {
		super();
	}
	public String toString() {
		return "Mã sv: " + maSV + " Mã môn học: " + maMH + " Điểm " + diem + " Lần thi " + lanThi;
	}

	public void display() {

		System.out.println("Mã sv: " + maSV + " Mã môn học: " + maMH + " Điểm " + diem + " Lần thi " + lanThi);

	}
}
