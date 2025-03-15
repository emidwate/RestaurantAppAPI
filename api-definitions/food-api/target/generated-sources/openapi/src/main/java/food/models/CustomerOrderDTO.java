package food.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CustomerOrderDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-15T20:34:40.824180900+01:00[Europe/Berlin]", comments = "Generator version: 7.8.0")
public class CustomerOrderDTO {

  private Long customerOrderId;

  private String name;

  private BigDecimal price;

  private Long foodId;

  public CustomerOrderDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CustomerOrderDTO(Long customerOrderId, String name, BigDecimal price, Long foodId) {
    this.customerOrderId = customerOrderId;
    this.name = name;
    this.price = price;
    this.foodId = foodId;
  }

  public CustomerOrderDTO customerOrderId(Long customerOrderId) {
    this.customerOrderId = customerOrderId;
    return this;
  }

  /**
   * Get customerOrderId
   * @return customerOrderId
   */
  @NotNull 
  @Schema(name = "customerOrderId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerOrderId")
  public Long getCustomerOrderId() {
    return customerOrderId;
  }

  public void setCustomerOrderId(Long customerOrderId) {
    this.customerOrderId = customerOrderId;
  }

  public CustomerOrderDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerOrderDTO price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * minimum: 0
   * @return price
   */
  @NotNull @Valid @DecimalMin("0") 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public CustomerOrderDTO foodId(Long foodId) {
    this.foodId = foodId;
    return this;
  }

  /**
   * Get foodId
   * @return foodId
   */
  @NotNull 
  @Schema(name = "foodId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("foodId")
  public Long getFoodId() {
    return foodId;
  }

  public void setFoodId(Long foodId) {
    this.foodId = foodId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerOrderDTO customerOrderDTO = (CustomerOrderDTO) o;
    return Objects.equals(this.customerOrderId, customerOrderDTO.customerOrderId) &&
        Objects.equals(this.name, customerOrderDTO.name) &&
        Objects.equals(this.price, customerOrderDTO.price) &&
        Objects.equals(this.foodId, customerOrderDTO.foodId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerOrderId, name, price, foodId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerOrderDTO {\n");
    sb.append("    customerOrderId: ").append(toIndentedString(customerOrderId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    foodId: ").append(toIndentedString(foodId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

