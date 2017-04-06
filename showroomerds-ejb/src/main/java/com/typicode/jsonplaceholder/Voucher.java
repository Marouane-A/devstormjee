package com.typicode.jsonplaceholder;

public class Voucher {

	private int voucherId;
    private String reference;
    private String name;
    private String description;
    private float amount;
    private Showroomer showroomer;
    
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voucher(int voucherId, String reference, String name, String description, float amount,
			Showroomer showroomer) {
		super();
		this.voucherId = voucherId;
		this.reference = reference;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.showroomer = showroomer;
	}
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Showroomer getShowroomer() {
		return showroomer;
	}
	public void setShowroomer(Showroomer showroomer) {
		this.showroomer = showroomer;
	}
	@Override
	public String toString() {
		return "Voucher [voucherId=" + voucherId + ", reference=" + reference + ", name=" + name + ", description="
				+ description + ", amount=" + amount + ", showroomer=" + showroomer + "]";
	}
	
    
}
