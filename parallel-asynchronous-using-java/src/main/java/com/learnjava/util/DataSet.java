package com.learnjava.util;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DataSet {

    public static Cart createCart(int noOfItemsInCart) {
        Cart cart = new Cart();
        List<CartItem> cartItemList = new ArrayList<>();
        IntStream.rangeClosed(1, noOfItemsInCart)
                .forEach(index -> {
                    String cartItem = "CartItem-".concat(index + "");
                    CartItem cartItem1 = new CartItem(index, cartItem, generatedRandomPrice(), index, false);
                    cartItemList.add(cartItem1);
                });
        cart.setCartItemList(cartItemList);
        return cart;
    }

    public static double generatedRandomPrice() {
        int min = 50;
        int max = 100;
        return Math.random() * (max - min + 1) + min;
    }

    public static List<String> namesList(){
        return List.of("Bob", "Jamie", "Jill", "Rick");

    }
}
