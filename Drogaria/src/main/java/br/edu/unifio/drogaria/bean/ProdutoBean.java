package br.edu.unifio.drogaria.bean;

import br.edu.unifio.drogaria.entidades.Categoria;
import br.edu.unifio.drogaria.entidades.Produto;
import br.edu.unifio.drogaria.repositories.CategoriaRepository;
import br.edu.unifio.drogaria.repositories.ProdutoRepository;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
@Data
public class ProdutoBean {
 private Produto produto;
 private List<Produto> produtos;

 private List<Categoria> categorias;

 @Autowired
 private ProdutoRepository produtoRepository;
 @Autowired
 private CategoriaRepository categoriaRepository;

 public void listar() {
  produtos = produtoRepository.findAll();
 }

 public void novo() {
  produto = new Produto();

  categorias = categoriaRepository.findAll();
 }

 public void salvar() {
  try {
   produtoRepository.save(produto);
   Messages.addFlashGlobalInfo("Registro salvo com sucesso");
   Faces.navigate("produto-listagem.xhtml?faces-redirect=true");

  } catch (DataIntegrityViolationException ex) {
   ex.printStackTrace();
   Messages.addFlashGlobalError("registro já existente");
  }

 }
}
