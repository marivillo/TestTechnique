package iHoover;


public class Coordinates {
	
	//members
	private String[]  m_DataLines;	
	private Integer[] m_roomSize;
	private int m_roomSizeX;
	private int m_roomSizeY;
	private Integer[] m_initPos;
	private int  m_initPosX;
	private int  m_initPosY;
	private char m_initDir;
	public int  m_currentPosX;
	public int  m_currentPosY;
	public char m_currentDir;	
	
	
	public Coordinates (String[] dataLines)
	{
		m_DataLines = dataLines;
		m_roomSize 	= getRoomSize();
		m_initPos   = getInitCoord(); 
		m_initDir   = getInitDir();
	}
	

	/**
     * This method let you obtain the size of the room from the first line of the text file.
     *
     * @param void
     * @return Int array [heigth, width] if no problem or null if there is a problem
     */
	private Integer[] getRoomSize(){
		
		String line = m_DataLines[0]; 									// Splitting the array of number separated by space into string array.
		String[]  s_array = line.split(" ");
		if(s_array.length == 2){
			Integer[] n_array = new Integer[s_array.length];
			for(int loop =0; loop<n_array.length;loop++)
		    {
				if(isNumericString(s_array[loop])== true)
				{
					int valueTotest = Integer.parseInt(s_array[loop]);	// Parsing from string to int
					if (valueTotest== 0){
						n_array = null; 								// Room size value cannot be equal to zero!!!
						break;
					}else{
						n_array[loop] = valueTotest;
					}
				}else{
					n_array = null; 									// Room size value is not a number or it is less than zero!!!
					break;
				}        
		    }
			return n_array;
		}else
			return null; 												//"Room size values must be max two strings!!!"
		
			
		
	}
	
	/**
     * This method let you obtain the init coordinates from the second line of the text file.
     *
     * @param void
     * @return Int array [XInitCoord, YInitCoord] if no problem or null if there is a problem
     */
	private Integer[] getInitCoord(){
		String line = m_DataLines[1]; 									//Splitting the array of number separated by space into string array.
		String[]  s_array = line.split(" ");
		if(s_array.length == 3){
			
			int l_coord = s_array.length-1; 							// orientation string is not took into account
			Integer[] n_array = new Integer[l_coord];
			for(int loop =0; loop<l_coord;loop++) 						//Creating the int array of size equals to string array.
		    {
				if(isNumericString(s_array[loop]))
				{
					int valueToTest = Integer.parseInt(s_array[loop]);	// Parsing from string to int
					if (valueToTest > m_roomSize[loop]){	
						n_array = null; 								// "This coordinate value (" + s_array[loop] + ") is out of bounds!!!"
						break;
					}else
						n_array[loop] = valueToTest;					
				}else{
					n_array = null;										// "Init coordinate value (" + s_array[loop] + ") is not a number or it is less than zero!!!"
					break;
				}		        
		    }
			return n_array;
		}else
			return null;							 					// number of string of Init position values and directions must be equal to three 
			
	}
	
	/**
     * This method let you obtain the init direction from the second line of the text file.
     *
     * @param void
     * @return String [N,S,E or W] if no problem or null if there is a problem
     */
	private char getInitDir(){
		String line = m_DataLines[1]; 									//Splitting the array of number separated by space into string array.
		String[]  s_array = line.split(" ");
		if(s_array.length == 3){
		if(isDirectionString(s_array[2]) == true) 
			return s_array[2].charAt(0);
		else
			return '\0';												// "Init direction letter must equal to N,E,W ou S instead of " + s_array[2] + "!!!"	
		} 
		else{
			return '\0';
		}
			
	}
	
	/**
     * This method let you verify if the string is a number.
     *
     * @param text
     * @return true= is a number or false = is not a number
     */
	private boolean isNumericString(String text){
	    if((text == null|| text.equals("")) && text.length() > 1){
	    	return false;
	    }
	    char[] characters = text.toCharArray();
	    for (int i = 0; i < text.length(); i++)
	    {
	        if (characters[i] < 48 || characters[i] > 57)
	        	return false;
	    }
	    return true;
	}
	
	/**
     * This method let you verify if the input direction string is correct (Equal to N,E,S or W) .
     *
     * @param text
     * @return true= correct or false = not correct
     */
	private boolean isDirectionString(String text){
	    if(text != null && text.length() > 1)
	    	return false;
	        
	    if(text.equals("N")|| text.equals("E")||text.equals("W")|| text.equals("S"))
            return true;
	  
	    return false;
	}
	
	/**
     * this method let you reset the current position coordinates and current direction.
     *
     * @param void
     * @return void
     */
	public void resetCurrentCoordinates()
	{
		m_currentPosX = m_initPosX ;
		m_currentPosY = m_initPosY;
		m_currentDir  = m_initDir;
	}
	
	/**
     * this method let you read m_roomSizeX member variable.
     *
     * @param void
     * @return void
     */
    public int getRoomSizeX()
    {
        return m_roomSizeX;
    }
	
    /**
     * this method let you read m_roomSizeY member variable.
     *
     * @param void
     * @return void
     */
    public int getRoomSizeY()
    {
        return m_roomSizeY;
    }
    
	/**
     * this method let you read m_currentDir member variable.
     *
     * @param void
     * @return void
     */
    public char getCurrentDir()
    {
        return m_currentDir;
    }
    
	/**
     * this  method let you verify if each text line has the correct information or not.
     *
     * @param void
     * @return true= correct or false = not correct
     */
	public boolean verifyCoordFromFile(){
		
		boolean flag = true;
		
		if ( m_roomSize == null){
			System.out.println(" Problem with Room size value!!!");
			flag = false;
		}
			
		if (m_initPos == null){
			System.out.println(" Problem with Init Coordinate!!!");
			flag = false;
		}
		
		if(m_initDir == '\0'){
			System.out.println(" Problem with Init Direction!!!");
			flag = false;
		}
		
		
		if(flag){
			// txt file
			m_roomSizeX = m_roomSize[0];
			m_roomSizeY = m_roomSize[1];
			m_initPosX  = m_initPos[0];
			m_initPosY  = m_initPos[1];
			// current
			m_currentPosX = m_initPosX ;
			m_currentPosY = m_initPosY;
			m_currentDir  = m_initDir;
			// info
			System.out.println(" Coordinates are correct!!!");
		}
		
		return flag;
							
	}

}
