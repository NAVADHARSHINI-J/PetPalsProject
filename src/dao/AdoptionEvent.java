package dao;

import java.sql.*;

import org.hexaware.entity.Partipants;

import util.DBConnUtil;

public class AdoptionEvent implements Atobtable{
		public void host() {
			String sql="select * from adoptionevents";
			try(Connection con=DBConnUtil.getConnection()){
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				System.out.println("Adoption Events:");
	            System.out.printf("%-10s %-30s %-18s %-20s%n", "Event ID", "Event Name", "Event Date", "Location");
	            System.out.println("---------------------------------------------------------------");
				while(rs.next()) {
					   System.out.printf("%-10d %-30s %-18s %-20s%n", 
                               rs.getInt("EventId"), rs.getString("EventName"), rs.getString("EventDate"), rs.getString("Location"));			            
				}
				
			}
			catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
		public void participant(Partipants p) {
			String query = "INSERT INTO participants (ParticipantID, ParticipantName, ParticipantType, EventID) " +
                    "VALUES (?, ?, ?, ?)";
     try (Connection conn = DBConnUtil.getConnection();
          PreparedStatement stmt = conn.prepareStatement(query)) {
         stmt.setInt(1, p.getParticipantId());
         stmt.setString(2, p.getParticipantName());
         stmt.setString(3, p.getParticipantType());
         stmt.setString(4, p.getEventId());
         int rowsInserted = stmt.executeUpdate();
     } catch (SQLException e) {
         System.err.println("Error inserting participant: " + e.getMessage());
     }
     System.out.println("PArticipants inserted Successfully");
 
		}
}
