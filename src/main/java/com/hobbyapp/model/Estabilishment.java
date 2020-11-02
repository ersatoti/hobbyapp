package com.hobbyapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Estabilishment {

	private String name;
	private String phone;
	private String address;
	private String longitude;
	private String latitude;
	private String description;
	private List<Field> fields;
}
