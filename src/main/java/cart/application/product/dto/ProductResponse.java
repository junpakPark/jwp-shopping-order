package cart.application.product.dto;

import java.math.BigDecimal;

import cart.domain.product.Product;

public class ProductResponse {
	private Long id;
	private String name;
	private BigDecimal price;
	private String imageUrl;

	private ProductResponse(Long id, String name, BigDecimal price, String imageUrl) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public static ProductResponse from(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getImageUrl());
	}

	public Long getId() {
		return id;
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
