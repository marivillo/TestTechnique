package iHoover;

public class Aspirateur {
	//members
	public  Coordinates m_coord;
	public  String m_AspPosition;
	
	
	public Aspirateur (Coordinates coordinatesLines)
	{
		m_coord = coordinatesLines;
		m_AspPosition = m_coord.m_currentPosX +" "+ m_coord.m_currentPosY +" "+ m_coord.m_currentDir;	
	}
		
		
	/**
     * This method let you execute multiples commands lines.
     *
     * @param Comnand object
     * @return void
     */
	public void execCmd(Command cmd) {
		String[] cmdLines = cmd.getCommands();
		for (int loop=0; loop < cmdLines.length; loop++)
		{
			readCmd(cmdLines[loop]);
			writeCurrentPosAndDir(m_AspPosition);
		}
	}		
	

	/**
     * This method let you read the commands lines in order to update the position and direction.
     *
     * @param command Line
     * @return void
     */
	private void readCmd(String currentcmd) {

		int  currentPosX= m_coord.m_currentPosX;// mcPosX;
		int  currentPosY= m_coord.m_currentPosY;//PosY;
		char currentDir = m_coord.m_currentDir; //Dir;
		//System.out.println(currentPosX +" "+ currentPosY +" "+ currentDir);
		char[] characters = currentcmd.toCharArray();
		for (int i = 0; i < characters.length; i++)
		{
		   
			// Avancer
			if(characters[i] == 'A')
			{
				if(currentDir == 'N') currentPosY = currentPosY + 1;
				if(currentDir == 'E') currentPosX = currentPosX + 1;
				if(currentDir == 'S') currentPosY = currentPosY - 1;
				if(currentDir == 'W') currentPosX = currentPosX - 1;
				// verifying current position if is bigger than bounds 
				if(currentPosX > m_coord.getRoomSizeX())  currentPosX = m_coord.getRoomSizeX(); //if bigger than X bound of room size current posX = Xcoord bound
				if(currentPosY > m_coord.getRoomSizeY())  currentPosY = m_coord.getRoomSizeY(); //if bigger than Y bound of room size current posY = Ycoord bound
			 }
			// Gauche
			if(characters[i] == 'G')
			{
				if(currentDir == 'N') currentDir = 'w';
				if(currentDir == 'E') currentDir = 'n';
				if(currentDir == 'S') currentDir = 'e';
				if(currentDir == 'W') currentDir = 's';
				//to Majuscule
				currentDir = (char)((int)currentDir-32);
			 }				
			// Droite
			if(characters[i] == 'D' )
			{
				if(currentDir == 'N') currentDir = 'e';
				if(currentDir == 'E') currentDir = 's';
				if(currentDir == 'S') currentDir = 'w';
				if(currentDir == 'W') currentDir = 'n';
				//to Majuscule
				currentDir = (char)((int)currentDir-32);
			 }
			//System.out.println(characters[i]);
			//System.out.println(currentPosX +" "+ currentPosY +" "+ currentDir);
		}
		//update
		m_AspPosition = currentPosX +" "+ currentPosY +" "+ currentDir;	
		m_coord.m_currentPosX = currentPosX;
		m_coord.m_currentPosY = currentPosY;
		m_coord.m_currentDir = currentDir;
		//System.out.println(currentPosX +" "+ currentPosY +" "+ currentDir);
		//System.out.println(m_coord.m_currentPosX  +" "+ m_coord.m_currentPosY +" "+ m_coord.m_currentDir);
		

	}
	
	/**
     * This method let you write current position after a command lines.
     *
     * @param result(current position and direction)
     * @return void
     */
	private void writeCurrentPosAndDir(String result) {
	// TODO Auto-generated method stub
		System.out.println("Current Position : " + result);

	}
		


	



}
