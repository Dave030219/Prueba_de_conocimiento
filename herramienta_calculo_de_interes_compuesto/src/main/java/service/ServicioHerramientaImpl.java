package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Inversion;
import model.Salida;

@Service
public class ServicioHerramientaImpl implements ServicioHerramienta {

	@Override
	public boolean validaEntradas(float ii, float aa, float piaa, float ai, float ri) {
		if ((ii >= 1000f) && (aa >= 0f) && (ai >= 0) && (ri >= 0)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Inversion calculaSalida(float ii, float aa, float piaa, float ai, float ri) {
		Inversion inversion = new Inversion();
		
		List<Salida> salida = new ArrayList <Salida>();
		float saldoInicial=0f;
		float aportacion=0f;
		float rendimiento=0f;
		float saldoFinal=0f;
		float aportacionesAnuales=0f;
		
		for (int i = 0; i < ai; i++) {
			
			if (i == 0) {
				saldoInicial = ii;
				aportacion = aa;
			} else {
				saldoInicial = saldoFinal;
				aportacion = (float) (aportacion * (1f + (piaa/100f)));
			}
			
			rendimiento = (float) ((saldoInicial + aportacion) * (ri / 100f));
			saldoFinal = (float) saldoInicial + aportacion + rendimiento;
			
			Salida sal = new Salida();
			sal.setAnio(i+1);
			sal.setSaldoI(saldoInicial);
			sal.setAportacion(aportacion);
			sal.setRendimiento(rendimiento);
			sal.setSaldoF(saldoFinal);
			
			
			aportacionesAnuales = aportacionesAnuales + aportacion;
			salida.add(sal);
		
		}
		
		inversion.setGi(saldoFinal- ii - aportacionesAnuales);
		inversion.setMf(saldoFinal);
		inversion.setSalida(salida);

		return inversion;
	}

}
