package com.record.services;

import com.record.model.RecordBook;

import java.util.List;

public interface RecordService {
    void save(RecordBook recordBook);
    void delete (RecordBook recordBook);
    RecordBook getRecordByLastName(String lastName) throws Exception;
    List<RecordBook> findAllRecord();
    boolean checkRecordPresence(RecordBook recordBook) throws Exception;
}
