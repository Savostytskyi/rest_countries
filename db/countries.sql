-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2015 at 06:04 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `countries`
--

-- --------------------------------------------------------

--
-- Table structure for table `countries_info`
--

CREATE TABLE `countries_info` (
  `id` int(6) NOT NULL,
  `name` varchar(40) NOT NULL,
  `capital` varchar(30) NOT NULL,
  `population` int(20) DEFAULT NULL,
  `currency` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `countries_info`
--

INSERT INTO `countries_info` (`id`, `name`, `capital`, `population`, `currency`) VALUES
(1, 'Austria', 'Vienna', 8507786, 'Euro'),
(2, 'Belgium', 'Brussels', 11203992, 'Euro'),
(3, 'Germany', 'Berlin', 80780000, 'Euro'),
(4, 'Liechtenstein', 'Vaduz', 37129, 'Swiss frank'),
(5, 'Monaco', 'Monaco', 38066, 'Euro'),
(6, 'Netherlands', 'Amsterdam', 16887700, 'Euro'),
(7, 'Byelorussia', 'Minsk', 9481000, 'Belarusian ruble'),
(8, 'Bulgaria', 'Sofia', 7245677, 'Lev'),
(9, 'Ukraine', 'Kiev', 42741248, 'Ukrainian grivn'),
(10, 'Czech Republic', 'Prague', 10512419, 'Czech Koruna'),
(11, 'Austria', 'Vienna', 0, 'Euro'),
(12, 'test', 'test', 500, 'fdf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `countries_info`
--
ALTER TABLE `countries_info`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
