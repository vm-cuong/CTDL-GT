package Khoa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import DSChuongTrinh.DSChuongTrinh;

public class Ghi {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("D:\\Doc Ghi\\Khoa.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		try {
			//
			Scanner scanner = new Scanner(System.in);
			DSKhoa linkedlist = new DSKhoa();
			ArrayList<Byte> st = new ArrayList<Byte>();
			int maKhoa, namThanhLap;
			String tenKhoa;

			boolean flag = true;
			while (flag == true) {
				System.out.println("Nhập mã Khoa:");
				maKhoa = scanner.nextInt();
				scanner = new Scanner(System.in);
				System.out.println("Nhập tên Khoa:");
				tenKhoa = scanner.nextLine();
				System.out.println("Nhập năm thành lập: ");
				namThanhLap = scanner.nextInt();
				scanner.nextLine();
				
				linkedlist.add(maKhoa, tenKhoa, namThanhLap);
				
				
				
				System.out.println("Bạn có muốn nhập tiếp? (Y/N) ");
				String chooss = scanner.nextLine();
				if (chooss.equals("Y")) {
					flag = true;
				} else {
					flag = false;
				}

			}
			byte[] bt = linkedlist.toString(linkedlist.getRoot()).getBytes();
			for (int i = 0; i < bt.length; i++) {
				st.add(bt[i]);
			}

			String temp = "";
			for (byte scan : st) {
				String s1 = String.format("%8s", Integer.toBinaryString(scan & 0xFF)).replace(' ', '0');
				temp = temp + s1;

			}
			
			oos.writeObject(temp);

			System.out.println("Sucess");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
			oos.close();
		}
	}

}
