package com.blo;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;

	public ArrayList<Ville> getInfoVille(String codePostal, String nomCommune) throws SQLException {
		ArrayList<Ville> ville = null;
		if (codePostal != null) {
			ville = villeDAO.getInfoVillesCodePostal(codePostal);
		}else if(nomCommune != null) {
			ville = villeDAO.getInfoVillesNomCommune(nomCommune);
		} else {
			ville = villeDAO.getInfoVilles();
		}
		return ville;
	}

	
	public void addVille(String codePostal, String codeCommune, String nomCommune,
			String libelleAcheminement, String ligne, String latitude, String longitude) throws SQLException {
		Ville ville = new Ville();
		ville.setCodeCommune(codeCommune);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLibelleAcheminement(libelleAcheminement);
		ville.setLigne(ligne);
		ville.setLatitude(latitude);
		ville.setLongitude(longitude);
		villeDAO.addVille(ville);
	}


	@Override
	public void delVille(String codePostal, String nomCommune) throws SQLException {
		villeDAO.delVille(codePostal, nomCommune);		
	}


	@Override
	public void chgVille(String codePostal, String codeCommune, String nomCommune,
			String libelleAcheminement, String ligne, String latitude, String longitude) throws SQLException {
		Ville ville = new Ville();
		ville.setCodeCommune(codeCommune);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLibelleAcheminement(libelleAcheminement);
		ville.setLigne(ligne);
		ville.setLatitude(latitude);
		ville.setLongitude(longitude);
		villeDAO.chgVilleCodeINSEE(ville);
	}

}
