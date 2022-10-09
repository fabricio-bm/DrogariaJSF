package br.edu.unifio.drogaria.entidades;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data

public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long codigo;

    @Column (nullable = false)  private  Byte quantidade;

@ManyToOne() @JoinColumn(nullable = false) private Pedido pedido;

@Column(nullable = false, precision = 6, scale = 2) private BigDecimal preco; //preço do produto no dia//

@ManyToOne @JoinColumn(nullable = false)   private Produto produto;
}
