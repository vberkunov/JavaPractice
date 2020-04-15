package com.record.dao;

import com.record.model.RecordBook;


import java.util.List;

public interface RecordDao {
    void save(RecordBook recordBook);
    void delete (RecordBook recordBook);
    RecordBook getRecordByLastName(String lastName) throws Exception;

    List<RecordBook> findAllRecord();
}
