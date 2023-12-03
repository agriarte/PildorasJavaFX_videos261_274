/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pildoras.javafx_controles_videos_tableview_videos_269_274;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author Pedro
 */
public class Videos_269_274_TableView extends Application {

    TextField txtTitulo, txtAño, txtPrecio;
    TableView<PeliculasDeTabla> tablaPeliculas;

    @Override
    public void start(Stage primaryStage) {

        Label lblCabecera = new Label("Lista de películas");
        lblCabecera.setFont(new Font("Arial", 20));
        tablaPeliculas = new TableView<>();

        //permitir selección multiple
        tablaPeliculas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Columna del título
        //instancia de columna con 2 datos genéricos:  < la clase PeliculasDeTabla, el tipo String>. 
        TableColumn<PeliculasDeTabla, String> colTitulo = new TableColumn<>("Título");
        //ancho mínimo
        colTitulo.setMinWidth(290);
        //Aquí se configura cómo se obtendrán los valores para las celdas de esta columna. La llamada a 
        //setCellValueFactory toma como argumento un PropertyValueFactory, que se utiliza para asociar 
        //la propiedad de un objeto PeliculasDeTabla con la columna. 
        //PropertyValueFactory es una implementación de la interfaz Callback. Su implementación de call 
        //se encarga de obtener el valor de la propiedad especificada en el constructor ("titulo") del 
        //objeto pasado como argumento.
        colTitulo.setCellValueFactory(new PropertyValueFactory<PeliculasDeTabla, String>("titulo"));

        //Columna del año
        TableColumn<PeliculasDeTabla, Integer> colAño = new TableColumn<>("Año");
        colAño.setMinWidth(100);
        colAño.setCellValueFactory(new PropertyValueFactory<PeliculasDeTabla, Integer>("año"));

        //Columna del precio
        TableColumn<PeliculasDeTabla, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setMinWidth(100);
        colPrecio.setCellValueFactory(new PropertyValueFactory<PeliculasDeTabla, Double>("precio"));

        //------- Para hacer EDITABLES las columnas
        //permitir edición de la tabla
        tablaPeliculas.setEditable(true);
        //con esta línea la columna titulo ya es editable al hacer doble click
        //el cambio es solo de la vista, falta el listener para que actualice los datos en la fuente de la tabla
        //Normalmente será en una base de datos
        colTitulo.setCellFactory(TextFieldTableCell.forTableColumn());
        //Evento que se dispara al editar una columna
        colTitulo.setOnEditCommit(e -> modificaTitulo(e));

        //---- las otras 2 sería repetir el proceso
        //ATENCION: En el curso no se menciona que al ser el tipo de datos de la columna integer se ha de convertir
        colAño.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAño.setOnEditCommit(e -> modificaAño(e));

        // Configura la celda de fábrica para que sea editable y utilice un DoubleStringConverter
        colPrecio.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        // Configura el evento de edición
        colPrecio.setOnEditCommit(e -> modificaPrecio(e));

        //---- fin de la parte de edición de la columna título.
        //Agregando películas al TableView
        tablaPeliculas.getColumns().addAll(colTitulo, colAño, colPrecio);

        //para poblar la tabla se usa el retorno de un método que devuelve un ObservableList con PeliculasDeTabla
        tablaPeliculas.setItems(cargaDatos());

        //Construcción del pane inferior ( botones y textfield para agregar columnas
        txtTitulo = new TextField();
        txtTitulo.setPromptText("introduce título");
        txtTitulo.setMinWidth(100);

        txtAño = new TextField();
        txtAño.setPromptText("introduce año");
        txtAño.setMinWidth(100);

        txtPrecio = new TextField();
        txtPrecio.setPromptText("introduce precio");
        txtPrecio.setMinWidth(100);

        Button botonAgregar = new Button("Agregar");
        botonAgregar.setMinWidth(70);
        botonAgregar.setOnAction(e -> agregarPeliculas());

        Button botonEliminar = new Button("Eliminar");
        botonEliminar.setMinWidth(70);
        botonEliminar.setOnAction(e -> eliminarPeliculas());

        HBox panelAgregar = new HBox();
        panelAgregar.setSpacing(7);//espacio entre elementos del HBox
        panelAgregar.setPadding(new Insets(10, 0, 0, 0));
        panelAgregar.getChildren().addAll(txtTitulo, txtAño, txtPrecio, botonAgregar, botonEliminar);

        //Construcción del pane principal de la tabla
        VBox panePrincipal = new VBox();
        panePrincipal.setPadding(new Insets(10, 10, 10, 10));
        panePrincipal.getChildren().addAll(lblCabecera, tablaPeliculas, panelAgregar);

        Scene scene = new Scene(panePrincipal, 700, 400);

        primaryStage.setTitle("TableView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // método que agrega peliculas a la ObservableList
    public ObservableList<PeliculasDeTabla> cargaDatos() {
        ObservableList<PeliculasDeTabla> datos = FXCollections.observableArrayList();

        datos.add(new PeliculasDeTabla("Heat", 1995, 29.95));
        datos.add(new PeliculasDeTabla("BraveHeart", 1995, 19.95));
        datos.add(new PeliculasDeTabla("Gladiato", 2000, 29.95));
        datos.add(new PeliculasDeTabla("Bailando con lobos", 1990, 22));
        datos.add(new PeliculasDeTabla("Gran Torino", 2008, 25));
        datos.add(new PeliculasDeTabla("El padrino", 1972, 9.95));
        datos.add(new PeliculasDeTabla("Scarface", 1983, 19.95));
        datos.add(new PeliculasDeTabla("El último Samurai", 2003, 29.95));
        datos.add(new PeliculasDeTabla("7 años en el Tibet", 1997, 29.95));
        datos.add(new PeliculasDeTabla("Taxi Driver", 1976, 19.95));
        datos.add(new PeliculasDeTabla("Collateral", 2004, 19.95));

        return datos;
    }

    // método que agrega una película introducida por textfields
    public void agregarPeliculas() {
        //crear objeto de tipo Peliculas
        PeliculasDeTabla peliNueva = new PeliculasDeTabla();
        //establecer valores del objeto con el contenido de los textfields
        peliNueva.setTitulo(txtTitulo.getText());
        peliNueva.setAño(Integer.parseInt(txtAño.getText()));
        peliNueva.setPrecio(Double.parseDouble(txtPrecio.getText()));
        //añadir objeto peliNueva a la tabla
        tablaPeliculas.getItems().add(peliNueva);

        //borrar los textfields por si el usuario quiere añadir otra pelicula
        txtTitulo.clear();
        txtAño.clear();
        txtPrecio.clear();

    }

    // método para eliminar películas del curso
    // funciona eliminar de solo una selección, en selección multiple no funciona
    /*
    public void eliminarPeliculas(){
        //Guardar la películas que el usuario ha seleccionado
        ObservableList<PeliculasDeTabla> seleccionados = tablaPeliculas.getSelectionModel().getSelectedItems();
        //Guardar toda la lista de películas
        ObservableList<PeliculasDeTabla> peliculas = tablaPeliculas.getItems();
        
        //por bucle for each se recorre toda la lista de películas y se compara con las pelíulas seleccionados
        //realmente no funcioana para multiples selecciones, este error no lo comentan en el curso
        for (PeliculasDeTabla iterador : seleccionados){
            //eliminar de la lista de películas todos los elementos que están seleccionados que se encuentran en el Observable "seleccionados"
         peliculas.remove(iterador);
        }
    }
     */
    //Método que permite eliminar selección multiple de la tabla o solo 1
    //Esta solución es más elegante, evitando el bucle for each
    public void eliminarPeliculas() {
        // Obtener las películas que el usuario ha seleccionado
        ObservableList<PeliculasDeTabla> seleccionados = tablaPeliculas.getSelectionModel().getSelectedItems();

        // Obtener toda la lista de películas
        ObservableList<PeliculasDeTabla> peliculas = tablaPeliculas.getItems();

        // Crear una copia de la lista de seleccionados para evitar la ConcurrentModificationException
        List<PeliculasDeTabla> seleccionadosCopy = new ArrayList<>(seleccionados);

        // Eliminar de la lista de películas todos los elementos que están seleccionados
        peliculas.removeAll(seleccionadosCopy);
    }

    private void modificaTitulo(TableColumn.CellEditEvent<PeliculasDeTabla, String> e) {
        //Obtener la fila que está siendo editada. getRowValue() devuelve el objeto asociado a la 
        //fila que se está editando.
        PeliculasDeTabla p = e.getRowValue();
        //obtener el nuevo valor después de la edición. Si hubiera BBDD se podría actualizar 
        p.setTitulo(e.getNewValue());

        //Nota: sin este método, si se modifica una columna y se vuelve a modificar por segunda vez, su valor vuelve a ser el 
        //real almacenado en el objeto. 
    }

    private void modificaAño(TableColumn.CellEditEvent<PeliculasDeTabla, Integer> e) {
        PeliculasDeTabla p = e.getRowValue();
        p.setAño(e.getNewValue());
    }

    private void modificaPrecio(TableColumn.CellEditEvent<PeliculasDeTabla, Double> e) {
        PeliculasDeTabla p = e.getRowValue();
        p.setPrecio(e.getNewValue());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
