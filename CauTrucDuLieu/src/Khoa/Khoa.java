package Khoa;

class Khoa {
	int maKhoa; // để tìm kiếm theo mã này trên cây
	String tenKhoa;
	int namThanhLap;
	Khoa pleftChild; // con trỏ bên trái
	Khoa prightChild; // con trỏ bên phải

	public Khoa(int maKhoa, String tenKhoa, int namThanhLap) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.namThanhLap = namThanhLap;
		this.pleftChild = this.prightChild = null;

	}

	public Khoa() {
		super();
	}

	public String toString() {
		return "Mã khoa: "+ maKhoa +" Tên khoa: "+tenKhoa+" Năm thành lập: "+namThanhLap; 
	}

}
