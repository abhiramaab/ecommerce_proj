package com.ecomm45.ecom8600.dto.Request;

import com.ecomm45.ecom8600.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateOrderRequest {

   private String customerEmail;
   private Long cartId;
}
