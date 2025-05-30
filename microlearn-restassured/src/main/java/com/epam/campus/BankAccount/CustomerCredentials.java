package com.epam.campus.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCredentials {

    private String id;
    private String name;
    private int balance;
    private User user;


}
