package sushil.test.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="industry")
public class Industry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long industryId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "industry_type")
    private String industryType;

//    @OneToMany(mappedBy = "industry", cascade = CascadeType.PERSIST, orphanRemoval = false, fetch = FetchType.LAZY)
//    private Set<Customer> customerList = new HashSet<>();
}
