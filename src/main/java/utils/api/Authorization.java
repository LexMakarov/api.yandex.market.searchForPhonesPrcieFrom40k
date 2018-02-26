package utils.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import utils.data.MarketJsonObject;

import static io.restassured.RestAssured.given;

public class Authorization {

  /*
  * На самом деле я так и не дождался ключа от Яндекса, хотя запрос отправлял несколько дней назад.
  * По этой причине, авторизация без отладки.
  * */

  public static String JSESSIONID;
  public static String BASE_URI = "https://api.content.market.yandex.ru";
  public static String username = "AlekseyMakarov";
  public static String password = "";
  static final Logger logger = Logger.getLogger(Authorization.class);

  public static void loginToMarket() {
    RestAssured.baseURI = BASE_URI;

    String loginJson = MarketJsonObject.generateJSONForLogin();
    JSESSIONID =
        given().
            header("Content-Type", ContentType.JSON).
            body(loginJson).
            when().
            post(APIPathes.login).
            then().
            statusCode(200).contentType(ContentType.JSON).
            extract().
            path("session.value");

    logger.info("\nAUTHORIZATION TOKEN: " + Authorization.JSESSIONID);
  }
}
