package com.cpe.backend.Carreturn.Entity;
import com.cpe.backend.FileSharing.Entity.Employee;
import com.cpe.backend.RentCar.Entity.RentCar;


import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Entity
@NoArgsConstructor
@Table(name="RETURNSCAR")
public class ReturnsCar {

    @Id
    @SequenceGenerator(name="returnscar_seq",sequenceName="returnscar_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="returnscar_seq")
    @Column(name = "RETURNSCAR_ID", unique = true, nullable = true)
    private Long id;
   
    @Column(name="RETURNDATE")
    private @NotNull LocalDateTime returndate;

    @Column(name="ANNOTATION")
    @Size(max = 68 , message = "error")
    private @NotNull String note;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private Employee createdby;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = RentCar.class)
    @JoinColumn(name = "RENT_CAR_ID", insertable = true)
    private RentCar rents;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Payforfine.class)
    @JoinColumn(name = "PAYFORFINE_ID", insertable = true)
    private Payforfine pays;
}