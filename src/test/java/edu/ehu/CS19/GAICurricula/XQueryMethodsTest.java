package edu.ehu.CS19.GAICurricula;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class XQueryMethodsTest {

	static XQueryMethods xqm;

	static ArrayList<String> esperadoFR;
	static ArrayList<String> esperadoPOM;

	@BeforeAll
	static void beforeAll() throws Exception {

		xqm = new XQueryMethods();

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
	@DisplayName("Consulta Lista XQuery FR")
	@ParameterizedTest
	@CsvSource({"Gusteau", "Parsia"})
	void consultaListaXQueryTestFR(String prenom) {

		String listaXQueryFR = 
				"for $c in doc(\"input/curriculumFranceSimp.xml\")/curriculums/curriculum[./prenom = '" + prenom + "']\n" +
						"return $c/erasmusendroits/lieu/text()";

		ArrayList<String> resultado = xqm.consultaListaXQuery(listaXQueryFR);

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
	@DisplayName("Consulta Lista XQuery POM")
	@Test
	void consultaListaXQueryTestPOM() {

		String listaXQueryPOM =
				"for $d in doc(\"input/pom.xml\")/project/dependencies/dependency\n" +
						"return $d/artifactId/text()";

		ArrayList<String> resultado = xqm.consultaListaXQuery(listaXQueryPOM);

		for(int i = 0; i < resultado.size(); i++) {
			if(resultado.get(i).compareTo(esperadoPOM.get(i)) != 0) {
				fail("El resultado y lo esperado es distinto: " + resultado.get(i) + " con " + esperadoPOM.get(i));
			}
		}

		assertTrue(true);
	}

}
