package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	public ArrayList<Ville> getInfoVille() throws SQLException;

	public ArrayList<Ville> getInfoVilles(String param) throws SQLException;

	
}
