package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Item {

    public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFavorites() {
		return isFavorites;
	}

	public void setFavorites(boolean isFavorites) {
		this.isFavorites = isFavorites;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	private String itemId = new ObjectId().toString();
    private String itemName;
    private double price;  // in dollars
    private String category;
    private boolean isFavorites = false; // default value is false
    private boolean isActive = true; // default value is true. used for soft deletion
    // private String description;
//    private String image; // image url


    public Item() {
    }

    public Item(String name, double price, String category) {
        this.itemName = name;
        this.price = price;
        this.category = category;
    }

}
