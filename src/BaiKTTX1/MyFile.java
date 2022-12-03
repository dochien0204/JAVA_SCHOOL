package BaiKTTX1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFile {

	public static void binaryOutputFile(List<Housing> list) throws IOException {
		
		FileOutputStream outFile = new FileOutputStream("Housing.bin");
		
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		
		out.writeInt(list.size());
		for(Housing hs : list) {
			out.writeObject(hs);
		}
		out.close();
	}
	
	public static List<Housing> binaryInputFile(String name, int n) throws IOException, ClassNotFoundException {
		// Xác định đối tượng tệp tin để xuất dữ liệu
		FileInputStream inFile = new FileInputStream(name);
		// Khai báo đối tượng thực hiện xuất
		ObjectInputStream in = new ObjectInputStream(inFile);

		in.readInt();
		List<Housing> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add((Housing) in.readObject());
		}
		in.close();
		return list;
	}
	
	public static int countObject() throws IOException {
		// Xác định đối tượng tệp tin để xuất dữ liệu
		FileInputStream inFile = new FileInputStream("Housing.bin");
		// Khai báo đối tượng thực hiện xuất
		ObjectInputStream in = new ObjectInputStream(inFile);
		int count = in.readInt();
		in.close();
		return count;
	}
	
	public static Housing findHousingInFile(String idChoose) {
		for(Housing hs : HousingGUI.list) {
			if(hs.getProduct_id().compareTo(idChoose) == 0) {
				return hs;
			}
		}
		return null;
	}
}
