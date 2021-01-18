package KhoaHoc;

class KhoaHoc {
	int maKhoaHoc; // not null, max = 15 chars
	int namBD; // not null
	int namKT; // not null
	KhoaHoc pleftChild;
	KhoaHoc prightChild;
	public KhoaHoc(int maKhoaHoc, int namBD, int namKT) {
		super();
		this.maKhoaHoc = maKhoaHoc;
		this.namBD = namBD;
		this.namKT = namKT;
		this.pleftChild=this.prightChild=null;
	}
	public KhoaHoc() {
		super();
	}
	public String toString() {
		return "Mã khóa học: "+ maKhoaHoc +" Năm bắt đầu: "+namBD+" Năm kết thúc: "+namKT; 
	}
}
