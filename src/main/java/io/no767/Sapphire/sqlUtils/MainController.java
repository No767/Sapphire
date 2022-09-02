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
@RequestMapping(path="/users")
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String username) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        String currentDateISO = df.format(new Date());

        UUID uuid = UUID.randomUUID();
        String userUUID = uuid.toString();

        KumikoUser n = new KumikoUser();
        n.setUserUUID(userUUID);
        n.setUsername(username);
        n.setDateJoined(currentDateISO);
        n.setIsActive(true);
        userRepo.save(n);
        return "Saved";
    }

    @PostMapping(path="/create")
    public @ResponseBody ResponseEntity createNewUser(@RequestBody PostUserJSON userInput) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        String currentDateISO = df.format(new Date());

        UUID uuid = UUID.randomUUID();
        String userUUID = uuid.toString();

        KumikoUser n = new KumikoUser();
        n.setUserUUID(userUUID);
        n.setUsername(userInput.getUsername());
        n.setDateJoined(currentDateISO);
        n.setIsActive(true);
        userRepo.save(n);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<KumikoUser> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping(path="/{userUUID}")
    public @ResponseBody Iterable<KumikoUser> findUserUUID(@PathVariable("userUUID") String userUUID) {
        return userRepo.findByUserUUIDContains(userUUID);
    }




}
