package domain;

public class Cart {
    private int productId;
    private int price;
    private short quantity;
    private String imageUrl;
    private String title;
	public Cart(int productId, int price, short quantity, String imageUrl, String title) {
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.title = title;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public short getQuantity() {
		return quantity;
	}
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void increaseQuantity(short quantity) {
		this.quantity += quantity;
	}
    
}
