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
