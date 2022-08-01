package inix.controller;

import inix.dto.GuildDto;
import inix.service.GuildService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/guild")
@AllArgsConstructor
@Slf4j
public class GuildController {

    private final GuildService guildService;

    // Get Mappings
    @GetMapping
    public List<GuildDto> getAllGuilds() {
        return guildService.getAll();
    }

    @GetMapping("/{id}")
    public GuildDto getGuild(@PathVariable Long id) {
        return guildService.getGuild(id);
    }

    // Post Mappings
    @PostMapping
    public GuildDto create(@RequestBody @Valid GuildDto guildDto) {
        return guildService.save(guildDto);
    }
}
