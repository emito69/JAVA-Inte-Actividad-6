package modelos;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data   // Getters y Setters
@Entity
@Table(name="contrato") 
public class Contrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @ManyToOne(cascade = CascadeType.MERGE)     // cada contrato es por un servicio
    @JoinColumn(
            name="servicio_id", 
            referencedColumnName="id")  //nombre de la foreing key en tabla Contrato
    private Servicio servicio;
    
    @ManyToMany(cascade = CascadeType.MERGE)   // varios contratos pueden tener los mismo Consumidores
    private List<Consumidor> consumidores;

    @ManyToMany(cascade = CascadeType.MERGE)   // varios contratos pueden tener los mismo Prestadores
    private List<Prestador> prestadores;
    
}
