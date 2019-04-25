package xqjcurricula;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class Curriculums2html {
	public static void main(String[] args) throws XQException {
		
		//Generación del fichero html que representa el erasmus de Francia
		String filenameFRHTML = "output/curriculumFrance.html";

		String xqueryFR = "<html>\r\n" + 
				"    <title>Curriculums erasmus</title>\r\n" + 
				"    <head>\r\n" + 
				"        <h1>Curriculums erasmus</h1>\r\n" + 
				"    </head>\r\n" + 
				"    <body>\r\n" + 
				"        <h2>Curriculums franceses</h2>\r\n" + 
				"        <div\r\n" + 
				"            id=\"curFran\">\r\n" + 
				"            {\r\n" + 
				"                for $c in doc(\"input/curriculumFranceSimp.xml\")/curriculums/curriculum\r\n" + 
				"                return\r\n" + 
				"                    <div\r\n" + 
				"                        id=\"{$c/CNI}\">\r\n" + 
				"                        <hr></hr>\r\n" + 
				"                        <img\r\n" + 
				"                            src=\"{data($c/@img)}\"\r\n" + 
				"                            alt=\"{$c/prenom}\"\r\n" + 
				"                            height=\"350\"\r\n" + 
				"                            width=\"300\"/>\r\n" + 
				"                        <h3>Datos básicos</h3>\r\n" + 
				"                        <strong>-Nom et prénom: </strong>\r\n" + 
				"                        <br>{data($c/@name-nombre-nom), $c/prenom}</br>\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Date De Naissance: </strong>\r\n" + 
				"                        <br>{data($c/@birthday-fnacimiento-datedenaissance)}</br>\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Passeport: </strong>\r\n" + 
				"                        {$c/passeport}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-CNI: </strong>\r\n" + 
				"                        {$c/CNI}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Email: </strong>\r\n" + 
				"                        {$c/email}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Tlf/Mobile: </strong>\r\n" + 
				"                        {$c/mobile, $c/tlfne}\r\n" + 
				"                        <h3>Dirección</h3>\r\n" + 
				"                        <strong>Pays: </strong>\r\n" + 
				"                        <br>{data($c/addresse/@country-paisOrigen-pays)}</br>\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong> CP: </strong>\r\n" + 
				"                        {$c/addresse/CPFr}\r\n" + 
				"                        <strong> Region: </strong>\r\n" + 
				"                        {$c/addresse/region}\r\n" + 
				"                        <strong> Province: </strong>\r\n" + 
				"                        {$c/addresse/province}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Ville: </strong>\r\n" + 
				"                        {$c/addresse/ville}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Rue: </strong>\r\n" + 
				"                        {$c/addresse/rue}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Addresse: </strong>\r\n" + 
				"                        Portail {$c/addresse/portail, $c/addresse/appartement}\r\n" + 
				"                        <h3>Idiomas</h3>\r\n" + 
				"                        <strong>-Langue maternelle: </strong>\r\n" + 
				"                        {$c/languematernelle}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Langue etrangeres: </strong>\r\n" + 
				"                        <table\r\n" + 
				"                            border=\"1\">\r\n" + 
				"                            <tr>\r\n" + 
				"                                <th>Langue</th><th>Niveau</th>\r\n" + 
				"                            </tr>\r\n" + 
				"                            {\r\n" + 
				"                                for $l in $c/languesetrangeres/lng\r\n" + 
				"                                return\r\n" + 
				"                                    <tr>\r\n" + 
				"                                        <td>{$l/text()}</td><td>{data($l/@level-nivel-niveau)}</td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                            }\r\n" + 
				"                        </table>\r\n" + 
				"                        <h3>Datos erasmus</h3>\r\n" + 
				"                        <strong>-Carriere: </strong>\r\n" + 
				"                        {$c/carriere}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong> -Cours: </strong>\r\n" + 
				"                        <br>{data($c/carriere/@course-curso-cours)}</br>\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Annees de tudes:</strong>\r\n" + 
				"                        <br>{data($c/carriere/@yearsstudying-añoscursando-anneesdetudes)}</br>\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong> -Erasmus endroits:</strong>\r\n" + 
				"                        {\r\n" + 
				"                            for $li in $c/erasmusendroits/lieu\r\n" + 
				"                            return\r\n" + 
				"                                <br>{$li}</br>\r\n" + 
				"                        }\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <strong>-Lieu prioritaire:</strong>\r\n" + 
				"                        {$c/lieuprioritaire}\r\n" + 
				"                        <br></br>\r\n" + 
				"                        <h3>Datos acádemicos/laborales</h3>\r\n" + 
				"                        <h4>Travails</h4>\r\n" + 
				"                        {\r\n" + 
				"                            for $t in $c/travail/occupation\r\n" + 
				"                            return\r\n" + 
				"                                <div>\r\n" + 
				"                                    <strong>-Poste:</strong>\r\n" + 
				"                                    <br>{data($t/@poste)}</br>\r\n" + 
				"                                    <br></br>\r\n" + 
				"                                    <strong> -Type de travail:</strong>\r\n" + 
				"                                    <br>{data($t/@typedetravail)}</br>\r\n" + 
				"                                    <br></br>\r\n" + 
				"                                    <strong> -Lieu de travail:</strong>\r\n" + 
				"                                    <br>{data($t/@lieudetravail)}</br>\r\n" + 
				"                                    <br></br>\r\n" + 
				"                                    <strong>-Periodo:</strong>\r\n" + 
				"                                    ({$t/datededébut}, {$t/datedefin})\r\n" + 
				"                                    <strong> -Entreprise: </strong>\r\n" + 
				"                                    {$t/entreprise}\r\n" + 
				"                                    <br></br>\r\n" + 
				"                                    <strong>-Descripción: </strong>\r\n" + 
				"                                    {$t/description}\r\n" + 
				"                                    <br></br>\r\n" + 
				"                                    <strong>-Temps con sacré/Produit: </strong>\r\n" + 
				"                                    {$t/tempsconsacré, $t/produit}\r\n" + 
				"                                </div>\r\n" + 
				"                        }\r\n" + 
				"                        <h4>Meilleure notes</h4>\r\n" + 
				"                        <table\r\n" + 
				"                            border=\"1\">\r\n" + 
				"                            <tr>\r\n" + 
				"                                <th>Code etudiant</th><th>Cours</th><th>Note moyenne</th>\r\n" + 
				"                            </tr>\r\n" + 
				"                            {\r\n" + 
				"                                for $n in $c/notes/meilleurenote\r\n" + 
				"                                return\r\n" + 
				"                                    <tr>\r\n" + 
				"                                        <td>{$n/codeetudiant}</td><td>{data($n/@cours)}</td><td>{$n/notemoyenne}</td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                            }\r\n" + 
				"                        </table>\r\n" + 
				"                        <h4>Realisation</h4>\r\n" + 
				"                        {\r\n" + 
				"                            for $r in $c/realisation/realisationatteint\r\n" + 
				"                            return\r\n" + 
				"                                <br>{$r}</br>\r\n" + 
				"                        }\r\n" + 
				"                        <hr></hr>\r\n" + 
				"                    </div>\r\n" + 
				"            }\r\n" + 
				"        </div>\r\n" + 
				"    </body>\r\n" + 
				"</html>";
		
		generaXQFichero(xqueryFR, filenameFRHTML);
		
		//Generación del fichero html que representa el erasmus de Inglaterra
		String filenameENHTML = "output/curriculumEngland.html";
		String xqueryEN = "<Insertar aquí xquery de England>";
		
		generaXQFichero(xqueryEN, filenameENHTML);
		
	}
	
	/**
	 * Genera un fichero de la extensión que sea a partir de un string con instrucciones de XQuery.
	 * 
	 * @param xquery String que contiene las instrucciones de XQuery que se van a utilizar para realizar el fichero.
	 * @param fn2g String que contiene el nombre de ruta relativa de un fichero que se va a generar con lo dado en las instrucciones XQuery.
	 */
	public static void generaXQFichero(String xquery, String fn2g) {
		System.out.println("**Se va a generar el fichero: " + fn2g + "**");
		XQDataSource xqs = new SaxonXQDataSource();
		
		try {
			XQConnection conn = xqs.getConnection();
			XQExpression xqe = conn.createExpression();
			XQResultSequence rs = xqe.executeQuery(xquery);
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fn2g));

			while (rs.next()) {
				String aline = rs.getItemAsString(null);
				bufferedWriter.write(aline);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
			conn.close();
		} catch (XQException e) {
			System.err.println("**Error inicializando la escritura del fichero con xquery** ver más:");
			e.printStackTrace();
		} catch (IOException ex) {
			System.err.println("**Error en la escritura del fichero '" + fn2g + "'**");
		}

		System.out.println("**Fichero generado con éxito**");

	}
}