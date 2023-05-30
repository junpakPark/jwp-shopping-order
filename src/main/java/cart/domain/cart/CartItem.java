package cart.domain.cart;

import cart.domain.product.Product;

public class CartItem {

	private final Long id;
	private final Product product;
	private int quantity;

	public CartItem(final Long id, final Product product, final int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	public void changeQuantity(final int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public Long getProductId() {
		return product.getId();
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
}