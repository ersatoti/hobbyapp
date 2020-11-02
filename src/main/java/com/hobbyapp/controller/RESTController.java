package com.hobbyapp.controller;

import com.hobbyapp.service.IService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

@AllArgsConstructor
@org.springframework.web.bind.annotation.RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
public abstract class RESTController<T, ID extends Serializable> {

	private final IService service;

	@ApiOperation(value = "create element")
	@PostMapping
	public Mono save(@RequestBody T json) {
		return this.service.create(json);
	}

	@ApiOperation(value = "update element")
	@PatchMapping
	public Mono update(@RequestBody T json) {
		return this.service.update(json);
	}

	@ApiOperation(value = "list all elements")
	@GetMapping("/list")
	public Flux<Model> getAll() {
		return this.service.list();
	}

	@ApiOperation(value = "delete element")
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable String id) {
		return this.service.delete(id);
	}

}
