package com.api.demo.entities;
import javax.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "sat_result")
public class SATResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getSatScore() {
		return satScore;
	}

	public void setSatScore(int satScore) {
		this.satScore = satScore;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	@Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String pincode;

    @Column(name = "sat_score", nullable = false)
    private int satScore;

    @Column(nullable = false)
    private boolean passed;
    public void calculatePassed() {
        passed = satScore > 30;
    }
    // Constructors, getters, and setters

    // ...
}
