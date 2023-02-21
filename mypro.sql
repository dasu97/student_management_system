-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2020 at 08:30 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mypro`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `sid` int(3) NOT NULL,
  `sname` varchar(50) NOT NULL,
  `sage` int(2) NOT NULL,
  `sgender` varchar(10) NOT NULL,
  `sub1` int(4) NOT NULL,
  `sub2` int(4) NOT NULL,
  `sub3` int(3) NOT NULL,
  `sub4` int(3) NOT NULL,
  `sub5` int(3) NOT NULL,
  `stotal` int(11) NOT NULL,
  `saverage` float NOT NULL,
  `sstatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`sid`, `sname`, `sage`, `sgender`, `sub1`, `sub2`, `sub3`, `sub4`, `sub5`, `stotal`, `saverage`, `sstatus`) VALUES
(1, 'dasuni', 20, 'Female', 12, 34, 56, 78, 91, 271, 54.2, 'PASS'),
(2, 'senuki', 20, 'Female', 12, 23, 45, 67, 46, 193, 38.6, 'PASS'),
(3, 'pawani', 21, 'Female', 24, 46, 36, 12, 60, 178, 35.6, 'PASS'),
(4, 'dasu', 21, 'Female', 12, 22, 23, 21, 21, 99, 19.8, 'FAIL'),
(5, 'madhu', 21, 'Female', 12, 21, 12, 12, 12, 69, 13.8, 'FAIL'),
(6, 'Janith', 21, 'Male', 12, 13, 21, 12, 10, 68, 13.6, 'FAIL'),
(7, 'tharindu', 20, 'Male', 34, 25, 46, 78, 59, 242, 48.4, 'PASS');

-- --------------------------------------------------------

--
-- Table structure for table `fogotpword`
--

CREATE TABLE `fogotpword` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `answer1` varchar(50) NOT NULL,
  `answer2` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fogotpword`
--

INSERT INTO `fogotpword` (`username`, `password`, `answer1`, `answer2`) VALUES
('admin', 'admin', 'home', 'run');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`sid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
