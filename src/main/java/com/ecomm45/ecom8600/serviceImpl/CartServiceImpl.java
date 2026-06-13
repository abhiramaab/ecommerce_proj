package com.ecomm45.ecom8600.serviceImpl;

import com.ecomm45.ecom8600.dto.Request.AddToCartRequest;
import com.ecomm45.ecom8600.dto.Response.CartResponse;
import com.ecomm45.ecom8600.dto.Response.CustomerResponse;
import com.ecomm45.ecom8600.entity.Cart;
import com.ecomm45.ecom8600.entity.CartItems;
import com.ecomm45.ecom8600.entity.Customer;
import com.ecomm45.ecom8600.entity.Product;
import com.ecomm45.ecom8600.repository.*;
import com.ecomm45.ecom8600.service.CartService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
@Data
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CartItemsRepository cartItemsRepository;

        @Override
        public CartResponse createCart(Long customerId) {
            Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));

            if (cartRepository.findByCustomer(customer).isPresent()) {
                throw new RuntimeException("Cart already exists");
            }

            Cart cart = new Cart();
            cart.setCustomer(customer);
            cart.setSubtotal(new BigDecimal("0.00"));
            cart.setCartItems(new ArrayList<>());

            Cart savedCart = cartRepository.save(cart);

            CartResponse cartResponse = new CartResponse();
            cartResponse.setCartId(savedCart.getId());
            cartResponse.setCartItems(savedCart.getCartItems());
            cartResponse.setTotalItems(savedCart.getCartItems().size());
            cartResponse.setSubTotalPrice(savedCart.getSubtotal());
            return cartResponse;
        }

    @Override
    public CartResponse getCart(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer Not Found"));

        Cart cart = cartRepository.findByCustomer(customer).orElseThrow(() -> new RuntimeException("Cart Not Found"));

        CartResponse cartResponse = new CartResponse();
        cartResponse.setTotalItems(cart.getCartItems().size());
        cartResponse.setCartItems(cart.getCartItems());
        cartResponse.setCartId(cart.getId());
        cartResponse.setSubTotalPrice(cart.getSubtotal());
        return cartResponse;

    }

    @Override
    public CartResponse addToCart(Long customerId, AddToCartRequest request) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        Cart cart = cartRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Cart Not Found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        CartItems cartItem = new CartItems();

        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setItemPrice(product.getPrice());
        cartItem.setQuantity(request.getQuantity());

        BigDecimal subTotal =
                product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));

        cartItem.setSubTotal(subTotal);

        cartItemsRepository.save(cartItem);

        cart.getCartItems().add(cartItem);

        BigDecimal total = BigDecimal.ZERO;

        for (CartItems item : cart.getCartItems()) {
            total = total.add(item.getSubTotal());
        }

        cart.setSubtotal(total);

        cartRepository.save(cart);

        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cart.getId());
        cartResponse.setCartItems(cart.getCartItems());
        cartResponse.setTotalItems(cart.getCartItems().size());
        cartResponse.setSubTotalPrice(cart.getSubtotal());

        return cartResponse;
    }

    @Override
    public void removeCartItem(Long customerId, Long cartItemId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        Cart cart = cartRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Cart Not Found"));

        CartItems cartItem = cartItemsRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart Item Not Found"));

        cart.getCartItems().remove(cartItem);

        BigDecimal total = BigDecimal.ZERO;

        for (CartItems item : cart.getCartItems()) {
            total = total.add(item.getSubTotal());
        }

        cart.setSubtotal(total);

        cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        Cart cart = cartRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Cart Not Found"));

        cart.getCartItems().clear();

        cart.setSubtotal(BigDecimal.ZERO);

        cartRepository.save(cart);
    }
}
