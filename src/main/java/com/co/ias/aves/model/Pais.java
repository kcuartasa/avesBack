package com.co.ias.aves.model;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "pais")
public class Pais {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String cdPais;
    @Column(nullable = false, length = 100)
    private String dsNombre;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Ave> aves;

    @ManyToOne
    private Zona zona;

}
