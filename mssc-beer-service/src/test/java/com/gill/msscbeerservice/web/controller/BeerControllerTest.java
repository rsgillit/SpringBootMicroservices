package com.gill.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gill.msscbeerservice.services.BeerService;
import com.gill.msscbeerservice.web.model.BeerDto;
import com.gill.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/{beerId}" , UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//        mockMvc.perform(get("/api/v1/beer/{beerId}" , UUID.randomUUID().toString())
//                .param("iscold", "yes")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(document("v1/beer",
//                        pathParameters(
//                                parameterWithName("beerId").description("UUID of desired beer to get")
//                        ),
//                        requestParameters(
//                                parameterWithName("iscold").description("Is Beer Cold Query param")
//
//                        ),
//                        responseFields(
//                                fieldWithPath("id").description("Id of Beer"),
//                                fieldWithPath("version").description("Version Number"),
//                                fieldWithPath("createDate").description("Date Created"),
//                                fieldWithPath("lastModifiedDate").description("Date Updated"),
//                                fieldWithPath("beerName").description("Beer Name"),
//                                fieldWithPath("beerStyle").description("Beer Style"),
//                                fieldWithPath("upc").description("UPC of Beer"),
//                                fieldWithPath("price").description("Price"),
//                                fieldWithPath("quantityOnHand").description("Quantity on Hand")
//                        )));
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        beerDto.setUpc("2342342");
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/" )
         .contentType(MediaType.APPLICATION_JSON)
         .content(beerDtoJson))
         .andExpect(status().isCreated())
        .andDo(document("v1/beer",
                requestFields(
                        fieldWithPath("id").ignored(),
                        fieldWithPath("version").ignored(),
                        fieldWithPath("createDate").ignored(),
                        fieldWithPath("lastModifiedDate").ignored(),
                        fieldWithPath("beerName").description("Beer Name"),
                        fieldWithPath("beerStyle").description("Beer Style"),
                        fieldWithPath("upc").description("UPC of Beer"),
                        fieldWithPath("price").description("Price"),
                        fieldWithPath("quantityOnHand").ignored()
                )));
    }

    @Test
    void updateBeerById() throws Exception {

        BeerDto beerDto = getValidBeerDto();
        beerDto.setUpc("5463456");
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

    }

    BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal(2.99))
                //.upc("test")
                .build();
    }
}
