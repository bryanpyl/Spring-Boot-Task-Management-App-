package com.example.reminder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reminder.entity.Reminder;
import com.example.reminder.repository.ReminderRepository;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public Reminder getReminderById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }

    public Reminder updateReminder(Long id, Reminder reminderDetails) {
        Reminder reminder = reminderRepository.findById(id).orElse(null);
        if (reminder != null) {
            reminder.setTitle(reminderDetails.getTitle());
            reminder.setTaskId(reminderDetails.getTaskId());
            reminder.setDescription(reminderDetails.getDescription());
            reminder.setDueDate(reminderDetails.getDueDate());
            return reminderRepository.save(reminder);
        }
        return null;
    }

    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }
}
