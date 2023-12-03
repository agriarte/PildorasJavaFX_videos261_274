/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pildoras.javafx_controles_videos261_269;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 
 * Un treeview sencillo con varias ramas y subramas La parte del Listener es
 * demasiado verbosa. Seguramente hay formas más sencillas
 * 
 * Ejemplos más avanzados consultar: https://examples.javacodegeeks.com/java-development/core-java/javafx-treeview-example/
 */
public class Video264_TreeView extends Application {

    @Override
    public void start(Stage primaryStage) {

        // el root de los items
        TreeItem root = new TreeItem("peliculas");

        //arbol SuperHeroes
        TreeItem<String> rSuperheroes = new TreeItem<>("Superheroes");
        rSuperheroes.setExpanded(true);

        TreeItem<String> super1 = new TreeItem<>("Superman");
        TreeItem<String> super2 = new TreeItem<>("Spyderman");

        rSuperheroes.getChildren().add(super1);
        rSuperheroes.getChildren().add(super2);

        //arbol comedias
        TreeItem<String> rComedias = new TreeItem<>("Comedia");
        rComedias.setExpanded(true);

        TreeItem<String> comedias1 = new TreeItem<>("Toma el dinero y corre");
        TreeItem<String> comedias2 = new TreeItem<>("Mejor solo que mal acompañado");

        rComedias.getChildren().add(comedias1);
        rComedias.getChildren().add(comedias2);
        //subarbol dentro de comedias, rama comedia musical
        TreeItem<String> rComediaMusical = new TreeItem<>("Comedia Musical");
        //item de comedia musical
        TreeItem<String> comediaMusical1 = new TreeItem<>("Cantando bajo la lluvia");
        //añadir a "Comedia" la rama "Comedia Musical"
        rComediaMusical.getChildren().add(comediaMusical1);

        rComedias.getChildren().add(rComediaMusical);

        //añadir al root
        root.getChildren().addAll(rComedias, rSuperheroes);
        TreeView miTreeView = new TreeView(root);

        // Agregar un ChangeListener al selectionModel del TreeView
        miTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue,
                    TreeItem<String> newValue) {
                if (newValue != null) {
                    // Aquí puedes hacer algo con el valor seleccionado
                    System.out.println("Seleccionado: " + newValue.getValue());
                }
            }
        });

        miTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {

            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                System.out.println("Selecco: " + newValue.getValue());
            }
        });
        StackPane miStackPane = new StackPane();
        miStackPane.getChildren().addAll(miTreeView);

        Scene scene = new Scene(miStackPane, 300, 250);

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

}
