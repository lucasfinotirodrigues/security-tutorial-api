package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.model.Usuario;
import application.repository.UsuarioRepository;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(userInfo.getUsername())
                .password(userInfo.getPassword())
                .roles(userInfo.getRoles().toArray(new String[0]))
                .build();
    }

    public UserInfo saveUser(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public UserInfo getUserByUsername(String username) {
        return userInfoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}