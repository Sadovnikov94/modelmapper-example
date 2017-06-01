package com.sadovnikov;

import com.sadovnikov.mapper.ShortMapper;
import com.sadovnikov.model.Client;
import com.sadovnikov.model.dto.ClientDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 * Created by iharsadounikau on 6/1/17.
 * Just For Fun
 */
public class MainExample {

    private static Client client;

    static {
        client = new Client();
        client.setName("Igor");
        client.setSurname("Sadovnikog");
        client.setLogin("sad");
        client.setPassword("12345678");
    }


    public static void main(String... args) {

        // Regular Mapping
        ModelMapper modelMapper = new ModelMapper();
        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);

        System.out.println(clientDTO);

        // Property Mapper Implementation
        modelMapper = new ModelMapper();

        modelMapper.addMappings(new ShortMapper());

        clientDTO = modelMapper.map(client, ClientDTO.class);

        System.out.println(clientDTO);

        // Anonymous Inner Class for One Time Usage
        modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Client, ClientDTO>() {
            @Override
            protected void configure() {
                map().setName("DEFAULT NAME");
                map(source.getLogin(), destination.getPassword());
                map(source.getPassword(), destination.getLogin());
            }
        });

        clientDTO = modelMapper.map(client, ClientDTO.class);

        System.out.println(clientDTO);

    }

}
