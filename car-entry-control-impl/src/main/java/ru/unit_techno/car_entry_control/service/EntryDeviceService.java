package ru.unit_techno.car_entry_control.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unit_techno.car_entry_control.entity.EntryDevice;
import ru.unit_techno.car_entry_control.repository.EntryDeviceRepository;

@Service
@AllArgsConstructor
public class EntryDeviceService {

    private EntryDeviceRepository entryDeviceRepository;

    public EntryDevice findBySlug(String slug) {
        EntryDevice entryDevice = entryDeviceRepository.findBySlug(slug);

        return entryDevice;
    }
}
