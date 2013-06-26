import java.util.ArrayList;


public class employee {
	
	public String name;
	public ArrayList<project> projects = new ArrayList<project>();
	public ArrayList<Integer> projectIDs = new ArrayList<Integer>();
	
	public employee(String line){
		this.name = line;
	}
	
	public employee(){
		
	}

	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Integer> getProjectIDs(){
		return projectIDs;
	}
	
	public void setProjectIDs(int id){
		this.projectIDs.add(id);
	}
	
	protected ArrayList<project> getProjects(){
		return projects;
	}

}
