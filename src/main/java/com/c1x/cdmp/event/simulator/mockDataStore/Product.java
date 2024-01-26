package com.c1x.cdmp.event.simulator.mockDataStore;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    String brand;
    int hasMultiSalesPrice;
    String hasSpecialPrice;
    int productCode;
    String imageURL;
    String linkURL;
    String name;
    int numReviews;
    int price;
    int quantity;
    double rating;
    int taxPrice;
    double taxRate;
    int taxRateType;

    @Override
    public String toString() {
        return "{" +
                "brand:'" + brand + '\'' +
                ", hasMultiSalesPrice:" + hasMultiSalesPrice +
                ", hasSpecialPrice:'" + hasSpecialPrice + '\'' +
                ", productCode:" + productCode +
                ", imageURL:'" + imageURL + '\'' +
                ", linkURL:'" + linkURL + '\'' +
                ", name:'" + name + '\'' +
                ", numReviews:" + numReviews +
                ", price:" + price +
                ", quantity:" + quantity +
                ", rating:" + rating +
                ", taxPrice:" + taxPrice +
                ", taxRate:" + taxRate +
                ", taxRateType:" + taxRateType +
                '}';
    }
}

