package org.hexaware.entity;


public abstract class Donation {
	  private String donationName;
	  private String donationDate;
	  private String donationType;
	public Donation(String donationName, String donationDate, String donationType) {
		super();
		this.donationName = donationName;
		this.donationDate = donationDate;
		this.donationType = donationType;
	}
	public String getDonationName() {
		return donationName;
	}
	public void setDonationName(String donationName) {
		this.donationName = donationName;
	}
	public String getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}
	public String getDonationType() {
		return donationType;
	}
	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}
	 
	public abstract void recordDonation(Donation don);
}
