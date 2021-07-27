
package ru.unit_techno.car_entry_control.config;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ActionObject {
    private Long rfidLabelValue;
    private Long deviceId;
    private LocalDateTime eventTime;
    //todo enum с 3 статусами
    private ActionStatus actionStatus;
    private String gosNumber;
}