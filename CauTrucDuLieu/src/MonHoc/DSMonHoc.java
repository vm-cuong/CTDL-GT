package MonHoc;

import java.util.Scanner;

public class DSMonHoc {
	MonHoc root;

	public MonHoc getRoot() {
		return root;
	}

	public void setRoot(MonHoc root) {
		this.root = root;
	}

	public void add(int maMH, String tenMH, int maKhoa) {
		MonHoc newnodeMonHoc = new MonHoc(maMH, tenMH, maKhoa);
		if (root == null) {
			root = newnodeMonHoc;
		} else {
			MonHoc nodeHienTai = root;
			MonHoc nodeChaKhoa;
			while (true) {
				nodeChaKhoa = nodeHienTai;
				if (maMH < nodeHienTai.maMH) {
					nodeHienTai = nodeHienTai.pleftChild;
					if (nodeHienTai == null) {
						nodeChaKhoa.pleftChild = newnodeMonHoc;
						return;
					}
				} else {
					nodeHienTai = nodeHienTai.prightChild;
					if (nodeHienTai == null) {
						nodeChaKhoa.prightChild = newnodeMonHoc;
						return;
					}
				}
			}
		}
	}
	// Duyệt cây LNR
//	public void inOrderTraverseTree(Khoa focusNode) {
//
//		if (focusNode != null) {
//
//			// Traverse the left node
//
//			inOrderTraverseTree(focusNode.pleftChild);
//
//			// Visit the currently focused on node
//
//			System.out.println(focusNode);
//
//			// Traverse the right node
//
//			inOrderTraverseTree(focusNode.prightChild);
//
//		}
//	}

// NLR
	public void preorderTraverseTree(MonHoc focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.pleftChild);

			preorderTraverseTree(focusNode.prightChild);
		}
	}

// LRN
//	public void postOrderTraverseTree(Khoa focusNode) {
//
//		if (focusNode != null) {
//
//			postOrderTraverseTree(focusNode.pleftChild);
//
//			postOrderTraverseTree(focusNode.prightChild);
//
//			System.out.println(focusNode);
//
//		}
//
//	}
	public void input() {
		int maMH;
		String tenMH;
		int maKhoa;

		Scanner sr = new Scanner(System.in);
		boolean flag = true;
		while (flag == true) {
			do {
				String smaMH;
				try {
					System.out.println("Nhập mã môn học: ");
					smaMH = sr.nextLine();
					if (Integer.parseInt(smaMH) <= 0) {
						System.out.println("Không có môn học nào có mã môn học này!");
					} else if (smaMH.length() == 0 || smaMH.length() > 15)
						System.out.println("Mã môn học không được để trống và dài tối đa 15 ký tự");
					else {
						maMH = Integer.parseInt(smaMH);
						break;
					}
				} catch (Exception e) {
					System.out.println("Mã môn học không chưa bất kỳ ký tự chữ cái nào và tối đa 15 ký tự");
					System.out.println("Mời nhập lại!");
				}
			} while (true);

			sr = new Scanner(System.in);

			do {

				System.out.println("Nhập tên môn học: ");
				tenMH = sr.nextLine();
				if (tenMH.length() == 0 || tenMH.length() > 500)
					System.out.println("Tên môn học không được để trống và dài tối đa 500 ký tự!");
				else
					break;
			} while (true);

			sr = new Scanner(System.in);

			do {
				String sMaKhoa;
				try {
					System.out.println("Nhập mã khoa: ");
					sMaKhoa = sr.nextLine();

					if (sMaKhoa.length() == 0) {
						System.out.println("Mã khoa không được để trống và tối đa 9 ký tự");
					} else if (sMaKhoa.length() > 9) {
						System.out.println("Mã khoa quá dài");
					} else {
						maKhoa = Integer.parseInt(sMaKhoa);
						break;
					}
				} catch (Exception e) {
					System.out.println("Mã khoa không chứa ký tự chữ cái nào và tối đa 9 ký tự!");
					System.out.println("Mời nhập lại!");
				}

			} while (true);
			add(maMH, tenMH, maKhoa);
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
