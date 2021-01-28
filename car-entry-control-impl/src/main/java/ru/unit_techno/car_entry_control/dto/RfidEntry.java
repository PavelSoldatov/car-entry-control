package ru.unit_techno.car_entry_control.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RfidEntry {

    @JsonProperty("device_did")
    private String deviceId;

    @JsonProperty("rfid")
    private String rfid;

    @JsonProperty("srv")
    private String serverResponse;
}
