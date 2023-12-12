package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tarefas/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    // EXERCICIO 1
    // INSERT USER
    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        Contato contatoMain = contatoService.save(contato);

        return ResponseEntity.ok(contatoMain);
    }

    // EXERCICIO 2
    // BUSCAR PELO ID
    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        Contato contato = contatoService.getById(id);

        return ResponseEntity.ok(contato);
    }

    // EXERCICIO 3
    // BUSCAR PELO NOME
    @GetMapping("/nome")
    public ResponseEntity<Contato> getContatoByNome(@RequestParam String nome) {
        Contato contato = contatoService.getContatoByNome(nome);

        return ResponseEntity.ok(contato);
    }

    // EXERCICIO 4
    // BUSCAR QUANTIDADE DE CONTATOS
    @GetMapping
    public ResponseEntity<Integer> getQuantidadeDeContatos() {
        int contato = contatoService.getAll();

        return ResponseEntity.ok(contato);
    }

    // EXERCICIO 5
    // BUSCAR PELA DATA DE NASCIMENTO
    @GetMapping("/data")
    public ResponseEntity<List<Contato>> getContatosByDataNascimento(@RequestParam LocalDate data) {
        List<Contato> contato = contatoService.getByDataNascimento(data);

        return ResponseEntity.ok(contato);
    }

    // EXERCICIO 6
    // ATUALIZAR CONTATO
    @PatchMapping("/{id}")
    public ResponseEntity<Contato> updateContatoById(@PathVariable Long id, @RequestBody Contato contato) {
        Contato contatos = contatoService.update(id, contato);

        return ResponseEntity.ok(contatos);
    }

    // EXERCICIO 7
    // DELETAR CONTATO
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String contato = contatoService.delete(id);

        return ResponseEntity.ok(contato);
    }
}
