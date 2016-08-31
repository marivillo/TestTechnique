package iHoover;

import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		// Obtaining URL			
		if (args.length == 0){
			System.out.println(" Please, you must insert txt file url!!!");
		}
		else{
			String filename;
			filename = args [0];
			// reading File
			try {
				// read file
				ReadFile file = new ReadFile(filename);
				// obtain data lines
				String[]dataFile = file.openFile();
				// Obtain coordinates information
				Coordinates coord = new Coordinates(dataFile);			
				// Obtain command from file
				Command cmd = new Command(dataFile);
				// Verifying information from file
				if(cmd.verifyCmdFromFile() && coord.verifyCoordFromFile())
				{
					// Aspirateur
					Aspirateur aspIHoover = new Aspirateur(coord);
					// exec command(s)
					aspIHoover.execCmd(cmd);			
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
