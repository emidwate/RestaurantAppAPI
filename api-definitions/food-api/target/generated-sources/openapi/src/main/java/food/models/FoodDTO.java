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
 * FoodDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-15T20:34:40.824180900+01:00[Europe/Berlin]", comments = "Generator version: 7.8.0")
public class FoodDTO {

  private Long id;

  private String name;

  private String ingredients;

  private BigDecimal price;

  private String emoji;

  public FoodDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FoodDTO(Long id, String name, String ingredients, BigDecimal price, String emoji) {
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
    this.price = price;
    this.emoji = emoji;
  }

  public FoodDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FoodDTO name(String name) {
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

  public FoodDTO ingredients(String ingredients) {
    this.ingredients = ingredients;
    return this;
  }

  /**
   * Get ingredients
   * @return ingredients
   */
  @NotNull 
  @Schema(name = "ingredients", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ingredients")
  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public FoodDTO price(BigDecimal price) {
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

  public FoodDTO emoji(String emoji) {
    this.emoji = emoji;
    return this;
  }

  /**
   * Get emoji
   * @return emoji
   */
  @NotNull 
  @Schema(name = "emoji", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("emoji")
  public String getEmoji() {
    return emoji;
  }

  public void setEmoji(String emoji) {
    this.emoji = emoji;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodDTO foodDTO = (FoodDTO) o;
    return Objects.equals(this.id, foodDTO.id) &&
        Objects.equals(this.name, foodDTO.name) &&
        Objects.equals(this.ingredients, foodDTO.ingredients) &&
        Objects.equals(this.price, foodDTO.price) &&
        Objects.equals(this.emoji, foodDTO.emoji);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, ingredients, price, emoji);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    emoji: ").append(toIndentedString(emoji)).append("\n");
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

