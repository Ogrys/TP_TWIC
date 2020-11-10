package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	public ArrayList<Ville> getInfoVilles() throws SQLException;

	public ArrayList<Ville> getInfoVillesCodePostal(String codePostal) throws SQLException;

	
}
