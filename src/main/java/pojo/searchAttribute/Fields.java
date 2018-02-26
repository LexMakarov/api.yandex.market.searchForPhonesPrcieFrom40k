package pojo.searchAttribute;

import pojo.Pojo;

public class Fields implements Pojo {

  public Vendor vendor;

  public Fields() {
  }

  public Fields setVendor(String vendorName) {
    this.vendor = new Vendor(vendorName);
    return this;
  }

}
