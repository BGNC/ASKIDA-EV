package com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();

}
