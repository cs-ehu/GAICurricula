package edu.ehu.CS19.GAICurricula;

public class Data2html {
	@SuppressWarnings({ "static-access", "static-access" })
	public static void main(String[] args) {
		
		XQueryMethods xqm = new XQueryMethods();
		
		//Generación del fichero html que representa el erasmus de Francia
		String filenameFRHTML = "output/curriculumFrance.html";

		String xqueryFR = "<html>\r\n" + 
				"    <title>Curriculums erasmus</title>\r\n" + 
				"    <head>\r\n" + 
				"<meta charset=\"UTF-8\"></meta>" +
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
				"                        <h3>Datos b�sicos</h3>\r\n" + 
				"                        <strong>-Nom et pr�nom: </strong>\r\n" + 
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
				"                        <h3>Direcci�n</h3>\r\n" + 
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
				"                        <br>{data($c/carriere/@yearsstudying-a�oscursando-anneesdetudes)}</br>\r\n" + 
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
				"                        <h3>Datos ac�demicos/laborales</h3>\r\n" + 
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
				"                                    ({$t/dateded�but}, {$t/datedefin})\r\n" + 
				"                                    <strong> -Entreprise: </strong>\r\n" + 
				"                                    {$t/entreprise}\r\n" + 
				"                                    <br></br>\r\n" + 
				"                                    <strong>-Descripci�n: </strong>\r\n" + 
				"                                    {$t/description}\r\n" + 
				"                                    <br></br>\r\n" + 
				"                                    <strong>-Temps con sacr�/Produit: </strong>\r\n" + 
				"                                    {$t/tempsconsacr�, $t/produit}\r\n" + 
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
		
		xqm.generaXQFichero(xqueryFR, filenameFRHTML);
		
		//Generación del fichero html que representa el erasmus de Inglaterra
		/*String filenameENHTML = "output/curriculumEngland.html";
		String xqueryEN = "<Insertar aqu� xquery de England>";
		
		xqm.generaXQFichero(xqueryEN, filenameENHTML);*/
		
		String filenameENHTML = "output/pomGAICurricula.html";
		String xqueryEN = "<html>\r\n" + 
				"    <title>MAVEN GAICurricula</title>\r\n" + 
				"    <head>\r\n" +
				"<meta charset=\"UTF-8\"></meta>" +
				"        <h1>GAICurricula</h1>\r\n" +
				"    </head>\r\n" + 
				"    <body>\r\n" + 
				"        <h3>Artefacto</h3>\r\n" + 
				"        {\r\n" + 
				"                for $p in doc(\"input/pom.xml\")/project\r\n" + 
				"                return\r\n" + 
				"                    <div id=\"all-page\">\r\n" + 
				"                        <div id=\"artifact\">\r\n" + 
				"                            <strong>-Id del grupo: </strong>\r\n" + 
				"                            <br>{$p/groupId}</br>\r\n" + 
				"                            <br></br>\r\n" + 
				"                            <strong>-Id del artefacto: </strong>\r\n" + 
				"                            <br>{$p/artifactId}</br>\r\n" + 
				"                            <br></br>\r\n" + 
				"                            <strong>-Versión: </strong>\r\n" + 
				"                            <br>{$p/version}</br>\r\n" + 
				"                            <br></br>\r\n" + 
				"                            <strong>-Packaging: </strong>\r\n" + 
				"                            <br>{$p/packaging}</br>\r\n" + 
				"                            <br></br>\r\n" + 
				"                        </div>\r\n" + 
				"                        <h3>Datos del proyecto</h3>\r\n" + 
				"                        <div id=\"proyect-data\">\r\n" + 
				"                            <strong>-Nombre del proyecto: </strong>\r\n" + 
				"                            <br>{$p/name}</br>\r\n" + 
				"                            <br></br>\r\n" + 
				"                            <strong>-URL: </strong>\r\n" + 
				"                            <a href=\"{$p/url}\"> Visitar URL del proyecto </a>\r\n" + 
				"                            <br></br>\r\n" + 
				"                            <strong>-Codificación del proyecto: </strong>\r\n" + 
				"                            <br>{$p/properties/project.build.sourceEncoding}</br>\r\n" + 
				"                        </div>\r\n" + 
				"                        <h3>Dependencias del proyecto</h3>\r\n" + 
				"                        <div id=\"dependencies\">\r\n" + 
				"                            <table border=\"1\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <th>Id del grupo</th><th>Id del artefacto</th><th>Versión</th>\r\n" + 
				"                                </tr>                            \r\n" + 
				"                                {\r\n" + 
				"                                    for $d in $p/dependencies/dependency\r\n" + 
				"                                    return\r\n" + 
				"                                    <tr>\r\n" + 
				"                                      <td>{$d/groupId}</td><td>{$d/artifactId}</td><td>{$d/version}</td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                }\r\n" + 
				"                            </table>\r\n" + 
				"                        </div>\r\n" + 
				"                        <h3>Plugins del proyecto</h3>\r\n" + 
				"                        <div id=\"plugins\">\r\n" + 
				"                             <table border=\"1\">\r\n" + 
				"                                <tr>\r\n" + 
				"                                    <th>Id del grupo</th><th>Id del artefacto</th>\r\n" + 
				"                                </tr>                            \r\n" + 
				"                                {\r\n" + 
				"                                    for $pl in $p/build/pluginManagement/plugins/plugin\r\n" + 
				"                                    return\r\n" + 
				"                                    <tr>\r\n" + 
				"                                      <td>{$pl/groupId}</td><td>{$pl/artifactId}</td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                }\r\n" + 
				"                            </table>\r\n" + 
				"                        </div>\r\n" + 
				"                    </div>\r\n" + 
				"        }\r\n" + 
				"    </body>\r\n" + 
				"</html>";
		
		xqm.generaXQFichero(xqueryEN, filenameENHTML);
		
	}
}