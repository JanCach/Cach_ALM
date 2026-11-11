import diary.Diary;
import ui.DiaryUI;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import java.time.LocalDate;

void main() {
    Diary mujDenicek = new Diary();

    DiaryUI mojeUI = new DiaryUI(mujDenicek);

    /*mujDenicek.addDay(LocalDate.of(2026, 10, 31));
    mujDenicek.addDay(LocalDate.of(2026, 11, 1));

    mujDenicek.addRecordToCurrentDay("bedna");
    mujDenicek.addRecordToCurrentDay("kniha");*/
    mojeUI.show();
}