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
     * localhost:8080/carts-service/cart/cartById/:id
     */
    @GetMapping("/cartById/{id}") //Get specific cart
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
     *     "cartId": 5.0,
     *     "customerId": 5.0,
     *     "orderId": 5.0,
     *     "productList": {
     *         "productId1": "1",
     *         "productId2": "2",
     *         "productId3": "1"
     *     }
     * }
     */
    @PostMapping("/create") //Create a new cart
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> createNewCart(@RequestBody Cart cart){
        return cartService.createNewCart(cart);
    }

    /**
     * Lägg till en produkt i kundvagnen. Funktionen kollar så att produkten är tillgänglig innan den läggs till.
     * @param cartId cart id på kundvagnen.
     * @param productId product id på produkten att lägga till.
     * @return productId som las till i kundvagnen.
     */
    @PostMapping("/addToCart{cartId}{productId}") //Put item into cart.
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addItemToCart(@RequestParam("cartId") String cartId, @RequestParam("productId") String productId){
        return cartService.addItemToCart(cartId, productId);
    }

    @DeleteMapping("/removeFromCart{cartId}{productId}") //Remove item from cart.
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> removeItemFromCart(@RequestParam("cartId") String cartId, @RequestParam("productId") String productId){
        return cartService.removeItemFromCart(cartId, productId);
    }

    @DeleteMapping("/deleteCart{cartId}") //Delete a whole cart.
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCart(@RequestParam("cartId") String cartId){
        return cartService.deleteExistingCart(cartId);
    }
}
