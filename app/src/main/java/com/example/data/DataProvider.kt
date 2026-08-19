package com.example.data

import com.example.model.*

object DataProvider {

    val uncleHo5Teachings = listOf(
        "1. Yêu Tổ quốc, yêu đồng bào.",
        "2. Học tập tốt, lao động tốt.",
        "3. Đoàn kết tốt, kỷ luật tốt.",
        "4. Giữ gìn vệ sinh thật tốt.",
        "5. Khiêm tốn, thật thà, dũng cảm."
    )

    val uncleHoTimeline = listOf(
        UncleHoTimelineEvent(
            year = "1890",
            title = "Ngày sinh Chủ tịch Hồ Chí Minh",
            location = "Làng Sen, Kim Liên, Nam Đàn, Nghệ An",
            description = "Sinh ngày 19/05/1890, tên khai sinh là Nguyễn Sinh Cung.",
            coordinateNote = "Tọa độ Di tích Kim Liên: 18°41'N 105°33'E (Hướng la bàn: Đông Nam)"
        ),
        UncleHoTimelineEvent(
            year = "1911",
            title = "Ra đi tìm đường cứu nước",
            location = "Bến Nhà Rồng, TP. Hồ Chí Minh",
            description = "Ngày 05/06/1911, Người lên con tàu Amiral Latouche-Tréville ra đi tìm đường giải phóng dân tộc.",
            coordinateNote = "Tọa độ Bến Nhà Rồng: 10°46'N 106°42'E"
        ),
        UncleHoTimelineEvent(
            year = "1941",
            title = "Trở về Tổ quốc lãnh đạo cách mạng",
            location = "Hang Cột Mốc 108, Pác Bó, Hà Quảng, Cao Bằng",
            description = "Ngày 28/01/1941, Bác trở về lãnh đạo cách mạng Việt Nam, lập căn cứ địa tại Cao Bằng.",
            coordinateNote = "Tọa độ Khu di tích Pác Bó: 22°58'N 106°01'E"
        ),
        UncleHoTimelineEvent(
            year = "1945",
            title = "Đọc Tuyên ngôn Độc lập",
            location = "Quảng trường Ba Đình, Hà Nội",
            description = "Ngày 02/09/1945, khai sinh ra nước Việt Nam Dân chủ Cộng hòa.",
            coordinateNote = "Tọa độ Quảng trường Ba Đình: 21°02'N 105°50'E"
        ),
        UncleHoTimelineEvent(
            year = "1969",
            title = "Bác Hồ đi vào cõi vĩnh hằng",
            location = "Hà Nội",
            description = "Ngày 02/09/1969, để lại muôn vàn tình cảm yêu thương và Bản Di chúc thiêng liêng.",
            coordinateNote = "Tọa độ Lăng Chủ tịch Hồ Chí Minh: 21°02'N 105°49'E"
        )
    )

    val vietnameseAlphabet = listOf(
        AlphabetLetter("A", "Áo", "Trang phục truyền thống", "/aː/"),
        AlphabetLetter("Ă", "Ăn cơm", "Hoạt động thường nhật", "/a/"),
        AlphabetLetter("Â", "Ấm trà", "Văn hóa trà Việt", "/ə/"),
        AlphabetLetter("B", "Bánh chưng", "Món bánh Tết cổ truyền", "/ɓ/"),
        AlphabetLetter("C", "Cờ đỏ sao vàng", "Quốc kỳ thiêng liêng", "/k/"),
        AlphabetLetter("D", "Dừa xiêm", "Đặc sản Bến Tre", "/z/"),
        AlphabetLetter("Đ", "Đồng khởi", "Khí thế quật khởi", "/ɗ/"),
        AlphabetLetter("E", "Em bé", "Nụ cười tuổi thơ", "/ɛ/"),
        AlphabetLetter("Ê", "Ếch cốm", "Hình tượng dân gian", "/e/"),
        AlphabetLetter("G", "Gốm Bát Tràng", "Tinh hoa làng nghề", "/ɣ/"),
        AlphabetLetter("H", "Hoa sen", "Quốc hoa Việt Nam", "/h/"),
        AlphabetLetter("I", "Im lặng", "Khoảnh khắc tĩnh lặng", "/i/"),
        AlphabetLetter("K", "Kẹo cu đơ", "Đặc sản Hà Tĩnh", "/k/"),
        AlphabetLetter("L", "Lúa nước", "Cái nôi văn minh Việt", "/l/"),
        AlphabetLetter("M", "Múa sạp", "Điệu múa vùng Tây Bắc", "/m/"),
        AlphabetLetter("N", "Nón lá", "Biểu tượng duyên dáng", "/n/"),
        AlphabetLetter("O", "Ong mật", "Chăm chỉ cần cù", "/ɔ/"),
        AlphabetLetter("Ô", "Ô quan", "Trò chơi dân gian", "/o/"),
        AlphabetLetter("Ơ", "Ơn nghĩa", "Truyền thống đạo lý", "/əː/"),
        AlphabetLetter("P", "Phở bò", "Ẩm thực trứ danh", "/p/"),
        AlphabetLetter("Q", "Quạt nan", "Hình bóng làng quê", "/kʷ/"),
        AlphabetLetter("R", "Rồng Tiên", "Truyền thuyết nguồn cội", "/r/"),
        AlphabetLetter("S", "Sông Hương", "Dòng sông thơ mộng xứ Huế", "/s/"),
        AlphabetLetter("T", "Trống đồng Đông Sơn", "Di sản ngàn năm", "/t/"),
        AlphabetLetter("U", "Uống nước nhớ nguồn", "Bài học nhân nghĩa", "/u/"),
        AlphabetLetter("Ư", "Ước mơ", "Khát vọng tuổi trẻ", "/ɨ/"),
        AlphabetLetter("V", "Vịnh Hạ Long", "Kỳ quan thiên nhiên thế giới", "/v/"),
        AlphabetLetter("X", "Xoan đào", "Cây gỗ quý quê hương", "/s/"),
        AlphabetLetter("Y", "Yêu thương", "Tình người cao đẹp", "/i/")
    )

    val infrastructureList = listOf(
        InfrastructureItem(
            title = "Cao tốc Bắc - Nam phía Đông (CT01)",
            category = "Cao tốc",
            lengthOrSpec = "Tổng chiều dài ~2.063 km (Tốc độ 100 - 120 km/h)",
            routeLocation = "Cửa khẩu Hữu Nghị (Lạng Sơn) ⇌ Đất Mũi (Cà Mau)",
            highlight = "Trục xương sống giao thông huyết mạch kết nối 32 tỉnh thành phố lớn trên cả nước."
        ),
        InfrastructureItem(
            title = "Đường sắt Bắc - Nam (Đường sắt Thống Nhất)",
            category = "Đường sắt",
            lengthOrSpec = "1.726 km (Khổ 1.000 mm, thời gian tàu SE ~30-32 giờ)",
            routeLocation = "Ga Hà Nội ⇌ Ga Sài Gòn",
            highlight = "Tuyến đường sắt lịch sử xuyên suốt chiều dài non sông, kết nối hàng chục ga lớn dọc miền duyên hải."
        ),
        InfrastructureItem(
            title = "Đường sắt Đô thị Metro Tuyến 1 (Bến Thành - Suối Tiên)",
            category = "Đường sắt Đô thị",
            lengthOrSpec = "19.7 km (2.6 km ngầm, 17.1 km trên cao, 14 nhà ga)",
            routeLocation = "Ga Bến Thành ⇌ Depot Long Bình (TP. Hồ Chí Minh)",
            highlight = "Tuyến metro huyết mạch hiện đại bậc nhất, giải tỏa giao thông cửa ngõ phía Đông Sài Gòn."
        ),
        InfrastructureItem(
            title = "Đường sắt Đô thị Hà Nội (Tuyến 2A Cát Linh - Hà Đông)",
            category = "Đường sắt Đô thị",
            lengthOrSpec = "13.05 km trên cao (12 nhà ga hiện đại)",
            routeLocation = "Ga Cát Linh ⇌ Ga Yên Nghĩa (Hà Nội)",
            highlight = "Tuyến tàu điện đô thị trên cao đầu tiên đi vào vận hành thương mại tại Việt Nam."
        ),
        InfrastructureItem(
            title = "Cầu vượt biển Tân Vũ - Lạch Huyện",
            category = "Cầu vượt biển",
            lengthOrSpec = "Dài 5.44 km (Một trong các cầu vượt biển dài nhất Đông Nam Á)",
            routeLocation = "Hải Phòng ⇌ Đảo Cát Hải",
            highlight = "Kết nối trung tâm TP Hải Phòng ra cụm cảng nước sâu quốc tế Lạch Huyện và đảo Cát Bà."
        ),
        InfrastructureItem(
            title = "Cầu vượt biển Thị Nại (Quy Nhơn)",
            category = "Cầu vượt biển",
            lengthOrSpec = "Dài 2.47 km bắc qua đầm Thị Nại",
            routeLocation = "TP. Quy Nhơn ⇌ Bán đảo Phương Mai (Bình Định)",
            highlight = "Cây cầu vượt biển kỳ vĩ mở đường phát triển Khu kinh tế Nhơn Hội và du lịch Kỳ Co - Eo Gió."
        ),
        InfrastructureItem(
            title = "Đường hầm Hải Vân (Hầm số 1 & 2)",
            category = "Hầm đường bộ",
            lengthOrSpec = "Dài 6.28 km (Hầm đường bộ dài nhất Đông Nam Á)",
            routeLocation = "Thừa Thiên Huế ⇌ TP. Đà Nẵng",
            highlight = "Công trình thế kỷ rút ngắn thời gian qua đèo Hải Vân từ 45 phút xuống còn 6 phút an toàn."
        ),
        InfrastructureItem(
            title = "Hầm dìm vượt sông Sài Gòn (Hầm Thủ Thiêm)",
            category = "Hầm đường bộ",
            lengthOrSpec = "Dài 1.49 km (Hầm dìm vượt sông hiện đại bậc nhất Đông Nam Á)",
            routeLocation = "Quận 1 ⇌ Khu đô thị mới Thủ Thiêm (TP. Hồ Chí Minh)",
            highlight = "Kết nối trung tâm lịch sử Sài Gòn với bán đảo Thủ Thiêm qua 6 đốt hầm bê tông đúc sẵn."
        ),
        InfrastructureItem(
            title = "Cầu Rồng Sông Hàn (Đà Nẵng)",
            category = "Cầu nổi tiếng",
            lengthOrSpec = "Dài 666 m (Thiết kế rồng thời Lý vươn ra biển lớn)",
            routeLocation = "Trung tâm TP. Đà Nẵng ⇌ Bãi biển Mỹ Khê",
            highlight = "Biểu tượng kiến trúc độc đáo có khả năng phun lửa và phun nước vào tối thứ Bảy, Chủ Nhật."
        ),
        InfrastructureItem(
            title = "Cáp treo Hòn Thơm (Phú Quốc)",
            category = "Cáp treo",
            lengthOrSpec = "Dài 7.899,9 m (Kỷ lục Guinness thế giới)",
            routeLocation = "Thị trấn An Thới ⇌ Đảo Hòn Thơm (Kiên Giang)",
            highlight = "Tuyến cáp treo 3 dây vượt biển dài nhất thế giới ngắm toàn cảnh biển ngọc Nam Phú Quốc."
        ),
        InfrastructureItem(
            title = "Cáp treo Fansipan Legend (Sa Pa)",
            category = "Cáp treo",
            lengthOrSpec = "Dài 6.292,5 m (Độ chênh ga kỷ lục 1.410 m)",
            routeLocation = "Thung lũng Mường Hoa ⇌ Đỉnh Fansipan (3.143 m)",
            highlight = "Đưa du khách chinh phục 'Nóc nhà Đông Dương' giữa biển mây bồng bềnh."
        ),
        InfrastructureItem(
            title = "Đèo Mã Pí Lèng (Vua của các con đèo)",
            category = "Đèo nổi tiếng",
            lengthOrSpec = "Dài ~20 km, độ cao ~1.200 m trên Cao nguyên đá Đồng Văn",
            routeLocation = "Hà Giang (Đồng Văn ⇌ Mèo Vạc)",
            highlight = "Một trong Tứ Đại Đỉnh Đèo hùng vĩ nhất, ôm trọn hẻm vực Tu Sản và dòng sông Nho Quế."
        ),
        InfrastructureItem(
            title = "Đèo Ô Quy Hồ (Đèo Mây Hoàng Liên Sơn)",
            category = "Đèo nổi tiếng",
            lengthOrSpec = "Dài ~50 km (Đèo dài nhất Việt Nam, độ cao 2.000 m)",
            routeLocation = "Lào Cai (Sa Pa) ⇌ Lai Châu (Tam Đường)",
            highlight = "Con đèo ngắm hoàng hôn rực rỡ và mây luồn huyền ảo đỉnh Cổng Trời."
        ),
        InfrastructureItem(
            title = "Cửa Khẩu Quốc Tế Hữu Nghị & Tà Lùng (Cao Bằng)",
            category = "Cửa khẩu quốc tế",
            lengthOrSpec = "Cửa khẩu đường bộ cấp quốc gia trọng điểm",
            routeLocation = "Việt Nam ⇌ Trung Quốc (Lạng Sơn & Cao Bằng)",
            highlight = "Hành lang kinh tế kết nối giao thương hàng hóa đường bộ sôi động hàng đầu phía Bắc."
        ),
        InfrastructureItem(
            title = "Tuyến Bay Starlux Airlines & Hành Lang Bay Tây Tạng",
            category = "Hàng không & Tuyến bay",
            lengthOrSpec = "Độ cao hành trình 33.000 - 41.000 ft (Tiêu chuẩn ETOPS)",
            routeLocation = "Châu Á ⇌ Bắc Mỹ qua Hành lang An toàn Hàng không",
            highlight = "Công nghệ định vị vệ tinh GPS/ADS-B và kiểm soát an toàn bay qua các địa hình hiểm trở."
        )
    )

    val portsAndEnergyList = listOf(
        PortAndEnergyItem(
            name = "Cụm Cảng Quốc Tế Cái Mép - Thị Vải",
            type = "Cảng nước sâu quốc tế",
            location = "Bà Rịa - Vũng Tàu",
            capacity = "Tiếp nhận siêu tàu container >250.000 DWT (~24.000 TEU)",
            description = "Top 11 cụm cảng hoạt động hiệu quả nhất thế giới, tuyến vận tải trực tiếp sang Bắc Mỹ và Châu Âu."
        ),
        PortAndEnergyItem(
            name = "Cảng Cửa Ngõ Quốc Tế Lạch Huyện",
            type = "Cảng nước sâu quốc tế",
            location = "Hải Phòng",
            capacity = "Đón tàu tải trọng 100.000 - 160.000 DWT",
            description = "Cửa ngõ logistics huyết mạch phía Bắc kết nối và thúc đẩy vùng kinh tế trọng điểm Vịnh Bắc Bộ."
        ),
        PortAndEnergyItem(
            name = "Cụm Mỏ Dầu Khí & Giàn Khoan Bạch Hổ",
            type = "Cảng dầu mỏ & Năng lượng",
            location = "Thềm lục địa Vũng Tàu (Bể Cửu Long)",
            capacity = "Trữ lượng khai thác hàng trăm triệu tấn dầu thô",
            description = "Biểu tượng của ngành công nghiệp dầu khí Việt Nam, cung cấp dầu thô và khí đồng hành cho đất nước."
        ),
        PortAndEnergyItem(
            name = "Cảng Xuất Dầu & Nhà Máy Lọc Dầu Dung Quất",
            type = "Cảng dầu mỏ & Năng lượng",
            location = "Khu kinh tế Dung Quất, Quảng Ngãi",
            capacity = "Công suất chế biến 6.5 triệu tấn dầu thô/năm",
            description = "Nhà máy lọc dầu đầu tiên của Việt Nam, tự chủ sản xuất xăng dầu phục vụ an ninh năng lượng quốc gia."
        ),
        PortAndEnergyItem(
            name = "Cảng Cá & Chợ Thủy Sản Thọ Quang",
            type = "Cảng cá trung ương",
            location = "Sơn Trà, Đà Nẵng",
            capacity = "Hàng trăm lượt tàu cập bến/ngày, công suất ~150.000 tấn/năm",
            description = "Trung tâm dịch vụ hậu cần nghề cá lớn nhất miền Trung, nơi cung cấp hải sản tươi cho cả nước."
        ),
        PortAndEnergyItem(
            name = "Cảng Cá Tắc Cậu",
            type = "Cảng cá đồng bằng",
            location = "Châu Thành, Kiên Giang",
            capacity = "Cửa ngõ vươn khơi vịnh Thái Lan và vùng biển Tây Nam",
            description = "Cảng cá sầm uất bậc nhất Đồng bằng sông Cửu Long với hàng ngàn phương tiện khai thác xa bờ."
        ),
        PortAndEnergyItem(
            name = "Bến Du Thuyền Quốc Tế Tuần Châu",
            type = "Bến du thuyền & Du lịch",
            location = "TP. Hạ Long, Quảng Ninh",
            capacity = "Sức chứa hơn 2.000 tàu du lịch neo đậu",
            description = "Cảng du thuyền nhân tạo lớn nhất Việt Nam, cửa ngõ đón khách chiêm ngưỡng Vịnh Hạ Long."
        )
    )

    val hospitalsList = listOf(
        HospitalItem(
            name = "Bệnh Viện Bạch Mai",
            level = "Hạng Đặc Biệt - Tuyến Trung Ương",
            location = "78 Giải Phóng, Đống Đa, Hà Nội",
            specialties = "Hồi sức cấp cứu, Tim mạch, Huyết học, Chống độc, Nội khoa chuyên sâu",
            scaleBeds = "Quy mô hơn 3.200 giường bệnh nội trú, bệnh viện đa khoa đầu ngành miền Bắc"
        ),
        HospitalItem(
            name = "Bệnh Viện Chợ Rẫy",
            level = "Hạng Đặc Biệt - Tuyến Trung Ương",
            location = "201B Nguyễn Chí Thanh, Quận 5, TP. Hồ Chí Minh",
            specialties = "Cấp cứu đa chấn thương, Ngoại thần kinh, Ghép tạng, Tim mạch can thiệp",
            scaleBeds = "Quy mô hơn 1.800 giường bệnh, hạt nhân y tế chuyên sâu hàng đầu phía Nam"
        ),
        HospitalItem(
            name = "Bệnh Viện Trung Ương Huế",
            level = "Hạng Đặc Biệt - Tuyến Trung Ương",
            location = "16 Lê Lợi, TP. Huế, Thừa Thiên Huế",
            specialties = "Ghép tạng, Ung bướu, Tim mạch, Phẫu thuật nội soi chuyên sâu",
            scaleBeds = "Thành lập năm 1894, quy mô hơn 4.000 giường trên cả 2 cơ sở"
        ),
        HospitalItem(
            name = "Bệnh Viện K Trung Ương",
            level = "Tuyến Trung Ương Chuyên Khoa",
            location = "Hà Nội (Cơ sở 1 Quán Sứ, Cơ sở 2 Tam Hiệp, Cơ sở 3 Tân Triều)",
            specialties = "Phòng ngừa, Chẩn đoán và Điều trị Ung bướu kỹ thuật cao",
            scaleBeds = "Trung tâm điều trị ung thư số 1 Việt Nam với hệ thống xạ trị gia tốc hiện đại"
        ),
        HospitalItem(
            name = "Bệnh Viện Nhi Trung Ương",
            level = "Tuyến Trung Ương Chuyên Khoa",
            location = "18/879 La Thành, Đống Đa, Hà Nội",
            specialties = "Nhi khoa chuyên sâu, Phẫu thuật sơ sinh, Hồi sức nhi, Di truyền học",
            scaleBeds = "Bệnh viện chuyên khoa Nhi đầu ngành cả nước với hơn 2.000 giường"
        ),
        HospitalItem(
            name = "Bệnh Viện Từ Dũ",
            level = "Hạng I - Chuyên Khoa Sản Phụ Khoa",
            location = "284 Cống Quỳnh, Quận 1, TP. Hồ Chí Minh",
            specialties = "Sản phụ khoa, Hiếm muộn, Thụ tinh trong ống nghiệm (IVF), Sơ sinh",
            scaleBeds = "Trung tâm hỗ trợ sinh sản và sản khoa uy tín hàng đầu Đông Nam Á"
        ),
        HospitalItem(
            name = "Bệnh Viện Đa Khoa Tỉnh Cao Bằng",
            level = "Hạng I - Tuyến Tỉnh Trọng Điểm",
            location = "Xã Hưng Đạo, TP. Cao Bằng, Tỉnh Cao Bằng",
            specialties = "Cấp cứu, Hồi sức, Ngoại chấn thương, Khám chữa bệnh nhân dân vùng Đông Bắc",
            scaleBeds = "Cơ sở vật chất hiện đại, trung tâm y tế nòng cốt chăm sóc sức khỏe đồng bào các dân tộc"
        )
    )

    val famousLandmarksList = listOf(
        FamousLandmarkItem(
            name = "Tòa Nhà The Landmark 81",
            region = "Việt Nam",
            country = "Việt Nam (TP. Hồ Chí Minh)",
            architecturalStyle = "Kiến trúc bó tre truyền thống hiện đại (Cao 461.3 m)",
            significance = "Tòa nhà cao nhất Việt Nam, biểu tượng cho khát vọng vươn tầm và sự thịnh vượng kinh tế."
        ),
        FamousLandmarkItem(
            name = "Cầu Vàng (Golden Bridge)",
            region = "Việt Nam",
            country = "Việt Nam (Bà Nà Hills, Đà Nẵng)",
            architecturalStyle = "Kiến trúc cầu đi bộ nâng đỡ bởi đôi bàn tay khổng lồ bằng rêu phong",
            significance = "Top những điểm đến tuyệt vời nhất thế giới do tạp chí TIME bình chọn."
        ),
        FamousLandmarkItem(
            name = "Hoàng Thành Thăng Long & Cột Cờ Hà Nội",
            region = "Việt Nam",
            country = "Việt Nam (Ba Đình, Hà Nội)",
            architecturalStyle = "Di sản kiến trúc cung đình phong kiến ngàn năm lịch sử",
            significance = "Di sản Văn hóa Thế giới UNESCO, trung tâm quyền lực chính trị qua nhiều triều đại."
        ),
        FamousLandmarkItem(
            name = "Quần Thể Di Tích Cố Đô Huế",
            region = "Việt Nam",
            country = "Việt Nam (Thừa Thiên Huế)",
            architecturalStyle = "Kiến trúc kinh thành, lăng tẩm và chùa chiền triều Nguyễn",
            significance = "Di sản Văn hóa Thế giới đầu tiên của Việt Nam được UNESCO vinh danh năm 1993."
        ),
        FamousLandmarkItem(
            name = "Cột Cờ Quốc Gia Lũng Cú",
            region = "Việt Nam",
            country = "Việt Nam (Đồng Văn, Hà Giang)",
            architecturalStyle = "Cột cờ bát giác trên đỉnh núi Rồng (Độ cao 1.470 m)",
            significance = "Điểm cực Bắc thiêng liêng của Tổ quốc với lá cờ đỏ sao vàng rộng 54 m² tượng trưng cho 54 dân tộc."
        ),
        FamousLandmarkItem(
            name = "Tháp Eiffel (Eiffel Tower)",
            region = "Châu Âu",
            country = "Pháp (Paris)",
            architecturalStyle = "Kiến trúc tháp thép rèn xây dựng năm 1889 (Cao 330 m)",
            significance = "Biểu tượng kinh đô ánh sáng thế giới và là một trong những công trình nổi tiếng nhất nhân loại."
        ),
        FamousLandmarkItem(
            name = "Vạn Lý Trường Thành (Great Wall)",
            region = "Châu Á",
            country = "Trung Quốc",
            architecturalStyle = "Thành lũy quân sự cổ đại bằng đá và gạch dài hơn 21.196 km",
            significance = "Một trong 7 Kỳ quan thế giới mới, công trình phòng thủ vĩ đại nhất lịch sử."
        ),
        FamousLandmarkItem(
            name = "Lăng Mộ Taj Mahal",
            region = "Châu Á",
            country = "Ấn Độ (Agra)",
            architecturalStyle = "Kiến trúc Hồi giáo Mughal xây bằng đá cẩm thạch trắng tinh khiết",
            significance = "Kiệt tác tình yêu vĩnh cửu, Di sản Văn hóa Thế giới UNESCO."
        ),
        FamousLandmarkItem(
            name = "Đấu Trường La Mã Colosseum",
            region = "Châu Âu",
            country = "Ý (Rome)",
            architecturalStyle = "Đấu trường vòng cung bằng đá xây từ thế kỷ thứ 1 sau Công nguyên",
            significance = "Biểu tượng quyền uy của Đế chế La Mã cổ đại và đỉnh cao kỹ thuật xây dựng vòm đá."
        ),
        FamousLandmarkItem(
            name = "Tượng Nữ Thần Tự Do",
            region = "Châu Mỹ",
            country = "Hoa Kỳ (New York)",
            architecturalStyle = "Tượng điêu khắc Tân Cổ điển bằng đồng (Cao 93 m)",
            significance = "Biểu tượng của tự do, dân chủ và tình hữu nghị quốc tế."
        ),
        FamousLandmarkItem(
            name = "Đại Kim Tự Tháp Giza & Tượng Nhân Sư",
            region = "Châu Phi",
            country = "Ai Cập (Cairo)",
            architecturalStyle = "Kiến trúc kim tự tháp đá cổ đại xây dựng hơn 4.500 năm trước",
            significance = "Kỳ quan duy nhất trong 7 Kỳ quan Thế giới Cổ đại còn tồn tại đến ngày nay."
        ),
        FamousLandmarkItem(
            name = "Núi Phú Sĩ & Đền Thờ Núi Lửa",
            region = "Châu Á",
            country = "Nhật Bản (Honshu)",
            architecturalStyle = "Ngọn núi lửa hình nón hoàn hảo (Độ cao 3.776 m)",
            significance = "Biểu tượng văn hóa tinh thần linh thiêng của đất nước Mặt trời mọc."
        )
    )

    val terracedFieldsList = listOf(
        TerracedFieldItem(
            name = "Ruộng Bậc Thang Mù Cang Chải",
            province = "Yên Bái",
            areaHectares = "Hơn 2.200 ha trải rộng 3 xã La Pán Tẩn, Chế Cu Nha, Dế Xu Phình",
            bestSeason = "Mùa lúa chín vàng: Tháng 9 - 10 | Mùa nước đổ: Tháng 5 - 6",
            nationalHeritageStatus = "Di Tích Quốc Gia Đặc Biệt (Thủ tướng Chính phủ xếp hạng 2019)",
            ethnicGroups = "Đồng bào dân tộc H'Mông (hơn 90% dân số)",
            highlights = "Những dải lụa vàng uốn lượn quanh sườn núi Hoàng Liên Sơn, đỉnh cao của nghệ thuật canh tác lúa nước trên đất dốc.",
            famousSpots = "Đồi Mâm Xôi La Pán Tẩn, Đồi Móng Ngựa Mồ Dề, Đèo Khau Phạ, Vành Móng Ngựa Chế Cu Nha"
        ),
        TerracedFieldItem(
            name = "Ruộng Bậc Thang Hoàng Su Phì",
            province = "Hà Giang",
            areaHectares = "Khoảng 3.700 ha trên địa bàn 24 xã, thị trấn",
            bestSeason = "Mùa vàng rực rỡ: Tháng 9 - 10 | Mùa hoa tam giác mạch & nước đổ: Tháng 5 - 11",
            nationalHeritageStatus = "Di Tích Quốc Gia (Bộ Văn hóa, Thể thao và Du lịch)",
            ethnicGroups = "Đồng bào các dân tộc Nùng, Dao đỏ, La Chí, Cờ Lao, Tày",
            highlights = "Ruộng bậc thang có độ dốc lớn nhất và tầng bậc cao vút chạm mây trời bên sườn đỉnh Tây Côn Lĩnh hùng vĩ.",
            famousSpots = "Bản Phùng, Bản Luốc, Sán Sả Hồ, Nậm Ty, Thông Nguyên, Tả Sử Choóng"
        ),
        TerracedFieldItem(
            name = "Ruộng Bậc Thang Thung Lũng Mường Hoa (Sa Pa & Y Tý)",
            province = "Lào Cai",
            areaHectares = "Hàng ngàn hecta uốn quanh dãy Hoàng Liên Sơn",
            bestSeason = "Mùa lúa trổ vàng óng: Tháng 8 - 9 | Mùa săn mây Y Tý: Tháng 10 - 4",
            nationalHeritageStatus = "Top ruộng bậc thang kỳ vĩ nhất thế giới do Travel and Leisure bình chọn",
            ethnicGroups = "Đồng bào H'Mông, Giáy, Dao Đỏ, Hà Nhì",
            highlights = "Bức tranh thủy mặc khổng lồ hòa quyện cùng bãi đá cổ Sa Pa, suối Mường Hoa và những nếp nhà trình tường của người Hà Nhì.",
            famousSpots = "Thung lũng Mường Hoa, Bản Tả Van, Tả Phìn, Ngải Thầu, Thung lũng Thề Pả (Y Tý)"
        ),
        TerracedFieldItem(
            name = "Ruộng Bậc Thang Thung Lũng Pù Luông",
            province = "Bá Thước & Quan Hóa, Thanh Hóa",
            areaHectares = "Khu bảo tồn thiên nhiên Pù Luông (17.600 ha rừng nguyên sinh)",
            bestSeason = "Hai vụ mùa: Vụ chiêm tháng 5 - 6 & Vụ mùa tháng 9 - 10",
            nationalHeritageStatus = "Khu Bảo Tồn Thiên Nhiên Sinh Thái Trọng Điểm Quốc Gia",
            ethnicGroups = "Đồng bào dân tộc Thái, Mường",
            highlights = "Thung lũng xanh thanh bình bên những guồng nước (cọn nước) khổng lồ dọc suối Chàm và nếp nhà sàn truyền thống.",
            famousSpots = "Bản Đôn, Bản Kho Mường, Bản Hiêu, Cọn nước Suối Chàm, Đỉnh Pù Luông (1.700 m)"
        ),
        TerracedFieldItem(
            name = "Ruộng Bậc Thang Trùng Khánh & Thác Bản Giốc",
            province = "Cao Bằng (Quê hương Tác giả)",
            areaHectares = "Trải dọc đôi bờ dòng sông Quây Sơn trong xanh như ngọc",
            bestSeason = "Mùa lúa chín vàng óng: Tháng 9 - 10 bên thác nước hùng vĩ",
            nationalHeritageStatus = "Công Viên Địa Chất Toàn Cầu UNESCO Non Nước Cao Bằng",
            ethnicGroups = "Đồng bào các dân tộc Tày, Nùng, Dao, H'Mông",
            highlights = "Cảnh sắc thần tiên kết hợp giữa ruộng bậc thang trĩu hạt và Thác Bản Giốc - thác nước tự nhiên lớn nhất Đông Nam Á.",
            famousSpots = "Thung lũng Phong Nậm, Thác Bản Giốc, Động Ngườm Ngao, Núi Mắt Thần (Núi Thủng)"
        ),
        TerracedFieldItem(
            name = "Ruộng Bậc Thang Xã Hồng Thái (Na Hang)",
            province = "Tuyên Quang",
            areaHectares = "Nằm ở độ cao 1.280 m so với mực nước biển",
            bestSeason = "Mùa vàng Na Hang: Tháng 9 - 10 | Mùa hoa lê nở trắng: Tháng 3",
            nationalHeritageStatus = "Danh Thắng Quốc Gia Na Hang - Lâm Bình",
            ethnicGroups = "Đồng bào dân tộc Dao Tiền, Tày, Mông",
            highlights = "Khí hậu mát mẻ quanh năm như Đà Lạt thu nhỏ của vùng Đông Bắc, mây mù bao phủ ruộng bậc thang đẹp như tranh vẽ.",
            famousSpots = "Bản Khau Tràng, Đồi chè Shan Tuyết cổ thụ, Lòng hồ Na Hang sinh thái"
        )
    )

    val nationalParksList = listOf(
        NationalParkItem(
            name = "Vườn Quốc Gia Phong Nha - Kẻ Bàng",
            province = "Quảng Bình",
            region = "Miền Trung",
            areaHectares = "123.326 ha (Vùng đệm hơn 220.000 ha)",
            unescoRamsarTitle = "Di Sản Thiên Nhiên Thế Giới UNESCO (2 lần: 2003 & 2015)",
            iconicFloraFauna = "Sơn Đoòng (hang lớn nhất thế giới), Voọc Hà Tĩnh, Bách xanh đá cổ 500 năm",
            highlights = "Vương quốc hang động thế giới với hệ thống karst đá vôi cổ 400 triệu năm, chứa hơn 300 hang động kỳ vĩ bậc nhất hành tinh.",
            ecotourismSpots = "Hang Sơn Đoòng, Động Phong Nha, Động Thiên Đường, Hang Én, Suối Nước Moọc, Sông Chày - Hang Tối"
        ),
        NationalParkItem(
            name = "Vườn Quốc Gia Cúc Phương",
            province = "Ninh Bình (kết nối Hòa Bình & Thanh Hóa)",
            region = "Miền Bắc",
            areaHectares = "22.408 ha (Vườn Quốc Gia đầu tiên của Việt Nam - 1962)",
            unescoRamsarTitle = "Vườn Quốc Gia Hàng Đầu Châu Á (World Travel Awards)",
            iconicFloraFauna = "Cây Chò chỉ ngàn năm tuổi, Voọc mông trắng, Bướm rừng bạt ngàn mùa xuân",
            highlights = "Khu rừng mưa nhiệt đới nguyên sinh bạt ngàn, trung tâm bảo tồn linh trưởng nguy cấp và di chỉ khảo cổ Người Tiền Sử.",
            ecotourismSpots = "Cây Chò Ngàn Năm, Động Người Xưa, Trung tâm Cứu hộ Linh trưởng, Hồ Mạc, Đỉnh Mây Bạc (648 m)"
        ),
        NationalParkItem(
            name = "Vườn Quốc Gia Cát Tiên",
            province = "Đồng Nai, Lâm Đồng, Bình Phước",
            region = "Miền Nam",
            areaHectares = "71.920 ha",
            unescoRamsarTitle = "Khu Dự Trữ Sinh Quyển Thế Giới UNESCO & Khu Ramsar Bàu Sấu (2005)",
            iconicFloraFauna = "Voi châu Á, Bò Tót (Gaur), Cá Sấu Xiêm Bàu Sấu, Vượn đen má vàng, Cây Tung cổ thụ 400 tuổi",
            highlights = "Thiên đường du lịch sinh thái hoang dã miền Nam với tour xem thú đêm độc đáo và hồ đầm ngập nước Bàu Sấu nguyên sơ.",
            ecotourismSpots = "Bàu Sấu, Tuyến Xem Thú Đêm Safari, Thác Trời - Thác Dựng, Cây Tung Đại Thụ, Đảo Tiên cứu hộ linh trưởng"
        ),
        NationalParkItem(
            name = "Vườn Quốc Gia Phia Oắc - Phia Đén",
            province = "Cao Bằng (Quê hương Tác giả)",
            region = "Miền Bắc",
            areaHectares = "10.593 ha",
            unescoRamsarTitle = "Khu Di Sản Cốt Lõi Công Viên Địa Chất Toàn Cầu UNESCO Non Nước Cao Bằng",
            iconicFloraFauna = "Đỉnh Phia Oắc (1.931 m) có tuyết rơi mùa đông, Rừng Rêu cổ tích ma mị, Trúc sào, Thông Pà Cò",
            highlights = "Nóc nhà phía Tây Cao Bằng với khí hậu á nhiệt đới quanh năm mát lạnh, cảnh quan sương mây bồng bềnh và di tích biệt thự cổ thời Pháp.",
            ecotourismSpots = "Đỉnh Núi Phia Oắc (1.931 m), Rừng Rêu Ma Mị, Đồi Chè Sinh Thái Kolia, Nhà Đỏ Thời Pháp, Mỏ Thiếc Tĩnh Túc"
        ),
        NationalParkItem(
            name = "Vườn Quốc Gia Ba Bể",
            province = "Bắc Kạn",
            region = "Miền Bắc",
            areaHectares = "10.048 ha",
            unescoRamsarTitle = "Khu Ramsar Thứ 3 Của Việt Nam & Vườn Di Sản ASEAN",
            iconicFloraFauna = "Cá Chép Kình, Voọc mũi hếch, Rừng nghiến cổ thụ trên núi đá vôi",
            highlights = "Trái tim xanh của vùng Đông Bắc với Hồ Ba Bể - một trong 20 hồ nước ngọt tự nhiên trên núi đá vôi đẹp nhất thế giới.",
            ecotourismSpots = "Hồ Ba Bể (Pé Lầm, Pé Lù, Pé Lèng), Động Puông, Thác Đầu Đẳng, Ao Tiên, Đảo Bà Góa, Bản Pác Ngòi"
        ),
        NationalParkItem(
            name = "Vườn Quốc Gia Tràm Chim",
            province = "Đồng Tháp (Tam Nông)",
            region = "Miền Nam",
            areaHectares = "7.313 ha",
            unescoRamsarTitle = "Khu Ramsar Thứ 2.000 Của Thế Giới & Thứ 4 Của Việt Nam (2012)",
            iconicFloraFauna = "Sếu Đầu Đỏ (Grus antigone), Ngan cánh trắng, Cỏ Năng kim, Hoa Hoàng đầu ấn, Sen - Súng Đồng Tháp",
            highlights = "Bức tranh thu nhỏ của vùng Đồng Tháp Mười nguyên bản mùa nước nổi, xứ sở di cư trú ngụ của loài Sếu Đầu Đỏ quý hiếm.",
            ecotourismSpots = "Khu bảo tồn Sếu Đầu Đỏ, Đi xuồng tắc ráng xuyên rừng tràm ngập nước, Đài quan sát chim, Cánh đồng hoa hoàng đầu ấn"
        ),
        NationalParkItem(
            name = "Vườn Quốc Gia Cát Bà",
            province = "Hải Phòng",
            region = "Miền Bắc",
            areaHectares = "17.360 ha (10.910 ha rừng núi & 6.450 ha mặt nước biển)",
            unescoRamsarTitle = "Khu Dự Trữ Sinh Quyển Thế Giới Quần Đảo Cát Bà UNESCO (2004)",
            iconicFloraFauna = "Voọc Cát Bà (loài linh trưởng nguy cấp nhất thế giới), Cây Kim Giao, Cầy gấm, San hô vịnh Lan Hạ",
            highlights = "Sự kết hợp hoàn hảo giữa rừng mưa nhiệt đới nguyên sinh trên đảo đá vôi, rừng ngập mặn ven biển và hệ sinh thái vịnh Lan Hạ.",
            ecotourismSpots = "Đỉnh Ngự Lâm ngắm toàn cảnh rừng đảo, Rừng Cây Kim Giao, Động Trung Trang, Thung lũng Việt Hải, Vịnh Lan Hạ"
        ),
        NationalParkItem(
            name = "Vườn Quốc Gia Bạch Mã",
            province = "Thừa Thiên Huế",
            region = "Miền Trung",
            areaHectares = "37.487 ha",
            unescoRamsarTitle = "Trung Tâm Đa Dạng Sinh Học Thực Vật Trọng Điểm Đông Dương",
            iconicFloraFauna = "Sao La (Kỳ lân châu Á), Trĩ sao, Trầm hương, Đỗ quyên hoa đỏ ngàn năm",
            highlights = "Nơi giao thoa khí hậu giữa miền Bắc và miền Nam, sở hữu thác Đỗ Quyên hùng vĩ đổ từ độ cao 300m và đỉnh Vọng Hải Đài mây vờn.",
            ecotourismSpots = "Vọng Hải Đài (Đỉnh Bạch Mã 1.450 m), Thác Đỗ Quyên (300 m), Ngũ Hồ suối ngọc, Đường mòn Trĩ Sao, Biệt thự cổ thời Pháp"
        )
    )

    val zoosList = listOf(
        ZooItem(
            name = "Thảo Cầm Viên Sài Gòn (Sở Thú Sài Gòn)",
            province = "TP. Hồ Chí Minh (Quận 1)",
            region = "Miền Nam",
            areaHectares = "17 ha",
            type = "Sở Thú & Vườn Bách Thảo Cổ Lâu Đời",
            totalSpeciesAndAnimals = "Hơn 1.500 cá thể (145 loài thú) & 900 loài thực vật cổ thụ",
            iconicAnimals = "Voi châu Á, Hổ Đông Dương, Báo hoa mai, Hươu cao cổ, Hà mã, Trăn đất, Rái cá lông mượt",
            highlights = "Xây dựng năm 1864, là một trong 8 sở thú lâu đời nhất trên thế giới còn hoạt động. 'Lá phổi xanh' lịch sử giữa lòng Sài Gòn phồn hoa.",
            famousExperiences = "Thăm Bảo tàng Động thực vật, xem biểu diễn voi & chim miễn phí cuối tuần, ngắm vườn phong lan & cây cổ thụ trăm năm"
        ),
        ZooItem(
            name = "Vinpearl Safari Phú Quốc",
            province = "Kiên Giang (Đảo Phú Quốc)",
            region = "Miền Nam",
            areaHectares = "380 ha (Quy mô Safari lớn nhất Việt Nam)",
            type = "Công Viên Chăm Sóc & Bảo Tồn Động Vật Bán Hoang Dã",
            totalSpeciesAndAnimals = "Hơn 3.000 cá thể thuộc 150 loài động vật quý hiếm toàn cầu",
            iconicAnimals = "Tê giác trắng châu Phi, Hổ Bengal, Sư tử châu Phi, Hươu cao cổ, Hồng hạc Mỹ, Linh dương sừng kiếm",
            highlights = "Mô hình 'Nhốt người thả thú' chuẩn quốc tế đầu tiên tại Việt Nam. Du khách ngồi xe buýt bảo vệ ngắm động vật hoang dã tự do đi lại.",
            famousExperiences = "Đi xe Bus Safari ngắm hổ & sư tử, đút thức ăn cho Hươu cao cổ tại Nhà hàng Giraffe, xem biểu diễn động vật & vũ điệu Zulu châu Phi"
        ),
        ZooItem(
            name = "Vườn Thú Thủ Lệ (Công Viên Thủ Lệ)",
            province = "Hà Nội (Ba Đình)",
            region = "Miền Bắc",
            areaHectares = "29 ha (Bao gồm 6 ha hồ nước trong lành)",
            type = "Vườn Thú Lịch Sử & Công Viên Văn Hóa Thủ Đô",
            totalSpeciesAndAnimals = "Gần 600 cá thể thuộc hơn 100 loài động vật",
            iconicAnimals = "Hổ Đông Dương, Voi châu Á, Báo gấm, Sư tử, Gấu ngựa, Vượn đen má trắng, Cá sấu hoa cà, Công xanh",
            highlights = "Khánh thành năm 1977, gắn liền với di tích linh thiêng Đền Voi Phục (Thăng Long Tứ Trấn) và ký ức tuổi thơ của nhiều thế hệ người dân Thủ đô.",
            famousExperiences = "Dạo quanh hồ Thủ Lệ rợp bóng mát, thăm khu chuồng thú hình bát giác, đạp vịt thiên nga trên hồ và tham quan Đền Voi Phục cổ kính"
        ),
        ZooItem(
            name = "Vinpearl Safari Nam Hội An (River Safari)",
            province = "Quảng Nam (Thăng Bình)",
            region = "Miền Trung",
            areaHectares = "40 ha",
            type = "Safari Bán Hoang Dã Trên Sông (River Safari Độc Nhất)",
            totalSpeciesAndAnimals = "Hơn 550 cá thể thuộc 50 loài động vật hoang dã",
            iconicAnimals = "Hồng hạc lông đỏ, Linh dương sừng xoắn Nyala, Vẹt Macaw Nam Mỹ, Chuột túi Kangaroo, Hổ Bengal, Tê giác",
            highlights = "Công viên động vật bán hoang dã trên sông đầu tiên và duy nhất tại Việt Nam. Du khách ngồi thuyền lênh đênh khám phá hệ sinh thái tự nhiên.",
            famousExperiences = "Ngồi thuyền xuôi dòng sông Amazon thu nhỏ, cho vẹt Macaw đậu lên tay chụp ảnh, tương tác gần với lạc đà Alpaca và cừu đáng yêu"
        ),
        ZooItem(
            name = "Vườn Thú Mở Đại Nam (Lạc Cảnh Đại Nam)",
            province = "Bình Dương (TP. Thủ Dầu Một)",
            region = "Miền Nam",
            areaHectares = "12,5 ha",
            type = "Vườn Thú Mở Bán Tự Nhiên Không Rào Chắn",
            totalSpeciesAndAnimals = "Hơn 600 cá thể thuộc hơn 63 loài chim, bò sát và thú quý",
            iconicAnimals = "Hổ trắng Nam Phi, Sư tử trắng, Báo lửa, Hươu cao cổ, Tê giác một sừng, Vượn má vàng, Khổng tước",
            highlights = "Thiết kế cách tân với hào nước và cây xanh thay cho rào sắt ngột ngạt, tạo không gian mở tối đa cho động vật sinh hoạt gần gũi với thiên nhiên.",
            famousExperiences = "Chiêm ngưỡng các loài biến thể gen hiếm có (Hổ trắng & Sư tử trắng), cho hươu cao cổ ăn cà rốt, tham quan vườn chim nhiệt đới"
        ),
        ZooItem(
            name = "Mường Thanh Safari Land Diễn Lâm",
            province = "Nghệ An (Huyện Diễn Châu)",
            region = "Miền Bắc",
            areaHectares = "60 ha (Safari tư nhân lớn nhất miền Bắc)",
            type = "Vườn Thú Bán Hoang Dã Mở Lớn Nhất Miền Bắc",
            totalSpeciesAndAnimals = "Hơn 1.000 cá thể thuộc 60 loài động vật từ khắp năm châu",
            iconicAnimals = "Hổ trắng, Hổ Bengal, Tê giác Nam Phi, Hươu cao cổ, Linh cẩu đốm, Ngựa vằn, Linh dương đầu bò, Gấu ngựa",
            highlights = "Nằm trọn trong thung lũng xanh mát ngút ngàn, môi trường sống mở lý tưởng cho các loài thú hoang dã thích nghi và sinh sản tự nhiên.",
            famousExperiences = "Tự tay cho thú ăn (hươu, voi), đi xe điện dạo quanh safari thung lũng, kết hợp tắm khoáng nóng và công viên nước Diễn Lâm"
        ),
        ZooItem(
            name = "Zoodoo Đà Lạt (Sở Thú Thân Thiện)",
            province = "Lâm Đồng (Lạc Dương - Đà Lạt)",
            region = "Miền Trung",
            areaHectares = "16 ha giữa rừng thông nguyên sinh",
            type = "Vườn Thú Thân Thiện Kiểu Úc (Interactive Petting Zoo)",
            totalSpeciesAndAnimals = "Hơn 30 loài động vật hiền lành, thân thiện nhập khẩu từ Úc",
            iconicAnimals = "Chuột túi Kangaroo, Lạc đà không bướu Alpaca, Lạc đà Llama, Ngựa lùn Pony, Cừu lông xù Dolly, Rái cá nước ngọt",
            highlights = "Mô hình vườn thú thân thiện tiêu chuẩn Úc, giới hạn số lượng khách theo tour hướng dẫn để bảo đảm động vật không bị stress.",
            famousExperiences = "Tận tay vuốt ve và đút cỏ cho chuột túi Kangaroo, ôm lạc đà Alpaca xù lông mềm mại, thưởng thức cafe ngắm thung lũng đồi thông"
        ),
        ZooItem(
            name = "FLC Zoo Safari Park Quy Nhơn",
            province = "Bình Định (TP. Quy Nhơn)",
            region = "Miền Trung",
            areaHectares = "38,5 ha ven biển Nhơn Lý",
            type = "Công Viên Động Vật Bán Hoang Dã Ven Biển",
            totalSpeciesAndAnimals = "Gần 1.000 cá thể động vật quý hiếm",
            iconicAnimals = "Thiên nga đen, Vượn má vàng, Sư tử, Gấu ngựa, Hươu sao, Lạc đà một bướu, Đà điểu châu Phi",
            highlights = "Safari ven biển độc đáo của miền Trung, bảo tồn gen các loài chim biển và thú nhiệt đới, kết nối với cồn cát và rừng phi lao lộng gió.",
            famousExperiences = "Trải nghiệm chèo thuyền Kayak ngắm đàn thiên nga, tham quan khu đảo linh trưởng và cắm trại dã ngoại dải bờ biển"
        )
    )

    val horoscopeZodiac = listOf(
        "Tý (Chuột)" to "Thông minh, nhanh nhẹn, quý nhân phù trợ trong công việc và học tập.",
        "Sửu (Trâu)" to "Chăm chỉ, bền bỉ, gặt hái thành quả vững chắc trong các kế hoạch dài hạn.",
        "Dần (Hổ)" to "Dũng mãnh, quyết đoán, cơ hội bứt phá và mở rộng mối quan hệ xã hội.",
        "Mão (Mèo)" to "Tinh tế, hòa nhã, tài lộc dồi dào, thuận hòa trong gia đạo.",
        "Thìn (Rồng)" to "Uy quyền, sáng tạo, nhiều dự án lớn nhận được sự ủng hộ nhiệt tình.",
        "Tỵ (Rắn)" to "Sâu sắc, tháo vát, quản lý tài chính hiệu quả, sức khỏe dồi dào.",
        "Ngọ (Ngựa)" to "Tự do, nhiệt huyết, hành trình mới rộng mở, đón nhiều niềm vui.",
        "Mùi (Dê)" to "Nhân ái, nghệ thuật, tinh thần thảnh thơi, công danh tấn tới.",
        "Thân (Khỉ)" to "Linh hoạt, mưu lược, giải quyết nhanh các bài toán thử thách kỹ thuật.",
        "Dậu (Gà)" to "Đúng giờ, kỷ luật, uy tín được nâng cao trong tập thể.",
        "Tuất (Chó)" to "Trung thành, đáng tin cậy, đón nhận sự giúp đỡ từ bạn bè chí cốt.",
        "Hợi (Heo)" to "Phúc hậu, an nhiên, cuộc sống tròn đầy ấm êm và thịnh vượng."
    )

    val projectChangelog = listOf(
        ProjectHistoryMilestone(
            date = "19/08/2026",
            version = "v2026.92.0",
            title = "Chuyển đổi Android Studio & Bổ sung Tri Thức Toàn Diện",
            detail = "Chính thức chuyển sang nền tảng Android Studio thuần với Java/XML & Jetpack Compose, tối ưu dung lượng cài đặt ở mức chuẩn 275 MB, tích hợp 5 điều Bác dạy, tiểu sử Bác Hồ, Tiếng Việt 1, LEGO 3D và hệ sinh thái game đa nền tảng.",
            apkSizeMB = 275
        ),
        ProjectHistoryMilestone(
            date = "18/08/2026",
            version = "v2026.80.0",
            title = "Tích hợp Thiên văn học & Tử vi số hóa",
            detail = "Tích hợp giờ mọc/lặn mặt trời - mặt trăng, la bàn số định vị GPS, tử vi 12 con giáp và tạo mã kích hoạt khẩn cấp TVxxxxxxxx.",
            apkSizeMB = 276
        ),
        ProjectHistoryMilestone(
            date = "17/08/2026",
            version = "v2026.76.0",
            title = "Tích hợp chuyển đổi mô hình 3D sang LEGO",
            detail = "Hỗ trợ các dòng LEGO City, Ninjago, Minecraft, Icons, Creator (tự động tính giá gạch lẻ), nén .zip và auto-recover.",
            apkSizeMB = 268
        ),
        ProjectHistoryMilestone(
            date = "16/08/2026",
            version = "v2026.60.0",
            title = "Tái cơ cấu & Dọn dẹp module nặng",
            detail = "Loại bỏ tính năng Travel Town, rút tiền/ví điện tử, trình duyệt web nội bộ để giảm triệt để gần 200 MB dung lượng thừa.",
            apkSizeMB = 260
        ),
        ProjectHistoryMilestone(
            date = "04/08/2026",
            version = "v16.04.2008",
            title = "Phát hành phiên bản đầu tiên 'Tiện ích của Đàm Tường Quân'",
            detail = "Khởi tạo dự án công cụ tổng hợp tại Cao Bằng, hỗ trợ các tiện ích SimCity, Minecraft Bedrock và Sketchware Pro.",
            apkSizeMB = 480
        )
    )
}
