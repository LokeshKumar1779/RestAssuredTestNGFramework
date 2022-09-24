import applicationApi.PlaylistApi;
import helper.*;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Error;
import pojo.Playlist;
import utils.DataLoader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.FakerUtils.generateDesc;
import static utils.FakerUtils.generateName;

@Epic("Spotify OAuth 2.0")
@Feature("Playlist API")
public class PlaylistTests extends BaseTest{

    @Story("Create a Playlist")
    @Description("This TC is about creation of playlist")
    @Test(priority = 1,description = "create a playlist")
    @Link("https://example.org")
    @Link(name = "allure",type = "mylink")
    @TmsLink("test-1")
    public void shouldBeAbleToCreatePlaylist(){

    Playlist playlistReq = PlaylistHelper.createPlayList(generateName(), generateDesc(), false);

    Response response = PlaylistApi.post(playlistReq);

    AssertStatus.assertStatusCode(response.statusCode(),201);
    AssertPlaylist.assertPlaylist(response.as(Playlist.class),playlistReq);

    }

    @Description("This TC is about get a playlist based on playlist id")
    @Test(priority = 2,description = "get a playlist")
    @Issue("123")
    @TmsLink("test-2")
    public void shouldBeAbleToAGetPlaylist(){

        //Playlist playlistReq = PlaylistHelper.createPlayList("Update_Playlist_01", "test Desc", false);

        Response response = PlaylistApi.get(DataLoader.getInstance().getPlaylistId());

        AssertStatus.assertStatusCode(response.statusCode(),200);
        AssertPlaylist.assertGetPlaylist(response.as(Playlist.class),DataLoader.getInstance().getPlaylistId());
    }


    @Description("This TC is about update of playlist")
   @Test(priority = 3,description = "update a playlist")
    @TmsLink("test-3")
    public void shouldBeAbleToUpdatePlaylist(){

       Playlist updatePlaylistReq = PlaylistHelper.updatePlayList(generateName(), generateDesc(),false);
       Response response = PlaylistApi.update(updatePlaylistReq,DataLoader.getInstance().getUpdatePlaylistId());
       AssertStatus.assertStatusCode(response.statusCode(),200);

    }

    @Story("Create a Playlist")
    @Description("This TC is about creation of playlist without name as negative TC")
    @Test(priority = 4,description = "Negative scenario of playlist creation without name")
    @TmsLink("test-4")
    public void shouldNotBeAbleToCreatePlaylistWithoutName(){

        Playlist playlistReq = PlaylistHelper.createPlayListWithOutName("",generateDesc(),false);

        Response response = PlaylistApi.post(playlistReq);
        AssertError.assertErrorCode(response.getStatusCode(),400);
        AssertError.assertErrorStatus(response.as(Error.class).getError().getStatus(),400);
        AssertError.assertErrorMsg(response.as(Error.class).getError().getMessage(), "Missing required field: name");

    }

    @Story("Create a Playlist")
    @Description("This TC is about creation of playlist when token is invalid as negative TC")
    @Test(priority = 5,description = "Negative scenario of playlist creation with invalid Token")
    @TmsLink("test-5")
    public void shouldNotBeAbleToCreatePlaylistWithoutAccessToken(){

        String token = "1234";

//        Playlist playlistReq = new Playlist().setName("Update_Playlist_01").setDescription("test Desc").setPublic(false);
        Playlist playlistReq = PlaylistHelper.createPlayList(generateName(), generateDesc(), false);
        Response response = PlaylistApi.post(playlistReq,token);

        AssertError.assertErrorCode(response.getStatusCode(),401);
        AssertError.assertErrorStatus(response.as(Error.class).getError().getStatus(),401);
        AssertError.assertErrorMsg(response.as(Error.class).getError().getMessage(), "Invalid access token");

    }


}
