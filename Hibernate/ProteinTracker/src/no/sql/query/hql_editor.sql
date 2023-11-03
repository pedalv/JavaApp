select user from User user, GoalAlert ga
where user.id = ga.id

select user from User user
join user.proteinData pd
where pd.total > 0

select user from User user
where user.proteinData.total > 0

<=>

select
  user0_.id as id1_4_,
  user0_.name as name2_4_,
  user0_.protein_data_id as protein_3_4_ 
 from
  protein_tracker.users user0_ cross 
 join
  protein_tracker.proteindata proteindat1_ 
 where
  user0_.protein_data_id=proteindat1_.id 
  and proteindat1_.total>0
  
  

from GoalAlert

Select user from User user
where user.name = :name

Select user from User user
where user.goalAlerts is not empty

Select user from User user
where user.name = 'Joe'
and user.proteinData.total > 0

from User

from User user

from User as user

select user from User as user