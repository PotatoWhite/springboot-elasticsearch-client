package me.potato.sample.springbootelasticsearch.repository;

import me.potato.sample.springbootelasticsearch.domain.entity.Crop;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface CropRepository extends ElasticsearchRepository<Crop, String> {
	@Override
	long count();

	List<Crop> findByName(String name);
}