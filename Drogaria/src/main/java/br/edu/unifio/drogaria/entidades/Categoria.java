package br.edu.unifio.drogaria.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Categoria {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigo; //até 128 categorias

//opcional nullable true, obrigatório nullable false
@Column (length = 50, nullable = false, unique = true) private String nome;
}
