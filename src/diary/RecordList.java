package diary;

public class RecordList {
    private String[] list;

    private int count;

    public RecordList() {
        list = new String[0];
        count = 0;
    }
    public void addRecord(String record) {
        String[] newList = new String[count+1];
        for (int i=0; i<count; i++) {
            newList[i] = list[i];

        }
        newList[count] = record;
        list = newList;
        count++;
    }

    public void deleteRecord(int index) {
        if (isEmpty() || index >= count || count < 0 || index < 0)
        {
            throw new IllegalArgumentException("špatný index");
        }
        String[] newList = new String[count-1];
        for (int i=0; i<count; i++) {
            if (i<index)
            {
                newList[i] = list[i];
            }
            else if (i>index)
            {
                newList[i - 1] = list[i];
            }

        }
        list=newList;
        count--;
    }

    public String getRecord(int index) {
        if (isEmpty() || index >= count || count < 0 || index < 0)
        {
            throw new IllegalArgumentException("špatný index");
        }
            return list[index];
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
