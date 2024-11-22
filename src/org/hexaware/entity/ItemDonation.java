package org.hexaware.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnUtil;

public class ItemDonation extends Donation{
	 private String itemType;

	public ItemDonation(String donationName, String donationDate, String donationType,String itemType) {
		super(donationName, donationDate, donationType);
		this.itemType=itemType;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Override
	public void recordDonation(Donation don) {
		String sql="insert into Donations (DonorName, DonationType, DonationItem, DonationDate) values(?,?,?,?)";
		try(Connection con=DBConnUtil.getConnection()){
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,don.getDonationName());
			st.setString(2,don.getDonationType());
			ItemDonation cs=(ItemDonation)don;
			st.setString(3,cs.getItemType());
			st.setString(4,don.getDonationDate());
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Record Inserted Successfully");	
	}
	 

}
