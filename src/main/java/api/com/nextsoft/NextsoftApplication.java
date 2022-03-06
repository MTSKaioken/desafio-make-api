package api.com.nextsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import api.com.nextsoft.models.Cliente;
import api.com.nextsoft.models.Endereco;
import api.com.nextsoft.repositories.ClienteRepository;
import api.com.nextsoft.repositories.EnderecosRepository;

@SpringBootApplication
public class NextsoftApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecosRepository enderecosClienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(NextsoftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Cliente clienteModel1 = new Cliente(null, "xxx.xxx-xx", "Kaio", "kaio@gmail.com", "11 98166");
		Cliente clienteModel2 = new Cliente(null, "yyy.yyy-yy", "ge", "ge@gmail.com", "11 23024");
		Cliente clienteModel3 = new Cliente(null, "zzz.zzz-zz", "cawe", "cawe.wewe@gmail.com", "13 24242424");
		
		Endereco endereco1 = new Endereco("Casa", "Rua ribeirão dos Arcos", 276, "Subindo o batalhão", "Jardim Roseli", "São Paulo", "SP");
		Endereco endereco2 = new Endereco("Trabalho", "Rua Confederação dos Tamoios", 26, "Perto da escola Iguatemi", "Jardim Iguatemi", "São Paulo", "SP");
		Endereco endereco3 = new Endereco("Trabalho", "Rua Oscar Muller", 6, "Perto de uma Praça", "Jardim Iguatemi", "São Paulo", "SP");
		
		clienteModel1.getEnderecosClientes().addAll(Arrays.asList(endereco1, endereco2));
		clienteModel2.getEnderecosClientes().addAll(Arrays.asList(endereco3));
		
		clienteRepository.saveAll(Arrays.asList(clienteModel1, clienteModel2, clienteModel3));
		enderecosClienteRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
		
	}

}
