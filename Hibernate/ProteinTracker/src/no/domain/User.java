package no.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

	private int id;
	private String name;
	
	//none-to-one or one-to-zero
	//private GoalAlert goalAlert;
	
	//many-to-many
	private Set<GoalAlert> goalAlerts = new HashSet<GoalAlert>();
	
	
	//private ProteinData proteinData = new ProteinData();
	
	//one to one
	private ProteinData proteinData;
	
	public User() {
		setProteinData(new ProteinData());
	}
	
	//SET
	//private Set<UserHistory> history = new HashSet<UserHistory>();
	
	//LIST
	private List<UserHistory> history = new ArrayList<UserHistory>();
	
	//MAP
	//private Map<String, UserHistory> history = new HashMap<String, UserHistory>();
		
	//BAG
	//private Collection<UserHistory> history = new ArrayList<UserHistory>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		//one to one
		proteinData.setUser(this);
	}
	
	/* BAG 
	public Collection<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Collection<UserHistory> history) {
		this.history = history;
	}
	*/
	/* MAP 
	public Map<String, UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Map<String, UserHistory> history) {
		this.history = history;
	}
	*/
	/* SET
	public Set<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Set<UserHistory> history) {
		this.history = history;
	}
	*/
	
	/* LIST */
	public List<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	
	/* One to many */
	public void addHistory(UserHistory historyItem)
	{
		historyItem.setUser(this);
		history.add(historyItem);
	}
	public Set<GoalAlert> getGoalAlerts() {
		return goalAlerts;
	}
	public void setGoalAlerts(Set<GoalAlert> goalAlerts) {
		this.goalAlerts = goalAlerts;
	}
	
	/* one-to-one or one-to-zero 
	public GoalAlert getGoalAlert() {
		return goalAlert;
	}
	public void setGoalAlert(GoalAlert goalAlert) {
		this.goalAlert = goalAlert;
	}
	*/
	
	


	
}
	
