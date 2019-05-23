package com.prs.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Product {
	
	@Id //declares id the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "VendorID")
	private Vendor vendor;
	private String partNumber;
	private String name;
	private double price;
	private String unit;
	private String photoPath;

	public Product(int id, Vendor vendor, String partNumber, String name, double price, String unit, String photoPath) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.partNumber = partNumber;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.photoPath = photoPath;

	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendorId(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		if (!unit.equals(null)) {
			return unit;
		}
		else return null;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotoPath() {
		if (!photoPath.equals(null)) {
			return photoPath;
		}
		else return null;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ",Vendor=" + vendor + ", PartNumber=" + partNumber + 
				", Name=" + name + ", Price=" + price + ", Unit =" + unit + ", PhotoPath =" + photoPath + "]";
		
	}

}
