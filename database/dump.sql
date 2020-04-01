-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.13 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_demo_spring_boot
CREATE DATABASE IF NOT EXISTS `db_demo_spring_boot` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci */;
USE `db_demo_spring_boot`;

-- Dumping structure for table db_demo_spring_boot.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table db_demo_spring_boot.category: 2 rows
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `code`, `name`) VALUES
	(1, NULL, NULL, NULL, NULL, 'the-thao', 'Thể Thao'),
	(2, NULL, NULL, NULL, NULL, 'thoi-su', 'Thời Sự');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table db_demo_spring_boot.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `content` text COLLATE utf8mb4_vietnamese_ci,
  `short_desc` text COLLATE utf8mb4_vietnamese_ci,
  `thumbnail` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKryugyuqj7jjkqd3byc5meoocy` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table db_demo_spring_boot.news: 3 rows
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `content`, `short_desc`, `thumbnail`, `title`, `category_id`) VALUES
	(1, NULL, NULL, NULL, NULL, 'content api api test 1', 'short desc api test 1', 'thumbnail api test 1', 'title api test 1', 2),
	(2, NULL, NULL, NULL, NULL, 'content api api test 2', 'short desc api test 2', 'thumbnail api test 2', 'title api test 2', 1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- Dumping structure for table db_demo_spring_boot.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table db_demo_spring_boot.role: 0 rows
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table db_demo_spring_boot.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table db_demo_spring_boot.user: 0 rows
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table db_demo_spring_boot.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- Dumping data for table db_demo_spring_boot.user_role: 0 rows
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
