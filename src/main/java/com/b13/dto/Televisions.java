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
public class Televisions extends Category{
	
	String screenSize;					//85", 75" - 84", 64" - 74", etc...
	String tvType;						//SmartTV, LED, OLED, Curved, Plasma, etc...
	List<String> features;				//Built-in spearkers, Bluetooth, HDR, etc...
	String resolution;					//4K, 8K, Full HD, HD
	String InputOutput;					//HDMI, Digital, Analog
	String color;						//Black, Gray, Silver, etc...
	
}
