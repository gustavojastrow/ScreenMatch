package br.com.jastrow.screenmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jastrow.screenmatch.filme.DadosAtualizadaFilme;
import br.com.jastrow.screenmatch.filme.DadosCadastroFilme;
import br.com.jastrow.screenmatch.filme.Filme;
import br.com.jastrow.screenmatch.filme.FilmeRepository;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null){
            var filme = repository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraFilme(DadosCadastroFilme dados) {
        var filme = new Filme(dados);
        repository.save(filme);

        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String atualizaFilme(DadosAtualizadaFilme dados) {
        var filme = repository.getReferenceById(dados.id());
        filme.atualizaDados(dados);
        return "redirect:/filmes";
    }
    @DeleteMapping
    @Transactional
    public String deletarFilme(Long id){
        repository.deleteById(id);
        
        return "redirect:/filmes";
    }
}