package com.davinchicoder.spring_boot_async_template_community.infrastructure.kafka.mapper;

import com.davinchicoder.spring_boot_async_template_community.application.userCreated.UserCreatedCmd;
import com.davinchicoder.spring_boot_async_template_community.infrastructure.events.UserCreated;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    UserCreatedCmd map(UserCreated userCreated);

}
