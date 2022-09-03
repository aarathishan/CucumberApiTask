package org.google.resources;

public enum APIResources {
	
	addPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/add/json"),
	deletePlaceApi("/maps/api/place/add/json");
	
	private String resources;
	APIResources(String resources){
		this.resources=resources;
	}
	public String getResource() {
		return resources;
	}

}
