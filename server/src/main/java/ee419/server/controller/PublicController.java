package ee419.server.controller;

import ee419.server.utils.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/test")
    public ResponseEntity<ResultVo<String>> getPublicResource() {
        String message = "This is a public message accessible by any user.";
        return ResponseEntity.ok(ResultVo.success("Fetched public message successfully", message));
    }
}
