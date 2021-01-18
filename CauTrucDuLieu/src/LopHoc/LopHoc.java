package LopHoc;

class LopHoc {
	String maLop;
	int maKhoa;
	int stt; // tăng dần
	int nienKhoa;
	LopHoc pNext;

	public LopHoc() {
		super();
	}

	public LopHoc(String maLop, int maKhoa, int stt, int nienKhoa) {
		super();
		this.maLop = maLop;
		this.maKhoa = maKhoa;
		this.stt = stt;
		this.nienKhoa = nienKhoa;
		this.pNext = null;
	}

	public String toString() {
		return "Mã Lớp: " + maLop + " Mã Khoa: " + maKhoa + "Khóa" + nienKhoa + " STT: " + stt;
	}

	public void display() {

		System.out.println("Mã Lớp: " + maLop + " Mã Khoa: " + maKhoa + "Khóa" + nienKhoa + " STT: " + stt);

	}

}
