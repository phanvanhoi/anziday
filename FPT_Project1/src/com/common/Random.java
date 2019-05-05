package com.common;

public class Random {

	public final static int STR_NUMBER = 1;
	public final static int STR_UPPER_CASE = 2;
	public final static int STR_LOWER_CASE = 4;

	private final static String NUMBERS = "0123456789";
	private final static String ALPHABE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	//TreatmentAreaDAO treatDAO = new TreatmentAreaDAO();
	
	private String input = new String(" ");

	public Random(int mode) {
		if ((mode & STR_NUMBER) != 0) {
			input += NUMBERS;
		}
		if ((mode & STR_UPPER_CASE) != 0) {
			input += ALPHABE;
		}
		if ((mode & STR_LOWER_CASE) != 0 || input.isEmpty()) {
			input += ALPHABE.toLowerCase();
		}
	}

	public Random() {
		
	}
	public String next(int length) {
		String string = new String();
		final int max = input.length();
		for (int i = 0; i < length; i++) {
			string += input.charAt(((int) (Math.random() * 1000)) % max);
		}
		return string;
	}

	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public String soDienThoai(int lenght) {
		String s = "0";
		for (int i = 0; i < lenght - 1; i++) {
			s += NUMBERS.charAt(createRandomIntBetween(0, 9));
		}
		return s;
	}

	private String[] ho = { "An", "Ánh", "Ân", "Âu Dương", "Ấu", "Bá", "Bạc", "Bạch", "Bàn", "Bàng", "Bành", "Bảo",
			"Bế", "Bì", "Biện", "Bình", "Bồ", "Ca", "Cái", "Cam", "Cảnh", "Cao", "Cáp", "Cát", "Cầm", "Cấn", "Chế",
			"Chiêm", "Châu", "Chung", "Chúng", "Chương", "Trử", "Cồ", "Cổ", "Công", "Cống", "Cung", "Cù", "Cự", "Dã",
			"Danh", "Diêm", "Diệp", "Doãn", "Dư", "Đồ", "Đàm", "Đan", "Đào", "Đậu", "Điền", "Đinh", "Điêu", "Đoàn",
			"Đôn", "Đồng", "Đổng", "Đới", "Đức", "Đường", "Giả", "Giao", "Giang", "Giàng", "Giáp", "Hà", "Hạ", "Hàn",
			"Hán", "Hi", "Hình", "Hoa", "Hồng", "Hùng", "Hứa", "Hướng", "Kiểu", "Kha", "Khương", "Khâu", "Khiếu",
			"Khoa", "Khổng", "Khu", "Khuất", "Khúc", "Kiều", "Kim", "La", "Lạc", "Lại", "Lâm", "Lều", "Lãnh", "Liêu",
			"Liễu", "Lò", "Lỗ", "Luyện", "Lục", "Lư", "Lữ", "Lương", "Lý", "Ma", "Mã", "Mạc", "Mạch", "Mai", "Mang",
			"Mâu", "Mẫn", "Mộc", "Nhan", "Ninh", "Nhâm", "Ngân", "Nghiêm", "Nghị", "Ngọ", "Ngọc", "Ngụy", "Nhữ", "Nông",
			"Ong", "Ông", "Phi", "Phí", "Phó", "Phú", "Phùng", "Phương", "Quản", "Quàng", "Quách", "Sầm", "Sơn", "Sử",
			"Thang", "Tạ", "Tào", "Tán", "Tăng", "Thạch", "Thái", "Thành", "	Thào", "Thẩm", "Thân", "Thập", "Thi",
			"Thiều", "Thịnh", "Thoa", "Thôi", "Tiêu", "Tiếp", "Tòng", "Tô", "Tôn", "Tông", "Tống", "Trang", "Trà",
			"Trác", "Tri", "Triệu", "Trịnh", "Trình", "Trưng", "Trương", "Từ", "Ti", "Uông", "Ung", "Ưng", "Ứng", "Văn",
			"Vi", "Viên", "Vưu", "Vương", "Xung", "Xa", "Yên" };
	private String[] ten = { "An Cơ", "An Khang", "Ân Lai", "An Nam", "An Nguyên", "An Ninh", "An Tâm", "Ân Thiện",
			"An Tường", "Anh Ðức", "Anh Dũng", "Anh Duy", "Anh Hoàng", "Anh Khải", "Anh Khoa", "Anh Khôi", "Anh Minh",
			"Anh Quân", "Anh Quốc", "Anh Sơn", "Anh Tài", "Anh Thái", "Anh Tú", "Anh Tuấn", "Anh Tùng", "Anh Việt",
			"Anh Vũ", "Bá Cường", "Bá Kỳ", "Bá Lộc", "Bá Long", "Bá Phước", "Bá Thành", "Bá Thiện", "Bá Thịnh",
			"Bá Thúc", "Bá Trúc", "Bá Tùng", "Bách Du", "Bách Nhân", "Bằng Sơn", "Bảo An", "Bảo Bảo", "Bảo Chấn",
			"Bảo Ðịnh", "Bảo Duy", "Bảo Giang", "Bảo Hiển", "Bảo Hoa", "Bảo Hoàng", "Bảo Huy", "Bảo Huynh", "Bảo Huỳnh",
			"Bảo Khánh", "Bảo Lâm", "Bảo Long", "Bảo Pháp", "Bảo Quốc", "Bảo Sơn", "Bảo Thạch", "Bảo Thái", "Bảo Tín",
			"Bảo Toàn", "Bích Nhã", "Bình An", "Bình Dân", "Bình Ðạt", "Bình Ðịnh", "Bình Dương", "Bình Hòa",
			"Bình Minh", "Bình Nguyên", "Bình Quân", "Bình Thuận", "Bình Yên", "Bửu Chưởng", "Bửu Diệp", "Bữu Toại",
			"Cảnh Tuấn", "Cao Kỳ", "Cao Minh", "Cao Nghiệp", "Cao Nguyên", "Cao Nhân", "Cao Phong", "Cao Sĩ", "Cao Sơn",
			"Cao Sỹ", "Cao Thọ", "Cao Tiến", "Cát Tường", "Cát Uy", "Chấn Hùng", "Chấn Hưng", "Chấn Phong",
			"Chánh Việt", "Chế Phương", "Chí Anh", "Chí Bảo", "Chí Công", "Chí Dũng", "Chí Giang", "Chí Hiếu",
			"Chí Khang", "Chí Khiêm", "Chí Kiên", "Chí Nam", "Chí Sơn", "Chí Thanh", "Chí Thành", "Chiến Thắng",
			"Chiêu Minh", "Chiêu Phong", "Chiêu Quân", "Chính Tâm", "Chính Thuận", "Chính Trực", "Chuẩn Khoa",
			"Chung Thủy", "Chung Tình", "Công Anh", "Công Án", "Công Ân", "Công Bằng", "Công Giang", "Công Hải",
			"Công Hào", "Công Hậu", "Công Hiếu", "Công Hoán", "Công Lập", "Công Lộc", "Công Luận", "Công Luật",
			"Công Lý", "Công Phụng", "Công Sinh", "Công Sơn", "Công Sửu", "Công Thành", "Công Tráng", "Công Tuấn",
			"Cường Dũng", "Cương Nghị", "Cương Quyết", "Cường Thịnh", "Ðắc Cường", "Ðắc Di", "Ðắc Lộ", "Ðắc Lực",
			"Ðắc Thái", "Ðắc Thành", "Ðắc Trọng", "Ðại Dương", "Ðại Hành", "Ðại Ngọc", "Ðại Thống", "Dân Hiệp",
			"Dân Khánh", "Ðan Quế", "Ðan Tâm", "Ðăng An", "Ðăng Ðạt", "Ðăng Khánh", "Ðăng Khoa", "Đăng Khương",
			"Ðăng Minh", "Đăng Quang", "Danh Nhân", "Danh Sơn", "Danh Thành", "Danh Văn", "Ðạt Dũng", "Ðạt Hòa",
			"Đình Bình", "Ðình Chiểu", "Ðình Chương", "Ðình Cường", "Ðình Diệu", "Ðình Ðôn", "Ðình Dương", "Ðình Hảo",
			"Ðình Hợp", "Đình Khải", "Ðình Kim", "Ðinh Lộc", "Ðình Lộc", "Ðình Luận", "Ðịnh Lực", "Ðình Nam",
			"Ðình Ngân", "Ðình Nguyên", "Ðình Nhân", "Ðình Phú", "Ðình Phúc", "Ðình Quảng", "Ðình Sang", "Ðịnh Siêu",
			"Ðình Thắng", "Ðình Thiện", "Ðình Toàn", "Ðình Trung", "Ðình Tuấn", "Ðoàn Tụ", "Ðồng Bằng", "Ðông Dương",
			"Ðông Hải", "Ðồng Khánh", "Ðông Nguyên", "Ðông Phong", "Ðông Phương", "Ðông Quân", "Ðông Sơn", "Ðức Ân",
			"Ðức Anh", "Ðức Bằng", "Ðức Bảo", "Ðức Bình", "Ðức Chính", "Ðức Duy", "Ðức Giang", "Ðức Hải", "Ðức Hạnh",
			"Đức Hòa", "Ðức Hòa", "Ðức Huy", "Ðức Khải", "Đức Khoa", "Ðức Khang", "Ðức Khiêm", "Ðức Kiên", "Ðức Long",
			"Ðức Mạnh", "Ðức Minh", "Ðức Nhân", "Ðức Phi", "Ðức Phong", "Ðức Phú", "Ðức Quang", "Ðức Quảng",
			"Ðức Quyền", "Ðức Siêu", "Ðức Sinh", "Ðức Tài", "Ðức Tâm", "Ðức Thắng", "Ðức Thành", "Ðức Thọ", "Ðức Toàn",
			"Ðức Toản", "Ðức Trí", "Ðức Trung", "Ðức Tuấn", "Ðức Tuệ", "Ðức Tường", "Dũng Trí", "Dũng Việt",
			"Dương Anh", "Dương Khánh", "Duy An", "Duy Bảo", "Duy Cẩn", "Duy Cường", "Duy Hải", "Duy Hiền", "Duy Hiếu",
			"Duy Hoàng", "Duy Hùng", "Duy Khang", "Duy Khánh", "Duy Khiêm", "Duy Kính", "Duy Luận", "Duy Mạnh",
			"Duy Minh", "Duy Ngôn", "Duy Nhượng", "Duy Quang", "Duy Tâm", "Duy Tân", "Duy Thạch", "Duy Thắng",
			"Duy Thanh", "Duy Thành", "Duy Thông", "Duy Tiếp", "Duy Tuyền", "Gia Ân", "Gia Anh", "Gia Bạch", "Gia Bảo",
			"Gia Bình", "Gia Cần", "Gia Cẩn", "Gia Cảnh", "Gia Ðạo", "Gia Ðức", "Gia Hiệp", "Gia Hòa", "Gia Hoàng",
			"Gia Huấn", "Gia Hùng", "Gia Hưng", "Gia Huy", "Gia Khánh", "Gia Khiêm", "Gia Kiên", "Gia Kiệt", "Gia Lập",
			"Gia Minh", "Gia Nghị", "Gia Phong", "Gia Phúc", "Gia Phước", "Gia Thiện", "Gia Thịnh", "Gia Uy",
			"Gia Vinh", "Giang Lam", "Giang Nam", "Giang Sơn", "Giang Thiên", "Hà Hải", "Hải Bằng", "Hải Bình",
			"Hải Ðăng", "Hải Dương", "Hải Giang", "Hải Hà", "Hải Long", "Hải Lý", "Hải Nam", "Hải Nguyên", "Hải Phong",
			"Hải Quân", "Hải Sơn", "Hải Thụy", "Hán Lâm", "Hạnh Tường", "Hào Nghiệp", "Hạo Nhiên", "Hiền Minh",
			"Hiệp Dinh", "Hiệp Hà", "Hiệp Hào", "Hiệp Hiền", "Hiệp Hòa", "Hiệp Vũ", "Hiếu Dụng", "Hiếu Học", "Hiểu Lam",
			"Hiếu Liêm", "Hiếu Nghĩa", "Hiếu Phong", "Hiếu Thông", "Hồ Bắc", "Hồ Nam", "Hòa Bình", "Hòa Giang",
			"Hòa Hiệp", "Hòa Hợp", "Hòa Lạc", "Hòa Thái", "Hoài Bắc", "Hoài Nam", "Hoài Phong", "Hoài Thanh",
			"Hoài Tín", "Hoài Trung", "Hoài Việt", "Hoài Vỹ", "Hoàn Kiếm", "Hoàn Vũ", "Hoàng Ân", "Hoàng Duệ",
			"Hoàng Dũng", "Hoàng Giang", "Hoàng Hải", "Hoàng Hiệp", "Hoàng Khải", "Hoàng Khang", "Hoàng Khôi",
			"Hoàng Lâm", "Hoàng Linh", "Hoàng Long", "Hoàng Minh", "Hoàng Mỹ", "Hoàng Nam", "Hoàng Ngôn", "Hoàng Phát",
			"Hoàng Quân", "Hoàng Thái", "Hoàng Tùng", "Hoàng Việt", "Hoàng Xuân", "Hồng Ðăng", "Hồng Đức", "Hồng Giang",
			"Hồng Lân", "Hồng Liêm", "Hồng Lĩnh", "Hồng Minh", "Hồng Nhật", "Hồng Nhuận", "Hồng Phát", "Hồng Quang",
			"Hồng Quý", "Hồng Sơn", "Hồng Thịnh", "Hồng Thụy", "Hồng Việt", "Hồng Vinh", "Huân Võ", "Hùng Anh",
			"Hùng Cường", "Hưng Ðạo", "Hùng Dũng", "Hùng Ngọc", "Hùng Phong", "Hùng Sơn", "Hùng Thịnh", "Hùng Tường",
			"Hướng Bình", "Hướng Dương", "Hướng Thiện", "Hướng Tiền", "Hữu Bào", "Hữu Bảo", "Hữu Bình", "Hữu Canh",
			"Hữu Cảnh", "Hữu Châu", "Hữu Chiến", "Hữu Cương", "Hữu Cường", "Hữu Ðạt", "Hữu Ðịnh", "Hữu Hạnh",
			"Hữu Hiệp", "Hữu Hoàng", "Hữu Hùng", "Hữu Khang", "Hữu Khanh", "Hữu Khoát", "Hữu Khôi", "Hữu Long",
			"Hữu Lương", "Hữu Minh", "Hữu Nam", "Hữu Nghị", "Hữu Nghĩa", "Hữu Phước", "Hữu Tài", "Hữu Tâm", "Hữu Tân",
			"Hữu Thắng", "Hữu Thiện", "Hữu Thọ", "Hữu Thống", "Hữu Thực", "Hữu Toàn", "Hữu Trác", "Hữu Trí",
			"Hữu Trung", "Hữu Từ", "Hữu Tường", "Hữu Vĩnh", "Hữu Vượng", "Huy Anh", "Huy Chiểu", "Huy Hà", "Huy Hoàng",
			"Huy Kha", "Huy Khánh", "Huy Khiêm", "Huy Lĩnh", "Huy Phong", "Huy Quang", "Huy Thành", "Huy Thông",
			"Huy Trân", "Huy Tuấn", "Huy Tường", "Huy Việt", "Huy Vũ", "Khắc Anh", "Khắc Công", "Khắc Dũng", "Khắc Duy",
			"Khắc Kỷ", "Khắc Minh", "Khắc Ninh", "Khắc Thành", "Khắc Triệu", "Khắc Trọng", "Khắc Tuấn", "Khắc Việt",
			"Khắc Vũ", "Khải Ca", "Khải Hòa", "Khai Minh", "Khải Tâm", "Khải Tuấn", "Khang Kiện", "Khánh An",
			"Khánh Bình", "Khánh Ðan", "Khánh Duy", "Khánh Giang", "Khánh Hải", "Khánh Hòa", "Khánh Hoàn",
			"Khánh Hoàng", "Khánh Hội", "Khánh Huy", "Khánh Minh", "Khánh Nam", "Khánh Văn", "Khoa Trưởng",
			"Khôi Nguyên", "Khởi Phong", "Khôi Vĩ", "Khương Duy", "Khuyến Học", "Kiên Bình", "Kiến Bình", "Kiên Cường",
			"Kiến Ðức", "Kiên Giang", "Kiên Lâm", "Kiên Trung", "Kiến Văn", "Kiệt Võ", "Kim Ðan", "Kim Hoàng",
			"Kim Long", "Kim Phú", "Kim Sơn", "Kim Thịnh", "Kim Thông", "Kim Toàn", "Kim Vượng", "Kỳ Võ", "Lạc Nhân",
			"Lạc Phúc", "Lâm Ðồng", "Lâm Dũng", "Lam Giang", "Lam Phương", "Lâm Trường", "Lâm Tường", "Lâm Viên",
			"Lâm Vũ", "Lập Nghiệp", "Lập Thành", "Liên Kiệt", "Long Giang", "Long Quân", "Long Vịnh", "Lương Quyền",
			"Lương Tài", "Lương Thiện", "Lương Tuyền", "Mạnh Cương", "Mạnh Cường", "Mạnh Ðình", "Mạnh Dũng",
			"Mạnh Hùng", "Mạnh Nghiêm", "Mạnh Quỳnh", "Mạnh Tấn", "Mạnh Thắng", "Mạnh Thiện", "Mạnh Trình",
			"Mạnh Trường", "Mạnh Tuấn", "Mạnh Tường", "Minh Ân", "Minh Anh", "Minh Cảnh", "Minh Dân", "Minh Ðan",
			"Minh Danh", "Minh Ðạt", "Minh Ðức", "Minh Dũng", "Minh Giang", "Minh Hải", "Minh Hào", "Minh Hiên",
			"Minh Hiếu", "Minh Hòa", "Minh Hoàng", "Minh Huấn", "Minh Hùng", "Minh Hưng", "Minh Huy", "Minh Hỷ",
			"Minh Khang", "Minh Khánh", "Minh Khiếu", "Minh Khôi", "Minh Kiệt", "Minh Kỳ", "Minh Lý", "Minh Mẫn",
			"Minh Nghĩa", "Minh Nhân", "Minh Nhật", "Minh Nhu", "Minh Quân", "Minh Quang", "Minh Quốc", "Minh Sơn",
			"Minh Tân", "Minh Thạc", "Minh Thái", "Minh Thắng", "Minh Thiện", "Minh Thông", "Minh Thuận", "Minh Tiến",
			"Minh Toàn", "Minh Trí", "Minh Triết", "Minh Triệu", "Minh Trung", "Minh Tú", "Minh Tuấn", "Minh Vu",
			"Minh Vũ", "Minh Vương", "Mộng Giác", "Mộng Hoàn", "Mộng Lâm", "Mộng Long", "Nam An", "Nam Dương",
			"Nam Hải", "Nam Hưng", "Nam Lộc", "Nam Nhật", "Nam Ninh", "Nam Phi", "Nam Phương", "Nam Sơn", "Nam Thanh",
			"Nam Thông", "Nam Tú", "Nam Việt", "Nghị Lực", "Nghị Quyền", "Nghĩa Dũng", "Nghĩa Hòa", "Ngọc Ẩn",
			"Ngọc Cảnh", "Ngọc Cường", "Ngọc Danh", "Ngọc Đại", "Ngọc Ðoàn", "Ngọc Dũng", "Ngọc Hải", "Ngọc Hiển",
			"Ngọc Huy", "Ngọc Khang", "Ngọc Khôi", "Ngọc Khương", "Ngọc Lai", "Ngọc Lân", "Ngọc Minh", "Ngọc Ngạn",
			"Ngọc Quang", "Ngọc Sơn", "Ngọc Thạch", "Ngọc Thiện", "Ngọc Thọ", "Ngọc Thuận", "Ngọc Tiển", "Ngọc Trụ",
			"Ngọc Tuấn", "Nguyên Bảo", "Nguyên Bổng", "Nguyên Ðan", "Nguyên Giang", "Nguyên Giáp", "Nguyễn Hải An",
			"Nguyên Hạnh", "Nguyên Khang", "Nguyên Khôi", "Nguyên Lộc", "Nguyên Nhân", "Nguyên Phong", "Nguyên Sử",
			"Nguyên Văn", "Nhân Nguyên", "Nhân Sâm", "Nhân Từ", "Nhân Văn", "Nhật Bảo Long", "Nhật Dũng", "Nhật Duy",
			"Nhật Hòa", "Nhật Hoàng", "Nhật Hồng", "Nhật Hùng", "Nhật Huy", "Nhật Khương", "Nhật Minh", "Nhật Nam",
			"Nhật Quân", "Nhật Quang", "Nhật Quốc", "Nhật Tấn", "Nhật Thịnh", "Nhất Tiến", "Nhật Tiến", "Như Khang",
			"Niệm Nhiên", "Phi Cường", "Phi Ðiệp", "Phi Hải", "Phi Hoàng", "Phi Hùng", "Phi Long", "Phi Nhạn",
			"Phong Châu", "Phong Dinh", "Phong Ðộ", "Phú Ân", "Phú Bình", "Phú Hải", "Phú Hiệp", "Phú Hùng", "Phú Hưng",
			"Phú Thịnh", "Phú Thọ", "Phú Thời", "Phúc Cường", "Phúc Ðiền", "Phúc Duy", "Phúc Hòa", "Phúc Hưng",
			"Phúc Khang", "Phúc Lâm", "Phục Lễ", "Phúc Nguyên", "Phúc Sinh", "Phúc Tâm", "Phúc Thịnh", "Phụng Việt",
			"Phước An", "Phước Lộc", "Phước Nguyên", "Phước Nhân", "Phước Sơn", "Phước Thiện", "Phượng Long",
			"Phương Nam", "Phương Phi", "Phương Thể", "Phương Trạch", "Phương Triều", "Quân Dương", "Quang Anh",
			"Quang Bửu", "Quảng Ðại", "Quang Danh", "Quang Ðạt", "Quảng Ðạt", "Quang Ðức", "Quang Dũng", "Quang Dương",
			"Quang Hà", "Quang Hải", "Quang Hòa", "Quang Hùng", "Quang Hưng", "Quang Hữu", "Quang Huy", "Quang Khải",
			"Quang Khanh", "Quang Lâm", "Quang Lân", "Quang Linh", "Quang Lộc", "Quang Minh", "Quang Nhân",
			"Quang Nhật", "Quang Ninh", "Quang Sáng", "Quang Tài", "Quang Thạch", "Quang Thái", "Quang Thắng",
			"Quang Thiên", "Quang Thịnh", "Quảng Thông", "Quang Thuận", "Quang Triều", "Quang Triệu", "Quang Trọng",
			"Quang Trung", "Quang Trường", "Quang Tú", "Quang Tuấn", "Quang Vinh", "Quang Vũ", "Quang Xuân", "Quốc Anh",
			"Quốc Bảo", "Quốc Bình", "Quốc Ðại", "Quốc Ðiền", "Quốc Hải", "Quốc Hạnh", "Quốc Hiền", "Quốc Hiển",
			"Quốc Hòa", "Quốc Hoài", "Quốc Hoàng", "Quốc Hùng", "Quốc Hưng", "Quốc Huy", "Quốc Khánh", "Quốc Mạnh",
			"Quốc Minh", "Quốc Mỹ", "Quốc Phong", "Quốc Phương", "Quốc Quân", "Quốc Quang", "Quốc Quý", "Quốc Thắng",
			"Quốc Thành", "Quốc Thiện", "Quốc Thịnh", "Quốc Thông", "Quốc Tiến", "Quốc Toản", "Quốc Trụ", "Quốc Trung",
			"Quốc Trường", "Quốc Tuấn", "Quốc Văn", "Quốc Việt", "Quốc Vinh", "Quốc Vũ", "Quý Khánh", "Quý Vĩnh",
			"Quyết Thắng", "Sĩ Hoàng", "Sơn Dương", "Sơn Giang", "Sơn Hà", "Sơn Hải", "Sơn Lâm", "Sơn Quân",
			"Sơn Quyền", "Sơn Trang", "Sơn Tùng", "Song Lam", "Sỹ Ðan", "Sỹ Hoàng", "Sỹ Phú", "Sỹ Thực", "Tạ Hiền",
			"Tài Ðức", "Tài Nguyên", "Tâm Thiện", "Tân Bình", "Tân Ðịnh", "Tấn Dũng", "Tấn Khang", "Tấn Lợi",
			"Tân Long", "Tấn Nam", "Tấn Phát", "Tân Phước", "Tấn Sinh", "Tấn Tài", "Tân Thành", "Tấn Thành",
			"Tấn Trình", "Tấn Trương", "Tất Bình", "Tất Hiếu", "Tất Hòa", "Thạch Sơn", "Thạch Tùng", "Thái Bình",
			"Thái Ðức", "Thái Dương", "Thái Duy", "Thái Hòa", "Thái Minh", "Thái Nguyên", "Thái San", "Thái Sang",
			"Thái Sơn", "Thái Tân", "Thái Tổ", "Thắng Cảnh", "Thắng Lợi", "Thăng Long", "Thành An", "Thành Ân",
			"Thành Châu", "Thành Công", "Thành Danh", "Thanh Ðạo", "Thành Ðạt", "Thành Ðệ", "Thanh Ðoàn", "Thành Doanh",
			"Thanh Hải", "Thanh Hào", "Thanh Hậu", "Thành Hòa", "Thanh Huy", "Thành Khiêm", "Thanh Kiên", "Thanh Liêm",
			"Thành Lợi", "Thanh Long", "Thành Long", "Thanh Minh", "Thành Nguyên", "Thành Nhân", "Thanh Phi",
			"Thanh Phong", "Thành Phương", "Thanh Quang", "Thành Sang", "Thanh Sơn", "Thanh Thế", "Thanh Thiên",
			"Thành Thiện", "Thanh Thuận", "Thành Tín", "Thanh Tịnh", "Thanh Toàn", "Thanh Toản", "Thanh Trung",
			"Thành Trung", "Thanh Tú", "Thanh Tuấn", "Thanh Tùng", "Thanh Việt", "Thanh Vinh", "Thành Vinh", "Thanh Vũ",
			"Thành Ý", "Thất Cương", "Thất Dũng", "Thất Thọ", "Thế An", "Thế Anh", "Thế Bình", "Thế Dân", "Thế Doanh",
			"Thế Dũng", "Thế Duyệt", "Thế Huấn", "Thế Hùng", "Thế Lâm", "Thế Lực", "Thế Minh", "Thế Năng", "Thế Phúc",
			"Thế Phương", "Thế Quyền", "Thế Sơn", "Thế Trung", "Thế Tường", "Thế Vinh", "Thiên An", "Thiên Ân",
			"Thiện Ân", "Thiên Bửu", "Thiên Ðức", "Thiện Ðức", "Thiện Dũng", "Thiện Giang", "Thiên Hưng", "Thiện Khiêm",
			"Thiên Lạc", "Thiện Luân", "Thiên Lương", "Thiện Lương", "Thiên Mạnh", "Thiện Minh", "Thiện Ngôn",
			"Thiên Phú", "Thiện Phước", "Thiện Sinh", "Thiện Tâm", "Thiện Thanh", "Thiện Thuật", "Thiện Tính",
			"Thiên Trí", "Thiếu Anh", "Thiệu Bảo", "Thiếu Cường", "Thịnh Cường", "Thời Nhiệm", "Thông Ðạt",
			"Thông Minh", "Thống Nhất", "Thông Tuệ", "Thụ Nhân", "Thu Sinh", "Thuận Anh", "Thuận Hòa", "Thuận Phong",
			"Thuận Phương", "Thuận Thành", "Thuận Toàn", "Thượng Cường", "Thượng Khang", "Thường Kiệt", "Thượng Liệt",
			"Thượng Năng", "Thượng Nghị", "Thượng Thuật", "Thường Xuân", "Thụy Du", "Thụy Long", "Thụy Miên", "Thụy Vũ",
			"Tích Ðức", "Tích Thiện", "Tiến Ðức", "Tiến Dũng", "Tiền Giang", "Tiến Hiệp", "Tiến Hoạt", "Tiến Võ",
			"Tiểu Bảo", "Toàn Thắng", "Tôn Lễ", "Trí Dũng", "Trí Hào", "Trí Hùng", "Trí Hữu", "Trí Liên", "Trí Minh",
			"Trí Thắng", "Trí Tịnh", "Triển Sinh", "Triệu Thái", "Triều Thành", "Trọng Chính", "Trọng Dũng",
			"Trọng Duy", "Trọng Hà", "Trọng Hiếu", "Trọng Hùng", "Trọng Khánh", "Trọng Kiên", "Trọng Nghĩa",
			"Trọng Nhân", "Trọng Tấn", "Trọng Trí", "Trọng Tường", "Trọng Việt", "Trọng Vinh", "Trúc Cương",
			"Trúc Sinh", "Trung Anh", "Trung Chính", "Trung Chuyên", "Trung Ðức", "Trung Dũng", "Trung Hải",
			"Trung Hiếu", "Trung Kiên", "Trung Lực", "Trung Nghĩa", "Trung Nguyên", "Trung Nhân", "Trung Thành",
			"Trung Thực", "Trung Việt", "Trường An", "Trường Chinh", "Trường Giang", "Trường Hiệp", "Trường Kỳ",
			"Trường Liên", "Trường Long", "Trường Nam", "Trường Nhân", "Trường Phát", "Trường Phu", "Trường Phúc",
			"Trường Sa", "Trường Sinh", "Trường Sơn", "Trường Thành", "Trường Thịnh", "Trường Vinh", "Trường Vũ",
			"Từ Ðông", "Tuấn Anh", "Tuấn Châu", "Tuấn Chương", "Tuấn Ðức", "Tuấn Dũng", "Tuấn Hải", "Tuấn Hoàng",
			"Tuấn Hùng", "Tuấn Khải", "Tuấn Khanh", "Tuấn Khoan", "Tuấn Kiệt", "Tuấn Linh", "Tuấn Long", "Tuấn Minh",
			"Tuấn Ngọc", "Tuấn Sĩ", "Tuấn Sỹ", "Tuấn Tài", "Tuấn Thành", "Tuấn Trung", "Tuấn Tú", "Tuấn Việt",
			"Tùng Anh", "Tùng Châu", "Tùng Lâm", "Tùng Linh", "Tùng Minh", "Tùng Quang", "Tường Anh", "Tường Lâm",
			"Tường Lân", "Tường Lĩnh", "Tường Minh", "Tường Nguyên", "Tường Phát", "Tường Vinh", "Tuyền Lâm",
			"Uy Phong", "Uy Vũ", "Vạn Hạnh", "Vạn Lý", "Văn Minh", "Vân Sơn", "Vạn Thắng", "Vạn Thông", "Văn Tuyển",
			"Viễn Cảnh", "Viễn Ðông", "Viễn Phương", "Viễn Thông", "Việt An", "Việt Anh", "Việt Chính", "Việt Cương",
			"Việt Cường", "Việt Dũng", "Việt Dương", "Việt Duy", "Việt Hải", "Việt Hoàng", "Việt Hồng", "Việt Hùng",
			"Việt Huy", "Việt Khải", "Việt Khang", "Việt Khoa", "Việt Khôi", "Việt Long", "Việt Ngọc", "Viết Nhân",
			"Việt Nhân", "Việt Phong", "Việt Phương", "Việt Quốc", "Việt Quyết", "Viết Sơn", "Việt Sơn", "Viết Tân",
			"Việt Thái", "Việt Thắng", "Việt Thanh", "Việt Thông", "Việt Thương", "Việt Tiến", "Việt Võ", "Vĩnh Ân",
			"Vinh Diệu", "Vĩnh Hải", "Vĩnh Hưng", "Vĩnh Long", "Vĩnh Luân", "Vinh Quốc", "Vĩnh Thọ", "Vĩnh Thụy",
			"Vĩnh Toàn", "Vũ Anh", "Vũ Minh", "Vương Gia", "Vương Triều", "Vương Triệu", "Vương Việt", "Xuân An",
			"Xuân Bình", "Xuân Cao", "Xuân Cung", "Xuân Hàm", "Xuân Hãn", "Xuân Hiếu", "Xuân Hòa", "Xuân Huy",
			"Xuân Khoa", "Xuân Kiên", "Xuân Lạc", "Xuân Lộc", "Xuân Minh", "Xuân Nam", "Xuân Ninh", "Xuân Phúc",
			"Xuân Quân", "Xuân Quý", "Xuân Sang", "Xuân Sơn", "Xuân Thái", "Xuân Thiện", "Xuân Thuyết", "Xuân Trung",
			"Xuân Trường", "Xuân Tường", "Xuân Vũ", "Yên Bằng", "Yên Bình", "Yên Sơn" };

	private String[] tinh = { "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh",
			"Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Đắk Lắk",
			"Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Tĩnh", "Hải Dương",
			"Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng",
			"Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Quảng Bình",
			"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
			"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
			"Vĩnh Phúc", "Yên Bái", "Phú Yên", "Cần Thơ", "Đà Nẵng", "Hải Phòng", "Hà Nội", "TP HCM" };

	private String[] moiQuanHe = { "Bố", "Mẹ", "Anh", "Chị", "Em trai", "Em gái" };

	private String[] khuVucDieuTri = { "Quận Hải Châu", "Quận Cẩm Lệ", "Quận Thanh Khê", "Quận Liên Chiểu",
			"Quận Ngũ Hành Sơn", "Quận Sơn Trà", "Huyện Hòa Vang", "Huyện Hoàng Sa" };

	private String[] moTaKhuVucDieuTri = {"tập trungtrung tâm kinh tế, văn hóa", "chính trị và giáo dục của Thành phố Đà Nẵng","tính diện tích sân bay (8,42 km²)"};
	
	//private String[] listTreatmentAreaID  = new Random().listTreatmentAreaID();
	
	String []roomID = {"R01","R02","R03","R04","R05","R05","R06","R07"};
	
	/*@SuppressWarnings("null")
	public String[] listTreatmentAreaID(){
		String list [] = null ;
		int i = 0;
		try {
			for(TreatmentArea x : treatDAO.listTreatmentArea()) {
				list[i] = x.getTreatmentid();
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	*/
	public String randomRoomID() {
		return roomID[createRandomIntBetween(0, roomID.length-1)];
	}
	
	/*public String randomTreatmentAreaID() {
		return listTreatmentAreaID[createRandomIntBetween(0, listTreatmentAreaID.length)];
	}*/
	
	public String autoHoTen() {
		return ho[createRandomIntBetween(0, ho.length-1)] + " " + ten[createRandomIntBetween(0, ten.length-1)];
	}

	public String randomMoiQuanHe() {
		return moiQuanHe[createRandomIntBetween(0, moiQuanHe.length-1)];
	}
	
	public String randommoTaKhuVucDieuTri() {
		return moTaKhuVucDieuTri[createRandomIntBetween(0, moTaKhuVucDieuTri.length-1)];
	}

	public String randomKhuVucDieuTri() {
		return khuVucDieuTri[createRandomIntBetween(0, khuVucDieuTri.length-1)];
	}
	
	public String autoTinh() {
		return tinh[createRandomIntBetween(0, tinh.length-1)];
	}

	public static String createRandomDate(int startYear, int endYear) {
		String day = createRandomIntBetween(10, 28)+"";
		String month = createRandomIntBetween(10, 12)+"";
		String year = createRandomIntBetween(startYear, endYear)+"";
		return year+"-"+month+"-"+day;
	}
	public String randomGender() {
		return createRandomIntBetween(0, 1) == 1 ? "Nữ" : "Nam";
	}

	
	
	
	public static void main(String[] args) {
		System.out.println(new Random().autoTinh());
		 String str = new Random(Random.STR_NUMBER + Random.STR_LOWER_CASE).next(4);
		String str1 = new Random().soDienThoai(10);
		System.out.println(str);
	}

}
