package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.*;
import java.util.*;

public class Main extends Application {
    TextField textField = new TextField();
    TextField textField1 = new TextField();
    String string;
    String string1;
    ListView<String> listView = new ListView<>();
    ListView<String> listView1 = new ListView<>();
    File chatFile;
    String studentListPath;
    static ObservableList<String> input = FXCollections.observableArrayList();
    static ObservableList<String> studentListOutput = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Button chooseFile = new Button("Choose chat file:");
        ComboBox<String> comboBox = new ComboBox();
        input.add(0, "10L");
        input.add(1, "35L");
        input.add(2, "36L");
        input.add(3, "37L");
        input.add(4, "38L");
        comboBox.setMaxWidth(150);
        comboBox.setItems(input);
        comboBox.setPromptText("Choose the section: ");
        textField.setEditable(false);
        comboBox.setOnAction(event -> {
            string = chatFile.getName().substring(4, 7);
            if(!comboBox.getValue().equals(string)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR!!!!");
                alert.setContentText("CHOOSE APPROPRIATE SECTION!!!!!!");
                alert.showAndWait();
            }else {
                if (comboBox.getValue().equals("10L")) {
                    studentListPath = "C:\\Users\\bekza\\Downloads\\10L.txt";
                    textField.setText(studentListPath);
                    listView.getItems().clear();
                    HashMap<String, Students> students = new HashMap<>();
                    Map<Integer, String> map = new LinkedHashMap<>();
                    Scanner scan = null;
                    try {
                        scan = new Scanner(new File(studentListPath));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (scan.hasNext()) {
                        String[] studentList = scan.nextLine().split(",");
                        for (int i = 1; i < studentList.length; i++) {
                            map.put(i, studentList[i]);
                            studentListOutput.addAll(map.values());
                        }
                        listView.setItems(studentListOutput);
                    }
                } else if (comboBox.getValue().equals("35L")) {
                    studentListPath = "C:\\Users\\bekza\\Downloads\\35L.txt";
                    textField.setText(studentListPath);
                    listView.getItems().clear();
                    HashMap<String, Students> students = new HashMap<>();
                    Map<Integer, String> map = new LinkedHashMap<>();
                    Scanner scan = null;
                    try {
                        scan = new Scanner(new File(studentListPath));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (scan.hasNext()) {
                        String[] studentList = scan.nextLine().split(",");
                        for (int i = 1; i < studentList.length; i++) {
                            map.put(i, studentList[i]);
                            studentListOutput.addAll(map.values());
                        }
                        listView.setItems(studentListOutput);
                    }
                } else if (comboBox.getValue().equals("36L")) {
                    studentListPath = "C:\\Users\\bekza\\Downloads\\36L.txt";
                    textField.setText(studentListPath);
                    listView.getItems().clear();
                    HashMap<String, Students> students = new HashMap<>();
                    Map<Integer, String> map = new LinkedHashMap<>();
                    Scanner scan = null;
                    try {
                        scan = new Scanner(new File(studentListPath));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (scan.hasNext()) {
                        String[] studentList = scan.nextLine().split(",");
                        for (int i = 1; i < studentList.length; i++) {
                            map.put(i, studentList[i]);
                            studentListOutput.addAll(map.values());
                        }
                        listView.setItems(studentListOutput);
                    }
                } else if (comboBox.getValue().equals("37L")) {
                    studentListPath = "C:\\Users\\bekza\\Downloads\\37L.txt";
                    textField.setText(studentListPath);
                    listView.getItems().clear();
                    HashMap<String, Students> students = new HashMap<>();
                    Map<Integer, String> map = new LinkedHashMap<>();
                    Scanner scan = null;
                    try {
                        scan = new Scanner(new File(studentListPath));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (scan.hasNext()) {
                        String[] studentList = scan.nextLine().split(",");
                        for (int i = 1; i < studentList.length; i++) {
                            map.put(i, studentList[i]);
                            studentListOutput.addAll(map.values());
                        }
                        listView.setItems(studentListOutput);
                    }
                } else if (comboBox.getValue().equals("38L")) {
                    studentListPath = "C:\\Users\\bekza\\Downloads\\38L.txt";
                    textField.setText(studentListPath);
                    listView.getItems().clear();
                    HashMap<String, Students> students = new HashMap<>();
                    Map<Integer, String> map = new LinkedHashMap<>();
                    Scanner scan = null;
                    try {
                        scan = new Scanner(new File(studentListPath));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (scan.hasNext()) {
                        String[] studentList = scan.nextLine().split(",");
                        for (int i = 1; i < studentList.length; i++) {
                            map.put(i, studentList[i]);
                            studentListOutput.addAll(map.values());
                        }
                        listView.setItems(studentListOutput);
                    }
                }
            }
        });
        chooseFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files", "*.*"));
            chatFile = fileChooser.showOpenDialog(primaryStage);
            textField1.setText(chatFile.getPath());
        });
        Button check = new Button("Check");
        check.setLayoutY(0);
        check.setLayoutX(150);
        check.setOnAction(event ->{
            HashMap<String, Students> students = new HashMap<>();
            try {
                Scanner scan = new Scanner(new File(studentListPath));
                while (scan.hasNext()){
                    String studentsData = scan.nextLine().replace(",", " ");
                    String[] data = studentsData.split(" ");
                    Students students1 = new Students(data[0], data[1], data[2], false);
                    students.put(data[0], students1);
                }
                scan.close();
                scan = new Scanner(chatFile);
                while (scan.hasNext()){
                    String id = scan.next();
                    Students students1 = students.get(id);
                    if(students1 != null){
                        students1.setAttended(true);
                        students.put(id, students1);
                    }
                }
                scan.close();
                listView1.getItems().clear();
                for(Students students1: students.values()){
                    if(!students1.isAttended()){
                        listView1.getItems().add(students1.toString());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        check.setLayoutX(300);
        HBox top = new HBox(5);
        top.getChildren().addAll(chooseFile,textField1, comboBox, textField, check);
        top.setPrefSize(700, 20);
        top.setStyle("-fx-background-color:rgb(34, 186, 193)");
        Label attStudents = new Label("Students list: ");
        attStudents.setFont(Font.font("Britannic Bold", 20));
        attStudents.setTextFill(Color.YELLOW);
        Label notAttStudents = new Label("Not attended students list: ");
        notAttStudents.setFont(Font.font("Britannic Bold", 20));
        notAttStudents.setTextFill(Color.YELLOW);
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: rgb(137, 149, 243)");
        gridPane.setHgap(100);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30));
        gridPane.setMaxSize(700, 600);
        gridPane.add(notAttStudents, 0, 0);
        gridPane.add(listView1, 0, 1);
        gridPane.add(attStudents, 1, 0);
        gridPane.add(listView, 1, 1);
        BorderPane position = new BorderPane();
        position.setTop(top);
        position.setLeft(gridPane);
        primaryStage.setScene(new Scene(position, 650, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class Students{
    private String id;
    private String name;
    private String surname;
    private boolean isAttended;


    public Students(String id, String name, String surname, boolean isAttended) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isAttended = isAttended;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isAttended() {
        return isAttended;
    }

    public void setAttended(boolean attended) {
        isAttended = attended;
    }

    @Override
    public String toString() {
        return name+" "+ surname;
    }
}


