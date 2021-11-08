package co.edu.usa.reto3;

import co.edu.usa.reto3.model.Categoria;
import co.edu.usa.reto3.model.Cliente;
import co.edu.usa.reto3.repositories.RepositoryCategoria;
import co.edu.usa.reto3.repositories.RepositoryCliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.usa.reto3"})
public class Reto3Application {

    @Autowired
    private RepositoryCategoria categorias;

    @Autowired
    private RepositoryCliente clientes;

    public static void main(String[] args) {
        SpringApplication.run(Reto3Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<Categoria> ps = categorias.getAll();
            System.out.println("Categorias: " + ps.size());

            List<Cliente> cs = clientes.getAll();
            System.out.println("Clientes: " + cs.size());
        };
    }

}
