package cart.error.exception;

public class BadRequestException extends RuntimeException {
	public BadRequestException(final String message) {
		super(message);
	}

	public static class Product extends BadRequestException {
		public Product() {
			super("해당 상품을 찾을 수 없습니다.");
		}
	}

	public static class Order extends BadRequestException {
		public Order() {
			super("해당 주문을 찾을 수 없습니다.");
		}
	}

	public static class OrderStatusUpdate extends BadRequestException {
		public OrderStatusUpdate() {
			super("주문 상태를 변경할 수 없습니다.");
		}
	}

	public static class Monetary extends BadRequestException {
		public Monetary(final String message) {
			super(String.format("%s는 0원 미만이 될 수 없습니다.", message));
		}
	}

	public static class Percentage extends BadRequestException {
		public Percentage() {
			super("할인율을 100% 이상이 될 수 없습니다.");
		}
	}

	public static class Coupon extends BadRequestException {
		public Coupon() {
			super("해당 쿠폰을 찾을 수 없습니다.");
		}
	}

	public static class SerialNumber extends BadRequestException {

		public SerialNumber() {
			super("발행 매수는 음수가 될 수 없습니다.");
		}
	}

	public static class Cart extends BadRequestException {
		public Cart() {
			super("카트에 해당 물품이 존재하지 않습니다.");
		}
	}
}
