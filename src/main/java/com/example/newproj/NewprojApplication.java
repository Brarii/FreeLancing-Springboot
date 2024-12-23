package com.example.newproj;

import com.example.newproj.Entities.Entities.approle;
import com.example.newproj.Entities.Entities.appuser;
import com.example.newproj.repositories.AppRoleRepository;
import com.example.newproj.repositories.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class NewprojApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewprojApplication.class, args);
    }

  /*  @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner initData(AppRoleRepository approlerepo, AppUserRepository appuserrepo, PasswordEncoder passwordEncoder) {
        return args -> {

            approle FREERole = approle.builder().id(2).nome("FREELANCER").build();
            approle CLIENTRole = approle.builder().id(3).nome("CLIENT").build();
            approlerepo.saveAll(List.of( FREERole, CLIENTRole));



            appuser user1 = appuser.builder()
                    .username("freelanceruser")
                    .password(passwordEncoder.encode("freelanceruser"))
                    .roles(List.of(FREERole))
                    .build();

            appuser user2 = appuser.builder()
                    .username("clientuser")
                    .password(passwordEncoder.encode("clientuser"))
                    .roles(List.of(CLIENTRole))
                    .build();



            appuserrepo.saveAll(List.of( user1, user2));
        };
    }*/

}
