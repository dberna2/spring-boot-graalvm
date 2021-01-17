package com.example.graalvm.springbootgraalvm.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Entity
@Table(name = "INVOICES")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    protected Long id;

    @Column(name="CREATION_DATE")
    private LocalDate creationDate;

    @JsonManagedReference
    @OneToMany(mappedBy="invoice", fetch = FetchType.EAGER)
    private List<Item> items;
}
