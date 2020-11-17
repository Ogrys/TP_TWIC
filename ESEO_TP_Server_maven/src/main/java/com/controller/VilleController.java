package com.controller;


import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
class VilleController {

	@Autowired
	VilleBLO villeService;

	//Methode por récupérer toutes les villes (possiblité par codePostal et nomCommune) 
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> getInfos(@RequestParam(required = false, value = "codePostal") String codePostal,
			@RequestParam(required = false, value = "nomCommune") String nomCommune) throws ClassNotFoundException, SQLException {
		ArrayList<Ville> ville = villeService.getInfoVille(codePostal, nomCommune);
		return ville;
	}
	
	//méthode pour ajouter une ville
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void addVille(@RequestParam(required = true, value = "codePostal") String codePostal, 
			@RequestParam(required = true, value = "codeCommune") String codeCommune,
			@RequestParam(required = true, value = "nomCommune") String nomCommune,
			@RequestParam(required = true, value = "libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = true, value = "ligne") String ligne,
			@RequestParam(required = true, value = "latitude") String latitude,
			@RequestParam(required = true, value = "longitude") String longitude) throws ClassNotFoundException, SQLException {
		villeService.addVille(codePostal, codeCommune, nomCommune, libelleAcheminement, ligne,
				latitude, longitude);
	}
	
	//méthode pour supprimer une ville
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public void delVille(@RequestParam(required = true, value = "codePostal") String codePostal,
			@RequestParam(required = true, value = "nomCommune") String nomCommune) throws ClassNotFoundException, SQLException {
		villeService.delVille(codePostal, nomCommune);
	}
	
	
	//méthode pour modifier une ville
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void chgVille(@RequestParam(required = true, value = "codePostal") String codePostal, 
			@RequestParam(required = true, value = "codeCommune") String codeCommune,
			@RequestParam(required = true, value = "nomCommune") String nomCommune,
			@RequestParam(required = true, value = "libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = true, value = "ligne") String ligne,
			@RequestParam(required = true, value = "latitude") String latitude,
			@RequestParam(required = true, value = "longitude") String longitude) throws ClassNotFoundException, SQLException {
		villeService.chgVille(codePostal, codeCommune, nomCommune, libelleAcheminement, ligne,
				latitude, longitude);
	}
	
}