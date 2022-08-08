package com.armaan.SpringDatasource.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "test_user")
public class TestUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_no")
    private String contact_no;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at")
    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date created_at;

    @Column(name = "created_by")
    private Long created_by;

    @Column(name = "updated_at")
    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date updated_at;

    @Column(name = "updated_by")
    private Long updated_by;

    @Column(name = "obj_status")
    private Boolean obj_status;

}
