package cart.application.product.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ProductRequest {

	@NotBlank(message = "상품의 이름은 반드시 입력해주세요.")
	private String name;
	@NotNull
	@PositiveOrZero(message = "가격은 0원 보다 낮을 수 없습니다. ")
	private BigDecimal price;
	@NotBlank(message = "상품의 사진은 반드시 입력해주세요.")
	private String imageUrl;

	public ProductRequest() {
	}

	public ProductRequest(String name, BigDecimal price, String imageUrl) {
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getImageUrl() {
		return imageUrl;
	}
}
