package applicationApi;

import io.restassured.response.Response;
import utils.ConfigLoader;

import java.time.Instant;
import java.util.HashMap;

import static applicationApi.RestResource.postAccount;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken(){
        try {
            if (expiry_time == null || Instant.now().isAfter(expiry_time)) {
                System.out.println("Renewing token...");
                Response response = renew_token();
                access_token = response.path("access_token");
                int expiry_duration = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiry_duration - 300);
            } else {
                System.out.println("Token is good to use");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ABORT!! Renew Token Failed");
        }
        return access_token;

    }

    private static Response renew_token(){

        HashMap<String,String> form_params = new HashMap<>();
        form_params.put("grant_type", ConfigLoader.getInstance().getGrantType());
        form_params.put("refresh_token",ConfigLoader.getInstance().getRefreshToken());
        form_params.put("client_id",ConfigLoader.getInstance().getClientId());
        form_params.put("client_secret",ConfigLoader.getInstance().getClientSecret());

        Response response = postAccount(form_params);

        if (response.statusCode() != 200){
            throw new RuntimeException("ABORT!! Renew Token Failed");
        }
        return response;
    }
}
