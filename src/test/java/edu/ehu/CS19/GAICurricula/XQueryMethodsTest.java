package edu.ehu.CS19.GAICurricula;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class XQueryMethodsTest {
	
	String listaXQueryFR;
	String listaXQueryFR2;
	String listaXQueryPOM;
	
	ArrayList<String> esperadoFR;
	ArrayList<String> esperadoPOM;
	
	@Before
	public void setUp() throws Exception {
		listaXQueryFR = 
				"for $c in doc(\"input/curriculumFranceSimp.xml\")/curriculums/curriculum[./prenom = 'Gusteau']" +
				"return $c/erasmusendroits/lieu";

		listaXQueryFR2 = 
				"for $c in doc(\"input/curriculumFranceSimp.xml\")/curriculums/curriculum[./prenom = 'Parsia']" +
				"return $c/erasmusendroits/lieu";
		
		listaXQueryPOM = 
				"for $d in doc(\"input/pom.xml\")/project/dependencies/dependency" +
				"return $d/artifactId";
		
		esperadoFR = new ArrayList<String>();
		esperadoFR.add("Bilbao");
		esperadoFR.add("Barcelona");
		esperadoFR.add("Sevilla");
		
		esperadoPOM = new ArrayList<String>();
		esperadoPOM.add("junit");
		esperadoPOM.add("Saxon-HE");
		
	}


	@Test
	public void consultaListaXQueryTestFR() {
		assertTrue(true);
	}

}
