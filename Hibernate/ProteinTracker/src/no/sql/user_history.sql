
CREATE TABLE `protein_tracker`.`USER_HISTORY` (
  `id` INT NOT NULL DEFAULT -1,
  `user_id` INT NOT NULL DEFAULT -1,
  `position` INT NOT NULL DEFAULT -1,
  `entry_identifier` VARCHAR(255) DEFAULT null,
  `entryTime` date,
  `entry` VARCHAR(255));

  commit;
  