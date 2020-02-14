package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Projects") //declare the table name associated with this class
public class Project {

	private int projectId;
	
	@FormParam("name")
	private String name;
	
	@FormParam("customer name")
	private String customerName;
	
	Set<Employee> projectTeam = new HashSet<>();
	
	//Provide the property in Employee with @ManyToMany and @JoinTable Configuration
	@ManyToMany(mappedBy="projectAssigned")
	@XmlTransient
	public Set<Employee> getProjectTeam() {
		return projectTeam;
	}
	public void setProjectTeam(Set<Employee> projectTeam) {
		this.projectTeam = projectTeam;
	}
	public Project() {
		// TODO Auto-generated constructor stub
	}
	@Id //marking the property as primary key for the table
	@Column(name="project_id") //using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO) //auto numbering configuration as per DB
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	@Column(name ="project_name",length=50,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + projectId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projectId != other.projectId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", customerName=" + customerName + "]";
	}
	
	
	
}
