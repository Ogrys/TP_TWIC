package com.blo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Override
	public ArrayList<Ville> getInfoVille() {
		ArrayList<Ville> listeVille;
		
		listeVille = null;
		//TODO dao
		
		return listeVille;
	}
	

}
