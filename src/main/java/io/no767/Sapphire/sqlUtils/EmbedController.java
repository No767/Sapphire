package io.no767.Sapphire.sqlUtils;

import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/embeds")
public class EmbedController {
    @Autowired
    private EmbedItemRepo embedItemRepo;

    @PostMapping(path = "/create")
    public @ResponseBody String createNewEmbed(@RequestBody PostNewEmbed userInput) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        String currentDateISO = df.format(new Date());

        UUID uuid = UUID.randomUUID();
        String embedUUID = uuid.toString();

        EmbedItems n = new EmbedItems();
        n.setEmbedUUID(embedUUID);
        n.setDateCreated(currentDateISO);
        n.setEmbedName(userInput.getEmbedName());
        n.setEmbedDescription(userInput.getEmbedDescription());
        n.setEmbedInline(userInput.getEmbedInline());
        embedItemRepo.save(n);
        return "Saved";
    }


    @GetMapping(path = "/{embedUUID}")
    public @ResponseBody Iterable<EmbedItems> getAllEmbeds(@PathVariable String embedUUID) {
        return embedItemRepo.findByEmbedUUIDContains(embedUUID);
    }


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<EmbedItems> getAllEmbeds() {
        return embedItemRepo.findAll();
    }

    @GetMapping(path="/{embedUUID}/{embedName}")
    public @ResponseBody Iterable<EmbedItems> getEmbedsWithName(@PathVariable String embedUUID, @PathVariable String embedName) {
        return embedItemRepo.findByEmbedUUIDContainsOrEmbedName(embedUUID, embedName);
    }

}
