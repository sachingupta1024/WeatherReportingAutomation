package com.testvagrant.dao.builder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.testvagrant.api.weatherresponse.Clouds;
import com.testvagrant.api.weatherresponse.Coord;
import com.testvagrant.api.weatherresponse.Main;
import com.testvagrant.api.weatherresponse.Rain;
import com.testvagrant.api.weatherresponse.Sys;
import com.testvagrant.api.weatherresponse.Weather;
import com.testvagrant.api.weatherresponse.Wind;

@JsonIgnoreProperties({"rain","1h" })
public class GetWeatherInfo {

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Rain getRain() {
		return rain;
	}

	public void setRain(Rain rain) {
		this.rain = rain;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public int getDt() {
		return dt;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	private Coord coord;

    private List<Weather> weather;

    private String base;

	private Main main;

    private Wind wind;
    
    private Rain rain;

    private Clouds clouds;

    private int dt;

    private Sys sys;

    private int timezone;

    private int id;

    private String name;

    private int cod;

    
}
