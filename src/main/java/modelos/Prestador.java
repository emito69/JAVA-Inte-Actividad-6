package modelos;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data   // Getters y Setters
@Entity
@Table(name="prestador") 
public class Prestador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long
    
    @Column(name = "nombre", nullable = false, length = 45)
    //@NotBlank (message = "El nombre no puede estar vacío")
    //@NotNull (message = "El nombre no puede estar vacío")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.PERSIST)     // un prestador puede ofrecer varios Servicios // PERSIST: cuando creo un Prestador debería crear en el mismo momento el/los Servicios
    @JoinColumn(name="prestador_id", referencedColumnName="id") //nombre de la foreing key en tabla Servicios
    private List<Servicio> servicios;
    
    
    @ManyToMany(mappedBy="prestadores", cascade = CascadeType.MERGE)   // varios Prestadores pueden aparecer en varios Contratos
    private List<Contrato> contratos;
}
