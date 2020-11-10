package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville {
	
	public String codeCommune;
	
	public String nomCommune;
	
	public String codePostal;
	
	public String libelleAcheminement;
	
	public String ligne;
}
