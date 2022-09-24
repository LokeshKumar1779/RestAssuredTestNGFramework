package helper;

import io.qameta.allure.Step;
import pojo.Playlist;


public class PlaylistHelper {


    @Step
    public static Playlist createPlayList(String playlistName,String playListDesc,boolean publicValue){
        // Without builder pattern
//        Playlist playlist = new Playlist();
//        playlist.setName(playlistName);
//        playlist.setDescription(playListDesc);
//        playlist.set_public(publicValue);
//        return playlist;
//        with builder pattern
        return Playlist.builder().name(playlistName).description(playListDesc)._public(publicValue).build();

    }

    public static Playlist updatePlayList(String updatedPlaylistName,String playListDesc,boolean publicValue){
      /*  Playlist playlist = new Playlist();
        playlist.setName(updatedPlaylistName);
        playlist.setDescription(playListDesc);
        playlist.set_public(publicValue);
        return playlist;
        */
        return Playlist.builder().name(updatedPlaylistName).description(playListDesc)._public(publicValue).build();

    }

    public static Playlist createPlayListWithOutName(String playlistName,String playListDesc,boolean publicValue){
     /*   Playlist playlist = new Playlist();
        playlist.setName(playlistName);
        playlist.setDescription(playListDesc);
        playlist.set_public(publicValue);
        return playlist;*/
        return Playlist.builder().name(playlistName).description(playListDesc)._public(publicValue).build();

    }

}
