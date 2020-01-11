package com.gill.msscbeerservice.services;

import com.gill.msscbeerservice.web.model.BeerDto;

import java.util.UUID;


public interface BeerService {

    BeerDto getById(UUID beerId) ;

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);
}
