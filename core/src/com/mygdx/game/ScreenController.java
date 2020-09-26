package com.mygdx.game;


public class ScreenController {

    RootController mainClient;



    //todo orice ar fi legat de trecerea itre Screenrui ar trebui sa fie aici

    public ScreenController(RootController mainClient){
        this.mainClient =mainClient;
    }

    public void goToCredentialsScreen(){
        mainClient.setScreen(mainClient.credentialsScreen);
    }

    public void goToJoinRoomScreen(){
        mainClient.setScreen(mainClient.joinRoomScreen);
    }


}
