package br.com.testes;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.core.BaseTest;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestWebMotors extends BaseTest {
	

	

	@Test
	public void ValidarMarcasWebMotors() {

		given()
			
		 
		.when()
			.get("/api/OnlineChallenge/Make")
		.then()
			.log().all()
			.statusCode(200)
			.body("ID", Matchers.hasSize(3))
			.body("Name", Matchers.hasItems("Chevrolet","Ford","Honda"))
			.body("ID", Matchers.hasItems(1,2,3))
			;
			

	}
	
	@Test
	public void ValidarModelossWebMotors() {

		given()
			
		 
		.when()
			.get("/api/OnlineChallenge/Model?MakeID=1")
		.then()
			.log().all()
			.statusCode(200)
			.body("Name", Matchers.hasItems("Agile","Astra","Onix"))
			.body("ID", Matchers.hasItems(1))
			.body("ID", Matchers.hasSize(3))
			;
			

	}
	
	@Test
	public void ValidarVersoessWebMotors() {

		given()
			
		 
		.when()
			.get("/api/OnlineChallenge/Version?ModelID=1")
		.then()
			.log().all()
			.statusCode(200)
			.body("Name",is(not(nullValue())))
				;
			

	}
	
	@Test
	public void ValidarVehiclesWebMotors() {

		given()
			
		 
		.when()
			.get("/api/OnlineChallenge/Vehicles?Page=1")
		.then()
			.log().all()
			.statusCode(200)
			.body("Make",is(not(nullValue())))
			.body("Make", Matchers.hasItems("Honda","Mitsubishi"))
			.body("Model", Matchers.hasItems("City","Lancer"))
			.body("Version", Matchers.hasItems("2.0 EVO 4P AUTOMÁTICO","2.0 EXL 4X4 16V GASOLINA 4P AUTOMÁTICO"))
			.body("Image", Matchers.hasItems("http://desafioonline.webmotors.com.br/content/img/01.jpg","http://desafioonline.webmotors.com.br/content/img/02.jpg"))
			.body("KM", Matchers.hasItems(0,47500))
			.body("Price", Matchers.hasItems("49000,00","59000,00"))
			.body("YearModel", Matchers.hasItems(2018,2012))
			.body("YearFab", Matchers.hasItems(2017,2012))
			.body("Color", Matchers.hasItems("Azul","Branco"))

			;
				
			

	}





}
