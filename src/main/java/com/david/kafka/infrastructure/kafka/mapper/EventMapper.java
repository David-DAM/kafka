package com.david.kafka.infrastructure.kafka.mapper;

import com.david.kafka.application.userCreated.UserCreatedCmd;
import com.david.kafka.infrastructure.events.UserCreated;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    UserCreatedCmd map(UserCreated userCreated);

}
