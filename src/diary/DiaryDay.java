package diary;

import java.time.LocalDate;

public class DiaryDay {

    private DiaryDay previous;
    private DiaryDay next;
    private LocalDate date;
    private RecordList records;

    public DiaryDay(LocalDate date) {
        this.date = date;
        this.previous = null;
        this.next = null;
        this.records = new RecordList();
    }

    public DiaryDay getNext() {
        return next;
    }

    public DiaryDay getPrevious() {
        return previous;
    }

    public void setNext(DiaryDay day) {
        next = day;
    }

    public void setPrevious(DiaryDay day) {
        previous = day;
    }

    public RecordList getRecords() {
        return records;
    }

    public void show() {
        System.out.println("den: " + date);

        if (records.isEmpty()) {
            System.out.println("v tomto dni nejsou žádné záznamy");
        }
        else {
            System.out.println ("počet záznamů: " + records.getCount());

            for (int i=0; i< records.getCount(); i++) {
                System.out.println((i + 1) + ". " + records.getRecord(i));
            }
        }
    }

    public LocalDate getDate() {
        return date;
    }
}
