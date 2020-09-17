package application;



import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.TOP_LEFT);
			root.setHgap(10);
			root.setVgap(10);

			// Tworzenie komponentów
			Label label1 = new Label("Źródło:");
			Label label2 = new Label("Wynik operacji:");
			Label label3 = new Label("Operacja:");
			TextField zrodlo = new TextField();
			TextField wynik = new TextField();
			Button kopiuj = new Button("Kopiuj");
			Button wykonaj = new Button("Wykonaj");
			RadioButton kodowanie = new RadioButton("kodowanie");
			RadioButton dekodowanie = new RadioButton("dekodowanie");
			ToggleGroup tgroup = new ToggleGroup();
			kodowanie.setToggleGroup(tgroup);
			dekodowanie.setToggleGroup(tgroup);

			// Dodanie elementów do sceny
			root.add(label1, 4, 4);
			root.add(zrodlo, 4, 5);
			root.add(kopiuj, 4, 6);
			root.setHalignment(kopiuj, HPos.RIGHT); //zmiana pozycji przycisku "kopiuj"
			root.add(label2, 4, 7);
			root.add(wynik, 4, 8);
			root.add(wykonaj, 4, 11);
			root.add(label3, 10, 4);
			root.add(kodowanie, 10, 5);
			root.add(dekodowanie, 10, 6);

			// zmiana wyglądu komponentów
			zrodlo.getStyleClass().add("my-field");
			wynik.getStyleClass().add("my-field");
			wykonaj.getStyleClass().add("my-button");
			label1.getStyleClass().add("my-label");
			label2.getStyleClass().add("my-label");
			label3.getStyleClass().add("my-label");
			kodowanie.getStyleClass().add("my-label");
			dekodowanie.getStyleClass().add("my-label");
			root.getStyleClass().add("my-root");

			// Akcja dla przycisku "Wykonaj"
			wykonaj.setOnAction(event -> {

				if (kodowanie.isSelected() && (!zrodlo.getText().equals(""))) {
					wynik.setText(Algorytm.encode(zrodlo.getText()));
				}

				if (dekodowanie.isSelected() && (!zrodlo.getText().equals(""))) {
					wynik.setText(Algorytm.decode(zrodlo.getText()));
				}
			});

			// Akcja dla przycisku "Kopiuj"
			kopiuj.setOnAction(event -> {
				zrodlo.setText(wynik.getText());
				wynik.setText("");
			});
			
			//Tworzenie nowej scany
			Scene scene = new Scene(root, 400, 320);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Run Length Encoding");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
