package business;

import java.time.LocalDateTime;

public class PurchaseRequest {
	
	private int id;
	private int userId;
	private String desc;
	private String justification;
	private LocalDateTime dateNeeded;
	private String deliveryMode;
	private String status;
	private double total;
	private LocalDateTime dateSubmitted;
	private String reasonForRejection;
	
	public PurchaseRequest(int id, int userId, String desc, String justification, LocalDateTime dateNeeded,
			String deliveryMode, String status, double total, LocalDateTime dateSubmitted,
			String reasonForRejection) {
	super();
	this.id = id;
	this.userId = userId;
	this.desc = desc;
	this.justification = justification;
	this.dateNeeded = dateNeeded;
	this.deliveryMode = deliveryMode;
	this.status = status;
	this.total = total;
	this.dateSubmitted = dateSubmitted;
	this.reasonForRejection = reasonForRejection;
	
}

public PurchaseRequest() {
	super();	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public String getJustification() {
	return justification;
}

public void setJustification(String justification) {
	this.justification = justification;
}

public LocalDateTime getDateNeeded() {
	return dateNeeded;
}

public void setDateNeeded(LocalDateTime dateNeeded) {
	this.dateNeeded = dateNeeded;
}

public String getDeliveryMode() {
	return deliveryMode;
}

public void setDeliveryMode(String deliveryMode) {
	this.deliveryMode = deliveryMode;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public LocalDateTime getDateSubmitted() {
	return dateSubmitted;
}

public void setDateSubmitted(LocalDateTime dateSubmitted) {
	this.dateSubmitted = dateSubmitted;
}

public String getReasonForRejection() {
	return reasonForRejection;
}

public void setReasonForRejection(String reasonForRejection) {
	this.reasonForRejection = reasonForRejection;
}

@Override
public String toString() {
	return "Purchase Request [id=" + id + ", UserID=" + userId + ", Description=" + desc + 
			", Justification=" + justification + ", DateNeeded=" + dateNeeded + 
			", DeliveryMode=" + deliveryMode +", Status=" + status +", Total=" + total +
			", DateSubmitted=" + dateSubmitted + ", ReasonForRejection=" + reasonForRejection +"]";

	
}
}
