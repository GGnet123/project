import java.io.FileInputStream;
import javafx.scene.shape.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;  
import javafx.scene.effect.DropShadow;
import javafx.scene.ImageCursor;
// our Map class becomes Pane by itself
public class Map extends Pane {
	Arena arena;
	Test test;
	int lvl;
	public Map(Stage stage,Heroes hero) throws FileNotFoundException {
		Image cursor = new Image(new FileInputStream("Imgs/Cursor.png"));//Image of new Cursor
		//glow effect
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.RED);
		shadow.setOffsetX(1f);
		shadow.setOffsetY(1f);
		shadow.setHeight(50);
		shadow.setWidth(50);
	
		//circles with enemies  
		Image gnoll = new Image(new FileInputStream("monsterImgs/gnoll.jpg"));
		Image Harpii = new Image(new FileInputStream("monsterImgs/harpy.jpg"));
		Image Ogre = new Image(new FileInputStream("monsterImgs/ogre.jpg"));
		Image ghoul = new Image(new FileInputStream("monsterImgs/ghoul.jpg"));
		Image drake = new Image(new FileInputStream("monsterImgs/questionmark.jpg"));
		
		Circle circle1 = new Circle();
		circle1.setCenterX(400);
	    circle1.setCenterY(650);
	    circle1.setRadius(50);
	    circle1.setStroke(Color.RED); // you may change it if you think it is needed ^_^
	    circle1.setStrokeWidth(3);
	    circle1.setFill(new ImagePattern(gnoll));//it does not work without ImagePattern (that is how we put an image into circle)
	    circle1.toFront();
	    
	    Circle circle2 = new Circle();
	    circle2.setCenterX(740);
	    circle2.setCenterY(690);
	    circle2.setRadius(50);
	    circle2.setStroke(Color.YELLOW);
	    circle2.setStrokeWidth(3);
	    circle2.setFill(new ImagePattern(Harpii));//it does not work without ImagePattern (that is how we put an image into circle)
	    circle2.toFront();
	    
	    Circle circle3 = new Circle();
	    circle3.setCenterX(870);
	    circle3.setCenterY(535);
	    circle3.setRadius(50);
	    circle3.setStroke(Color.GREEN);
	    circle3.setStrokeWidth(3);
	    circle3.setFill(new ImagePattern(Ogre));//it does not work without ImagePattern (that is how we put an image into circle)
	    
	    Circle circle4 = new Circle();
	    circle4.setCenterX(1150);
	    circle4.setCenterY(575);
	    circle4.setRadius(50);
	    circle4.setStroke(Color.BLUE);
	    circle4.setStrokeWidth(3);
	    circle4.setFill(new ImagePattern(ghoul));//it does not work without ImagePattern (that is how we put an image into circle)
	    
	    Circle circle5 = new Circle();
	    circle5.setCenterX(1240);
	    circle5.setCenterY(90);
	    circle5.setRadius(50);
	    circle5.setStroke(Color.RED);
	    circle5.setStrokeWidth(3);
	    circle5.setFill(new ImagePattern(drake));//it does not work without ImagePattern (that is how we put an image into circle)
	    
	    //applying glow effect
	    circle1.setOnMouseEntered(e -> 
		{   
			circle1.setEffect(shadow); 
		});
		circle1.setOnMouseExited(e ->{
			circle1.setEffect(null); 
		});
		 circle2.setOnMouseEntered(e -> 
		{   
			circle2.setEffect(shadow); 
		});
		circle2.setOnMouseExited(e ->{
			circle2.setEffect(null); 
		});
		
		 circle3.setOnMouseEntered(e -> 
		{   
			circle3.setEffect(shadow); 
		});
		circle3.setOnMouseExited(e ->{
			circle3.setEffect(null); 
		});

		circle4.setOnMouseEntered(e -> 
		{   
			circle4.setEffect(shadow); 
		});
		circle4.setOnMouseExited(e ->{
			circle4.setEffect(null); 
		});
		
		circle5.setOnMouseEntered(e -> 
		{   
			circle5.setEffect(shadow); 
		});
		circle5.setOnMouseExited(e ->{
			circle5.setEffect(null); 
		});
		
	    //our Map
		Image map = new Image(new FileInputStream("backgrounds/Map.jpeg"));  
		ImageView mapImg = new ImageView(map); 
		mapImg.setFitHeight(780);
		mapImg.setFitWidth(1380);
		
		
		//setting an event on our circles
		circle1.setOnMouseClicked(e->{
			lvl = 1;
			try {
				arena = new Arena(lvl,stage,hero);
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(arena,1300,700);
			scene.setCursor(new ImageCursor(cursor));
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
			
		});
		
		circle2.setOnMouseClicked(e->{
			lvl = 2;
			try {
				arena = new Arena(lvl,stage,hero);
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(arena,1300,700);
			scene.setCursor(new ImageCursor(cursor));
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
			
		});
		
		circle3.setOnMouseClicked(e->{
			lvl = 3;
			try {
				arena = new Arena(lvl,stage,hero);
				
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(arena,1300,700);
			scene.setCursor(new ImageCursor(cursor));
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
			
		});
		
		circle4.setOnMouseClicked(e->{
			lvl = 4;
			try {
				arena = new Arena(lvl,stage,hero);
				
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(arena,1300,700);
			scene.setCursor(new ImageCursor(cursor));
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
			
		});
		
		circle5.setOnMouseClicked(e->{
			lvl = 5;
			try {
				arena = new Arena(lvl,stage,hero);
				
			} catch (FileNotFoundException e1) {}
			Scene scene = new Scene(arena,1300,700);
			scene.setCursor(new ImageCursor(cursor));
			stage.setScene(scene);
			stage.setFullScreen(true);
			stage.setTitle("Hero Adventures!");
			stage.show();
		});
		
		//shop
		DropShadow gold = new DropShadow();
		gold.setColor(Color.GOLD);
		gold.setOffsetX(1f);
		gold.setOffsetY(1f);
		gold.setHeight(150);
		gold.setWidth(150);
		
		Image shop = new Image(new FileInputStream("hut.png"));
		ImageView shopImg = new ImageView(shop);
		shopImg.setFitWidth(110);
		shopImg.setFitHeight(95);
		shopImg.setLayoutX(1170);
		shopImg.setLayoutY(260);
		shopImg.toFront();
		shopImg.setOnMouseClicked(event->{
			try {
				Shop sh = new Shop(stage,hero);
				Scene scene = new Scene(sh,1300,700);
				scene.setCursor(new ImageCursor(cursor));
				stage.setScene(scene);
				stage.setFullScreen(true);
				stage.setTitle("Hero Adventures!");
				stage.show();
				
			} catch (IOException e1) {}
		});
		shopImg.setOnMouseEntered(e -> 
		{   
			shopImg.setEffect(gold); 
		});
		shopImg.setOnMouseExited(e ->{
			shopImg.setEffect(null); 
		});
		
		//adding everything on our map
		getChildren().addAll(mapImg,circle1,circle2,circle3,circle4,circle5,shopImg);
	}
}
