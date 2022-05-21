-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2022 at 09:01 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `egpower`
--

-- --------------------------------------------------------

--
-- Table structure for table `inquirypower`
--

CREATE TABLE IF NOT EXISTS `inquirypower` (
  `Iqid` int(4) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(100) NOT NULL,
  `acc_num` varchar(30) NOT NULL,
  `area` varchar(40) NOT NULL,
  `date` varchar(40) NOT NULL,
  `reason` varchar(100) NOT NULL,
  PRIMARY KEY (`Iqid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `paymentpower`
--

CREATE TABLE IF NOT EXISTS `paymentpower` (
  `pay_ID` int(4) NOT NULL AUTO_INCREMENT,
  `pay_method` varchar(50) NOT NULL,
  `account_no` varchar(40) NOT NULL,
  `pay_date` varchar(40) NOT NULL,
  `pay_amount` varchar(50) NOT NULL,
  PRIMARY KEY (`pay_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
