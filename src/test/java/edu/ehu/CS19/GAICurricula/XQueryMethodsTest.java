package edu.ehu.CS19.GAICurricula;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class XQueryMethodsTest {
	
	XQueryMethods xqm;
	
	String listaXQueryFR;
	String listaXQueryFR2;
	String listaXQueryPOM;
	
	ArrayList<String> esperadoFR;
	ArrayList<String> esperadoPOM;
	
	@Before
	public void setUp() throws Exception {
		
		xqm = new XQueryMethods();
		
		listaXQueryFR = 
				"for $c in doc(\"input/curriculumFranceSimp.xml\")/curriculums/curriculum[./prenom = 'Gusteau']\n" +
				"return $c/erasmusendroits/lieu/text()";

		listaXQueryFR2 = 
				"for $c in doc(\"input/curriculumFranceSimp.xml\")/curriculums/curriculum[./prenom = 'Parsia']\n" +
				"return $c/erasmusendroits/lieu/text()";
		
		listaXQueryPOM = 
				"for $d in doc(\"input/pom.xml\")/project/dependencies/dependency\n" +
				"return $d/artifactId/text()";
		
		esperadoFR = new ArrayList<String>();
		esperadoFR.add("Bilbao");
		esperadoFR.add("Barcelona");
		esperadoFR.add("Sevilla");
		
		esperadoPOM = new ArrayList<String>();
		esperadoPOM.add("junit");
		esperadoPOM.add("Saxon-HE");
		
	}

	/**
	 *  Comprueba que los lugares del primer estudiante francés son los correctos.
	 */
	@Test
	public void consultaListaXQueryTestFR() {
		ArrayList<String> resultado = xqm.consultaListaXQuery(listaXQueryFR);
		
		for(int i = 0; i < resultado.size(); i++) {
			if(resultado.get(i).compareTo(esperadoFR.get(i)) != 0) {
				fail("El resultado y lo esperado es distinto: " + resultado.get(i) + " con " + esperadoFR.get(i));
			}
		}
		
		assertTrue(true);
	}
	
	/**
	 *  Comprueba que los lugares del segundo estudiante francés son los correctos.
	 */
	@Test
	public void consultaListaXQueryTestFR2() {
		ArrayList<String> resultado = xqm.consultaListaXQuery(listaXQueryFR2);
		
		for(int i = 0; i < resultado.size(); i++) {
			if(resultado.get(i).compareTo(esperadoFR.get(i)) != 0) {
				fail("El resultado y lo esperado es distinto: " + resultado.get(i) + " con " + esperadoFR.get(i));
			}
		}
		
		assertTrue(true);
	}
	
	/**
	 *  Comprueba que las dependencias del POM tienen un artifactId correcto.
	 */
	@Test
	public void consultaListaXQueryTestPOM() {
		ArrayList<String> resultado = xqm.consultaListaXQuery(listaXQueryPOM);
		
		for(int i = 0; i < resultado.size(); i++) {
			if(resultado.get(i).compareTo(esperadoPOM.get(i)) != 0) {
				fail("El resultado y lo esperado es distinto: " + resultado.get(i) + " con " + esperadoPOM.get(i));
			}
		}
		
		assertTrue(true);
	}

}
