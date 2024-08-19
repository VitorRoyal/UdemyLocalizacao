package br.com.localizacao;

import br.com.localizacao.domain.entity.Cidade;
import br.com.localizacao.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		var cidade = new Cidade(null, "porto", null);
		cidadeService.filtroDinamico(cidade).forEach(System.out::println);
		cidadeService.listarCidadesByNomeSpecs();
	}


	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
