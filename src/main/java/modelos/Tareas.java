package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data   // Getters y Setters
@Entity
@Table(name="tareas") 
public class Tareas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long
    
    @Column(name = "denominacion", nullable = false, length = 45)
    //@NotBlank (message = "La denominacion no puede estar vacía")
    //@NotNull (message = "La denominacion no puede estar vacía")
    private String denominacion;    
    
}
