package applicationApi;

import helper.SpecBuilder;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.Playlist;
import utils.ConfigLoader;

import static applicationApi.TokenManager.getToken;
import static constants.Route.*;


public class PlaylistApi extends SpecBuilder {


    @Step
    public static Response post(Playlist playlist){

        return RestResource.post(USERS+"/"+ ConfigLoader.getInstance().getUserId() +PLAYLISTS,getToken(),playlist);

    }

    @Step
    public static Response get(String playlistId){

        return RestResource.get(PLAYLISTS+"/"+playlistId,getToken());

    }

    @Step
    public static Response update(Playlist playlist, String playlistId){

        return RestResource.update(PLAYLISTS+"/"+playlistId,getToken(),playlist);

    }

    @Step
    public static Response post(Playlist playlist, String token) {

        return RestResource.post(USERS + "/"+ ConfigLoader.getInstance().getUserId() + PLAYLISTS,token,playlist);
    }
}
