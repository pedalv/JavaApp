CREATE SCHEMA `protein_tracker` DEFAULT CHARACTER SET utf8 ;

drop table protein_tracker.users;

CREATE TABLE `protein_tracker`.`USERS` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `total` INT NOT NULL DEFAULT 0,
  `goal` INT NOT NULL DEFAULT 100,
  PRIMARY KEY (`id`));

commit;

User
id:int
name:string
total:int
goal:int


CREATE TABLE `protein_tracker`.`USERS` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

commit;
  
User
id:int
name:string


CREATE TABLE `protein_tracker`.`USERS` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `protein_data_id` INT NOT NULL DEFAULT -1,
  PRIMARY KEY (`id`));

commit;

User
id:int
name:string
protein_data_id:int



User
id:int
name:string
goalAlert: goalAlert
goalAlerts: SET<GoalAert>
ProteinData:ProteinData
history: Set|list|Map|Collection<UserHistory>
