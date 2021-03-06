package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Screens.CreateRoom;
import com.mygdx.game.Screens.Credentials;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.JoinRoom;
import com.mygdx.game.Screens.Lobby;
import com.mygdx.game.Screens.MainMenu;
import com.mygdx.game.networking.dto.NetworkDTO;
import com.mygdx.game.networking.networkController.NetworkController;

import java.net.URISyntaxException;
import java.util.List;

public class Client extends Game implements NetworkController {

	public float screenWidth;
	public float screenHeight;

	public ScreenController screenController;

	MainMenu mainMenuScreen;
	Credentials credentialsScreen;
	JoinRoom joinRoomScreen;
	CreateRoom createRoomScreen;
	Lobby lobbyScreen;
	GameScreen gameScreen;

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
		lobbyScreen = new Lobby(this);
		gameScreen =  new GameScreen(this);


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

	/**
	 * Get a copy of the instance of Network interface
	 * ex :
	 * {
	 * NetworkService service = NetworkService.getInstance();
	 * service.initService(http,this)
	 * this.networkService = service;
	 * }
	 *
	 * @param http : the address of the server (host + port)
	 * @return -;
	 */
	@Override
	public void initializeNetworkService(String http) {

	}

	@Override
	public void connect() throws URISyntaxException {

	}

	/**
	 * This function gets call when the connection status has changed
	 * ex: when you try to connect to server, when to connection is establish... the parameter isConnected will be true;
	 *
	 * @param isConnected
	 */
	@Override
	public void setConnectedStatus(boolean isConnected) {

	}

	/**
	 * This function gets called when the networkingService has received token
	 *
	 * @param token
	 */
	@Override
	public void setToken(NetworkDTO.Token token) {

	}

	/**
	 * This function get's called when the player made the ROOM_REQUEST. It moves the screen to ROOM_SCREEN
	 */
	@Override
	public void goToRoomsScreen() {

	}

	/**
	 * This function get's called when the client received the response from ROOM_REQUEST. Look to put all the rooms in the ROOM_SCREEN.
	 *
	 * @param roomsResponse
	 */
	@Override
	public void updateRooms(NetworkDTO.RoomsResponse roomsResponse) {

	}

	/**
	 * This functions gets called every time client receives lobbyData
	 *
	 * @param lobby
	 * @param isOwner -> true === u are owner, false otherwise;
	 */
	@Override
	public void setLobbyData(NetworkDTO.Lobby lobby, boolean isOwner) {

	}

	/**
	 * This function gets called when you need to change the screen to LOBBY
	 */
	@Override
	public void goToLobbyScreen() {

	}

	/**
	 * This function gets called when you need to change the screen to MAIN_MENU
	 */
	@Override
	public void goToMainMenu() {

	}

	/**
	 * This function gets called when you need to change the screen to GAME
	 */
	@Override
	public void goToGame() {

	}

	/**
	 * This functions gets called when you received the players for a game for the first time
	 *
	 * @param players
	 */
	@Override
	public void updatePlayerList(List<NetworkDTO.Player> players) {

	}

	/**
	 * This function gets called when you received the cards
	 *
	 * @param cards
	 */
	@Override
	public void updateCards(NetworkDTO.Cards cards) {

	}

	/**
	 * This function gets called when it's your turn to make the bid
	 * It's up to you to ensure that the bid which will be made is valid!!
	 *
	 * @param bid
	 */
	@Override
	public void showHudForBids(NetworkDTO.Bids.Bid bid) {

	}

	/**
	 * This function gets called when it's not your turn to make bid;
	 */
	@Override
	public void hideBidHUD() {

	}

	/**
	 * This function gets called when it's your turn to place a card
	 * It's up to you to ensure that the card which will be placed is valid;
	 *
	 * @param ps
	 */
	@Override
	public void showHudForCards(NetworkDTO.Table.PlayerStatus ps) {

	}

	/**
	 * This function gets called when it's not your turn to place a card
	 */
	@Override
	public void hideCardHud() {

	}

	/**
	 * This function gets called when you received the bids Data
	 *
	 * @param bids
	 */
	@Override
	public void updateBids(NetworkDTO.Bids bids) {

	}

	/**
	 * This function gets called when the client received Table Data
	 *
	 * @param table
	 */
	@Override
	public void updateTable(NetworkDTO.Table table) {

	}

	/**
	 * Call this function when you picked a card and want to send it to server
	 * !! Make sure the card is valid before calling this function!!
	 *
	 * @param card
	 */
	@Override
	public void sendCard(String card) {

	}

	/**
	 * Call this function when you choosed the bid and want to send it to server
	 * !!Make sure the bid is valid before calling this function!!
	 *
	 * @param bid
	 */
	@Override
	public void sendBid(int bid) {

	}

	/**
	 * Call this function when you want to join a game from the room_list
	 *
	 * @param roomID
	 * @param nickname
	 */
	@Override
	public void joinGame(String roomID, String nickname) {

	}

	/**
	 * Call this function when you want to start the game in which you are owner;
	 */
	@Override
	public void startGame() {

	}

	/**
	 * Call this function when you want to leave the room
	 */
	@Override
	public void leaveRoom() {

	}

	/**
	 * call this function when you want to get all the rooms
	 */
	@Override
	public void getRooms() {

	}

	/**
	 * Call this function when you want to disconnect to the server
	 * EX: When the player press the exit button or shut down the main procces.
	 */
	@Override
	public void disconnect() {

	}
}

