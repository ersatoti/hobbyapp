package com.hobbyapp.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoricGame {

    private String estabilishment;
    private String estabilishmentAddress;
    private String estabilishmentPhone;
    private String longitude;
    private String latitude;
    private String field;
    private LocalDateTime date;
    private Double value;
    private String status;
}
