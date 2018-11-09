package com.example.api.models;

import java.util.Objects;
import com.example.api.models.AddressObject;
import com.example.api.models.PersonObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A family
 */
@ApiModel(description = "A family")

public class FamilyObject  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private String id;

  @JsonProperty("address")
  private AddressObject address = null;

  @JsonProperty("members")
  @Valid
  private List<PersonObject> members = new ArrayList<>();

  public FamilyObject id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(min=5,max=20) 
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FamilyObject address(AddressObject address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AddressObject getAddress() {
    return address;
  }

  public void setAddress(AddressObject address) {
    this.address = address;
  }

  public FamilyObject members(List<PersonObject> members) {
    this.members = members;
    return this;
  }

  public FamilyObject addMembersItem(PersonObject membersItem) {
    this.members.add(membersItem);
    return this;
  }

  /**
   * Get members
   * @return members
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<PersonObject> getMembers() {
    return members;
  }

  public void setMembers(List<PersonObject> members) {
    this.members = members;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FamilyObject familyObject = (FamilyObject) o;
    return Objects.equals(this.id, familyObject.id) &&
        Objects.equals(this.address, familyObject.address) &&
        Objects.equals(this.members, familyObject.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, members);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FamilyObject {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
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

