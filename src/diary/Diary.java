package diary;

import java.time.LocalDate;

public class Diary {

    private DiaryDay first;
    private DiaryDay last;
    private DiaryDay current;
    private int count;

    public Diary() {
        this.first = null;
        this.last = null;
        this.current = null;
        this.count = 0;
    }

    public void showCurrentDay() {
        if (current != null) {
            current.show();
        }
        else {
            System.out.println("V deniku neni zadny zaznam");
        }
    }

    public DiaryDay getCurrent() {
        return current;
    }

    public void addDay(LocalDate date) {
        DiaryDay day = new DiaryDay(date);

        if (count == 0) {
            first = day;
            last = day;
            current = day;
        } else {

            // ⬇️ NÁSLEDUJÍCÍ ŘÁDKY UPRAVIT !!!!!!!!!!!!
            // Co když je vybraný den (current) zároveň posledním dnem v deníku?
            // Pak current.next obsahuje null a ty řádky níže nebudou fungovat.
            // To se musí nějak ošetřit, aby šel přidat do deníku nový den,
            // i když aktuálně stojíš na posledním dni v deníku.
            if (current.getNext() != null) {
                day.setNext(current.getNext());
                day.setPrevious(current);
                current.getNext().setPrevious(day);
                current.setNext(day);
            }
            else {
                day.setPrevious(current);
                current.setNext(day);
                last = day;
            }
            current = day;
        }

        count++;
    }

    // ⬇️ Doplnit metody ⬇️

    // Metoda nextDay()
    // - nastaví current na následující den v deníku
    // - ošetřit, co se stane, když už stojíme na začátku

    public boolean nextDay() {
        if (current == null || current.getNext() == null) {
            return false;
        }
        current = current.getNext();
        return true;
    }

    // Metoda previousDay()
    // - nastaví current na předchozí den v deníku
    // - ošetřit, co se stane, když už stojíme na konci

    public boolean previousDay() {
        if (current == null || current.getPrevious() == null) {
            return false;
        }
        current = current.getPrevious();
        return true;
    }

    // Metoda firstDay()
    // - nastaví current na první den v deníku

    public void firstDay() {
        /*
        while(current.getPrevious() != null) {
            current = current.getPrevious();
        }
         */
        current = first;
    }

    // Metoda lastDay()
    // - nastaví current na poslední den v deníku

    public void lastDay() {
        /*
        while(current.getNext() != null) {
            current = current.getNext();
        }
         */
        current = last;
    }

    // Metoda deleteCurrentDay()
    // - smaže aktuální uzel z deníku
    // - takže musíme nastavit vlastnosti next a previous okolních uzlů tak,
    //   aby ukazovaly na sebe navzájem a už ne na ten uzel, který mažeme
    // - pozor, opět musíme ošetřit, co se má stát, když mažeme první nebo
    //   poslední uzel v seznamu, protože pak některé vlastnosti obsahují null
    // - po smazání uzlu také snížíme hodnotu proměnné count v deníku o 1

    public boolean deleteCurrentDay() {
        if (current == null) {
            return false;
        }

        DiaryDay prev = current.getPrevious();
        DiaryDay next = current.getNext();

        if (prev != null) {
            prev.setNext(next);
        } else {
            first = next;          // mazali jsme první den
        }

        if (next != null) {
            next.setPrevious(prev);
        } else {
            last = prev;           // mazali jsme poslední den
        }

        current.setNext(null);
        current.setPrevious(null);

        // po smazání stojíme na dalším dni, a když není, tak na předchozím
        // (když není ani ten, je deník prázdný a current je null)
        current = (next != null) ? next : prev;

        count--;
        return true;
    }

    public void addRecordToCurrentDay(String text) {
        if (current == null) {
            System.out.println("Nelze přidat záznam, v deníku není žádný den");
        } else {
            current.getRecords().addRecord(text);
        }
    }

    // index je od 1, tak jak ho vidí uživatel
    public boolean deleteRecordFromCurrentDay(int number) {
        if (current == null) {
            return false;
        }
        int index = number - 1;
        if (index < 0 || index >= current.getRecords().getCount()) {
            return false;
        }
        current.getRecords().deleteRecord(index);
        return true;
    }
}