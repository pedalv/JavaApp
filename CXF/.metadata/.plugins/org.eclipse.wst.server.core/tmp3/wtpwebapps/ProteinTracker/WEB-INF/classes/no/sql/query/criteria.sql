User user = new User();
user.setName("joe");
Example e = Example.create(user)
	.ignoreCase();
criteria criteria = session.createCriteria(User.class)
	.add(e);

	
session.createCriteria(User.class)
.createAlias("proteinData", "pd")
.add(Restrictions.or(
		Restrictions.eq("name","Joe"),
		Restrictions.eq("name","Bob")
	)).setProjection(Projections.property("pd.total")); 

	
session.createCriteria(User.class)
.add(Restrictions.or(
	Restrictions.eq("name","Joe"),
	Restrictions.eq("name","Bob")
)).setProjection(Projections.projectionList()
	.add(Projections.property("name"))
	.add(Projections.property("id"))
);


session.createCriteria(User.class)
.add(Restrictions.or(
	Restrictions.eq("name","Joe"),
	Restrictions.eq("name","Bob")
)).setProjection(Projections.groupProperty("id"));


session.createCriteria(User.class)
.add(Restrictions.or(
	Restrictions.eq("name","Joe"),
	Restrictions.eq("name","Bob")
)).setProjection(Projections.groupProperty("id"));


session.createCriteria(User.class)
.add(Restrictions.or(
	Restrictions.eq("name","Joe"),
	Restrictions.eq("name","Bob")
));


session.createCriteria(User.class)