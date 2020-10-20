/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse.ruzicka.main;


import cz.vse.ruzicka.MainController;
import cz.vse.ruzicka.logika.Hra;
import cz.vse.ruzicka.logika.IHra;
import cz.vse.ruzicka.uiText.TextoveRozhrani;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/*******************************************************************************
 * Třída {@code Start} je hlavní třídou projektu,
 * který ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Start extends Application
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {

        List<String> vstup = Arrays.asList(args);


        if(vstup.contains("text")) {
                IHra hra = new Hra();
                TextoveRozhrani ui = new TextoveRozhrani(hra);
                ui.hraj();
        } else {
            launch();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Startuji");

        primaryStage.setTitle("Karkulka");

        primaryStage.show();

        FXMLLoader loader = new FXMLLoader();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("scene.fxml");
        Parent root = loader.load(stream);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        MainController controller = loader.getController();
        controller.init();
    }
}
