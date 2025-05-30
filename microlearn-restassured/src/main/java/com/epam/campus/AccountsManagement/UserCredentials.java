package com.epam.campus.AccountsManagement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCredentials {

    private String login;
    private String email;
    private String password;
    private String langKey;

}
