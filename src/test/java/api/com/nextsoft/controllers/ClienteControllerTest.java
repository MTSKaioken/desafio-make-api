package api.com.nextsoft.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import io.restassured.http.ContentType;

import api.com.nextsoft.models.Cliente;
import api.com.nextsoft.controllers.ClienteController;
import api.com.nextsoft.repositories.ClienteRepository;
import api.com.nextsoft.repositories.EnderecosRepository;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class ClienteControllerTest {
    
    @Autowired
    private ClienteController clienteController;
    
    @MockBean
    private ClienteRepository clienteRepository;

    @MockBean
    private EnderecosRepository enderecosRepository;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.clienteController); 
    }

    @Test
    public void returnSucess_WhenFindClients(){

        given()
            .accept(ContentType.JSON)
        .when()
            .get("/clientes")
        .then()
            .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void returnSucess_WhenFindOneClient(){

        when(this.clienteRepository.getById(1L))
            .thenReturn(new Cliente(1L, "zzz.zzz-zz", "cawe", "cawe.wewe@gmail.com", "13 24242424"));

        given()
            .accept(ContentType.ANY)
        .when()
            .get("/clientes/{id}", 1L)
        .then()
            .statusCode(HttpStatus.OK.value());
    }

}
