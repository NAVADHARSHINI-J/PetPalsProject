package org.hexaware.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.InsufficientFunds;
import util.DBConnUtil;

public class CashDonation extends Donation{
	private double amount;
	 public CashDonation(String donationName, String donationDate, String donationType,double amount) {
		super(donationName, donationDate, donationType);
		this.amount=amount;		
	}
	 
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public void recordDonation(Donation don) {
		String sql="insert into Donations (DonorName, DonationType, DonationAmount, DonationDate) values(?,?,?,?)";
		boolean b=true;
		try(Connection con=DBConnUtil.getConnection()){
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,don.getDonationName());
			st.setString(2,don.getDonationType());
			CashDonation cs=(CashDonation)don;
			st.setDouble(3,cs.getAmount());
			if(cs.getAmount()<10) throw new InsufficientFunds("Amount should be greater than 10");
			st.setString(4,don.getDonationDate());
			st.executeUpdate();
		}
		catch(InsufficientFunds | SQLException e) {
			System.err.println(e.getMessage());
			b=false;
			
		}
		if(b) System.out.println("Record Inserted Successfully");	
	}

	
}
