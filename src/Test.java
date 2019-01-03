import java.io.File;
import java.io.FileInputStream;
import javafx.scene.media.*;
import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;  
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.ImageCursor;
public class Test extends Application{
	Map map;
	public void start(Stage stage) throws FileNotFoundException {
		//creating pane
		GridPane chooseHero = new GridPane();
		chooseHero.setPadding(new Insets(80, 80, 120, 190));
		chooseHero.setHgap(30);
		
		Image cursor = new Image(new FileInputStream("Imgs/Cursor.png"));//Image of new Cursor
		
		//importing images
		Image Herald = new Image(new FileInputStream("HeroImgs/Herald.png"));  
		ImageView HeraldImg = new ImageView(Herald); 
		Image Ciri = new Image(new FileInputStream("HeroImgs/Ciri.png"));  
		ImageView CiriImg = new ImageView(Ciri); 
		Image Yen = new Image(new FileInputStream("HeroImgs/Yen.jpeg"));  
		ImageView YenImg = new ImageView(Yen);
		
		Media media = new Media((new File("IntroGame.mp4").toURI().toString()));
		MediaPlayer player = new MediaPlayer(media);
		MediaView view = new MediaView(player);
		view.setFitWidth(1400);
		view.setFitHeight(1400);
		player.play();
		
		Media sound = new Media((new File("sounds//backsound_civil.mp3").toURI().toString()));
		MediaPlayer backsound = new MediaPlayer(sound);
		
		//pane for intro video
		Pane introPane = new Pane();
		
		Button skip = new Button("Skip");
		skip.setLayoutX(1155);
		skip.setLayoutY(700);
		skip.setTextFill(Color.WHITE);
		skip.setPrefHeight(50);
		skip.setPrefWidth(178);
		skip.setStyle("-fx-background-color: black; ");
		skip.setOnAction(e->{
			player.stop();
			backsound.play();
			Scene scene = new Scene(chooseHero,1300,700);
			scene.setCursor(new ImageCursor(cursor));
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
		});
		introPane.getChildren().addAll(view,skip);
		
		//red glow effect
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.RED);
		shadow.setOffsetX(1f);
		shadow.setOffsetY(1f);
		
		//add everything on pane
		chooseHero.add(HeraldImg,0,0);
		chooseHero.add(CiriImg,1,0);
		chooseHero.add(YenImg,2,0);
		//background
		chooseHero.setStyle("-fx-background-image: url('file:C:/Users/user/eclipse-workspace/DecoratorPattern/backgrounds/mainback.jpg')");
		
		//glow and growth effect when mouse is pointing
		HeraldImg.setOnMouseEntered(e -> 
		{   
			HeraldImg.setScaleX(HeraldImg.getScaleX()+0.1);
			HeraldImg.setScaleY(HeraldImg.getScaleY()+0.1);
			HeraldImg.toFront();
			HeraldImg.setEffect(shadow); 
		});
		HeraldImg.setOnMouseExited(e ->{
			HeraldImg.setScaleX(HeraldImg.getScaleX()-0.1);
			HeraldImg.setScaleY(HeraldImg.getScaleY()-0.1);
			HeraldImg.toFront();
			HeraldImg.setEffect(null); 
		});
		
		CiriImg.setOnMouseEntered(e -> 
		{   
			CiriImg.setScaleX(CiriImg.getScaleX()+0.1);
			CiriImg.setScaleY(CiriImg.getScaleY()+0.1);
			CiriImg.toFront();
			CiriImg.setEffect(shadow); 
		});
		CiriImg.setOnMouseExited(e ->{
			CiriImg.setScaleX(CiriImg.getScaleX()-0.1);
			CiriImg.setScaleY(CiriImg.getScaleY()-0.1);
			CiriImg.toFront();
			CiriImg.setEffect(null); 
		});
		
		YenImg.setOnMouseEntered(e -> 
		{   
			YenImg.setScaleX(YenImg.getScaleX()+0.1);
			YenImg.setScaleY(YenImg.getScaleY()+0.1);
			YenImg.toFront();
			YenImg.setEffect(shadow); 
		});
		YenImg.setOnMouseExited(e ->{
			YenImg.setScaleX(YenImg.getScaleX()-0.1);
			YenImg.setScaleY(YenImg.getScaleY()-0.1);
			YenImg.toFront();
			YenImg.setEffect(null); 
		});
		
		
		HeraldImg.setOnMouseClicked(e->{
			try {
				Heroes hero = new Herald();
				//initializing map (try catch is because in map we search for img files and that needs FileNotFoundException)
			map = new Map(stage,hero);
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(map,1300,700);
			scene.setCursor(new ImageCursor(cursor));//change the cursor
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
		});
		
		YenImg.setOnMouseClicked(e->{
			
			try {
				Heroes hero = new Yen();
				map = new Map(stage,hero);
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(map,1300,700);
			scene.setCursor(new ImageCursor(cursor));//change the cursor
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
			
		});
		
		CiriImg.setOnMouseClicked(e->{
			
			try {
				Heroes hero = new Ciri();
				map = new Map(stage,hero);
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(map,1300,700);
			scene.setCursor(new ImageCursor(cursor));//change the cursor
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
			
		});
		
		Scene scene = new Scene(introPane,1300,700);
		scene.setCursor(new ImageCursor(cursor));//change the cursor
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setTitle("Hero Adventures!");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
