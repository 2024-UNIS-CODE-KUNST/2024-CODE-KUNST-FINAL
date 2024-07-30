package com.example.unisweb.email;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email")
    public ResponseEntity<?> saveEmail(@RequestParam String email) {
        try {
            EmailOkDto emailDto = emailService.saveEmail(email);
            return ResponseEntity.status(HttpStatus.CREATED).body(emailDto);
        } catch (Exception e) {
            EmailFailDto failDto = emailService.saveEmailFail(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(failDto);
        }
    }

    @GetMapping("/email/failure")
    public ResponseEntity<EmailFailDto> saveEmailFail(@RequestParam String errorMessage) {
        EmailFailDto emailFailDto = emailService.saveEmailFail(errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(emailFailDto);
    }
    
    @PostMapping("/send")
    public ResponseEntity<String> sendEmails(@RequestParam String subject, @RequestParam String message) {
        emailService.sendEmails(subject, message);
        return ResponseEntity.status(HttpStatus.OK).body("모집 이메일을 성공적으로 발송했습니다");
    }
}
