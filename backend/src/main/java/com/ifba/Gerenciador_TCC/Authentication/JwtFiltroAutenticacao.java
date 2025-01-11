import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFiltroAutenticacao extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String autorizacaoCabecalho = request.getHeader("Authorization");
        String token = null;
        String nomeUsuario = null;

        if (autorizacaoCabecalho != null && autorizacaoCabecalho.startsWith("Bearer ")) {
            token = autorizacaoCabecalho.substring(7);
            nomeUsuario = extrairNomeUsuarioDoToken(token);
        }

        if (nomeUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(nomeUsuario, null, new ArrayList<>());
            autenticacao.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }

        filterChain.doFilter(request, response);
    }

    private String extrairNomeUsuarioDoToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("secretaChave")
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
