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
public class Phones extends Category{
	
	String phoneCondition;			//NEW, REBURBISHED, PREOWNED
	String phoneType;				//Phone with plans, unlocked, prepaid...
	String carrier;					//Verizon, AT&T, Sprint, T-Mobile etc...
	String model;					//S10+, S9+, iPhone 11, etc...
	List<String> features;			//Bluetooth, Touch screen, headphone jack...
	String operatingSystem;			//Android, iOS
	String resolution;
	String color;
	String wirelessModel;			//4G LTE, 5G, 3G, 4G etc...
	String storage;					//128 GB, 256 GB, 512 GB, etc...
	
}
