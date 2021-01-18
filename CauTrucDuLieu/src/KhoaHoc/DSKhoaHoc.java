package KhoaHoc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DSKhoaHoc {
	KhoaHoc root;

	public KhoaHoc getRoot() {
		return root;
	}

	public void setRoot(KhoaHoc root) {
		root = root;
	}

	public void add(int maKhoaHoc, int namBD, int namKT) {
		KhoaHoc newnodeKhoaHoc = new KhoaHoc(maKhoaHoc, namBD, namKT);
		if (root == null) {
			root = newnodeKhoaHoc;
		} else {
			KhoaHoc kh = root;
			KhoaHoc nodeChaKhoa;
			while (true) {
				nodeChaKhoa = kh;
				if (maKhoaHoc < kh.maKhoaHoc) {
					kh = kh.pleftChild;
					if (kh == null) {
						nodeChaKhoa.pleftChild = newnodeKhoaHoc;
						return;
					}
				} else {
					kh = kh.prightChild;
					if (kh == null) {
						nodeChaKhoa.prightChild = newnodeKhoaHoc;
						return;
					}
				}
			}
		}
	}
	// Duyệt cây LNR
//		public void inOrderTraverseTree(Khoa focusNode) {
	//
//			if (focusNode != null) {
	//
//				// Traverse the left node
	//
//				inOrderTraverseTree(focusNode.pleftChild);
	//
//				// Visit the currently focused on node
	//
//				System.out.println(focusNode);
	//
//				// Traverse the right node
	//
//				inOrderTraverseTree(focusNode.prightChild);
	//
//			}
//		}

	// NLR
	public void preorderTraverseTree(KhoaHoc focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.pleftChild);

			preorderTraverseTree(focusNode.prightChild);
		}
	}

	// LRN
//		public void postOrderTraverseTree(Khoa focusNode) {
	//
//			if (focusNode != null) {
	//
//				postOrderTraverseTree(focusNode.pleftChild);
	//
//				postOrderTraverseTree(focusNode.prightChild);
	//
//				System.out.println(focusNode);
	//
//			}
	//
//		}

	public void input() {
		int maKhoaHoc = 0;
		int namBD;
		int namKT;

		Scanner sr = new Scanner(System.in);
		boolean flag = true;
		while (flag == true) {
			do {

				try {
					System.out.println("Nhập mã Khóa học: ");
					// maKhoaHoc = sr.nextInt();
					String smaKhoaHoc = sr.nextLine();

					if (smaKhoaHoc.length() == 0 || smaKhoaHoc.length() > 15) {
						System.out.println("Mã khóa học không được để trống và dài tối đa 15 ký tự");
					} else {
						maKhoaHoc = Integer.parseInt(smaKhoaHoc);
						break;
					}
				} catch (Exception e) {
					System.out.println("Mã khóa học không thể chứ bất kỳ ký tự chữ cái nào");
					System.out.println("Mời nhập lại!");
				}
			} while (true);

			sr = new Scanner(System.in);
			do {
				String snamBD, snamKT;
				try {
					System.out.println("Nhập năm bắt đầu: ");
					snamBD = sr.nextLine();
					System.out.println("Nhập năm kết thúc: ");
					snamKT = sr.nextLine();
					if (Integer.parseInt(snamBD) <= 0 || Integer.parseInt(snamKT) <= 0) {
						System.out.println("Năm nhập vào chưa hợp lệ( Lưu ý: không được để trống và không thể là 0)");
					} else if (Integer.parseInt(snamBD) > Integer.parseInt(snamKT)
							|| (Integer.parseInt(snamKT) - Integer.parseInt(snamBD)) < 3
							|| (Integer.parseInt(snamKT) - Integer.parseInt(snamBD)) > 10) {
						System.out.println(
								"Một khóa học ít nhất là 3 năm và không thể kéo dài quá 10 năm. Vui lòng nhập đúng yêu cầu!");
					} else {
						namBD = Integer.parseInt(snamBD);
						namKT = Integer.parseInt(snamKT);
						break;
					}
				} catch (Exception e) {
					System.out.println("Vui lòng không để trống năm học bắt đầu và kết thúc");
					System.out.println(
							"Lưu ý: Năm không được để trống không thể bằng không và một niên khóa tối thiểu là 3 năm và tối đa 10 năm!");
				}
			} while (true);
			sr = new Scanner(System.in);
			add(maKhoaHoc, namBD, namKT);
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
