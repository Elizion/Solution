package com.ear.core.enums;

public enum PeriodicityEnum {
 
	DAY("DAY"),
	HOUR("HOUR"),
	FIVE_MINUTAL("FIVE_MINUTAL");
	
	private String name;
	
	PeriodicityEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static PeriodicityEnum getPeriodicityEnum(String periodicity) {
		for(PeriodicityEnum periodicityEnum : PeriodicityEnum.values()) {
			if (periodicity.equals(periodicityEnum.getName())) {
				return periodicityEnum;
			}
		}
		return null;
	}
	
}
