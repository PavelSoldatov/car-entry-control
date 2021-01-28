package ru.unit_techno.car_entry_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.unit_techno.car_entry_control.entity.EntryDevice;
import ru.unit_techno.car_entry_control.entity.RfidLabel;

public interface EntryDeviceRepository extends JpaRepository<EntryDevice, Long> {

    EntryDevice findBySlug(String slug);
}
