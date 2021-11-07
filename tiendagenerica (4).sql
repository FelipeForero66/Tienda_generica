-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2021 at 06:20 AM
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
(10, 152, '7', 10);

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
  `telefono` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id`, `idTipoDocumento`, `numeroDocumento`, `direccion`, `email`, `nombre`, `telefono`) VALUES
(5, 6, '1001316963', 'Calle 6 A No 88 20', 'jhosetmenjura@gmail.com', 'sebas menjura', '3102681882'),
(7, 6, '1', 'Cra 69 No 12 A 42', 'jhosetmenjura@gmail.com', 'sebas menjura', '3102681882'),
(12, 6, '23123', 'Cra 69 No 12 A 42', 'jhosetmenjura@gmail.com', 'juan', '3102681882');

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
(162, 3, 19000, 'Maleta niño', 100000, 119000),
(163, 4, 38000, 'Maleta Viaje', 200000, 238000),
(164, 6, 28000, 'Maleta Empresarial', 150000, 178000);

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
  `nit` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`id`, `ciudad`, `direccion`, `nombre`, `telefono`, `nit`) VALUES
(3, 'jhosetmenjura@gmail.com', 'Calle 6 A No 88 20 int 11 Apa 504', 'juan', '3102681882', '345'),
(4, 'jhosetmenjura@gmail.com', 'Calle 6 A No 88 20 int 11 Apa 504', 'juan', '3102681882', '1'),
(6, 'jhosetmenjura@gmail.com', 'Calle 6 A No 88 20', 'Jhoset', '2345789', '4');

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
  `nombreUsuario` varchar(255) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `idTipoDocumento`, `numeroDocumento`, `email`, `nombre`, `password`, `nombreUsuario`) VALUES
(1, 6, '1', 'jhosetmenjura@gmail.com', 'Jhoset', '123', 'df'),
(2, 5, '123123', 'armando@', 'juan', '123', 'IanSeAH'),
(10, 6, '1238', 'sebas@gmail.com', 'sebas', '123', 'jhoset96');

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
  `valorVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `venta`
--

INSERT INTO `venta` (`id`, `idCliente`, `idUsuario`, `ivaVenta`, `totalVenta`, `valorVenta`) VALUES
(1, 7, 1, 19000, 100000, 119000),
(2, 5, 1, 38000, 200000, 238000),
(3, 7, 1, 25000, 150000, 125000),
(4, 5, 1, 19000, 200000, 125000),
(5, 5, 1, 9000, 89000, 80000),
(6, 5, 1, 9000, 89000, 80000),
(7, 7, 10, 9000, 89000, 80000);

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
  ADD KEY `FK_PRODUCTO_DETALLE` (`idProducto`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=165;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
