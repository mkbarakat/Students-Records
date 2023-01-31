package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.FileChooser;


public class Main extends Application {
	Join<Student> theList = new Join<>();
	boolean canBeUpdated = false;
	DLLNode<Student> current;
	@Override
	public void start(Stage primaryStage) {
		FileChooser fileChooser = new FileChooser();
		TextField mainFolderTextField = new TextField();
		mainFolderTextField.setEditable(false);
		Button loadFileButton = new Button("Open File");
		TextArea MainTextArea = new TextArea();
		MainTextArea.setMinWidth(900);
		;

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(20);
		pane.add(new Label("Select File"), 0, 0);
		pane.add(mainFolderTextField, 1, 0);
		pane.add(loadFileButton, 2, 0);


		// Insert
		GridPane pane3 = new GridPane();
		pane3.setAlignment(Pos.CENTER);
		pane3.setHgap(10);
		pane3.setVgap(20);
		pane3.setStyle(" -fx-padding:10;-fx-border: 1px solid; -fx-border-color: black;");
		TextField insertseatTextField = new TextField();
		TextField insertbranchTextField = new TextField();
		insertbranchTextField.setEditable(false);
		TextField insertmarkTextField = new TextField();
		TextField insertstatusTextField = new TextField();

		pane3.add(new Label("Seat number"), 0, 0);
		pane3.add(new Label("Branch"), 1, 0);
		pane3.add(new Label("Mark"), 2, 0);
		pane3.add(new Label("Status"), 3, 0);
		pane3.add(insertseatTextField, 0, 1);
		pane3.add(insertbranchTextField, 1, 1);
		pane3.add(insertmarkTextField, 2, 1);
		pane3.add(insertstatusTextField, 3, 1);
		pane.add(new Label("Insert new record"), 0, 2);
		pane.add(pane3, 1, 2);
		Button InsertButton = new Button("Insert");
		pane3.add(InsertButton, 4, 1);

		///////////// select branch area
		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.CENTER);
		pane2.setHgap(10);
		pane2.setVgap(20);
		Button ScBranchButton = new Button("Scintefic");
		Button LitBranchButton = new Button("Literary ");
		ScBranchButton.setMinWidth(400);
		LitBranchButton.setMinWidth(400);
		pane2.add(ScBranchButton, 0, 0);
		pane2.add(LitBranchButton, 2, 0);
		pane.add(new Label("Select branch"), 0, 1);
		pane.add(pane2, 1, 1);
		// Update
		GridPane pane4 = new GridPane();
		pane4.setAlignment(Pos.CENTER);
		pane4.setHgap(10);
		pane4.setVgap(20);
		pane4.setStyle(" -fx-padding:10;-fx-border: 1px solid; -fx-border-color: black;");
		TextField selectseatTextField = new TextField();
		TextField selectbranchTextField = new TextField();
		selectbranchTextField.setEditable(false);
		TextField selectmarkTextField = new TextField();
		TextField selectstatusTextField = new TextField();
		Button deleteButton = new Button("Delete");

		pane4.add(new Label("Select Seat number to update"), 0, 0);
		pane4.add(selectseatTextField, 1, 0);
		pane4.add(new Label("Branch"), 1, 1);
		pane4.add(new Label("Mark"), 2, 1);
		pane4.add(new Label("Status"), 3, 1);
		pane4.add(selectbranchTextField, 1, 2);
		pane4.add(selectmarkTextField, 2, 2);
		pane4.add(selectstatusTextField, 3, 2);
		pane.add(new Label("Update"), 0, 3);
		pane.add(pane4, 1, 3);
		Button updateButton = new Button("Update");
		Button selectButton = new Button("select");
		pane4.add(updateButton, 3, 0);
		pane4.add(deleteButton, 4, 0);
		pane4.add(selectButton, 2, 0);
		
		// find
		GridPane pane5 = new GridPane();
		pane5.setAlignment(Pos.CENTER);
		pane5.setHgap(10);
		pane5.setVgap(20);
		pane5.setStyle(" -fx-padding:10;-fx-border: 1px solid; -fx-border-color: black;");
		TextField findseatTextField = new TextField();
		TextField resultTextField = new TextField();
		resultTextField.setEditable(false);
		resultTextField.setMinWidth(600);
		Button searchButton = new Button("Search");
		Button nextButton = new Button("Next");
		Button prevButton = new Button("Prev");
	
	
		pane5.add(new Label("Seat number"), 0, 0);
		pane5.add(findseatTextField, 1, 0);
		pane5.add(searchButton, 2, 0);
		pane5.add(prevButton, 0, 1);
		pane5.add(resultTextField, 1, 1);
		pane5.add(nextButton, 2, 1);
		pane.add(new Label("Find"), 0, 4);
		pane.add(pane5, 1, 4);
		//pane5.add(searchButton, 4, 1);
		
		MainTextArea.setMinHeight(400);
		MainTextArea.setMinWidth(1200);
		pane.add(new Label("List"), 0, 5);
		pane.add(MainTextArea, 1, 5);
		Button showButton = new Button("Show");
		pane.add(showButton, 2, 5);
		
		TextField heightTextField = new TextField();
		pane.add(new Label("Tree Heights"), 0, 6);
		pane.add(heightTextField, 1, 6);

		loadFileButton.setOnAction(e -> {
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			mainFolderTextField.setText(selectedFile.toString());
		});

		ScBranchButton.setOnAction(e -> {
			try {
				insertbranchTextField.setText("Scientific");
				theList = readFile(mainFolderTextField.getText(), 1);
				theList.doublyList.traverse();
				theList.doublyList.traverseBack();
				MainTextArea.setText(theList.show());
				heightTextField.setText(theList.getHeight());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		LitBranchButton.setOnAction(e -> {
			try {
				insertbranchTextField.setText("Literary ");
				theList = readFile(mainFolderTextField.getText(), 2);
				theList.doublyList.traverse();
				theList.doublyList.traverseBack();
				MainTextArea.setText(theList.show());
				heightTextField.setText(theList.getHeight());

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		InsertButton.setOnAction(e -> {
			double mark = Double.parseDouble(insertmarkTextField.getText());
			int seatNumber = Integer.parseInt(insertseatTextField.getText());
			String branch = insertbranchTextField.getText();

			if (theList.isExist(Integer.parseInt(insertseatTextField.getText()))) {
				insertstatusTextField.setText("Seat Number Dublication!");
				theList.doublyList.traverse();
			} else {
				if (mark >= 0 && mark <= 100) {
					theList.insert(new Student(seatNumber, branch, mark));
					insertstatusTextField.setText("Successfully added");
					theList.doublyList.traverse();
					MainTextArea.setText(theList.show());
					heightTextField.setText(theList.getHeight());
				} else {
					insertstatusTextField.setText("Mark from 0 to 100");
				}
			}
		});

		updateButton.setOnAction(e -> {
			if (canBeUpdated) {
				double mark = Double.parseDouble(selectmarkTextField.getText());
				int seatNumber = Integer.parseInt(selectseatTextField.getText());
				String branch = selectbranchTextField.getText();

				if (theList.isExist(Integer.parseInt(selectseatTextField.getText()))) {
					if (mark >= 0 && mark <= 100) {
						if (!branch.equals("")) {
							System.out.println("DOBLY LIST before");
							theList.doublyList.traverse();
							System.out.println("MARK TREE before");
							theList.LLAVL.traverseInOrder();
							theList.update2(seatNumber,branch,mark);
							selectstatusTextField.setText("Successfully updated");
							System.out.println("DOBLY LIST after");
							theList.doublyList.traverse();
							System.out.println("MARK TREE AFTER");
							theList.LLAVL.traverseInOrder();
							MainTextArea.setText(theList.show());
							heightTextField.setText(theList.getHeight());
						}
					}
					theList.doublyList.traverse();
				} else {
					selectstatusTextField.setText("Mark from 0 to 100");
				}
			}
		});
		
		selectButton.setOnAction(e -> {
			selectmarkTextField.setText("");
			selectbranchTextField.setText("");
			int seatNumber = Integer.parseInt(selectseatTextField.getText());
			if (theList.isExist(Integer.parseInt(selectseatTextField.getText()))) {
				selectstatusTextField.setText("you can update");
				canBeUpdated = true;
				Student st = theList.findBySeatNumber(seatNumber).data;
				selectmarkTextField.setText("" + st.mark);
				selectbranchTextField.setText(st.branch);
			} else {
				selectstatusTextField.setText("Not Exist");
			}
		});
		
		searchButton.setOnAction(e ->{
			int seatNumber = Integer.parseInt(findseatTextField.getText());
			if (theList.isExist(Integer.parseInt(findseatTextField.getText()))) {
				current=theList.findBySeatNumber(seatNumber);
				resultTextField.setText(current.toString());
			}else {
				resultTextField.setText("Not exist");
			}
			
		});
		nextButton.setOnAction(e ->{
			if(current!=null) {
				current=current.next;
				resultTextField.setText(current.toString());
				findseatTextField.setText(""+current.data.id);
			}
		});
		prevButton.setOnAction(e ->{
			if(current!=null) {
				current=current.prev;
				resultTextField.setText(current.toString());
				findseatTextField.setText(""+current.data.id);
			}
		});
		
		deleteButton.setOnAction(e ->{
			int seatNumber = Integer.parseInt(selectseatTextField.getText());
			if (theList.isExist(Integer.parseInt(selectseatTextField.getText()))) {
				theList.deletefromAll(seatNumber);
				selectstatusTextField.setText("Successfully deleted");
				MainTextArea.setText(theList.show());
				heightTextField.setText(theList.getHeight());
			}else {
				selectstatusTextField.setText("Not exist");
			}
		});
		
		showButton.setOnAction(e ->{
			
			MainTextArea.setText(theList.show());
			
			
		});
		
		Scene scene = new Scene(pane, 1920, 1080);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static Join<Student> readFile(String link, int n) throws FileNotFoundException {
		Join<Student> j = new Join<Student>();
		File file = new File(link);
		System.out.println(file.exists());
		Scanner fileScanner = new Scanner(file);
		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine().trim();
			if (n == 1) {
				String arr[] = line.split(",");
				if (arr[1].trim().equalsIgnoreCase("Scientific")) {
					Student s = new Student(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]));
					j.insert(s);
				}
			} else {
				String arr[] = line.split(",");
				if (!arr[1].trim().equalsIgnoreCase("Scientific")) {
					Student s = new Student(Integer.parseInt(arr[0]), arr[1].trim(), Double.parseDouble(arr[2]));
					j.insert(s);
				}
			}
		}
		fileScanner.close();
		return j;
	}

}
