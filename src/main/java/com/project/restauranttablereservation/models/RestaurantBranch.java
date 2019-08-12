/**
 * 
 */
package com.project.restauranttablereservation.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sivasaiv
 *
 */

@Entity
@Table(name ="restaurant_branch")
public class RestaurantBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branch_id")
	private int id;
	
	private String city;
	
	private String address;
	
	private int capacity;
	
	@Column(name = "opens_at")
	private String opensAt;
	
	@Column(name = "closes_at")
	private String closesAt;
	
	@ManyToOne
	@JoinColumn(name = "rest_status_id")
	private RestaurantStatus status;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="branch_admin",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> admins;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_cuisine",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "cuisine_id",referencedColumnName = "id"))
	private Set<Cuisine> cuisines;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_type",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "type_id",referencedColumnName = "id"))
	private Set<RestaurantType> types;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_payment_type",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "payment_type_id",referencedColumnName = "id"))
	private Set<PaymentType> paymentTypes;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="branch_seating_type",joinColumns = @JoinColumn(name = "branch_id"), inverseJoinColumns = @JoinColumn(name = "seating_type_id",referencedColumnName = "id"))
    private Set<SeatingType> seatingTypes;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private Set<MenuItem> menuItems;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private Set<ReservationSlot> slots ;

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private Set<RestaurantPhoneNumber> phone;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getOpensAt() {
		return opensAt;
	}

	public void setOpensAt(String opensAt) {
		this.opensAt = opensAt;
	}

	public String getClosesAt() {
		return closesAt;
	}

	public void setClosesAt(String closesAt) {
		this.closesAt = closesAt;
	}

	public RestaurantStatus getStatus() {
		return status;
	}

	public void setStatus(RestaurantStatus status) {
		this.status = status;
	}

	public Set<User> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<User> admins) {
		this.admins = admins;
	}

	public Set<Cuisine> getCuisines() {
		return cuisines;
	}

	public void setCuisines(Set<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	public Set<RestaurantType> getTypes() {
		return types;
	}

	public void setTypes(Set<RestaurantType> types) {
		this.types = types;
	}

	public Set<PaymentType> getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(Set<PaymentType> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}

	public Set<SeatingType> getSeatingTypes() {
		return seatingTypes;
	}

	public void setSeatingTypes(Set<SeatingType> seatingTypes) {
		this.seatingTypes = seatingTypes;
	}

	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public Set<ReservationSlot> getSlots() {
		return slots;
	}

	public void setSlots(Set<ReservationSlot> slots) {
		this.slots = slots;
	}

	public Set<RestaurantPhoneNumber> getPhone() {
		return phone;
	}

	public void setPhone(Set<RestaurantPhoneNumber> phone) {
		this.phone = phone;
	}

	public void addMenuItem(MenuItem menuItem) {
		if (menuItem != null) {
			if (menuItems == null) {
				menuItems = new HashSet<>();
			}
			menuItems.add(menuItem);
		}

	}
	
	public void addSlot(ReservationSlot slot) {
		if (slot != null) {
			if (slots == null) {
				slots = new HashSet<>();
			}
			slots.add(slot);
		}

	}
	
	public void addNumber(RestaurantPhoneNumber phoneNumber) {
		if (phoneNumber != null) {
			if (phone == null) {
				phone = new HashSet<>();
			}
			phone.add(phoneNumber);
		}

	}
	
	public void addSeatingType(SeatingType seatingType) {
		if (seatingType != null) {
			if (seatingTypes == null) {
				seatingTypes = new HashSet<>();
			}
			seatingTypes.add(seatingType);
		}

	}
	
	public void addPaymentType(PaymentType paymentType) {
		if (paymentType != null) {
			if (paymentTypes == null) {
				paymentTypes = new HashSet<>();
			}
			paymentTypes.add(paymentType);
		}

	}
	
	public void addType(RestaurantType type) {
		if (type != null) {
			if (types == null) {
				types = new HashSet<>();
			}
			types.add(type);
		}

	}
	
	public void addCuisine(Cuisine cuisine) {
		if (cuisine != null) {
			if (cuisines == null) {
				cuisines = new HashSet<>();
			}
			cuisines.add(cuisine);
		}

	}
	
	public void addAdminUser(User user) {
		if (user != null) {
			if (admins == null) {
				admins = new HashSet<>();
			}
			admins.add(user);
		}

	}
}
