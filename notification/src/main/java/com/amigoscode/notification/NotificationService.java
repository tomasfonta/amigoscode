package com.amigoscode.notification;


import com.amigoscode.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void createNotification(NotificationRequest request) {

        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .sender("Amigoscode")
                .build();

        notificationRepository.save(notification);

    }

}
