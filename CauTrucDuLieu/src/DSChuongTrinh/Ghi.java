package DSChuongTrinh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ghi {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("D:\\Doc Ghi\\ChuongTrinh.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		try {
			//
			Scanner scanner = new Scanner(System.in);
			DSChuongTrinh linkedlist = new DSChuongTrinh();
			ArrayList<Byte> st = new ArrayList<Byte>();
			String mactr, tenctr;
			boolean flag = true;
			while (flag == true) {
				do {
					System.out.println("Nhap Ma Chuong trinh: ");
					mactr = scanner.nextLine();
					if(mactr.length() == 0)
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
					tenctr = scanner.nextLine();
					if(tenctr.length() == 0)
					{
						System.out.println("Ma Chuong trinh khong duoc de trong");
					}
					else
					{
						break;
					}
				} while (true);
				linkedlist.insertFirstLink(mactr, tenctr);
				byte[] bt = linkedlist.toString().getBytes();
				for (int i = 0; i < bt.length; i++) {
					st.add(bt[i]);
				}
				System.out.println("Bạn có muốn nhập tiếp? (Y/N) ");
				String chooss = scanner.nextLine();
				if (chooss.equals("Y")) {
					flag = true;
				} else {
					flag = false;
				}

			}
			linkedlist.display();
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
