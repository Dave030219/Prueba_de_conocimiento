package service;

import java.util.List;


import model.Inversion;


public interface ServicioHerramienta {
	Inversion calculaSalida(float ii, float aa, float piaa, float ai, float ri);
	boolean validaEntradas(float ii, float aa, float piaa, float ai, float ri);
}
