package com.onisun.demo1.converter;

import com.onisun.demo1.bean.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Neo
 * @version 1.0
 */
@Component
public class MyConverter implements Converter<String, Person> {

    public Person convert(String source) {
        Person person = null;
        String[] split = source.split("-");
        if (source != null && split.length == 4){
            person = new Person();
            person.setId(Integer.parseInt(split[0]));
            person.setName(split[1]);
            person.setAge(Integer.parseInt(split[2]));
            person.setGender(split[3]);
            System.out.println("convert-----"+person);
        }
            return person;
    }
}
