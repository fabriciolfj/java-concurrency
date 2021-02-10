package com.learnjava.parallelstreams;

import com.learnjava.domain.checkout.Cart;
import com.learnjava.domain.checkout.CheckoutResponse;
import com.learnjava.domain.checkout.CheckoutStatus;
import com.learnjava.service.CheckoutService;
import com.learnjava.service.PriceValidatorService;
import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutServiceTest {

    private PriceValidatorService priceValidatorService = new PriceValidatorService();
    private CheckoutService checkoutService = new CheckoutService(priceValidatorService);

    @Test
    void no_of_cores() {
        System.out.println("no of cores: " + Runtime.getRuntime().availableProcessors());
    }

    @Test
    void checkout_6_items() {
        Cart cart = DataSet.createCart(6);

        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);

        assertEquals(CheckoutStatus.SUCCESS, checkoutResponse.getCheckoutStatus());
    }

    @Test
    void checkout_13_items() {
        Cart cart = DataSet.createCart(13);

        CheckoutResponse checkoutResponse = checkoutService.checkout(cart);

        assertEquals(CheckoutStatus.FAILURE, checkoutResponse.getCheckoutStatus());
    }
}
