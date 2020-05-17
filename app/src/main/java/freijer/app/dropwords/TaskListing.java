package freijer.app.dropwords;

public class TaskListing {
    String task1;
    int TaskFlag;
   int TY;


    String[] Task_1 = {"Собрать 3 слова из 3 букв", "Собрать 1 слово из 5 букв"};


    public String TaskList(){
//        RandomTasks();
        switch (RandomTasks()){
            case 0:
                this.task1 = "Нет задания";
                this.TY = 0;
                break;
            case 1:
                this.task1 = "Собрать 3 слова из 3 букв";
                this.TY = 1;
                break;
            case 2:
                this.task1 = "Собрать 1 слово из 5 букв";
                this.TY = 2;
                break;
            case 3:
                this.task1 = "Собрать 1 слово из 4 букв";
                this.TY = 3;
                break;
        }
        return this.task1;
    }
    public int RandomTasks(){
        this.TaskFlag = 1 +(int) (Math.random() * 3);
        return this.TaskFlag;
    }
}
