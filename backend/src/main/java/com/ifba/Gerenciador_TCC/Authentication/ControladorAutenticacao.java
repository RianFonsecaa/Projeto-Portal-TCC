import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorAutenticacao {

    @Autowired
    private AuthenticationManager gerenciadorAutenticacao;

    @Autowired
    private ServicoJwt servicoJwt;

    @PostMapping("/login")
    public ResponseEntity<?> criarTokenAutenticacao(@RequestBody RequisicaoLogin requisicaoLogin) throws AuthenticationException {
        Authentication autenticacao = gerenciadorAutenticacao.authenticate(
                new UsernamePasswordAuthenticationToken(requisicaoLogin.getNomeUsuario(), requisicaoLogin.getSenha())
        );

        String token = servicoJwt.gerarToken(requisicaoLogin.getNomeUsuario());
        return ResponseEntity.ok(new RespostaLogin(token));
    }
}
