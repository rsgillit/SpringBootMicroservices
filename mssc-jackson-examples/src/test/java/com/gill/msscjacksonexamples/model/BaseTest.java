package com.gill.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    BeerDto getDto() {
        return BeerDto.builder()
                .beerName("BeerName")
                .beerStyle("ALE")
                .id(UUID.randomUUID())
                .createDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(123123123123L)
                .build();
    }
}
