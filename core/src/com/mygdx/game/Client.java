package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Screens.CreateRoom;
import com.mygdx.game.Screens.Credentials;
import com.mygdx.game.Screens.JoinRoom;
import com.mygdx.game.Screens.MainMenu;

public class Client extends Game {

	public float screenWidth;
	public float screenHeight;

	public ScreenController screenController;

	MainMenu mainMenuScreen;
	Credentials credentialsScreen;
	JoinRoom joinRoomScreen;
	CreateRoom createRoomScreen;

	@Override
	public void dispose() {
		super.dispose();
		System.out.println("Disposed here!");
	}

	@Override
	public void create() {
		// System.out.println("Version: " + version);

		screenController = new ScreenController(this);

		mainMenuScreen =  new MainMenu(this);
		credentialsScreen =  new Credentials(this);
		joinRoomScreen =  new JoinRoom(this);
		createRoomScreen = new CreateRoom(this);

		setScreen(mainMenuScreen);
	}

	public void setSCreen(Screen screen){
		setScreen(screen);
	}

	@Override
	public void render() {
		super.render();
//        //System.out.println(this.changeState);
//        if(this.changeState) {
//            //System.out.println(this.state);
//            switch (this.state) {
//                case MAIN_MENU:
//                    setScreen(mainMenuScreen);
//                    break;
//                case CREATE_ROOM:
//                    setScreen(createRoomScreen);
//                    break;
//                case JOIN_ROOM:
//                    setScreen(joinRoomScreen);
//                    break;
//                case LOBBY_ROOM:
//                    setScreen(lobbyScreen);
//                    break;
//                case LOADING:
//                    setScreen(loadingScreen);
//                    break;
//                case GAME_SCREEN:
//                    setScreen(gameScreen);
//                    break;
//                case CREDENTIALS:
//                    setScreen(credentialsScreen);
//                    break;
//                default:
//                    setScreen(mainMenuScreen);
//                    break;
//            }
//            this.changeState = false;
	}


	public float getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(float screenWidth) {
		this.screenWidth = screenWidth;
	}

	public float getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(float screenHeight) {
		this.screenHeight = screenHeight;
	}
}

