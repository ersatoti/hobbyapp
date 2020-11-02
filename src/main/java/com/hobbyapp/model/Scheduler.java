package com.hobbyapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scheduler{

	private String scheduledTime;
	private String status;
	private Player player;
	private Manager approver;

}
