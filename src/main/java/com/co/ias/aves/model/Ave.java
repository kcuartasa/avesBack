package com.co.ias.aves.model;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table (name = "ave")
public class Ave {


    @Id()
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="cdave", nullable = false)
    private String cdAve;
    @Column(name = "dsnombre_comun", nullable = false, length = 100)
    private String dsNombreComun;
    @Column(name = "dsnombre_cientifico", nullable = false, length = 100)
    private String dsNombreCientifico;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Pais> paises;

}
