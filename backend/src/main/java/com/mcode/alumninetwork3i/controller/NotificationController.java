package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.entity.NotificationEntity;
import com.mcode.alumninetwork3i.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/notifications")
    public ResponseEntity<?> getNotifications(@RequestParam("page") Integer page,
                                              @RequestParam("size") Integer size) {
        page = page < 0 ? 0 : page - 1;
        size = size <= 0 ? 5 : size;
        List<NotificationEntity> notifications = notificationService.getNotificationsForAuthUserPaginate(page, size);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @PostMapping("/notifications/mark-seen")
    public ResponseEntity<?> markAllSeen() {
        notificationService.markAllSeen();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/notifications/mark-read")
    public ResponseEntity<?> markAllRead() {
        notificationService.markAllRead();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}