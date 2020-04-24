package com.example.orderservice.resources;

import com.example.orderservice.dto.commands.OrderCreateDTO;
import com.example.orderservice.services.commands.OrderCommandService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping(value = "/api/orders")
@Api(value = "Order Commands", description = "Order Commands Related Endpoints", tags = "Order Commands")
public class OrderCommandResource {

    private final OrderCommandService orderCommandService;

    public OrderCommandResource(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }


    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
        return orderCommandService.createOrder(orderCreateDTO);
    }
}
