package BaiKTTX1;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable{
	public static final String PRODUCT_ID = "No product_id";
	public static final String PRODUCT_NAME = "No product_name";
	public static final double PRODUCT_PRICE = 0.0d;
	public static final int PRODUCT_TOTAL = 0;

	private String product_id;
	private String product_name;
	private double product_price;
	private int product_total;

	public Product() {
		this(Product.PRODUCT_ID, Product.PRODUCT_NAME, Product.PRODUCT_PRICE, Product.PRODUCT_TOTAL);
	}

	public Product(String product_id, String product_name, double product_price, int product_total) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = product_total;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getProduct_total() {
		return product_total;
	}

	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}

	@Override
	public String toString() {
		return "product_id=" + product_id + ", product_name=" + product_name + ", product_price=" + product_price
				+ ", product_total=" + product_total + "]";
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập ID: ");
		product_id = sc.nextLine();
		System.out.println("Nhập Tên: ");
		product_name = sc.nextLine();
		System.out.println("Nhập giá: ");
		product_price = sc.nextDouble();
		System.out.println("Nhập số lượng: ");
		product_total = sc.nextInt();
		sc.nextLine();
	}

	public void output() {
		System.out.printf("%-10s%-10s%-30s%-15s%-15d", "", product_id, product_name,
				String.format("%.2f", product_price), product_total);
	}
}
