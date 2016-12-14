package coldashes.data;

public class WordInfo {
	
	//private variables
	int _id;
	String _text;
	String _definition;
	
	// Empty constructor
	public WordInfo(){
		
	}
	// constructor
	public WordInfo(int id, String text, String definition){
		this._id = id;
		this._text = text;
		this._definition = definition;
	}
	
	// constructor
	public WordInfo(String name, String definition){
		this._text = name;
		this._definition = definition;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getText(){
		return this._text;
	}
	
	// setting name
	public void setName(String name){
		this._text = name;
	}
	
	// getting phone number
	public String getDefinition(){
		return this._definition;
	}
	
	// setting phone number
	public void setDefinition(String definition){
		this._definition = definition;
	}
}
