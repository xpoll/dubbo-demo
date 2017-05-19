-- @author xpoll
-- @mail blmdz521@126.com
-- @address www.blmdz.cn

CREATE TABLE `t_student` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('刘涛', '22', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('姜磊', '21', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('张三', '24', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('李四', '22', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('王五', '22', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('赵六', '21', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('田七', '24', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('杨洋', '20', now());
INSERT INTO `t_student` (`name`, `age`, `time`) VALUES ('刘敏', '21', now());
