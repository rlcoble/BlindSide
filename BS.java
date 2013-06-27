import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class BS extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	String[] statuses = {"Notified", "Started", "Almost Complete", "Complete"}; //if selectionIndex is 0, display error. or delete
	static ArrayList<employee> employees			= new ArrayList<employee>();
	static ArrayList<project> projects				= new ArrayList<project>();
	
	static ArrayList<String> empNames				= new ArrayList<String>();
	static ArrayList<String> projNames				= new ArrayList<String>();
	JList names										= new JList(empNames.toArray());
	JList projs										= new JList(/*projNames.toArray()*/); //make show a subset of projNames
	
	JOptionPane	error								= new JOptionPane();
	
	JComboBox statusList 							= new JComboBox(statuses);
	
	JFrame trackerWindow 	     		 			= new JFrame("Tracker Window");

	JPanel topPanel 	     		 				= new JPanel();
	JPanel bottomPanel 	     		 				= new JPanel();
	
	JButton showButton								= new JButton("Show");
	JButton addEmployeeButton						= new JButton("Add");
	JButton deleteEmployeeButton					= new JButton("Delete");
	JButton clearButton								= new JButton("Clear");
	JButton showAllButton							= new JButton("Show All");
	JButton saveButton								= new JButton("Save");
	JButton resetButton								= new JButton("Reset");
	JButton addProjectButton						= new JButton("Add New Project");
	JButton closeButton								= new JButton("Close");
	
	JDialog addProjectPopup							= new JDialog();
	JDialog employeeView							= new JDialog();
	
	JTextField showTextField						= new JTextField("");
	JTextField addEmployeeTextField					= new JTextField("");
	JTextField titleTextField						= new JTextField("");
	JTextField startTextField						= new JTextField("");
	JTextField endTextField						    = new JTextField("");
	JTextField employeeTextField					= new JTextField("");
	JTextField usernameTextField					= new JTextField("");
	
	JTextArea descriptionTextArea					= new JTextArea();
	JTextArea commentsTextArea						= new JTextArea();
	
	JScrollPane employeeScrollPane 	   				= new JScrollPane(names);
	JScrollPane projectScrollPane					= new JScrollPane(projs);
	JScrollPane descScrollPane						= new JScrollPane(descriptionTextArea);
	JScrollPane commScrollPane						= new JScrollPane(commentsTextArea);
	
	JLabel showLabel								= new JLabel("Search Employees (First Last):", SwingConstants.CENTER);
	JLabel addEmployeeLabel							= new JLabel("Add Employee (First Last):", SwingConstants.CENTER);
	JLabel titleLabel								= new JLabel("Project Title:");
	JLabel startDateLabel							= new JLabel("Start Date:");
	JLabel endDateLabel								= new JLabel("Projected End Date:");
	JLabel descriptionLabel							= new JLabel("Description:");
	JLabel commentsLabel							= new JLabel("Comments:");
	JLabel statusLabel								= new JLabel("Status:");
	JLabel employeeLabel							= new JLabel("Employee:");
	JLabel projectsLabel							= new JLabel("Projects:");
	JLabel usernameLabel							= new JLabel("Username");
	
	
	
	public static void main(String[] args) throws Exception{
		File f = new File("names.txt");
		File f2 = new File("projects.txt");
		String line = null;
		String line2 = null;
		
		if(f.exists()){
			if(f.length() != 0){
				FileReader fr 		= new FileReader("names.txt");
				BufferedReader br 	= new BufferedReader(fr);
				while((line = br.readLine()) != null){
					employee e = new employee(line);
					employees.add(e);
				}
				fr.close();
				br.close();
			}
		}
		else{
			FileWriter fw		= new FileWriter("names.txt");
			fw.write("");
			fw.close();
		}
		for(int i = 0; i<employees.size(); i++){
			empNames.add(employees.get(i).getName());
		}
		
		if(f2.exists()){
			if(f2.length() != 0){
				FileReader fr2 		= new FileReader("projects.txt");
				BufferedReader br2 	= new BufferedReader(fr2);
				while((line2 = br2.readLine()) != null){
					project p = new project(line2);
					projects.add(p);
					p.setID(projects.indexOf(p));
				}
				fr2.close();
				br2.close();
			}
		}
		else{
			FileWriter fw2		= new FileWriter("projects.txt");
			fw2.write("");
			fw2.close();
		}
		for(int i = 0; i<projects.size(); i++){
			projNames.add(projects.get(i).getTitle());
			for(int r = 0; r<employees.size(); r++){
				if(employees.get(r).getName().equals(projects.get(i).getEmployee()))
					employees.get(r).setProjectIDs(projects.get(i).getID());
			}
		}
		
		new BS();
	}
	
	public BS() {
		names.setVisible(false);
		
		topPanel.setLayout(new GridLayout(1,8));
		topPanel.add(showLabel);
		topPanel.add(showTextField);
		topPanel.add(showButton);
		topPanel.add(showAllButton);
		topPanel.add(clearButton);
		topPanel.add(addEmployeeLabel);
		addEmployeeButton.setBackground(Color.GREEN);
		addEmployeeButton.setOpaque(true);
		topPanel.add(addEmployeeTextField);
		topPanel.add(addEmployeeButton);
		
		
		bottomPanel.setLayout(new GridLayout(1,1));
		bottomPanel.add(deleteEmployeeButton);
		deleteEmployeeButton.setBackground(Color.RED);
		deleteEmployeeButton.setOpaque(true);
		deleteEmployeeButton.setVisible(false);
		
		trackerWindow.getContentPane().add(topPanel,"North");
		trackerWindow.getContentPane().add(employeeScrollPane);
		trackerWindow.getContentPane().add(bottomPanel,"South");
		
		showButton.addActionListener(this);
		showAllButton.addActionListener(this);
		addEmployeeButton.addActionListener(this);
		clearButton.addActionListener(this);
		deleteEmployeeButton.addActionListener(this);
		resetButton.addActionListener(this);
		saveButton.addActionListener(this);
		names.addMouseListener(this);
		projs.addMouseListener(this);
		addProjectButton.addActionListener(this);
		closeButton.addActionListener(this);
		
		trackerWindow.setSize(1500,800);
		trackerWindow.setVisible(true);
		trackerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addProjectPopup.setLayout(new GridLayout(8,2,0,3));
		
		addProjectPopup.add(titleLabel);
		addProjectPopup.add(titleTextField);
		titleLabel.setLabelFor(titleTextField);
		
		addProjectPopup.add(startDateLabel);
		addProjectPopup.add(startTextField);
		startDateLabel.setLabelFor(startTextField);
		
		addProjectPopup.add(endDateLabel);
		addProjectPopup.add(endTextField);
		endDateLabel.setLabelFor(endTextField);
		
		descriptionTextArea.setLineWrap(true);
		addProjectPopup.add(descriptionLabel);
		addProjectPopup.add(descScrollPane);
		descriptionLabel.setLabelFor(descScrollPane);
		
		commentsTextArea.setLineWrap(true);
		addProjectPopup.add(commentsLabel);
		addProjectPopup.add(commScrollPane);
		commentsLabel.setLabelFor(commScrollPane);
		
		addProjectPopup.add(statusLabel);
		addProjectPopup.add(statusList);
		commentsLabel.setLabelFor(statusList);	
		
		addProjectPopup.add(usernameLabel);
		addProjectPopup.add(usernameTextField);
		usernameLabel.setLabelFor(employeeTextField);
		
		employeeView.add(employeeLabel);
		employeeView.add(employeeTextField);
		employeeLabel.setLabelFor(employeeTextField);
		
		addProjectPopup.add(saveButton);
		saveButton.setBackground(Color.GREEN);
		saveButton.setOpaque(true);
		addProjectPopup.add(resetButton);	
		
		employeeView.setLayout(new GridLayout(3,2,0,3));
		
		employeeView.add(projectsLabel);
		employeeView.add(projectScrollPane);
		employeeLabel.setLabelFor(projectScrollPane);
		
		employeeView.add(addProjectButton);
		addProjectButton.setBackground(Color.GREEN);
		addProjectButton.setOpaque(true);
		employeeView.add(closeButton);
		closeButton.setBackground(Color.RED);
		closeButton.setOpaque(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		//if name is selected in window, show bottom frame.
		//if name is double clicked, clear pane, show list of projects/tasks
		//once project/task is double clicked, show detailed view
		//add button makes new employee, double click employee and have option to add new task/project
		
		if(ae.getSource() == addEmployeeButton){
			for(int i = 0; i<employees.size(); i++){
				if(addEmployeeTextField.getText().trim().toLowerCase().equals(employees.get(i).getName().trim().toLowerCase())){
					JOptionPane.showMessageDialog(this,"The user that you entered already exits.");
					return;
				}
				
				if(addEmployeeTextField.getText().trim().equals("")){
					JOptionPane.showMessageDialog(this,"Please enter an employee name.");
					return;
				}
			}
			employee e = new employee();
			e.setName(addEmployeeTextField.getText().trim());
			employees.add(e);
			showTextField.setText(addEmployeeTextField.getText().trim());
			FileWriter fw;
			try {
				fw = new FileWriter("names.txt", true);
				fw.append(addEmployeeTextField.getText().trim()+"\n");
				empNames.add(addEmployeeTextField.getText().trim());
				names.setListData(empNames.toArray());
				fw.close();
			} 
			
			catch (IOException e1) {
				e1.printStackTrace();
			}
			addEmployeeTextField.setText("");
			showButton.doClick();
			names.setVisible(false);
		}
		
		if(ae.getSource() == showAllButton){
			if(employees.size() == 0){
				JOptionPane.showMessageDialog(this,"There are no employees to show.");
				return;
			}
			names.setVisible(true);
		}
		
		if(ae.getSource() == resetButton){
			resetButton.setEnabled(true);
			saveButton.setEnabled(true);
			titleTextField.setEditable(true);
			startTextField.setEditable(true);
			endTextField.setEditable(true);
			descriptionTextArea.setEditable(true);
			commentsTextArea.setEditable(true);
			statusList.setEnabled(true);
			titleTextField.setText("");
			startTextField.setText("");
			endTextField.setText("");
			descriptionTextArea.setText("");
			commentsTextArea.setText("");
			statusList.setSelectedIndex(0);
		}
		
		if(ae.getSource() == clearButton){
			showTextField.setText("");
			addEmployeeTextField.setText("");
			names.setVisible(false);
			//deleteEmployeeButton.setVisible(false);
		}
		
		if(ae.getSource() == addProjectButton){
			resetButton.setEnabled(true);
			resetButton.doClick();
			addProjectPopup.setSize(500,500);
			addProjectPopup.setLocationRelativeTo(null);
			addProjectPopup.setVisible(true);
		}
		
		if(ae.getSource() == saveButton){
			for(int t = 0; t<projects.size(); t++){
				if(titleTextField.getText().trim().toLowerCase().equals(projects.get(t).getTitle().trim().toLowerCase())){
					JOptionPane.showMessageDialog(this,"The project that you entered already exits. This issue will be addressed in future releases!");
					return;
				}
			}
			project p = new project();
			p.setTitle(titleTextField.getText());
			p.setStart(startTextField.getText());
			p.setEnd(endTextField.getText());
			p.setDescription(descriptionTextArea.getText());
			p.setComments(commentsTextArea.getText());
			p.setStatus((String) statusList.getSelectedItem());
			p.setEmployee(employeeTextField.getText());
			projects.add(p);
			p.setID(projects.indexOf(p));
			for(int i = 0; i<employees.size(); i++){
				if(employees.get(i).getName().trim().toLowerCase().equals(employeeTextField.getText().trim().toLowerCase())){
					employees.get(i).setProjectIDs(projects.indexOf(p));
				}
			}
			try {
				FileWriter fw = new FileWriter("projects.txt", true);
				fw.append(titleTextField.getText().trim()+" | "+startTextField.getText().trim()+" || "+endTextField.getText().trim()+" ||| "+descriptionTextArea.getText().trim()+" |||| "+commentsTextArea.getText().trim()+" ||||| "+statusList.getSelectedItem()+ " |||||| "+usernameTextField.getText().trim() + " |@| "+employeeTextField.getText().trim()+"\n");
				projNames.add(titleTextField.getText().trim());
				//projs.setListData(projNames.toArray());
				fw.close();
				
				addProjectPopup.dispose();
				showTextField.setText(employeeTextField.getText().trim());
				employeeView.dispose();
				showButton.doClick();
			} 
			
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		if(ae.getSource() == showButton){
			int count = 0;
			if(showTextField.getText().trim().equals("")){
				JOptionPane.showMessageDialog(this,"Please enter an employee name.");
				return;
			}
			for(int i = 0; i<employees.size(); i++){
				if(employees.get(i).getName().trim().toLowerCase().equals(showTextField.getText().trim().toLowerCase())){
					showTextField.setText("");
					employeeView.setSize(300,300);
					employeeView.setLocationRelativeTo(null);
					employeeTextField.setText(employees.get(i).getName().trim());
					employeeTextField.setEditable(false);
					ArrayList<String> empProjs = new ArrayList<String>();
					ArrayList<Integer> projIDs = employees.get(i).getProjectIDs();
					for(int x = 0; x<employees.size(); x++){
						if(employees.get(x).getName().trim().toLowerCase().equals(employeeTextField.getText().trim().toLowerCase())){
							for(int z = 0; z<projIDs.size(); z++){
								for(int j = 0; j<projects.size(); j++){
									if(projIDs.get(z) == j){
										empProjs.add(projects.get(j).getTitle());
									}
								}
							}
						}
				 	}	
					projs.setListData(empProjs.toArray());
					employeeView.setVisible(true);
				
				}
				else{
					count += 1;
				}
			}
			if(count == employees.size()){
				JOptionPane.showMessageDialog(this,"The user that you entered was not found. Please try again.");
			}
		}
		
		if(ae.getSource() == closeButton){
			employeeView.dispose();
		}
	}
	
	 public void mouseClicked(MouseEvent me) {
		 if(me.getSource() == names){
			 if(me.getClickCount() == 1){
				 //deleteEmployeeButton.setVisible(true);
			 }
		 
			 if(me.getClickCount() == 2){
				 int index = names.locationToIndex(me.getPoint());
				 String empName = (String) names.getModel().getElementAt(index);
				 showTextField.setText(empName);
				 showButton.doClick();
			 }
	 	}
		 
		 if(me.getSource() == projs){
			 if(me.getClickCount() == 2){
				int index = projs.locationToIndex(me.getPoint());
				String projName = (String) projs.getModel().getElementAt(index);
				addProjectPopup.setSize(500,500);
				addProjectPopup.setLocationRelativeTo(null);
				for(int i = 0; i<projects.size(); i++){
					if(projects.get(i).getTitle().equals(projName)){
						titleTextField.setText(projects.get(i).getTitle());
						startTextField.setText(projects.get(i).getSDate());
						endTextField.setText(projects.get(i).getEDate());
						descriptionTextArea.setText(projects.get(i).getDescription());
						commentsTextArea.setText(projects.get(i).getComments());
						for(int j = 0; j<statuses.length; j++){
							if(projects.get(i).getStatus().equals(statuses[j]+" "))
								statusList.setSelectedIndex(j);
						}
					}
				}
				titleTextField.setEditable(false);
				startTextField.setEditable(false);
				endTextField.setEditable(false);
				descriptionTextArea.setEditable(false);
				commentsTextArea.setEditable(false);
				statusList.setEnabled(false);
				saveButton.setEnabled(false);
				resetButton.setEnabled(false);
				addProjectPopup.setVisible(true);
			 }
	 	}	 
	 }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
