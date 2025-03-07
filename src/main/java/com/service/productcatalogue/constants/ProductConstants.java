package com.service.productcatalogue.constants;

/**
 * This class holds the HTTP Status and return Message
 *
 */
public class ProductConstants {

    private ProductConstants(){
        //restrict instantiation
    }

    public static final String  STATUS_201 = "201";
    public static final String  MESSAGE_201 = "Product added successfully";
    public static final String  STATUS_200 = "200";
    public static final String  MESSAGE_200 = "Request processed successfully";
    public static final String  STATUS_417 = "417";
    public static final String  MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact help team";
    public static final String  MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact help team";
    public static final String  STATUS_500 = "500";
    public static final String  MESSAGE_500= "Product not found. Please try again or contact help team";

}
