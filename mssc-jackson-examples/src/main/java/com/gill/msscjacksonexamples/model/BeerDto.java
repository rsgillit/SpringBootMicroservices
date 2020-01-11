package com.gill.msscjacksonexamples.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @JsonProperty("beerId")
    @Null
    private UUID id;


    @NotBlank
    private String beerName;

    @NotNull
    private String beerStyle;

    @NotNull
    private Long upc;


    private BigDecimal price;

    private OffsetDateTime createDate;


    private OffsetDateTime lastModifiedDate;

}
