package com.hobbyapp.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("user")
public class User extends Model{

    @Indexed(unique=true)
    private String username;
    private String password;
    private boolean active;
    private List<String> roles;
}
