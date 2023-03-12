package com.olakunle.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    private String productName;
    private UUID ISBN;  // TODO: Make this look like the normal ISBN
    private BigDecimal price;
    private String productCompany;
    private LocalDateTime purchasedDate;
}
