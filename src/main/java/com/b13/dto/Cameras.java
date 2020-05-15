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
public class Cameras extends Category{
	
	List<String> features;		//Rechargable battery, built-in wifi, AF, etc...
	String videoResolution;		//4K, 1920 x 1080, 4096 x 2160, etc...
	String color;
	String lensType;			//Standard Zoom, Telephoto zoom, Wide Angle Prime etc...
	String flashModes;			//Automatic, Fill-in, Off, etc...
	int aperture;				//40 f/, 38 f/, 36 f/, 32 f/
	int focalLength;			//18mm - 25mm, 26mm - 49mm, 50 - 69mm, etc...
	float screenSize;			//>2", 2" - 2.9", 3" - 3.4", etc...
	String storageType;			//SDHC, SDXC, microSD, microSDHC, etc...
	
}
