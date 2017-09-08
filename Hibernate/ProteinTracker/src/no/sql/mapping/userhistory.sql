  CREATE TABLE `protein_tracker`.`USERHISTORY` (
  `id` INT NOT NULL DEFAULT -1,
  `user` INT NOT NULL DEFAULT -1,
  `user_id` INT NOT NULL DEFAULT -1,
  `position` INT NOT NULL DEFAULT -1,
  `entry_identifier` VARCHAR(255) DEFAULT null,
  `entryTime` date,
  `entry` VARCHAR(255));

  commit;

  
  
UserHistory
id:int
user:int
user_id:int
entry_identifier:int -> use on map
position:int -> use on list
entryTime:date
entry:string