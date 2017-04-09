--
-- user表结构
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `role` varchar(40) DEFAULT '',
  `email` varchar(40) DEFAULT '',
  `phone` varchar(20) DEFAULT '',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 事务管理测试表tbl_account
--
DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account` (
  `money` int(10) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;