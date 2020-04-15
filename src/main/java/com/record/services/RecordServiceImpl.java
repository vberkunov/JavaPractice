package com.record.services;

import com.record.dao.RecordDao;
import com.record.dao.RecordDaoImpl;
import com.record.model.RecordBook;

import java.util.List;

public class RecordServiceImpl implements RecordService {
        private RecordDao recordDao;



        public RecordServiceImpl(RecordDao dao){
            this.recordDao = dao;
        }

    @Override
    public void save(RecordBook recordBook) {
        if(recordBook!=null){
            List<RecordBook> records = recordDao.findAllRecord();
            if(!records.isEmpty()) {
                RecordBook lastRecord = records.get(records.size() - 1);

                recordDao.save(recordBook);
            }
        }

    }

    @Override
    public void delete(RecordBook recordBook) {
        if(recordBook!=null) {
            recordDao.delete(recordBook);
        }
    }

    @Override
    public RecordBook getRecordByLastName(String lastName) throws Exception {
        if(lastName!=null) {
            return recordDao.getRecordByLastName(lastName);
        }
        return null;
    }
    @Override
    public boolean checkRecordPresence(RecordBook record) throws Exception {
        RecordBook r = recordDao.getRecordByLastName(record.getLastName());

        return r != null;
    }



    @Override
    public List<RecordBook> findAllRecord() {
        return recordDao.findAllRecord();
    }
}
