package com.ecomm45.ecom8600.serviceImpl;

import com.ecomm45.ecom8600.dto.Request.CreateOrderRequest;
import com.ecomm45.ecom8600.dto.Response.OrderResponse;
import com.ecomm45.ecom8600.entity.*;
import com.ecomm45.ecom8600.enums.Status;
import com.ecomm45.ecom8600.repository.*;
import com.ecomm45.ecom8600.service.OrderService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Data
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final CartItemsRepository cartItemsRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderResponse createOrder(String email, CreateOrderRequest request) {
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Customer with email " + email + " not found"));

        Cart cart = cartRepository.findByCustomer(customer).orElseThrow(() -> new RuntimeException("Cart not found"));

        if(cart.getCartItems().isEmpty()){
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());
        order.setCustomer(cart.getCustomer());
        order.setCustomerName(cart.getCustomer().getFirstName() + " " + cart.getCustomer().getLastName());
        order.setCustomerEmail(cart.getCustomer().getEmail());
        order.setCustomerPhone(cart.getCustomer().getPhone());
        order.setCustomerAddress(cart.getCustomer().getAddress());
        order.setOrderStatus(Status.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        BigDecimal totalPrice = BigDecimal.ZERO;

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItems cartItems : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrders(order);
            orderItem.setProductId(cartItems.getProduct().getId());
            orderItem.setQuantity(cartItems.getQuantity());
            orderItem.setItemName(cartItems.getProduct().getProductName());
            orderItem.setPrice(cartItems.getProduct().getPrice());

            totalPrice = totalPrice.add(cartItems.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItems.getQuantity())));

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(order);

        cart.getCartItems().clear();
        cart.setSubtotal(BigDecimal.ZERO);

        cartRepository.save(cart);

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setOrderId(savedOrder.getId());
        orderResponse.setTotalPrice(savedOrder.getTotalPrice());


        List<Long> productIds = new ArrayList<>();
        List<String> productNames = new ArrayList<>();

        for (OrderItem orderItem : savedOrder.getOrderItems()) {
            productIds.add(orderItem.getProductId());
            productNames.add(orderItem.getItemName());
        }

        orderResponse.setProductIds(productIds);
        orderResponse.setProductNames(productNames);

        return orderResponse;
    }

    @Override
    public OrderResponse findById(Long customerId, Long OrderId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer with id " + customerId + " not found"));

        Order order = orderRepository.findById(OrderId).orElseThrow(() -> new RuntimeException("Order with id " + OrderId + " not found"));

        if (!order.getCustomer().getId().equals(customer.getId())) {
            throw new RuntimeException("Customer with id " + customerId + " not found");
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setOrderId(order.getId());

        BigDecimal totalPrice = BigDecimal.ZERO;
        List<Long> productIds = new ArrayList<>();
        List<String> productNames = new ArrayList<>();

        for (OrderItem orderItem : order.getOrderItems()) {
            totalPrice = totalPrice.add(orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));

            productIds.add(orderItem.getProductId());
            productNames.add(orderItem.getItemName());
        }

        orderResponse.setTotalPrice(totalPrice);
        orderResponse.setProductIds(productIds);
        orderResponse.setProductNames(productNames);

        return orderResponse;
    }
}
