package com.hobbyapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("player")
public class Player extends Model{

	private String nome;
	private String cpf;
	private String telefone;
	private List<Contact> contacts;
	private List<HistoricGame> historicGames;
}
