/*
 * package com.example.petstore.controller;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.mockito.Mockito; import
 * org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity;
 * 
 * import com.example.petstore.dto.OrderRequest; import
 * com.example.petstore.dto.OrderResponse; import
 * com.example.petstore.dto.PetResponseDto; import
 * com.example.petstore.service.OrderService;
 * 
 * @ExtendWith(MockitoExtension.class) public class OrderController {
 * 
 * @InjectMocks OrderController orderController;
 * 
 * 
 * 
 * @Mock OrderService orderService;
 * 
 * @Test public void bookingDetails() { OrderRequest orderRequest = new
 * OrderRequest();
 * 
 * orderRequest.setPetId(1);
 * 
 * OrderResponse orderResponse = new OrderResponse();
 * 
 * 
 * 
 * Mockito.when(orderService.orderPetsByPetId(1, 1)).thenReturn(orderResponse);
 * 
 * 
 * 
 * ResponseEntity<OrderResponse> responsebusdetailsdto = orderController.;
 * assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * } }
 */