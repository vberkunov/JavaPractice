package com.record.dao;

import com.record.model.RecordBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordDaoImpl implements RecordDao {
    private List<RecordBook> record;
    private static RecordDao instance;


    private RecordDaoImpl(){
        this.record = new ArrayList<>(Arrays.asList(
                new RecordBook.Builder()
                        .withFirstName("Vasya")
                        .withSecondName( "Petrovich")
                        .withLastName("Shishkin")
                        .withPhone("098654224")
                        .build(),
                new RecordBook.Builder()
                        .withFirstName("Petya")
                        .withSecondName( "Antonovich")
                        .withLastName("Andreev")
                        .withPhone("656878875")
                        .build(),
                new RecordBook.Builder()
                        .withFirstName("Kolya")
                        .withSecondName( "Oleksandrovich")
                        .withLastName("Petrov")
                        .withPhone("098657624")
                        .build()

        ));
    }

    public static synchronized RecordDao getInstance() {
        if (instance == null) {
            instance = new RecordDaoImpl();
        }
        return instance;
    }

    @Override
    public void save(RecordBook recordBook) {
        record.add(recordBook);
    }

    @Override
    public void delete(RecordBook recordBook) {
        record.remove(recordBook);
    }

    @Override
    public RecordBook getRecordByLastName(String lastName) throws Exception {
        return record.stream().filter(u -> u.getLastName().equals(lastName))
                .findAny().orElse(null);
    }

    @Override
    public List<RecordBook> findAllRecord() {
        return record;
    }
}
