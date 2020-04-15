package com.record.model;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDate {
    @Setter
    @Getter
    private int day;
    private int month;
    private int year;

    public static class DateBuilder{
        private MyDate newDate;

        public DateBuilder(MyDate newDate) {
            this.newDate = new MyDate();
        }

        public DateBuilder date(int day, int month, int year){
            newDate.day = day;
            newDate.month = month;
            newDate.year = year;
            return this;
        }
        public MyDate build(){
            return  newDate;
        }

    }


}

