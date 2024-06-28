-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: 2024project_java
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblcart`
--

DROP TABLE IF EXISTS `tblcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcart` (
  `cart_id` int NOT NULL,
  `user_id` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `fk_tbluser_idx` (`user_id`),
  CONSTRAINT `fk_tbluser` FOREIGN KEY (`user_id`) REFERENCES `tbluser` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcart`
--

LOCK TABLES `tblcart` WRITE;
/*!40000 ALTER TABLE `tblcart` DISABLE KEYS */;
INSERT INTO `tblcart` VALUES (12346,'12345'),(2021608161,'2021608160'),(5,'4'),(6,'5');
/*!40000 ALTER TABLE `tblcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcartitem`
--

DROP TABLE IF EXISTS `tblcartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcartitem` (
  `cart_item_id` int NOT NULL AUTO_INCREMENT,
  `cart_item_quantity` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `cart_id` int DEFAULT NULL,
  PRIMARY KEY (`cart_item_id`),
  KEY `fk_tblcartitem_product` (`product_id`),
  KEY `fk_cart_idx` (`cart_id`),
  CONSTRAINT `fk_cart` FOREIGN KEY (`cart_id`) REFERENCES `tblcart` (`cart_id`),
  CONSTRAINT `fk_tblcartitem_product` FOREIGN KEY (`product_id`) REFERENCES `tblproduct` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcartitem`
--

LOCK TABLES `tblcartitem` WRITE;
/*!40000 ALTER TABLE `tblcartitem` DISABLE KEYS */;
INSERT INTO `tblcartitem` VALUES (7,3,3,5),(9,5,1,5),(12,1,2,5),(13,1,1,6);
/*!40000 ALTER TABLE `tblcartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcategory`
--

DROP TABLE IF EXISTS `tblcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcategory` (
  `category_id` int NOT NULL,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcategory`
--

LOCK TABLES `tblcategory` WRITE;
/*!40000 ALTER TABLE `tblcategory` DISABLE KEYS */;
INSERT INTO `tblcategory` VALUES (1,'Món tráng miệng'),(2,'Món dùng ngay'),(3,'Đồ uống');
/*!40000 ALTER TABLE `tblcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorder`
--

DROP TABLE IF EXISTS `tblorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblorder` (
  `order_id` int NOT NULL,
  `order_created_date` varchar(45) NOT NULL,
  `order_total_price` int DEFAULT NULL,
  `order_status` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `order_address_shipping` varchar(500) NOT NULL,
  `order_ship_name` varchar(100) DEFAULT NULL,
  `order_ship_price` int DEFAULT NULL,
  `user_id` varchar(15) DEFAULT NULL,
  `payment_id` int DEFAULT NULL,
  `order_date_come` varchar(15) DEFAULT NULL,
  `order_time_come` varchar(15) DEFAULT NULL,
  `order_participants` int DEFAULT NULL,
  `order_message` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_tblorder_paytblproductment` (`payment_id`),
  KEY `fk_tblorder_user` (`user_id`),
  CONSTRAINT `fk_tblorder_paytblproductment` FOREIGN KEY (`payment_id`) REFERENCES `tblpayment` (`payment_id`),
  CONSTRAINT `fk_tblorder_user` FOREIGN KEY (`user_id`) REFERENCES `tbluser` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorder`
--

LOCK TABLES `tblorder` WRITE;
/*!40000 ALTER TABLE `tblorder` DISABLE KEYS */;
INSERT INTO `tblorder` VALUES (-1884797711,'28/06/2024',500000,'Dang duyet','ha noi',NULL,0,'5',1,NULL,NULL,NULL,'hay'),(1,'10/06/2024',293293,'Đã giao','Minh Khai, Hà Nội','tiêu chuẩn',0,'2',1,NULL,NULL,NULL,NULL),(2,'10/06/2024',178000,'Đã giao','Cầu Giấy, Hà Nội','tiêu chuẩn',0,'2',1,NULL,NULL,NULL,NULL),(3,'11/06/2024',218000,'Đã giao','Xuân Thủy, Hà Nội','tiêu chuẩn',0,'2',2,NULL,NULL,NULL,NULL),(4,'10/06/2024',312394,'Đã giao','Hà Nội','nhanh',50000,'2',3,NULL,NULL,NULL,NULL),(5,'23/06/2024',10000,'Đang giao','Phú Minh, Hà Nội','nhanh',50000,'3',1,NULL,NULL,NULL,NULL),(6,'20/06/2024',23430,'Đã giao','Đống Đa, Hà Nội','nhanh',50000,'3',4,NULL,NULL,NULL,NULL),(7,'23/06/2024',29324,'Đang giao','Thái Bình','tiêu chuẩn',0,'2',3,NULL,NULL,NULL,NULL),(8,'23/06/2024',32100,'Đang giao','Thái Bình','tiêu chuẩn',0,'4',1,NULL,NULL,NULL,NULL),(10,'24/06/2024',2000,'Đang giao','Thái Bình','tiêu chuẩn',0,'6',1,NULL,NULL,NULL,NULL),(11,'11/06/2024',29128,'Đã giao','Minh Khai, Hà Nội','tiêu chuẩn',0,'7',1,NULL,NULL,NULL,NULL),(12,'12/06/2024',93124,'Đã giao','Minh Khai, Hà Nội','tiêu chuẩn',0,'8',1,NULL,NULL,NULL,NULL),(13,'22/06/2024',312312,'Đang giao','Minh Khai, Hà Nội','tiêu chuẩn',0,'9',1,NULL,NULL,NULL,NULL),(14,'22/06/2024',312493,'Đang giao','Minh Khai, Hà Nội','tiêu chuẩn',0,'5',2,NULL,NULL,NULL,NULL),(15,'13/06/2024',31312,'Đã giao','Nội Bài','tiêu chuẩn',0,'6',1,NULL,NULL,NULL,NULL),(16,'12/06/2024',312941,'Đã giao','Thanh Hóa','nhanh',50000,'7',2,NULL,NULL,NULL,NULL),(17,'12/06/2024',312941,'Đã giao','Hà Nội','tiêu chuẩn',50000,'8',1,NULL,NULL,NULL,NULL),(18,'29/05/2024',319239,'Đã giao','Hà Nội','nhanh',50000,'9',1,NULL,NULL,NULL,NULL),(19,'12/03/2024',312412,'Đã giao','Hả Nội','nhanh',50000,'10',1,NULL,NULL,NULL,NULL),(20,'15/03/2024',312941,'Đã giao','Sóc Sơn','tiêu chuẩn',50000,'9',2,NULL,NULL,NULL,NULL),(21,'29/03/2024',958321,'Đã giao','Sóc Trăng','nhanh',50000,'3',3,'2024-06-28','13:00 PM',5,'An ngon'),(22,'01/04/2024',391230,'Đã giao','Bạc Liêu','tiêu chuẩn',0,'4',3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tblorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpayment`
--

DROP TABLE IF EXISTS `tblpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpayment` (
  `payment_id` int NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpayment`
--

LOCK TABLES `tblpayment` WRITE;
/*!40000 ALTER TABLE `tblpayment` DISABLE KEYS */;
INSERT INTO `tblpayment` VALUES (1,'VN Pay'),(2,'Thanh toán khi nhận hàng'),(3,'Chuyển khoản qua ngân hàng'),(4,'Thanh toán bằng thẻ ngân hàng');
/*!40000 ALTER TABLE `tblpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpaymentdetail`
--

DROP TABLE IF EXISTS `tblpaymentdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpaymentdetail` (
  `product_id` int NOT NULL,
  `order_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`product_id`,`order_id`),
  KEY `fk_tblorder_detail_idx` (`order_id`),
  CONSTRAINT `fk_tblorder_detail` FOREIGN KEY (`order_id`) REFERENCES `tblorder` (`order_id`),
  CONSTRAINT `fk_tblproduct_detail` FOREIGN KEY (`product_id`) REFERENCES `tblproduct` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpaymentdetail`
--

LOCK TABLES `tblpaymentdetail` WRITE;
/*!40000 ALTER TABLE `tblpaymentdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblpaymentdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproduct`
--

DROP TABLE IF EXISTS `tblproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblproduct` (
  `product_id` int NOT NULL,
  `product_img` varchar(45) DEFAULT NULL,
  `product_name` varchar(45) NOT NULL,
  `product_ingredient` varchar(1000) DEFAULT NULL,
  `product_portion` varchar(45) DEFAULT NULL,
  `product_energy` varchar(100) DEFAULT NULL,
  `product_time_complete` varchar(45) DEFAULT NULL,
  `product_description` varchar(1500) DEFAULT NULL,
  `product_price` int NOT NULL,
  `product_quantity` int NOT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_tblproduct_category` (`category_id`),
  CONSTRAINT `fk_tblproduct_category` FOREIGN KEY (`category_id`) REFERENCES `tblcategory` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproduct`
--

LOCK TABLES `tblproduct` WRITE;
/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
INSERT INTO `tblproduct` VALUES (1,'1-1','Bánh chuối hấp','+ Bánh chuối: Chuối sứ chín, đường vàng, muối Thái, hương va-ni, rượu vodka, tinh dầu chuối, bột năng, dầu hạt cải, bột nếp, màu vàng thực phẩm','1 -2 người','Protein - 30','6 phút','Bánh chuối hấp là một món ăn vặt dân dã của nền ẩm thực Việt. Các đầu bếp của TASTY đã khéo léo kết hợp vị ngọt ngào của những quả chuối sứ chín thơm lừng cùng nước cốt dừa béo ngậy, nhấn nhá một chút hương rượu vodka để gia tăng sự độc đáo trong hương vị từng miếng bánh. Là sự giao thoa tinh tế giữa ẩm thực truyền thống và hơi thở hiện đại, từng miếng bánh chuối dẻo dai được phủ một lớp nước cốt dừa thơm béo, tuy giản dị song lại có sức hấp dẫn lạ lùng với các thực khách gần xa.',49000,40,1),(2,'1-2','Dương chi cam lộ','Puree xoài, xoài tươi, tép bưởi da xanh, bột báng','1 người','Protein - 22','7 phút','Dương chi cam lộ là một món tráng miệng xuất phát từ Hongkong với nguyên liệu chính là bưởi chùm (bưởi, xoài và bột mì). Dựa theo hương vị nguyên bản, các bếp trưởng TASTY đã điều chỉnh món ăn theo khẩu vị người Việt Nam bằng việc kết hợp các nguyên liệu nội địa cao cấp: xoài cát Hòa Lộc, bưởi Năm Roi, sữa hoa hồng... Với hương vị chua ngọt, thanh mát đến từ hoa quả, dương chi cam lộ sẽ làm vị giác của bạn dịu lại sau mỗi bữa ăn. Món ăn cũng chứa nhiều thành phần dinh dưõng (vitamin A, C, D & khoáng chất) góp phần làm đẹp da và cải thiện hệ thống tiêu hóa.',56000,47,1),(3,'1-3','Nha đam pha lê','Nha đam, bột rau câu, đường cát, sả, lá chanh thái','1 người','Protein - 23.2','8 phút','Là món tráng miệng độc quyền của đầu bếp tài năng TASTY. Món ăn đã có vinh dự được thưởng thức và đón nhận qua nhiều tổng thống, lãnh tụ quốc gia của nhiều nước. Nay xuất hiện trên thực đơn của nhà hàng TASTY với sứ mệnh nâng tầm trải nghiệm ẩm thực của thực khách. Từ dưỡng chất kỳ diệu của nha đam, món tráng miệng đem đến sự thanh mát, nhẹ nhàng có tác dụng làm đẹp da, tóc và vóc dáng của phái đẹp. Ngoài ra nha đam còn bổ sung nước cho cơ thể, thanh nhiệt cho hệ tiêu hóa, tăng cường hệ miễn dịch. Để đem đến bữa tiệc \"thị & vị giác\" cho khách hàng, đầu bếp TASTY còn khéo léo tô điểm thêm nhiều loại trái cây nhiệt đới.',56000,47,1),(4,'2-1','Salad rau mùa sốt cam','Xà lách carol, xà lách frise, xà lách lô lô tím, xà lách mỡ, xà lách radicchio tím, táo đỏ, táo xanh, cà chua bi, củ cải đường, rau mầm, cà rốt baby, trái olive đen, trái olive xanh.','1 - 2 người','Protein - 28, Carbs - 24, Fats - 8','6 - 8 phút','Salad rau mùa sốt cam TASTY là sự lựa chọn tuyệt vời cho các tín đồ yêu eat clean. Món ăn có đến 5 loại xà lách (carol, frise, lô lô tím, xà lách mỡ và radicchio tím) kết hợp cùng các loại trái cây như táo, cà chua, ô liu... mang lại nguồn vitamin tổng hợp dồi dào, hỗ trợ tăng cường đề kháng cho cơ thể. Điểm nhấn tạo nên nét chấm phá cho món nằm ở nước sốt cam độc đáo với vị chua ngọt tự nhiên dịu dàng. Salad rau mùa sốt cam TASTY thực sự là một bữa tiệc về màu sắc, xua tan cơn nóng mùa hè, đánh thức tối đa vị giác.',69000,40,2),(5,'2-2','Salad rau mùa sốt mác mác','Táo đỏ, táo xanh, củ dền, cà rốt, xà lách lolo, xà lách carron, chanh dây, dầu oliu, rau quế, mayonaise,...','1 người','Protein: 2.2, Carbs: 14.4, Fat: 12.2, Total Kcal: 157.8','15 phút','Salad rau mùa sốt mác mác được lựa chọn từ những loại rau củ ẩm thực phương Tây như xà lách lolo, xà lách carron, dầu oliu, kết hợp với hương đồng cỏ nội trong văn hoá ẩm thực Việt Nam là củ dền, táo đỏ, táo xanh, chanh dây và rau quế. Tất cả được hòa quyện dưới lớp sốt mác mác rau mùi được cấu thành bởi 3 thành phần chính là chanh dây, rau mùi và mayonaise, đem đến hương vị độc đáo, giàu vitamin C và chất xơ.',69000,43,2),(6,'2-3','Phở cuốn TASTY','Nạc vai bò Úc, bánh ướt, húng lủi, húng quế, ngò gai, giá sống, cà chua, hành phi, đậu phộng, nước mắm, đường cát Biên Hòa, giấm nuôi, tỏi lột, mè trắng, bột thịt gà, tiêu đen','1 người','Protein - 28.33, Carbs - 24.93, Fats - 8.97 (Total Kcal - 293.77)','15 phút','Phở cuốn TASTY là món ăn được các đầu bếp TASTY Kitchen dành nhiều thời gian dày công chế biến. Với bánh phở tạo ra từ hạt gạo ngâm suốt 12 tiếng liền, sau đó xay và tráng cách thủy mang đến miếng bánh ướt mỏng, dai dai hoàn toàn tự nhiên. Thêm vào đó là sự kết hợp hài hòa cùng nguyên liệu bò Úc thượng hạng tẩm ướp đậm vị và các loại rau thơm nhiệt đới. Khi thưởng thức kèm nước sốt chấm được pha chế đặc biệt mang đến trải nghiệm ẩm thực tuyệt hảo, đầy thú vị.',83000,30,2),(7,'2-4','Salad bò Nam Bộ','Thăn bò, húng quế, ngò gai, rau càng cua, lá cóc, lá quế vị, xà lách lô lô xanh, tắc, khế, cà pháo, hành tím, sả, ớt sừng, mè trắng, lá chanh thái','3 người','Protein - 23.165, Carbs - 7.4, Fats - 6.1 (Total Kcal - 177.16)','15 phút','Salad bò Nam Bộ tại TASTY Kitchen là món ăn vô cùng đặc sắc với sự kết hợp tinh tế của nhiều nguyên liệu làm khơi dậy vị giác của thực khách. Những phần bò fillet cung cấp lượng protein cần thiết cho sức khỏe cùng những loại rau dân dã và mộc mạc như càng cua, lá quế tươi mát. Bên cạnh đó còn có vị chua của nhiều loại trái cây giàu vitamin C như khế chua, tắc được cân bằng bởi sự ngọt dịu của sốt salad đã tạo nên một món ăn vô cùng hấp dẫn.',127000,29,2),(8,'2-5','Sụn gà xóc muối Tây Ninh','Sụn gà, muối Tây Ninh, trứng gà, sả, nghệ, lá chanh, ớt sừng, hành phi, tỏi phi, tôm khô, chà bông heo, bột chiên xù','2 người','Protein - 19, Carbs - 5.8, Fats - 4 (Total Kcal - 135.2)','15 phút','Món sụn gà xóc muối Tây Ninh là một món ăn vặt hoàn hảo với độ giòn từ lớp bột bên ngoài và độ dai dai từ sụn gà bên trong. Các đầu bếp TASTY Kitchen đã sáng tạo khéo léo khi kết hợp muối ớt Tây Ninh và các gia vị hấp dẫn giúp tạo nên một món ăn mới lạ với mùi thơm cùng hương vị đậm đà. Món ăn được gói gọn trong một chiếc tổ chim làm bằng sả chiên, không chỉ đẹp mắt mà thực khách có thể thưởng thức độ giòn thơm, vị vừa ăn.',137000,31,2),(9,'2-6','Nem lụi nướng mía','Mỡ gáy, thịt nạc mông, giò sống heo, mía cây, màu thực phẩm, chất tạo độ dai thực phẩm, bột nở, bột bắp, tiêu đen, tiêu sọ trắng, sả cây, hành tím, tỏi, mật ong, mắm khô, bột ngũ vị hương, bột ngọt, đường cát','1 - 3người','Protein - 19, Carbs - 5.8, Fats - 4 (Total Kcal - 135.2)','10 - 12 phút','Nem lụi được biết đến là đặc sản của vùng đất kinh kỳ đồng thời là lựa chọn mà mọi tín đồ yêu thích ẩm thực không thể bỏ qua. Món ăn hấp dẫn ngay từ cái nhìn đầu tiên với màu sắc vàng ươm cùng mùi vị thơm lừng sau khi được nướng lên. Thực khách sẽ cảm nhận trọn vẹn vị đậm đà pha chút mềm dai của thịt heo, giò sống hài hòa với các gia vị đặc biệt. Thêm vào đó, Nem lụi TASTY còn ngon hơn khi dùng kèm bánh tráng, bún tươi, rau sống và nước chấm sền sệt, vị bùi ngậy do chính các đầu bếp TASTY sáng tạo.',160000,160,2),(10,'3-1','Trà hibiscus thanh yên 330ml','Trà xanh hoa lài Đài Loan, hoa lạc thần, mứt thanh yên Nhật, trân châu trắng','1 người','Protein - 14','3 phút','Trà hibiscus thanh yên là sự kết hợp tinh tế giữa 2 loại trà xanh hoa lài Đài Loan, hoa lạc thần và mứt thanh yên. Thức uống bật lên hương vị đậm và thơm của trà & hậu vị thanh mát chua nhẹ',59000,80,3),(11,'3-2','Trà oloong bưởi hồng 330ml','Trà Oolong, mứt bưởi đỏ, trân châu trắng','1 người','Protein - 13','3 phút','Trà Oloong bưởi hồng trà là một trong những thức uống độc đáo nhất trong menu trà hoa quả nhà TASTY. Hương vị thân thuộc của trà Oloong mang đến trải nghiệm đầy mới lạ khi kết hợp với mứt bưởi hồng. Nhấp 1 ngụm trà để từ từ cảm nhận vị đắng nhẹ từ vỏ bưởi ngọt ngọt chua chua khó cưỡng, cùi bưởi và trân châu trắng dai giòn hòa quyện mượt mà cùng vị chát dịu dàng từ trà Oloong. Điểm nhấn của thức uống nằm ở topping cùi bưởi và tép bưởi thật 100%, mang đến hương vị thanh mát thuần tự nhiên. ',59000,91,3),(12,'3-3','Trà lài nhãn 330ml','Trà xanh hoa lài Đài Loan, syrup nhãn, trái nhãn','1 người','Protein - 15','3 phút','Trà lài luôn là khởi đầu dễ chịu để sáng tạo nên những thức uống thanh nhiệt thú vị. Khi kết hợp cùng long nhãn, trà lài được cân bằng độ chát nhẹ bằng vị ngọt dịu thanh nhã, tạo nên một thức uống giải nhiệt, an thần hiệu quả.',59000,98,3),(13,'3-4','Trà vải hoa hồng 330ml','Trà xanh hoa lài Đài Loan, vải hoa hồng.','1 người','Protein - 13.5','3 phút','Trà vải hoa hồng là sự kết hợp hoàn hảo của trà xanh hoa nhài Đài Loan đậm vị, cùng mứt vải hoa hồng dịu dàng thơm ngọt tạo nên thứ thức uống quyến rũ đầy tươi mát. Topping vải ngâm chua ngọt hấp dẫn góp phần hoàn thiện hương vị tuyệt hảo của món trà. Thưởng thức một cốc trà vải hoa hồng mát lạnh chắc chắn sẽ là một sự lựa chọn hoàn hảo, giúp xua tan đi cái nóng oi ả của tiết trời mùa hè.',59000,101,3),(14,'3-5','Trà lài kiwi nha đam 330ml','Trà xanh hoa lài Đài Loan, mứt kiwi, nha đam, syrup sả lá dứa','1 người','Protein - 14','3 phút','Đúng như tên gọi là một món nước hoàn hảo dành cho phái đẹp giúp đẹp da, giữ dáng và chống lão hóa. Từ các nguyên liệu chọn lọc như: tuyết yến, nhựa đào, long nhãn, nấm đông trùng hạ thảo, táo đỏ, kỷ tử, hạt sen, hạt chia,...được nấu tỉ mỉ cùng đường cỏ ngọt, một loại đường tốt cho sức khỏe công dụng hỗ trợ giảm cân, mang đến vị ngọt thanh mát dễ dàng chinh phục từng thực khách khó tính nhất',59000,90,3),(15,'3-6','Trà sữa masala 330ml','Trà đen Lâm Hà, syrup masala chai, bột sữa tách béo','1 người','Protein - 17','3 phút','Trà sữa Masala là sự kết hợp đầy tinh tế của trà đen có nguồn gốc từ vùng trà nổi tiếng Lâm Hà, Lâm Đồng cùng bột sữa cao cấp và syrup spicy tự nấu từ các loại thảo mộc gia vị. Được dày công nghiên cứu bởi những đội ngũ đầu bếp TASTY Kitchen, Trà sữa Masala được xem như bản giao hưởng mượt mà của vị trà sữa thơm bùi, ngọt dịu lại đậm đà hương thơm thảo mộc thiên nhiên. Hãy chọn trà sữa Masala để có được những trải nghiệm sảng khoái và tươi mới nhất cho hè này. ',59000,87,3),(16,'3-7','Trà sữa oloong 330ml','Trà oolong Bảo Lộc, bột sữa tách béo ','1 người','Protein - 12','3 phút','Trà sữa Oolong TASTY là sự hòa quyện của tinh túy giữa trà oolong vùng Bảo Lộc trứ danh và bột sữa thơm béo. Với tỷ lệ trà, sữa và đường phù hợp, mỗi ly trà sữa oolong có vị ngọt thanh dịu nhẹ, dễ dàng làm xiêu lòng mọi tín đồ trà sữa. TASTY Kitchen hy vọng, mỗi ly trà sữa oloong sẽ giúp quý khách tận hưởng vị ngon lan tỏa đến từng giác quan và tiếp thêm năng lượng cho ngày tươi mới.',59000,79,3),(17,'3-8','Trà sữa lài hoa đậu biếc 330ml','Trà xanh hoa lài, trà hoa đậu biếc, trân châu trắng, bột sữa tách béo','1 người','Protein - 12.2','3 phút','Nguyên liệu chính của thức uống là trà xanh hoa lài Đài Loan kết hợp cùng trà hoa đậu biếc được ngâm ủ cẩn thận để sản phẩm có vị đậm đà và hương thơm đặc trưng. Trà kết hợp cùng bột sữa tách béo và phần topping trân châu trắng dai giòn, mang đến một thức uống có hương vị ngọt thanh mà không quá béo ngậy. Món trà mang màu xanh tím tự nhiên vô cùng đẹp mắt, hơn nữa còn có tác dụng giúp đẹp da, ngăn ngừa lão hóa, tăng cường hệ miễn dịch và tốt cho sức khỏe tim mạch.',59000,99,3);
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbluser` (
  `user_id` varchar(15) NOT NULL,
  `user_firstname` varchar(200) DEFAULT NULL,
  `user_birthday` varchar(45) DEFAULT NULL,
  `user_address` varchar(500) DEFAULT NULL,
  `user_phone` varchar(45) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `user_pass` varchar(100) NOT NULL,
  `user_status` int unsigned DEFAULT NULL,
  `user_role` varchar(15) NOT NULL,
  `user_created_date` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluser`
--

LOCK TABLES `tbluser` WRITE;
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` VALUES ('10','Nguyễn Duy Thái','10/01/2003','Quảng Ninh','0986674521','nguyenduythai03@gmail.com','123456',1,'User','08/06/2024'),('11','Nguyen My Hanh','07/07/2003','Dong Anh','0987654123','nmhanh03@gmail.com','123456',1,'User','08/06/2024'),('12345','Hup canh','12/08/2002','Viet Nam','0343611390','bechlervivan68@hotmail.com','123456',1,'User','2024-06-28'),('1234567','Hehe','12/08/2002','ha noi','0987035442','nhquan50@gmail.com','123456',0,'User','2024-06-28'),('2','Nguyễn Hồng Quân','12/09/2003','Sóc Sơn, Hà Nội','0338329262','nhquan15550@gmail.com','123456',1,'Admin','08/06/2024'),('2021608160','An','2005-08-22','Ha Noi','09999988899','An@gmail.com','12345',1,'User','2024-06-28'),('3','Nguyễn Văn Việt','01/01/2003','Hà Nội','0338329263','nguyenvanviet@gmail.com','123456',1,'Admin','08/06/2024'),('4','Nguyễn Thế Bình','12/08/2003','Phú Minh, Sóc Sơn','0987035443','thbn120803@gmail.com','123456',1,'User','08/06/2024'),('5','Trần Đăng Bình','08/02/2003','Phú Minh, Sóc Sơn','0863726481','binhdb03@gmail.com','123456',1,'User','08/06/2024'),('6','Bùi Quang Huy','05/05/2003','Kim Lũ','0983762451','bqhuy03@gmail.com','123456',1,'User','08/06/2024'),('7','Trần Ngọc Hải','07/05/2003','Hà Nội','0938217322','tnhai03@gmail.com','123456',1,'User','08/06/2024'),('8','Đỗ Huy Hoàng','06/05/2003','Thái Bình','0987362514','dhhoang03@gmail.com','123456',1,'User','08/06/2024'),('9','Hoàng Kim Quang','08/09/2002','Thái Bình','0987654332','hkquang0903@gmail.com','123456',1,'User','08/06/2024');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-28 19:09:59
