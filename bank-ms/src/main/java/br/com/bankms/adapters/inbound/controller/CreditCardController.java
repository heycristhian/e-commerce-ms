package br.com.bankms.adapters.inbound.controller;

import br.com.bankms.adapters.inbound.dto.request.CreditCardRequest;
import br.com.bankms.adapters.mapper.CreditCardMapper;
import br.com.bankms.application.entity.CreditCard;
import br.com.bankms.application.ports.service.CreditCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/creditCards")
public class CreditCardController {

    @Autowired
    private CreditCardService service;


    @PostMapping("/buy/{value}")
    public ResponseEntity<Void> buy(@RequestBody @Valid CreditCardRequest request, @PathVariable BigDecimal value) {
        log.info("Starting the purchase process");
        CreditCard creditCard = CreditCardMapper.INSTANCE.toEntity(request);
        service.buy(creditCard, value);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
