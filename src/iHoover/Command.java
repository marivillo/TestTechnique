package iHoover;

public class Command {
	// members
	// members
	public  String[]  m_DataLines;
	private String [] m_commands;

	
	public Command (String[] dataLines)
	{
		m_DataLines = dataLines;
		m_commands  = readAllCmdLines(dataLines);
	}
	
    /**
     * this method let you read m_commands member variable.
     *
     * @param void
     * @return void
     */
    public String [] getCommands()
    {
        return m_commands;
    }
	
	
	/**
     * this method let you obtain multiple commands lines from txt file.
     *
     * @param void
     * @return  String array [commands] if no problem or null if there is a problem
     */
	private String[] readAllCmdLines(String[] dataLines){
		
		if (dataLines.length >= 3){
			String [] cmdLines = new String[dataLines.length-2];
			for (int loop=2;loop<dataLines.length;loop++){
				
				// get current command line
				String cmdLine = readCmdLine(dataLines[loop]);
				// evaluate current command line
				if(isCommandString(cmdLine) == false)
					 return null;
				else
					cmdLines[loop-2] = cmdLine;
			}
			return cmdLines;
		}
		else{
			return null;
		}
	}
	
	/**
     * this method let you obtain a command line from txt file.
     *
     * @param void
     * @return String [command] if no problem or null if there is a problem
     */
	private String readCmdLine(String cmdLine){
		//Splitting the array of number separated by space into string array.	
		//String cmdLine = m_DataLines[2]; 
		String[]  s_array = cmdLine.split(" ");
		
		for( int loop = 0; loop<s_array.length;loop++){
			// orientation out
			 if(isCommandString(s_array[loop]) == false)
				 return null;
		}
		return s_array[0];
	}

	
	/**
     * This method let you verify if the command line is correct or not (equal to A,G or D).
     *
     * @param text
     * @return true= correct or false = not correct
     */
	private boolean isCommandString(String text){
	    if(text == null||text.equals(""))
	    	return false;
	    
	    char[] characters = text.toCharArray();

	    for (int i = 0; i < characters.length; i++)
	    {
	    	if(characters[i] != 'A' && characters[i] != 'G' && characters[i] != 'D' )
	            return false;
	    }
	    return true;
	}
	
	
	/**
     * this  method let you verify if each command line has the correct information or not.
     *
     * @param void
     * @return true= correct or false = not correct
     */
	
	public boolean verifyCmdFromFile(){
		
		if (m_commands == null){
			System.out.println(" Problem with commands line!!!");
			return false;
		}else{
			System.out.println(" Commands lines are correct!!!");
			return true;
		}
		

							
	}


	
}
