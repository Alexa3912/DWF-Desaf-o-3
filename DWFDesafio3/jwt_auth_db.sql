-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-05-2025 a las 06:42:55
-- Versión del servidor: 9.1.0
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jwt_auth_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `registrado_por_github` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `password`, `rol`, `registrado_por_github`) VALUES
(1, 'Bang Chan', 'bangchan@example.com', '$2a$10$7QxEJXQJxk2/5sJqWyZ9ZunxNg6Qlmx6ny/Ez2b8gdpZwFh4NZo/S', 'USER', FALSE),
(2, 'Lee Know', 'leeknow@example.com', '$2a$10$7QxEJXQJxk2/5sJqWyZ9ZunxNg6Qlmx6ny/Ez2b8gdpZwFh4NZo/S', 'USER', FALSE),
(3, 'Changbin', 'changbin@example.com', '$2a$10$7QxEJXQJxk2/5sJqWyZ9ZunxNg6Qlmx6ny/Ez2b8gdpZwFh4NZo/S', 'USER', FALSE),
(4, 'Hyunjin', 'hyunjin@example.com', '$2a$10$7QxEJXQJxk2/5sJqWyZ9ZunxNg6Qlmx6ny/Ez2b8gdpZwFh4NZo/S', 'USER', FALSE),
(5, 'Han', 'han@example.com', '$2a$10$7QxEJXQJxk2/5sJqWyZ9ZunxNg6Qlmx6ny/Ez2b8gdpZwFh4NZo/S', 'USER', FALSE);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
