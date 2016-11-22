package testForJsp.action;

public class Note {
	public int noteID;
	public String filename;
	public String content;
	public Note(int noteID,String content){
		this.noteID = noteID;
		this.filename = noteID + ".txt";
		this.content = content;
	}
}
