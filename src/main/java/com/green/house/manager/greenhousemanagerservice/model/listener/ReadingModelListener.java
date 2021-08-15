package com.green.house.manager.greenhousemanagerservice.model.listener;

import com.green.house.manager.greenhousemanagerservice.model.Command;
import com.green.house.manager.greenhousemanagerservice.model.Reading;
import com.green.house.manager.greenhousemanagerservice.service.SequenceGeneratorService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class ReadingModelListener extends AbstractMongoEventListener<Reading> {
    private final SequenceGeneratorService sequenceGeneratorService;

    public ReadingModelListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Reading> event) {
        super.onBeforeConvert(event);
        if (event.getSource().getId() == null || event.getSource().getId().longValue() < 1) {
            event.getSource().setId(BigInteger.valueOf(
                    sequenceGeneratorService.generateSequence(Command.SEQUENCE_NAME)));
        }
    }
}
