package sushil.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 20, message = "Customer name must be between 3-20 characters")
    private String name;

    @Column(name = "email", nullable = false)
    @Email(message = "Please provide a valid email")
    private String email;


    @Column(name = "phone")
    @NotNull
    @Size(min = 10, max = 12, message = "Customer Phone must be between 10-12 characters")
    private String phone;

    @Column(name= "address")
    @NotNull
    @Size(min = 5, max = 512, message = "Customer Address must be between 5-512 characters")
    private String address;


    @Column(name = "customer_status")
    private String customerStatus;

    @Column(name = "account_manager")
    private String accountManager;

    @Column(name="audit")
    private String audit;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "industry_type")
    private String industryType;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "industry_id")
//    private Industry industryDetail;;

}
