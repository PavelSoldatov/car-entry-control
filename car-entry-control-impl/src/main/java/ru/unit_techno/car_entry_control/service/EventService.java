package ru.unit_techno.car_entry_control.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unit_techno.car_entry_control.repository.EventRepository;

@Service
@AllArgsConstructor
public class EventService {

    private EventRepository eventRepository;

    public void create() {

    }
}
