package ru.unit_techno.car_entry_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.unit_techno.car_entry_control.entity.RfidLabel;

public interface RfidLabelRepository extends JpaRepository<RfidLabel, Long> {

    RfidLabel findByRfidLabelValue(String labelValue);
}
