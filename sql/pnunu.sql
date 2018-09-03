SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pnunu_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `pnunu_roles_permissions`;
CREATE TABLE `pnunu_roles_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL,
  `permission` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roles_permissions_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pnunu_roles_permissions
-- ----------------------------
INSERT INTO `pnunu_roles_permissions` VALUES ('1', 'admin1', 'user:select');

-- ----------------------------
-- Table structure for pnunu_users
-- ----------------------------
DROP TABLE IF EXISTS `pnunu_users`;
CREATE TABLE `pnunu_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_id_uindex` (`id`),
  UNIQUE KEY `users_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pnunu_users
-- ----------------------------
INSERT INTO `pnunu_users` VALUES ('1', 'pnunu0', 'pnunu22');

-- ----------------------------
-- Table structure for pnunu_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `pnunu_user_roles`;
CREATE TABLE `pnunu_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_roles_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pnunu_user_roles
-- ----------------------------
INSERT INTO `pnunu_user_roles` VALUES ('1', 'admin1', 'pnunu0');
INSERT INTO `pnunu_user_roles` VALUES ('2', 'user1', 'pnunu0');

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL,
  `permission` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roles_permissions_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES ('1', 'admin', 'user:select');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_id_uindex` (`id`),
  UNIQUE KEY `users_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'pnunu', 'pnunu');

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_roles_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES ('1', 'admin', 'pnunu');
INSERT INTO `user_roles` VALUES ('2', 'user', 'pnunu');
