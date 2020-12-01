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

	//methode qui liste les villes sur le code postal
	public ArrayList<Ville> getInfoVillesCodePostal(String codePostal) throws SQLException {
		String requeteSelect = "SELECT * FROM ville_france WHERE code_postal = " + codePostal;
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(requeteSelect);
		return parseReponse(rs, connection);
	}
	
	//methode qui liste les villes sur le nom de la commune
	public ArrayList<Ville> getInfoVillesNomCommune(String nomCommune) throws SQLException {
		String requeteSelect = "SELECT * FROM ville_france WHERE code_postal = " + nomCommune;
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(requeteSelect);
		ArrayList<Ville> villes = parseReponse(rs, connection);
		connection.close();
		return villes;
	}
	
	//methode qui retourne la liste de toutes les villes
	public ArrayList<Ville> getInfoVilles() throws SQLException {
		String requeteSelect = "SELECT * FROM ville_france";
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(requeteSelect);
		return parseReponse(rs, connection);
	}
	
	//methode pour découper les réponses et éviter la duplication de code
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

	//méthode qui ajoute une ville
	public void addVille(Ville ville) throws SQLException {
		String requeteInsert = "INSERT INTO ville_france(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES "
				+ "('"+ville.getCodeCommune()+"','"+ville.getNomCommune()+"','"+ville.getCodePostal()+"','"
						+ ville.getLibelleAcheminement()+"','"+ville.getLigne()+"','"+ville.getLatitude()+"','"+ville.getLongitude()+"')";
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(requeteInsert);
		connection.close();
	}

	//méthode qui supprime une ville, en prenant le nom et le code postal
	public void delVille(String codePostal, String nomCommune) throws SQLException {
		String requeteDelete = "DELETE FROM ville_france WHERE code_postal = '" + codePostal + "' AND nom_commune = '"+ nomCommune +"'";
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(requeteDelete);
		connection.close();
	}

	//méthode pour update une ville par son code insee
	public void chgVilleCodeINSEE(Ville ville) throws SQLException {
		String requeteUpdate = "UPDATE ville_france SET Nom_commune='"+ville.getNomCommune()+"', "
				+ "Code_postal='"+ville.getCodePostal()+"', Libelle_acheminement='" + ville.getLibelleAcheminement()+"', "
						+ "Ligne_5='"+ville.getLigne()+"', Latitude='"+ville.getLatitude()+"', "
								+ "Longitude='"+ville.getLongitude()+"' "
										+ "WHERE Code_commune_INSEE='"+ville.getCodeCommune()+"'";
		Connection connection = JDBCConfiguration.getConnexionBDD();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(requeteUpdate);
		connection.close();
	}
}
