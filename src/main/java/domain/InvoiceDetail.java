package domain;

public class InvoiceDetail {
    private long id;
    private int productId;
    private short quantity;
    private int price;
    private String title;
    private String imageUrl;
    
	public InvoiceDetail(long id, int productId, short quantity, int price) {
		this(id, productId, quantity, price, null,null);
	}

	public InvoiceDetail(long id, int productId, short quantity, int price, String title, String imageUrl) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.title = title;
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
    

}
