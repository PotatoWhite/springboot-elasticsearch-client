package me.potato.sample.springbootelasticsearch.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "farm", type = "crops")
public class Crop {

	@Id
	private String id;

	private String name;

	public Crop() { }

	public Crop(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Crop{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
