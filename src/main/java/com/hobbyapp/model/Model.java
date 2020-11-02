
package com.hobbyapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

@Setter
@Getter
public abstract class Model implements Persistable<String> {

	@Id
	private String id;
	@Transient
	private boolean newModel;

	@Override
	@Transient
	public boolean isNew() {
		return this.newModel || Objects.isNull(id);
	}
}

