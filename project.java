//import java.util.ArrayList;
 
public class project {
      public String projectTitle;
      public String startDate;
      public String endDate;
      public String description;
      public String comments;
      public String status;
      public int id;
      public String employee;
      String username;
      
      // Constructor
      public project (String line) {
          this.projectTitle = line.substring(0, line.indexOf(" | "));
          this.startDate = line.substring(line.indexOf(" | ")+3, line.indexOf(" || "));
          this.endDate = line.substring(line.indexOf(" || ")+4, line.indexOf(" ||| "));
          this.description = line.substring(line.indexOf(" ||| ")+5, line.indexOf(" |||| "));
          this.comments = line.substring(line.indexOf(" |||| ")+6, line.indexOf(" ||||| "));
          this.status = line.substring(line.indexOf(" ||||| ")+7, line.indexOf(" |||||| "));
          this.username = line.substring(line.indexOf(" |||||| ")+8, line.indexOf("|@|"));
          this.employee = line.substring(line.indexOf(" |@| ")+5);
          //this.id = BS.employees.get(index);
           
      }
      
      public project(){
  		
  	  }
     
      // Getter and Setter for Title
      protected void setTitle (String title) {
            this.projectTitle = title;
      }
      protected String getTitle() {
            return projectTitle;
      }
     
      // Getter and Setter for Start Date
      protected void setStart(String sdate) {
            this.startDate = sdate;
      }
      protected String getSDate() {
            return startDate;
      }
     
      // Getter and Setter for End Date
      protected void setEnd(String edate) {
            this.endDate = edate;
      }
      protected String getEDate() {
            return endDate;
      }
     
      // Getter and Setter for Description
      protected void setDescription(String desc) {
            this.description = desc;
      }
      protected String getDescription() {
            return description;
      }
     
      // Bleep dee deep
      protected void setComments(String comm) {
            this.comments = comm;
      }
      protected String getComments() {
            return comments;
      }
     
      // More
      protected void setStatus(String stat) {
            this.status = stat;
      }
      protected String getStatus() {
            return status;
      }
     
      // F.I.N.A.L.L.Y.
      protected void setID(int i) {
            this.id = i;
      }
      protected int getID() {
            return id;
      }
      
      protected void setEmployee(String emp){
    	  this.employee = emp;
      }
      
      protected String getEmployee(){
    	  return employee;
      }
      
      protected String getUsername(){
    	  return username;
      }
      protected void setUsername(String user) {
    	  this.username = user;
      }
     
}
