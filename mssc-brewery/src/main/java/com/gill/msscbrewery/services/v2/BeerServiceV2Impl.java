package com.gill.msscbrewery.services.v2;

import com.gill.msscbrewery.web.model.BeerDto;
import com.gill.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.gill.msscbrewery.web.model.v2.BeerStyleEnum.PISLSNER;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2{

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(PISLSNER)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .build();
    }

    @Override
    public BeerDtoV2 updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(beerId)
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .build();
    }

    @Override
    public void deleteById(UUID beerId) {
        log.info("Deleting a beer..." + beerId);
    }
}
