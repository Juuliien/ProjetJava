-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 07 juin 2019 à 22:57
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;



DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id`) VALUES
(2019),
(2020);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trimestre_id` int(11) NOT NULL,
  `inscription_id` int(11) NOT NULL,
  `appreciation` text COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `trimestre_id` (`trimestre_id`),
  KEY `inscription_id` (`inscription_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `trimestre_id`, `inscription_id`, `appreciation`) VALUES
(3, 1, 6, 'test');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomclasse` varchar(24) COLLATE latin1_general_ci NOT NULL,
  `Niveau_id` int(11) NOT NULL,
  `AnneeScolaire_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Niveau_id` (`Niveau_id`),
  KEY `AnneeScolaire_id` (`AnneeScolaire_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `nomclasse`, `Niveau_id`, `AnneeScolaire_id`) VALUES
(1, '6eme1', 1, 2019),
(2, '6eme2', 1, 2019),
(3, '5eme1', 2, 2019),
(4, '6eme3', 1, 2019),
(5, '5eme2', 2, 2019);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bulletin_id` int(11) NOT NULL,
  `enseignement_id` int(11) NOT NULL,
  `appreciationmat` text COLLATE latin1_general_ci,
  PRIMARY KEY (`id`),
  KEY `bulletin_id` (`bulletin_id`),
  KEY `enseignement_id` (`enseignement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id`, `bulletin_id`, `enseignement_id`, `appreciationmat`) VALUES
(1, 3, 3, ''),
(2, 3, 3, ''),
(3, 3, 11, NULL),
(4, 3, 11, NULL),
(5, 3, 8, NULL),
(6, 3, 9, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomdiscipline` varchar(24) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id`, `nomdiscipline`) VALUES
(1, 'maths'),
(2, 'physique');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classe_id` int(11) NOT NULL,
  `discipline_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classe_id` (`classe_id`),
  KEY `discipline_id` (`discipline_id`),
  KEY `personne_id` (`personne_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`id`, `classe_id`, `discipline_id`, `personne_id`) VALUES
(3, 1, 1, 12),
(4, 2, 2, 13),
(7, 2, 1, 16),
(8, 2, 2, 17),
(9, 1, 1, 18),
(11, 4, 1, 24),
(12, 1, 1, 25);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detailbulletin_id` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `appreciationeval` text COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `detailbulletin_id` (`detailbulletin_id`),
  KEY `detailbulletin_id_2` (`detailbulletin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `detailbulletin_id`, `note`, `appreciationeval`) VALUES
(1, 1, 2, 'nul\r\n'),
(2, 1, 2, 'nul\r\n'),
(3, 2, 0, 'tres nul'),
(5, 5, 10, 'passable'),
(6, 6, 22, 'ezae');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classe_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classe_id` (`classe_id`),
  KEY `personne_id` (`personne_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `classe_id`, `personne_id`) VALUES
(6, 5, 9);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomniveau` varchar(24) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nomniveau`) VALUES
(1, '6eme'),
(2, '5eme');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(24) COLLATE latin1_general_ci NOT NULL,
  `prenom` varchar(24) COLLATE latin1_general_ci NOT NULL,
  `type` varchar(12) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `type`) VALUES
(1, 'Testt', 'Test', 'eleve'),
(2, 'Test', 'Testzaeaz', 'eleve'),
(3, 'Test2', 'Test2', 'enseignant'),
(4, 'Test3', 'Test3', 'eleve'),
(5, 'Test4', 'Test4', 'eleve'),
(6, 'Test', 'test', 'eleve'),
(7, 'samy', 'samy', 'eleve'),
(8, 'sammy', 'sam', 'eleve'),
(9, 'liu', 'julien', 'eleve'),
(10, 'michel', 'michel', 'enseignant'),
(11, 'micheel', 'michelle', 'enseignant'),
(12, 'micheel', 'CCCCCCC', 'enseignant'),
(13, 'micheel', 'michelle', 'enseignant'),
(14, 'micheel', 'michelle', 'enseignant'),
(15, 'micheel', 'michelle', 'enseignant'),
(16, 'micheel', 'michelle', 'enseignant'),
(17, 'micheel', 'michelle', 'enseignant'),
(18, 'zzeae', 'azea', 'enseignant'),
(19, '', '', 'enseignant'),
(20, 'luc', 'luc', 'enseignant'),
(21, 'mmcj', 'rfr', 'eleve'),
(22, 'zae', 'aze', 'eleve'),
(23, 'zzeae', 'azea', 'enseignant'),
(24, 'micheel', 'm', 'enseignant'),
(25, 'micheel', 'BBBBBBBBB', 'enseignant');

-- --------------------------------------------------------

--
-- Structure de la table `trismestre`
--

DROP TABLE IF EXISTS `trismestre`;
CREATE TABLE IF NOT EXISTS `trismestre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `AnneeScolaire_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AnneeScolaire_id` (`AnneeScolaire_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `trismestre`
--

INSERT INTO `trismestre` (`id`, `numero`, `debut`, `fin`, `AnneeScolaire_id`) VALUES
(1, 1, '2018-09-03', '2018-12-21', 2019),
(2, 1, '2019-09-02', '2019-12-20', 2020);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `bulletin_ibfk_1` FOREIGN KEY (`trimestre_id`) REFERENCES `trismestre` (`id`),
  ADD CONSTRAINT `bulletin_ibfk_2` FOREIGN KEY (`inscription_id`) REFERENCES `inscription` (`id`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`Niveau_id`) REFERENCES `niveau` (`id`),
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`AnneeScolaire_id`) REFERENCES `anneescolaire` (`id`);

--
-- Contraintes pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `detailbulletin_ibfk_1` FOREIGN KEY (`bulletin_id`) REFERENCES `bulletin` (`id`),
  ADD CONSTRAINT `detailbulletin_ibfk_2` FOREIGN KEY (`enseignement_id`) REFERENCES `enseignement` (`id`);

--
-- Contraintes pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `enseignement_ibfk_1` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_2` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_3` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`detailbulletin_id`) REFERENCES `detailbulletin` (`id`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `inscription_ibfk_2` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `trismestre`
--
ALTER TABLE `trismestre`
  ADD CONSTRAINT `trismestre_ibfk_1` FOREIGN KEY (`AnneeScolaire_id`) REFERENCES `anneescolaire` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
