package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AnagrammaDAO {

	
	public boolean isCorrect(String anagramma) {
		
		final String sql = "SELECT * FROM parola WHERE nome=?";

		

		try {
			boolean trovato=false;
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				trovato=true;

			}
			
			st.close();
			rs.close();

			conn.close();
			
			return trovato;
	
	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
	}
	}
	

}
