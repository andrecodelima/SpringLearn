//package com.mballem.demoparkapi.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Slf4j
//public class JwtAuthorizationFilterBKP extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtUserDetailsService detailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        final String token = request.getHeader(JwtUtils.JWT_AUTORIZATION);
//
//        if(token == null || !token.startsWith(JwtUtils.JWT_BEARER)){
//            log.info("JWT token está nulo, vazio ou não iniciado com 'Bearer'.");
//            filterChain.doFilter(request, response);
//            return;
//            // Se o token for nulo ou não iniciar com Bearer, a gente vai forçar uma saída do filtro.
//            /*
//            * Isso aqui vai ser útil para as requisições que não necessitam do token.
//                Por exemplo, para você criar um usuário ou mesmo para você autenticar na aplicação.
//                Você não vai precisar de um token.
//                Então, como o nosso filtro captura todas as requisições, aquelas requisições que não precisam do token
//                vão ficar pelo caminho nesse nosso primeiro if.*/
//        }
//
//        //validando o token
//        if(!JwtUtils.isTokenValid(token)){
//            log.warn("JWT Token está inválido ou expirado");
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String username = JwtUtils.getUsernameFromToken(token);
//
//        toAuthentication(request, username);
//        filterChain.doFilter(request, response);
//    }
//
//    private void toAuthentication(HttpServletRequest request, String username) {
//        UserDetails userDetails = detailsService.loadUserByUsername(username);
//
//        UsernamePasswordAuthenticationToken authenticationToken = UsernamePasswordAuthenticationToken
//                .authenticated(userDetails, null, userDetails.getAuthorities());
//        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//    }
//
//}
