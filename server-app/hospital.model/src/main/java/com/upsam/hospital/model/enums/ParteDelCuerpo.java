package com.upsam.hospital.model.enums;

public enum ParteDelCuerpo {
	
	CABEZA("CABEZA"),
	HOMBRO("HOMBRO"), 
	CADERA("CADERA"), 
	RODILLA("RODILLA"), 
	PIE("PIE");
	
    private String name;

    ParteDelCuerpo(String name) { this.name = name; }
	
}
