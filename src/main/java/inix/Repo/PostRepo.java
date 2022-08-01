package inix.Repo;

import inix.model.Guild;
import inix.model.Post;
import inix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAllByGuild(Guild guild);
    List<Post> findByUser(User user);
}
