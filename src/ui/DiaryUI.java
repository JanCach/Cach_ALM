package ui;

import diary.Diary;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DiaryUI {
    private Diary diary;
    private Scanner scanner = new Scanner(System.in);

    public DiaryUI(Diary diary) {
        this.diary = diary;
    }

    public void show() {
        boolean repeat = true;

        while (repeat) {
            System.out.print("\n".repeat(5));
            diary.showCurrentDay();

            System.out.println("Záznamy: [A] Přidat  [D] Smazat");
            System.out.println("    Dny: [J] Předchozí  [K] Další  [U] První  [I] Poslední");
            System.out.println("Program: [Q] Konec");

            if (!scanner.hasNextLine()) break;
            String command = scanner.nextLine().trim().toLowerCase();
            if (command.isEmpty()) continue;

            switch (command) {
                case "j":
                    if (!diary.previousDay()) System.out.println( "Předchozí den není.");
                    break;
                case "k":
                    if (!diary.nextDay()) System.out.println( "Další den není.");
                    break;
                case "u":
                    diary.firstDay();
                    break;
                case "i":
                    diary.lastDay();
                    break;
                case "a":
                    LocalDate date;
                    String record;

                    System.out.println("Zadej datum (RRRR-MM-DD):");
                    try {
                        date = LocalDate.parse(scanner.nextLine().trim());
                    } catch (DateTimeParseException e) {
                        System.out.println("Špatný formát data.");
                        break;
                    }

                    System.out.println("Zadej text záznamu:");
                    record = scanner.nextLine();
                    if (record.isEmpty()) {
                        System.out.println("Záznam neobsahoval žádný text.");
                        break;
                    }

                    if (diary.getCurrent() == null || (date.isAfter(diary.getCurrent().getDate()) && (diary.getCurrent().getNext() == null || date.isBefore(diary.getCurrent().getNext().getDate())))) {
                        diary.addDay(date);
                        diary.addRecordToCurrentDay(record);
                    }

                    else if (date.isEqual(diary.getCurrent().getDate()))  {
                        diary.addRecordToCurrentDay(record);
                    }

                    else
                    {
                        System.out.println("záznam odmítnuty");
                    }
                    break;

                case "d":
                    System.out.println("Číslo záznamu ke smazání:");
                    try {
                        int number = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println("mažeš záznam : "+ diary.getCurrent().getRecords().getRecord(number - 1));
                        System.out.println("Opravdu chceš smazat záznam? [A]no  [N]e");
                        if (!scanner.nextLine().trim().toLowerCase().equals("a")) {
                            break;
                        }

                        diary.deleteRecordFromCurrentDay(number);
                        if (diary.getCurrent().getRecords().isEmpty()) {
                            diary.deleteCurrentDay();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Buď to není čislo, nebo záznam s tímto číslem neexistuje.");
                    }
                    break;
                case "q":
                    repeat = false;
                    break;
                default:
                    System.out.println( "Neznámý příkaz: " + command);
            }
        }
    }
}