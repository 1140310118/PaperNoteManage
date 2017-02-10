package base.model;

public class Note {
	public String noteID;
	public String filename;
	public String content;
	public String getNoteID() {
		return noteID;
	}
	public void setNoteID(String noteID) {
		this.noteID = noteID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Note(String noteID,String content){
		this.noteID = noteID;
		this.filename = noteID + ".txt";
		this.content = content;
	}
	public Note(int i, String fileString) {
		// TODO Auto-generated constructor stub
	}
}
