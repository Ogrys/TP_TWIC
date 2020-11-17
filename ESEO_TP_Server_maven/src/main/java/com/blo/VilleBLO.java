package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVille(String codePostal, String nomCommune) throws SQLException;

	public void addVille(String codePostal, String codeCommune, String nomCommune, String libelleAcheminement,
			String ligne, String latitude, String longitude) throws SQLException;

	public void delVille(String codePostal, String nomCommune) throws SQLException;

	public void chgVille(String codePostal, String codeCommune, String nomCommune, String libelleAcheminement,
			String ligne, String latitude, String longitude) throws SQLException;

}
