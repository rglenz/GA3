import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Calculator extends Application{
	//Global variables to make calculator work
	Double temp1=0.0, temp2=0.0,sum=0.0;
	String operator="";
	boolean pressed=false;
	
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		//create grid
		GridPane grid = new GridPane();
		//create screen
		
		TextField screen = new TextField();
		screen.setDisable(true);
		//create buttons
		Button button0 = new Button("0");
		Button button1 = new Button("1");
		Button button2 = new Button("2");
		Button button3 = new Button("3");
		Button button4 = new Button("4");
		Button button5 = new Button("5");
		Button button6 = new Button("6");
		Button button7 = new Button("7");
		Button button8 = new Button("8");
		Button button9 = new Button("9");		
		Button buttonAdd = new Button("+");
		Button buttonMinus = new Button("-");
		Button buttonDivide = new Button("/");
		Button buttonMultiply = new Button("*");
		Button buttonEqual = new Button("=");
		Button buttonClear = new Button("CE");
		Button buttonDec = new Button(".");

		
		//add buttons to grid
		grid.add(screen, 0, 0,4,1);
		grid.add(button7, 0, 1,1,1);
		grid.add(button8, 1, 1,1,1);
		grid.add(button9, 2, 1,1,1);
		grid.add(buttonDivide, 3, 1,1,1);
		grid.add(button4, 0, 2,1,1);
		grid.add(button5, 1, 2,1,1);
		grid.add(button6, 2, 2,1,1);
		grid.add(buttonMultiply, 3, 2,1,1);
		grid.add(button1, 0, 3,1,1);
		grid.add(button2, 1, 3,1,1);
		grid.add(button3, 2, 3,1,1);
		grid.add(buttonMinus, 3, 3,1,1);
		grid.add(buttonClear, 0, 4,1,1);
		grid.add(button0, 1, 4,1,1);
		grid.add(buttonEqual, 2, 4,1,1);
		grid.add(buttonAdd, 3, 4,1,1);
		grid.add(buttonDec, 0, 5,1,1);
		

		//align the left column correctly 
		grid.setHgap(10);
		grid.setVgap(10);
		GridPane.setHalignment(button7, HPos.CENTER); 
		GridPane.setValignment(button7, VPos.CENTER);
		GridPane.setHalignment(button4, HPos.CENTER); 
		GridPane.setValignment(button4, VPos.CENTER);
		GridPane.setHalignment(button1, HPos.CENTER); 
		GridPane.setValignment(button1, VPos.CENTER);
		GridPane.setHalignment(buttonDec, HPos.CENTER); 
		GridPane.setValignment(buttonDec, VPos.CENTER);
		//Button functionality 
		button0.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(0,screen);
			}
		});
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(1,screen);
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(2,screen);
			}
		});
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(3,screen);
			}
		});
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(4,screen);
			}
		});
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(5,screen);
			}
		});
		button6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(6,screen);
			}
		});
		button7.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(7,screen);
			}
		});
		button8.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(8,screen);
			}
		});
		button9.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				numberClick(9,screen);
			}
		});
		buttonDec.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				screen.setText(screen.getText()+".");
			}
		});
		buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				operatorClick("+",screen);
			}
		});
		buttonMinus.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				operatorClick("-",screen);
			}
		});
		buttonDivide.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				operatorClick("/",screen);
			}
		});
		buttonMultiply.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				operatorClick("*",screen);
			}
		});
		buttonClear.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				screen.setText("");
				operator="";
				pressed =false;
				temp1=0.0;
				temp2=0.0;
			}
		});
		buttonEqual.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				switch(operator) {
					case "+":
						sum=temp1+temp2;
						break;
					case "-":
						sum=temp1-temp2;
						break;
					case "*":
						sum=temp1*temp2;
						break;
					case "/":
						sum=temp1/temp2;
						break;		
				}
				temp1=sum;
				screen.setText(String.valueOf(sum));
			}
		});
		//set the scene 
		Scene scene = new Scene(grid, 145, 215);
		stage.setScene(scene);
		stage.show();
	}
	
	//handles when a number button is clicked 
	private void numberClick(int i,TextField screen) {
		if(!pressed) {
			screen.setText(screen.getText()+String.valueOf(i));
			temp1=Double.parseDouble(screen.getText());
			System.out.println(temp1);
		}
		else {
			screen.setText(screen.getText()+String.valueOf(i));
			temp2=Double.parseDouble(screen.getText());
			System.out.println(temp2);
		}
	}
	
	//handles when an operator button is clicked 
	private void operatorClick(String o,TextField screen) {
		pressed=true;
		screen.setText("");
		operator=o;
	}
	
	public static void main(String []args)  {
		launch(args);
	}


}