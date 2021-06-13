/**
 * Name: Athena Cepe
 * Student ID: 18470716
 * Pledge of honour: I pledge by honour that this program is solely my own work.
 */

package application;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;


public class Main extends Application { 
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane(); // Root StackPane

			//Create double variables for the width and height of the scene
			double width = 500, height = 500;
			//Create int variable for the radius of the red circle and the moving speed of the red circle
			int radius = 10, speed = 5;

			Pane gamePane = new Pane();
			root.getChildren().add(gamePane);


			//Creates the timer box
			VBox timerBox = new VBox();
			timerBox.setAlignment(Pos.TOP_CENTER);
			root.getChildren().add(timerBox);

			//Create the targets left box
			VBox targetBox = new VBox();
			targetBox.setAlignment(Pos.BOTTOM_CENTER);
			root.getChildren().add(targetBox);

			//Creates the label to display the time for the timer box
			Label label1 = new Label("0");
			label1.setFont(Font.font(20));
			label1.setTextFill(Color.BLUE);
			timerBox.getChildren().add(label1);

			//Label for the number of targets
			Label label2 = new Label();
			label2.setFont(Font.font(20));
			label2.setTextFill(Color.GREEN);
			targetBox.getChildren().add(label2);

			//Creates the Red Circle
			Circle movingc = new Circle(height/2, width/2, radius); // is made in the center of the interface
			movingc.setFill(Color.RED);
			gamePane.getChildren().add(movingc);

			//Creates the random black dots and is spawned at different places
			int numTarget = ThreadLocalRandom.current().nextInt(5,10);                                                      

			for(int i = 0; i < numTarget; i++) {
				double randomx = ThreadLocalRandom.current().nextDouble(40, width);
				double randomy = ThreadLocalRandom.current().nextDouble(40, width);
				Circle dot = new Circle(randomx, randomy, 5);
				gamePane.getChildren().add(dot); 
			}

			//Label to indicate the number targets left
			label2.setText("Targets Left: " + numTarget);
			gamePane.setFocusTraversable(true);


			//Scene/Window
			Scene scene = new Scene(root,width,height);
			//Display the panel or scene
			primaryStage.setScene(scene);
			primaryStage.show();

			// bring the gamePane to focus
			gamePane.requestFocus();

			//Animation Timers
			AnimationTimer timer = new AnimationTimer() {
				private long startTime = System.currentTimeMillis();
				@Override public void handle(long stamp) {
					long present = System.currentTimeMillis();
					double elapseTime = (present - startTime)/1000;
					label1.setText("Elapsed Time: " + (int)elapseTime + " seconds");

				}
			};
			timer.start(); 

			//Input from the user's keyboard
			gamePane.setOnKeyPressed(e -> {
				double x = movingc.getCenterX();
				double y = movingc.getCenterY();

				switch(e.getCode()) {
				case UP:
					if (y > radius) //if it hasnt reached the top edge
						movingc.setCenterY(y - speed); // set circle to new location
					break;
				case LEFT:
					if(x > radius)
						movingc.setCenterX(x - speed);
					break;
				case DOWN:
					if(y <height - radius)
						movingc.setCenterY(y + speed);
					break;
				case RIGHT:
					if(x <width - radius)
						movingc.setCenterX(x + speed);
					break;
				default: //nothing to do
					break; 
				}
				
				//collect all overlapping black dots
				List<Node> overlaps = new LinkedList<>();
				ObservableList<Node> allCircles = gamePane.getChildren();

				for(Node n : allCircles) {
					Circle c = (Circle) n;
					if(isOverlap(movingc, c)) {
						overlaps.add(c);
					}
				}

				for(Node n : overlaps) {
					allCircles.remove(n);
					label2.setText("Targets Left: " + ((int)allCircles.size() - 1));
				} 		
				
				if(allCircles.size() == 1) {
					//only the red circle is left on the panel 
					//the red circle will change colour and the timer will stop
					movingc.setFill(Color.BLUE); 
					timer.stop();
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isOverlap(Circle c1, Circle c2) {
		//Get the center point of the circles 
		double x1 = c1.getCenterX();
		double y1 = c1.getCenterY();
		double x2 = c2.getCenterX();
		double y2 = c2.getCenterY();
		//Calculate the distance
		double comp1 = Math.pow(Math.abs(x2-x1), 2);
		double comp2 = Math.pow(Math.abs(y2-y1), 2);
		double distance = Math.sqrt(comp1 + comp2);
		double r1 = c1.getRadius();
		double r2 = c2.getRadius();
		boolean cond1 = distance <= r1 + r2;
		boolean cond2 = distance > 0;
		boolean overlap = cond1 && cond2;
		return overlap;

	}

	public static void main(String[] args) {
		launch(args);
	}
}
