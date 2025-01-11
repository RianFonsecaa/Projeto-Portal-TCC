import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServicoJwt {

    private String chaveSecreta = "secretaChave";
    private long validadeMilissegundos = 3600000; // 1 hora

    public String gerarToken(String nomeUsuario) {
        return Jwts.builder()
                .setSubject(nomeUsuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validadeMilissegundos))
                .signWith(SignatureAlgorithm.HS512, chaveSecreta)
                .compact();
    }
}
