/**
 * 
 */
package com.project.restauranttablereservation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sivasaiv
 *
 */
@Entity
@Table(name ="menu_item")
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	private String  name;
	
	private String description;
	
	private int cost;
	
	@ManyToOne
	@JoinColumn(name="item_category_id")
	private MenuCategory category;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private RestaurantBranch branch;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public MenuCategory getCategory() {
		return category;
	}

	public void setCategory(MenuCategory category) {
		this.category = category;
	}

	public RestaurantBranch getBranch() {
		return branch;
	}

	public void setBranch(RestaurantBranch branch) {
		this.branch = branch;
	}
	
}
