package com.testvagrant.dao.builder;

import com.testvagrant.dao.GetData;
import com.testvagrant.utilities.UtilClass;

public class GetWeatherData extends GetData {

	@Override
	public GetWeatherInfo getDataFromAPI() {
		return UtilClass.getResponseFromAPI();
	}

	@Override
	public GetWeatherInfo getDataFromUI() {
		return UtilClass.getUIInfo();
	}
}
