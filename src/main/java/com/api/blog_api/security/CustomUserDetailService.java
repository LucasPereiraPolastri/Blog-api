package com.api.blog_api.security;

import com.api.blog_api.model.UsuarioModel;
import com.api.blog_api.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {


    private final UsuarioRepository usuarioRepository;

    public  CustomUserDetailService(UsuarioRepository usuarioRepository){
        this.usuarioRepository =   usuarioRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UsuarioModel usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado" + username));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRole())
                .disabled(!usuario.isEnabled())
                .build();
    }


}
