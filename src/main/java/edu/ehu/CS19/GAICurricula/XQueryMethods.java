package edu.ehu.CS19.GAICurricula;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class XQueryMethods {
	
	public XQueryMethods() {
	}
	
	/**
	 * Genera un fichero de la extensión que sea a partir de un string con instrucciones de XQuery.
	 * 
	 * @param xQuery String que contiene las instrucciones de XQuery que se van a utilizar para realizar el fichero.
	 * @param fn2g String que contiene el nombre de ruta relativa de un fichero que se va a generar con lo dado en las instrucciones XQuery.
	 */
	public void generaXQFichero(String xQuery, String fn2g) {
		System.out.println("**Se va a generar el fichero: " + fn2g + "**");
		XQDataSource xqs = new SaxonXQDataSource();
		
		try {
			XQConnection conn = xqs.getConnection();
			XQExpression xqe = conn.createExpression();
			XQResultSequence rs = xqe.executeQuery(xQuery);
			
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

		System.out.println("**Fichero generado con Éxito**");

	}
	
	/**
	 * Genera un fichero de la extensión que sea a partir de la raíz de un XML de un pom y una ruta de destino.
	 * 
	 * @param inFile String fichero de entrada xml
	 * @param fn2g String fichero a generar
	 */
	public void generaXQPOM(String inFile, String fn2g) {
		System.out.println("**Se va a generar el fichero: " + fn2g + "**");
		XQDataSource xqs = new SaxonXQDataSource();
		String xQuery = "<html>\r\n" + 
				"    <title>MAVEN GAICurricula</title>\r\n" + 
				"    <head>\r\n" +
				"<meta charset=\"UTF-8\"></meta>" +
				"        <h1>GAICurricula</h1>\r\n" +
				"    </head>\r\n" + 
				"    <body>\r\n" + 
				"        <h3>Artefacto</h3>\r\n" + 
				"        {\r\n" + 
				"                for $p in doc(\"" + inFile + "\")/project\r\n" + 
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
		
		try {
			XQConnection conn = xqs.getConnection();
			XQExpression xqe = conn.createExpression();
			XQResultSequence rs = xqe.executeQuery(xQuery);
			
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

		System.out.println("**Fichero generado con Éxito**");

	}
	
	/**
	 * A partir de un XQuery con una referencia a un fichero XML, saca datos que se puedan listar en un ArrayList.
	 * 
	 * @param xquery 
	 * @return result
	 */
	public ArrayList<String> consultaListaXQuery(String xquery) {
	    System.out.println("**Empezando consulta**");

	    ArrayList<String> result = null;
	    
		try {
		    XQDataSource xqs = new SaxonXQDataSource(); 
			XQConnection conn = xqs.getConnection();
			XQExpression xqe = conn.createExpression();
			
		    XQResultSequence rs = xqe.executeQuery(xquery);
		    
		    result = new ArrayList<String>();

		    while(rs.next())
		      result.add(rs.getItemAsString(null));
		    
		    conn.close();
		} catch (XQException e) {
			System.err.println("**Error en la consulta**");
			e.printStackTrace();
		}
	    
		System.out.println("**Lista creada con éxito**");
	    return result;
	}
	
}
