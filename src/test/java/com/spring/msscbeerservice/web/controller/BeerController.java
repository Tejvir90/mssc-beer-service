package com.spring.msscbeerservice.web.controller;

import com.spring.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/vi1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {

        //TODO: IMPL
        return new ResponseEntity<>(BeerDto.builder().build(), OK);
    }


    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {

        //TODO: IMPL
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity  updateBeer(@PathVariable UUID uuid ,@RequestBody BeerDto beerDto){

        //TODO: IMPL
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public void deleteBeerByID(@PathVariable UUID uuid){
        //TODO: IMPL
    }


}
