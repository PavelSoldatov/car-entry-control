package ru.unit_techno.car_entry_control.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.unit_techno.car_entry_control.dto.RfidEntry;
import ru.unit_techno.car_entry_control.entity.EntryDevice;
import ru.unit_techno.car_entry_control.entity.RfidLabel;
import ru.unit_techno.car_entry_control.repository.RfidLabelRepository;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
@AllArgsConstructor
public class RfidLabelService {

    private RfidLabelRepository rfidLabelRepository;
    private EntryDeviceService entryDeviceService;


    // todo продумать сигнатуру метода, тип возвращаемого значени
    @SneakyThrows
    public boolean labelExists(RfidEntry rfidEntry) {
        RfidLabel rfidLabel = rfidLabelRepository.findByRfidLabelValue(rfidEntry.getRfid());

        boolean exists = rfidLabel != null;

        EntryDevice entryDevice = entryDeviceService.findBySlug(rfidEntry.getDeviceId());

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(String.format("http://%s/post", entryDevice.getIpAddress())))
            .POST(HttpRequest.BodyPublishers.noBody())
            .build();

        HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofMinutes(1))
            .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());


        // todo реалиовать обработку кодов ответа от Адруины шлагбаума
        if (response.statusCode() == 200) {
            // create event
        }
        return false;
    }
}
