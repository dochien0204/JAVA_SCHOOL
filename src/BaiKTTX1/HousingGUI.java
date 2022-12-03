package BaiKTTX1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class HousingGUI extends JFrame {

	public static List<Housing> list = new ArrayList<>();
	private HousingManagerImpl housingManager = new HousingManagerImpl();
	Locale locale = new Locale("en", "EN");
    DecimalFormat decimalFormat = (DecimalFormat)NumberFormat
        .getNumberInstance(locale);
    private static String idChoose;

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textTotal;
	private JTextField textArea;
	private JTextField textLocation;
	private JTextField textOwner;
	private JTable table = new JTable();
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnReset;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_8;
	private JTextField textSearch;
	private JButton btnSearch;
	private JLabel lblNewLabel_9;
	private JComboBox cbSort;
	private JButton btnSort;
	private JComboBox cbIsNC;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HousingGUI frame = new HousingGUI();
					frame.setTitle("Quản lý Bất Động Sản");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public HousingGUI() throws ClassNotFoundException, IOException {
		initTable();
		list = MyFile.binaryInputFile("Housing.bin", MyFile.countObject());
		fillTable(list);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 817);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ BẤT ĐỘNG SẢN");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(293, 0, 387, 77);
		contentPane.add(lblNewLabel);

		lblNewLabel_2 = new JLabel("Số lượng BĐS");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(84, 169, 156, 31);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Tên Bất Động Sản");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(84, 83, 156, 31);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Giá BĐS ($)");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(84, 127, 156, 31);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Diện Tích (m²)");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(84, 211, 156, 31);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Địa Điểm");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(84, 253, 156, 31);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Chủ sở hữu");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(84, 295, 156, 31);
		contentPane.add(lblNewLabel_7);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(273, 81, 263, 35);
		contentPane.add(textName);

		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(273, 125, 263, 35);
		contentPane.add(textPrice);

		textTotal = new JTextField();
		textTotal.setColumns(10);
		textTotal.setBounds(273, 167, 263, 35);
		contentPane.add(textTotal);

		textArea = new JTextField();
		textArea.setColumns(10);
		textArea.setBounds(273, 209, 263, 35);
		contentPane.add(textArea);

		textLocation = new JTextField();
		textLocation.setColumns(10);
		textLocation.setBounds(273, 251, 263, 35);
		contentPane.add(textLocation);

		textOwner = new JTextField();
		textOwner.setColumns(10);
		textOwner.setBounds(273, 293, 263, 35);
		contentPane.add(textOwner);

		// event add
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkValidData()) {
					return;
				}
				Housing hs = new Housing();
				hs.setProduct_id("HS".concat(String.valueOf(list.size() + 1)));
				hs.setProduct_name(textName.getText().trim());
				hs.setProduct_price(Double.valueOf(textPrice.getText().trim()));
				hs.setProduct_total(Integer.valueOf(textTotal.getText().trim()));
				hs.setArea(Double.valueOf(textArea.getText().trim()));
				hs.setLocation(textLocation.getText().trim());
				hs.setOwner(textOwner.getText().trim());
				for(Housing housing : list) {
					if(hs.getProduct_name().compareTo(housing.getProduct_name()) == 0) {
						JOptionPane.showMessageDialog(contentPane, "BĐS đã tồn tại", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				housingManager.addHousing(hs);
				JOptionPane.showMessageDialog(contentPane, "Thêm BĐS thành công", "Successful", JOptionPane.PLAIN_MESSAGE);
				try {
					list = MyFile.binaryInputFile("Housing.bin", MyFile.countObject());
					fillTable(list);
					resetField();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(29, 353, 113, 35);
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkValidData()) {
					return;
				}
				int choice = JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc chắn cập nhật thông tin không?" ,"Hỏi",
						JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
					resetField();
					return;
				}
				for(Housing housing : list) {
					if(housing.getProduct_id().compareTo(idChoose) == 0) {
						housing.setProduct_id(idChoose);
						housing.setProduct_name(textName.getText().trim());
						housing.setProduct_price(Double.valueOf(textPrice.getText().trim()));
						housing.setProduct_total(Integer.valueOf(textTotal.getText().trim()));
						housing.setArea(Double.valueOf(textArea.getText().trim()));
						housing.setLocation(textLocation.getText().trim());
						housing.setOwner(textOwner.getText().trim());
						break;
					}
				}
	
				try {
					writeToFile();
					list = MyFile.binaryInputFile("Housing.bin", MyFile.countObject());
					fillTable(list);
					resetField();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "Sửa BĐS thành công", "Successful", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEdit.setBounds(152, 353, 113, 35);
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Xoá");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(contentPane, "Bạn chưa chọn BĐS để xoá", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int choice = JOptionPane.showConfirmDialog(contentPane, "Bạn có muốn xoá BĐS " + (String)table.getValueAt(row, 0),
						"Hỏi", JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
					return;
				}
				for(Housing hs : list) {
					if(hs.getProduct_id().compareTo((String)table.getValueAt(row, 0)) == 0) {
						housingManager.delHousing(hs);
						break;
					}
				}
				try {
					writeToFile();
					list = MyFile.binaryInputFile("Housing.bin", MyFile.countObject());
					fillTable(list);
					resetField();
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDelete.setBounds(289, 353, 113, 35);
		contentPane.add(btnDelete);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 413, 1023, 2);
		contentPane.add(separator);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textName.setText((String) table.getValueAt(row, 1));
				textPrice.setText(HousingGUI.formatString((String)table.getValueAt(row, 2)));
				textTotal.setText((String) table.getValueAt(row, 3));
				textArea.setText((String) table.getValueAt(row, 4));
				textLocation.setText((String) table.getValueAt(row, 5));
				textOwner.setText((String) table.getValueAt(row, 6));
				idChoose = (String)table.getValueAt(row, 0);
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 454, 953, 262);
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum());
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);		
		
		JButton btnExit = new JButton("Thoát chương trình");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnExit.setBounds(412, 736, 149, 31);
		contentPane.add(btnExit);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(423, 353, 113, 35);
		contentPane.add(btnReset);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(573, 83, 24, 305);
		contentPane.add(separator_1);
		
		lblNewLabel_1 = new JLabel("Tìm kiếm");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(598, 85, 98, 31);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.addItem(new ComboItem("Tìm kiếm theo tên", "name"));
		comboBox.addItem(new ComboItem("Tìm kiếm theo giá", "price"));
		comboBox.addItem(new ComboItem("Tìm kiếm theo diện tích", "area"));
		comboBox.addItem(new ComboItem("Tìm kiếm theo địa điểm", "location"));
		comboBox.addItem(new ComboItem("Tìm kiếm theo chủ sở hữu", "owner"));
		comboBox.setBounds(718, 85, 211, 31);
		contentPane.add(comboBox);
		
		lblNewLabel_8 = new JLabel("Nhập giá trị");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_8.setBounds(598, 127, 105, 31);
		contentPane.add(lblNewLabel_8);
		
		textSearch = new JTextField();
		textSearch.setBounds(718, 127, 211, 31);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				String value = ((ComboItem)item).getValue();
				List<Housing> listSearch = new ArrayList<>();
				if(textSearch.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(contentPane, "Bạn chưa nhập giá trị cần tìm kiếm", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String textInput = textSearch.getText().trim();
				if(value.compareTo("name") == 0) {
					 listSearch = housingManager.searchHousingByName(textSearch.getText());
				} else if(value.compareTo("price") == 0) {
					try {
						double price = Double.parseDouble(textInput);
						if(price <= 0) {
							JOptionPane.showMessageDialog(contentPane, "Giá phải lớn hơn 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
						listSearch = housingManager.searchHousingByPrice(price);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(contentPane, "Giá phải là số thực", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if(value.compareTo("area") == 0) {
					try {
						double area = Double.parseDouble(textInput);
						if(area <= 0) {
							JOptionPane.showMessageDialog(contentPane, "Diện tích phải lớn hơn 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
						listSearch = housingManager.searchHousingByArea(area);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(contentPane, "Giá phải là số thực", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (value.compareTo("owner") == 0) {
					listSearch = housingManager.searchHousingByOwner(textInput);
				} else if (value.compareTo("location") == 0) {
					listSearch = housingManager.searchHousingByLocation(textInput);
				}
				
				try {
					fillTable(listSearch);
					textSearch.setText("");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSearch.setBounds(718, 179, 113, 35);
		contentPane.add(btnSearch);
		
		lblNewLabel_9 = new JLabel("Sắp xếp");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setBounds(591, 259, 105, 31);
		contentPane.add(lblNewLabel_9);
		
		cbSort = new JComboBox();
		cbSort.addItem(new ComboItem("Sắp xếp theo giá", "price"));
		cbSort.addItem(new ComboItem("Sắp xếp theo diện tích", "area"));
		cbSort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbSort.setBounds(718, 259, 211, 31);
		contentPane.add(cbSort);
		
		btnSort = new JButton("Sắp xếp");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lấy ra table đang được hiển thị
				int totalRow = table.getRowCount();
				int totalColumn = table.getColumnCount();
				List<Housing> listSort = new ArrayList<>();
				for(int i = 0; i < totalRow; i++) {
					Housing hs = new Housing();
					hs.setProduct_id((String)table.getValueAt(i, 0));
					hs.setProduct_name((String)table.getValueAt(i, 1));
					hs.setProduct_price(Double.parseDouble(HousingGUI.formatString((String)table.getValueAt(i, 2))));
					hs.setProduct_total(Integer.parseInt((String)table.getValueAt(i, 3)));
					hs.setArea(Double.parseDouble((String)table.getValueAt(i, 4)));
					hs.setLocation((String)table.getValueAt(i, 5));
					hs.setOwner((String)table.getValueAt(i, 6));
					listSort.add(hs);
				}
				
				Object itemSort = cbSort.getSelectedItem();
				String valueSort = ((ComboItem)itemSort).getValue();
				
				Object itemIsNC = cbIsNC.getSelectedItem();
				String valueIsNC = ((ComboItem)itemIsNC).getValue();
				
				if(valueSort.compareTo("price") == 0) {
					if(valueIsNC.compareTo("asc") == 0) {
						Collections.sort(listSort, new sortedByPrice());
					} else {
						Collections.sort(listSort, new sortedByPrice().reversed());
					}
				} else {
					if(valueIsNC.compareTo("asc") == 0) {
						Collections.sort(listSort, new sortedByArea());
					} else {
						Collections.sort(listSort, new sortedByArea().reversed());
					}
				}
				
				try {
					fillTable(listSort);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSort.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSort.setBounds(718, 353, 113, 35);
		contentPane.add(btnSort);
		
		cbIsNC = new JComboBox();
		cbIsNC.addItem(new ComboItem("Tăng dần", "asc"));
		cbIsNC.addItem(new ComboItem("Giảm dần", "desc"));
		cbIsNC.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbIsNC.setBounds(718, 301, 138, 31);
		contentPane.add(cbIsNC);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(598, 224, 349, 2);
		contentPane.add(separator_2);
	} 

	private void initTable() {
		String[] columns = { "ID", "Tên BĐS", "Giá($)", "Số lượng", "Diện tích(m²)", "Địa điểm", "Chủ sở hữu" };
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
	}

	private void fillTable(List<Housing> list) throws ClassNotFoundException, IOException {
		tableModel.setRowCount(0);
		for (Housing hs : list) {
			tableModel.addRow(new String[] { hs.getProduct_id(), hs.getProduct_name(), decimalFormat.format(hs.getProduct_price()),
					"" + hs.getProduct_total(),String.format("%.2f",hs.getArea()), hs.getLocation(), hs.getOwner() });
		}
		table.setRowHeight(30);
		
		//Can giua cac cot trong table
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
 
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
        table.setAutoCreateRowSorter(true);
		tableModel.fireTableDataChanged();
	}
	
	public static String formatString(String s) {
		String str[]  = s.split("");
		StringBuilder newString = new StringBuilder();
		for(int i = 0; i < str.length; i++) {
			if(str[i].compareTo(",") != 0) {
				newString.append(str[i]);
			}
		}
		return newString.toString();
	}
	
	public boolean checkValidData() {
		if(!validateEmtyField()) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		try {
			double price = Double.parseDouble(textPrice.getText());
			if(price <= 0) {
				sb.append("Giá phải lớn hơn 0");
			}
			
		} catch(Exception ex) {
			sb.append("Giá phải là kiểu số thực");
		}
		try {
			int total = Integer.parseInt(textTotal.getText());
			if(total <= 0) {
				sb.append("Số lượng lớn hơn 0");
			}
			
		} catch(Exception ex) {
			sb.append("Số lượng phải là kiểu số nguyên");
		}
		try {
			double area = Double.parseDouble(textArea.getText());
			if(area < 0) {
				sb.append("Diện tích phải lớn hơn 0");
			}
			
		} catch(Exception ex) {
			sb.append("Diện tích phải là kiểu số thực");
		}
		if(sb.length() > 0 ) {
			JOptionPane.showMessageDialog(contentPane, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean validateEmtyField() {
		StringBuilder sb = new StringBuilder();
		if(textName.getText().equals("")) {
			sb.append("Tên BĐS không được để trống \n");
		}
		if(textPrice.getText().equals("")) {
			sb.append("Giá BĐS không được để trống \n");
		}
		if(textTotal.getText().equals("")) {
			sb.append("Số lượng không được để trống \n");
		}
		if(textArea.getText().equals("")) {
			sb.append("Diện tích không được để trống \n");
		}
		if(textLocation.getText().equals("")) {
			sb.append("Địa điểm không được để trống \n");
		}
		if(textOwner.getText().equals("")) {
			sb.append("Chủ sở hữu không được để trống \n");
		}
		if(sb.length() > 0 ) {
			JOptionPane.showMessageDialog(contentPane, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void resetField() {
		textName.setText("");
		textPrice.setText("");
		textTotal.setText("");
		textArea.setText("");
		textLocation.setText("");
		textOwner.setText("");
		textSearch.setText("");
	}
	
	public void resetAll() {
		resetField();
		try {
			fillTable(list);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeToFile() throws IOException {
		MyFile.binaryOutputFile(list);
	}
}

