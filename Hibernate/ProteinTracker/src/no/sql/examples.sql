/*  Not use in production
<property name="hibernate.hbm2ddl.auto">create</property
*/

CREATE SCHEMA `protein_tracker` DEFAULT CHARACTER SET utf8 ;

drop table protein_tracker.users;

CREATE TABLE `protein_tracker`.`USERS` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `total` INT NOT NULL DEFAULT 0,
  `goal` INT NOT NULL DEFAULT 100,
  PRIMARY KEY (`id`));

commit;


CREATE TABLE `protein_tracker`.`USER_HISTORY` (
  `id` INT NOT NULL,
  `position` INT NOT NULL DEFAULT 0,
  `entry_identifier` VARCHAR(255),
  `entryTime` date,
  `entry` VARCHAR(255));
commit;

