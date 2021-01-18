package DSChuongTrinh;

import java.io.Serializable;
import java.util.Scanner;

public class DSChuongTrinh implements Serializable{
	ChuongTrinh firstLink;

	public ChuongTrinh getFirstLink() {
		return firstLink;
	}

	public void setFirstLink(ChuongTrinh firstLink) {
		this.firstLink = firstLink;
	}

	public DSChuongTrinh() {
		// TODO Auto-generated constructor stub
		firstLink = null;
	}

	public boolean isEmpty() {

		return (firstLink == null);

	}
	public String toString() {
		ChuongTrinh theLink = firstLink;
		String temp="";
		while (theLink != null) {

			temp=temp+theLink.toString();
			theLink = theLink.pNext;


		}
		return temp;
	}

	public void insertFirstLink(String maCTr, String tenCTr) {
		ChuongTrinh newLink = new ChuongTrinh(maCTr, tenCTr);

		// Connects the firstLink field to the new Link
		newLink.pNext = firstLink;

		firstLink = newLink;

	}
	//sắp xếp 
	 ChuongTrinh sorted ;
	 public void insertionSort(ChuongTrinh headref)  
	    { 
	        // Initialize sorted linked list 
	        sorted = null; 
	        ChuongTrinh current = headref; 
	        // Traverse the given linked list and insert every 
	        // node to sorted 
	        while (current != null)  
	        { 
	            // Store next for next iteration 
	        	ChuongTrinh next = current.pNext; 
	            // insert current in sorted linked list 
	            sortedInsert(current); 
	            // Update current 
	            current = next; 
	        } 
	        // Update head_ref to point to sorted linked list 
	        firstLink = sorted; 
	    } 
	  
	    /* 
	     * function to insert a new_node in a list. Note that  
	     * this function expects a pointer to head_ref as this 
	     * can modify the head of the input linked list  
	     * (similar to push()) 
	     */
	   public void sortedInsert(ChuongTrinh newnode)  
	    { 
	        /* Special case for the head end */
	        if (sorted == null || Integer.parseInt(sorted.maCTr) >= Integer.parseInt(newnode.maCTr))  
	        { 
	            newnode.pNext = sorted; 
	            sorted = newnode; 
	        } 
	        else 
	        { 
	        	ChuongTrinh current = sorted; 
	            /* Locate the node before the point of insertion */
	            while (current.pNext != null && Integer.parseInt(current.pNext.maCTr) < Integer.parseInt(newnode.maCTr))  
	            { 
	                current = current.pNext; 
	            } 
	            newnode.pNext= current.pNext; 
	            current.pNext = newnode; 
	        } 
	    } 
	public void display() {

		ChuongTrinh theLink = firstLink;

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

	public ChuongTrinh findByID(String mactr) {
		ChuongTrinh thelink = firstLink;
		if (!isEmpty()) {
			while (thelink.maCTr.equals(mactr) == false) {
				if (thelink.pNext == null) {
					return null;

				} else {
					thelink = thelink.pNext;
				}
			}
		} else {
			System.out.println("Danh sách rỗng");
		}
		return thelink;
	}
	public String findByIDGetName(String mactr) {
		ChuongTrinh thelink = firstLink;
		String tempString;
		if (!isEmpty()) {
			while (thelink.maCTr.equals(mactr) == false) {
				if (thelink.pNext == null) {
					return null;

				} else {
					thelink = thelink.pNext;
				}
			}
		} else {
			System.out.println("Danh sách rỗng");
		}
		tempString=thelink.tenCTr;
		return tempString;
	}

	public ChuongTrinh findByName(String mactr) {
		ChuongTrinh thelink = firstLink;
		if (!isEmpty()) {
			while (thelink.tenCTr.equals(mactr)==false) {
				if (thelink.pNext == null) {
					return null;

				} else {
					thelink = thelink.pNext;
					thelink.display();
				}
			}
		} else {
			System.out.println("Danh sách rỗng");
		}
		return thelink;
	}
	//Xóa đầu
	public ChuongTrinh removeFirst() {
		ChuongTrinh linkTam = firstLink;
		if (!isEmpty()) {
			// xóa khỏi danh sách;
			firstLink = firstLink.pNext;
		} else {
			System.out.println("Danh sách rỗng! ");
		}
		return linkTam;
	}
	//Xóa theo ID
	public ChuongTrinh removeLink(String maCtr) {
		ChuongTrinh linkTam = firstLink;
		ChuongTrinh linkHienTai = firstLink;
		while (linkHienTai.maCTr.equals(maCtr)==false) {
			if(linkHienTai.pNext==null) {
				return null;
			}
			else {
				linkTam=linkHienTai;
				linkHienTai=linkHienTai.pNext;
			}
		}
		if(linkHienTai == firstLink) {
			firstLink = firstLink.pNext;
		}
		else {
			linkTam.pNext=linkHienTai.pNext;
		}
		return linkHienTai;
	}
	
	// Nhập
	Scanner sr = new Scanner(System.in);
	public void input() {
		String maCTr;
		String tenCT;
		do {
			System.out.println("Nhap Ma Chuong trinh: ");
			maCTr = sr.nextLine();
			if(maCTr.length() == 0)
			{
				System.out.println("Ma Chuong trinh khong duoc de trong");
			}
			else
			{
				break;
			}
		} while (true);
		
		do {
			System.out.println("Nhap ten chuong trinh: ");
			tenCT = sr.nextLine();
			if(tenCT.length() == 0)
			{
				System.out.println("Ma Chuong trinh khong duoc de trong");
			}
			else
			{
				break;
			}
		} while (true);
		insertFirstLink(maCTr, tenCT);
	}
	
}
