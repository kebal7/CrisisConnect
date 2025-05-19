-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2025 at 07:30 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crisisconnect`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL,
  `disasterId` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `commentContent` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `disasterrecord`
--

CREATE TABLE `disasterrecord` (
  `disasterId` int(11) NOT NULL,
  `disasterTitle` varchar(100) DEFAULT NULL,
  `disasterType` varchar(50) DEFAULT NULL,
  `municipalityOrVdc` varchar(100) DEFAULT NULL,
  `ward` int(3) DEFAULT NULL,
  `longitudeLatitude` varchar(100) DEFAULT NULL,
  `dateOfIncident` date DEFAULT NULL,
  `reportedBy` varchar(50) DEFAULT NULL,
  `assignedCoordinator` varchar(50) DEFAULT NULL,
  `noOfInjuries` int(11) DEFAULT NULL,
  `noOfDeath` int(11) DEFAULT NULL,
  `noOfMissing` int(11) DEFAULT NULL,
  `estimatedLoss` decimal(15,2) DEFAULT NULL,
  `otherNotes` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `disasterrecord`
--

INSERT INTO `disasterrecord` (`disasterId`, `disasterTitle`, `disasterType`, `municipalityOrVdc`, `ward`, `longitudeLatitude`, `dateOfIncident`, `reportedBy`, `assignedCoordinator`, `noOfInjuries`, `noOfDeath`, `noOfMissing`, `estimatedLoss`, `otherNotes`) VALUES
(7, 'Fire at Kamladi', 'Fire', 'Kathmandu', 3, '', '2025-05-21', 'kebal77', '', 0, 0, 0, 0.00, ''),
(8, 'Landslide at Sanga', 'Landslide', 'Kathmandu', 1, '', '2025-05-08', NULL, '', 0, 0, 0, 0.00, ''),
(10, 'Flood at Kamladi', 'Flood', 'Kathmandu', 13, '27.234,85.244', '2025-05-07', 'kebal77', 'Shishir Poudel', 0, 0, 0, 0.00, ''),
(11, 'Flood at Kamladi Tukucha', 'Flood', 'Kathmandu', 13, '27.235,85.245', '2025-05-16', 'kebal77', '', 0, 0, 0, 0.00, ''),
(12, 'Flood at Bishnumati Teku Corridor', 'Flood', 'Lalitpur', 0, '', '2025-05-08', NULL, 'Ronish Prajapati', 0, 0, 0, 0.00, '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `user_type` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` bigint(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` text DEFAULT NULL,
  `image_path` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `full_name`, `user_type`, `password`, `email`, `phone_number`, `dob`, `address`, `image_path`) VALUES
('admin', 'admin', 'admin', 'dCEVigb8Y9vCiWB33ApB7J9POXQffEPnXWuG41zFpZDrZIyhbZxjsgn7PyrRWQFXqQ==', 'admin@gmail.com', 9818181818, '2025-04-29', 'Admin Locaion', 'null'),
('asmitabadal', 'Asmita Badal', 'admin', 'kXVSFM6C5EnLmsHccVWlX7MTQMFhIN8qC8Knz5YJ/XVBLzA4NXx77/bsB/C+ESCfJCOVPvKw7Q==', 'asmita.badal555@gmail.com', 9840207368, '2001-11-30', 'Banepa', 'null'),
('kebal', 'Kebal Badal', 'user', 'JrMjfa32WN5nNytVPKue3Mwcz1GZrB1IvqrTMfO/fK4IqstPiZfFnF+nTSVsZtI=', 'kebalbadal@gmail.com', 9762886391, '2004-02-29', 'Godamchok', 'null'),
('kebal11', 'Kebal Badal', 'user', 'USWgxdDWQNNI5H6xHEOfQcanVavJ/58r+owogRkovE2ZW9GJaxL4/8SNnrZJ3WyDXBAxwg==', 'kebal11@gmail.com', 9862886311, '2005-06-14', 'Banepa', 'null'),
('kebal7', 'Kebal Badal', 'admin', 'cMFdlr1aj+Ii/XzTT4rECZC+oym5XCjEZx//i9+L77E5eT4pC7ezOQc53lnk7h/EyLjVRA==', 'kebal@gmail.com', 9762886392, '2025-05-24', 'Godamchok', 'null'),
('kebal77', 'Kebal Badal', 'admin', 'xsxDNhIVXddGzHtnab/LjS6dn/NajPCYYJpLBaXSkhrWxqJEZlEZMBc7+w/OL42gHJqmFwYd95FiLQ==', 'kebal77@gmail.com', 9762886377, '2025-05-04', 'Godamchok', 'null'),
('ronish', 'Ronish Don', 'admin', 'I19Q/DakC+lQbv/lruB27G/370LjQIh8bVQ5br6rPQmS2D5gqCtTklIYDek5VLlIaUG7IzDs', 'ronish@gmail.com', 9861696009, '2025-05-18', 'Jyatha Thamel', 'null'),
('rooneyish', 'Ronish Prajapati', 'admin', 'faohtYTbpbeaCyw92zOw4OEuJft1JKdaBriyO5pc/vMjYF3YW4nObSid8ifQIpPxo62OxE8=', 'ronishprajapati50@gmail.com', 9861696008, '2000-07-21', 'Jyatha', 'null');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `disasterId` (`disasterId`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `disasterrecord`
--
ALTER TABLE `disasterrecord`
  ADD PRIMARY KEY (`disasterId`),
  ADD KEY `reportedBy` (`reportedBy`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone_number` (`phone_number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `disasterrecord`
--
ALTER TABLE `disasterrecord`
  MODIFY `disasterId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`disasterId`) REFERENCES `disasterrecord` (`disasterId`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `disasterrecord`
--
ALTER TABLE `disasterrecord`
  ADD CONSTRAINT `disasterrecord_ibfk_1` FOREIGN KEY (`reportedBy`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
