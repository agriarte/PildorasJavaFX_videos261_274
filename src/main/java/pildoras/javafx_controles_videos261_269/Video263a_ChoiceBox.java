package pildoras.javafx_controles_videos261_269;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX Video263a_ChoiceBox
 */
public class Video263a_ChoiceBox extends Application {

    private ChoiceBox<Jugadores> equipoEstrellas;

    @Override
    public void start(Stage stage) {

        //crear choicebox
        equipoEstrellas = new ChoiceBox<Jugadores>();
        //añadir items
        //equipoEstrellas.getItems().add(new Jugadores("Michael", "Jordan"));
        //equipoEstrellas.getItems().add(new Jugadores("Larry", "Bird"));
        //equipoEstrellas.getItems().add(new Jugadores("Magic", "Johnson"));
        Jugadores Jordan = new Jugadores("Michael", "Jordan");
        Jugadores Bird = new Jugadores("Larry", "Bird");
        Jugadores Johnson = new Jugadores("Magic", "Johnson");
        //añadir al ChoiceBox 3 instancias de Jugadores
        equipoEstrellas.getItems().addAll(Jordan, Bird, Johnson);
        //seleccionar valor por defecto del ChoiceBox
        equipoEstrellas.setValue(Jordan);
        //no parece hacer nada, funciona igual comentándolo
        //equipoEstrellas.show();

        Button miBoton = new Button("haz click");
        miBoton.setPrefWidth(120);
        miBoton.setOnAction(e->funcionJuegos());
        
        //crear el pane, BorderPane(Node center, Node top, Node right, Node bottom, Node left)
        BorderPane miBorderPane = new BorderPane(null, equipoEstrellas, null, miBoton,null );

        Scene scene = new Scene(miBorderPane, 640, 480);
        //alinear elemento del pane
        miBorderPane.setAlignment(miBoton, Pos.CENTER);
        miBorderPane.setAlignment(equipoEstrellas, Pos.CENTER);
        //evento de click al choicebox
        equipoEstrellas.setOnAction(e->accionBoton());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void accionBoton() {
        String mensaje = "Has escogido a " + equipoEstrellas.getValue();
        emergente.VentanaEmergente.mostrar(mensaje, "probando choicebox");
    }

    private void funcionJuegos() {
        System.out.println(";equipoEstrellas.getItems().size():" + equipoEstrellas.getItems().size());
        
        Jugadores pedro = new Jugadores("Pedro", "Agri");
        equipoEstrellas.getItems().add(pedro);
        //equipoEstrellas.getItems().remove(1);// borrar por índice
        equipoEstrellas.getItems().clear();//borra todos los elementos pero también da por pulsado un elemento (comportamiento no deseado)
    }

}

class Jugadores {

    private String Nombre, Apellidos;

    public Jugadores(String Nombre, String Jugadores) {
        super();
        this.Nombre = Nombre;
        this.Apellidos = Jugadores;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre + ", Apellido: " + Apellidos;
    }

}
