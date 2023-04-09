package com.haris.learn.graphql.config;

import com.haris.learn.graphql.model.Post;
import com.haris.learn.graphql.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostInitiatorConfig implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        postRepository.save(Post
                .builder()
                        .authorId("MH100")
                        .category("science")
                        .title("How far is the sun")
                        .description("Embark on an exhilarating journey through the cosmos with \"How Far is the Sun.\" This captivating book delves into the intricacies of our solar system and sheds light on the sun's vital role in our lives.")
                .build());
        postRepository.save(Post
                .builder()
                        .authorId("MH101")
                        .category("sport")
                        .title("Technic to get firm muscle")
                        .description("Techniques for Firm Muscles\" is a comprehensive guide to building muscle strength and toning your body through effective workouts and nutrition.")
                .build());
        postRepository.save(Post
                .builder()
                        .authorId("MH100")
                        .category("food")
                        .title("Top 50 quick menus for breakfast")
                        .description("Top 50 Quick Menus for Breakfast\" is a lifesaver for busy mornings, offering delicious and nutritious recipes that can be made in a flash. Start your day right with these mouthwatering options.")
                .build());
        postRepository.save(Post
                .builder()
                        .authorId("MH100")
                        .category("science")
                        .title("The evolution of frog")
                        .description("The Evolution of Frogs\" traces the fascinating history of these amphibians, exploring their origins, adaptations, and unique features. Discover the complex and intriguing world of these beloved creatures in this comprehensive book.")
                .build());
    }
}
