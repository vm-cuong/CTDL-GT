package Khoa;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Doc {

	public static void main(String[] args) {
		try {
			// Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileInputStream fis = new FileInputStream("D:/Doc Ghi/Khoa.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Bước 2: Đọc dữ liệu
			String s = (String) ois.readObject();
			
			byte[] temp;
			temp = binaryToBytes(s);
			
			s = toUTF8(temp);
			System.out.println(s);
			

			fis.close();
			ois.close();
		} catch (Exception ex) {
			System.out.println("Loi doc file: " + ex);
		}

	}

	public static String binaryUnicodeToString(String binary) {

		byte[] array = ByteBuffer.allocate(4).putInt( // 4 bytes byte[]
				Integer.parseInt(binary, 2)).array();

		return new String(array, StandardCharsets.UTF_8);
	}
	
	public static byte[] binaryToBytes(String input) {
	    // TODO: Argument validation (nullity, length)
	    byte[] ret = new byte[input.length() / 8];
	    for (int i = 0; i < ret.length; i++) {
	        String chunk = input.substring(i * 8, i * 8 + 8);
	        ret[i] = (byte) Short.parseShort(chunk, 2);
	    }
	    return ret;
	}
	static String toUTF8(byte[] bytes) {
	    // TODO 
	    return new String(bytes, StandardCharsets.UTF_8);
	}

	}


