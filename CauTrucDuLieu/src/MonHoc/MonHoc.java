package MonHoc;

class MonHoc {
	int maMH;
	String tenMH;
	int maKhoa;
	MonHoc pleftChild;
	MonHoc prightChild;
	public MonHoc(int maMH, String tenMH, int maKhoa) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.maKhoa = maKhoa;
		this.pleftChild=this.prightChild=null;
	}
	public MonHoc() {
		super();
	}
	public String toString() {
		return "Mã môn học: "+ maMH +" Tên môn học: "+tenMH; 
	}
}
