package midterm2018;

public class ConvertObject {
    public String task = null;
    private int num = 0;



    public void increaseNum() {this.num++;}

    public void useQusetion(String tsk) {
       String[] split = tsk.split(":");
       for (int i = 0; i < split.length; i++) {
           if(split[i].contains("task")) {
               String[] temp = split[i+1].split(",");
               String nu = temp[0].replaceAll("“","");
               nu = nu.replaceAll("”", "");
               nu = nu.replaceAll("\\s+","");
               this.setTask(nu);
           } else if(split[i].contains("num")) {
               String[] temp = split[i+1].split("\n");
               String nu = temp[0].replaceAll("\"","");
               nu = nu.replaceAll("\\s+","");
               this.setNum(Integer.parseInt(nu));
           }
       }
       if (this.task.equals("inc")) {
           this.increaseNum();
       }
    }

    public void setTask(String tsk){this.task=tsk;}

    public void setNum(int n) {this.num=n;}

}
