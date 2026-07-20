package com.coderbyte.workspace;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderbyte.workspace.item.CartItem;
import com.coderbyte.workspace.service.CartService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
public class WorkspaceApplication {

	@RestController
	@RequestMapping("/api/cart")
	public class CartController {

		private final CartService cartService;

		public CartController(CartService cartService) {
			this.cartService = cartService;
		}

		@GetMapping
		public Collection<CartItem> getAllItems() {
			// list all items in the cart
			return cartService.getAllItems();
		}

		@PostMapping
		public void addItem(@RequestBody CartItem item) {
			// add an item to the cart
			cartService.addItem(item);
		}

		@DeleteMapping("/{id}")
		public void removeItem(@PathVariable String id) {
			// remove an item from the cart by its id
			cartService.removeItem(id);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceApplication.class, args);
	}

}