package com.hobbyapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("manager")
public class Manager extends Model{

	private String name;
	private String cpf;
	private String phone;
	private List<Estabilishment> estabilishments;
	@Indexed(unique = true)
	private String username;
}
