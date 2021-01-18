package Khoa;

import java.util.Scanner;

public class DSKhoa {
	// Node con Khoa -> Makhoa
		// 2 node con (left. right)
		Khoa root;

		public void add(int makhoa, String tenKhoa, int namThanhLap) {
			Khoa newnodeKhoa = new Khoa(makhoa, tenKhoa, namThanhLap);
			if (root == null) {
				root = newnodeKhoa;
			} else {
				Khoa nodeHienTai = root;
				Khoa nodeChaKhoa;
				while (true) {
					nodeChaKhoa = nodeHienTai;
					if (makhoa < nodeHienTai.maKhoa) {
						nodeHienTai = nodeHienTai.pleftChild;
						if (nodeHienTai == null) {
							nodeChaKhoa.pleftChild = newnodeKhoa;
							return;
						}
					} else {
						nodeHienTai = nodeHienTai.prightChild;
						if (nodeHienTai == null) {
							nodeChaKhoa.prightChild = newnodeKhoa;
							return;
						}
					}
				}
			}
		}

		public Khoa getRoot() {
			return root;
		}

		public void setRoot(Khoa root) {
			root = root;
		}

		// Duyệt cây LNR
		public void inOrderTraverseTree(Khoa focusNode) {

			if (focusNode != null) {

				// Traverse the left node

				inOrderTraverseTree(focusNode.pleftChild);

				// Visit the currently focused on node

				System.out.println(focusNode);

				// Traverse the right node

				inOrderTraverseTree(focusNode.prightChild);

			}
		}

		// NLR
		public void preorderTraverseTree(Khoa focusNode) {

			if (focusNode != null) {
				System.out.println(focusNode.toString());

				preorderTraverseTree(focusNode.pleftChild);
				preorderTraverseTree(focusNode.prightChild);
			}
		}
		public String toString(Khoa nodehientai) {
			String str = "";
		    if(nodehientai == null) {
		        return str;
		    } else{
		        str += nodehientai.toString()+"\n";
		        str += toString(nodehientai.pleftChild)+"" + toString(nodehientai.prightChild)+"";
		    }

		return str;
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
		public Khoa findByID(int makhoa) {
			Khoa nodeHienTai = root;
			while (nodeHienTai.maKhoa != makhoa) {
				if (makhoa < nodeHienTai.maKhoa) {
					nodeHienTai = nodeHienTai.pleftChild;
				} else {
					nodeHienTai = nodeHienTai.prightChild;
				}
				if (nodeHienTai == null) {
					System.out.println("Mã khoa không tồn tại");
					return null;

				}
			}
			System.out.println("Mã khoa có tồn tại!");
			return nodeHienTai;

		}
		public Khoa findByID1(int makhoa) {
			Khoa nodeHienTai = root;
			while (nodeHienTai.maKhoa != makhoa) {
				if (makhoa < nodeHienTai.maKhoa) {
					nodeHienTai = nodeHienTai.pleftChild;
				} else {
					nodeHienTai = nodeHienTai.prightChild;
				}
				if (nodeHienTai == null) {
					return null;

				}
			}
			System.out.println("Mã khoa đã tồn tại!");
			return nodeHienTai;

		}

//		public boolean removenode(int makhoa) {
//			Khoa nodeHienTai = root;
//			Khoa nodechaKhoa = root;
//			boolean nodeTraiCon = true;
//			while (nodeHienTai.maKhoa != makhoa) {
//				nodechaKhoa = nodeHienTai;
//				if (makhoa < nodeHienTai.maKhoa) {
//					nodeTraiCon = true;
//					nodeHienTai = nodeHienTai.pleftChild;
//				} else {
//					nodeTraiCon = false;
//					nodeHienTai = nodeHienTai.prightChild;
//				}
//				if (nodeHienTai == null) {
//					return false;
//				}
//				if (nodeHienTai.pleftChild == null && nodeHienTai.prightChild == null) {
//					if (nodeHienTai == root) {
//						root = null;
//					} else if (nodeTraiCon) {
//						nodechaKhoa.pleftChild = null;
//					} else {
//						nodechaKhoa.prightChild = null;
//					}
//				} else if (nodeHienTai.prightChild == null) {
//					if (nodeHienTai == root) {
//						root = nodeHienTai.pleftChild;
//					} else if (nodeTraiCon) {
//						nodechaKhoa.pleftChild = nodeHienTai.pleftChild;
//					} else {
//						nodechaKhoa.prightChild = nodeHienTai.pleftChild;
//					}
//				} else if (nodeHienTai.pleftChild == null) {
//					if (nodeHienTai == root) {
//						root = nodeHienTai.prightChild;
//					} else if (nodeTraiCon) {
//						nodechaKhoa.pleftChild = nodeHienTai.prightChild;
//					} else {
//						nodechaKhoa.prightChild = nodeHienTai.prightChild;
//					}
//				} else {
//					Khoa replacement = getReplacementnode(nodeHienTai);
//					if (nodeHienTai == root) {
//						root = replacement;
//					} else if (nodeTraiCon) {
//						nodechaKhoa.pleftChild = replacement;
//					} else {
//						nodechaKhoa.prightChild = replacement;
//						replacement.pleftChild = nodeHienTai.pleftChild;
//					}
//				}
//
//			}
//			return true;
//		}
//
//		private Khoa getReplacementnode(Khoa nodeThayThe) {
//			// TODO Auto-generated method stub
//			Khoa replacementParent = nodeThayThe;
//			Khoa replacement = nodeThayThe;
//			Khoa nodeKhoa = nodeThayThe.prightChild;
//			while (nodeKhoa != null) {
//				replacementParent = replacement;
//				replacement = nodeKhoa;
//				nodeKhoa = nodeKhoa.pleftChild;
//			}
//			if (replacement != nodeThayThe.prightChild) {
//				replacementParent.pleftChild = replacement.prightChild;
//				replacement.prightChild = nodeThayThe.prightChild;
//			}
//			return replacement;
//		}
		 public void delete(Integer data) {
			 
		        deleteNode(this.root, data);
		    }
		 
		    private Khoa deleteNode(Khoa root, Integer data) {
		 
		        if(root == null) return root;
		 
		        if(data < root.maKhoa) {
		            root.pleftChild=deleteNode(root.pleftChild, data);
		        } else if(data > root.maKhoa) {
		            root.prightChild=deleteNode(root.prightChild, data);
		        } else {
		            // node with no leaf nodes
		            if(root.pleftChild == null && root.prightChild == null) {
		                System.out.println("deleting "+data);
		                return null;
		            } else if(root.pleftChild == null) {
		                // node with one node (no left node)
		                System.out.println("deleting "+data);
		                return root.prightChild;
		            } else if(root.prightChild == null) {
		                // node with one node (no right node)
		                System.out.println("deleting "+data);
		                return root.pleftChild;
		            } else {
		                // nodes with two nodes
		                // search for min number in right sub tree
		                Integer minValue = minValue(root.prightChild);
		                root.maKhoa=minValue;
		                root.prightChild=deleteNode(root.prightChild, minValue);
		                System.out.println("deleting "+data);
		            }
		        }
		 
		        return root;
		    }
		 
		    private Integer minValue(Khoa node) {
		 
		        if(node.pleftChild != null) {
		            return minValue(node.pleftChild);
		        }
		        return node.maKhoa;
		    }
		// Input

//	public void input() {
//		int makhoa;
//		String tenKhoa;
//		int namThanhLap;
//		String sMaKhoa = null;
//
//		Scanner sr = new Scanner(System.in);
//
//		do {
//			try {
//
//				System.out.println("Nhập mã Khoa: ");
//				sMaKhoa = sr.nextLine();
////			makhoa = sr.nextInt();
////			String sMaKhoa = String.valueOf(makhoa);
//
//				if (sMaKhoa.length() == 0) {
//					System.out.println("Mã khoa không được để trống!");
//				} else if (sMaKhoa.length() > 9) {
//					System.out.println("Mã khoa quá dài!");
//				} else {
//					makhoa = Integer.parseInt(sMaKhoa);
//					break;
//				}
//			} catch (Exception e) {
//
//				System.out.println("Mã khoa không thể chứ bất kỳ ký tự chữ cái nào");
//
//				System.out.println("Mời nhập lại");
//			}
//		} while (true);
//
//		sr = new Scanner(System.in);
//		do {
//			System.out.println("Nhập tên khoa: ");
//			tenKhoa = sr.nextLine();
//			if (tenKhoa.length() == 0 || tenKhoa.length() > 30) {
//				System.out.println("Tên khoa không được để trống và dài tối đa 30 ký tự");
//			} else {
//				break;
//			}
//		} while (true);
//
//		sr = new Scanner(System.in);
//
//		do {
//			System.out.println("Năm thành lập: ");
//			namThanhLap = sr.nextInt();
//
//			if (namThanhLap <= 0) {
//				System.out.println("Năm thành lập không hợp lệ!");
//			} else {
//				break;
//			}
//
//		} while (true);
//		add(makhoa, tenKhoa, namThanhLap);
//	}

}
