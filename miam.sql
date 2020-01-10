-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 09 jan. 2020 à 13:12
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `miam`
--
CREATE DATABASE IF NOT EXISTS `miam` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `miam`;

-- --------------------------------------------------------

--
-- Structure de la table `commander`
--

DROP TABLE IF EXISTS `commander`;
CREATE TABLE IF NOT EXISTS `commander` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `cEval` int(11) DEFAULT NULL,
  `cEtat` varchar(30) NOT NULL DEFAULT 'en_attente',
  `prixTot` double NOT NULL DEFAULT 0,
  `idCompte` int(11) NOT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `id` (`idCompte`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commander`
--

INSERT INTO `commander` (`idCommande`, `cEval`, `cEtat`, `prixTot`, `idCompte`) VALUES
(1, NULL, 'en_attente', 0, 1),
(2, NULL, 'en_attente', 0, 2);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `idCompte` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `mdp` varchar(8) NOT NULL,
  `email` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'client',
  `compteEtat` varchar(30) NOT NULL DEFAULT 'en_attente ',
  PRIMARY KEY (`idCompte`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`idCompte`, `nom`, `mdp`, `email`, `type`, `compteEtat`) VALUES
(1, 'Jordan', 'jordan1', 'jordan@gmail.com', 'client', 'en_attente '),
(2, 'Hubert', 'hubert1', 'hubert@gmail.com', 'client', 'en_attente '),
(3, 'Alban', 'alban1', 'alban@gmail.com', 'client', 'en_attente '),
(4, 'Admin', 'admin2', 'admin@gmail.com', 'admin', 'valide'),
(6, 'Jordan', 'client', 'jo', 'client', 'en_attente ');

-- --------------------------------------------------------

--
-- Structure de la table `devis`
--

DROP TABLE IF EXISTS `devis`;
CREATE TABLE IF NOT EXISTS `devis` (
  `idDevis` int(11) NOT NULL AUTO_INCREMENT,
  `dEval` int(11) DEFAULT NULL,
  `dEtat` varchar(30) NOT NULL DEFAULT 'en_attente',
  `prix` double NOT NULL DEFAULT 0,
  `quoi` varchar(500) DEFAULT NULL,
  `idCompte` int(11) NOT NULL,
  PRIMARY KEY (`idDevis`),
  KEY `id_dev` (`idCompte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `idCom` int(11) NOT NULL,
  `idProd` int(11) NOT NULL,
  `qte` int(11) NOT NULL,
  PRIMARY KEY (`idCom`,`idProd`),
  KEY `id_prod` (`idProd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`idCom`, `idProd`, `qte`) VALUES
(1, 1, 3),
(1, 35, 2),
(2, 11, 2);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `idProduit` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) NOT NULL,
  `prix` double NOT NULL DEFAULT 0,
  `taille` varchar(30) NOT NULL DEFAULT 'grand',
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`idProduit`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idProduit`, `libelle`, `prix`, `taille`, `type`) VALUES
(1, 'chocolatine', 2, 'Grand', 'viennoiserie'),
(3, 'chocolatine', 0.75, 'mini', 'viennoiserie'),
(5, 'pain au chocolat', 1.2, 'grand', 'viennoiserie'),
(6, 'pain au chocolat', 0.6, 'mini', 'viennoiserie'),
(7, 'croissant', 1, 'grand', 'viennoiserie'),
(8, 'croissant', 0.5, 'mini', 'viennoiserie'),
(9, 'pain au raisin', 1.7, 'grand', 'viennoiserie'),
(10, 'pain au raisin ', 0.85, 'mini', 'viennoiserie'),
(11, 'chausson au pomme', 1.3, 'grand', 'viennoiserie'),
(12, 'chausson au pomme', 0.65, 'mini', 'viennoiserie'),
(13, 'poulet', 4, 'grand', 'sandwich'),
(14, 'poulet', 2, 'demi', 'sandwich'),
(15, 'saumon', 5, 'grand', 'sandwich'),
(16, 'saumon', 2.5, 'demi', 'sandwich'),
(17, 'jambon', 3, 'grand', 'sandwich'),
(18, 'jambon', 1.5, 'demi', 'sandwich'),
(19, 'vegetarien', 7, 'grand', 'sandwich'),
(20, 'vegetarien', 3.5, 'demi', 'sandwich'),
(21, 'fraisier', 8, 'grand', 'gateau'),
(22, 'fraisier', 1, '1 part', 'gateau'),
(23, 'framboisier', 9, 'grand', 'gateau'),
(24, 'framboisier', 2, '1 part', 'gateau'),
(25, 'tarte au pomme', 7, 'grand', 'gateau'),
(26, 'tarte au pomme', 0.8, '1 part', 'gateau'),
(27, 'basque', 10, 'grand', 'gateau'),
(28, 'basque', 2.5, '1 part', 'gateau'),
(29, 'eau', 2, 'grand', 'boisson'),
(30, 'eau', 1, '50 cl', 'boisson'),
(31, 'oasis', 3, 'grand', 'boisson'),
(32, 'oasis', 1.5, '30 cl', 'boisson'),
(33, 'coca', 4, '50 cl', 'boisson'),
(34, 'coca', 2, '30 cl', 'boisson'),
(35, 'cafe', 3, 'long', 'boisson'),
(36, 'cafe', 1.5, 'court', '');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commander`
--
ALTER TABLE `commander`
  ADD CONSTRAINT `id` FOREIGN KEY (`idCompte`) REFERENCES `compte` (`idCompte`);

--
-- Contraintes pour la table `devis`
--
ALTER TABLE `devis`
  ADD CONSTRAINT `id_dev` FOREIGN KEY (`idCompte`) REFERENCES `compte` (`idCompte`);

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `id_com` FOREIGN KEY (`idCom`) REFERENCES `commander` (`idCommande`),
  ADD CONSTRAINT `id_prod` FOREIGN KEY (`idProd`) REFERENCES `produit` (`idProduit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
