package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Client;
import com.mygdx.game.Constants;
import com.mygdx.game.ScreenController;
import com.mygdx.game.generics.Player;
import com.mygdx.game.generics.Room;

import java.util.ArrayList;
import java.util.List;

public class Lobby implements Screen {
    Stage stage;
    Skin skin;
    Viewport viewport;
    float width;
    float height;

    Client mainController;
    ScreenController screenController;

    //Buttons



    public List<Player> players = new ArrayList<>();
    public Table table = new Table();

    public Lobby(Client mainController){
        viewport = new ScreenViewport();
        stage = new Stage(viewport);
        this.mainController = mainController;
        screenController =  mainController.screenController;
        System.out.println( " Created Lobby Screeem ");
    }


    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin = new Skin(Gdx.files.internal(Constants.skinJsonString));
        Gdx.input.setInputProcessor(stage);

        table.debug();

        table.center();

        table.defaults().expandX().fill().space(5f);

        Player pl1 = new Player("hudy",2);
        Player pl2 = new Player("hudy1",2);
        Player pl3 = new Player("hudy2",2);
        Player pl4 = new Player("hudy3",2);
        Player pl5 = new Player("hudy4",2);

        players.add(pl1);
        players.add(pl2);
        players.add(pl3);
        players.add(pl4);
        players.add(pl5);

        refreshTable(table,players);

        ScrollPane scrollPane = new ScrollPane(table,skin);
        scrollPane.setWidth(Gdx.graphics.getWidth()-200);
        scrollPane.setHeight(Gdx.graphics.getHeight()-100);
        scrollPane.setPosition(50,50);
        scrollPane.debug();

        TextButton startBtn = new TextButton("Start",skin);
        startBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println( "Start Button Pressed");
                screenController.goToGameScreen();
            }
        });
        startBtn.setHeight(30);
        startBtn.setWidth(100);
        startBtn.setPosition(Gdx.graphics.getWidth() - startBtn.getWidth() - 20,20);

        TextButton backBtn = new TextButton("Back",skin);
        backBtn.setPosition(15,15);
        backBtn.setHeight(30);
        backBtn.setWidth(100);

        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                screenController.goToMainMenu();
            }
        });
         //stage.addActor(table);
        stage.addActor(backBtn);
        stage.addActor(scrollPane);
        stage.addActor(startBtn);

    }

    public void refreshTable(Table table, List<Player> players){
        table.clear();
        table.defaults().width(110);

        for (Player pl:players) {
            table.row().setActorHeight(20);
            Label label = new Label(pl.getNickName() + " ",skin);
            label.setAlignment(Align.center);
            table.add(label);
            table.row();
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.8f,0.8f, 0.8f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;


        refreshTable(table,players);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
