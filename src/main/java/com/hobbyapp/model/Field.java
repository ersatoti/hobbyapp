package com.hobbyapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Field {

	private String name;
	private String amountPlayers;
	private Double valueHour;
	private List<Scheduler> scheduler;

}
