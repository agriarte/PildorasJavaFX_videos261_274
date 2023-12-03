/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pildoras.javafx_controles_videos261_269;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Solucion al ejercicio de los videos 265 y 266
 *
 */
public class Video265_266_peliculasTreeView extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeView<String> miArbol;
        Label muestraNombres;
        TreeItem<String> root, belicas, familiares, dramas, infantiles, comedias;

        // el root de los items
        root = new TreeItem<String>("Películas");
        root.setExpanded(true);

        //categoria bélicas
        belicas = muestraNodoArbol("Bélicas", root);
        muestraNodoArbol("Salvar al soldado Ryan", belicas);
        muestraNodoArbol("La chaqueta metálica", belicas);
        muestraNodoArbol("Apocalipsi now", belicas);

        //categoria familiares
        familiares = muestraNodoArbol("Para toda la familia", root);
        infantiles = muestraNodoArbol("Infantiles", familiares);
        muestraNodoArbol("Fantasía", infantiles);
        muestraNodoArbol("Toy Store", infantiles);

        //categoría comedias
        comedias = muestraNodoArbol("Comedia", familiares);
        muestraNodoArbol("No me chilles que no te veo", comedias);

        muestraNodoArbol("Los visitantes", familiares);
        muestraNodoArbol("E.T.", familiares);

        //categoría dranas
        dramas = muestraNodoArbol("Drama", root);
        muestraNodoArbol("Heat", dramas);
        muestraNodoArbol("Bailando con lobos", dramas);
        muestraNodoArbol("Gran Torino", dramas);

        miArbol = new TreeView<>(root);
        miArbol.setShowRoot(false);

        muestraNombres = new Label();

        VBox miPane = new VBox();
        miPane.setPadding(new Insets(20, 20, 20, 20));
        miPane.getChildren().addAll(miArbol, muestraNombres);

        //arbol 
        // Agregar un ChangeListener al selectionModel del TreeView
        //METODO 1 MUY VERBOSO
        miArbol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue,
                    TreeItem<String> newValue) {
                if (newValue != null) {
                    // Aquí puedes hacer algo con el valor seleccionado
                    System.out.println("Seleccionado: " + newValue.getValue());
                }
            }
        });

        //METODO 2 CON LAMBDA
        miArbol.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) -> {
            System.out.println("(lambda)Selección: " + newValue.getValue());
        });

        //Listener del tutorial opcion1
        miArbol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue valor, Object viejoValor, Object nuevoValor) {
                String mensaje = "";
                ObservableList<TreeItem<String>> elementosSeleccionados = miArbol.getSelectionModel().getSelectedItems();
                for (TreeItem elemento: elementosSeleccionados){
                    mensaje += elemento.getValue()+"\n";
                    muestraNombres.setText(mensaje);
                }
            }

        });
        
        //Listener del tutorial opcion2 con Lambda y llamada a un método
        miArbol.getSelectionModel().selectedItemProperty().addListener((valor, antiguoValor, nuevoValor)->selecciónItemArbol(nuevoValor));

        //
        Scene scene = new Scene(miPane);

        primaryStage.setTitle("Probando TreeView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public TreeItem<String> muestraNodoArbol(String titulo, TreeItem<String> parent) {

        TreeItem<String> item = new TreeItem<>(titulo);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    private void selecciónItemArbol(TreeItem<String> nuevoValor) {
        System.out.println("Por Lambda según curso. Selección: " + nuevoValor.getValue());
    }

}
