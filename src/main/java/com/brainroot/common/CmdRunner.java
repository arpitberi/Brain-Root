package com.brainroot.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... strings) throws Exception {

        User u1 = createUser("user::0001", "Perry", "Manson", "perry.mason@acme.com", "Who can we get on the case?","password");
        userRepository.save(u1);

        User u2 = createUser("user::0002", "Major", "Tom", "major.tom@acme.com", "Send me up a drink","password");
        userRepository.save(u2);


        User u3 = createUser("user::0003", "Jerry", "Wasaracecardriver", "jerry.wasaracecardriver@acme.com", "el sob number one","password");
        userRepository.save(u3);

        Optional<User> user = userRepository.findById("user::0001");
        System.out.println("User found = "+user.get().getFirstName());

        List<User> result = userRepository.findByEmailLike("%@acme.com");

        System.out.println( "Total of @acme.com users = "+result.size()  );

    }

    public static User createUser(String id, String firstName, String lastName,
                                  String email, String tagLine,String password) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setTagLine(tagLine);
        user.setPassword(password);
        return user;
    }

}
