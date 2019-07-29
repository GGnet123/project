import java.io.BufferedReader;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.FileInputStream;
import javafx.scene.text.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.event.*;
import javafx.scene.shape.*;
public class Shop extends Pane{
	String link;
	Heroes hero;
	int cash = 0;
	public Shop(Stage stage,Heroes hero) throws IOException{
	this.hero=hero;
	////////////////////////////////
	Image cursor = new Image(new FileInputStream("Imgs/Cursor.png"));//Image of new Cursor	
	/////////////////////////////////
	
	/////////////////////////////////
	BufferedReader br = new BufferedReader(new FileReader("Money.txt"));
	String money = br.readLine();
	cash = cash + Integer.parseInt(money);
	Text gold = new Text("Money: " + money);
	gold.setY(700);
	gold.setFill(Color.GOLD);
	gold.setFont(Font.font ("Verdana", 50));
	/////////////////////////////////////////

	//////////////////////////////////////////
	Image image1 = new Image(new FileInputStream(hero.shoplink1));
    ImageView imageView1 = new ImageView(image1);
    imageView1.setFitHeight(300);
    imageView1.setFitWidth(350);
    imageView1.setRotate(-50);
    Image image2 = new Image(new FileInputStream(hero.shoplink2));
    ImageView imageView2 = new ImageView(image2);
    imageView2.setFitHeight(300);
    imageView2.setFitWidth(350);
    imageView2.setRotate(-50);
    Image image3 = new Image(new FileInputStream(hero.shoplink3));
    ImageView imageView3 = new ImageView(image3);
    imageView3.setFitHeight(300);
    imageView3.setFitWidth(350);
    imageView3.setRotate(-45);
    Image image4 = new Image(new FileInputStream(hero.shoplink4));
    ImageView imageView4 = new ImageView(image4);
    imageView4.setFitHeight(300);
    imageView4.setFitWidth(350);
    imageView4.setRotate(-50);
    ////////////////////////////////////////////////////////
    setStyle("-fx-background-image: url('file:C:/Users/user/eclipse-workspace/DecoratorPattern/backgrounds/shop2.jpg'); "
    		+ "-fx-background-repeat: repeat;" + "-fx-background-size: 1300 800;");
    ////////////////////////////////////////////////////////
    HBox weapons = new HBox();
    weapons.getChildren().addAll(imageView1, imageView2, imageView3, imageView4);
    weapons.setTranslateY(73);
    
    Button btn1 = new Button("Buy");
    btn1.setStyle("-fx-background-color: burlywood;"+"-fx-font-size: 20px;"+"-fx-pref-width:150px;");
    Button btn2 = new Button("Buy");
    btn2.setStyle("-fx-background-color: burlywood;"+"-fx-font-size: 20px;"+"-fx-pref-width:150px;");
    Button btn3 = new Button("Buy");
    btn3.setStyle("-fx-background-color: burlywood;"+"-fx-font-size: 20px;"+"-fx-pref-width:150px;");
    Button btn4 = new Button("Buy");
    btn4.setStyle("-fx-background-color: burlywood;"+"-fx-font-size: 20px;"+"-fx-pref-width:150px;");
///////////////////////////////////////////////
    HBox armor = new HBox();
    Image arm1 = new Image(new FileInputStream("imgs//a1.png"));
    ImageView armorView1 = new ImageView(arm1);
    armorView1.setFitHeight(300);
    armorView1.setFitWidth(350);
    Image arm2 = new Image(new FileInputStream("imgs//a2.png"));
    ImageView armorView2 = new ImageView(arm2);
    armorView2.setFitHeight(300);
    armorView2.setFitWidth(350);
    Image arm3 = new Image(new FileInputStream("imgs//a3.png"));
    ImageView armorView3 = new ImageView(arm3);
    armorView3.setFitHeight(300);
    armorView3.setFitWidth(350);
    Image arm4 = new Image(new FileInputStream("imgs//a4.png"));
    ImageView armorView4 = new ImageView(arm4);
    armorView4.setFitHeight(300);
    armorView4.setFitWidth(350);
    armor.getChildren().addAll(armorView1,armorView2,armorView3,armorView4);
 	armor.setTranslateY(100);
///////////////////////////////////////////////
    
    HBox buybtn = new HBox();
    buybtn.getChildren().addAll(btn1,btn2,btn3,btn4);
    buybtn.setTranslateY(600);
    buybtn.setTranslateX(100);
    buybtn.setSpacing(200);
   
    ////////////////////////////////////////////////////////////////
    //creating tabs
    TabPane tabPane = new TabPane();
    Tab tab = new Tab();
    Tab tab2 = new Tab();
    tab.setContent(weapons);
    tab2.setContent(armor);
    tabPane.getTabs().addAll(tab,tab2);
    tabPane.setPrefHeight(1400);
    tabPane.setLayoutY(37.7);
    tabPane.setTabMinHeight(100);
    tabPane.setTabMaxHeight(100);
    ImageView icon1 = new ImageView(new Image(new FileInputStream("imgs//swordicon.png")));
    icon1.setFitWidth(100);
    icon1.setFitHeight(100);
    ImageView icon2 = new ImageView(new Image(new FileInputStream("imgs//armoricon.png")));
    icon2.setFitWidth(100);
    icon2.setFitHeight(100);
    
    tab.setGraphic(icon1);
    tab2.setGraphic(icon2);
    getStylesheets().addAll("file:C://Users//user//eclipse-workspace//DecoratorPattern//shop.css");
	///////////////////////////////////////////////////////////////
    //buttons set on action
    btn1.setOnAction(e->{
    	if(cash>=3000) {
    		if(tab.isSelected()) {		
    		cash-=3000;
    		this.hero = new Sword(hero);
    		}
    		if(tab2.isSelected()) {
    			cash-=3000;
    			this.hero.hp = hero.getHP() + 100;
    		}
			try {
				PrintWriter writer = new PrintWriter("Money.txt", "UTF-8");
				writer.println(cash);
				writer.close();
				gold.setText("Money: " + cash);
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {}
    	}
    	else {
    		Text cant = new Text("Not Enough Money!");
    		cant.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
    		cant.setFill(Color.RED);
    		cant.setX(460);
    		cant.setY(300);
    		
    		FadeTransition ft = new FadeTransition(Duration.millis(1500), cant);
    		ft.setFromValue(1.0);
    		ft.setToValue(0.0);
    		ft.setCycleCount(1);
    		ft.setAutoReverse(false);
    		getChildren().add(cant);
    		ft.play();
    	}
    });    
    
    btn2.setOnAction(e->{
    	if(cash>=5000) {
    		if(tab.isSelected()) {		
    		cash-=5000;
    		this.hero = new Sword2(hero);
    		}
    		if(tab2.isSelected()) {
    			cash-=5000;
    			this.hero.hp =hero.getHP() + 200;
    		}
			try {
				PrintWriter writer = new PrintWriter("Money.txt", "UTF-8");
				writer.println(cash);
				writer.close();
				gold.setText("Money: " + cash);
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {}
    	}
    	else {
    		Text cant = new Text("Not Enough Money!");
    		cant.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
    		cant.setFill(Color.RED);
    		cant.setX(460);
    		cant.setY(300);
    		
    		FadeTransition ft = new FadeTransition(Duration.millis(1500), cant);
    		ft.setFromValue(1.0);
    		ft.setToValue(0.0);
    		ft.setCycleCount(1);
    		ft.setAutoReverse(false);
    		getChildren().add(cant);
    		ft.play();
    	}
    });
    
    btn3.setOnAction(e->{
    	if(cash>=8000) {
    		if(tab.isSelected()) {		
    		cash-=8000;
    		this.hero = new Sword3(hero);
    		}
    		if(tab2.isSelected()) {
    			cash-=8000;
    			this.hero.hp =hero.getHP() + 300;
    		}
			try {
				PrintWriter writer = new PrintWriter("Money.txt", "UTF-8");
				writer.println(cash);
				writer.close();
				gold.setText("Money: " + cash);
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {}
    	}
    	else {
    		Text cant = new Text("Not Enough Money!");
    		cant.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
    		cant.setFill(Color.RED);
    		cant.setX(460);
    		cant.setY(300);
    		
    		FadeTransition ft = new FadeTransition(Duration.millis(1500), cant);
    		ft.setFromValue(1.0);
    		ft.setToValue(0.0);
    		ft.setCycleCount(1);
    		ft.setAutoReverse(false);
    		getChildren().add(cant);
    		ft.play();
    	}
    });
    
    btn4.setOnAction(e->{
    	if(cash>=10000) {
    		if(tab.isSelected()) {		
    		cash-=10000;
    		this.hero = new Sword4(hero);
    		}
    		if(tab2.isSelected()) {
    			cash-=10000;
    			this.hero.hp = hero.getHP() + 400;
    		}
			try {
				PrintWriter writer = new PrintWriter("Money.txt", "UTF-8");
				writer.println(cash);
				writer.close();
				gold.setText("Money: " + cash);
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {}
    	}
    	else {
    		Text cant = new Text("Not Enough Money!");
    		cant.setFont(Font.font ("Tahoma",FontWeight.BOLD, 50));
    		cant.setFill(Color.RED);
    		cant.setX(460);
    		cant.setY(300);
    		
    		FadeTransition ft = new FadeTransition(Duration.millis(1500), cant);
    		ft.setFromValue(1.0);
    		ft.setToValue(0.0);
    		ft.setCycleCount(1);
    		ft.setAutoReverse(false);
    		getChildren().add(cant);
    		ft.play();
    	}
    });

	///////////////////////////////////////////////////////////////
	Button back = new Button("Back to Map");
	back.setLayoutX(10);
	back.setLayoutY(10);
	back.setOnAction(event->{
		try {
			Map	map = new Map(stage,this.hero);
			Scene scene = new Scene(map,1300,700);
			stage.setScene(scene);
			stage.setFullScreen(true);
			scene.setCursor(new ImageCursor(cursor));
			stage.setTitle("Hero Adventures!");
			stage.show();
		} catch (FileNotFoundException e1) {} 		
	});
	getChildren().addAll(tabPane,gold,back,buybtn);
	}
}