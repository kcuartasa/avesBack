package com.co.ias.aves.model;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "zona")
public class Zona {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String cdZona;
    @Column(nullable = false, length = 100)
    private String dsNombre;

    @OneToMany
    private List<Pais> paises;

}
