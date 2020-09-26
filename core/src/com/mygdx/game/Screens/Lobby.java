package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Client;
import com.mygdx.game.ScreenController;
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

    TextField userNameTF;
    TextField roomNameTF;

    //Buttons
    TextButton createRoomBtn;

    public List<Room> rooms = new ArrayList<>();
    public Table table = new Table();

    public Lobby(Client mainController){
        viewport = new ScreenViewport();
        stage = new Stage(viewport);
        this.mainController = mainController;
        screenController =  mainController.screenController;
    }

    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        skin = new Skin(Gdx.files.internal("skin.json"));
        Gdx.input.setInputProcessor(stage);

        table.debug();

        table.center();

        table.defaults().expandX().fill().space(5f);
        


        refreshTable(table,this.rooms);

        ScrollPane scrollPane = new ScrollPane(table,skin);
        scrollPane.setWidth(Gdx.graphics.getWidth()-200);
        scrollPane.setHeight(Gdx.graphics.getHeight()-100);
        scrollPane.setPosition(50,50);
        scrollPane.debug();

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
        // stage.addActor(table);
        stage.addActor(backBtn);
        stage.addActor(scrollPane);

    }

    @Override
    public void render(float delta) {

    }

    public void refreshTable(Table table, List<Room> rooms){
        table.defaults().width(110);

        System.out.println(rooms);

        for (final Room rm:rooms) {
            table.row().setActorHeight(20);
            System.out.println("rm.getROOMID() = " + rm.getRoomID());

            table.add(new Label(rm.getRoomID() + " ",skin)).width(rm.getRoomID().length()*20);//!! NETESTAT
            table.add(new Label("[" + rm.getNrOfPlayers()+ "/" + rm.getMaxCapacity() +"]",skin)).width(50).expandX();
            TextButton joinBtn = new TextButton("Join",skin);
            joinBtn.setHeight(30);
            table.add(joinBtn).width(100).pad(3);
            joinBtn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    screenController.goToCredentialsScreen();
                    // mainController.goToCredentialsScreen(rm.getRoomID());
                }
            });
            table.row();
        }
    }

    @Override
    public void resize(int width, int height) {

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
