package br.edu.unifio.drogaria.repositories;

import br.edu.unifio.drogaria.entidades.Categoria;
import br.edu.unifio.drogaria.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
