package utils.data;

import pojo.searchAttribute.Fields;
import pojo.searchAttribute.PhoneSearch;

public class MarketPojo {

  public static PhoneSearch generateJSONForPhoneSearch(String vendorName) { //String projectId, String summary, String issueType, String assignee,

    PhoneSearch marketPOJOObj = new PhoneSearch(new Fields()

        .setVendor(vendorName)

    );
    return marketPOJOObj;
  }
}