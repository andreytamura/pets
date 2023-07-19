package br.com.software.pets.bd.mongo.listeners;

import br.com.software.pets.bd.mongo.model.BaseModel;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MongoListener extends AbstractMongoEventListener<BaseModel> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseModel> event) {
        super.onBeforeConvert(event);

        if (event.getSource().getId() == null || event.getSource().getId().isEmpty())
            event.getSource().setCreatedAt(new Date());

        if (event.getSource().getId() != null && !event.getSource().getId().isEmpty())
            event.getSource().setUpdatedAt(new Date());
    }
}
