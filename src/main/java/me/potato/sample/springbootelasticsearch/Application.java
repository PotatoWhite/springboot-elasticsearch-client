package me.potato.sample.springbootelasticsearch;

import me.potato.sample.springbootelasticsearch.domain.entity.Crop;
import me.potato.sample.springbootelasticsearch.repository.CropRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.common.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final Log logger = LogFactory.getLog(getClass());

	private final CropRepository cropRepository;

	public Application(CropRepository cropRepository) {
		this.cropRepository = cropRepository;
	}


	@Override
	public void run(String... args) {
		logger.info("STORE========================");

		Crop potato = new Crop("ID001", "Potato");
		Crop tomato = new Crop("ID002", "tomato");
		Crop carrot = new Crop("ID003", "carrot");
		cropRepository.save(potato);
		cropRepository.save(tomato);
		cropRepository.save(carrot);


		logger.info("RETRIEVE======================");

		Iterable<Crop> all = cropRepository.findAll();
		all.forEach(logger::info);

		List<Crop> tomatos = cropRepository.findByName("tomato");
		tomatos.forEach(logger::info);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
