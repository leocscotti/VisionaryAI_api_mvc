package br.com.fiap.visionaryAI.springAI;

import br.com.fiap.visionaryAI.dto.EmpresaResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/springai")
@Tag(name = "Basic - Spring AI")
public class SpringAIChatController {

    private final SpringAIChatService chatService;

    public SpringAIChatController(SpringAIChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/generate")
    public ResponseEntity<Map> generate(
            @RequestParam(value = "message", defaultValue = "Qual é a situação da empresa cadastrada?") String message) {

        EmpresaResponse empresa = new EmpresaResponse();
        empresa.setId(1L);
        empresa.setNome("Plusoft");
        empresa.setCnpj("12345678900123");
        empresa.setEmail("contato.plusoft@gmail.com");
        empresa.setSituacao("Ativa");
        empresa.setMessage("A empresa " + empresa.getNome() + " está " + empresa.getSituacao() +
                " e possui o CNPJ " + empresa.getCnpj() + ".");

        return new ResponseEntity<>(Map.of("ollama", chatService.run(empresa.getMessage())), HttpStatus.OK);
    }


}
