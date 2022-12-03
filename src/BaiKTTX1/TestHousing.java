package BaiKTTX1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestHousing{
	

	public static List<Housing> list = new ArrayList<>();

	public static void addList() {
		Housing h1 = new Housing("HS01", "Nhà đất 1", 1000.5, 2, 7.5, "Tân Hội", "Đỗ Chiến");
		Housing h2 = new Housing("HS02", "Nhà đất 2", 900.5, 2, 8.5, "Tân Lập", "Đỗ Chiến");
		Housing h3 = new Housing("HS03", "Nhà đất 3", 800.5, 4, 9.5, "Liên Trung", "Đỗ Đỗ");
		Housing h4 = new Housing("HS04", "Nhà đất 4", 700.5, 7, 10.5, "Phùng", "Đỗ Chiến");
		Housing h5 = new Housing("HS05", "Nhà đất 5", 600.5, 1, 11.5, "Liên Hà", "Đỗ Công");
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);
		list.add(h5);
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		TestHousing.addList();
//		HousingManagerImpl hm = new HousingManagerImpl();
//		
//		do {
//			System.out.println("--------Menu---------");
//			System.out.println("1. Hiển thị danh sách BĐS");
//			System.out.println("2. Thêm 1 bất động sản");
//			System.out.println("3. Sửa một bất động sản");
//			System.out.println("4. Xoá 1 bất động sản");
//			System.out.println("5. Tìm kiếm bất động sản theo tên");
//			System.out.println("6. Tìm kiếm bất động sản theo giá");
//			System.out.println("7. Tìm kiếm bất động sản theo diện tích");
//			System.out.println("8. Tìm kiếm bất động sản theo chủ sở hữu");
//			System.out.println("9. Tìm kiếm bất động sản theo địa điểm");
//			System.out.println("10. Sắp xếp danh sách bất động sản theo giá");
//			System.out.println("11. Sắp xếp danh sách bất động sản theo diện tích");
//			System.out.println("0. Thoát chương trình");
//			System.out.printf("     Nhập lựa chọn của bạn: ");
//			int choose = sc.nextInt();
//			sc.nextLine();
//			switch (choose) {
//			case 1: {
//				hm.displayListHousing(list);
//				break;
//			}
//			case 2: {
//				Housing h = new Housing();
//				h.input();
//				if (!hm.checkExsistHousing(h, list)) {
//					hm.addHousing(h);
//					System.out.println("     Thêm BĐS thành công!");
//					hm.displayListHousing(list);
//				} else {
//					System.out.println("     Mã BĐS đã tồn tại!");
//				}
//				break;
//			}
//			case 3: {
//				System.out.print("     Nhập ID bất động sản cần sửa: ");
//				boolean check = false;
//				String id = sc.nextLine();
//				for (Housing hs : list) {
//					if (hs.getProduct_id().compareToIgnoreCase(id) == 0) {
//						check = true;
//						hm.editHousing(hs);
//						System.out.println("     Sửa BĐS thành công!");
//						hm.displayListHousing(list);
//						break;
//					}
//				}
//				if (!check) {
//					System.out.println("     Không tìm thấy BĐS cần sửa");
//				}
//				break;
//			}
//			case 4: {
//				System.out.print("     Nhập ID bất động sản cần xoá: ");
//				String id = sc.nextLine();
//				boolean check = false;
//				for (Housing hs : list) {
//					if (hs.getProduct_id().compareToIgnoreCase(id) == 0) {
//						check = true;
//						hm.delHousing(hs);
//						System.out.println("     Xoá thành công !");
//						hm.displayListHousing(list);
//						break;
//					}
//				}
//				if (!check) {
//					System.out.println("     Không tìm thấy BĐS cần xoá");
//				}
//				break;
//			}
//			case 5: {
//				System.out.print("     Nhập tên BĐS muốn tìm: ");
//				String name = sc.nextLine();
//				boolean check = false;
//				if (hm.searchHousingByName(name).size() > 0) {
//					check = true;
//					hm.displayListHousing(hm.searchHousingByName(name));
//					break;
//				}
//				if (!check) {
//					System.out.println("     Không tìm thấy tên BĐS");
//				}
//				break;
//			}
//			case 6: {
//				System.out.print("     Nhập giá BĐS muốn tìm: ");
//				double price = sc.nextDouble();
//				sc.nextLine();
//				boolean check = false;
//				if (hm.searchHousingByPrice(price).size() > 0) {
//					check = true;
//					hm.displayListHousing(hm.searchHousingByPrice(price));
//					break;
//				}
//				if (!check) {
//					System.out.println("     Không tìm thấy giá BĐS muốn tìm");
//				}
//				break;
//
//			}
//			case 7: {
//				System.out.print("     Nhập diện tích BĐS muốn tìm: ");
//				double area = sc.nextDouble();
//				sc.nextLine();
//				boolean check = false;
//				if (hm.searchHousingByArea(area).size() > 0) {
//					check = true;
//					hm.displayListHousing(hm.searchHousingByArea(area));
//					break;
//				}
//				if (!check) {
//					System.out.println("     Không tìm thấy diện tích BĐS muốn tìm");
//				}
//				break;
//
//			}
//			case 8: {
//				System.out.print("     Nhập chủ sở hữu BĐS muốn tìm: ");
//				String owner = sc.nextLine();
//				boolean check = false;
//				if (hm.searchHousingByOwner(owner).size() > 0) {
//					check = true;
//					hm.displayListHousing(hm.searchHousingByOwner(owner));
//					break;
//				}
//				if (!check) {
//					System.out.println("     Không tìm thấy chủ sở hữu BĐS muốn tìm");
//				}
//				break;
//			}
//			case 9: {
//				System.out.print("     Nhập địa điểm BĐS muốn tìm: ");
//				String location = sc.nextLine();
//				boolean check = false;
//				if (hm.searchHousingByLocation(location).size() > 0) {
//					check = true;
//					hm.displayListHousing(hm.searchHousingByLocation(location));
//					break;
//				}
//				if (!check) {
//					System.out.println("     Không tìm thấy địa điểm BĐS muốn tìm");
//				}
//				break;
//			}
//			case 10: {
//				System.out.print("     Nhập giá minimum: ");
//				double price = sc.nextDouble();
//				sc.nextLine();
//				List<Housing> housings = hm.sortedHousingByPrice(price, true);
//				if(housings.size() == 0) {
//					System.out.println("     Ko tìm thấy các Housing có giá minimum từ " + price);
//					break;
//				}
//				hm.displayListHousing(housings);					
//				break;
//
//			}
//			case 11: {
//				System.out.print("     Nhập diện tích minimum: ");
//				double area = sc.nextDouble();
//				sc.nextLine();
//				List<Housing> housings = hm.sortedHousingByArea(area, true);
//				if(housings.size() != 0) {
//					hm.displayListHousing(housings);					
//					break;
//				}
//				System.out.println("     Ko tìm thấy area minimum " + area);
//				break;
//			}
//			case 0: {
//				System.exit(0);
//				break;
//			}
//
//			}
//		} while (true);
//	}
	
	public static void main(String[] args) {
		List<Housing> list = TestHousing.generatedHousing(20);
		for(Housing hs : list) {
			System.out.println(hs.toString());
		}
		try {
			MyFile.binaryOutputFile(list);
			MyFile.binaryInputFile("Housing.bin", list.size());
		} catch (IOException | ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Housing> generatedHousing(int n) {
		String[] housingName = {"Căn hộ chung cư", "Nhà phố", "Đất nền", "Đất nghỉ dưỡng",
				"Đất xây nhà xưởng", "Đất nghĩa trang", "Condotel", "Officetel", "Shophouse"};
		String[] location = {"Hà Nội", "Cần Thơ", "Đà Nẵng", "Hải Phòng", "Bắc Ninh", "Đồng Nai", "Buôn Ma Thuột", "Đà Lạt",
				"Lâm Đồng", "Thanh Hoá", "An Giang", "Cà Mau", "Cao Bằng", "Bình Phước", "Bình Thuận", "Thành phố HCM", "Hà Nội", "Khánh Hoà"
				,"Kiên Giang", "Kon Tum", "Lạng Sơn", "Lào Cai", "Nam Định", "Nghệ An", "Ninh Bình", "Phú Thọ",
				"Phú Yên", "Quảng Bình", "Quảng Nam", "Sơn La", "Sóc Trăng", "Thái Bình", "Hà Nam",
				"Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};
		String[] firstNames = { "Anh", "Anh Tuấn", "Tuấn Anh", "Minh Anh", "Bảo", "Vân", "Hân", "Vũ", "Hùng", "Hải Anh",
				"Châu", "Châu Anh", "Minh Châu", "Linh", "Thuý", "Hồng", "Việt", "Nam", "Khải", "Huyền Anh", "Huy Anh",
				"Hưng", "Trang", "Yến", "Yến Anh" };
		String[] lastNames = { "Hoàng", "Nguyễn", "Lê", "Phan", "Phạm", "Vũ", "Đào", "Đoàn", "Linh", "Lương", "Ngô",
				"Mạnh", "Đỗ" };
		Housing[] list = new Housing[n];
		List<Housing> hs = Arrays.asList(list);
		for(int i = 0; i < n; i++) {
			list[i] = new Housing();
			list[i].setProduct_id("HS" + String.valueOf(i + 1));
			int indexName = (int) (Math.random() * housingName.length);
			int indexLocation = (int)(Math.random() * location.length);
			list[i].setProduct_name(housingName[indexName] + " " + location[indexLocation]);
			list[i].setProduct_price((int)(50000 + (int)(Math.random()*300000)));
			list[i].setProduct_total(1 + (int)(Math.random()*5));
			list[i].setArea((double)50 + (double)(Math.random()*300));
			list[i].setLocation(location[indexLocation]);
			int indexFirstName = (int)(Math.random() * firstNames.length);
			int indexLastName = (int)(Math.random() * lastNames.length);
			list[i].setOwner(lastNames[indexLastName] + " " + firstNames[indexFirstName]);
		}
		return hs;
	}
}
