-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 25, 2016 at 01:14 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbadminlte`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` bit(1) NOT NULL,
  `fullname` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `enabled`, `fullname`, `image`, `password`, `email`) VALUES
('admin', b'1', 'Tạ Duy Hoàng', 'user_hoang.jpg', '$2a$10$ioyBUv9gJCSoMZdf83d5g.Ce2jtPcUon/w5MPsk30pN02Rk9qKVie', 'duyhoanptit@gmail.com'),
('hoang.td', b'1', NULL, 'user_hoang.jpg', '$2a$10$PlcweSMerl5I6MlgjRMSrOAYQUT1IB351wjK3QExWrfAam0Hr7BLi', NULL),
('hoangptit', b'1', 'Tạ Duy Hoàng', 'user_hoang.jpg', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'duyhoanptit@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `account_role`
--

CREATE TABLE IF NOT EXISTS `account_role` (
  `accounts_username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `roles_roleId` int(11) NOT NULL,
  PRIMARY KEY (`accounts_username`,`roles_roleId`),
  KEY `FKjnvjc4gplw7bhq7bcyma4y031` (`roles_roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account_role`
--

INSERT INTO `account_role` (`accounts_username`, `roles_roleId`) VALUES
('admin', 1),
('hoang.td', 1),
('hoangptit', 1);

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE IF NOT EXISTS `blog` (
  `blogId` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`blogId`),
  KEY `FKnphtql81e0budiffjgau46rn5` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `itemId` int(11) NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci,
  `link` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `published_date` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `blog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  KEY `FKjcl8ks0hdimy797728g8scsg4` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `nameRole` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `nameRole`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_EMPLOYEE');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account_role`
--
ALTER TABLE `account_role`
  ADD CONSTRAINT `FK3ullthaoc42ieenpwxc140fw9` FOREIGN KEY (`accounts_username`) REFERENCES `account` (`username`),
  ADD CONSTRAINT `FKjnvjc4gplw7bhq7bcyma4y031` FOREIGN KEY (`roles_roleId`) REFERENCES `role` (`roleId`);

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `FKnphtql81e0budiffjgau46rn5` FOREIGN KEY (`username`) REFERENCES `account` (`username`);

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FKjcl8ks0hdimy797728g8scsg4` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`blogId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
