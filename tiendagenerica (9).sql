-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2021 at 01:07 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiendagenerica`
--

-- --------------------------------------------------------

--
-- Table structure for table `buscarnumeros`
--

CREATE TABLE `buscarnumeros` (
  `id` int(11) NOT NULL,
  `numeroProducto` int(11) NOT NULL,
  `numeroCliente` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `numeroUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `buscarnumeros`
--

INSERT INTO `buscarnumeros` (`id`, `numeroProducto`, `numeroCliente`, `numeroUsuario`) VALUES
(1, 155, '1', 2),
(2, 158, '2', 234),
(3, 152, '6', 3),
(4, 152, '4', 3),
(5, 159, '745896', 58272),
(6, 155, '2', 1),
(7, 155, '785278', 1),
(8, 155, '2', 1),
(9, 155, '5', 1),
(10, 152, '7', 10),
(11, 163, '7', 1),
(12, 163, '14', 10),
(13, 163, '1001316963', 10),
(14, 162, '23123', 10),
(15, 163, '14', 10),
(16, 163, '23123', 10),
(17, 162, '14', 10),
(18, 163, '23123', 10),
(19, 163, '5', 10),
(20, 163, '5', 10),
(21, 163, '12', 10),
(22, 163, '7', 10),
(23, 162, '5', 1),
(24, 163, '14', 10),
(25, 163, '12', 10),
(26, 163, '1', 10),
(27, 163, '12', 10),
(28, 163, '12', 10),
(29, 163, '5', 10),
(30, 163, '5', 10),
(31, 163, '7', 1),
(32, 163, '5', 10),
(33, 163, '23123', 10),
(34, 163, '7', 10),
(35, 162, '7', 10),
(36, 162, '5', 10),
(37, 162, '7', 2),
(38, 163, '', 10),
(39, 163, '', 10),
(40, 163, '2', 10),
(41, 163, '5', 10),
(42, 163, '5', 10),
(43, 163, '5', 10),
(44, 165, '12', 10),
(45, 164, '12', 10),
(46, 163, '2', 1238),
(47, 163, '5', 1238),
(48, 163, '5', 2);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `numeroDocumento` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `sede` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id`, `idTipoDocumento`, `numeroDocumento`, `direccion`, `email`, `nombre`, `telefono`, `sede`) VALUES
(25, 6, '1', 'Cra 69 No 12 A 42', 'jhosetmenjura@gmail.com', 'caro', '3102681882', 0),
(26, 6, '125256', 'cra 69 1758', 'juan@gmail', 'juani peluche', '1244568', 0),
(28, 5, '12323', 'Calle 6 A No 88 20', 'jhosetmenjura@gmail.com', 'juanito', '3102681882', 1),
(29, 6, '23', 'Calle 6 A No 88 20', 'jhosetmenjura@gmail.com', 'sebas menjura', '3102681882', 1),
(30, 6, '345654', 'Calle 6 A No 88 20', 'jhosetmenjura@gmail.com', 'sebas menjura', '3102681882', 2),
(31, 6, '100', 'Calle 6 A No 88 20', 'sebasf@gmail.com', 'sebas menjura f', '3102681882', 2),
(32, 6, '23412', 'Calle 6 A No 88 20', 'sebasmgmail.com', 'sebas menjura', '3102681882', 3),
(33, 6, '26', 'Calle 6 A No 88 20', 'jhosetmenjura@gmail.com', 'CAMILO FLORIAN', '123124', 3);

-- --------------------------------------------------------

--
-- Table structure for table `detalleventa`
--

CREATE TABLE `detalleventa` (
  `id` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `cantidadProducto` int(11) NOT NULL,
  `valorTotal` double NOT NULL,
  `valorVenta` double NOT NULL,
  `valorIva` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `ivaCompra` double NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id`, `idProveedor`, `ivaCompra`, `nombre`, `precioCompra`, `precioVenta`) VALUES
(243, 10, 900, 'Melon', 9000, 9900),
(244, 10, 300, 'fresa', 3000, 3600),
(245, 10, 600, 'Sandia', 6000, 6600),
(248, 12, 1800, 'Fresas', 18000, 19800),
(249, 12, 500, 'Guayavas', 3000, 3500),
(250, 12, 1000, 'Alverjas', 9000, 10000),
(251, 12, 3000, 'Sandia', 27000, 30000),
(252, 12, 2000, 'Chocolate', 12000, 14000),
(253, 12, 1800, 'papaya', 18000, 19800);

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `ciudad` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `telefono` varchar(15) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `nit` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `Sede` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`id`, `ciudad`, `direccion`, `nombre`, `telefono`, `nit`, `Sede`) VALUES
(10, 'Bogota', 'Calle 6 A No 88 20', 'juan', '3102681882', '1235689', NULL),
(12, 'Bogota', 'Calle 6 A No 88 20', 'juan', '3102681882', '123456', 1),
(13, 'Cali', 'Cra 68 # 12-A ', 'Cristobal Soria', '25589', '5236897', 2),
(14, 'Cali', 'Cra 69 No 12 A 42', 'Andrea Florez', '5689745', '3697852', 2),
(15, 'Medellin', 'Calle 6 A No 88 20 int 11 Apa 504', 'caro forero', '256898', '2459523', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `id` int(11) NOT NULL,
  `tipo` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `tipodocumento`
--

INSERT INTO `tipodocumento` (`id`, `tipo`) VALUES
(5, 'REGISTRO CIVIL'),
(6, 'CEDULA'),
(7, 'TARJETA IDENTIDAD');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `numeroDocumento` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `nombreUsuario` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `sede` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `idTipoDocumento`, `numeroDocumento`, `email`, `nombre`, `password`, `nombreUsuario`, `sede`) VALUES
(1, 5, '4589', 'Fres85@hotmail', 'Camila Fresneda', '123', 'df', 1),
(29, 5, '1', 'sebas@gmail.com', 'sebas menjura', '123', 'juan99', 0),
(37, 6, '6', 'PerezRozo@gmail.com', 'Perez Rozo Pereira', '123', 'PR', 1),
(39, 6, '4567', 'Francisco@gmail.com', 'Alejandra Forero', '123', 'AL', 2),
(40, 6, '25', 'SM@GMAIL.COM', 'sebas menjura', '123', 'SM', 3);

-- --------------------------------------------------------

--
-- Table structure for table `venta`
--

CREATE TABLE `venta` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `ivaVenta` double NOT NULL,
  `totalVenta` double NOT NULL,
  `valorVenta` double NOT NULL,
  `Sede` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `venta`
--

INSERT INTO `venta` (`id`, `idCliente`, `idUsuario`, `ivaVenta`, `totalVenta`, `valorVenta`, `Sede`) VALUES
(27, 26, 29, 38000, 200000, 238000, 1),
(31, 28, 1, 1800, 2010000, 18000, 1),
(32, 29, 1, 1800, 5100000, 18000, 1),
(33, 31, 39, 5800, 3163600, 54000, 2),
(34, 33, 40, 4800, 1727600, 39000, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buscarnumeros`
--
ALTER TABLE `buscarnumeros`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_TIPODOCUMENTO_CLIENTE` (`idTipoDocumento`);

--
-- Indexes for table `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_PRODUCTO_DETALLE` (`idProducto`),
  ADD KEY `detalle_venta_ibfk_1` (`idVenta`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_PROVEEDOR_PRODUCTO` (`idProveedor`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_ibfk_1` (`idTipoDocumento`);

--
-- Indexes for table `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CLIENTE_VENTA` (`idCliente`),
  ADD KEY `FK_USUARIO_VENTA` (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buscarnumeros`
--
ALTER TABLE `buscarnumeros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=254;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`id`);

--
-- Constraints for table `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`id`),
  ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`id`);

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FK_PROVEEDOR_PRODUCTO` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`id`);

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`id`);

--
-- Constraints for table `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_CLIENTE_VENTA` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK_USUARIO_VENTA` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_USUARIO_VENTA2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
