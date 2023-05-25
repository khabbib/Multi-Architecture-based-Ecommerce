package com.example.CartsService.controller;


import com.example.CartsService.model.Cart;
import com.example.CartsService.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /**
     * Hämtar alla carts i databasen
     * @return en lista på alla carts.
     */
    @GetMapping("/") //Get all carts
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<List<Cart>> getAvailableCarts(){
        return cartService.getAvailableCarts();
    }

    /**
     * Hämta en specifik cart från databasen
     * @param id cart id
     * @return cart objektet
     *
     * Exempel request i postman:
     * localhost:8080/carts-service/cart/cartById?id=gadhf34g1j234gf
     */
    @GetMapping("/cartById{id}") //Get specific cart
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<Cart> getCartById(@PathVariable("id") String id){
        return cartService.getCartById(id);
    }


    /**
     * Skapa en ny cart i databasen.
     * @param cart objekt i json format.
     * @return id på carten som skapats.
     *
     * Exempel request i postman:
     * {
     *     "cartId": 3.0,
     *     "customerId": 3.0,
     *     "orderId": 3.0
     * }
     */
    @PostMapping("/create") //Create a new cart
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> createNewCart(@RequestBody Cart cart){
        return cartService.createNewCart(cart);
    }

    /**
     * Lägg till en produkt i kundvagnen. Funktionen kollar så att produkten är tillgänglig innan den läggs till.
     * @param cid cart id på kundvagnen.
     * @param pid product id på produkten att lägga till.
     * @return productId som las till i kundvagnen.
     */
    @PostMapping("/addToCart{cartId}{productId}") //Put item into cart.
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addItemToCart(@PathVariable("cid") String cid, @PathVariable("pid") String pid){
        return cartService.addItemToCart(cid, pid);
    }

    @DeleteMapping("/{id}") //Remove item from cart.
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<Cart> removeItemFromCart(@RequestParam String cartId, @RequestParam String productId){
        return cartService.removeItemFromCart(cartId, productId);
    }
}
