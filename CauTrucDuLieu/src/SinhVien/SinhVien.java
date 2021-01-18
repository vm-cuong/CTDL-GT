package SinhVien;

class SinhVien {
	String maSV; // not null, max 20 chars
	String hoTen; // not null. max 500 chars
	int namSinh; // not null
	boolean gioiTinh; // not null
	String maLop; // not null, max 20 chars
	SinhVien pNext;

	public SinhVien(String maSV, String hoTen, int namSinh, boolean gioiTinh, String maLop) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.maLop = maLop;
		this.pNext = null;
	}

	public SinhVien() {
		super();
	}

	public String toString() {
		return "Mã sv: " + maSV + " Họ và tên: " + hoTen + " Năm Sinh: " + namSinh + " Gioi Tính: " + gioiTinh;
	}

	public void display(boolean gioiTinh) {
		String gTinh = null;
		if (gioiTinh == true) {
			gTinh = "Nam";
		} else if(gioiTinh == false) {
			gTinh = "Nữ";
		}
		
		System.out.println("Mã sv: " + maSV + " Họ và tên: " + hoTen + " Năm Sinh: " + namSinh + " Gioi Tính: " + gTinh + " Mã lớp: " + maLop);

	}

}
