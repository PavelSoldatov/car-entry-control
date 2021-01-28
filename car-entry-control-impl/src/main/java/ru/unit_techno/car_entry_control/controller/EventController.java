package ru.unit_techno.car_entry_control.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.unit_techno.car_entry_control.dto.RfidEntry;
import ru.unit_techno.car_entry_control.service.EntryDeviceService;
import ru.unit_techno.car_entry_control.service.EventService;
import ru.unit_techno.car_entry_control.service.RfidLabelService;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
public class EventController {

    private RfidLabelService rfidLabelService;

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.OK)
    public RfidEntry eventHandler(@RequestBody RfidEntry rfidEntry) {
        boolean exists = rfidLabelService.labelExists(rfidEntry);



        return rfidEntry;
    }
}
