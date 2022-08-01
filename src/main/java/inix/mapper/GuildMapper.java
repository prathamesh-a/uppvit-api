package inix.mapper;

import inix.dto.GuildDto;
import inix.model.Guild;
import inix.model.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuildMapper {

    @Mapping(target = "postCount", expression = "java(mapPosts(guild.getPosts()))")
    GuildDto mapGuildToDto(Guild guild);

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Guild mapDtoToGuild(GuildDto guildDto);

    default Integer mapPosts(List<Post> postCount) {
        return postCount.size();
    }

}
