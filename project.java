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
      
      // Constructor
      public project (String title, String sdate, String edate, String desc, String comm, String stat, int idee) {
           
            this.projectTitle = title;
            this.startDate = sdate;
            this.endDate = edate;
            this.description = desc;
            this.comments = comm;
            this.status = stat;
            this.id = idee;
           
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
     
}