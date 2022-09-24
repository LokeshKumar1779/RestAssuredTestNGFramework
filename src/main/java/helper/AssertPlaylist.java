package helper;

import io.qameta.allure.Step;
import pojo.Playlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertPlaylist {

    @Step
    public static void assertPlaylist(Playlist playListRsp, Playlist playListReq){
        assertThat(playListRsp.getName(),equalTo(playListReq.getName()));
        assertThat(playListRsp.getDescription(), equalTo(playListReq.getDescription()));
        assertThat(playListRsp.get_public(), equalTo(playListReq.get_public()));
    }

    @Step
    public static void assertGetPlaylist(Playlist playlistRsp,String playlistId){
        assertThat(playlistRsp.getId(),equalTo(playlistId));
    }
}
