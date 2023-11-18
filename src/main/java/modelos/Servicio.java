package modelos;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data   // Getters y Setters
@Entity
@Table(name="servicio") 
public class Servicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long
    
    @Column(name = "denominacion", nullable = false, length = 45)
    //@NotBlank (message = "La denominacion no puede estar vacía")
    //@NotNull (message = "La denominacion no puede estar vacía")
    private String denominacion;  
    
    @OneToMany(cascade = CascadeType.PERSIST)     // un servicio puede componerse de varias tareas   // PERSIST: cuando creo Servicio debería crear en el mismo momento la/las tareas
    @JoinColumn(name="servicio_id", referencedColumnName="id") //nombre de la foreing key en tabla tareas
    private List<Tareas> tareas;
  
}
