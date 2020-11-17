package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	public ArrayList<Ville> getInfoVilles() throws SQLException;

	public ArrayList<Ville> getInfoVillesCodePostal(String codePostal) throws SQLException;
	
	public ArrayList<Ville> getInfoVillesNomCommune(String nomCommune) throws SQLException;

	public void addVille(Ville ville) throws SQLException;

	public void delVille(String codePostal, String nomCommune) throws SQLException;

	public void chgVilleCodeINSEE(Ville ville) throws SQLException;
}
