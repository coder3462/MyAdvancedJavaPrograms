package Unit11;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ListViewDemo2 extends Application
{
    private Label response;

    @Override
    public void start(Stage myStage)
    {
        myStage.setTitle( "ListView Demo" );

        FlowPane rootNode = new FlowPane();

        Scene myScene = new Scene( rootNode, 300, 200 );
        rootNode.setAlignment( Pos.CENTER );

        ObservableList<String> choices = FXCollections.observableArrayList( " Item 1", " Item 2", " Item 3" );

        ListView<String> myListView = new ListView<String>( choices );
        myListView.setPrefSize( 100, 100 );

        myListView.getSelectionModel().setSelectionMode( SelectionMode.SINGLE );

        response = new Label("");

        // add control to the layout manager
        rootNode.getChildren().addAll( myListView, response );
        myStage.setScene( myScene );
        myStage.show();

        MultipleSelectionModel<String> selectionMod = myListView.getSelectionModel();
        selectionMod.selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed( ObservableValue<? extends String> change, String oldVal, String newVal )
                    {
                        response.setText( newVal + " was elected" );
                    }
                }
        );
    }

    public static void main(String[] args)
    {
        launch( args );
    }
}
