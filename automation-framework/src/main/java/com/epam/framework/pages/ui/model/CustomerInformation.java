package com.epam.framework.pages.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInformation {
   private String firstName;
   private String lastName;
   private String postalCode;

}
