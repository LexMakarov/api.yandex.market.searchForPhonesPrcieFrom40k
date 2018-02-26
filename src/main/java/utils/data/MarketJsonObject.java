package utils.data;

import org.json.simple.JSONObject;
import utils.api.Authorization;

public class MarketJsonObject {


    public static String generateJSONForLogin() {
        JSONObject authData = new JSONObject();
        authData.put("username", Authorization.username);
        authData.put("password", Authorization.password);

        return authData.toJSONString();
    }

}