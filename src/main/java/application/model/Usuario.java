package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios") // Sugiro mudar para um nome mais apropriado
@Setter
@Getter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome_de_usuario", nullable = false, unique = true) // Nome mais semântico
    private String nomeDeUsuario;
    
    @Column(nullable = false)
    private String senha; // Nome mais semântico que "amino"
}