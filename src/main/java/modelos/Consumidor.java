package modelos;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data   // Getters y Setters
@Entity
@Table(name="consumidor") 

public class Consumidor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long
    
    @Column(name = "nombre", nullable = false, length = 45)
    //@NotBlank (message = "El nombre no puede estar vacío")
    //@NotNull (message = "El nombre no puede estar vacío")
    private String nombre;
    
    @ManyToMany(mappedBy="consumidores", cascade = CascadeType.MERGE)  // varios Consumidores pueden aparecer en varios Contratos
    private List<Contrato> contratos;
    
}
