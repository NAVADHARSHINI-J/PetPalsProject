package dao;

import java.sql.*;
import org.hexaware.entity.*;

import exception.InvalidAgeException;
import exception.NullReferenceException;
import util.DBConnUtil;

public class PetShelterImp implements PetShelter{

	@Override
	public boolean addPet(Pet pet) {
		String sql="insert into pets (Name,age,breed,type,AvailableForAdoption)values(?,?,?,?,?)";
		try(Connection con=DBConnUtil.getConnection()){
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,pet.getName());
			if((pet.getName()).equals("")) throw new NullReferenceException("Please Give value");
			st.setInt(2, pet.getAge());
			if(pet.getAge()<0) throw new InvalidAgeException("Age should be greater than zero");
			 if (pet instanceof Dog) {
	                Dog dog = (Dog) pet;
	                st.setString(3, dog.getDogBreed());
			 }
			 if(pet instanceof Cat) {
				 Cat cat=(Cat) pet;
				 st.setString(3, cat.getCatBreed());
			 }
			st.setString(4,pet.gettype());
			st.setInt(5, pet.getAvailableForAdoption());
			st.executeUpdate();
		}
		catch(InvalidAgeException | NullReferenceException | SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean removePet(int petId) {
		String sql="Delete from pets where PetID=?";
		try(Connection con=DBConnUtil.getConnection()){
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,petId);
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public int listAvailablePets() {
		String sql="Select count(PetID) from pets where AvailableForAdoption=1 ";
		try(Connection con=DBConnUtil.getConnection()){
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			rs.next();
			int list=rs.getInt(1);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}
		
}
