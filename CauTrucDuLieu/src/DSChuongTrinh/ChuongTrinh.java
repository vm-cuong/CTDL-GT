package DSChuongTrinh;

class ChuongTrinh {
	String maCTr;
	String tenCTr;
	ChuongTrinh pNext;

	public ChuongTrinh(String maCTr, String tenCTr) {
		super();
		this.maCTr = maCTr;
		this.tenCTr = tenCTr;
		this.pNext = null;
	}

	public ChuongTrinh() {
		super();
	}

	public String toString() {
		return "Mã Chương Trình: " + maCTr + " Tên Chương Trình: " + tenCTr+"\n";
	}
	
	public void display() {

		System.out.println("Mã Chương Trình: " + maCTr + " Tên Chương Trình: " + tenCTr);

	}

}
