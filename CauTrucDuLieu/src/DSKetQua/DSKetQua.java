package DSKetQua;

import java.util.Scanner;

public class DSKetQua {

	KetQua firstLink;

	public DSKetQua() {
		// TODO Auto-generated constructor stub
		firstLink = null;
	}

	public boolean isEmpty() {

		return (firstLink == null);

	}
	public void insertFirstLink(double diem, int lanThi, int maMH, String maSV) {
		KetQua newLink = new KetQua(diem, lanThi, maMH, maSV);

		// Connects the firstLink field to the new Link

		newLink.pNext = firstLink;

		firstLink = newLink;

	}

	public void display() {

		KetQua theLink = firstLink;

		// Start at the reference stored in firstLink and

		// keep getting the references stored in next for

		// every Link until next returns null

		while (theLink != null) {

			theLink.display();
			System.out.println("Next Link: " + theLink.pNext);

			theLink = theLink.pNext;

			System.out.println();

		}

	}

	public void input() {
		double diem;
		int lanThi;
		int maMH;
		String maSV;
		String sdiem;
		Scanner sr = new Scanner(System.in);
		boolean flag = true;
		while (flag == true) {
			do {
				try {
					System.out.println("Nhập điểm: ");
					sdiem = sr.nextLine();
					diem = Integer.parseInt(sdiem);
					// String sdiem = String.valueOf(diem);

					if (diem < 0 || diem > 10) {
						System.out.println("Điểm nhập vào không hợp lệ!");
					} else {
						diem = Double.parseDouble(sdiem);
						break;
					}

				} catch (Exception e) {
					System.out.println("Điểm không được để trống và không chứa ký tự chữ cái");
				}
			} while (true);

			sr = new Scanner(System.in);

			do {
				String slanThi;
				try {
					System.out.println("Nhập lần thi: ");
					slanThi = sr.nextLine();
					 
					if (Integer.parseInt(slanThi) < 0)
						System.out.println("Bạn đã nhập sai. Vui lòng nhập lại");
					else if (slanThi.length() == 0) {
						System.out.println("Lần thi không được để trống");
					} else if (Integer.parseInt(slanThi) > 20) {
						System.out.println("Không cho Sinh viên thi quá số lần quy định. Vui lòng liên hệ phòng công tác sinh viên và chọn môn học thay thế!");
					}
					else {
						lanThi = Byte.parseByte(slanThi);
						break;
					}
				} catch (Exception e) {
					System.out.println("Số lần thi phải hợp lệ( Lưu ý: Không chứa ký tự là chữ cái)!");
				}
			} while (true);

			sr = new Scanner(System.in);

			do {
				String smaMH;
				try {
					System.out.println("Nhập mã môn học: ");
					smaMH = sr.nextLine();
					 
					if (Integer.parseInt(smaMH) <= 0) {
						System.out.println("Không có môn học nào có mã này!");
					} else if (smaMH.length() == 0 || smaMH.length() > 15)
						System.out.println("Mã môn học không được để trống và tối đa 15 ký tự");
					else {
						maMH = Integer.parseInt(smaMH);
						break;
					}
				} catch (Exception e) {
					System.out.println("Mã môn học phải lớn hơn không, tối đa 15 ký tự và không có ký tự là chữ cái!");
					System.out.println("Mời nhập lại");
				}
			} while (true);

			sr = new Scanner(System.in);
			do {
				System.out.println("Nhập mã Sinh viên: ");
				maSV = sr.nextLine();
				if (maSV.length() <= 0 || maSV.length() > 20)
					System.out.println("Mã Sinh viên không được để trống và tối đa 20 ký tự!");
				else
					break;
			} while (true);
			insertFirstLink(diem, lanThi, maMH, maSV);
			System.out.println("Bạn có muốn nhập tiếp? (Y/N): ");
			String choose = sr.nextLine();
			if (choose.equals("Y")) {
				flag = true;
			} else {
				flag = false;
			}
		}

	}
}
