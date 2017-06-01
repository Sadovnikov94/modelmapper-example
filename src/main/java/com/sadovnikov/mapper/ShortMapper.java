package com.sadovnikov.mapper;

import com.sadovnikov.model.Client;
import com.sadovnikov.model.dto.ClientDTO;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.PropertyMapping;

/**
 * Created by iharsadounikau on 6/1/17.
 */
public class ShortMapper extends PropertyMap<Client, ClientDTO> {
    @Override
    protected void configure() {
        skip().setLogin(null);
        skip().setPassword(null);
    }
}
