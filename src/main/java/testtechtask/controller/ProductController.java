package testtechtask.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testtechtask.dto.product.CreateProductRecordRequest;
import testtechtask.dto.product.ProductDto;
import testtechtask.service.product.ProductService;

@Tag(name = "Type management", description = "Endpoints for managing types")
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService productService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/all")
    @Operation(summary = "Get all types with records",
            description = "Get a list of all available types with records")
    public List<ProductDto> findAll() {
        return productService.getAll();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/add")
    @Operation(summary = "Save record to repository",
            description = "Save valid record to repository")
    public ProductDto save(@RequestBody @Valid CreateProductRecordRequest request) {
        return productService.save(request);
    }
}
