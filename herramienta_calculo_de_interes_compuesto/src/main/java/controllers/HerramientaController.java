package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import model.Inversion;
import service.ServicioHerramienta;

@CrossOrigin(origins="*")
@RestController
public class HerramientaController {
	

	@Autowired
	ServicioHerramienta calcula;

	@GetMapping(value="calcula", produces=MediaType.APPLICATION_JSON_VALUE)
	public Inversion Calcula(@RequestParam("ii") float ii,@RequestParam("aa") float aa,@RequestParam("piaa") float piaa,@RequestParam("ai") float ai,@RequestParam("ri") float ri){
		
		Inversion result= null;
		boolean validaCalculo = false;
		
		validaCalculo = calcula.validaEntradas(ii,aa,piaa,ai,ri);
		
		if(validaCalculo) {
			result = (Inversion) calcula.calculaSalida(ii,aa,piaa,ai,ri);
		}
		
		return result;
	}
}

