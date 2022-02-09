package br.com.evaluation.service;

import br.com.evaluation.model.Grupo;
import br.com.evaluation.model.Permissao;
import br.com.evaluation.model.Usuario;
import br.com.evaluation.repository.GrupoRepository;
import br.com.evaluation.repository.PermissaoRepository;
import br.com.evaluation.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarios;

    @Autowired
    private GrupoRepository grupos;

    @Autowired
    private PermissaoRepository permissoes;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarios.findByLogin(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));
    }

    public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
        List<Grupo> gruposList = grupos.findByUsuariosIn(Collections.singletonList(usuario));
        return authorities(gruposList);
    }

    public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
        Collection<GrantedAuthority> auths = new ArrayList<>();
        for (Grupo grupo: grupos) {
            List<Permissao> lista = permissoes.findByGruposIn(Collections.singletonList(grupo));
            for (Permissao permissao: lista) {
                auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
            }
        }
        return auths;
    }

}