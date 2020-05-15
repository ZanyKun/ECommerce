package com.b13.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Computers extends Category{
	
	String computerType;		//Laptop, Desktop, All-In-One
	String operatingSystem;		//Windows, Mac OS, Chrome OS
	String videoCard;			//None, something NVIDIA, something AMD
	int storageCapacity;		//<250 GB, 250 - 480 GB, 1TB, etc...
	String storageType;			//SSD, SSD + HHD, HHD, etc...
	String color;
	List<String> features;		//HDMI IO, Bluetooth, Wireless-AC, Optical Drive, etc...
	int ramSpace;				//8GB, 16GB, 32GB, etc...
	String processorModel;		//something Intel, something AMD.
	
}
