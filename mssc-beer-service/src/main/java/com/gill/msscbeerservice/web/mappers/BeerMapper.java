package com.gill.msscbeerservice.web.mappers;

import com.gill.msscbeerservice.domain.Beer;
import com.gill.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDto beerDto);
    BeerDto beerToBeerDto(Beer beer);
}
