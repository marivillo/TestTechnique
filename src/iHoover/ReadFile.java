package iHoover;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	
	public static String m_path;
	public static String[]  m_DataLines;
	public static Integer[] m_roomSize;
	public static Integer[] m_initCoord;
	public static String [] m_commands;
	public static char m_initDir;
	
	public ReadFile(String file_path){
		m_path = file_path;
	}
	
	/**
     * This method let you obtain the number of lines contain in a text file .
     *
     * @param 
     * @return nbOfLines
     */
	
	public int readLines() throws IOException {
		FileReader file_to_read = new FileReader(m_path);	 //  This reads bytes from a text file, and each byte is a single character
		BufferedReader bf = new BufferedReader(file_to_read);// let you read whole lines of text, rather than single characters
		String cLine;										 // string variable for current line
		int nbOfLines = 0;									 // set the number of lines
		while ((cLine = bf.readLine()) != null){
			nbOfLines++;									 // update number of lines 
		}
		bf.close();											 // close reader
		return nbOfLines;
	}
	
	/**
     * This method let you open and read a txt file.
     *
     * @param 
     * @return nbOfLines
     */
	
	public String[] openFile() throws IOException{
		
		FileReader fr = new FileReader(m_path);				//  This reads bytes from a text file, and each byte is a single character
		BufferedReader txtReader = new BufferedReader(fr); 	// let you read whole lines of text, rather than single characters
		int nbOfLines = readLines();									// set the number of lines
		String[] txtData = new String[nbOfLines];			// sets up a String array
		//
		for(int loop=0; loop<nbOfLines;loop++){
			txtData[loop]= txtReader.readLine();		 	// read whole lines, rather than single characters	
		}		
		txtReader.close();									// close reader
		return txtData;
	}
	
	
	
}
