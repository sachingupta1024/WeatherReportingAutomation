package com.testvagrant.dao;

import com.testvagrant.dao.builder.GetWeatherInfo;

public abstract class GetData {
	
	public abstract GetWeatherInfo getDataFromAPI();
	
	public abstract GetWeatherInfo getDataFromUI();
	

}
