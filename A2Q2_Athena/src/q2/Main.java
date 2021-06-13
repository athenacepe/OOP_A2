/**
 * Name: Athena Cepe
 * Student ID: 18470716
 * Pledge of honour: I pledge by honour that this program is solely my own work.
 */

package q2;
import static java.lang.System.out;

public class Main {

public static void main(String[] args) {
	Note[] noteArray = new Note[5];
	noteArray[0] = new Note("D", 19);
	noteArray[1] = new Note("C", 20);
	noteArray[2] = new Note("F", 31);
	noteArray[3] = new Note("B", 45);
	noteArray[4] = new Note("C", 73);
	
	processNotes(noteArray);
}

public static void processNotes(Note[] notes){
	int sum = 0;
		for (int i = 0; i < notes.length;i++) {
			notes[i].playNote(); //calls the playNote() and displays the objects in the list
			sum += notes[i].getDuration(); //calculates the total duration from all the objects in the list
			}
		out.printf("Total duration of notes: %s seconds", sum);
}
}