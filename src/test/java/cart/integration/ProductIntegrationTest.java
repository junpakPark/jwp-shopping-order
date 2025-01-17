package cart.integration;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import cart.application.product.dto.ProductRequest;
import cart.application.product.dto.ProductResponse;

public class ProductIntegrationTest extends IntegrationTest {

	@Test
	public void getProducts() {
		var result = given()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.when()
			.get("/products")
			.then()
			.extract();

		assertThat(result.statusCode()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	public void createProduct() {
		var product = new ProductRequest("치킨", BigDecimal.valueOf(10_000L), "http://example.com/chicken.jpg");

		var response = given()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(product)
			.when()
			.post("/products")
			.then()
			.extract();

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	public void getCreatedProduct() {
		var product = new ProductRequest("피자", BigDecimal.valueOf(15_000L), "http://example.com/pizza.jpg");

		// create product
		var location =
			given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(product)
				.when()
				.post("/products")
				.then()
				.statusCode(HttpStatus.CREATED.value())
				.extract().header("Location");

		// get product
		var responseProduct = given().log().all()
			.when()
			.get(location)
			.then()
			.statusCode(HttpStatus.OK.value())
			.extract()
			.jsonPath()
			.getObject(".", ProductResponse.class);

		assertThat(responseProduct.getId()).isNotNull();
		assertThat(responseProduct.getName()).isEqualTo("피자");
		assertThat(responseProduct.getPrice()).isEqualTo(BigDecimal.valueOf(15_000L));
	}
}
