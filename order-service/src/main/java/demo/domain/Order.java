package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@Document(collection = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Map<OrderStatus, Date> getUpdateHistory() {
		return updateHistory;
	}

	public void setUpdateHistory(Map<OrderStatus, Date> updateHistory) {
		this.updateHistory = updateHistory;
	}

	@Id
    private String id;

    @Indexed
    private String userId;
    private OrderStatus orderStatus;
    private List<Item> items = new ArrayList<>();
    private DeliveryInfo deliveryInfo;
    private double totalCost;
    private String note;
    @CreatedDate
    private Date creationTime;
    @LastModifiedDate
    private Date lastModifyTime;

    private Map<OrderStatus, Date> updateHistory = new HashMap<>();

    public Order() {
    }

    @JsonCreator
    public Order(@JsonProperty("items") List<Item> items,
                 @JsonProperty("deliveryInfo") DeliveryInfo deliveryInfo,
                 @JsonProperty("note") String note) {
        this.items = items;
        this.deliveryInfo = deliveryInfo;
        this.note = note;
        this.creationTime = new Date();
        this.totalCost = calculateTotalCost(this.items);
        this.orderStatus = OrderStatus.PENDING;
        this.updateHistory.put(this.orderStatus, this.creationTime);
    }

    private double calculateTotalCost(List<Item> items) {
        double cost = 0L;
        for(Item item : items) {
            cost += item.getPrice()*100;
        }
        return cost/100.0;
    }

}
