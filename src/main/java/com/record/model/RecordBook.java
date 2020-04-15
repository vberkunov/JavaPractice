package com.record.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RecordBook extends MyDate {

    private String firstName;
    private String secondName;
    private String lastName;
    private String phone;



    public static class Builder  {
        private RecordBook newRecord;

        public Builder() {
            this.newRecord = new RecordBook();
        }

        public Builder withFirstName(String fName){
            newRecord.firstName = fName;
            return this;
        }
        public Builder withSecondName(String sName){
            newRecord.secondName = sName;
            return this;
        }
        public Builder withLastName(String lName){
            newRecord.lastName = lName;
            return this;
        }
        public Builder withPhone(String phone){
            newRecord.phone = phone;
            return this;
        }

        public RecordBook build(){
            return newRecord;
        }

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RecordBook that = (RecordBook) o;
        return firstName.equals(that.firstName) &&
                secondName.equals(that.secondName) &&
                lastName.equals(that.lastName) &&
                phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, secondName, lastName, phone);
    }



    @MyAnnotation
    public void getDaysBeforeBirthday() {
        Calendar current = Calendar.getInstance();
        int currentDate = current.get(Calendar.DATE);
        int currentMonth = current.get(Calendar.MONTH) + 1;
        int currentYear = current.get(Calendar.YEAR);

        Period period = Period.between(LocalDate.of(currentYear, currentMonth, currentDate),
                LocalDate.of(currentYear + 1, getMonth(), getDay()));
        System.out.println("Days: " + period.getDays() + " Months: " + period.getMonths());
    }

    @Override
    public String toString() {
        return "RecordBook{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
