package constants;

import io.restassured.config.Config;

public interface PlaylistConstants extends Config {

    String CREATE_PLAYLIST = "/users/{userid}/playlists";
    String GET_PLAYLIST = "/playlists/{playlistId}";
    String UPDATE_PLAYLIST = "/playlists/{playlistId}";
}
