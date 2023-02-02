package com.iu.home;

public class Soldier {
	private String name;
	private Long num;
	
	private Gun gun;
	
	public Soldier() {
	//	this.gun = new Gun();
	}
	
	
	public Soldier(Gun gun) {
		this.gun=gun;
	}
	
	public void setGun(Gun gun) {
		this.gun=gun;
	}
	
	public void useGun() {
		this.gun.trigger();
		
	}
}
