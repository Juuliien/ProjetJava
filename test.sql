-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 30 avr. 2019 à 13:37
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `piscine`
--

-- --------------------------------------------------------

--
-- Structure de la table `acheteur`
--

DROP TABLE IF EXISTS `acheteur`;
CREATE TABLE IF NOT EXISTS `acheteur` (
  `id` int(11) NOT NULL,
  `identifiant` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acheteur`
--

INSERT INTO `acheteur` (`id`, `identifiant`, `password`) VALUES
(1, 'Julien34', '123456'),
(2, 'Martin57', '365421'),
(3, 'Jules62', '658974'),
(4, 'hugo92', '6598742'),
(5, 'Paul38', '2369874'),
(32, 'lilian466', '123456');

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `id` int(11) NOT NULL,
  `identifiant` varchar(255) NOT NULL,
  `password` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`id`, `identifiant`, `password`) VALUES
(1, 'Juliette32', 2369874),
(2, 'Charlotte38', 3987562),
(3, 'Sebastien25', 6598741),
(4, 'Jean25', 546982),
(5, 'Zoe', 657894);

-- --------------------------------------------------------

--
-- Structure de la table `connexion`
--

DROP TABLE IF EXISTS `connexion`;
CREATE TABLE IF NOT EXISTS `connexion` (
  `ID` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `identifiant` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `connexion`
--

INSERT INTO `connexion` (`ID`, `type`, `identifiant`, `password`) VALUES
(1, 'Vendeur', 'Julien38', '123456'),
(2, 'Vendeur', 'Martin93', '654321'),
(3, 'Vendeur', 'Hugo92', '564321'),
(4, 'Vendeur', 'Pierre69', '546321'),
(5, 'Vendeur', 'Antoine37', '532146'),
(6, 'Vendeur', 'Valentin92', '132456'),
(7, 'Vendeur', 'Jessica22', '213456'),
(8, 'Acheteur', 'Juliette36', '265431'),
(9, 'Acheteur', 'Emma68', '345612'),
(10, 'Acheteur', 'Louise', '516432'),
(11, 'Acheteur', 'Jade', '614532'),
(12, 'Acheteur', 'Florian38', '621534'),
(13, 'Acheteur', 'Manon', '634125'),
(14, 'Administrateur', 'Gabriel54', '987654'),
(15, 'Administrateur', 'Lucas45', '945687'),
(16, 'Administrateur', 'Mila36', '945612'),
(17, 'Administrateur', 'Arthur42', '456723'),
(18, 'Administrateur', 'Alice22', '369852'),
(19, 'Administrateur', 'Liam56', '345789'),
(20, 'Administrateur', 'Paul39', '654781'),
(21, 'Administrateur', 'Anna', '642358');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `ID` int(11) NOT NULL,
  `Auteur` varchar(255) NOT NULL,
  `TItre` varchar(255) NOT NULL,
  `Date` int(11) NOT NULL,
  `Genre` varchar(256) NOT NULL,
  `Prix` decimal(4,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`ID`, `Auteur`, `TItre`, `Date`, `Genre`, `Prix`) VALUES
(1, 'Franck Thilliez', 'Luca', 2019, 'Policier', '23.04'),
(2, 'J.K.Rowling', 'Harry Potter et la chambre des secrets', 2003, 'Fantastique', '9.78'),
(3, 'Will Peterson ', 'Triskellion ', 2009, 'Fantastique', '11.78'),
(4, 'Sophie Jordan', 'Lueur de Feu', 2011, 'fantastique', '7.04'),
(5, 'Ian Manook', 'Yeruldelgger', 2013, 'Policier', '13.54'),
(6, 'Guy Delisle', 'Chroniques de Jérusalem', 2011, 'bande dessinée', '14.00'),
(7, 'Eric Simard ', 'Le souffle de la pierre d\'Irlande', 2007, 'Fantastique', '4.54'),
(8, 'Shaun Tan', 'Là où vont nos pères', 2007, 'bande desinée', '7.19'),
(9, 'Michel Bussi', 'Nymphéas noirs', 2011, 'Policier', '8.24'),
(10, 'Riad Sattouf', 'L\'Arabe du futur', 2015, 'Bande desinée', '14.00'),
(11, 'Olivier Norek', 'Entre deux mondes', 2018, 'Policier', '16.25'),
(12, 'Julie Dachez', 'La différence invisible', 2016, 'Bande desinée', '12.96'),
(13, 'Christophe Garda', 'Serpentis : Le gardien des Registres', 2013, 'Fantastique', '6.00'),
(14, 'Elliot Skell', '\r\nLa Maison Sans-Pareil', 2012, 'Fantastique', '9.46'),
(15, 'Michel Bussi', 'Maman a tort', 2015, 'Policier', '9.84'),
(16, 'Guy Delisle', 'Chroniques birmanes', 2007, 'Bande dessinée', '16.00'),
(17, 'Michel Bussi', 'Le Temps est assassin', 2016, 'Policier', '12.14'),
(18, 'Brandon Mull', 'Animal Tatoo', 2014, 'Fantastique', '5.99'),
(19, 'Fred Vargas', 'Debout les morts', 2000, 'Policier', '12.99'),
(20, 'Didier Conrad', 'Astérix chez les Pictes', 2013, 'Bande dessinée', '8.00');

-- --------------------------------------------------------

--
-- Structure de la table `musique`
--

DROP TABLE IF EXISTS `musique`;
CREATE TABLE IF NOT EXISTS `musique` (
  `ID` int(11) NOT NULL,
  `Titre` varchar(255) NOT NULL,
  `Auteur` varchar(255) NOT NULL,
  `Date` int(11) NOT NULL,
  `Genre` varchar(255) NOT NULL,
  `Prix` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `musique`
--

INSERT INTO `musique` (`ID`, `Titre`, `Auteur`, `Date`, `Genre`, `Prix`) VALUES
(1, 'Lose Yourself', 'Eminem', 2008, 'rap', 1),
(2, 'Smells Like Teen Spirit', 'Nirvana ', 1991, 'Rock', 1),
(3, 'Sultans of Swing', 'Dire Straits', 1978, 'rock', 1),
(4, 'the Message', 'Nas', 1996, 'rap', 2),
(5, 'Saïan', 'RZA', 2003, 'Hip-hop', 2),
(6, 'Beastie', 'Beastie Boys', 1982, 'Hip-hop', 2),
(7, 'We will rock you', 'Queen', 1977, 'Rock', 2),
(8, 'Juicy', 'The Notorious B.I.G.', 1994, 'Rap', 3),
(9, 'Karma Police', 'Radiohead', 1997, 'rock', 3),
(10, 'Regulate', 'Warren G', 1994, 'Hip-hop', 1);

-- --------------------------------------------------------

--
-- Structure de la table `sports et loisir`
--

DROP TABLE IF EXISTS `sports et loisir`;
CREATE TABLE IF NOT EXISTS `sports et loisir` (
  `ID` int(11) NOT NULL,
  `Catégorie` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prix` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sports et loisir`
--

INSERT INTO `sports et loisir` (`ID`, `Catégorie`, `Nom`, `Prix`) VALUES
(1, 'Fitness et Musculation', 'Barre de traction', 39),
(2, 'Fitness et Musculation', 'Appareils abdominaux', 115),
(3, 'Fitness et Muculation', 'Corde à sauter', 8),
(4, 'Fitness et Musculation', 'Tapis', 21),
(5, 'Cyclisme', 'vélos de ville', 299),
(6, 'Pêche', 'Moulinets pêche en mer', 11),
(7, 'Pêche', 'Leurres souples', 14);

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

DROP TABLE IF EXISTS `vendeur`;
CREATE TABLE IF NOT EXISTS `vendeur` (
  `Id` int(11) NOT NULL,
  `identifiant` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vendeur`
--

INSERT INTO `vendeur` (`Id`, `identifiant`, `password`) VALUES
(1, 'Jessica24', '23656464'),
(2, 'Gabriel36', '3453455'),
(3, 'jules31', '3354531'),
(4, 'Martin47', '5378315'),
(5, 'Emma37', '3544533');

-- --------------------------------------------------------

--
-- Structure de la table `vêtement`
--

DROP TABLE IF EXISTS `vêtement`;
CREATE TABLE IF NOT EXISTS `vêtement` (
  `ID` int(11) NOT NULL,
  `Genre` varchar(255) NOT NULL,
  `Catégorie` varchar(255) NOT NULL,
  `Taille` varchar(255) NOT NULL,
  `Prix` int(11) NOT NULL,
  `Marque` varchar(255) NOT NULL,
  `Couleur` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vêtement`
--

INSERT INTO `vêtement` (`ID`, `Genre`, `Catégorie`, `Taille`, `Prix`, `Marque`, `Couleur`) VALUES
(1, 'Femme', 'Robes', 'S', 10, 'Yming', 'Vert'),
(2, 'Femme', 'Robes', 'M', 10, 'Yming', 'Bleu'),
(3, 'femme', 'Jeans', '36', 44, 'Levi\'s', 'noir'),
(4, 'femme', 'Jeans', '40', 51, 'Levi\'s', 'bleu'),
(5, 'homme', 'Jeans', '38', 70, 'Levi\'s', 'noir'),
(6, 'homme', 'jeans', '40', 80, 'Pepe Jeans', 'blanc'),
(7, 'homme', 'T-shirts', 'M', 70, 'Lacoste', 'gris'),
(8, 'homme', 'Chemises', 'L', 49, 'Meraki', 'blanc'),
(9, 'homme', 'chaussure', '42', 76, 'Nike', 'noir'),
(10, 'Femmme', 'chaussure', '38', 101, 'Lacoste', 'Blanc'),
(11, 'homme', 'Manteau', 'XL', 100, 'Red Bridge', 'noir');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
