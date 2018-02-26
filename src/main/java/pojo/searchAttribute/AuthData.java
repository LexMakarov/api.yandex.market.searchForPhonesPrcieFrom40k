package pojo.searchAttribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import pojo.Pojo;

public class AuthData implements Pojo {

  @JsonProperty("username") //для возможности использовать CamelCase
  public String userName;
  public String password;

  public AuthData(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }
}
