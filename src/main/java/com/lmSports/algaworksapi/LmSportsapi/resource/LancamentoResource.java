package com.lmSports.algaworksapi.LmSportsapi.resource;

import com.lmSports.algaworksapi.LmSportsapi.event.RecursoCriadoEvent;
import com.lmSports.algaworksapi.LmSportsapi.exceptionHandler.LmSportsExceptionHandler;
import com.lmSports.algaworksapi.LmSportsapi.model.Lancamento;
import com.lmSports.algaworksapi.LmSportsapi.repository.LancamentosRepository;
import com.lmSports.algaworksapi.LmSportsapi.service.LancamentoService;
import com.lmSports.algaworksapi.LmSportsapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentosRepository lancamentosRepository;

    @Autowired
    private LancamentoService lancamentoService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;


    @GetMapping
    public List<Lancamento> listar(){
 return lancamentosRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo){
        Lancamento lancamento = lancamentosRepository.findOne(codigo);
        return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
        Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @ExceptionHandler({PessoaInexistenteOuInativaException.class})
    public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex){
        String mensagemUsuario = messageSource.getMessage("pessoa.inexistente.ou-inativa", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.toString();
        List<LmSportsExceptionHandler.Erro> erros = Arrays.asList(new LmSportsExceptionHandler.Erro(mensagemUsuario, mensagemDesenvolvedor));
        return ResponseEntity.badRequest().body(erros);
    }

}
