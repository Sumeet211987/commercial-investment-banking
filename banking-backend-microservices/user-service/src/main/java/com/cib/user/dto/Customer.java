package com.cib.user.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String userName;
    private String emailId;
    private Integer phoneNumber;
    private Integer identityNumber;
    private String address;
    private String password;
    private boolean active; 

}
