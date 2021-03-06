package com.spring.msscbeerservice.web.controller;

import com.spring.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {

        //TODO: IMPL
        return new ResponseEntity<>(BeerDto.builder().id(beerId).build(), OK);
    }


    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {

        //TODO: IMPL
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {

        //TODO: IMPL
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteBeerByID(@PathVariable UUID beerId) {
        //TODO: IMPL
    }


}
