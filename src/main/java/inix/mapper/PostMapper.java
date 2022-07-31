package inix.mapper;

import inix.dto.PostRequest;
import inix.dto.PostResponse;
import inix.model.Guild;
import inix.model.Post;
import inix.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "guild", source = "guild")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Guild guild, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "guildName", source = "guild.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}

