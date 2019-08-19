package com.project.restauranttablereservation.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name="name")
    private String name;

    private String password;
    
    @Column(name="active")
	private boolean isActive;

    @Column(name="email_id")
    private String emailId;
    
    @Column(name="phone_no")
    private String phoneNumber;
    
    private String description;
    
    private String address;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    public User() {
    	
    }
	/**
	 * @param user
	 */
	public User(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.isActive = user.isActive();
		this.emailId = user.getEmailId();
		this.phoneNumber = user.getPhoneNumber();
		this.description = user.getDescription();
		this.address = user.getAddress();
		this.roles = user.getRoles();
	}


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




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public boolean isActive() {
		return isActive;
	}




	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public Set<Role> getRoles() {
		return roles;
	}




	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




	public void addRole(Role role) {
		if (role != null) {
			if (roles == null) {
				roles = new HashSet<>();
			}
			roles.add(role);
		}

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
