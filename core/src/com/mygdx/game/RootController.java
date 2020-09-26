package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Screens.Credentials;
import com.mygdx.game.Screens.JoinRoom;
import com.mygdx.game.Screens.MainMenu;
import com.mygdx.networking.dto.NetworkDTO;
import com.mygdx.networking.networkController.NetworkController;
import com.mygdx.networking.networkService.NetworkService;

import java.net.URISyntaxException;
import java.util.List;

public class RootController extends Game implements NetworkController {

	//TODO: ADD THIS TO CONSTANTS;
	public float screenWidth;
	public float screenHeight;


	//Different types of controllers and services
	public ScreenController screenController;
	public NetworkService networkService;

	// Screens
	MainMenu mainMenuScreen;
	Credentials credentialsScreen;
	JoinRoom joinRoomScreen;

	//Game data
	NetworkDTO.Token token;
	NetworkDTO.Bids bidStatus;
	NetworkDTO.Table tableStatus;


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

		setScreen(mainMenuScreen);
	}

	public void setScreen(Screen screen){
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


	//NETWORKING

	@Override
	public void initializeNetworkService(String http) {
		this.networkService = NetworkService.getInstance();
		this.networkService.initService(http,this);
	}

	@Override
	public void connect() throws URISyntaxException {
		this.networkService.login();
	}

	@Override
	public void setConnectedStatus(boolean isConnected) {
		// if isConnected === true; change to mainMenu
		//else... let loading screen instead
	}

	@Override
	public void setToken(NetworkDTO.Token token) {
		this.token = token;
		//here u can add a function to update the screen with the new token;
	}

	@Override
	public void goToRoomsScreen() {
		//change to roomsScreen;
	}

	@Override
	public void updateRooms(NetworkDTO.RoomsResponse roomsResponse) {
		//here u get the list of rooms...add the list to the screen
	}

	@Override
	public void setLobbyData(NetworkDTO.Lobby lobby, boolean isOwner) {
		//here u get the lobby data...add this to screen
		//if isOwner == true => make the start/ready button visible
	}

	@Override
	public void goToLobbyScreen() {
		//go to lobby screen
	}

	@Override
	public void goToMainMenu() {
		//go to main menu
	}

	@Override
	public void goToGame() {
		//go to game screen
	}

	@Override
	public void updatePlayerList(List<NetworkDTO.Player> players) {
		//here u get the list with the players which take part in the game
		//use this to arrange players to the table
	}

	@Override
	public void updateCards(NetworkDTO.Cards cards) {
		//this function gets called when u receive cards;
		// use this function to show cards to your player;
		// look in cards to see if there is any atu
	}

	@Override
	public void showHudForBids(NetworkDTO.Bids.Bid bid) {
		//this function gets called when u need to make the bid;
		//use bid to see the forbidden value;
	}

	@Override
	public void hideBidHUD() {
		// u just need to hide the BidHud
	}

	@Override
	public void showHudForCards(NetworkDTO.Table.PlayerStatus ps) {
		//Same as bid...but now u see the all the cards placed by the players
		// use ps to see what u can put and what u cannot
		//even if the server makes validation, u should do that too.
	}

	@Override
	public void hideCardHud() {
		//just hide CardHud
	}

	@Override
	public void updateBids(NetworkDTO.Bids bids) {
		this.bidStatus = bids;
	}

	@Override
	public void updateTable(NetworkDTO.Table table) {
		this.tableStatus = table;
	}

	@Override
	public void sendCard(String card) {
		//Get the card for the player
		//1. validate the card
		//2. send to networkService;

		//validate(card);
		this.networkService.sendCardResponse(card);
	}

	@Override
	public void sendBid(int bid) {
		//validate(bid)
		this.networkService.sendBidResponse(bid);
	}

	@Override
	public void joinGame(String roomID, String nickname) {
		//validate(roomID,nickname); SHOULD NOT BE NULL!
		this.networkService.joinRoomRequest(roomID,nickname);
		//go to loading screen
	}

	@Override
	public void startGame() {
		this.networkService.startGameRequest();
		//go to loading screen
	}

	@Override
	public void leaveRoom() {
		this.networkService.leaveRoomRequest();
		//go to main Menu
	}

	@Override
	public void getRooms() {
		this.networkService.makeRoomsRequest();
		//go to loading screen
	}

	@Override
	public void disconnect() {
		this.networkService.disconnect();
		System.exit(0);
	}
}

