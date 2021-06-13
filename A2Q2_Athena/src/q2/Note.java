package q2;
import static java.lang.System.*;
public class Note {
	private String pitch;
	private int duration;
	
	public Note(String pitch, int duration) {
		this.setPitch(pitch);
		this.setDuration(duration);
	}
	
	public void playNote() {
		out.printf("The note %s is played for %d seconds.\n", pitch, duration);
	}
	
//GETTER AND SETTER FOR PITCH AND DURATION	
	public String getPitch() {
		return pitch;
	}
	public void setPitch(String pitch) {
		this.pitch = pitch;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}

