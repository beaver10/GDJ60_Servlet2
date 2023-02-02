package com.iu.home;

public class Gun {
	private String company;
	private String name;
	
	private Bullet bullet;

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}


	public void trigger() {
		this.bullet.sound();
		
	}

}
