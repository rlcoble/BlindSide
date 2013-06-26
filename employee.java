import java.util.ArrayList;

public class employee {
	String name;
	ArrayList<project> projects;
	ArrayList<Integer> projectIDs;
	
	// Constructor when given a name
	public employee(String line){
		this.name = line;
	}

	// Empty constructor
	public employee(){
		
	}

	// Getter and setter for Employee name field
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return name;
	}

	// Add projects to employee or get list of projects
	public void addProjects(project proj) {
		this.projects.add(proj);
	}
	public ArrayList<project> getProjects () {
		return projects;
	}
	
	// Add a new project id or return list of project ids
	public void addProjID(int id) {
		this.projectIDs.add(id);
	}
	public ArrayList<Integer> getProjIDs() {
		return projectIDs;
	}
}
