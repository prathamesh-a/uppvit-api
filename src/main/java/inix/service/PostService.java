package inix.service;

import inix.Repo.GuildRepo;
import inix.Repo.PostRepo;
import inix.Repo.UserRepo;
import inix.dto.PostRequest;
import inix.dto.PostResponse;
import inix.exception.UppvitException;
import inix.mapper.PostMapper;
import inix.model.Guild;
import inix.model.Post;
import inix.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepo postRepository;
    private final GuildRepo guildRepo;
    private final UserRepo userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new UppvitException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    public void save(PostRequest postRequest) {
        Guild guild = guildRepo.findByName(postRequest.getGuildName())
                .orElseThrow(() -> new UppvitException(postRequest.getGuildName()));
        postRepository.save(postMapper.map(postRequest, guild, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByGuild(Long guildId) {
        Guild guild = guildRepo.findById(guildId)
                .orElseThrow(() -> new UppvitException(guildId.toString()));
        List<Post> posts = postRepository.findAllByGuild(guild);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UppvitException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
