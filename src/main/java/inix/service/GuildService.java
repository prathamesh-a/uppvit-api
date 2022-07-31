package inix.service;

import inix.Repo.GuildRepo;
import inix.dto.GuildDto;
import inix.exception.UppvitException;
import inix.model.Guild;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class GuildService {

    private final GuildRepo guildRepo;
    private final AuthService authService;

    @Transactional(readOnly = true)
    public List<GuildDto> getAll() {
        return guildRepo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional
    public GuildDto save(GuildDto guildDto) {
        Guild guild = guildRepo.save(mapToGuild(guildDto));
        guild.setId(guild.getId());
        return guildDto;
    }

    @Transactional(readOnly = true)
    public GuildDto getGuild(Long id) {
        Guild guild = guildRepo.findById(id)
                .orElseThrow(() -> new UppvitException("Guild not found with id -" + id));
        return mapToDto(guild);
    }

    private GuildDto mapToDto(Guild subreddit) {
        return GuildDto.builder().name(subreddit.getName())
                .id(subreddit.getId())
                .postCount(subreddit.getPosts().size())
                .build();
    }

    private Guild mapToGuild(GuildDto guildDto) {
        return Guild.builder().name("/v/" + guildDto.getName())
                .description(guildDto.getDescription())
                .user(authService.getCurrentUser())
                .createdDate(now()).build();
    }
}
