package com.g9.handbagstore.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bag_categories")
public class BagCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bag_category_id")
	private int bagCategoryId;
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
	@Column(name = "name", columnDefinition = "ntext", nullable = false)
	private String name;
	@Column(name = "size", columnDefinition = "varchar(80)", nullable = false)
	private String size;
	@Column(name = "weight", columnDefinition = "real", nullable = false)
	private double weight;
	@Column(name = "cover_photo", columnDefinition = "varchar(3000)", nullable = false)
	private String coverPhoto;
	@Column(name = "short_description", columnDefinition = "nvarchar(255)", nullable = false)
	private String shortDescription;
	@Column(name = "long_description", columnDefinition = "ntext", nullable = false)
	private String longDescription;

	@OneToMany(mappedBy = "bagCategory")
	private List<Bag> listBags;

	public BagCategory(int bagCategoryId, Brand brand, String name, String size, double weight, String coverPhoto,
			String shortDescription, String longDescription) {
		super();
		this.bagCategoryId = bagCategoryId;
		this.brand = brand;
		this.name = name;
		this.size = size;
		this.weight = weight;
		this.coverPhoto = coverPhoto;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public BagCategory(Brand brand, String name, String size, double weight, String coverPhoto, String shortDescription,
			String longDescription) {
		super();
		this.brand = brand;
		this.name = name;
		this.size = size;
		this.weight = weight;
		this.coverPhoto = coverPhoto;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public BagCategory() {
		super();
	}

	public int getBagCategoryId() {
		return bagCategoryId;
	}

	public void setBagCategoryId(int bagCategoryId) {
		this.bagCategoryId = bagCategoryId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public String toString() {
		return "BagCategory [bagCategoryId=" + bagCategoryId + ", brand=" + brand + ", name=" + name + ", size=" + size
				+ ", weight=" + weight + ", coverPhoto=" + coverPhoto + ", shortDescription="
				+ shortDescription + ", longDescription=" + longDescription + "]";
	}
}
