package com.example.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A address
 */
@ApiModel(description = "A address")

public class AddressObject  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("city")
  private String city;

  @JsonProperty("state")
  private String state;

  @JsonProperty("line1")
  private String line1;

  @JsonProperty("line2")
  private String line2;

  @JsonProperty("line3")
  private String line3;

  public AddressObject city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  @ApiModelProperty(example = "Fremont", required = true, value = "")
  @NotNull

@Size(min=5,max=20) 
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public AddressObject state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  */
  @ApiModelProperty(example = "CA", required = true, value = "")
  @NotNull

@Size(min=2,max=20) 
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AddressObject line1(String line1) {
    this.line1 = line1;
    return this;
  }

  /**
   * Get line1
   * @return line1
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(min=5,max=20) 
  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public AddressObject line2(String line2) {
    this.line2 = line2;
    return this;
  }

  /**
   * Get line2
   * @return line2
  */
  @ApiModelProperty(value = "")

@Size(min=5,max=20) 
  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public AddressObject line3(String line3) {
    this.line3 = line3;
    return this;
  }

  /**
   * Get line3
   * @return line3
  */
  @ApiModelProperty(value = "")

@Size(min=5,max=20) 
  public String getLine3() {
    return line3;
  }

  public void setLine3(String line3) {
    this.line3 = line3;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressObject addressObject = (AddressObject) o;
    return Objects.equals(this.city, addressObject.city) &&
        Objects.equals(this.state, addressObject.state) &&
        Objects.equals(this.line1, addressObject.line1) &&
        Objects.equals(this.line2, addressObject.line2) &&
        Objects.equals(this.line3, addressObject.line3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, state, line1, line2, line3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressObject {\n");
    
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
    sb.append("    line3: ").append(toIndentedString(line3)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

