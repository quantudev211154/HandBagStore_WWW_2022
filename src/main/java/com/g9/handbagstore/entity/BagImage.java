package com.g9.handbagstore.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bag_images")
public class BagImage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bag_image_id")
	private int bagImageId;
	@ManyToOne
	@JoinColumn(name = "bag_id", nullable = false)
	private Bag bag;
	@Column(name = "image", columnDefinition = "varbinary(MAX)", nullable = false)
	private byte[] image;

	public BagImage(int bagImageId, Bag bag, byte[] image) {
		super();
		this.bagImageId = bagImageId;
		this.bag = bag;
		this.image = image;
	}

	public BagImage(Bag bag, byte[] image) {
		super();
		this.bag = bag;
		this.image = image;
	}

	public BagImage() {
		super();
	}

	public int getBagImageId() {
		return bagImageId;
	}

	public void setBagImageId(int bagImageId) {
		this.bagImageId = bagImageId;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "BagImage [bag=" + bag + ", image=" + Arrays.toString(image) + "]";
	}
}
