package search;

import utils.api.APIPathes;
import utils.data.MarketPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import pojo.searchAttribute.PhoneSearch;
import utils.api.Authorization;

import static io.restassured.RestAssured.given;

public class SearchVendorPhonesWithPOJOTest {


  @Test
  public void searchPhonesTest() {
    ValidatableResponse response;

    Integer valueOfMinPrice = 40000;
    String minPrice = "pricefrom=";
    String phonesCategory = "hid=91491";

    /* test data and parameters */
    String vendorName = "Samsung";

    PhoneSearch marketPOJOObj = MarketPojo.generateJSONForPhoneSearch(vendorName);

    response = given().
        header("Content-Type", ContentType.JSON).
        header("Cookie", "JSESSIONID=" + Authorization.JSESSIONID).
        body(marketPOJOObj).
        when().
        get(APIPathes.searchPath+"?"+phonesCategory+"&"+minPrice+valueOfMinPrice). //страшно, знаю, но по-другому придумать не смог :)
        then().
        statusCode(200).contentType(ContentType.JSON);

    String responseBody = response.extract().asString();
    System.out.printf("\nRESPONSE: " + responseBody);

    //String arrayPhones = response.extract().path("значение"); //тут можно было бы извлечь массив, но я так и не нашел способа..

  }
}
