package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> getInfoVillesCodePostal(String codePostal) throws SQLException {
		String requeteSelect = "SELECT * FROM ville_france WHERE code_postal = " + codePostal;
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(requeteSelect);
		return parseReponse(rs, connection);
	}
	
	public ArrayList<Ville> getInfoVilles() throws SQLException {
		String requeteSelect = "SELECT * FROM ville_france";
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(requeteSelect);
		return parseReponse(rs, connection);
	}
	
	public ArrayList<Ville> parseReponse(ResultSet rs, Connection connection) throws SQLException {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Ville ville = null;
		while (rs.next()) {
			ville = new Ville();
			ville.setCodeCommune(rs.getString(1));
			ville.setNomCommune(rs.getString(2));
			ville.setCodePostal(rs.getString(3));
			ville.setLibelleAcheminement(rs.getString(4));
			ville.setLigne(rs.getString(5));
			ville.setLatitude(rs.getString(6));
			ville.setLongitude(rs.getString(7));
			villes.add(ville);
		}
		connection.close();
		return villes;		
	}
}
