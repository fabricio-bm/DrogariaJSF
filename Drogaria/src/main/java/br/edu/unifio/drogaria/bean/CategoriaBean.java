package br.edu.unifio.drogaria.bean;

import br.edu.unifio.drogaria.entidades.Categoria;
import br.edu.unifio.drogaria.repositories.CategoriaRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
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
public class CategoriaBean {

    private Categoria categoria; //1 categoria só

    private List<Categoria> categorias;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void listar() {
        categorias = categoriaRepository.findAll();
    }

    public void novo() {
        categoria = new Categoria();

    }

    public void salvar() {
        try {
            categoriaRepository.save(categoria);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso");
            Faces.navigate("categoria-consulta.xhtml?faces-redirect=true");

        } catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            Messages.addFlashGlobalError("O registro já existente");

        }

    }

    public void selecionarExclusao(Categoria cursor) {
        Faces.setFlashAttribute("cursor", cursor);
        Faces.navigate("categoria-exclusao.xhtml?faces-redirect=true");

    }

    public void selecionarEdicao(Categoria cursor) {
        Faces.setFlashAttribute("cursor", cursor);
        Faces.navigate("categoria-edicao.xhtml?faces-redirect=true");
    }

    public void carregar() {
        categoria = Faces.getFlashAttribute("cursor");
    }

    public void excluir() {
        try {
            categoriaRepository.save(categoria);
            Messages.addFlashGlobalInfo("Registro salvo com sucesso");
            Faces.navigate("categoria-consulta.xhtml?faces-redirect=true");

        } catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            Messages.addFlashGlobalError("O registro já existente");

        }
    }
}