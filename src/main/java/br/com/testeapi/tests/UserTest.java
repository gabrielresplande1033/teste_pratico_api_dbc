package br.com.testeapi.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

import com.github.javafaker.Faker;

import br.com.testeapi.core.BaseTest;
import br.com.testeapi.pojo.User;
import br.com.testeapi.pojo.UserApenasNome;
import br.com.testeapi.pojo.UserNomeInteiro;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserTest extends BaseTest {
	
	public static Faker faker = Faker.instance();

	@Test
	public void criarUsuario() {
		User userRequest = new User();
		userRequest.setName(faker.name().fullName());
		userRequest.setJob(faker.job().field());
		
		User userResponse = 
		given()
			.body(userRequest)
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"))
			.extract().body().as(User.class)
		;
		
		Assert.assertThat(userResponse.getId(), notNullValue());
		Assert.assertThat(userResponse.getCreatedAt(), notNullValue());
		Assert.assertEquals(userRequest.getName(), userResponse.getName());
		Assert.assertThat(userResponse.getJob(), is(userRequest.getJob()));
	}
	
	@Test
	public void criarUsuarioComApenasNome() {
		UserApenasNome userRequest = new UserApenasNome();
		userRequest.setName(faker.name().fullName());
		
		UserApenasNome userResponse = 
		given()
			.body(userRequest)
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"))
			.extract().body().as(UserApenasNome.class)
		;
		
		Assert.assertThat(userResponse.getId(), notNullValue());
		Assert.assertThat(userResponse.getCreatedAt(), notNullValue());
		Assert.assertEquals(userRequest.getName(), userResponse.getName());
	}
	
	@Test
	//Como o schema espera uma String, irá gerar um erro ao retornar um inteiro na resposta
	public void criarUsuarioComNomeTipoInteiro() {
		UserNomeInteiro userRequest = new UserNomeInteiro();
		userRequest.setName(328732183);
		
		given()
			.body(userRequest)
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"))
		;
	}
	
}
