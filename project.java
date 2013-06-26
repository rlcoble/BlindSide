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
      public project (String line) {
           
           //this.projectTitle = title;
            //this.startDate = sdate;
            //this.endDate = edate;
            //this.description = desc;
            //this.comments = comm;
            //this.status = stat;
            //this.id = idee;
           
      }
     
      // Getter and Setter for Title
      private void setTitle (String title) {
            this.projectTitle = title;
      }
      String getTitle() {
            return projectTitle;
      }
     
      // Getter and Setter for Start Date
      private void setStart(String sdate) {
            this.startDate = sdate;
      }
      private String getSDate() {
            return startDate;
      }
     
      // Getter and Setter for End Date
      private void setEnd(String edate) {
            this.endDate = edate;
      }
      private String getEDate() {
            return endDate;
      }
     
      // Getter and Setter for Description
      private void setDescription(String desc) {
            this.description = desc;
      }
      private String getDescription() {
            return description;
      }
     
      // Bleep dee deep
      private void setComments(String comm) {
            this.comments = comm;
      }
      private String getComments() {
            return comments;
      }
     
      // More
      private void setStatus(String stat) {
            this.status = stat;
      }
      private String getStatus() {
            return status;
      }
     
      // F.I.N.A.L.L.Y.
      private void setID(int i) {
            this.id = i;
      }
      private int getID() {
            return id;
      }
      
      private void setEmployee(String emp){
    	  this.employee = emp;
      }
      
      private String getEmployee(){
    	  return employee;
      }
     
}
