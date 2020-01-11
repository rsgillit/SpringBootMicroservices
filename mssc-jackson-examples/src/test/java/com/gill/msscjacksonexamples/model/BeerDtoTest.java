package com.gill.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeSerializeDto() throws JsonProcessingException {
        String json = "{\"id\":\"ecae7a06-bef3-4f42-9ca1-ec934a5f1145\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":123123123123,\"price\":12.99,\"createDate\":\"2020-01-11T15:09:18.463704-06:00\",\"lastModifiedDate\":\"2020-01-11T15:09:18.464312-06:00\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }

}
